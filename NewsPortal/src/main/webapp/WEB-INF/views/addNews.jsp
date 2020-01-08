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
			<div class="col-sm-4"><br/><br/><br/>
				<h1>Add News</h1>
				<form action='<s:url value="newinsert"></s:url>' method="post">
					<input  name="nurl" type="text" class="form-control"
						placeholder="url" /> <br />
					<input  name="ntitle" type="text" required="required"
						class="form-control" placeholder="title" /> <br />
					<input  name="ntext" type="text" class="form-control"
						placeholder="title text" /> <br />
					<input  name="ntexttwo" type="text" class="form-control"
						placeholder="text" /> <br />	
						<div class="form-group">
						<select name="ncid" class="form-control">
							<c:if test="${not empty ctgData}">
								<c:forEach items="${ctgData }" var="item">
										<option value="${item.ctid}">${item.ctname}</option>
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