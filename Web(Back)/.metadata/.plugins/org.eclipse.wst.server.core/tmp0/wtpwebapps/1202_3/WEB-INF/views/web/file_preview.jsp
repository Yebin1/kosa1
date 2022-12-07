<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
파일 명 : ${requestScope.filename}
<img width="300px" height="200px" src="ADupload/${requestScope.filename}">
</body>
</html>