<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script>
	$(()=>{
		//문자열 비동기식으로 가져오기
		$("#str").click(function() {
			$.ajax({
				url:"/home/ajaxStr",
				data:"num=23&name=이순신",
				success:function(result) { //ajaxStr 맵핑한곳에서 리턴한 값이 result에 담김
					$("#view").append(result);
					
				}
				//에러는 딱히 안씀. 그냥 아무것도 안할거니까.
			});
		});
		
		//서버에서 List 컬렉션 객체 비동기식으로 가져오기
		$("#lst").on('click',function() {
			var url = "/home/ajaxList";
			var params = "num=100&nick=고구마";
			$.ajax({
				url:url,
				data:params,
				success:function(r) { 
					var rr = $(r); //r은 바로 못 쓰니까 담아주기
					
					rr.each(function(idx,vo) {
						$("#view").append("<hr/>"+idx+"-->"+vo.num+":"+vo.userid+":"+vo.nick);					
					});		
				},
				error:function(e) {
					console.log("List전송 에러 발생함", e.responseText);
				}
			});
		});
		
		//서버에서 비동기식으로 Object 가져오기
		$(document).on('click','#obj',function() {
			$.ajax({
				url:"/home/ajaxObject",
				success:function(result){
					$("#view").append("<hr/>num="+result.num+", userid="+result.userid+", nick="+result.nick);
				}
			});
		});
		
		//서버에서 비동기식으로 Map객체 가져옥
		$(document).on('click','#map',function() {
			$.ajax({
				url:"/home/ajaxMap",
				success:function(result) {
					var tag = "번호="+result.k1.num+", 아이디="+result.k1.userid+", 닉네임="+result.k1.nick+"<br/>";
					tag+="번호="+result.k2.num+", 아이디="+result.k2.userid+", 닉네임="+result.k2.nick+"<br/>";
					tag+="번호="+result.k3.num+", 아이디="+result.k3.userid+", 닉네임="+result.k3.nick+"<br/>";
					
					$("#view").append(tag);
				}
			
			});
		});
		
		//서버에서 비동기식으로 JSON 정보를 문자열로 가져와 json 객체로 파싱하여 정보를 사용하기
		$("#json").click(function() {
			$.ajax({
				url:"/home/ajaxJson",
				success:function(result) {
					//문자열을 전송받아 json형식으로 파싱한다.
					var jsonParsing = JSON.parse(result);
					console.log(jsonParsing);
					$("#view").append("no="+jsonParsing.no+", username="+jsonParsing.username);
					$("#view").append(", tel="+jsonParsing.tel+", addr="+jsonParsing.addr);
					
				}
			});
		});
	});
</script>
</head>
<body>
	AjaxTestPage

	<input type="button" id="str" value="ajax(문자열)"/> <!-- 화면전환없이 Mapping 찾아서 문자열을 보여주는걸 구현할 것~ -->
	<input type="button" id="lst" value="ajax(List)"/>
	<input type="button" id="obj" value="ajax(Obj)"/>
	<input type="button" id="map" value="ajax(Map)"/>
	<input type="button" id="json" value="ajax(Json)"/>
	
	<hr/>
	<div id="view"></div>
</body>
</html>