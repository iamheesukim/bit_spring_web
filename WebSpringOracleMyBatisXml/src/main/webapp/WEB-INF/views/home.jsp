<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	<a href="/myapp/login">로그인</a>
	<a href="/myapp/logout">로그아웃</a>
	<a href="/myapp/board/list">게시판</a>
</h1>
${userid }, ${username }
<%
	//session.invalidate();
%>
</body>
</html>
