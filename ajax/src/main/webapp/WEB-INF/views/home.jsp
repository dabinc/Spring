<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<meta charset="UTF-8">
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<a href="none_ajax1.jsp">ajax1-사용안할때</a>
<a href="ajax2.jsp">ajax2-기본문법</a>
<a href="ajax3_result.jsp">ajax3-데이터반환예시</a>
<a href="ajax4.jsp">ajax4-JSON객체 반환</a>
<a href="ajax5.jsp">ajax5-restController</a>
<a href="ajax6_restController.jsp">ajax6-rest예시</a>
</body>
</html>
