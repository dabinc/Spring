<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<script>
var elNode = document.createElement('h3');
var textNode = document.createTextNode('텍스트 노드');
elNode.appendChild(textNode);
document.body.appendChild(elNode);
</script>

</body>
</html>