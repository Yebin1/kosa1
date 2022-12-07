<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<a href="main.do">Main</a>&nbsp;&nbsp;&nbsp;||
<a href="login.do">Login</a>&nbsp;&nbsp;&nbsp;||
<a href="register.do">Register</a>&nbsp;&nbsp;&nbsp;||
<a href="#">Intro</a>&nbsp;&nbsp;&nbsp;||
<a href="#">Intro</a>&nbsp;&nbsp;&nbsp;

<%
	if(session.getAttribute("id") != null){
		out.print("<b>[ " + session.getAttribute("id") +" ]</b> 로그인 상태");
		out.print("<a href='logout.do'>[ 로그아웃 ]</a>");
	}else{
		out.print("<b>[로그인 하지 않으셨네요]</b>");
		out.print("<a href='login.do'>[ 로그인 ]</a>");
	}
%>
