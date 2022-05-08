<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type = "text/javascript">
function readURL(input){
	   var file = input.files[0]
	   console.log(file)

	if( file != "" ){
      var reader = new FileReader()

		// reads file
      	reader.readAsDataURL(file)
     	reader.onload = function(e){
        console.log( e.target.result )
        $('#preview').attr('src', e.target.result )
      }

	}
}
</script>


</head>
<body>
	<c:import url="../default/header.jsp"/>
	<div class="wrap">
	<div style="width:500px; margin: 0 auto;">
		<br>
		<h3 align="center">Upload Form</h3>
		<form action="/root/board/upload" method="post" 
								enctype="multipart/form-data">
	<table class="table">
		<tr>
			<th>ID</th> 
			<td>
				<input type="text" style="margin: auto" name="id" value="${loggedUser}" readonly><br>
			</td>
		</tr>
		<tr>
			<th>Title</th> 
			<td>
			<input type="text" style="margin: auto" name="title" placeholder="Input Title" size="50"><br>
			</td>
		</tr>
		<tr>
			<th>Contents</th> 
			<td>
			<textarea rows="10" cols="50" name="content"></textarea></td>
		</tr>
		<tr>	
			<th>Image</th> 
			<td>
			<input type="file" style="margin: auto" name="imageFileName"
			onchange="readURL(this)">
			<img src="#" id="preview" width="100px" height="100px;">
			
			</td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="submit" class="btn btn-outline-success" value ="Upload">
				<input type="button" class="btn btn-outline-warning" value ="Back to List" onclick="location.href='/root/board/list'">
			</td>
		</tr>
	</table>
	</form>
	</div>
</div>
</body>
</html>