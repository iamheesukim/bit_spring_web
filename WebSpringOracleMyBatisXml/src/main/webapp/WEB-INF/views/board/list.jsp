<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>글목록</h1>
<a href="/myapp/board/write">글쓰기</a>
<c:forEach var="vo" items="${list }">
	<div>
		${vo.no },
		<a href="/myapp/board/view?no=${vo.no}">${vo.subject }</a>,
		${vo.userid },
		${vo.hit },
		${vo.writedate }
	</div>

</c:forEach>
</body>
</html>