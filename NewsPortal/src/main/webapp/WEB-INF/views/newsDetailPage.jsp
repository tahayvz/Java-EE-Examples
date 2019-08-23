<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<c:import url="/exitfunc"></c:import>

</head>
<body>
	<div class="container">
		<c:import url="/navbar"></c:import>
		<div class="row">
				<div class="col-sm-12">
			<c:if test="${ not empty data }">
						<br/><br/><br/>
					<h1>${data.ntitle }</h1>
					<p>${data.ntext }</p>
					<img src="${data.nurl}" class="img-fluid" alt="Responsive image" style="width:80%;height:auto;">
					<p>${data.ntexttwo }</p>
				</c:if>
		</div>
	</div>
</div>
	<c:import url="/js"></c:import>
	<c:import url="/footer"></c:import>
</body>
</html>