<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@page errorPage="/error/commonError.jsp"%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--
Error (예외 상황) 처리 페이지
최종 배포 전 제작, 처리

1. 페이지 마다 설정 page errorPage="/error/commonError.jsp"

2. 전역 설정 <error-page>
		<error-code>404</error-code>
		<location>/error/Error404.jsp</location>
		</error-page>
		
		전역보다 지역이 우선시됨

  -->

	<%
	String data = request.getParameter("name");
	String data2 = data.toLowerCase(); // null인 경우 함수 적용 X >> error 500
	%>
	전달 받은 내용:<%=data%>
</body>
</html>