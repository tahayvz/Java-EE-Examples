<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
	<title>Home</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	
</head>
<body>
<div class="container" >
<div class="row">
	<div class="col-sm-4">
			<h1>Database Listesi</h1>
	
<form action="" method="post">
<input type="text" name="uname" class="form-control" placeholder="Name"><br/>
<input type="text" name="usurname" class="form-control" placeholder="Surname"><br/>
<input type="email" name="umail" class="form-control" placeholder="mail"><br/>	
<input type="password" name="upassword" class="form-control" placeholder="password"><br/>	
<input type="number" name="uprice" class="form-control" placeholder="price"><br/>	
<input type="text" name="uresim" class="form-control" placeholder="image"><br/>	

<input type="submit" value="Kaydet" class="btn btn-success"/>
</form>
</div>
	<div class="col-sm-8">
		<h1>Araba Listesi</h1>
			<table class="table table-hover">
			  <thead>
			    <tr>
			      <th scope="col">ID</th>
			      <th scope="col">İSİM</th>
			      <th scope="col">SOYİSİM</th>
			      <th scope="col">E-MAIL</th>
			      <th scope="col">ŞİFRE</th>		
			      <th scope="col">FİYAT</th>					          
			      <th scope="col">RESİM</th>		
			    </tr>
			  </thead>
			  <tbody>
				  <c:if test="${not empty data }">
				  	<c:forEach items="${data }" var="item">
				   	  <tr>
				      <th scope="row">${item.uid }</th>  
				      <td>${item.uname }</td>
				      <td>${item.usurname}</td>
				      <td>${item.umail }</td>						
				      <td>${item.upassword }</td>
				      <td>${item.uprice }</td>
				      <td><img src="${item.uresim }" width="150" class="img-responsive"/></td>	      
				      
				    <td>  <form action="delete/${item.uid }" method="post">
						<input type="submit" value="Sil" class="btn btn-danger"/>
					</form>	</td>					
					   <td> 
					<td>  <form action="detail/${item.uid }" method="get">
						<input type="submit" value="Edit" />
					</form>	</td>					
					   <td> 

				  	  </tr>
				    </c:forEach>
				 </c:if>
			  </tbody>
			</table>
			</div>
			</div>
			</div>
</body>
</html>
