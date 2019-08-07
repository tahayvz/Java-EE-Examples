<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

	<c:import url="/exitfunc"></c:import>


</head>
<body>
	<div class="container">

<c:import url="/navbar"></c:import>


<c:if test="${not empty ls }">
		<table class="table table-hover">
			<thead>
				<tr>
					<th scope="col">crid</th>
					<th scope="col">cname</th>
					<th scope="col">csurname</th>
					<th scope="col">cphone</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${ls }" var="item">
				<tr>
					<th scope="row">${ item.crid}</th>
					<td>${item.cname }</td>
					<td>${item.csurname }</td>
					<td>${item.cphone }</td>
				</tr>		
				</c:forEach>
			</tbody>
		</table>
		</c:if>
	</div>
	
</body>
<c:import url="/js"></c:import>
</html>
