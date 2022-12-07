<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<!-- input name이 있어야 서버에서 받을 수 있음
required 반드시 입력하도록 함
 -->
<form action="${pageContext.request.contextPath}/registerok.do" method="POST">
ID: <input type="text" name="id" placeholder="ID 입력" required="required"><br>
PWD: <input type="password" name="pwd" placeholder="PWD 입력" required="required"><br>
EMAIL: <input type="text" name="email" placeholder="EMAIL 입력" required="required"><br>
<input type="submit" value="회원가입">
</form>
</body>
</html>