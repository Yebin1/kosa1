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
웹 환경

client > (request: 요청) > server 
server는 request 객체를 사용해서 read

server > (response: 응답) > client
응답 결과를 client의 웹 브라우저가 해석
응답 내용은 해석 가능한 형태 (text, html, css, script)

request, response, session, application, out ...
>> 톰캣이 가지고 있는 자원 (WAS: javax.객체 ...)

response
1. 표현식 (출력) %=
2. 페이지 이동 처리 (response.sendRedirect) > 서버 랜더링 > location.href="Ex01..."

** javascript 페이지 이동 처리 >> location.href="Ex01..."
** 서버에게 페이지를 재요청: F5 (새로고침)
 -->

	1. 일반적인 출력 (표현식):
	<%=100 + 200 + 300%>
	2. sendRedirect: response 객체 함수
	<%
	//response.sendRedirect("Ex01_index.jsp"); // 이 페이지를 서버에게 재요청
	%>
	<script type="text/javascript">
		location.href = "Ex01_index.jsp";
	</script>

</body>
</html>