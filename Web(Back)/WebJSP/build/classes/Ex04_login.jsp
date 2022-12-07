<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
/*
내장 객체 (WAS) 가지고 있는 자원
1. request
2. response
3. session
4. application
*/

// 1. 한글 처리
request.setCharacterEncoding("UTF-8"); // post 전송
// 2. 데이터 받기
String id = request.getParameter("id");
// 3. 로직 처리 (비즈니스 업무) >> DB 작업 >> 암호화 작업 >> 개발자 마음

/*
1. 클라이언트 http://localhost:9000/WebJSP/Ex04_login.html 요청 보냄
2. 서버는 요청 받음 >> WAS 안 감 >> Web Server가 처리 >> Ex04_login.html client 전달
3. Ex04_login.html (입력) >> submit >> http://localhost:9000/WebJSP/Ex04_login.jsp
4. 요청 객체가 자동 생성 (request)
 4.1. request 객체가 클라이언트가 던진 수많은 아래 정보를 저장
 4.2. client 정보 (IP, 브라우저 정보, 입력값, 전송 방식)
 4.3. HttpServletRequest라는 타입을 가지는 클래스의 객체 >> request
 4.4. 자동 발생되는 코드: HttpServletRequest request = new HttpServletRequest(); 자동 생성
*/
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
입력값: <%=id %><hr>
접속 클라이언트 IP: <%=request.getRemoteAddr() %><hr>
서버 (인코딩): <%=request.getCharacterEncoding() %><hr>
포트: <%=request.getServerPort() %><hr>
context root(http://www.naver.com/WebJSP/)<br>
WebJSP >>> 사이트명, 가상 디렉토리, 홈 디렉토리, default 웹 경로
<%=request.getContextPath() %>

</body>
</html>