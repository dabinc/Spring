<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
			uri="http://java.sun.com/jsp/jstl/core" %>
			
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<style type="text/css">
	* { margin: 0; }
	.wrap{ width: 1000px; margin: auto; }
	.header{ width: 1000px; }
	.title{
		font-size: 70pt;
		text-align: center;
		text-shadow: 10px 10px 15px #FFEBE5;
		margin-top: 0;
		padding-bottom: 20px;
		color : #FFEBE5;
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
    
	
</style>

</head>
<body>
	<div class="wrap">
		<div class="header">
			<a id = "none" href="/root/index"><h1 class="title">Dabin Choi</h1></a>
		</div>
	</div>
	<div class="navdiv">	
		<div class="wrap">
		<nav>
			<ul>
				<li> <a href="/root/index">Home</a> </li>
				
				
				<li> <a href="/root/member/memberList">Members</a> </li>
			
				
				<li> <a href="/root/board/list">Board</a> </li>
				
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
</div>
</body>
</html>








