<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	파일 업로드
</h1>
<form method="post" action="/myapp/dataUpload" enctype="multipart/form-data">
	작성자 : <input type="text" name="userid" value="goguma"/><br/>
	제목 : <input type="text" name="subject"/><br/>
	첨부파일 : <input type="file" name="filename"/><br/>
			<input type="file" name="filename"/><br/>
			<input type="file" name="filename"/><br/>
			<input type="file" name="filename"/><br/>
	<input type="submit" value="업로드하기"/>
</form>
</body>
</html>
