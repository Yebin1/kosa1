<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script type="text/javascript">
 //jquery 로 간단하게 유효성 check 하기
  function check(){
	 
	/* if(!modiForm.pwd.value){
		 alert('Password를 입력해 주세요.');
		 modiForm.pwd.focus();
		 return false;
	 } else if(!modiForm.name.value){
		 alert('name를 입력해 주세요.');
		 modiForm.name.focus();
		 return false;
	 }else if(!modiForm.email.value){
		 alert('이메일을 확인해주세요');
		 modiForm.firstEmail.focus();
		 return false;
	 }else if(!modiForm.phone.value){
		 alert('핸드폰번호를 입력해주세요.');
		 modiForm.firstNumber.focus();
		 return false;
	 }else if(!modiForm.address.value){
		 alert('주소를 입력해 주세요.');
		 modiForm.address.focus();
		 return false;
	 } */
	 document.modiForm.submit();
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
<link href="images/kingbird.ico" rel="icon">
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
    
    <style>
    input {
    	marin-top:10px;
    }
    </style>
</head>

<body>
		<c:choose>
	<c:when test="${sessionScope.userid == 'admin'}"> <!-- 관리자일때 -->
		<!-- 사이드바 들어갈 자리 -->
      <jsp:include page="/WEB-INF/views/include/adminsidebar_css.jsp"></jsp:include>
        <!-- Content Start -->
        <div class="content">
        <!-- 헤더 -->
         <jsp:include page="/WEB-INF/views/include/adminheader_css.jsp"></jsp:include>
	</c:when>
	<c:when test="${sessionScope.userid ne null and sessionScope.userid ne admin}"> <!-- 일반사용자 -->
		 <!-- 사이드바 들어갈 자리 -->
         <jsp:include page="/WEB-INF/views/include/sidebar_css.jsp"></jsp:include>
         <!-- Content Start -->
         <div class="content">
         <!-- 헤더 -->
         <jsp:include page="/WEB-INF/views/include/userheader_css.jsp"></jsp:include>
	</c:when>
</c:choose>
        



      

        <!-- Modify Start -->
       
          <div class="container-fluid">
            <div class="row h-100 align-items-center justify-content-center" style="min-height: 100vh;">
                <div class="col-12 col-sm-8 col-md-6 col-lg-5 col-xl-4" style="width:800px; padding-top:40px;">
                    <div class="bg-light rounded p-4 p-sm-5 my-4 mx-3">
                        <div class="d-flex align-items-center">
                            <a href="index.do">
                                <h3 class="text-primary" style="margin-left:20px;">KINGBIRD</h3>
                            </a>
                            <h4 style="margin-left:50px;">${sessionScope.userid}님 회원정보 수정</h4>
                            
                        </div>
               
                       <form action="updateOK.user" method="post" id = "modiForm" name = "modiForm">
                        <c:set var="dao" value="${requestScope.dao}" />
                        
              
                        
                        <div class="col-sm-12 col-xl-6">
                        <div class="bg-light rounded h-100 p-4" style="width:600px; padding-top:40px;">
                            <div class="input-group mb-3">
                                <span class="input-group-text" id="basic-addon1">ID</span>
                                <input type="text" id = "userid" name = "userid" class="form-control" value="${sessionScope.userid}" aria-label="user 입력"
                                    aria-describedby="basic-addon1" readonly>
                            </div>

                            <div class="input-group mb-3">
                                <span class="input-group-text" id="basic-addon1">Password</span>
                                <input type="password" name="pwd" id="pwd" class="form-control" placeholder="Password를 입력하세요" aria-label="pwd 입력"
                                    aria-describedby="basic-addon1">
                            </div>

                            <div class="input-group mb-3">
                                <input type="text" name="firstEmail" id="firstEmail" class="form-control" placeholder="E-mail"
                                    aria-label="Recipient's username" aria-describedby="basic-addon2">
                                <span class="input-group-text" id="basic-addon2"><select class="form-select" id="lastEmail" name="lastEmail" 
                                    aria-label="Floating label select example">
                                    <option selected>Last E-mail</option>
                                    <option value="gmail.com">gmail.com</option>
                                    <option value="naver.com">naver.com</option>
                                    <option value="hanmail.com">hanmail.com</option>
                                </select></span>
                            </div>   
                            <div class="input-group mb-3">
                                <span class="input-group-text" id="basic-addon1">이름</span>
                                <input type="text"name="name" id="name" class="form-control" placeholder="이름을 입력하세요" aria-label="이름 입력"
                                    aria-describedby="basic-addon1">
                            </div>

                            <div class="input-group mb-3">
                                <span class="input-group-text" id="basic-addon1"><select class="form-select" id="firstNumber" name="firstNumber"
                                    aria-label="Floating label select example">
                                    <option selected>First Number</option>
                                    <option value="010">010</option>
                                    <option value="016">016</option>
                                    <option value="011">011</option>
                                </select></span>
                                <input type="text" class="form-control" placeholder="전화번호를 입력하세요" aria-label="pwd 입력" name="phoneNumber" id="phoneNumber"
                                    aria-describedby="basic-addon1">
                            </div>

                            
 
                            <label for="your Gender">Your Gender </label>
                             <div class="form-check">
                                <input class="form-check-input" type="radio" name="gender" id="gender" value="여" checked>
                                <label class="form-check-label" for="flexRadioDefault2">
                                    여성
                                </label>
                                </div>
                                <div class="form-check">
                                <input class="form-check-input" type="radio" name="gender" id="gender" value="남">
                                <label class="form-check-label" for="flexRadioDefault2">
                                    남성
                                </label>
                                </div>
                                <div class="input-group mb-3">
                                <input type="text" class="form-control" placeholder="자주 사용하시는 개발언어를 선택해주세요"
                                    aria-label="Recipient's username" aria-describedby="basic-addon2">
                                <span class="input-group-text" id="basic-addon2"><select class="form-select" id="floatingSelect"
                                    aria-label="Floating label select example">
                                    <option selected>JAVA</option>
                                    <option value="1">C++</option>
                                    <option value="2">Python</option>
                                    <option value="3">C+</option>
                                </select></span>
                            </div>
                           <!-- <div>
								<label for="your Gender">Your Gender </label> <input
									type="radio" name="gender" id="gender" value="여" checked>여자
								<input type="radio" name="gender" id="gender" value="남">남자
							</div> -->
            				 <br>
                            <div align="center">
                            	 <button type="button" class="btn btn-primary rounded-pill m-2" onclick="check();">회원 수정</button>
       							 <a href='index.jsp'>뒤로가기</a></td>
                            </div>
                            <input type="hidden" name="startdate" value="${sessionScope.startdate}">
                            <input type="hidden" name="startdate" value="${sessionScope.profilephoto}">
                        </div>
                    </div>
                        
                        
  
 
                      </form>
                    </div>
                   
                </div>
                  
            </div>
           
        </div> 
        
      
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