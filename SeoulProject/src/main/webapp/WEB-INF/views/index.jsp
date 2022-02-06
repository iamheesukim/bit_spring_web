<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- 배너이미지 -->
<style>
#bx img {
	width: 800px;
	height: 350px;
}

#bx, #bx li {
	margin: 0px;
	padding: 0px;
	width: 800px;
}

h1 {
	text-align: center;
}
</style>
<script>
	$(()=>{
		$('#bx').bxSlider({
			mode:'horizontal' 
			,slideWidth:800
			,slideHeight:350
			,speed:5000
			,auto:true
			,captions:true
			,infiniteLoop:false
			,hideControlOnEnd:true
		});
	});
</script>

<section>
	<ul id="bx">
		<li><a href="#"><img src="resources/img/banner1.jpg"
				title="Seoul Music Festival"></a></li>
		<li><a href="#"><img src="resources/img/banner2.jpg"
				title="SIBAC 2019"></a></li>
		<li><a href="#"><img src="resources/img/banner3.jpg"
				title="2019 서울전환도시 국제컨퍼런스"></a></li>
		<li><a href="#"><img src="resources/img/banner4.jpg"
				title="2019 다다다 발표대회"></a></li>
		<li><a href="#"><img src="resources/img/banner5.jpg"
				title="2019 서울인공지능챗본론"></a></li>
		<li><a href="#"><img src="resources/img/banner6.jpg"
				title="서울차 없는 날"></a></li>
		<li><a href="#"><img src="resources/img/banner7.jpg"
				title="Zero 제로페이 미국 캐나다 이벤트"></a></li>
	</ul>


	<!-- 자유게시판 -->
	<style>
#list ul, #list li {
	margin: 0;
	padding: 0;
	list-style: none;
}

#list {
	width: 800px;
	height: 300px;
	margin: 0 auto;
}

#boardList>li {
	float: left;
	width: 6%;
	height: 40px;
	line-height: 40px;
	border-bottom: 1px solid #ddd;
}

#boardList>li:nth-child(6n+3) {
	width: 56%;
}

#boardList>li:nth-child(6n+4), #boardList>li:nth-child(6n+5) {
	width: 13%;
}

.wordCut {
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}

#list a:link, #list a:visited, #list a:hover {
	text-decoration: none;
	color: black;
}

#pagingDiv {
	margin : 0 auto;
	width: 280px;
	}
</style>

	<script>
   $(()=>{
      $('#allChk').on('change',function(){//체인지 이벤트가 발생하면
    	  //prop('속성종류') => 그 속성종류 자체의 상태를 뜻함 true or false
    	  //prop('속성종류',상태) => 그 속성종류를 상태로 바꿔라
            $('#boardList input[type=checkbox]').prop('checked',$('#allChk').prop('checked'));
      
      }); 
      
   });
</script>

	<h1>자유게시판</h1>
	<div id="list">
		<input type="checkbox" id="allChk">전체선택
		<ul id="boardList">
			<li><input type="hidden" /></li>
			<li>번호</li>
			<li class="wordCut">제목</li>
			<li>작성자</li>
			<li>작성일</li>
			<li>조회수</li>

			<c:forEach var="vo" items="${list}">
				<li><input type="checkbox" name="chk" value="${vo.no}" /></li>
				<li>${vo.no }</li>
				<li class="wordCut"><a href="list.jsp?num=1">${vo.subject}</a></li>
				<li>${vo.username }</li>
				<li>${vo.writedate }</li>
				<li>${vo.hit }</li>
			</c:forEach>
		</ul>
	</div>

	<!-- 페이징 -->
	<div id="pagingDiv">
		<ul class='pagination pagination-md'>
			
			<c:if test="${pVo.nowPage>1}">
				<li class='page-item'><a
					href="/seoul?nowPage=${pVo.nowPage-1}"
					class='page-link'>Prev</a></li>
			</c:if>

			<c:if test="${pVo.nowPage==1}">
				<li class='page-item'><a href='' class='page-link'>Prev</a></li>
			</c:if>

			<!-- 시작페이지부터 5개의 페이지 출력 -->
			<c:forEach var="i" begin="${pVo.startPage}"
				end="${pVo.startPage+pVo.onePageNumberCount-1}">
				
				<c:if test="${i<=pVo.totalPage}">
					
					<c:if test="${i==pVo.nowPage}">
						<li class='page-item active'>
					</c:if>

					<c:if test="${i!=pVo.nowPage}">
						<li class='page-item'>
					</c:if>

					<a
						href="/seoul?nowPage=${i}"
						class='page-link'>${i}</a>
				</c:if>
			</c:forEach>

			<!-- 다음페이지-->
			<c:if test="${pVo.nowPage<pVo.totalPage}">
				<li class='page-item'><a
					href="/seoul?nowPage=${pVo.nowPage+1}"
					class='page-link'>Next</a></li>
			</c:if>
		</ul>
	</div>

</section>