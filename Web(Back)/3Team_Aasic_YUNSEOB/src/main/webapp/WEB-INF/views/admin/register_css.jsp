<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script type="text/javascript">
 //jquery 로 간단하게 유효성 check 하기
  function check(){
	 
	 if(!joinForm.userid.value){
		 alert('ID를 입력해 주세요.');
		 joinForm.userid.focus();
		 return false;
	 }else if(!joinForm.pwd.value){
		 alert('PWD를 입력해 주세요.');
		 joinForm.pwd.focus();
		 return false;
	 }else if(!joinForm.name.value){
		 alert('name를 입력해 주세요.');
		 joinForm.name.focus();
		 return false;
	 }else if(!joinForm.firstEmail.value){
		 alert('이메일을 확인해주세요');
		 joinForm.firstEmail.focus();
		 return false;
	 }else if(!joinForm.lastEmail.value){
		 alert('이메일을 확인해주세요');
		 joinForm.lastEmail.focus();
		 return false;
	 }else if(!joinForm.firstNumber.value){
		 alert('핸드폰 앞자리를 입력해 주세요.');
		 joinForm.firstNumber.focus();
		 return false;
	 }else if(!joinForm.phoneNumber.value){
		 alert('핸드폰번호를 입력해 주세요.');
		 joinForm.phoneNumber.focus();
		 return false;
	 }else if(!joinForm.address.value){
		 alert('주소를 입력해 주세요.');
		 joinForm.address.focus();
		 return false;
	 }
	 document.joinForm.submit();
 } 
 
 function submit2(frm) { 
	    frm.action='idOverlapCheck.user'; 
	    frm.submit(); 
	    return true; 
	  } 

 $(function(){
	//아이디 중복확인 비동기 
	$('#idcheck').on("click",(function(){//checkView
		
		//비동기 함수 호출
		 	$.ajax({
				url : "idOverlapCheck.user",  //URL 보내기
				type : "POST",					 //방식
				dataType : "html",		  	 //데이터 타입
				data : {
					'userid' : $('#userid').val()  //글번호 
				},
				success : function(data){
				$('#checkView').empty(data);
				$('#checkView').append(data);
				},
				error : function(request,status,error){
					alert("code:" +request.status+"\n" + "message:"+request.responseText+"\n"+"error:"+error);
					console.log(error);
				}
			});
	}));
/* 	console.log("function3");	 */
});
</script>

<head>
    <meta charset="utf-8">
    <title>DASHMIN - Bootstrap Admin Template</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="" name="keywords">
    <meta content="" name="description">

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600;700&display=swap" rel="stylesheet">
    
    <!-- Icon Font Stylesheet -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
    <link href="lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet" />

    <!-- Customized Bootstrap Stylesheet -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
		<!-- 사이드바 들어갈 자리 -->
		<jsp:include page="/WEB-INF/views/include/sidebar_css.jsp"></jsp:include>
		<!-- 사이드바 들어갈 자리 -->

<!-- 
<form action="insert.do" method="post" name="joinForm"
										id="joinForm" novalidate>
										<div>
											<label for="your ID">Your ID</label> <input type="text"
												name="userid" id="userid" required>
											<input type='button' value='ID중복확인' id="idcheck">
											<div id="checkView"></div>
											<div>Please, enter your ID!</div>
										</div>
										<div>
											<label for="yourPassword">Your Password</label> <input
												type="password" name="pwd" id="pwd" required>
											<div>Please enter a valid Password!</div>
										</div>
										<div>
											<label for="your Name">Your Name</label> <input type="text"
												name="name" id="name" required>
											<div>Please, enter your Name!</div>
										</div>
										<div>
											<label for="your Email">Your Email</label> 
												<input type="text" name="firstEmail" id="firstEmail" required> @
												
												<select id="lastEmail" name="lastEmail">
													<option value="" selected="selected">선택해주세요.</option>
													<option value="naver.com">naver.com</option>
													<option value="google.com">google.com</option>
													<option value="daum.net">daum.net</option>
												</select> 
											<div>Please, enter your Email!</div>
										</div>
										<div>
											<select id="firstNumber" name="firstNumber">
												<option value="" selected="selected">선택해주세요.</option>
												<option value="010">010</option>
												<option value="011">011</option>
												<option value="016">016</option>
											</select> <input type="text" name="phoneNumber" id="phoneNumber"
												required>
										</div>
										<div>
											<label for="your Address">address 추후에 지도api 사용해보자.</label> <input
												type="text" name="address" id="address" required>
											<div>Please enter your Address!</div>
										</div>
										<div>
											<label for="your Gender">Your Gender </label> <input
												type="radio" name="gender" id="gender" value="여" checked>여자
											<input type="radio" name="gender" id="gender" value="남">남자
										</div>

										<div>
											<button type="button" onclick="check();">회원가입</button>
										</div>
										<div>
											<button type="reset">취소</button>
										</div>
										<div>
											<p>
												아이디가 있으신가요? <a href="login.do"> Log in</a>
											</p>
										</div>
									</form>
 -->

        <!-- Content Start -->
        
        <div class="content">
        <!-- 헤더 -->
          <jsp:include page="/WEB-INF/views/include/header_css.jsp"></jsp:include>
		<!-- 헤더 -->

         <!-- 
          
         
          -->

        <!-- Sign Up Start -->
          <div class="container-fluid">
            <div class="row h-100 align-items-center justify-content-center" style="min-height: 100vh;">
                <div class="col-12 col-sm-8 col-md-6 col-lg-5 col-xl-4">
                    <div class="bg-light rounded p-4 p-sm-5 my-4 mx-3">
                        <div class="d-flex align-items-center justify-content-between mb-3">
                            <a href="index2.jsp">
                                <h3 class="text-primary"></i>KINGBIRD</h3>
                            </a>
                            <h3>Sign Up</h3>
                            
                        </div>
               
                        <form action="insert.do" method="post" name="joinForm" id="joinForm" novalidate>
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" id="userid" name ="userid" placeholder="유저 아이디">
                            <label for="floatingText">User ID</label>
                        </div>
                        	<div id="checkView"></div>
                        	
                        <input type='button' value='ID중복확인' id="idcheck" class="btn btn-sm btn-primary m-2">
							<br>
							
                         <div class="form-floating mb-4">
                            <input type="password" class="form-control" id="pwd" name ="pwd" placeholder="비밀번호">
                            <label for="floatingPassword">Password</label>
                        </div>
                          <div class="form-floating mb-3">
                            <input type="text" class="form-control" id="name" name = "name" placeholder="유저 아이디">
                            <label for="floatingText">Your Name</label>
                        </div>
                        <div class="form-floating mb-3">
                            <input type="text" class="form-control" name="firstEmail" id="firstEmail" required placeholder = "email">
                             <label for="floatingInput">First Email Address</label> @ 
                              <label for="floatingInput"></label>
                           	<select id="lastEmail" class = "accordion-button" name="lastEmail">
													<option value="" selected="selected">선택해주세요.</option>
													<option value="naver.com">naver.com</option>
													<option value="google.com">google.com</option>
													<option value="daum.net">daum.net</option>
							</select> 
                        </div>
                        
                                                                 
                        <div class="form-floating mb-3">                          
                           	<select id="firstNumber" class = "accordion-button" name="firstNumber">
													<option value="" selected="selected">first phoneNumber</option>
												<option value="010">010</option>
												<option value="011">011</option>
												<option value="016">016</option>
							</select> 
							<br>	
							<div class="form-floating mb-3">						
							 <input type="text" class="form-control" name="phoneNumber" id="phoneNumber" required placeholder = "zz">
                 			  <label for="floatingInput">Your phoneNumber</label>
                 			  </div>
                        </div>
                       
      
                       
                          <div class="form-floating mb-3">
                            <input type="text" class="form-control" id="address" name = "address" placeholder="유저 아이디">
                            <label for="floatingText">Your Address</label>
                        </div>
                        
                        <!-- 주쇼ㅗ -->
                        
                        <div class="form-floating mb-4">
                       
                            <input type="radio" class=form-check-input name="gender" id="gender" value="여" checked>여자
							<input type="radio" class="form-check-input"name="gender" id="gender" value="남">남자
                            
                        </div>
                  
                        <button type="button" class="btn btn-primary py-3 w-100 mb-4" onclick="check();">Sign Up</button>
                        <p class="text-center mb-0">아이디가 있으신가요? <a href="login.do">Sign In</a></p>
                      </form>
                    </div>
                   
                </div>
                  
            </div>
           
        </div> 
        
        <!-- Sign Up End -->
        <!-- <div class="container-fluid">
            <div class="row h-100 align-items-center justify-content-center" style="min-height: 100vh;">
            <div class="col-12 col-sm-8 col-md-6 col-lg-5 col-xl-4">
            <div class="bg-light rounded p-4 p-sm-5 my-4 mx-3">
            <div class="d-flex align-items-center justify-content-between mb-3">
                            <a href="index2.jsp">
                                <h3 class="text-primary"></i>KINGBIRD</h3>
                            </a>
                            <h3>Sign Up</h3>
                            
                        </div>
        				<form action="insert.do" method="post" name="joinForm"id="joinForm" novalidate>
        				
 						<div class="form-floating mb-3">
                            <input type="text" class="form-control" id="userid" name ="userid" placeholder="유저 아이디">
                            <label for="floatingText">User ID</label>
                        </div>
                        	<div id="checkView"></div>
                        	
                        <input type='button' value='ID중복확인' id="idcheck" class="btn btn-sm btn-primary m-2">
							<br>
							
						<div class="form-floating mb-4">
                            <input type="password" class="form-control" id="pwd" name ="pwd" placeholder="비밀번호">
                            <label for="floatingPassword">Password</label>
                        </div>										

										<div>
											<label for="yourPassword">Your Password</label> <input
												type="password" name="pwd" id="pwd" required>
											<div>Please enter a valid Password!</div>
										</div>
										<div>
											<label for="your Name">Your Name</label> <input type="text"
												name="name" id="name" required>
											<div>Please, enter your Name!</div>
										</div>
										<div>
											<label for="your Email">Your Email</label> 
												<input type="text" name="firstEmail" id="firstEmail" required> @
												
												<select id="lastEmail" name="lastEmail">
													<option value="" selected="selected">선택해주세요.</option>
													<option value="naver.com">naver.com</option>
													<option value="google.com">google.com</option>
													<option value="daum.net">daum.net</option>
												</select> 
											<div>Please, enter your Email!</div>
										</div>
										<div>
											<select id="firstNumber" name="firstNumber">
												<option value="" selected="selected">선택해주세요.</option>
												<option value="010">010</option>
												<option value="011">011</option>
												<option value="016">016</option>
											</select> <input type="text" name="phoneNumber" id="phoneNumber"
												required>
										</div>
										<div>
											<label for="your Address">address 추후에 지도api 사용해보자.</label> <input
												type="text" name="address" id="address" required>
											<div>Please enter your Address!</div>
										</div>
										<div>
											<label for="your Gender">Your Gender </label> <input
												type="radio" name="gender" id="gender" value="여" checked>여자
											<input type="radio" name="gender" id="gender" value="남">남자
										</div>

										<div>
											<button type="button" onclick="check();">회원가입</button>
										</div>
										<div>
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
									</div>
									</div>


 -->
            <!-- Footer Start -->
          <jsp:include page="/WEB-INF/views/include/footer_css.jsp"></jsp:include>
            <!-- Footer End -->
        </div>
        <!-- Content End -->


        <!-- Back to Top -->
        <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>
    </div>

    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
    <script src="lib/chart/chart.min.js"></script>
    <script src="lib/easing/easing.min.js"></script>
    <script src="lib/waypoints/waypoints.min.js"></script>
    <script src="lib/owlcarousel/owl.carousel.min.js"></script>
    <script src="lib/tempusdominus/js/moment.min.js"></script>
    <script src="lib/tempusdominus/js/moment-timezone.min.js"></script>
    <script src="lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

    <!-- Template Javascript -->
    <script src="js/main.js"></script>
</body>

</html>