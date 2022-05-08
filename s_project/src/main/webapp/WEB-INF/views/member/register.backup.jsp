<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
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
            $("#addr").val( data.zonecode + addr )	
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

    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700" rel="stylesheet">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">
    <style>
	* { margin: 0; }
	.wrap{ width: 1000px; margin: auto; }
	.header{ width: 1000px; }
	.title{
		font-size: 70pt;
		text-align: center;
		text-shadow: 10px 10px 15px #FFEBE5;
		margin-top: 0;
		padding-bottom: 20px;
		color : #FF7042;
		font-family: Georgia;
	}
	nav{ background-color: #FFEBE5; width: 1000px;}
	.navdiv{ width: 100%; background-color: #FFEBE5; }
	
	nav ul{ list-style: none; display: flex;
				justify-content: end; }
	nav ul li{ padding: 10px; }
	nav ul li a{text-decoration: none; color: #D83E25; }
	nav ul li a:hover {
		color: orange; border-bottom:  2px solid black;
		transition: all 0.25s; padding-bottom: 3px; 
	}
	 
    #none{
		text-decoration: none;
        }
      html, body {
      display: flex;

      justify-content: center;
      height: 100%;
      }
      body, div, h1, form, input, p {
      padding: 0;
      margin: 0;
      outline: none;
      font-family: Roboto, Arial, sans-serif;
      font-size: 16px;
      color: #666;
      }
      h1 {
      padding: 10px 0;
      font-size: 32px;
      font-weight: 300;
      text-align: center;
      }
      p {
      font-size: 12px;
      }
      hr {
      color: #a9a9a9;
      opacity: 0.3;

      }
      .main-block {
      max-width: 340px;
      min-height: 460px;
      padding: 10px 0;
      margin: auto;
      border-radius: 5px;
      border: solid 1px #ccc;
      box-shadow: 1px 2px 5px rgba(0,0,0,.31);
      background: #ebebeb;
      }
      form {
      margin: 0 30px;
      }
      .account-type, .gender {
      margin: 15px 0;
      }
      input[type=radio] {
      display: none;
      }
      label#icon {
      margin: 0;
      border-radius: 5px 0 0 5px;

      }
      label.radio {
      position: relative;
      display: inline-block;
      padding-top: 4px;
      margin-right: 20px;
      text-indent: 30px;
      overflow: visible;
      cursor: pointer;
      }
      label.radio:before {
      content: "";
      position: absolute;
      top: 2px;
      left: 0;
      width: 20px;
      height: 20px;
      border-radius: 50%;
      background: #1c87c9;
      }
      label.radio:after {
      content: "";
      position: absolute;
                           
      width: 9px;
      height: 4px;
      top: 8px;
      left: 4px;
      border: 3px solid #fff;
      border-top: none;
      border-right: none;
      transform: rotate(-45deg);
      opacity: 0;
      }
      input[type=radio]:checked + label:after {
      opacity: 1;
      }
      input[type=text], input[type=password] {
      width: calc(100% - 57px);
      height: 36px;
      margin: 13px 0 0 -5px;
      padding-left: 10px;
      border-radius: 0 5px 5px 0;
      border: solid 1px #cbc9c9;
      box-shadow: 1px 2px 5px rgba(0,0,0,.09);
      background: #fff;
      }

      input[type=password] {
      margin-bottom: 15px;
      }
      #icon {
      display: inline-block;
      padding: 9.3px 15px;
      box-shadow: 1px 2px 5px rgba(0,0,0,.09);
      background: #1c87c9;
      color: #fff;
      text-align: center;
      }
      .btn-block {
      margin-top: 10px;
      text-align: center;
      }
      button {
      width: 100%;
      padding: 10px 0;
      margin: 10px auto;
      border-radius: 5px;
      border: none;
      background: #1c87c9;
      font-size: 14px;
 
     font-weight: 600;
      color: #fff;
      }
      button:hover {
      background: #26a9e0;
      }
    </style>
    
    <script src="https://apis.google.com/js/platform.js" async defer></script>
    <meta name="google-signin-scope" content="profile email">
    <meta name="google-signin-client_id" content="138044134847-6ndk3pfhe1rkt5cl5339c27r4aptfuns.apps.googleusercontent.com.apps.googleusercontent.com">
	
	<script>
	function checkDup() {

		let toCheck = $("#id").val()
		console.log(toCheck)
		$.ajax({
			url		: 	"checkDup?id=" + toCheck,
			success	:	function(data) {
				if (data > 0){
					alert('Duplicate ID')
				}
				else {
					alert('You may use this ID')
			
					
				}
			}
		})	
	}
	</script>
    
</head>
<body>
<div class="wrap">
		<div class="header">
			<a class="title" id = "none" href="/root/index">Dabin Choi</a>
		</div>

<div class="navdiv">	
	<div class="wrap">
		<nav>
			<ul>
				<li> <a href="/root/index">Home</a> </li>
				
				<c:if test="${loggedUser == null }">
				<li> <a href="/root/member/login">Members</a> </li>
				</c:if>
			
				<c:if test="${loggedUser != null }">
				<li> <a href="/root/member/memberList">Members</a> </li>
				</c:if>
				
				<li>	
				<c:if test="${loggedUser == null }">
				<a href="/root/member/login">Login</a> 
				</c:if>
				
				<c:if test="${loggedUser != null }">
				<a href="/root/member/logout">Logout</a> 
				</c:if>
				
				</li>
				
				<li> 
				<c:if test="${loggedUser == null }">
				<a href="/root/member/register">Register</a> 
				</c:if>
				</li>
			</ul>
		</nav>
	</div>



        <br><br>
	<div class="main-block">
	<h1>
	Web-Registration</h1>
 	<form id="fo1" action="/root/member/register" method="post">
        <hr>
        <div class="account-type">
          <input type="radio" value="none" id="radioOne" name="account" checked/>
          <label for="radioOne" class="radio">Personal</label>
          <input type="radio" value="none" id="radioTwo" name="account" />
          <label for="radioTwo" class="radio">Company</label>
        </div>
        <hr>
        <div>
        <label id="icon" for="id"><i class="fas fa-user"></i></label>
        <input type="text" name="id" id="id" placeholder="Input ID" required/>
		
		<button type="button" id = "btn1" class="btn btn-primary" onclick="checkDup()">
		<span id="before" class="spinner-border spinner-border-sm"></span>
  		check duplicate
		<span id="after" class="btn btn-success-sm"></span>
  		checked </button>
  		
        
        <label id="icon" for="pw"><i class="fas fa-unlock-alt"></i></label>
        <input type="password" name="pw" id="pw" placeholder="Input Password" required/>
        <label id="icon" for="addr"><i class="fas fa-envelope"></i></label>
        <input type="text" readonly name="addr" id="addr" placeholder="Search for Address" onclick="daumPost()"/> 
		</div>
        <hr>
        <div class="gender">
          <input type="radio" value="none" id="male" name="gender" checked/>
 		<label for="male" class="radio">Male</label>
          <input type="radio" value="none" id="female" name="gender" />
          <label for="female" class="radio">Female</label>
        </div>
        <hr>
        
       	<div class="g-signin2" data-onsuccess="onSignIn"></div>
        
        
        <hr>
        <div class="btn-block">
          <p>By clicking Register, you agree on our <a href="https://choid.xyz">Privacy Policy for choid</a>.</p>
          <button type="submit">Submit</button>
        </div>
      </form>
    </div>
</div>
</div>



</body>
</html>




