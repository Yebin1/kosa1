<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
String name = request.getParameter("name");
if (name.equals("kglim")) {
	out.print("<b>" + name + "</b>");
} else if (name.equals("hong")) {
	out.print("<i>" + name + "</i>");
} else {
	out.print("<h3>" + name + "</h3>");
}
out.print("<hr>");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--  
위 코드를 EL 과 JSTL 변환 하세요
-->

	<c:set var="name" value="${param.name}" />
	<c:choose>
		<c:when test="${name == 'kglim'}">
			<b>${name}</b>
			<br>
		</c:when>
		<c:when test="${name == 'hong'}">
			<i>${name}</i>
		</c:when>
		<c:otherwise>
			<h3>${name}</h3>
		</c:otherwise>
	</c:choose>


</body>
</html>