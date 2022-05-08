<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<script>
	function getFunc() {
		$.ajax({
			url		:	"rest",
			type	:	"get",
			dataType:	"text",
			success	:	function(data) {
				$('#label').text(data)
			}
		})
	}

	function postFunc() {
		$.ajax({
			url		:	"rest",
			type	:	"post",
			dataType:	"text",
			success	:	function(data) {
				$('#label').text(data)
			}
		})
	}
	
	function putFunc() {
		$.ajax({
			url		:	"rest",
			type	:	"put",
			dataType:	"text",
			success	:	function(data) {
				$('#label').text(data)
			}
		})
	}
	
	function deleteFunc() {
		$.ajax({
			url		:	"rest",
			type	:	"delete",
			dataType:	"text",
			success	:	function(data) {
				$('#label').text(data)
			}
		})
	}
	
</script>



</head>
<body>
<h1 align=center>ajax5 test page</h1>
	<hr>
	<div align=center>
	<label id="label"></label>
	<hr>	
	<input type="button" onclick="getFunc()" value="get">
	<input type="button" onclick="postFunc()" value="post">
	<input type="button" onclick="putFunc()" value="put">
	<input type="button" onclick="deleteFunc()" value="delete">
	</div>
</body>
</html>