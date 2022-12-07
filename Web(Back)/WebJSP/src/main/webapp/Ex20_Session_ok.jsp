<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
// 1. 한글 처리
request.setCharacterEncoding("UTF-8");

// 2. 데이터 받기
String uid = request.getParameter("uid");
String pwd = request.getParameter("pwd");

// 3. 업무 처리 (로직 처리) >> 개발자 로직 제어
// JDBC 코드 >> DB 연결 >> CRUD 구문 생성 >> 실행 >> 결과 >> 처리
// Model >> DTO, DAO >> DAO 객체만 생성 가지고 놀기

// DB 연결 >> 회원 테이블 >> id, pwd >> 회원 여부인지 검증
// 쿼리문: select count(*) from member where id=? and pwd=?
// 쿼리문: select id, pwd from member where id=?

// 수행되었다고 치고
boolean success = false;
if (uid.equals(pwd)) { // 회원 ID == 비번 >> 회원 판단
	// 로그인 성공
	// session 객체 >> Scope >> WAS >> 내에서 사용 가능 (WEBAPP 내에서 모든 페이지가 사용)
	// Point >> session 객체 >> WebApp 내 모든 페이지가 사용
	session.setAttribute("memberid", uid);
	// memberid 세션 변수는 모든 다른 페이지에서 사용 가능
	success = true;
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	if (success == true) {
		// 로그인 성공
		out.print("<b>로그인 성공</b><br>");
		String user = (String) session.getAttribute("memberid");
		out.print(user + "님 로그인 되었습니다. <br>");
		out.print("<a href='Ex20_Session_Member.jsp'>회원전용</a>");

	} else {
	%>
	<!-- 로그인 실패 -->
	<script type="text/javascript">
		alert("다시 로그인 해주세요.");
		location.href("Ex20_Session_Lobin.jsp"); // F5 (새로고침)
		// window.history.go(-1) >> 직전 페이지로
	</script>
	<%
	}
	%>

</body>
</html>