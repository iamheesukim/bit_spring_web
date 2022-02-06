<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
	.wordCut{
		white-space:nowrap;
		overflow:hidden;
		text-overflow:ellipsis;
	}
	#header, #board{overflow:auto; border-bottom:1px solid gray;}
	#header>div{float:left; width:50%;}
	#header>div:last-child{float:right; text-align:right;}
	
	#board>li{float:left; width:10%; border-bottom:1px solid #ddd; height:40px;}
	#board>li:nth-child(5n+2){width:60%};
</style>
<script>
	$(function(){
		$('#searchFrm').submit(function(){
			if($('#searchWord').val()==''){
				alert('검색어를 입력 후 검색하세요');
				return false;
			}
			return true;
		});
	});
</script>

<h1>게시판 리스트</h1>
<div id="header">
	<div>총 레코드 수 : ${pVo.totalRecord }</div>
	<div>총페이지수/현재페이지 : ${pVo.totalPage}/${pVo.nowPage}</div>
</div>

<!-- 리스트 -->
<ul id="board">
	<li>번호</li>
	<li>제목</li>
	<li>글쓴이</li>
	<li>등록일</li>
	<li>조회수</li>
	
	<c:forEach var="vo" items="${list}">
		<li>${vo.no }</li>
		<li class="wordCut"><a href="/myapp/boardView?no=${vo.no}&nowPage=${pVo.nowPage}">${vo.subject}</a></li>
		<li>${vo.userid }</li>
		<li>${vo.writedate }</li>
		<li>${vo.hit }</li>
	</c:forEach>
</ul>

<!-- 페이징 -->
<div>
	<ul class='pagination pagination-lg'>
		<!-- 이전페이지는 현재페이지가 1페이지보다 클 때만 표시 -->
		<c:if test = "${pVo.nowPage>1}">
			<li class='page-item'><a href="/myapp/boardList?nowPage=${pVo.nowPage-1}<c:if test='${pVo.searchWord!=null && pVo.searchKey!=null}'>&searchKey=${pVo.searchKey}&searchWord=${pVo.searchWord}</c:if>" class='page-link'>Prev</a></li>
		</c:if>
		
		<c:if test="${pVo.nowPage==1}">
			<li class='page-item'><a href='' class='page-link'>Prev</a></li>
		</c:if>
		
		<!-- 시작페이지부터 5개의 페이지 출력 -->
		<c:forEach var="i" begin="${pVo.startPage}" end="${pVo.startPage+pVo.onePageNumberCount-1}">
			<!-- 출력할 페이지번호 총페이지수보다 작을때만 출력한다 -->
			<c:if test="${i<=pVo.totalPage}"> <!-- 마지막페이지가 7이라면 8,9,10은 안뜨게끔.. -->
				<c:if test="${i==pVo.nowPage}">
					<li class='page-item active'>
				</c:if>
				
				<c:if test="${i!=pVo.nowPage}">
					<li class='page-item'>
				</c:if>
				
				<a href="/myapp/boardList?nowPage=${i}<c:if test='${pVo.searchWord!=null && pVo.searchKey!=null}'>&searchKey=${pVo.searchKey}&searchWord=${pVo.searchWord}</c:if>" class='page-link'>${i}</a></li>
			</c:if>
		</c:forEach>
		
		<!-- 다음페이지는 현재페이지가 총 페이지 수 보다 작으면 다음페이지가 있다. -->
		<c:if test="${pVo.nowPage<pVo.totalPage}">
			<li class='page-item'><a href="/myapp/boardList?nowPage=${pVo.nowPage+1}<c:if test='${pVo.searchWord!=null && pVo.searchKey!=null}'>&searchKey=${pVo.searchKey}&searchWord=${pVo.searchWord}</c:if>" class='page-link'>Next</a></li>
		</c:if>
	</ul>
</div>

<!-- 검색 -->
<div>
<form method="get" id="searchFrm" action="/myapp/boardList">
	<select name="searchKey">
		<option value="subject">제목</option>
		<option value="content">글내용</option>
		<option value="userid">작성자</option>
	</select>
	
	<input type="text" name="searchWord" id="searchWord"/>
	<input type="submit" value="Search"/>

</form>
</div>