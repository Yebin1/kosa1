<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 
    Today Point
    개념 이해 (서버 자원 활용하기)
    session 객체 가지고 놀기
    
    1. session 객체 (사용자마다 부여되는 교유한 객체)
    	>> 접속하는 브라우저마다 (sessionID)를 가지고 객체 관리
    	>> 접속한 사용자마다 고유한 변수 만들기 session.setAttribute()
    	>> session.setAttribute("id", request.getParameter("userid"));
    	
    	
    	접속자 3명
    	
    	김유신: server가 객체(session) 하나 생성, 식별값(A1)을 브라우저에게 전달
    	>> 생성된 session 객체 내 변수, 값 만들기가 가능
    	>> session 객체 (id, kim)
    	
    	이순신: 식별값(A2)
    	>> session 객체 (id, lee)
    	
    	...
    
     -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>세션 정보</h3>
	sessionID: <%=session.getId() %>
	<br><br><hr>
	<h3>세션 변수 (set)</h3>
	<%
	String userid = request.getParameter("userid");
	// Point ↓
	session.setAttribute("id", userid); // *** Client에 저장
	%>
	필요할 때마다 get함수를 통해 세션 변수를 가져온다.<br>
	<%
	String id = (String)session.getAttribute("id"); // 읽어옴 / Object는 가장 큰 타입이므로 String으로 다운캐스팅 필요
	out.print("당신의 ID: <b>" + id + "</b>");
	%>
	
	<!-- 
	session 객체의 유효 scope: webApp 전체 >> 어떤 페이지든 저장한 session 객체 사용 가능 
	setAttribute >> 다른 페이지에서도 getAttribute할 수 있다
	-->
	
</body>
</html>