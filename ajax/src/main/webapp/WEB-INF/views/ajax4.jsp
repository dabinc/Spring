<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
function ajax4(){ //DTO로 주고받는 형식
	// javascript와 jsp 언어임
	let n = document.getElementById("name").value
	let a = $("#age").val();
	let p = $("#phoneNumber").val();
	console.log(n);
	console.log(a);
	
	let form = {age:a, name:n, phone:p}
	console.log(form)
	
		$.ajax({
		url			:	"result4_1",
		type		:	"post",
		data		:	JSON.stringify(form), 
			//send the made form AS JSON
		dataType	:	'json', 
			//and get as json
		contentType	:	"application/json; charset=utf-8",
		success		:	function(result){
			$("#label").text(result.name +" ," + result.age);
			console.log(result);
		}
	})
}
</script>

</head>
<body>
ajax4 example<br>
<input type="text" id="name"><br>
<input type="text" id="age"><br>
<input type="text" id="phoneNumber"><br>
<input type="button" value="click" onclick="ajax4()">
<hr>
<label id="label"></label>
</body>
</html>