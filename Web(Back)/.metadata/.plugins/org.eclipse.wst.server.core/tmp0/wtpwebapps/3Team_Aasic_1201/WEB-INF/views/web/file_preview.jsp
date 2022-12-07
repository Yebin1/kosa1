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
<%-- <a class="btn btn-primary rounded-pill m-2" href="filedownload.user?filename=${requestScope.filename}">다운로드하기</a>
 --%>
<%-- <a class="btn btn-primary rounded-pill m-2" href="upload/${requestScope.filename}">새창으로 보기</a>
 --%><img width="300px" height="200px" src="ADupload/${requestScope.filename}">
</body>
</html>