<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
/*
응답
1. <%=
2. <% 안에서 out 객체 사용

장단점 이해하기

*/
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>혼합된 코드 (정적 + 동적)</title>
</head>
<body>
	<h3>스파게티 코드 (UI 작업): 표현식</h3>
	<%
	boolean b = true;
	if (10 > 5) {
	%>
	IF(true)
	<font color="red"><%=b%></font>
	<%
	} else {
	b = false;
	%>
	IF(FALSE)
	<font color="blue"><%=b%></font>
	<%
	}
	%>
	<br><hr>
	<h3>Out 객체 사용 (서버에서 코드 작업)</h3>
	<%
	boolean b2 = true;
	if (10 > 5) {
		out.print("IF(true)<font color='red'>" + b2 + "</font>");
	} else {
		b = false;
		out.print("IF(true)<font color='blue'>" + b2 + "</font>");
	}
	%>
</body>
</html>