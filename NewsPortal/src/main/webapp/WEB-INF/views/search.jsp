<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>News Portal</title>
<c:import url="/css"></c:import>
<c:import url="/exitfunc"></c:import>

</head>
<body>
	<div class="container">
		<c:import url="/guestnavbar"></c:import>
		<div class="row">


			<table class="table">

				<tbody>
					<c:if test="${ not empty data }">
						<c:forEach items="${ data }" var="item">
							<div class="col-sm-3" style="max-width: 18rem; height: 20rem;">
								<br /> <br /> <br />
								<div class="card"
									style="max-width: 18rem; height: 18rem; min-width: 10rem;">
									<a href="news/${item.nid}"> <img class="card-img-top"
										src="${item.nurl}" alt="New 1"
										style="width: %50; height: auto;"> <a />
										<div class="card-body">
											<h5 class="card-title">${item.ntitle}</h5>
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