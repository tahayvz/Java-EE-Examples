<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container" >

<h1>Menü</h1>
<hr/>
<div class="row">
<div class="col-sm-6">
<h3>Tatlılar</h3>
<hr/>
<c:if test="${ not empty data }">
	<c:forEach items="${data }" var="item">  
	<%--data is just name indicated at homecontroller.java. item is name used in this file--%>		
		<div><a href='<s:url value="/detail/${item }"></s:url>'>${item }</a></div>
	</c:forEach>
</c:if>
</div>

<div class="col-sm-6">
<h3>İçecekler</h3>
<hr/>
<c:if test="${ not empty datatwo }">
	<c:forEach items="${datatwo }" var="itemtwo">  
		<div><a href='<s:url value="/detail/${itemtwo }"></s:url>'>${itemtwo }</a></div>
	</c:forEach>
</c:if>
</div>

</div>
<hr/>

<div class="row">
<div class="col-sm-6">
<c:if test="${ not empty fail }">
	<div class="alert alert-danger alert-dismissible fade show" role="alert">
	  <strong>Hata!</strong> ${fail }
	  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
	    <span aria-hidden="true">&times;</span>
	  </button>
	</div>
</c:if>
<form method="post">
	<input name="mail" type="email" class="form-control" placeholder="E-mail" />
	<br><input name="password" type="password" class="form-control" placeholder="Password" />
	
	<br><input type="submit" value="Send" class="btn btn-success" />
</form>
</div>
<div class="col-sm-6"></div>
</div>


</div>
</body>
<script src="https://code.jquery.com/jquery-3.4.1.min.js" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>

</html>