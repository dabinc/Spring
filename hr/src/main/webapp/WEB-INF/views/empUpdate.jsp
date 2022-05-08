<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 수정 페이지</title>
</head>
<body>


<h2>수정 사항 입력</h2>
<form action="/hr/emp/update"method="post">
		<input type="hidden" name=empId value="${emp.employeeId }">
	<table>
	<!-- emp VO comes in as ${emp} -->
		<tr><td>사원번호</td><td>${emp.employeeId }</td></tr>
		<tr><td>이름/성</td><td>${emp.firstName} ${emp.lastName}</td></tr>
		<tr><td>이메일</td><td><input type=text name=email></td></tr>
		<tr><td>연락처</td><td><input type=text name=phoneNumber></td></tr>
		<tr><td>입사일</td><td>${emp.hireDate }</td></tr>
		
		<tr><td>직무</td><td>
		<select name=jobId>
			<c:forEach var="job" items="${jobList }">
			<option value="${job.jobId }">${job.jobTitle }
			</option>
			</c:forEach>
		</select>
		
		<tr><td>급여</td><td><input type=text name=salary></td></tr>
		<tr><td>보너스율</td><td><input type=number min=0 max=0.99 step=0.05 name=comissionPct></td></tr>
		<tr><td>매니저</td><td>
		<select name=employeeId>
			<c:forEach var="man" items="${manList }">
			<option value="${man.employeeId}">${man.firstName }
			</option>
			</c:forEach>
		</select>
		<tr><td>부서</td><td>
		<select name=departmentId>
			<c:forEach var="dept" items="${deptList }">
			<option value="${dept.departmentId }">${dept.departmentName }
			</option>
			</c:forEach>
		</select>
		<tr><td><input type="submit" value="저장"> <input type="reset" value="취소"></td></tr>

	</table>
	
</form>







</body>
</html>