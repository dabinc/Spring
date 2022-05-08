<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
	img:hover {width:170px;height:170px;}
</style>
</head>
<body>

<c:import url="../default/header.jsp"></c:import>

<div align=center>

<table class = "table table-borderless" style="vertical-align:middle;">
	<tr>
	<th class = "h2"> File ID</th>
	<th class = "h2"> File Name</th>
	<th class = "h2"> Full Name </th>
	<th class = "h2"> Image </th>
	<th class = "h2"> download </th>
	
	</tr>
		<c:forEach var="file" items ="${fileList}">
		<c:set var ="contextPath" value="${pageContext.request.contextPath }"/>
	<tr> 
	<td class = "data1">${file.id } </td>
	<td class = "data1">${file.name } </td>
	<td class = "data1">${file.saveName } </td>
	<td class = "data1"><img src="${contextPath}/download?file=${file.saveName }" width="150px"> </td>
	<td class = "data1"><a href="${contextPath }/download?file=${file.saveName}">
   ${file.saveName} download </a> </td>

	</tr>
		</c:forEach>	
</table>
	<a href="${contextPath}/upload">업로드 이동</a>
</div>

</body>
</html>

