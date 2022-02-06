<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script>
	$(function(){
		$('#logFrm').submit(function(){
			if($('#userid').val()==''){
				alert('아이디를 입력하세요');
				return false;
			}
			if($('#userpwd').val()==''){
				alert('비밀번호를 입력하세요.');
				return false;
			}
			return true;
		});
	});
</script>

<h1>로그인</h1>
<form id="logFrm" method="post" action="<%=request.getContextPath()%>/loginOk">
	아이디 : <input type="text" name="userid" id="userid"/><br/>
	비밀번호 : <input type="password" name="userpwd" id="userpwd"/><br/>
	<input type="submit" value="로그인"/>
</form>
