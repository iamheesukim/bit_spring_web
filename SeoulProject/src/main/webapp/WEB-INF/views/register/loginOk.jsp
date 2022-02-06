<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${logStatus=='Y'}">
	<script>
		alert("로그인 성공");
		location.href="/seoul/";
	</script>
</c:if>
<c:if test="${logStatus!='Y'}">
	<script>
		alert("로그인 실패");
		history.back();
	</script>
</c:if>