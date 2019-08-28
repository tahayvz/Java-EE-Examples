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
<c:import url="/css"></c:import>
<c:import url="/exitfunc"></c:import>

</head>
<body>
	<div class="container">
		<c:import url="/navbar"></c:import>

		<div class="row">
			<div class="col-sm-4">
				<br /> <br /> <br />
				<h1>Edit News</h1>
				<form action="${us != null ? 'userEdit' : 'editNews/userEdit' }"
					method="post">
					<input value="${us.nurl }" name="nurl" type="text"
						class="form-control" placeholder="url" /> <br /> <input
						value="${us.ntitle }" name="ntitle" type="text"
						required="required" class="form-control" placeholder="title" /> <br />

					<input value="${us.ntext }" name="ntext" type="text"
						class="form-control" placeholder="titletext" /> <br /> 
					<input  name="ntexttwo" type="text"
						class="form-control" placeholder="text" /> <br />

					<div class="form-group">
						<select name="ncid" class="form-control">
							<c:if test="${not empty ctgData}">
								<c:forEach items="${ctgData }" var="item">
									<c:if test="${us.ncid == item.ctid}">
										<option selected="selected" value="${item.ctid}">${item.ctname}</option>
									</c:if>
									<c:if test="${us.ncid != item.ctid}">
										<option value="${item.ctid}">${item.ctname}</option>
									</c:if>
								</c:forEach>
							</c:if>
						</select>
					</div>
					<input type="submit" value="Kaydet" class="btn btn-success" />
				</form>
			</div>
		</div>
	</div>
	<c:import url="/js"></c:import>
	<c:import url="/footer"></c:import>
</body>
</html>