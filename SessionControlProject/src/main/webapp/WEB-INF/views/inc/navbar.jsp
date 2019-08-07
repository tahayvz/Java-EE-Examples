<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    
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
       <form action='<s:url value="search"></s:url>' class="form-inline my-2 my-lg-0">
          <input name="q"  class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search" value="${param.q}">
          <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
  </div>
</nav>
    
    