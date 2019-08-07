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

	<c:import url="/exitfunc"></c:import>


</head>
<body>
<div class="container" >

<c:import url="/navbar"></c:import>


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

</body>
<c:import url="/js"></c:import>
</html>