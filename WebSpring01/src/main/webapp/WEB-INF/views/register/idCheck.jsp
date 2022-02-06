<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
	#menu, #bottom{
		display:none;
	}
</style>
<script>
	function setUserid(userid){
		// 회원가입폼에
		opener.document.getElementById("userid").value = userid;
		opener.document.getElementById("idChkStatus").value = "Y";
		window.close();
	}
</script>


<!-- 중복아이디가 있을 때 -->
<b>${userid }</b>
<c:if test="${result > 0 }">
	는 사용 불가능한 아이디입니다.
</c:if>
<!-- 중복아이디가 없을 때 -->
<c:if test="${result <= 0 }">
	는 사용가능한 아이디입니다.
	<input type="button" value="사용하기" onclick="setUserid('${userid }')"/>
</c:if>
<hr/>
<form method="get" action="<%=request.getContextPath() %>/idCheck">
	아이디 : <input type="text" name="userid" id="userid"/>
	<input type="submit" value="아이디중복검사하기"/>
</form>