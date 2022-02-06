<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${result==0 }">
	<script>
		alert("회원등록실패하였습니다.");
		history.back();
	</script>
</c:if>
<c:if test="${result > 0 }">
	<script>
		location.href="/myapp/login";
	</script>
</c:if>