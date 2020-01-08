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
<c:import url="/exitfunc"></c:import>

</head>
<body>
	<div class="container">
		<c:import url="/navbar"></c:import>

		<div class="row">
			<div class="col-sm-8">
				<h1>User List</h1>
				<table class="table table-hover">
					<tbody>
						<c:if test="${ not empty data }">
							<c:forEach items="${ data }" var="item">
								<tr>

									<td>
										<div class="card" style="width: 18rem;">
											<img class="card-img-top" src="${item.nurl}" alt="New 1">
											<div class="card-body">
												<h5 class="card-title">${item.ntitle}</h5>
												<p class="card-text">${item.ntext}</p>
											</div>
										</div>
									</td>
									<td><a href='<s:url value="/delete/${item.nid}"></s:url>'
										class="btn btn-danger">Delete</a></td>
								</tr>
							</c:forEach>
						</c:if>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<c:import url="/js"></c:import>
	<c:import url="/footer"></c:import>
</body>
</html>