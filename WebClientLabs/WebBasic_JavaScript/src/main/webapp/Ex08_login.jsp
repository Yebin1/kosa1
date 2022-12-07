<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% 
	// JAVA 코드
	// 
	
	String id = request.getParameter("txtuserid");
    String pw = request.getParameter("txtpw");
    %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
서버 확인 (Client 다시 전달) <br>
입력한 ID: <%= id %> <br>
입력한 PW: <%= pw %>
</body>
</html>