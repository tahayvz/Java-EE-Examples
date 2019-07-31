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

	<div class="col-sm-12">
		<table class="table table-hover">
		  <thead>
		    <tr>
		      <th scope="col">ID</th>
		      <th scope="col">E-mail</th>
		      <th scope="col">Password</th>     
		      <th scope="col">Name</th>
		      <th scope="col">Surname</th>
		      <th scope="col">Phone</th>
		      <th scope="col">Category</th>
		      <th scope="col">Note</th>
		      
		    </tr>
		  </thead>
		  <tbody>
		  
		  <c:if test="${not empty tableData }">
		  	<c:forEach items="${tableData }" var="item">
			    <tr>
			     <th>${item.crid }</th>
   			      <th>${item.cmail }</th>
			      <th>${item.cpassword }</th>			    
			      <td>${item.cname }</td>
			      <td>${item.csurname }</td>
			      <td>${item.cphone }</td>
			      <td>${item.ctitle }</td>
			      <td>  <textarea readonly style="resize:none;border:none">${item.cnote } </textarea></td>
			   	
			    </tr>
		    </c:forEach>
		 </c:if>
		    
		    
		  </tbody>
		</table>
	</div>
</div>

</div>


</div>
</body>
<script src="https://code.jquery.com/jquery-3.4.1.min.js" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>

</html>