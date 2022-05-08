<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>태그 셀렉트 예제</title>
</head>
<body>

<table>
<tr><td> 선택해야 하는 값</td></tr>
</table>

<script>
//f12누르면 개발자 - console 들어가서 확인가능
console.log(document.childNodes.length);
for(var i=0; i<document.childNodes.length; i++){
	console.log(document.childNodes[i])
}
// 이런식으로 매핑해줘야 하는데 중간 textNode도 껴있고 귀찮다. 그래서 jquery랑 selectbyId로 한다.
let text = document.childNodes[1].childNodes[2].childNodes[1].childNodes[1].childNodes[0].childNodes[0];
console.log(text);

</script>


</body>
</html>