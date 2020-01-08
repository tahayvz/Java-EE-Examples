
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Newsportal</title>
<c:import url="/css"></c:import>

</head>


<body>
	<div class="container">
		<c:import url="/guestnavbar"></c:import>
		<div class="row">
			<div class="col-sm-4">
				<br />
				<br />
				<br />
				<br />
				<form action='<s:url value="/login"></s:url>' method="post">
				
					<input name="amail" type="text" class="form-control"	placeholder="Username" required/> <br> 
					<input name="apassword" type="password" class="form-control" placeholder="Password" required /> <br>
						
					<input type="submit" value="Send" class="btn-success" /> 
					

				
					<div class="checkbox mb-3">
						<label> <input name="remember_me" value="on"
							type="checkbox"> Remember me
						</label>
					</div>
				</form>
				
			<a class="btn btn-primary" href="addUser" role="button">Sign Up</a>	
						
			</div>
		</div>
	</div>


	<c:import url="/js"></c:import>
	<c:import url="/footer"></c:import>
</body>
</html>