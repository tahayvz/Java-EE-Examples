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
	<c:import url="/exitfunc"></c:import>

</head>
<body>
	<div class="container">
	<c:import url="/navbar"></c:import>
	
		<div class="row">
			<div class="col-sm-4"><br/><br/><br/>
				<h1>Add News</h1>
				<form action="${us != null ? 'userEdit' : 'newinsert' }" method="post">
					<input value="${us.nurl }" name="nurl" type="text" class="form-control"
						placeholder="url" /> <br />
					<input value="${us.ntitle }" name="ntitle" type="text" required="required"
						class="form-control" placeholder="title" /> <br />
					<input value="${us.ntext }" name="ntext" type="text" class="form-control"
						placeholder="title text" /> <br />
					<input value="${us.ntexttwo }" name="ntexttwo" type="text" class="form-control"
						placeholder="text" /> <br />	
					
					<input type="submit" value="Kaydet" class="btn btn-success" />
					
				</form>
			</div>
	
		</div>



	</div>
	<c:import url="/js"></c:import>
<c:import url="/footer"></c:import>
</body>


</html>