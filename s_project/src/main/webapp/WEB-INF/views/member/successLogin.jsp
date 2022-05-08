<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:import url="../default/header.jsp" />
<br>
<div align=right class="wrap"> 
 <c:if test="${loggedUser != null}">
 Welcome ${loggedUser }
 </c:if>
 
 <c:if test="${loggedUser == null}">
 You must log in to fully use the service.
 </c:if>
</div>

</body>
</html>