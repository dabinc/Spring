<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

</head>
<body>
<c:import url="../default/header.jsp"></c:import>

<div class="wrap">

	<div style="margin: 0 auto;">
	<br><br>
	<h3 align="center"> Member Details </h3> <br>
	<form action="/root/member/register" method="post">
	<table class="table table-striped">
		<tr>
			<th>ID</th> <td> ${memberInfo.pw }</td>
		</tr>
		<tr>
			<th>Password</th> <td> <input type="hidden" name="pw"> </td>
		</tr>
		<tr>
			<th>Address <hr>zip/street address/#apt</th> <td> <input type="text" name="addr"> ${memberInfo.addr}</td> 
		</tr>
	</table>
	<hr>
	<button style="center" type="button" class="btn btn-outline-danger btn-sm" onclick="alert()">Delete</button>
	</form>
	&nbsp;	
	<button style="center"  type="button" class="btn btn-outline-warning  btn-sm" onclick="/root/member/update">update</button>
	</div>
</div>



</body>
</html>