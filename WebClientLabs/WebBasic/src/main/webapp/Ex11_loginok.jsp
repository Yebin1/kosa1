<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 // 자바 코드를 구현하는 영역
 // action="Ex11_loginok.jps"
 // 클라이언트에서 도착한 데이터를 받아주는 역할
 
 // <input type="text" name="id">
 // <input type="password name="pwd">
 
 String userid=request.getParameter("id");
 String pwd=request.getParameter("pwd");
 // 클라이언트가 입력한 아이디, 패스워드 값을 서버에서 받음
 
 // 필요하다면
 // insert into member(id, pwd) values(userid, pwd);
 
 %>   
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>당신이 입력한 데이터</h3>
ID:<%= userid %> <br>
PWD: <%= pwd %>
</body>
</html>