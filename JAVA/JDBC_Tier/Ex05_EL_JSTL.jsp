<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
/*
JSTL 구문 (WAS에서 해석, 서버 쪽 스크립트 자원)
<c:set> 변수 생성, 값을 저장
<c:remove> 변수 삭제
<c:if test=""> 조건문 test="조건식 true, false"
<c:choose> 여러가지 조건 처리 (if 활용도가 높음)
<c:forEach> 반복문 (java: 개선된 for문)
<c:forTokens> for + split
<c:out> 출력식 >> EL ${} 사용
<c:catch> 예외 처리 

*/
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>JSTL & EL</h3>
	EL parameter: ${param.id}-${param.pwd}
	<br>
	<h3>EL 값 변수에 저장</h3>
	<c:set var="userid" value="${param.id}" />
	<c:set var="userpwd" value="${param.pwd}" />
	<hr>
	<h3>JSTL 변수값 출력</h3>
	id: ${userid}
	<br> pwd: ${userpwd}
	<br>
	<hr>
	<c:if test="${!empty userpwd}">
		<!-- 비밀번호가 존재한다면 -->
		<h3>not empty userpwd</h3>
		<c:if test="${userpwd == '1004'}">
			<h3>welcome admin page</h3>
		</c:if>
	</c:if>
	<!-- http://192.168.0.56:9000/WebJSP_EL_JSLT/Ex05_EL_JSTL.jsp?id=aaa&pwd=1004 -->
</body>
</html>