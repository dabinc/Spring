<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	function ajax02() {
		// JQuery 문법은 $. 으로 시작한다.
		// 기본 코드는 $.ajax({}) 중괄호 안에 작성한다.
		$.ajax({
			url		: "ajax2", 
			type 	: "get",
			success : function(){
				console.log('연결 성공')
			},
			error 	: function(){
				alert('문제 발생')
			}
		})
	}
</script>
</head>
<body>
AJAX.jsp
<h1> 1 </h1> <h1> 1 </h1> <h1> 1 </h1>
<h1> 1 </h1> <h1> 1 </h1> <h1> 1 </h1>
<h1> 1 </h1> <h1> 1 </h1> <h1> 1 </h1>
<h1> 1 </h1> <h1> 1 </h1> <h1> 1 </h1>
<h1> 1 </h1> <h1> 1 </h1> <h1> 1 </h1>
<h1> 1 </h1> <h1> 1 </h1> <h1> 1 </h1>
<h1> 1 </h1> <h1> 1 </h1> <h1> 1 </h1>

<button type="button" onclick="ajax02()">
	click
</button>


</body>
</html>