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

			<table class="table">

				<tbody>
					<c:if test="${ not empty data }">
						<c:forEach items="${ data }" var="item">

							<div class="col-sm-3" style=" min-width: 12rem;">
								<br /> <br /> <br />
								<div class="card" style="max-width: 15rem; height: 20rem; min-width: 10rem;">
								<img class="card-img-top"	
										src="${item.nurl}" alt="New 1"
										style="width: %50; height: auto;">
										<div class="card-body">
											<h5 class="card-title">${item.ntitle}</h5>
											<a href='<s:url value="/editNews/${item.nid}"></s:url>'
										class="btn btn-danger">Edit</a>

										</div>
								</div>
							</div>

						</c:forEach>
					</c:if>
				</tbody>
			</table>

		</div>
	</div>
	<c:import url="/js"></c:import>
	<c:import url="/footer"></c:import>
</body>


</html>