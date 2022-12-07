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
접속한 Client가 가지고 있는 domain 별로 기록되어 있는 cookie read
 -->
	<%
	Cookie[] cs = request.getCookies();
	// 웹 브라우저가 가지고 있는 모든 쿠키

	if (cs != null | cs.length > 0) {
		// 개발자 마음
		for (Cookie c : cs) {
			out.print("c.getName: " + c.getName() +"<br>");
			out.print("c.getValue: " + c.getValue() +"<br>");
			out.print("c.getMaxAge: " + c.getMaxAge() +"<br>"); // -1이라면 소멸 시간이 없다 (메모리)
			out.print("c.getDomain: " + c.getDomain() +"<br><hr>");
		}
	}
	%>
</body>
</html>