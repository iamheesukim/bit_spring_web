<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function delChk(no) {
		if(confirm("삭제할까요?")) {
			location.href="/myapp/board/del?no="+no;
		}
	}
</script>
</head>
<body>
<h1>글내용보기</h1>
<ul>
	<li>번호 : ${vo.no }</li>
	<li>작성자 : ${vo.userid }</li>
	<li>등록일 : ${vo.writedate }, 조회수 : ${vo.hit }</li>
	<li>제목 : ${vo.subject }</li>
	<li>글내용 : ${vo.content }</li>
</ul>

<a href="/myapp/board/Edit?no=${vo.no}">수정</a>
<a href="javascript:delChk(${vo.no})">삭제</a>
</body>
</html>