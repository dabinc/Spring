<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>평균 점수 계산기</title>
</head>
<body>

<script>
function score(subjects){
	var sum = 0;
	for (var i=0; i < subjects.length; i++) {
		sum += Number(prompt(subjects[i]+" 점수를 입력하세요."));
		// 프롬프트를 띄워서 입력받은 값을 number 형태로 바꿔주고 더한다.
		// 언어, 수학, 영어, 사회 = 4개의 프롬프트를 띄워 더한다.
		}
	var avg = sum/subjects.length;
	return avg
	}
//자바스크립트는 함수처리가 자유롭다
//score function 생성시에 subjects 선언시에 매개변수 안적어도
//밑에 result=score(subjects)를 불르면 자동으로 박아준다
//subjects의 타입을 따로 안넣어줘도 되서 편리하다.
var subjects = ['언어', '수학', '영어', '사회'];
var result = score(subjects);
document.write("평균 점수는 "+result+" 점 입니다.");

</script>
</body>
</html>