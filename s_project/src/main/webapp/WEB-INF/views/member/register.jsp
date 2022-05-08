<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
function daumPost(){
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
            console.log(data.zonecode)
            console.log(data.roadAddressEnglish)
            console.log(data.userSelectedType)
            console.log(data.jibunAddressEnglish)
            var addr="";
            if(data.userSelectedType == 'R') {
            	addr = data.roadAddressEnglish
            } else {
            	addr = data.jibunAddressEnglish
            }
            $("#addr1").val( data.zonecode )
            $("#addr2").val( addr )
            $("#addr3").focus()
        }
    }).open();
}
function register(){
    addr1 = $("#addr1").val()
    addr2 = $("#addr2").val()
    addr3 = $("#addr3").val()
    console.log( addr1 +"/"+ addr2 + "/" + addr3 )
    addr1 = addr1 +"/"+ addr2 + "/" + addr3
    
    $("#addr1").val( addr1 )
    fo.submit()
}
</script>


</head>
<body>
	<c:import url="../default/header.jsp" />
	<div class="wrap">
		<div style="margin: auto;">
		<h3 align="center"> Registration Page </h3>

		
		<br><br>
		<form id="fo" action="/root/member/register" method="post">
		
			<table class="table table-striped">
				<tr>
					<th style=margin:auto><h4 align=center>ID</h4></th>
					<td>
					<input type="text" name="id" style="height:40px"> &nbsp;
						<button type="button" class="btn btn-outline-danger btn-sm" onclick="">Check Duplicate</button>
					</td>
				</tr>
				
				<tr>
					<th style=margin:auto><h4 align=center>Password</h4></th>
					<td>
						<input type="password" name="pw" style="height:40px">
					</td>
				</tr>
				
				<tr>
					<th style=margin:auto><h4 align=center>Address</h4></th>
					<td>
						<input type="text" id="addr1" placeholder="우편번호" readonly name="addr">
						<input type="button" class="btn btn-info" value="우편번호 찾기" onclick="daumPost()">
						<br>
						<input type="text" id="addr2" placeholder="주 소" readonly>
						<input type="text" id="addr3" placeholder="상세주소">
					</td>
				</tr>
				<!-- 또는 name=addr로 3개를 묶으면 자동으로 parsing되서 버튼/script 안써도 된다@-->
				<tr>
					<td colspan="2">
					<input type="button" onclick="register()" class="btn btn-outline-success" value="register"> &nbsp;					
					</td>
				</tr>			
			</table>
		</form>			
		</div>
	</div>

</body>
</html>