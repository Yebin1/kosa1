<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입력값 확인하기</title>
</head>
<body>
	<%-- <h3>게시판 입력 내용 확인</h3>
	제목&emsp;${newArticleCommand.title}<br>
	내용&emsp;${newArticleCommand.content}<br>
	순번&emsp;${newArticleCommand.parentId}<br> --%>
	
		<h3>게시판 입력 내용 확인</h3>
	제목&emsp;${Articledata.title}<br>
	내용&emsp;${Articledata.content}<br>
	순번&emsp;${Articledata.parentId}<br>
</body>
</html>