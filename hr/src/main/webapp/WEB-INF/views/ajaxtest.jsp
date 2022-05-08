<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js">
</script>
<meta charset="UTF-8">
<title> ajax Test</title>


</head>
<body>

<span id=ajaxarea>ajax 값</span>
<br>
<button id=ajax> ajax 실행</button>
<script>
$("#ajax").click("on", function() {
	$.ajax({
		url:		"/hr/emp/ajaxtest",
		type:		"post",
		data:		{id : "choid"},
		//파라미터 묵어주기: 알아서 매핑을 해주는데 여러개 넣을수도 있고 지금은 id에 choid를 넣어라
		dataType:	"text",
		success:	function(result) {
						$("#ajaxarea").text(result);
		}, //성공시에 ajaxarea에 text를 넣어라
		error:		function(exception) {
						console.log(exception.statusText);
		}
	})	
})
</script>
	<!--  ### ajax using javascript
	<script>
	$("#ajax").click("on", function() {
	var xhr = new XMLHttpRequest();
	var setArea = function(word) {
		document.getElementById("ajaxarea").innerText = word;
	}
	var params = "id=gctserf"
	xhr.open('post', '/hr/emp/ajaxtest');
	xhr.setRequestHeader("content-type", "application/x-www-form-urlencoded");
	xhr.send(params);
	xhr.onlyreadystatechange = function() {
		if(xhr.readyState === xhr.DONE) {
			if(xhr.status === 200 || xhr.status === 201) {
				setArea(xhr.responseText);
			}
		}	
	};
});
	</scrip -->
</body>
</html>