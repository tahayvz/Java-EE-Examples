<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<div class="container" >
<div class="row">
	<div class="col-sm-4">
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
</div>
</div>
</body>
</html>