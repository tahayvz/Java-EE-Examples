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
	
			<div class="col-sm-8">
				<h1>User List</h1>
				<table class="table table-hover">
					<thead>
						<tr>
							<th scope="col">ID</th>
							<th scope="col">Name</th>
							<th scope="col">Brand</th>
							<th scope="col">Made In</th>
							<th scope="col">Price</th>
							<th scope="col">Delete</th>
							<th scope="col">Edit</th>

						</tr>
					</thead>
					<tbody>

						<c:if test="${ not empty data }">
							<c:forEach items="${ data }" var="item">
								<tr>
									<th scope="row">${item.pid}</th>
									<td>${item.pname}</td>
									<td>${item.pbrand}</td>
									<td>${item.pmadein}</td>
									<td>${item.pprice}</td>
								
								</tr>
							</c:forEach>
						</c:if>

					</tbody>
				</table>

			</div>
		</div>
	</div>
</body>
<c:import url="/js"></c:import>
</html>