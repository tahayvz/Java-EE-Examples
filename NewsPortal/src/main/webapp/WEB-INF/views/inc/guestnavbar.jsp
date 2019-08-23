<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
    
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
      <a class="navbar-brand" href="#">Navbar</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item ${guestpage== 'guestnews' ? 'active' : ''}">
            <a class="nav-link" href='<s:url value="/guestnews"></s:url>'>Home <span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item ${guestpage == 'exit' ? 'active' : ''}">
             <a onclick="return alt();" class="nav-link" href='<s:url value="/exit"></s:url>'>Exit</a>
          </li>
        </ul>
        <form action='<s:url value="search"></s:url>' class="form-inline my-2 my-lg-0">
          <input name="q"  class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search" value="${param.q}">
          <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
      </div>
    </nav>
   
    