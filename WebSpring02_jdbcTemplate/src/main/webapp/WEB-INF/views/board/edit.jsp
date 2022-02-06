<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <form method="post" action="/app/board/editOk">
      <h1>글 수정</h1>
      <input type="hidden" name="no" value="${vo.no }" />
      제목 : <input type="text" name="subject" value="${vo.subject } }"/><br/>
      내용 : <textarea name="content" cols="50" rows="10">${vo.content }</textarea><br/>
      <input type="submit" value="수정하기"/>
   </form>
</body>
</html>