<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<title>File Info</title>
</head>
<body>
<c:set var="len" value="${fn:length(file.fileName)}"/>
<c:set var="fileType" value="${fn:toUpperCase(fn:substring(file.fileName, len-4, len))}" />
<c:choose>
<c:when test="${(fileType eq '.JPG') or (fileType eq 'JPEG') or (fileType eq '.PNG') or (fileType eq '.GIF')}">
<img src="/file/img/${file.fileId}" width="100" class="img-thumbnail">
</c:when>
<c:otherwise>
<img src="/file/resources/images/basic.jpg" width="100" class="img-thumbnail">
</c:otherwise>
</c:choose>
<br><br>
파일 이름 : <a href="/file/img/${file.fileId}">${file.fileName}</a><br>
파일 디렉토리 : ${file.directoryName} <br>
파일 크기 : <fmt:formatNumber value="${file.fileSize/(1024*1000)}" pattern="#,###" />MB<br>
파일 유형 : ${file.fileContentType}<br>
파일 업로드 날짜 : ${file.fileUploadDate}<br>
<a href="/file/delete/${file.fileId}" class="delete">파일 삭제</a>
<script>
$(document).ready(function() {
$(".delete").click(function() {
if(confirm("이 작업은 되돌릴 수 없습니다. 파일을 정말 삭제하시겠습니까?")){
	return true;
	} else {
		return false;
	}
})
})
</script>
</body>
</html>
