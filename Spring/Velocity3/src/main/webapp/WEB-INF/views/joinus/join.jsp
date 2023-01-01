<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="/resources/js/join.js"></script>
<style>
#container {
	width: 100%;
	height: 100%;
	position: relative;
}

.dpn {
	display: none !important;
}

.join_wrap {
	width: 550px;
	margin: 0 auto;
	border: 1px solid #dadada;
	padding: 24px;
	border-radius: 5px;
}

.join_title {
	width: 100%;
	height: 35px;
	font-size: 19px;
	font-weight: bold;
	padding-left: 10px;
	padding: 0 0 10px 10px;
}

.join_box {
	width: 100%;
}

.join_box input {
	width: 100%;
	height: 50px;
	border: 1px solid #dadada;
	padding: 17px;
	border-radius: 5px;
	margin-top: 20px;
}

.join_box span {
	display: inline-block;
	color: red;
	font-size: 12px;
	padding-left: 1px;
	padding-top: 8px;
}

.email_auth {
	width: 100%;
	margin-top: 10px;
}

.email_auth input {
	display: inline-block;
	width: calc(100% - 121px);
	vertical-align: top;
	margin: 0;
}

.email_auth_btn {
	display: inline-block;
	width: 115px;
	height: 50px;
	padding: 17px 0 15px;
	border-radius: 6px;
	border: solid 1px rgba(0, 0, 0, .15);
	background-color: #03c75a;
	color: white;
	font-size: 17px;
	font-weight: bold;
	line-height: 1;
}

.join_btn {
	display: block;
	width: 100%;
	padding: 17px 0 15px;
	border-radius: 6px;
	border: solid 1px rgba(0, 0, 0, .15);
	background-color: #03c75a;
	color: white;
	font-size: 19px;
	font-weight: bold;
	margin-top: 20px;
}

#container {
	width: 100%;
	height: 100%;
	position: relative;
}

.dpn {
	display: none !important;
}

.join_wrap {
	width: 550px;
	margin: 100 auto;
	border: 1px solid #dadada;
	padding: 24px;
	border-radius: 5px;
}

.join_title {
	width: 100%;
	height: 35px;
	font-size: 19px;
	font-weight: bold;
	padding-left: 10px;
	padding: 0 0 10px 10px;
}

.join_box {
	width: 100%;
}

.join_box input {
	width: 100%;
	height: 50px;
	border: 1px solid #dadada;
	padding: 17px;
	border-radius: 5px;
	margin-top: 20px;
}

.join_box span {
	display: inline-block;
	color: red;
	font-size: 12px;
	padding-left: 1px;
	padding-top: 8px;
}

.email_auth {
	width: 100%;
	margin-top: 10px;
}

.email_auth input {
	display: inline-block;
	width: calc(100% - 121px);
	vertical-align: top;
	margin: 0;
}

.email_auth_btn {
	display: inline-block;
	width: 115px;
	height: 50px;
	padding: 17px 0 15px;
	border-radius: 6px;
	border: solid 1px rgba(0, 0, 0, .15);
	background-color: #03c75a;
	color: white;
	font-size: 17px;
	font-weight: bold;
	line-height: 1;
}

.join_btn {
	display: block;
	width: 100%;
	padding: 17px 0 15px;
	border-radius: 6px;
	border: solid 1px rgba(0, 0, 0, .15);
	background-color: #03c75a;
	color: white;
	font-size: 19px;
	font-weight: bold;
	margin-top: 20px;
}
</style>
<title>Join</title>

<script>
	/**
	 *  회원가입 관련 처리
	 */

	function fn_join() {
		var f = $('#join_frm');
		var formData = f.serialize();

		$.ajax({
			type : "POST",
			url : "join",
			data : formData,
			success : function(data) {
				if (data == "Y") {
					alert("회원가입이 완료되었습니다.");
					location.href = "/index.htm"
				} else {
					alert("회원가입에 실패하였습니다.");
				}
			},
			error : function(data) {
				alert("회원가입 에러 발생!");
				console.log(data);
			}
		});
	}

	$(function() {

		var email_auth_cd = '';

		$('#join').click(function() {

			if ($('#id').val() == "") {
				alert("아이디를 입력해주세요.");
				return false;
			}

			if ($('#name').val() == "") {
				alert("닉네임을 입력해주세요.");
				return false;
			}

			if ($('#password').val() == "") {
				alert("비밀번호를 입력해주세요.");
				return false;
			}

			if ($('#password').val() != $('#password_ck').val()) {
				alert("비밀번호가 일치하지 않습니다.");
				return false;
			}
			
			 if(email == ''){
				 alert("이메일을 입력해주세요.");
				 return false;
				 }

			if($('#email_auth_key').val() != email_auth_cd){
				alert("인증번호가 일치하지 않습니다.");
				return false;
			} 

			fn_join();
		});

		
		$(".email_auth_btn").click(function(){	     	 
		 var email = $('#email').val();
		 console.log(email);
		 var a =[];
			email = $('.email').val();
			
			$("input[name=email]").each(function(index, item){
	              //a.push($(item).val());
	              let txt = "";
	              txt =( $(item).val());
	              console.log("보낼 메일 주소 : "+txt)
	              a.push(txt)
	              //console.log($(item).val());
	        });
		 
		 $.ajax({
		 type : "POST",
		 url : "emailAuth/",
		 data : {
			"email" : a
		 },
		 success: function(data){
		 alert("인증번호가 발송되었습니다.");
		 email_auth_cd = data;
		 },
		 error: function(data){
		 alert("메일 발송에 실패했습니다.");
		 }
		 }); 
		 });  

		$('#userid').focusout(function() {
			var userid = $('#userid').val();
			console.log(userid);
			$.ajax({
				type : "POST",
				url : "idCheck/"+userid,
				success : function(data) {
					
					 if(data == "N")  {
						$('#id_ck').empty(data);
						$('#id_ck').append("<div id='p' style='color:red;'>사용 불가능한 아이디</div>");		//중복아이디일 때
						console.log(data)
					} else{
						$('#id_ck').empty(data);
						 $('#id_ck').append("<div id='p' style='color:green;'>사용 가능한 아이디</div>"); //중복 없을 때
						console.log("data : "+data); 
					}
				},
				error : function(data) {
				}
			});
		}); 
		
		$('#email_auth_key').focusout(function() {
			var email_auth_key = $('#email_auth_key').val();
			console.log(email_auth_key);
			$.ajax({
				type : "POST",
				url : "mailCheck/"+email_auth_key,
				success : function(data) {
					
					 if(data == "Y")  {
						$('#mail_ck').empty(data);
						$('#mail_ck').append("<div id='p' style='color:green;'>인증에 성공하였습니다.</div>");		//중복아이디일 때
						console.log(data)
					} else {
						$('#mail_ck').empty(data);
						 $('#mail_ck').append("<div id='p' style='color:red;'>인증 번호를 다시 확인해 주세요.</div>"); //중복 없을 때
						console.log("data : "+data); 
					}
				},
				error : function(data) {
				}
			});
		}); 
		
	}); 
		
		</script>
		</head>
		<body>
			<div id="container" class="container">
				<div class="content">
					<div class="join_wrap">
						<form id="join_frm">
							<div class="join_title">회원가입</div>
							<div class="join_box">
								<input type="text" placeholder="아이디" name="userid" id="userid" style="margin: 0;">
							 	<span id="id_ck" ></span> 
									<input type="text" placeholder="이름" name="name" id="name">
									 <!-- <span id="nickname_ck" class="dpn">이미 사용중인 닉네임입니다.</span> -->
									 <input type="password" placeholder="비밀번호" name="pwd" id="password"> 
									 <input type="password" placeholder="비밀번호  확인" id="password_ck">
								<div class="email_auth">
									<input type="text" placeholder="이메일" name="email" id="email" class="email">
									<button type="button" id="email_auth_btn" class="email_auth_btn">인증번호 받기</button>
								</div>
								<input type="text" placeholder="인증번호 입력" id="email_auth_key">
								<span id="mail_ck" ></span> 
							</div>
							<button type="button" id="join" class="join_btn">가입하기</button>
						</form>
					</div>
				</div>
			</div>
		</body>
		</html>