<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

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

	<script type="text/javascript">
	function delCheck(){
		document.del.submit();
	}
	function historyBack(){
		javascript:history.back();
	}
</script>

</head>
<body>
<c:choose>
	<c:when test="${sessionScope.userid eq admin}"> <!-- 관리자일때 -->
		<!-- 사이드바 들어갈 자리 -->
      <jsp:include page="/WEB-INF/views/include/adminsidebar_css.jsp"></jsp:include>
        <!-- Content Start -->
        <div class="content">
        <!-- 헤더 -->
         <jsp:include page="/WEB-INF/views/include/adminheader_css.jsp"></jsp:include>
	</c:when>
	<c:when test="${sessionScope.userid ne null && sessionScope.userid ne admin}"> <!-- 일반사용자 -->
		 <!-- 사이드바 들어갈 자리 -->
         <jsp:include page="/WEB-INF/views/include/sidebar_css.jsp"></jsp:include>
         <!-- Content Start -->
         <div class="content">
         <!-- 헤더 -->
         <jsp:include page="/WEB-INF/views/include/userheader_css.jsp"></jsp:include>
	</c:when>
</c:choose>
     
	
	<c:set var="idx" value="${requestScope.idx}" />
	<c:set var="boardname" value="${requestScope.boardname}" />
	<c:set var="writerid" value="${requestScope.writerid}" />
	
	<div id="pageContainer">
		<div style="padding-top: 25px; text-align: center">
			<form name="del" method="POST" action="boardDeleteOk.user?boardname=${boardname}&idx=${idx}&userid=${userid}">
				<center>
					
					<div align="center" style="width:400px;height:200px;">
						<h3 style="padding-top:100px;">정말 삭제하시겠습니까?</h3>
					</div>
					
					<button class="btn btn-primary rounded-pill m-2"  onclick="location.href='boardDeleteOk.user?boardname=${boardname}&idx=${idx}&writerid=${writerid}'">삭제하기</button>
					<input class="btn btn-primary rounded-pill m-2"  type="button" onclick="historyBack();" value="뒤로가기">
					<!-- <input type="reset" value="뒤로가기"> -->
					<div style="padding-bottom:130px;"></div>
				</center>
				<input type="hidden" name="idx" value="${idx}">
				<input type="hidden" name="writerid" value="${writerid}" >
				<input type="hidden" name="boardname" value="${boardname}">
			</form>
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