<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>글수정</h1>

<form method="post" action="/myhome/editOk?no=${vo.no }">
	제목 : <input type="text" name="subject" value="${vo.subject }"/><br/>
	글내용 : <textarea name="content" cols="50">${vo.content }</textarea><br/>
	<input type="submit" value="글 수정"/>
</form>
</body>
</html>