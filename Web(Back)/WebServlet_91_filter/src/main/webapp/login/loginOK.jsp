<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
 
    // 1. 한글 처리
    // 2. 한글 처리 코드가 모든 페이지 상단에 공통사항(공통 관심)으로 있어야 함
    // 3. 공통 관심(보조 관심)을 분리, 한 곳에서 통합 관리하자 >> 가장 대표적인 기능: Filter
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
한글명: ${param.kor}<br>
영문명: ${param.eng}<br>
</body>
</html>