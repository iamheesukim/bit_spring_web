<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
	#mainDiv {
		/*background-color:pink;*/
		width:80%;
		margin : 0 auto;
	}
	
	#imgbox {
		width : 100%;
		height : 200px; /* 나중에 지움 */
		border : 1px solid black; /* 나중에 지움 */
		margin : 0 auto;
		margin-top:70px;
		margin-bottom:70px;
	}
	
	td:nth-of-type(2n+1) {
		font-weight:bold;
		font-size:1.5em;
	}
	
	table {
		margin-bottom:70px;
	}
	
	#buttonbox {
		float:right;
		margin-bottom:70px;
	}
</style>

<div id="mainDiv">
	<h1>광고 관리</h1> <!-- 상단 좀 띄워야할듯 -->
	
	<div id="imgbox">
		이미지 들어갈 자리
		# 안에 $ { aVo.ad_photo }
		<img src="#"/>
	</div>
	
	<table class="table">
		<tbody>
		<tr>
			<td>상호명</td>
			<td>$ { bVo.business_name }</td>
		</tr>
		<tr>
			<td>연락처</td>
			<td>$ { bVo.business_tel }</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>$ { bVo.business_id }</td>
		</tr>
		<tr>
			<td>기간</td>
			<td>$ { aVo.ad_start } ~ $ { aVo.ad_end }</td>
		</tr>
		<tr>
			<td>링크</td>
			<td><a href="https://www.naver.com/" target="_blank">임시로 링크는 네이버 걸어둠 $ { aVo.link }</a></td>
		</tr>
		<tr>
			<td>내용</td>
			<td>$ { aVo.content }</td>
		</tr>
		</tbody>
		<tfoot>
	</table>
	
	<!-- 평소 우리가 하던 스타일
	<ul>
		<li>상호명 : $ { bVo.business_name }</li>
		<li>연락처 : $ { bVo.business_tel }</li>
		<li>작성자 : $ { bVo.business_id }</li>
		<li>기간 : $ { aVo.ad_start } ~ $ { aVo.ad_end }</li>
		<li>링크 : $ { aVo.link }</li>
		<li>내용 : $ { aVo.content }</li>
	</ul>
	 -->
	 
	 <!-- 관리자용 버튼 -->
	 <div id="buttonbox">
		 <input type="button" value="목록으로" class="btn btn-dark"/>
		 <input type="button" value="승인" class="btn btn-danger"/>
		 <input type="button" value="미승인" class="btn btn-secondary"/>
	 </div>
	 
	 <!-- 광고주용 버튼 -->
	 <div id="buttonbox">
		 <input type="button" value="목록으로" class="btn btn-dark"/>
		 <input type="button" value="수정" class="btn btn-danger"/>
		 <input type="button" value="삭제" class="btn btn-secondary"/>
	 </div>

</div>