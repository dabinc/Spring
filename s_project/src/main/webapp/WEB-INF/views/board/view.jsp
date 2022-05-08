<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<script type="text/javascript">
function showReplyForm(){
	$("first").slideDown("slow");
	$("modal_wrap").show();
}
	
function hideReplyForm(){
	$("first").hide();
	$("modal_wrap").hide();
}
function replyFunc(){
	let form={}; let arr = $("#Form1").serializeArray();
	for (i=0; i <arr.length; i++){
		form[arr[i].name] = arr[i].value
	}
	console.log(form)
	
	$.ajax({
		url : "addReply", type : "post",
		data : JSON.stringify(form),
		contentType : "application/json; charset=utf=8",
		success: function() {
			alert('reply successful');
			hideReplyForm();
		}
		
	})
}

function showReply() {
	$.ajax({
		url : "showReply/" + ${dto.writeNo}, 
		type : "get",
		dataType:"json",
		success	: function(data) {
			let html=""
			data.forEach(function(d){
				let dBefore = new Date(d.write_date)
				let dAfter = dBefore.getFullYear() + "/ " +
				dBefore.getMonth()+1 + "/" +
				dBefore.getDate() + "  " +
				dBefore.getHours() + ":" +
				dBefore.getMinutes() + ":" +
				dBefore.getSeconds() + ":" +
				
				html += "<div align='left'><b>ID : </b> + d.id/"
				html += "<b>Date : </b>" + dAfter + "<br>"
				html += "<b>Title: </b>" + d.title + "<br>"
				html += "<b>Content: </b>" + d.content+ "<hr></div>"
			})
			
			$("#reply").html(html)
				
		}
	})
}
</script>

<style type="text/css">
#modal_wrap {
	display: none;
	position: fixed; z-index: 9; margin: 0 auto;
	top:30px; left:0; right:0; width:350px; height:450px;
	background-color: rgba(255, 255, 228, 0.5);
}
#first {
	display: none;
	position: fixed; z-index: 11; margin: 0 auto;
	top:30px; left:0; right:0; width:350px%; height:450px;
	background-color: rgba(255, 255, 228, 0.7);
	background-image: url("paper.gif");
 	background-color: #cccccc;
}
</style>
</head>
<body onload="showReply()">
	<c:import url="../default/header.jsp"></c:import> <br>
	<br>
	
	<h3 align="center"> Details </h3>
	
	<div align="center" class="wrap"> 
	<br>
	<table class="table table-striped">
		<tr>
			<th style="vertical-align: middle" align="center">Uploader</th> <td style="vertical-align: middle">${dto.id }</td>
		</tr>
		
		<tr>
			<th style="vertical-align: middle" align="center">Title</th> <td style="vertical-align: middle">${dto.title }</td>
		</tr>
		<tr>
			<th style="vertical-align: middle" align="center">Upload Time</th> <td style="vertical-align: middle">${dto.saveDate }</td>
		</tr>
		<tr>
			<th style="vertical-align: middle", align="center">Content</th> <td>${dto.content}</td>
		</tr>
		<tr>
			<th style="vertical-align: middle" align="center">File Name</th> <td>${dto.imageFileName}</td> 
		</tr>
		
		<c:if test="${dto.imageFileName != 'none'}">
		<tr>
			<th style="vertical-align: middle" align="center">Image</th> 
			<td>
			<a href="c:/spring/image_repo/${dto.imageFileName}"><img src="/root/board/download?file=${dto.imageFileName }" width="100px" height="100px">
			</a>
			</td> 
		</tr>	
		</c:if>
		
		<c:if test="${dto.id == loggedUser or loggedUser == 'admin'}">
			<tr>
				<td colspan="3" align="right">
				<button type="button" class="btn btn-outline-warning" onclick="location.href='update?writeNo=${dto.writeNo}'">Modify</button>
				&nbsp; &nbsp;
				<button type="button" class="btn btn-outline-dark" onclick="location.href='delete?writeNo=${dto.writeNo}'">Delete</button>
				<button type="button" class="btn btn-outline-info"" onclick="showReplyForm()">Reply</button>
				</td>				
			</tr>	
		</c:if>
		
		<c:if test="${dto.id != loggedUser}">
			<tr>
				<td colspan="2" align="right">
				<button type="button" class="btn btn-outline-info" onclick="showReplyForm()">Reply</button>
				&nbsp; &nbsp;
				</td>				
			</tr>	
		</c:if>
		<tr> <td colspan ="4">
			<div id="reply"></div>
		</table>
	</div>	
	
	<div id="modal_wrap">
		<div id="first">
			<div style="width:250px; margin:0 auto; padding-top:20px;">
				<form id="Form1">
					<input type="hidden" name="write_No" value="${dto.writeNo }">
					<b> Reply to ${ dto.title} </b> <hr>
					<b> Writer : ${loggedUser }</b> <hr>
					<b> Title   </b> <br>
					<input type="text" size="30" name="title"><hr>
					<b> Content </b> <br>
					<textarea name="content" rows="5" cols="30"></textarea>
					<hr>
					<button type="button" onclick="replyFunc()"> reply </button>
					<button type="button" onclick="hideReplyForm()"> cancel </button>
					
				</form>
			</div>
		</div>
	</div>
	
	
	
	
	
	
	
	
</body>
</html>