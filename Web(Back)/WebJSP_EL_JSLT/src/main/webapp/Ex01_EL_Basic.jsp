<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    
    request.setCharacterEncoding("UTF-8");
    
    String id = request.getParameter("userid");
    
    request.setAttribute("name", "korea");
    request.setAttribute("user", "kosa");
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>JSP 출력</h3>
<b><%=id %></b><br>
<b><%=request.getAttribute("name") %></b><br>
<b><%=request.getParameter("userid") %></b><br><br><hr>
<!-- 
EL (출력 표현식): JSP 페이지에서 사용되는 전용 스크립트 언어 (화면에 출력) >> 서버에서 해석되는 스크립트
이유: 스파게티 코드는 % 영역과 UI 영역 혼재되어 있어 유지보수에 어렵고 코드 가독성이 떨어짐
문제 해결: html과 함께 쓸 수 있고 서버 자원도 잘 출력할 수 있는 script
>> JSP에서만 사용 가능하며 쉽다

EL: tomcat이 내장하고 있는 객체 (자원) 별도의 참조 없이 사용 가능

EL이 가지고 있는 객체
1. param
2. paramValues
3. requestScope
4. sessionScope
5. applicationScope
 -->
 
 <h3>EL 출력하기</h3>
 기존 코드 <%=1+5 %><br>
 EL: ${100+500}<br>
 EL: ${"1"+1}<br> <!-- 2 (자동 형변환) -->
 EL: ${1==1}<br> <!-- true -->
 EL: ${false}<br> <!-- false -->
 EL: ${!false}<br> <!-- true -->
 EL: ${empty x}<br> <!-- true -->
 
 
</body>
</html>