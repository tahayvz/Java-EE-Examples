<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<script>
	function alt() {
		const cnf = confirm("Are you sure you want to logout?");
		if (cnf) {
			return true;
		} else {
			return false;
		}
	}	
</script>

