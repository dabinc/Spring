<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	인사 시스템에 오신것을 환영합니다.  <br>
</h1>	
<!-- 현재 위치가 8080/hr/이기때문에 상대경로로 작성 -->
	1. <a href = "emp/count"> <button> 사원 수 확인 </button></a> <br>
	2. <a href = "emp/list"> <button> 사원 목록 확인 </button></a> <br>
	3. <a href = "emp/insert"> <button> 사원 정보 입력</button></a> <br>
	3. <a href = "emp/ajaxtest"> <button> ajax test</button></a> <br>

<P>  현재시각은  ${serverTime}입니다. </P>
</body>
</html>
