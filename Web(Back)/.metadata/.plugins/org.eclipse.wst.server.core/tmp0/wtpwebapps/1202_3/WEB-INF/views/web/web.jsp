<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>KingBird</title>
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
    
    <!-- 내가 추가한 링크 -->
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Inconsolata">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
       th, td {
        text-align: center;
      }
    </style>
    
    <script>
//HOT게시판 비동기 
		$(document).ready(function(){
			//비동기 함수 호출
			$.ajax(
				{
					 cache : false,
			            url : "hotList.do", 
			            type:"GET", 
			            dataType:"html",	
			            success : function(data) {
			                $('#hotboardtable').empty(data);
			                $('#hotboardtable').append(data);
			            }, // success 
			    
			            error : function(request,status,error) {
			            	alert("code:" +request.status+"\n" + "message:"+request.responseText+"\n"+"error:"+error);
							console.log(error);
			            }
			        }); // $.ajax */
			        
			        
			        
	        $.ajax(
					{
						 cache : false,
				            url : "noticeList.do", 
				            type:"GET", 
				            dataType:"html",	
				            success : function(data) {
				                $('#noticeboardtable').empty(data);
				                $('#noticeboardtable').append(data);
				            }, // success 
				    
				            error : function(request,status,error) {
				            	alert("code:" +request.status+"\n" + "message:"+request.responseText+"\n"+"error:"+error);
								console.log(error);
				            }
				        }); // $.ajax */
			    });
</script>
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
           <!-- Sale & Revenue Start -->
            <div class="container-fluid pt-4 px-4">
            		<!-- <h6 class="mb-0">이달의 광고</h6> 왼쪽 글자 이거 지울거임
                <div><h4 align="center"  style="background-color:gray; height:230px;">배너 들어갈 부분</h4></div> -->
                <!-- 광고 배너 리스트 -->
         <div id="myCarousel" class="carousel slide" data-ride="carousel">
				<ol class="carousel-indicators">
					<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
					<li data-target="#myCarousel" data-slide-to="1"></li>
					<li data-target="#myCarousel" data-slide-to="2"></li>
					<li data-target="#myCarousel" data-slide-to="3"></li>
				</ol>

				<div class="carousel-inner" role="listbox">

					<div class="item active">
						<img src="./images/코딩1.png" alt="광고1" width="100%" height="205">
						<div class="carousel-caption">
                            <!-- <h2>인간의 수준을 넘어선 디자인</p> -->
						</div>
					</div>

					<div class="item">
						<img src="./images/코딩.png" alt="광고2" width="100%" height="205">
						<div class="carousel-caption">
							<!-- <h3>광고2</h3> -->
						</div>
					</div>

					<div class="item">
						<img src="./images/코딩1.png" alt="광고3" width="100%" height="205">
						<div class="carousel-caption">
							<!-- <h3>광고3</h3> -->
						</div>
					</div>

					<div class="item">
						<img src="./images/코딩2.png" alt="광고4" width="100%" height="205">
						<div class="carousel-caption">
							<!-- <h3>광고4</h3> -->
						</div>
					</div>
				</div>
				</div>
                
            </div>
            <!-- Sale & Revenue End -->


            <!-- Hot게시판 Start -->
            <div class="container-fluid pt-4 px-4">
                <div class="row g-4">
                    <div class="col-sm-12 col-xl-6">
                       
                        <div id="hotboardtable" class="bg-light rounded h-100 p-4" style="width:440px; float:left; margin-right:90px;">
                            
                        </div>
                         <!-- 핫게시판 End -->
                        
                        
                        
                        <div  id="noticeboardtable" class="bg-light rounded h-100 p-4" style="width:440px; float:left;">
                           
                        </div>
                    </div>
                    <div class="col-sm-12 col-xl-6">
                       
                        
                    </div>
                </div>
            </div>


            <!-- Recent Sales Start -->
            
            
            
             <div class="container-fluid pt-4 px-4">
                <div class="row g-4">
                    <div class="col-sm-12 col-xl-6" style="margin-left:20px;">
                    <h4 class="mb-0"><b><span style="color:#009CFF;">KINGBIRD</span> 회원 개발언어 그래프</b></h4>
                        <div class="bg-light rounded h-100 p-4" style="width:440px; float:left; margin-right:74px;">
                           <h5 class="mb-0"><b>이용자<span style="color:#009CFF;"> 사용언어</span> 현황</b></h5>
									<canvas id="bar-chart">사용 언어</canvas>
									<h6 style="margin-left:50px;">Kingbird 회원들이 어떤 언어를 주로 사용하는지 보여줍니다.</h6>
                        </div>
                         <!-- 핫게시판 End -->
                        
                        
                        
                        <!-- 공지사항 게시판 Start -->
                        <div class="bg-light rounded h-100 p-4" style="width:440px; float:left;">
                        <h5 class="mb-0"><b>일별<span style="color:#009CFF;"> 사용자 </span>현황</b></h5>
	                    			  <canvas id="worldwide-sales"></canvas>
	                    			  <h6 style="margin-left:95px;">Kingbird 회원들의 이용빈도를 나타냅니다.</h6>
                        </div>
                    </div>
                    <div class="col-sm-12 col-xl-6">
             
                    </div>
                </div>
            </div>
        
                
            </div>
            <!-- Recent Sales End -->


            <!-- Widgets Start -->
            <div class="container-fluid pt-4 px-4">
                <div class="row g-4">
              
                </div>
            </div>
            <!-- Widgets End -->


            <!-- Footer Start -->
            <div class="container-fluid pt-4 px-4">
                <div class="bg-light rounded-top p-4">
                    <div class="row">
                        <div class="col-12 col-sm-6 text-center text-sm-start">
                            &copy; <a href="#">KINGBIRD</a>, All Right Reserved. 
                        </div>
                        <div class="col-12 col-sm-6 text-center text-sm-end">
                            <!--/*** This template is free as long as you keep the footer author’s credit link/attribution link/backlink. If you'd like to use the template without the footer author’s credit link/attribution link/backlink, you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". Thank you for your support. ***/-->
                            Designed By <a href="https://htmlcodex.com">Kingbird Design Team</a>
                        </br>
                        Distributed By <a class="border-bottom" href="https://themewagon.com" target="_blank">JunHans</a>
                        </div>
                    </div>
                </div>
            </div>
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

		/* 	// Single Bar Chart
			var ctx4 = $("#bar-chart").get(0).getContext("2d");
			var myChart4 = new Chart(ctx4,
					{
						type : "bar",
						data : {
							labels : [ "Italy", "France", "Spain", "USA",
									"Argentina" ],
							datasets : [ {
								backgroundColor : [ "rgba(0, 156, 255, .7)",
										"rgba(0, 156, 255, .6)",
										"rgba(0, 156, 255, .5)",
										"rgba(0, 156, 255, .4)",
										"rgba(0, 156, 255, .3)" ],
								data : [ 55, 49, 44, 24, 15 ]
							} ]
						},
						options : {
							responsive : true
						}
					}); */

			// Pie Chart
			var ctx5 = $("#pie-chart").get(0).getContext("2d");
			var myChart5 = new Chart(ctx5,
					{
						type : "pie",
						data : {
							labels : [ "Italy", "France", "Spain", "USA",
									"Argentina" ],
							datasets : [ {
								backgroundColor : [ "rgba(0, 156, 255, .7)",
										"rgba(0, 156, 255, .6)",
										"rgba(0, 156, 255, .5)",
										"rgba(0, 156, 255, .4)",
										"rgba(0, 156, 255, .3)" ],
								data : [ 55, 49, 44, 24, 15 ]
							} ]
						},
						options : {
							responsive : true
						}
					});

			/*    // Doughnut Chart
			   var ctx6 = $("#doughnut-chart").get(0).getContext("2d");
			   var myChart6 = new Chart(ctx6, {
			       type: "doughnut",
			       data: {
			           labels: ["Italy", "France", "Spain", "USA", "Argentina"],
			           datasets: [{
			               backgroundColor: [
			                   "rgba(0, 156, 255, .7)",
			                   "rgba(0, 156, 255, .6)",
			                   "rgba(0, 156, 255, .5)",
			                   "rgba(0, 156, 255, .4)",
			                   "rgba(0, 156, 255, .3)"
			               ],
			               data: [55, 49, 44, 24, 15]
			           }]
			       },
			       options: {
			           responsive: true
			       }
			   }); */

		})(jQuery);
	</script>
	<script type="text/javascript">
		$(function() {
			$(document).ready(
					function() {
						//비동기 처리
						$.ajax({ // 파일이 아닌 url 주소로 요청을 보냄.
							url : "/3Team_Aasic/chart/singlebarchartjson.jsp",
							type : "GET",
							dataType : "JSON", //POINT
							success : function(data) {

								var boardheader = new Array();
								var boardcnt = new Array();
								$.each(data, function(index, obj) {
									boardheader[index] = obj.boardheader

								});

								$.each(data, function(index, obj) {
									boardcnt[index] = parseInt(obj.boardcnt)

								});


								// Single Bar Chart
								var ctx4 = $("#bar-chart").get(0).getContext("2d");
								var myChart4 = new Chart(ctx4,
										{
											type : "bar",
											data : {
												labels : boardheader,
												datasets : [ {
													backgroundColor : [ "rgba(0, 156, 255, .7)",
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
                     url : "/3Team_Aasic/chart/checkvisitorjson.jsp",
                     type : "GET",
                     dataType : "JSON", //POINT
                     success : function(data) {

                        var perdate = new Array();
                        var boardcnt = new Array();
                        var visitor = new Array();
                        
                        
                        $.each(data, function(index, obj) {
                           perdate[index] = obj.perdate
                        });
                        
                        $.each(data, function(index, obj) {
                           boardcnt[index] = parseInt(obj.boardcnt)
                        });
                        
                        $.each(data, function(index, obj) {
                           visitor[index] = parseInt(obj.visitor)
                        });


                        // Worldwide Sales Chart
                         var ctx1 = $("#worldwide-sales").get(0).getContext("2d");
                         var myChart1 = new Chart(ctx1, {
                             type: "bar",
                             data: {
                                 labels: perdate,
                                 datasets: [{
                                         label: "방문자 수",
                                         data: visitor,
                                         backgroundColor: "rgba(0, 156, 255, .7)"
                                     },
                                     {
                                         label: "게시글 수",
                                         data: boardcnt,
                                         backgroundColor: "rgba(0, 156, 255, .5)"
                                     },
                                    
                                 ]
                                 },
                             options: {
                                 responsive: true
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