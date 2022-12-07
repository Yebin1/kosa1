<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script type="text/javascript">
	//jquery 로 간단하게 유효성 check 하기

	function loginValueCheck() {
		/* alert("가입"); */
	/* 	if (!joinForm.id.value) {
			alert('ID를 입력해 주세요.');
			joinForm.id.focus();
			return false;
		} else if (!joinForm.pwd.value) {
			alert('PWD를 입력해 주세요.');
			joinForm.pwd.focus();
			return false;
		} else if (!joinForm.name.value) {
			alert('name를 입력해 주세요.');
			joinForm.name.focus();
			return false;
		} else if (!joinForm.email.value) {
			alert('email를 입력해 주세요.');
			joinForm.email.focus();
			return false;
		} else { */
			document.joinForm.submit();
		//}

	}
</script>

</head>
<body>
	<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
	<main>
		<div class="container">

			<section>
				<div>
					<div>
						<div>
							<div>
								<a href="관리자 접근을 해야되나?"> <img alt=""> <span>NiceAdmin</span>
								</a>
							</div>
							<!-- End Logo -->

							<div>

								<div>
									<div>
										<h5>Create an Account</h5>
									</div>

									<form action="${pageContext.request.contextPath}/insert.do" method="post" name="joinForm"
										id="joinForm">

										<table>
											<tr>
												<td id="title">아이디</td>
												<td><input type="text" name="id" maxlength="50">
													<input type="button" value="중복확인"></td>
											</tr>

											<tr>
												<td id="title">비밀번호</td>
												<td><input type="password" name="password"
													maxlength="50"></td>
											</tr>

											<tr>
												<td id="title">이름</td>
												<td><input type="text" name="name" maxlength="50">
												</td>
											</tr>

											<tr>
												<td id="title">성별</td>
												<td><input type="radio" name="gender" value="남" checked>남
													<input type="radio" name="gender" value="여">여</td>
											</tr>

											<tr>
												<td id="title">이메일</td>
												<td><input type="text" name="email1" maxlength="50">@
													<select name="email2">
														<option>naver.com</option>
														<option>gmail.com</option>
												</select></td>
											</tr>

											<tr>
												<td id="title">휴대전화</td>
												<td><input type="text" name="phone" /></td>
											</tr>
											<tr>
												<td id="title">주소</td>
												<td><input type="text" size="50" name="address" /></td>
											</tr>
										</table>

										<div>
											<button type="button" onclick="loginValueCheck()">회원가입</button>
											<button type="reset">취소</button>
										</div>
										<div>
											<p>
												아이디가 있으신가요? <a href="login.do"> Log in</a>
											</p>
										</div>
									</form>

								</div>
							</div>

							<div>
								Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
							</div>

						</div>
					</div>
				</div>

			</section>

		</div>
	</main>
	<!-- End #main -->


	<a href="#"></a>

</body>
</html>