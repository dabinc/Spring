<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberList</title>

<style type="text/css">

</style>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">

</head>
<body>
	<c:import url="../default/header.jsp"></c:import> <br>
	<br>
	<h3 align="center"> Member List </h3>
	<div align="center" class="wrap"> 
	<br>
	<table class="table table-striped">
		<tr>
			<th style="vertical-align: middle" align="center"># <th style="vertical-align: middle" align="center">ID</th> <th style="vertical-align: middle" align="center">Password</th> <th style="vertical-align: middle" align="center">Address<hr style="vertical-align: middle" align="center">zip/street address/#apt</th> <th style="vertical-align: middle" align="center">Register Date</th>
		</tr>
	<c:forEach var="member" items="${memberList }">
		
		<tr>
			<td style="vertical-align: middle"> ${member.number } </td>
			<td style="vertical-align: middle" >
			<a href="memberInfo?id=${member.id }"> ${member.id } </a>
			</td>
			<td style="vertical-align: middle">${member.pw }</td>
			<td style="vertical-align: middle">${member.addr }</td>
			<td>${member.regDate }</td>
		</tr>
	</c:forEach>
	</table>
	</div>
</body>
</html>