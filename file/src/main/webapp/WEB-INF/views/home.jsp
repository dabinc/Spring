<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>	
<html>
<head>
<!-- jquery를 다운해서 쓸수도 있는데 maven처럼 CDN-jQuery snippet
을 직접 src처리 해서 쓰는 방법이 있다. -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<title>File Home</title>
</head>
<body>
<h1>
	안녕하세요. 자료실입니다. 오늘도 좋은 하루 되세요.  
</h1>
<br><br><br>
<p><a href="/file/new">파일 업로드</a></p><br>
<p><a href="/file/list">파일 전체 목록</a></p><br><br>
<form action="/file/list/" name=form>

디렉토리 목록 : <select name="dir" id="dir">
<option value="/">/
<option value="/images">이미지
<option value="/data">자료
<option value="/general">공통
</select>
 &nbsp;<input type=submit value="조회" id="form">
</form>
<br><br>

<form action="/file/info">
파일 번호 검색 : <input type=number name=fileId> 
&nbsp;<input type=submit value ="검색">
</form>

<script>
//document는 이 페이지 그자체이고 렌더링/준비될때, function을 만들어라
//document는 body부터 #0은 h1, #1은 a tag, #2는 a tag등인데
//jQuery가 직통으로 찍어서 가져올수 있게 해줘서 #form은 첫번째 폼을 가져온다
//function에서 form태그가 눌렷을때, 새로운 function을 만들어라
//dir option으로 선택된 값 value를 dir에 붙여라
//document.form.action을 /file/list +/image 등이 들어간다
//경로가 form action에 고정되있고 param으로 넘어가는데 이렇게 보내면 컨트롤러에서 
//커스터마이징 가능
$(document).ready(function() {
	$("#form").click(function() {
		var dir = $("dir option:selected").val();
		document.form.action="/file/list/"+dir;
	})
})
</script>


</body>
</html>
