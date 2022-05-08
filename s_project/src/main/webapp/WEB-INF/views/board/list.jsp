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
	<h3 align="center"> Board List </h3>
	<div align="center" class="wrap"> 
	<br>
	
	<div class ="wrap">
	<table class="table table-striped">
		<tr>
			<th style="vertical-align: middle" align="center"># </th>
			<th style="vertical-align: middle" align="center">ID</th> 
			<th style="vertical-align: middle" align="center">Title</th> 
			<th style="vertical-align: middle" align="center">Upload Date</th>
			<th style="vertical-align: middle" align="center">Views</th>
			<th style="vertical-align: middle" align="center">Image Name</th>
			<th style="vertical-align: middle" align="center">Thumbnail</th>
		</tr>
		<c:if test="${boardList.size() == 0}">
			<tr><th colspan="6"> 등록된 글이 없습니다. </th></tr>
		</c:if>
		
	<c:forEach var="dto" items="${boardList }">
		<tr>
			<td style="vertical-align: middle"> ${dto.writeNo } </td>
			<td style="vertical-align: middle"> ${dto.id }</td>
			<td style="vertical-align: middle"> <a href="view?writeNo=${dto.writeNo }"> ${dto.title }</a></td>
			<td style="vertical-align: middle"> ${dto.saveDate }</td>
			<td style="vertical-align: middle"> ${dto.hit }</td>
			<td style="vertical-align: middle"> ${dto.imageFileName }</td>
			<td style="vertical-align: middle"> thumbnail</td>
		</tr>
	</c:forEach>
	<tr>
	<td colspan="7" align="right">
	<button type="button" class="btn btn-outline-success" onclick="location.href='upload'">Upload</button>
	</td>
	</tr>
	</table>
	<hr>
	<div style="text-align: right;">
		<div align="left">
			<c:forEach var ="num" begin="1" end="${repeat }">
				<a href="/root/board/list?page=${num}">
					[${num }]
				</a>
			</c:forEach>
		</div>
		
			</div>
	</div>
	</div>
</body>
</html>