<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>JSTL 출력 - EL 출력</h3>
	<c:out value="<p>문단 태그</p>" />
	<p>문단 태그</p>
	<hr>
	<p>문단 태그입니다. 
	&lt;p&gt; 태그는 설명 ...
	<hr>
	<h3>예외처리</h3>
	<!-- 
		c:catch 안의 구문에서 예외가 발생하면 예외 객체가 생성되고
		예외 객체 주소를 받아서 처리한다.
		
		var="msg" >> java: Exception msg
	 -->
	<c:catch var="msg">
		name: <%=request.getParameter("name") %><br>
		<%
			if (request.getParameter("name").equals("hong")) {
				out.print("당신의 이름은 " + request.getParameter("name") + "입니다.");
			}
		%>
	</c:catch>
	<c:if test="${msg != null}">
		<h3>예외 발생</h3>
		오류 메시지: ${msg}<br>
	</c:if>
</body>
</html>