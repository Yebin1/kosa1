<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tomcat Connection Pool 사용하기</title>
</head>
<body>
	<%
	Connection conn = null;

	// JNDI 작업
	// 현재 프로젝트에서 특정 이름을 가진 객체를 검색해 사용할 수 있게 만든다. (이름 기반 검색)
	Context context = new InitialContext();

	// context.xml에서 설정한 name "jdbc/oracle"
	// java:comp/env/ ... 
	DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
	// lookup된 객체의 타입: DateSource
	// object라서 다운캐스팅 필요
	
	// ds >> 튜브를 가지고 있는 가게 주소
	conn = ds.getConnection();
	// 튜브 주세요
	// 연결 객체 타입
	
	out.print("DB 연결 여부: " + conn.isClosed() + "<br>");
	
	// 반드시 반환해야 함
	// pool에서의 close는 자원 해제가 아닌 '반환'
	conn.close();
	out.print("DB 연결 여부: " + conn.isClosed() + "<br>");
	
	// pool이 제공하는 객체의 scope >> method로 한정해야 한다.
	
	
	
	%>
</body>
</html>