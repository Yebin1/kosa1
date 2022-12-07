<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
// EL 대체 <%= write 대체
// EL 사용한다고 해서 EL JAVA API 사용 불가 (<%=만 담당)

Date today = new Date();
request.setAttribute("day", today);
session.setAttribute("day2", today);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>EL 화면 출력 (서버 자원)</h3>
	EL: ${requestScope.day}<br> <!-- request의 day 가져옴 -->
	EL: ${day}<br> <!-- requestScope 생략 가능 (가독성 좋지 않아 되도록이면 생략하지 말 것) -->
	EL: ${sessionScope.day2}<br> <!-- sessionScope생략시 requestScope인지 sessionScope인지 파악하기 힘듦 -->
	
	
	
</body>
</html>