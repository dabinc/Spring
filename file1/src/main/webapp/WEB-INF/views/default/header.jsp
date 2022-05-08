<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
			uri="http://java.sun.com/jsp/jstl/core" %>
			
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<style type="text/css">
	* { margin: 0; }
	.wrap{ width: 1000px; margin: auto; }
	.header{ width: 1000px; }
	.title{
		font-size: 70pt;
		text-align: center;
		text-shadow: 10px 10px 15px #D4F0F0;
		margin-top: 0;
		padding-bottom: 20px;
		color : #CCE2CB	;
		font-family: Georgia;
	}
	.data1 {
		font-size: 15pt;
		text-align: center;
		margin-top: 0;
		padding-bottom: 20px;
		color : #008080	;
		font-family: Georgia;
	}
	.h2{
		font-size: 30pt;
		text-align: center;
		margin-top: 0;
		padding-bottom: 20px;
		color : #CCE2CB		;
		font-family: Georgia;
	}
	
	
	}
	nav{ background-color: #CCE2CB; width: 1000px;}
	.navdiv{ width: 100%; background-color: #CCE2CB; }
	
	nav ul{ list-style: none; display: flex;
				justify-content: end; }
	nav ul li{ padding: 10px; }
	nav ul li a{text-decoration: none; color: #B6CFB6; }
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
			<a id = "none" href="/file"><h1 class="title">File Service</h1></a>
		</div>
	</div>
	<div class="navdiv">	
		<div class="wrap">
		<nav>
			<ul>
				<li  class="data1"> <a href="/file">Home</a> </li>
				<li class="data1"> <a href="/file/upload">Upload</a> </li>
				<li class="data1"> <a href="/file/list">FileList</a> </li>
			</ul>
		</nav>
		</div>
</div>
</body>
</html>








