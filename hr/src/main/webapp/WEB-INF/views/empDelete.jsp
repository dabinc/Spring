<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>사원 삭제 페이지</title>
</head>
<body>

${emp.firstName} ${emp.lastName }님은 현재  <br><br>
${mgrCount} 명과 <br><br>
${deptCount } 부서의 매니저입니다. <br><br>
<h2>${emp.firstName} ${emp.lastName }님의 정보를 정말 삭제하시겠습니까?</h2>
<br>
<form action="/hr/emp/delete" method="post">
	<input type=hidden name=empId value="${emp.employeeId }">
	<input type=submit value=삭제> <input type=reset value=취소>
</form>


</body>
</html>