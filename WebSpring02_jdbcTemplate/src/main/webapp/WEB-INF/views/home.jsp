<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
   <title>Home</title>
</head>
<body>
<h1>
   <a href="/app/login">${username} 로그인</a>
   <a href="/app/board/list">게시판</a>
   <%
      //session.invalidate();
   %>
</h1>
</body>
</html>