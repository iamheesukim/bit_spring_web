<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>글쓰기</h1>

<form method="post" action="/myapp/board/writeOk">
	제목 : <input type="text" name="subject"/><br/>
	<textarea name="content" cols="50" rows="10"></textarea><br/>
	<input type="submit" value="글 저장"/>
</form>
</body>
</html>