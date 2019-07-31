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

<script>

function alt() {
	const cnf = confirm("Çıkış Yapmak istediğinizden Emin misiniz?");
	if (cnf) {
		return true;
	} else {
		return false;
	}
}

</script>
<style>
.md-avatar {
  width: 100;
  height: 100px;
}
</style>
</head>
<body>
<div class="container" >

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Navbar</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href='<s:url value="/dashboard"></s:url>'>Add Contact <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href='<s:url value="/settings"></s:url>'>Update Contact</a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Category
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href='<s:url value="/allContact"></s:url>'>All Contact</a>
          <a class="dropdown-item" href='<s:url value="/family"></s:url>'>Family</a>
          <a class="dropdown-item" href='<s:url value="/friends"></s:url>'>Friends</a>
          <a class="dropdown-item" href='<s:url value="/work"></s:url>'>Work</a>
          <a class="dropdown-item" href='<s:url value="/other"></s:url>'>Other</a>
          
          <div class="dropdown-divider"></div>
          <a onclick="return alt();" class="dropdown-item" href='<s:url value="/exit"></s:url>'>Exit</a>
        </div>
      </li>
    
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav>




<div class="row">
	<div class="col-sm-6">
		<h1>Add Contact</h1>
		<form action='<s:url value="cartInsert"></s:url>' method="post">
			<div class="form-group">
			    <input required="required" name="cmail" type="email" class="form-control"  placeholder="e-mail">
  			</div>
			
			<div class="form-group">
			    <input required="required" name="cpassword" type="password" class="form-control"  placeholder="password">
  			</div>
			
			<div class="form-group">
			    <input required="required" name="cname" type="text" class="form-control"  placeholder="Name">
  			</div>
  			
  			<div class="form-group">
			    <input required="required"  name="csurname" type="text" class="form-control"  placeholder="Surname">
  			</div>
  			
  			<div class="form-group">
  				<input name="cphone"  required="required"  class="form-control" type='tel' pattern='[0-9]{3}[0-9]{3}[0-9]{4}' maxlength="10"  title='Phone Number: 5556667788 ' placeholder="5xxxxxxxxx">
  			</div>
  			<div class="form-group">
			  <textarea  name=cnote class="form-control" rows="3"  placeholder="Write note here..."></textarea>
			</div>
  			<div class="form-group">
			    <select name="cid" class="form-control">
			    <c:if test="${ not empty catData }">
			    	<c:forEach items="${catData }"  var="item" >
			    		<option value="${item.cid }">${item.ctitle }</option>
			    	</c:forEach>
			    </c:if>
			    </select>
			  </div>
			  
			<button type="submit" class="btn btn-success">Save</button>
			
		</form>
	</div>


</div>

</div>


</div>
</body>
<script src="https://code.jquery.com/jquery-3.4.1.min.js" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>

</html>