<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/core"%>
<%
/* 	if((String)session.getAttribute("id") == null || !session.getAttribute("id").equals("admin") ){
		//강제로 페이지 이동
		out.print("<script>location.href='main.do'</script>");
	} */
%>	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	border: solid 2px black;
	border-collapse: collapse;
}

tr {
	border: solid 1px blue;
	background-color: white;
	color: black;
}

td {
	border: solid 1px red;
}
</style>
</head>
<body>
	<table
		style="width: 900px; height: 500px; margin-left: auto; margin-right: auto;">
		<tr>
			<td colspan="2"><jsp:include page="/common/Top.jsp"></jsp:include>
			</td>
		</tr>
		<tr>
			<td style="width: 200px"><jsp:include page="/common/Left.jsp"></jsp:include>
			</td>
			<td style="width: 700px">
				<form action="update.do" method="post">

					<h3 style="text-align: center;">회원가입</h3>
					<div>
						<table
							style="width: 400px; height: 200px; margin-left: auto; margin-right: auto;">
					<c:set var="dao" value="${requestScope.dao}"/>
							<tr>								<td>아이디</td>
								<td>
					  				<input type="text" name="id" value="${dao.id}" readonly>
								</td>
							</tr>
							<tr>
								<td>비번</td>
 								<td>${dao.pwd}</td>
 							</tr>
							<tr>
								<td>이름</td>
								<td>
									<input type="text" name="name" value="${dao.name}" style="background-color: yellow">
								</td>
							</tr>
							<tr>
								<td>나이</td>
								<td>
 									<input type="text" name="age" value="${dao.age}" style="background-color: yellow">
								</td>
							</tr>
							<tr>
							
							<td>성별</td>
								<td>
  									[${dao.gender}]
			 								<input type="radio" name="gender" id="gender" value="여" <c:if test="${dao.gender}, '여')}">checked</c:if>>여자
											<input type="radio" name="gender" id="gender" value="남" <c:if test="${dao.gender}, '남')}">checked</c:if>>남자
 								</td>
							</tr>
							<tr>
								<td>이메일</td>
								<td>
 									<input type="text" name="email" value="dao.email" style="background-color: yellow"> 
								</td>
							</tr>
							<tr>
								<td colspan="2">
								<input type="submit" value="수정하기">
								<a href='update.do'>리스트이동</a></td>
						</table>

					</div>
				</form>
			</td>
		</tr>
		<tr>
			<td colspan="2"><jsp:include page="/common/Bottom.jsp"></jsp:include>
			</td>
		</tr>
	</table>
</body>
</html>
