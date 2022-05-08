<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	function ajax3(){
		$.ajax({
			url		:	"result3",
			type	:	"GET",
			success	:	function(data){
				$("#count").text(data)
				// set count = return val
			},
			error	:	function(){
				alert('error!')	
			}
		})
	}
</script>
</head>
<body>
<h1>AJAX Result</h1>

<input type="button" onclick="ajax03()" value="click">
<label id="count"> 0 </label>

</body>
</html>