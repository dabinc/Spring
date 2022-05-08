<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var = "contextPath" value = "${pageContext.request.contextPath }" />
    
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	.main-block {
      max-width: 340px;
      min-height: 400px;
      padding: 10px 0;
      margin: auto;
      border-radius: 5px;
      border: solid 2px #ccc;
      box-shadow: 1px 2px 5px rgba(0,0,0,.31);
      background: EOF8F5;
      align-items: center;
      align-content: flex-end;
      }
      </style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:import url="../default/header.jsp"></c:import>
<br><br>
<div class="main-block">
<h2 class = "h2">Upload Form</h2>
<form action="${contextPath}/upload" method="post" 
								enctype="multipart/form-data"> 
	<input type="text" style="margin: auto" name="id" placeholder="ID"><br>
	<input type="text" style="margin: auto" name="name" placeholder="input Name"><br>
	<input type="file" style="margin: auto" name="file"><br>
	<input type="submit" style="margin: auto" value="upload"><br>
</form>   
</div>

</body>
</html>