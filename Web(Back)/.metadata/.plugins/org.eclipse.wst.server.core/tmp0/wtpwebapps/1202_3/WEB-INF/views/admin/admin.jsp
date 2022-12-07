<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>ADMIN</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
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
		<jsp:include page="/WEB-INF/views/include/adminsidebar_css.jsp"></jsp:include>
        <!-- Content Start -->
        <div class="content">
        <!-- 헤더 -->
        <jsp:include page="/WEB-INF/views/include/adminheader_css.jsp"></jsp:include>

		<c:set var="total" value="${sessionScope.totalCount}" />
		<c:set var="today" value="${sessionScope.todayCount}" />
            <!-- 방문자 집계 Start -->
            <div class="container-fluid pt-4 px-4" style="margin-left:110px; margin-top:80px; margin-bottom:200px;">
            	<h2><b style="color:#007FFF;">KINGBIRD</b> 관리자 페이지</h2>
            	<h4>방문자 집계</h4>
                <div class="row g-4" >
                    <div class="col-sm-6 col-xl-3">
                        <div class="bg-light rounded d-flex align-items-center justify-content-between p-4">
                            <i class="fa fa-chart-line fa-3x text-primary"></i>
                            <div class="ms-3">
                                <p class="mb-2">일일 방문자 수</p>
                                <h6 class="mb-0">${today} 명</h6>
                            </div>
                        </div>
                    </div>
                    
                    
                    <div class="col-sm-6 col-xl-3">
                        <div class="bg-light rounded d-flex align-items-center justify-content-between p-4">
                            <i class="fa fa-chart-bar fa-3x text-primary"></i>
                            <div class="ms-3">
                                <p class="mb-2">전체 방문자 수</p>
                                <h6 class="mb-0">${total} 명</h6>
                                

                            </div>
                        </div>
                    </div>
                    
                </div>
            </div>
			
			
			
		
            
            
            <!-- Chart Start -->
            <div class="container-fluid pt-4 px-4">
                <div class="row g-4">
                
                    <div class="col-sm-12 col-xl-6">
                        <div class="bg-light rounded h-100 p-4">
                            <h6 class="mb-4">커뮤니티 이용자 성비</h6>
                            <canvas id="pie-chart"></canvas>
                        </div>
                    </div>
                    <div class="col-sm-12 col-xl-6">
                        <div class="bg-light rounded h-100 p-4">
                            <h6 class="mb-4">사용자 점유율</h6>
                            <canvas id="doughnut-chart"></canvas>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Chart End -->

			<!--falcon chart  -->
			<!--falcon chart  -->
			



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
	<script type="text/javascript">
		(function($) {
			"use strict";

			// Spinner
			var spinner = function() {
				setTimeout(function() {
					if ($('#spinner').length > 0) {
						$('#spinner').removeClass('show');
					}
				}, 1);
			};
			spinner();

			// Back to top button
			$(window).scroll(function() {
				if ($(this).scrollTop() > 300) {
					$('.back-to-top').fadeIn('slow');
				} else {
					$('.back-to-top').fadeOut('slow');
				}
			});
			$('.back-to-top').click(function() {
				$('html, body').animate({
					scrollTop : 0
				}, 1500, 'easeInOutExpo');
				return false;
			});

			// Sidebar Toggler
			$('.sidebar-toggler').click(function() {
				$('.sidebar, .content').toggleClass("open");
				return false;
			});

			// Progress Bar
			$('.pg-bar').waypoint(function() {
				$('.progress .progress-bar').each(function() {
					$(this).css("width", $(this).attr("aria-valuenow") + '%');
				});
			}, {
				offset : '80%'
			});

			// Calender
			$('#calender').datetimepicker({
				inline : true,
				format : 'L'
			});

			// Testimonials carousel
			$(".testimonial-carousel").owlCarousel({
				autoplay : true,
				smartSpeed : 1000,
				items : 1,
				dots : true,
				loop : true,
				nav : false
			});


		})(jQuery);
	</script>
	<script type="text/javascript">
		$(function() {
			$(document).ready(
					function() {
						//비동기 처리
						$.ajax({ // 파일이 아닌 url 주소로 요청을 보냄.
							url : "/3Team_Aasic/chart/chartjson.jsp",
							type : "GET",
							dataType : "JSON", //POINT
							success : function(data) {

								var boardname = new Array();
								var boardcnt = new Array();
								$.each(data, function(index, obj) {
									boardname[index] = obj.boardname

								});

								$.each(data, function(index, obj) {
									boardcnt[index] = parseInt(obj.boardcnt)

								});

								// Doughnut Chart
								var ctx6 = $("#doughnut-chart").get(0)
										.getContext("2d");
								var myChart6 = new Chart(ctx6, {
									type : "doughnut",
									data : {
										labels : boardname,
										datasets : [ {
											backgroundColor : [
													"rgba(0, 156, 255, .7)",
													"rgba(0, 156, 255, .6)",
													"rgba(0, 156, 255, .5)",
													"rgba(0, 156, 255, .4)",
													"rgba(0, 156, 255, .3)" ],
											data : boardcnt
										} ]
									},
									options : {
										responsive : true
									}
								});
							},
							error : function(xhr) {
								alert(xhr.status + "ERROR");
							}
						});
					});
		});
	</script>
	<script type="text/javascript">
		$(function() {
			$(document).ready(
					function() {
						//비동기 처리
						$.ajax({ // 파일이 아닌 url 주소로 요청을 보냄.
							url : "/3Team_Aasic/chart/genderchartjson.jsp",
							type : "GET",
							dataType : "JSON", //POINT
							success : function(data) {

								var gender = new Array();
								var gendercount = new Array();
								$.each(data, function(index, obj) {
									gender[index] = obj.gender

								});

								$.each(data, function(index, obj) {
									gendercount[index] = parseInt(obj.gendercount)

								});


								// Pie Chart
								var ctx5 = $("#pie-chart").get(0).getContext("2d");
								var myChart5 = new Chart(ctx5,
										{
											type : "pie",
											data : {
												labels : gender,
												datasets : [ {
													backgroundColor : [ "rgba(0, 156, 255, .7)",
														"rgba(0, 156, 255, .3)",
															
															 ],
													data : gendercount
												} ]
											},
											options : {
												responsive : true
											}
										});
							},
							
							error : function(xhr) {
								alert(xhr.status + "ERROR");
							}
						});
					});
		});
	</script>
	<!-- Template Javascript -->
	<!-- <script src="js/main.js"></script> -->
</body>

</html>