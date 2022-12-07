<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="border: 2px; border-color: silver;" >
파일 명 : ${requestScope.filename}
<hr style="color: blue;">
<a class="btn btn-primary rounded-pill m-2" href="filedownload.user?filename=${requestScope.filename}">다운로드하기</a>

<a class="btn btn-primary rounded-pill m-2" href="upload/${requestScope.filename}" target="_blank">새창으로 보기</a>
<img width="100px" height="120px" src="upload/${requestScope.filename}">
</body>
</html>