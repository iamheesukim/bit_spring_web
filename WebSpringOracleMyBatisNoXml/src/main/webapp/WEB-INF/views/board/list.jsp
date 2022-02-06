<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"
	integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<style>
ul, li {
	padding: 0;
	margin: 0;
	list-style-type: none;
}

.wordCut {
	white-space: nowrap;
	text-overflow: ellipsisl;
	overflow: hidden;
}

li {
	width: 10%;
	border-bottom: 1px solid gray;
	height: 40px;
	line-height: 40px;
	float: left;
}

li:nth-child(5n+2) {
	width: 60%;
}
</style>
<script>
	$(function(){
	
		// 전체선택
		$('#allCheck').change(function(){
			$('#frm input').prop('checked', $('#allCheck').prop('checked'));
		});
	    
  		//배열에 레코드 저장한 후 삭제하기.
  		$("#arrayDel").click(()=>{
	    	//폼의 action 속성을 설정하고 submit 발생
	    	$("#frm").attr("action","/myapp3/arrayBoardDel");
	       	$("#frm").submit();
	    });
	  	
	  	//배열에 레코드 저장한 후 삭제하기.
	    $("#listDel").click(()=>{
	       //폼의 action 속성을 설정하고 submit 발생
	       $("#frm").attr("action","/myapp3/listBoardDel");
	       $("#frm").submit();
	    });
	    
	 });
</script>

</head>
<body>
	<h1>게시판 목록</h1>
	<a href="/myapp3/boardWrite">글쓰기</a>
	<div>
		<input type="checkbox" id="allCheck">전체선택
		<input type="button" id="arrayDel" value="배열로 삭제하기" />
		<input type="button" id="listDel" value="리스트(컬렉션)로 삭제하기" />
	</div>
	<form method="post" id="frm">
		<ul>
			<li>번호</li>
			<li>제목</li>
			<li>작성자</li>
			<li>조회수</li>
			<li>등록일</li>

			<c:forEach var="vo" items="${list}">
				<li><input type="checkbox" name="noDelArray" value="${vo.no}" />
					<input type="checkbox" name="noDelList" value="${vo.no}" />
					${vo.no }</li>
				<li class="wordCut"><a href="/myapp3/boardView?no=${vo.no }">${vo.subject }</a></li>
				<li>${vo.userid }</li>
				<li>${vo.hit }</li>
				<li>${vo.writedate }
			</c:forEach>
		</ul>
	</form>
</body>
</html>