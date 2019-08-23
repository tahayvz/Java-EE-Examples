<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/css"></c:import>


</head>
<body>
	<div class="container">
	
	
		<div class="row">
			<div class="col-sm-4"><br/><br/><br/>
				<h1>Add User</h1>
			
				<form action='<s:url value="/userinsert"></s:url>' method="post">
					<input value="${au.amail }" name="amail" type="text" class="form-control"
						placeholder="mail" /> <br />
					<input value="${au.apassword }" name="apassword" type="text" required="required"
						class="form-control" placeholder="password" /> <br />
	
					<input type="submit" value="Kaydet" class="btn btn-success" />
					
				</form>
			</div>
		</div>
	</div>
	<c:import url="/js"></c:import>
<c:import url="/footer"></c:import>
</body>


</html>