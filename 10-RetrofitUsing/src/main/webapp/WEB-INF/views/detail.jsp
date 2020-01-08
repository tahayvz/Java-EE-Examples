@@ -1,39 +0,0 @@
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Home</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

</head>
<body>

	<div class="row">
		<div class="col-sm-12">

			<c:if test="${not empty ls }">
				<c:forEach items="${ls }" var="item">
									${item.productId}
									${item.productName}
									${item.brief}
									${item.price}
									<c:if test="${not empty item.categories }">
										${item.categories.get(0).categoryName}
									</c:if>
						<c:if test="${not empty item.images }">
							<img src="${item.images.get(0).thumb}" class="img-responsive" />
						</c:if>

				</c:forEach>
			</c:if>


		</div>
	</div>
</body>
</html>