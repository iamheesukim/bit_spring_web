<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>로그인</h1>
<form method="post" action="/app/loginOk">
   id: <input type="text" name="userid"><br>
   pwd:<input type="password" name="userpwd">
   <input type="submit" value="Login">
</form>
</body>
</html>