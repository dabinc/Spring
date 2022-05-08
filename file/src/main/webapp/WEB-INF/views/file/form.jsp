<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 파일은 binary로 데이터가 넘어가는데, 이걸 인코딩해줘야해서 enctype지정 아래 option과 바이너라 동시에 전송-->
<form action="/file/save" method="post" enctype="multipart/form-data">
종류 : 
<select name="dir" id="dir">
<option value="/">/
<option value="/images">이미지
<option value="/data">자료
<option value="/general">공통
</select>

<input type=file name=file>
<input type=submit value=저장>
<input type=reset value=취소>
</form>
<br><br>
<a href="/file/">돌아가기</a>

</body>
</html>