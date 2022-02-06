<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	홈 ${username }님 접속 <!-- 이름 나오면 로그인 된거임 -->
	<a href="/myhome/logout">로그아웃</a>
	<a href="/myhome/list">게시판</a>
	<a href="/myhome/transactionTest">트랜잭션테스트</a>
	
</h1>

<form method="post" action="/myhome/loginOK">
	아이디 : <input type="text" name="userid"/>
	비밀번호 : <input type="password" name="userpwd"/>
	<input type="submit" value="로그인"/>
</form>
</body>
</html>
