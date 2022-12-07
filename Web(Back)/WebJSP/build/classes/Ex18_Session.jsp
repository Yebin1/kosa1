<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
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

Server (웹 서버 (WAS))
1. server memory: session 객체 (사이트 접속하는 사용자마다 고유하게 부여하는 메모리 (객체) >> 서버 리부팅, 개발 코드 변경 >> 소멸 > 재생성
2. server memory: application 객체 (사이트 접속하는 모든 사용자에게 부여하는 메모리 (객체) >> 서버 리부팅, 개발 코드 변경 >> 소멸 > 재생성

session 객체: 서버(Web)에 접속한 사용자마다 고유하게 부여되는 객체
고유성 보장 (key값 만들어 객체에게 할당) >> 각각의 session 객체마다 이름표(key) 붙임 >> key값은 클라이언트에게 전달 >> 해당 key로 사용자 분별
활용) 클라이언트마다 고유하게 부여 >> session 객체 (로그인 ID, 장바구니, 사용자의 정보)

제일 편리한 반면 성능 저하의 원인이 될 수 있음

1. http://192.168.0.56:9000/WebJSP/Ex18_Session.jsp 서버에 요청 보내기
2. sessionID (key) 생성 >> session 객체가 key를 가지고 있음 >> 생성된 sessionID값을 response (cookie)
 2.1. JSESSIONID: 5225224562253A143F092E53005EC2F5
3. 동기화

sessionID값 지운 후 새로고침 >> key값이 있는지 확인한 후 없으면 새로운 key값을 발급
ex) 접속자 1000명인 Web Server에 key 1000개 생성됨 key 이름표를 달고 있는 session 객체도 1000개 생성

ex) Client가 로그아웃 버튼 클릭 >> server는?
	로그아웃 판단 >> key 가지고 와서 >> 해당 key 이름표 달고 있는 session 객체를 찾아 abandon (소멸) >> invalidate
	>>>>>요악: 해당 key 이름표 달고 있는 session 객체를 찾아 지운다

 -->
 
 <%
 
 Date time = new Date();
 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
 
 %>
 <h3>Session 객체 정보</h3>
 Session 객체의 식별값: <%=session.getId() %>
 <hr>
 <%
 time.setTime(session.getCreationTime()); // session이 생성된 시각
 %>
 Session이 생성된 시각: <%=formatter.format(time) %>
 <hr>
 <%
 time.setTime(session.getLastAccessedTime());
 %>
 Session 마지막 접속 시간(Client): <%=formatter.format(time) %>
</body>
</html>