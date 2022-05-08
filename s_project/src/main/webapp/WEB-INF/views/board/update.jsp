<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type = "text/javascript">
function readURL(input) {
	   var file = input.files[0]
	   console.log(file)

	if( file != "" ){
      var reader = new FileReader()

		// reads file
      	reader.readAsDataURL(file)
     	reader.onload = function(e) {
        console.log( e.target.result )
        $('#preview').attr('src', e.target.result)
      								}
	}
}

</script>

</head>
<body>
<c:import url="../default/header.jsp"></c:import>

<div class="wrap">

	<div style="margin: 0 auto;">
	<br><br>
	<h3 align="center"> Update Content </h3> <br>
	<form action="/root/board/update" method="post" enctype="multipart/form-data">
		 <input type="hidden" name="originalFileName" value= "${dto.imageFileName }">

		
	<table class="table table-striped">
		<tr>
			<th>#</th> 
			<td> 
		 	<input type="hidden" name="writeNo" value= "${dto.writeNo }">
		 	${dto.writeNo}
		 	</td>
		</tr>
		
		<tr>
			<th>Uploader</th> <td> <input type="text" name="id" value="${dto.id }" readonly> </td>
		</tr>
		
		<tr>
			<th>Title</th> <td> <input type="text" name="title" value="${dto.title }"> </td>
		</tr>
		<tr>
			<th>Content</th> 
			<td>			
			<textarea rows="10" cols="50" name="content">${dto.content }</textarea>
			</td>
		</tr>
		
		<tr>	
			<th>Image</th> 
			<td>
			<input type="file" style="margin: auto" name="imageFileName"
			onchange="readURL(this)">
			
			<c:if test="${dto.imageFileName == 'none'}">
			<img src="#" id="preview" width="100px" height="100px;">
			</c:if>
			
			<c:if test="${dto.imageFileName != 'none'}">
			<img id="preview" src="/root/board/download?file=${dto.imageFileName }" width="100px" height="100px">
			</c:if>
			</td>
		</tr>
		
		<tr>
			<td colspan="2" align="right">
				<input type="submit" class="btn btn-outline-success" value ="Update">
				<input type="button" class="btn btn-outline-danger" value ="Delete" onclick="location.href='/root/board/bdelete?writeNo=' + ${dto.writeNo}">
				<input type="button" class="btn btn-outline-warning" value ="Back to List" onclick="location.href='/root/board/list'">
			</td>
		</tr>
		
		
		
	</table>
	<hr>
	</form>
	&nbsp;	
	</div>
</div>



</body>
</html>