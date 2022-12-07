<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");

/*
1. 클라이언트 데이터 받기
2. Tomcat (내장 객체): 클라이언트가 요청 보내면 요청 하나에 대해 서버는 request 객체를 자동 생성
 2.1. request 객체 (요청): 객체 안에 요청한 정보 (입력한 데이터 + IP + 브라우저 버전)
 2.2. response 객체 (응답): 서버가 가지는 자원을 클라이언트에게 출력
 
Request request = new Request(); ... 자동으로 생성

http://localhost:9000/WebJSP/Ex02_register.jsp?userid=aaa&pwd=1234

*/

String uid = request.getParameter("userid");
String pwd = request.getParameter("pwd");
// hobby input 태그 name 통일
// 배열
String[] hobbyarray = request.getParameterValues("hobby");

/*
get 방식 전송 (한글 깨짐 X)
>> Tomcat 9.0 ver 부터 get 방식 한글 깨짐 X

post 방식 전송 (한글 깨짐)
>> 별도의 한글 처리
>> 페이지 상단에 인코딩 작업 필요


*/
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	서버가 클라이언트에게 응답
	<br> ID값:
	<%=uid%><br> PWD값:
	<%=pwd%><br> 당신의 취미는
	<%
for (String str : hobbyarray) {
%>
	<b>hobby:<%=str%>
	</b>
	<%
	}
	%>
</body>
</html>