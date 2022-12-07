<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

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
</head>

<body>
		<!-- 사이드바 들어갈 자리 -->
		<jsp:include page="/WEB-INF/views/include/sidebar_css.jsp"></jsp:include>
		
		<!-- 사이드바 들어갈 자리 -->


        <!-- Content Start -->
        <div class="content">
        <!-- 헤더 -->
          <jsp:include page="/WEB-INF/views/include/header_css.jsp"></jsp:include>
		<!-- 헤더 -->

     	<%-- <b>${userid} 회원님의 계정 비밀번호를 입력하세요</b>
				<form name="info" action="update.user" method="POST">
				<input type="password" name="pwd" size="5">
				<input type="hidden" name="userid" value="${userid}">
				<input type="submit" value="비밀번호 확인">
				</form>
				<br> --%>
				
				<!-- Sign In Start -->
        <div class="container-fluid">
            <div class="row h-100 align-items-center justify-content-center" >
                <div class="col-12 col-sm-8 col-md-6 col-lg-5 col-xl-4" style="width:500px; padding-top:40px;">
                    <div class="bg-light rounded p-4 p-sm-5 my-4 mx-3">
                        <div class="d-flex align-items-center justify-content-between mb-3">
                            <a href="index.html" class="">
                                <h3 class="text-primary">KINGBIRD</h3>
                            </a>
                            <h4 >${userid} 님</h4>
                        </div>
                        <form name="info" action="update.user" method="POST">
                      	<input type="hidden" name="userid" value="${userid}">
                        <div class="form-floating mb-4">
                            <input type="password" class="form-control" id="floatingPassword" id = "pwd" name = "pwd">
                            <label for="floatingPassword">비밀번호를 입력하세요</label>
                        </div>
                       
                        <button type="submit" class="btn btn-primary py-3 w-100 mb-4">Submit</button>
                       
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- Sign In End -->


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