<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
/*
[요청에 대한 흐름 제어]
1. include (공통 디자인)
2. forward (중계자)

공통점: request 객체를 공유
차이점: 제어권	- include (제어권을 다시 가지고 온다)
			- forward (제어권을 넘겨준다) >> spring에서 (servlet이 요청을 판단, 요청마다 다른 서비스) >> forward를 통해 제어
			Point) 요청 주소는 동일, 다른 page의 내용을 서비스

ex)
http://192.168.0.29:8090/WebJSP/Ex14_forward.jsp?code=B
http://192.168.0.29:8090/WebJSP/Ex14_forward.jsp?code=C

1. 클라이언트가 요청한 page > Ex14_forward.jsp
2. 클라이언트가 받는 page 정보 > A.jsp / B.jsp / C.jsp

원리:	Buffer 주인 >> Ex14_forward.jsp >> Buffer는 Ex14_forward 내용을 담아야 하는데
	forward를 만나면 >> 주인을 배신하고 Buffer를 비워버림 >> 비워진 Buffer에 forward된 page의 내용을 담아 Client에게 서비스
	
*/

String code = request.getParameter("code");
String viewurl = null;

if (code.equals("A")) {
	viewurl="/forward/A.jsp";
} else if (code.equals("B")) {
	viewurl="/forward/B.jsp";
} else if (code.equals("C")) {
	viewurl="/forward/C.jsp";
}

/* http://192.168.0.56:9000/WebJSP/Ex14_forward_main.jsp?code=A */

%>

<jsp:forward page="<%=viewurl %>"></jsp:forward>
<!--
forward된 페이지 >> 자신의 데이터 의미 X
어차피 buffer를 비우고 다른 페이지 내용을 담기 때문
 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>Forward Main Page</h3>
</body>
</html>