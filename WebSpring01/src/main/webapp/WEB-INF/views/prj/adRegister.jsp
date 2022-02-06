<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
	#mainDiv {
		/*background-color:pink;*/
		width:80%;
		margin : 0 auto;
	}
	
	#buttonbox {
		float:right;
		margin-bottom:70px;
	}
	
	label {
		margin-top : 10px;
	}
</style>
<script>

</script>

<div id="mainDiv">
	<h1>광고 신청</h1> <!-- 상단 좀 띄워야할듯 -->

	<form method="post" action="">
		<div class="mb-3">
			<label>상호명</label>
			<input type="text" class="form-control" name="name" id="name" value="$ {bVo.business_name}" readonly>
			
			<label>주소</label>
			<input type="text" class="form-control" name="addr" id="addr" value="$ {bVo.business_addr}" readonly>
			
			<label>연락처</label>
			<input type="text" class="form-control" name="tel" id="tel" value="$ {bVo.business_tel}" placeholder="하이픈(-) 없이 입력하세요." required>
			
			<label>시작날짜</label>
			<input type="date" class="form-control" name="start" id="start" required>
			
			<label>마감날짜</label>
			<input type="date" class="form-control" name="end" id="end" required>
			
			<label>링크</label>
			<input type="text" class="form-control" name="link" id="link" required>
			
			<label>내용</label>
			<textarea class="form-control" name="content" id="content" rows="2"></textarea>
			
			<label>첨부파일</label>
			<input class="form-control" type="file" id="formFile" required>
		</div>
		
		<div id="buttonbox">
			<input type="reset" value="리셋" class="btn btn-dark"/>
			<input type="submit" value="신청" class="btn btn-danger"/>
			<input type="button" value="취소" class="btn btn-secondary"/>
		</div>
		
	</form>
	
	


</div>