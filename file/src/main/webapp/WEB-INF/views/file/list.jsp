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
<title>File List</title>
</head>
<body>
<table border=1>
<Tr>
<th>파일번호</th>
<TH>경로</TH>
<th>미리보기</th>
<th>파일명</th>
<th>크기</th>
<th>유형</th>
<th>날짜</th>
<th>삭제</th>
</Tr>
<c:forEach var="file" items="${fileList }">
<c:set var="len" value="${fn:length(file.fileName) }"/>
<!-- 파일 전체이름 가져오기 -->
<c:set var="fileType" value="${fn:toUpperCase(fn:substring(file.fileName, len-4, len))}" />
<!-- 파일 이름 마지막 확장자로 파일 타입 결정한다 (무식한 방식이긴 함)-->
<tr>
<td>${file.fileId }
<td>${file.directoryName } 
<td><!-- image file을 가져와야한다 (미리보기)-->

<!-- img파일 타입들일 경우엔, 100사이즈 썸네일을 띄워라. 경로는 /file/img/에서 자동 매핑 -->
<c:choose>
<c:when test="${(fileType eq '.JPG') or (fileType eq 'JPEG') or (fileType eq '.PNG') or (fileType eq '.GIF')}">
<img src="/file/img/${file.fileId}" width="100" class="img-thumbnail"><br>
</c:when>

<c:otherwise>
<img src="file/resources/images/basic.jpg" width="100" class="img-thumbnail">
</c:otherwise>
</c:choose>
</td> <!-- 칸이 닫힌다 -->
<td> <!--  "파일명" 새로운 칸 열기 -->
<a href="/file/info/${file.fileId}">${file.fileName }</a> 
</td>
<td>
<fmt:formatNumber value="${file.fileSize/1024}" pattern="#,###"/>KB
<!--  파일사이즈 1024로 나눠서 변환 -->
</td>
<td>${file.fileContentType }</td>
<TD>${file.fileUploadDate }</TD>
<td>
<a href="/file/delete/${file.fileId }" class="delete">삭제</a>
</td>
</td>
</tr>
</c:forEach>
</table>
<br>
<br>
<a href="/file/">돌아가기</a>
<script>
// confirm 창이 나오고 true면 그대로 위 /file/delete/fileID로 간다.
$(document).ready(function() {
	$(".delete").click(function() {
		if (confirm("이 작업은 되돌릴 수 없습니다. 파일을 정말 삭제하시겠습니까?")){
			return true;
		} else {
			return false;
		}
	})
})
</script>




</body>
</html>