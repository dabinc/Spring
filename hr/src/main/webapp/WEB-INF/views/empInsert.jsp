<%@ page language="java" contentType="text/html; charset=UTF-8"	
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js">
</script>
<meta charset="UTF-8">
<title>사원 정보 ${empty emp ? "입력페이지" : "수정페이지" }</title>
</head>
<body>

<h2>사원 정보 ${empty emp ? "입력페이지" : "수정페이지" }</h2>
<form action="/hr/emp/${empty emp ? 'insert' : 'update' }" method="post">
	<table>
		<tr><td>사원번호</td><td><input type=text name=employeeId value="${emp.employeeId }" ${ empty emp ? "" : "readonly" } id="userId">
		
		<c:if test="${empty emp }">
		&nbsp; <input type="button" id=idCheck value="중복검사"></button>
		</c:if>		
		
		</td></tr>
		<tr><td>이름/성</td><td><input type=text name=firstName value="${emp.firstName }"> <input type="text" name=lastName value="${emp.lastName }"></td></tr>
		<tr><td>이메일</td><td><input type=text name=email value="${emp.email}"></td></tr>
		<tr><td>연락처</td><td><input type=text name=phoneNumber value="${emp.phoneNumber}"></td></tr>
		<tr><td>입사일</td><td><input type=text name=hireDate value="${emp.hireDate}"></td></tr>
		
		<tr><td>직무</td><td>
		<select name=jobId>
			<c:forEach var="job" items="${jobList }">
			<option value="${job.jobId } "${emp.jobId eq job.jobId ? "selected" : ""}>${job.jobTitle }
			</option>
			</c:forEach>
		</select>
		
		<tr><td>급여</td><td><input type=text name=salary value="${emp.salary }"></td></tr>
		<tr><td>보너스율</td><td><input type=number min=0 max=0.99 step=0.05 name=comissionPct value="${emp.comissionPct }"></td></tr>
		
		<tr><td>매니저</td><td><input type=text name=managerId value=102>
		<!--  <select name=managerId>
			<c:forEach var="man" items="${manList }">
			<option value="${man.employeeId}" ${emp.managerId eq man.employeeId ? "selectd" : "" }>${man.firstName }
			</option>
			</c:forEach>
		</select>
		 -->
		<tr><td>부서</td><td>
		<select name=departmentId>
			<c:forEach var="dept" items="${deptList }">
			<option value="${dept.departmentId }" ${emp.departmentId eq dept.departmentId ? "selected" : ""}>${dept.departmentName }
			</option>
			</c:forEach>
		</select>
		<tr><td><input type="submit" id="submit" value="저장"> <input type="reset" value="취소"></td></tr>
			<!-- submit하기 전에 check()를 불러라. -->
	</table>
	
</form>

<script>
	let ck = false;
	$(function() {
	$("#idCheck").on("click", function() {
		let employeeId = $("#userId").val();
		if(employeeId) {
			$.ajax({
				url		:	"/hr/emp/idCheck",
				type	:	"post",
				data	:	{empId : employeeId},
				dataType:	"text",
				success	:	function(check) {
					if(check) {
						alert("사용할 수 있는 사원번호 입니다.");
						$("#idCheck").remove();
						$("#userId").attr("readonly",true);
						ck=true;
					} else {
						alert("중복되는 사원번호 입니다. 다시 입력해 주세요.");
					}
					return false;
				},
				error	:	function(){
					alert("중복체크중 미지의 에러 발생. 관리자에게 문의하세요.");
					return false;
				}		
			})
		} else {
			alert("사원번호칸이 비었습니다. 사원번호를 입력하세요.");
			return false;	
		}
	})
	$("#submit").on("click", function() {
		if(!ck) {
			alert("사원번호 중복체크를 먼저 실행해주세요.");
			event.preventDefault();
			return false;
		} else {
			alert("신청하시겠습니까?");
			$("form").submit();
		}
	})
})
</script>
</body>
</html>