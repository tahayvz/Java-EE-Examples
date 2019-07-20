<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>Welcome Detail Page</h1>
<h2>${title }</h2>	
<c:forEach items="${listDondurma }" var="item">  
		<div>${item }</a></div>
	</c:forEach>

		<%String order[]= request.getParameterValues("orders");
        if(order != null){%>
        <h4>Siparişiniz hazırlanıyor...</h4>
        <ul><%for(int i=0; i<order.length; i++){%>
            <li><%=order[i]%></li><%}%>
        </ul><%}%>
	
	 <form name="form1" onsubmit="checkBoxValidation()">
	        <h2>Önerilen içecekler</h2>
            <input type="checkbox" name="orders" value="Cay"/>Çay
            <input type="checkbox" name="orders" value="Kahve"/>Kahve
            <input type="checkbox" name="orders" value="Su"/>Su
            <h2>Önerilen tatlılar</h2>
            <input type="checkbox" name="orders" value="Baklava"/>Baklava
            <input type="checkbox" name="orders" value="Kunefe"/>Künefe
            <input type="checkbox" name="orders" value="Kadayif"/>Kadayıf
            <br/>
            <input type="submit" value="gönder"/>
      </form>
        
       
      
        
</body>
</html>