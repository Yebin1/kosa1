<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
</head>
<body>
	<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
	<form action="${pageContext.request.contextPath}/loginok.do" method="post" name="loginForm" id="loginForm"
		novalidate>
		<div>
			<table>
				<tr>
					<td id="title">아이디</td>
					<td><input type="text" name="id" maxlength="50"></td>
				</tr>

				<tr>
					<td id="title">비밀번호</td>
					<td><input type="password" name="password" maxlength="50"></td>
				</tr>
			</table>
			<div>
				<button type="submit">로그인</button>
				<input type="reset" value="취소">
			</div>
			<div>
				<p>
					아이디가 없나요? <a href="register.do">Create an account</a>
				</p>
			</div>
		</div>
	</form>
</body>
</html>