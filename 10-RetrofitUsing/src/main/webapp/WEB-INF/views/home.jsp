<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<title>Home</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

<div class="row">
			<div class="col-sm-12">
				<table class="table table-hover">
					<thead>
						<tr>
							<th scope="col">ID</th>
							<th scope="col">Name</th>
							<th scope="col">Brief</th>
							<th scope="col">Price ($)</th>
							<th scope="col">Category Name</th>
							<th scope="col">Image</th>
							</tr>
					</thead>
					<tbody>
						<c:if test="${not empty ls }">
							<c:forEach items="${ls }" var="item">
								<tr>
									<th scope="row">${item.productId}</th>
									<td>${item.productName}</td>
									<td>${item.brief}</td>
									<td>${item.price}</td>
									<c:if test="${not empty item.categories }">
										<td>${item.categories.get(0).categoryName}</td>
									</c:if>
									<c:if test="${not empty item.images }">
										<td><img src="${item.images.get(0).thumb}"
											class="img-responsive" /></td>
									</c:if>
									<td><button onclick="location.href='detail/${item.productId}';" type="button" class="btn btn-link">Detail</button></td>
									
									</tr>
							</c:forEach>
						</c:if>
					</tbody>
				</table>
			</div>
		</div>

</body>
</html>
