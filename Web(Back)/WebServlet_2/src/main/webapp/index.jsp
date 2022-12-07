<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--
	http://192.168.0.56:9000/WebServlet_2/index.jsp 
	request.getContextPath() >> http://192.168.0.56:9000/WebServlet_s2
	-->
	<!-- %=request.getContextPath() (자바 코드), 위 EL 코드로 적으면 페이지 이름, 주소 등이 수정되어도 가져올 수 있음 -->
	<h3>index page</h3>
	<a href="${pageContext.request.contextPath}/NowServlet">요청하기</a>
<br>
	<a href="${pageContext.request.contextPath}/Now.do">요청하기2</a>
		<a href="${pageContext.request.contextPath}/Now.action">요청하기3</a>
</body>
</html>