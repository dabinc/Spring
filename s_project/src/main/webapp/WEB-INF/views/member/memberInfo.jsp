<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberInfo</title>
<script>
function alert() {
	alert('Are you sure you want to delete this?')
}
</script>
</head>
<body>
<c:import url="../default/header.jsp"></c:import>

<div class="wrap">

	<div style="margin: 0 auto;">
	<br><br>
	<h3 align="center"> Member Details </h3> <br>
	<table class="table table-striped">
		<tr>
			<th style="vertical-align: middle" align="center">ID</th> <td style="vertical-align: middle">${memberInfo.id }</td>
		</tr>
		<tr>
			<th style="vertical-align: middle" align="center">Password</th> <td>******</td>
		</tr>
		<tr>
			<th style="vertical-align: middle" align="center">Address (Zip/Street Address/#APT)</th> <td>${memberInfo.addr}</td> 
		</tr>
			
		<c:if test="${memberInfo.id == loggedUser or loggedUser == 'admin'}">
			<tr>
				<td colspan="2" align="right">
				<button type="button" class="btn btn-warning" onclick="location.href='modify_form?id=${memberInfo.id}'">Modify</button>
				&nbsp; &nbsp;
				<button type="button" class="btn btn-danger" onclick="location.href='delete?id=${memberInfo.id}'">Delete</button>
				</td>				
			</tr>	
		</c:if>
		
			
	</table>
	</div>
</div>



</body>
</html>