<%@page import="java.util.HashMap"%>
<%@page import="kr.or.kosa.Emp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%

Emp e = new Emp(2000, "kosauser");
HashMap<String, String> hp = new HashMap<>();
hp.put("data", "1004");

request.setAttribute("emp", e); // EL 사용 가능


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>기존 방식</h3>
<%=e %><br> <!-- kr.or.kosa.Emp@58c17dec -->
<%=e.getEname() %><br>
<%=e.getEmpno() %><br>

<h3>EL 출력</h3>
EL(출력 X): 자바 객체에 대한 직접적인 접근이 불가 ${e}<br>
EL(출력 X): 자바 객체에 대한 직접적인 접근이 불가 ${e.getEname()}<br>

<h3>해결</h3>
1. request 객체 또는 session 객체에 담는다.<br>
EL: ${requestScope.emp}<br><br>

2. JSTL 사용하여 처리

<h3>JSTL (core)</h3>
변수 생성, 제어문 (자바 코드 도움 없이) >> 서버에서 해석되고 실행되는 자원<br>
<c:set var="m" value="<%=e %>"/>
JSTL 사용하여 변수 m 생성 (EL 사용하여 접근 가능): ${m}<br>
getter 함수 (권장 X): ${m.getEmpno()}<br> 

EL 출력: (m.memberfield명 >> 자동으로 getter 호출): ${m.empno}<br>
EL 출력: (m.memberfield명 >> 자동으로 getter 호출): ${m.ename}<br>

<!-- 
EL: 출력 목적 >> 변수, 제어 구조 X
JSTL: 출력 목적 >> 변수, 제어 구조 출력에 도움
 -->
 
 <c:set var="username" value="${m.ename}"/><br>
 변수값 출력: ${username}<br>
 
 <hr>
 <h3>JSTL 변수 만들고 Scope 정의하기</h3>
 <c:set var="job" value="농구선수" scope="request"/>
 당신의 직업은: ${job}<br>
 만약 당신이 include, forward를 통해 페이지를 제어한다면 그 페이지에서도 EL을 통해 job 변수값 출력 가능
 <hr>
 
 <c:set var="job2" value="야구선수"/> <!-- page가 scope (따로 적지 않았으므로) -->
 값 출력: ${job2}<br>
 
 만든 변수를 삭제하는 기능<br>
 <c:remove var="job2"/>
 삭제한 값 출력: ${job2}<br>
 <hr>
 
 JAVA API 제공 객체 (직접 접근): ${hp}<br> <!-- 접근 불가 -->
 1. request 또는 session 객체에 담는다. (권장)<br>
 2. JSTL 사용 (c:set)<br><br>
 
 <c:set var="vhp" value="<%=hp%>"/>
 hp 객체: ${vhp}<br>
 hp 객체: ${vhp.data}<br>
 
 <hr>
 값을 write (hp.put("color", "red")): c:set의 목적은 데이터 추가가 아니므로 사용하지 않는 것을 권장<br>
 <c:set target="${vhp}" property="color" value="red"/>
 hp 객체: ${vhp}<br>
 
 
 
 
 

</body>
</html>