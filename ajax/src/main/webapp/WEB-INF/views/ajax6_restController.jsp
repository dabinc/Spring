<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<script>
function getUsers() {
	$.ajax({
		url		:	"users",
		type	:	"get",
		dataType:	"json",
		success	:	function(list) {
			console.log(list)
			// $("#users").text(list[0].name + list[0].age)
			// $("#users").text("<b>"+ list[0].name + "</b>" + list[0].age)
			// $("#users").html("<b>"+ list[0].name + "</b>" + list[0].age)
			// $("#users").append("<b>"+ list[0].name + "</b>" + list[0].age + "<hr>")
			let html = ""
			for(i=0; i<list.length;i++) {
				html = html + "<b>이름 : " + list[i].name + "님 </b> <br>"
				html = html + "<b>나이 : " + list[i].age  + "살 </b> <br>"
			}
			$("#users").html(html);
		}
	})
}
function getUser() {
	let n = $("#name").val()	// id로 가져온다 
	$.ajax({
//데이터가 노출되서 과거엔 이랬음	url		:	"user1?name=" +n,
//요즘엔 경로처럼 사용함 
		url		:	"user2/"+n,
		type	:	"get",
		dataType:	"json",
		success	:	function(data){
			html = "";
			html += "<b>이름 : " + data.name + "님 </b> <br>"
			html += "<b>나이 : " + data.age  + "살 </b> <br>"
			$("#users").html(html)
		}
	})
}
function modify() {
	let n = $("#newName").val() // id로 가져온다 
	let a = $("#newAge").val()  // id로 가져온다 
	form = {name:n, age:a}
	$.ajax({
		url		:	"modify",
		type	:	"put",
		data	:	JSON.stringify(form),
		contentType	: "application/json;charset=utf-8",
		success :	function() {
			alert('수정성공')
			$()
		}
	})
}
function register() {
	// 폼에 대한 input list를 name으로 가져와서 배열로 다 받아오는 똑똑한 방식
	// 폼 안에 20개가 넘는게 인풋이 잇을 수 있으니깐~
	let form = {}
	let arr = $("#fm").serializeArray()
	console.log(arr)
	for(i=0; i<arr.length; i++) {
		form[arr[i].name] = arr[i].value
		console.log(form)
	}
}

</script>

</head>
<body>
	<h1 align=center><a href="">ajax6 test page</a></h1>
	<hr>
	<div align=center>
	<span id="users"></span>
	<hr>	
	<input type="button" onclick="getUsers()" value="사용자 목록 조회"> <br><hr>
	<input type="text" placeholder="Input Name" id="name">
	<input type="button" onclick="getUser()" value="특정 사용자 조회"><br> <hr>
	
	
	<input type="text" placeholder="Target Name" id="newName">
	<input type="text" placeholder="Target age" id="newAge">
	<input type="button" onclick="modify()" value="정보변경"><br><hr>
	
	<hr>
	<form id ="fm"> <!-- name 사용하면 seriallize할수있다. -->
		<input type="text" name="id" required>
		<input type="text" name="name "required>
		<input type="text" name="age" required>
		<input type="text" name="addr" required>
		<input type="button" onclick="register()" value="가입">
	</form>
	
	</div>
</body>
</html>