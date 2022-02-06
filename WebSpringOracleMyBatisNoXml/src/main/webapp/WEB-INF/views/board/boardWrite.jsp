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

<form method="post" action="/myapp3/boardWriteOk">
	제목 : <input type="text" name="subject"/><br/>
	글내용 : <textarea name="content" rows="5" cols="100"></textarea><br/>
	<input type="submit" value="글등록"/>
</form>
</body>
</html>