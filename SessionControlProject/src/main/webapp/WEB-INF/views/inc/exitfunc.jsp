<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


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