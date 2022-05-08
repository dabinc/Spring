<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 목록</title>
</head>
<body>
<h2> 전체 사원 목록 </h2>

<table>
	<tr>
	<td>사원번호</td>
	<td>이름</td>
	<td>성</td>
	<td>이메일</td>
	<td>연락처</td>
	<td>입사일</td>
	<td>직무</td>
	<td>급여</td>
	<td>보너스율</td>
	<td>매니저</td>
	<td>부서</td>
	</tr>
	
	<c:forEach var="emp" items="${empList}">
	<tr> 
	<td> <a href = "/hr/emp/info?empId=${emp.employeeId }"> ${emp.employeeId}</a> </td>
	<td> ${emp.firstName} </td>
	<td> ${emp.lastName} </td>
	<td> ${emp.email} </td>
	<td> ${emp.phoneNumber} </td>
	<td> ${emp.hireDate} </td>
	<td> ${emp.jobId} </td>
	<td> ${emp.salary} </td>
	<td> ${emp.comissionPct} </td>
	<td> ${emp.managerId} </td>
	<td> ${emp.departmentId} </td>
	</tr>
	</c:forEach>
	</table>

</body>
</html>