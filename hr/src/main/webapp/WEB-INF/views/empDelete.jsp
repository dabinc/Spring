<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��� ���� ������</title>
</head>
<body>

${emp.firstName} ${emp.lastName }���� ����  <br><br>
${mgrCount} ��� <br><br>
${deptCount } �μ��� �Ŵ����Դϴ�. <br><br>
<h2>${emp.firstName} ${emp.lastName }���� ������ ���� �����Ͻðڽ��ϱ�?</h2>
<br>
<form action="/hr/emp/delete" method="post">
	<input type=hidden name=empId value="${emp.employeeId }">
	<input type=submit value=����> <input type=reset value=���>
</form>


</body>
</html>