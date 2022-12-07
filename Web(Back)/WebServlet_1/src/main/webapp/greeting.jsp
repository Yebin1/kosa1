<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>VIEW Page</h3>
UI 코드 담당
<hr>
<%=	request.getAttribute("msg")%>
<hr>
EL: ${requestScope.msg}
<br>

</body>
</html>