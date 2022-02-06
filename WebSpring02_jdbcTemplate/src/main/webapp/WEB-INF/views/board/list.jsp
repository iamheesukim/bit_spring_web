<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>게시판 목록</h1>
	<a href="/app/board/write">글쓰기</a>
	
	<ol>
		<c:forEach var="vo" items="${list}">
			<li>
				${vo.no },
				<a href="/app/board/view?no=${vo.no}">${vo.subject}</a>,
				${vo.userid },
				${vo.hit },
				${vo.writedate }
			</li>
		</c:forEach>
	</ol>
	

</body>
</html>