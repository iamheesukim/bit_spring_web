<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
#whitetop {
	width: 100%;
	height: 80px;
	/*background-color:red;*/
}

#mainDiv {
	/*background-color:pink;*/
	width: 72%;
	margin: 0 auto;
	color: #553a31;
}

#profileDiv {
	width: 100%;
	height: 150px;
	border: 1px solid #553a31;
	margin-top: 50px;
	text-align: center;
	line-height: 50px;
	background-color: #eaded9;
	margin-bottom: 50px;
}


#adminMenu img {
	width:100px;
	height:100px;
}

</style>

<div id="whitetop"></div>

<div id="mainDiv">
	<h1>My Page</h1>

	<!-- < c : if test="${logid=='admin'}"> -->
	<div id="profileDiv">
		admin 님의 마이페이지<br />
		<!-- ${logid } -->
		<h2>Plan.D</h2>
		사업자번호 : 555555555
	</div>

	<table id="adminMenu">
		<tr>
			<td><img src="img/user.png" /><br/>회원 관리</td>
			<td><img src="img/user.png" /><br/>회원 관리</td>
			<td><img src="img/user.png" /><br/>회원 관리</td>
			<td><img src="img/user.png" /><br/>회원 관리</td>
		</tr>
		<tr>
			<td><img src="img/user.png" /><br/>회원 관리</td>
			<td><img src="img/user.png" /><br/>회원 관리</td>
			<td><img src="img/user.png" /><br/>회원 관리</td>
			<td><img src="img/user.png" /><br/>회원 관리</td>
		</tr>
	</table>
	<!--  < / c:if> -->

</div>