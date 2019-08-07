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

	<c:import url="/exitfunc"></c:import>

</head>
<body>
	<div class="container">

		<c:import url="/navbar"></c:import>




		<div class="row">

			<div class="col-sm-12">

				<table class="table table-hover">
					<thead>
						<tr>
							<th scope="col">ID</th>
							<th scope="col">E-mail</th>
							<th scope="col">Password</th>
							<th scope="col">Name</th>
							<th scope="col">Surname</th>
							<th scope="col">Phone</th>
							<th scope="col">Category</th>
							<th scope="col">Note</th>

						</tr>
					</thead>
					<tbody>

						<c:if test="${not empty tableData }">
							<c:forEach items="${tableData }" var="item">
								<tr>
									<th>${item.crid }</th>
									<th>${item.cmail }</th>
									<th>${item.cpassword }</th>
									<td>${item.cname }</td>
									<td>${item.csurname }</td>
									<td>${item.cphone }</td>
									<td>${item.ctitle }</td>
									<td><textarea readonly style="resize: none; border: none">${item.cnote } </textarea></td>

								</tr>
							</c:forEach>
						</c:if>


					</tbody>
				</table>
			</div>
		</div>

	</div>


	</div>
</body>
<c:import url="/js"></c:import>

</html>