<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" >
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<div class="container" >

<c:import url="/navbar"></c:import>


<h1>Login Page</h1>
<div class="row">
<div class="col-sm-4">
<form action="login" method="post">
			<input name="mail" type="email" class="form-control" placeholder="E-mail"/>
			<br>
			<input name="password" type="password" class="form-control" placeholder="Password" />
			<br>
			<input type="submit" value="Send" class="btn-success" />
			
			</form> 
		</div>
	
		</div>
</body>
<c:import url="/js"></c:import>
</html>