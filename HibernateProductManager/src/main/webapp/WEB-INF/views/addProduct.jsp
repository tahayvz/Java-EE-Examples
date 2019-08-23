<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

</head>
<body>
	<div class="container">

		<c:import url="/navbar"></c:import>

		<div class="row">
			<div class="col-sm-4">
				<h1>Add User</h1>
				<form action="${pro != null ? 'userEdit' : 'userInsert' }"
					method="post">
					<input value="${pro.pname }" name="pname" type="text" class="form-control" placeholder="pname" /> 
					<br />
					<input	value="${pro.pbrand }" name="pbrand" type="text" required="required" class="form-control" placeholder="pbrand" />
					<br /> 
					<input value="${pro.pmadein }" name="pmadein" type="text" class="form-control" placeholder="pmadein" /> 
					<br />
					<input value="${pro.pprice }" name="pprice" type="number" class="form-control" placeholder="pprice" /> 
					<br /> 
					<input type="submit" value="Kaydet" class="btn btn-success" />

				</form>
		</div>
	</div>
</body>
<c:import url="/js"></c:import>
</html>