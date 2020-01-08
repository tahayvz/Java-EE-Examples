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

		<div class="row">
			<div class="col-sm-4">
				<h1>Add User</h1>
				<form action="${us != null ? 'userEdit' : 'userInsert' }" method="post">
					<input value="${us.uname }" name="uname" type="text" class="form-control"
						placeholder="uname" /> <br />
					<input value="${us.usurname }" name="usurname" type="text" required="required"
						class="form-control" placeholder="usurname" /> <br />
					<input value="${us.umail }" name="umail" type="email" class="form-control"
						placeholder="umail" /> <br />
					<input value="${us.upassword }" name="upassword" type="password" class="form-control"
						placeholder="upassword" /> <br />
					<input value="${us.uprice }"  type="number" name="uprice" class="form-control" placeholder="Price"><br/>
		        	<input value="${us.uimg }"  type="text" name="uimg" class="form-control" placeholder="Image URL"><br/>
						
					<input type="submit" value="Kaydet" class="btn btn-success" />
					
				</form>
				<br/>
			    <a href="login" class="btn btn-primary">Login</a>
			</div>
			<div class="col-sm-8">
				<h1>User List</h1>
				<table class="table table-hover">
					<thead>
						<tr>
							<th scope="col">ID</th>
							<th scope="col">Name</th>
							<th scope="col">Surname</th>
							<th scope="col">Mail</th>
							<th scope="col">Password</th>
							<th scope="col">Price</th>
							<th scope="col">Image</th>
							<th scope="col">Delete</th>
							<th scope="col">Edit</th>

						</tr>
					</thead>
					<tbody>

						   <c:if test="${ not empty data }">
		  	<c:forEach items="${ data }" var="item">
			    <tr>
			      <th scope="row">${item.uid}</th>
			      <td>${item.uname}</td>
			      <td>${item.usurname}</td>
			      <td>${item.umail}</td>
			      <td>${item.upassword}</td>
			        <td>${item.uprice }</td>
				      <td><img src="${item.uimg}" width="150" class="img-responsive"/></td>
			      <td>
			      	<a href='<s:url value="/delete/${item.uid}"></s:url>' class="btn btn-danger">Sil</a>
			      </td>
			       <td>
			      	<a href='<s:url value="/edit/${item.uid}"></s:url>' class="btn btn-info">edit</a>
			      </td>
			    </tr>
			</c:forEach>
		  </c:if>

					</tbody>
				</table>

			</div>
		</div>

	</div>
</body>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>

</html>