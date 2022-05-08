<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- always the same tag when using jstl in jsp files so make sure you know-->
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>



</head>

<body>
<c:import url="../default/header.jsp" />

<div align="right" class="wrap">
	<form action="/root/member/userCheck" method="post"> 
		<input type="text" name="id" placeholder="Input ID" required> <br>
		<input type="password" name="pw" placeholder="Input Password" required> <br><br>
		<input type="checkbox" name="autoLogin"> Auto Login &nbsp;&nbsp;&nbsp;
		<input type="submit" class="btn btn-outline-success" value="login"> &nbsp; 
	</form>
</div>

<c:import url="/src/main/webapp/resources/main.html" />
<c:import url="src/main/webapp/resources/main.html" />
<c:import url="src/main/webapp/resources/scss/index.html" />
<c:import url="/src/main/webapp/resources/scss/index.html" />
<c:import url="src/main/webapp/resources/scss/main.html" />
<c:import url="/src/main/webapp/resources/scss/main.html" />
	

</body>
</html>