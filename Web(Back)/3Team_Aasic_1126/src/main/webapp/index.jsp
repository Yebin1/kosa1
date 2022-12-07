<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <title>Kingbird</title>
    	<meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 
Flex Template 
http://www.templatemo.com/tm-406-flex
-->
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
        
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/font-awesome.css">
        <link rel="stylesheet" href="css/animate.css">
        <link rel="stylesheet" href="css/templatemo_misc.css">
        <link rel="stylesheet" href="css/templatemo_style.css">

        <script src="js/vendor/modernizr-2.6.1-respond-1.1.0.min.js"></script>
    </head>
    <body>
        <!--[if lt IE 7]>
            <p class="chromeframe">You are using an outdated browser. <a href="http://browsehappy.com/">Upgrade your browser today</a> or <a href="http://www.google.com/chromeframe/?redirect=true">install Google Chrome Frame</a> to better experience this site.</p>
        <![endif]-->


        <div class="site-main" id="sTop">
            <div class="site-header">
            <div>
               <!--  <div class="container"> -->
                    <!-- <div class="row">
                        <div class="col-md-12 text-center">
                            <ul class="social-icons">
                                <li><a href="#" class="fa fa-facebook"></a></li>
                                <li><a href="#" class="fa fa-twitter"></a></li>
                                <li><a href="#" class="fa fa-dribbble"></a></li>
                                <li><a href="#" class="fa fa-linkedin"></a></li>
                            </ul>
                        </div> /.col-md-12
                    </div> --> <!-- /.row -->
                </div> <!-- /.container -->
                <div class="main-header">
                    <div class="container">
                        <div id="menu-wrapper">
                            <div class="row">
                                <div class="logo-wrapper col-md-2 col-sm-2">
                                    <h1>
                                        <a href="#">KINGBIRD</a>
                                    </h1>
                                </div> <!-- /.logo-wrapper -->
                                <div class="col-md-10 col-sm-10 main-menu text-right">
                                    <div class="toggle-menu visible-sm visible-xs"><i class="fa fa-bars"></i></div>
                                    <ul class="menu-first">
                                         <li class="active"><a href="boardList.user?boardname=트러블슈팅">트러블슈팅</a></li>
                                        <li><a href="boardList.user?boardname=질문과답변">질문과답변</a></li>
                                        <li><a href="boardList.user?boardname=프로젝트모집">프로젝트</a></li>
                                        <li><a href="boardList.user?boardname=자유게시판">자유</a></li>
                                        <li><a href="boardList.user?boardname=공지사항" class="external" target="_parent" rel="nofollow">공지사항</a></li> 
                                        <li><a href="myboardList.user">마이페이지</a></li>                           
                                    </ul>                                    
                                </div> <!-- /.main-menu -->
                            </div> <!-- /.row -->
                        </div> <!-- /#menu-wrapper -->                        
                    </div> <!-- /.container -->
                </div> <!-- /.main-header -->
            </div> <!-- /.site-header -->
            
            <!-- <div class="site-slider">
                <div class="slider">
                    <div class="flexslider">
                        <ul class="slides">
                            <li>
                                <div class="overlay"></div>
                                <img src="images/.jpg" alt="">
                                <div class="slider-caption visible-md visible-lg">
                                    <h2>유일한 개발자를 위한 커뮤니티</h2>
                                    <p>KingBird와 함께 하세요</p>
                                    <a href="#" class="slider-btn">Let us design!</a>
                                </div>
                            </li>
                            <li>
                                <div class="overlay"></div>
                                <img src="images/개발자.webp" alt="">
                                <div class="slider-caption visible-md visible-lg">
                                    <h2>지금 가입하세요</h2>
                                    <p>JOIN US</p>
                                    <a href="#" class="slider-btn">Go to Portfolio</a>
                                </div>
                            </li>
                            <li>
                                <div class="overlay"></div>
                                <img src="images/111.png" alt="">
                                <div class="slider-caption visible-md visible-lg">
                                    <h2>Pro Level Design</h2>
                                    <p>인간의 수준을 넘어선 디자인</p>
                                    <a href="#" class="slider-btn">Mobile Website</a>
                                </div>
                            </li>
                        </ul>
                    </div> /.flexslider
                </div> /.slider
            </div> --> <!-- /.site-slider -->
        </div> <!-- /.site-main -->
        
        
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
        


        <div class="content-section" id="services">
            <div class="container">
                <div class="row">
                    <div class="heading-section col-md-12 text-center">
                        <h2><span style="color:red;">HOT</span> BOARD</h2>
                        <p></p>
                    </div> <!-- /.heading-section -->
                </div> <!-- /.row -->
                <div class="row">
                    <div class="col-md-3 col-sm-6">
                        <div class="service-item" id="service-1">
                            <div class="service-icon">
                                <i class="fa fa-file-code-o"></i>
                            </div> <!-- /.service-icon -->
                            <div class="service-content">
                                <div class="inner-service">
                                   <h3>HTML5 Coding</h3>
                                   <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Enim, assumenda, eveniet, consectetur, ex doloribus veniam asperiores incidunt mollitia placeat aniet.</p> 
                                </div>
                            </div> <!-- /.service-content -->
                        </div> <!-- /#service-1 -->
                    </div> <!-- /.col-md-3 -->
                    <div class="col-md-3 col-sm-6">
                        <div class="service-item" id="service-2">
                            <div class="service-icon">
                                <i class="fa fa-paper-plane-o"></i>
                            </div> <!-- /.service-icon -->
                            <div class="service-content">
                                <div class="inner-service">
                                   <h3>Our Support</h3>
                                   <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Enim, assumenda, eveniet, consectetur, ex doloribus veniam asperiores incidunt mollitia placeat aniet.</p> 
                                </div>
                            </div> <!-- /.service-content -->
                        </div> <!-- /#service-1 -->
                    </div> <!-- /.col-md-3 -->
                    <div class="col-md-3 col-sm-6">
                        <div class="service-item" id="service-3">
                            <div class="service-icon">
                                <i class="fa fa-institution"></i>
                            </div> <!-- /.service-icon -->
                            <div class="service-content">
                                <div class="inner-service">
                                   <h3>Our Design</h3>
                                   <p>We make HTML CSS templates that are responsive for any screen size on any device. Feel free to download and use our templates without restrictions.</p> 
                                </div>
                            </div> <!-- /.service-content -->
                        </div> <!-- /#service-1 -->
                    </div> <!-- /.col-md-3 -->
                    <div class="col-md-3 col-sm-6">
                        <div class="service-item" id="service-4">
                            <div class="service-icon">
                                <i class="fa fa-flask"></i>
                            </div> <!-- /.service-icon -->
                            <div class="service-content">
                                <div class="inner-service">
                                   <h3>Go for mobile</h3>
                                   <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Enim, assumenda, eveniet, consectetur, ex doloribus veniam asperiores incidunt mollitia placeat aniet.</p> 
                                </div>
                            </div> <!-- /.service-content -->
                        </div> <!-- /#service-1 -->
                    </div> <!-- /.col-md-3 -->
                </div> <!-- /.row -->
            </div> <!-- /.container -->
        </div> <!-- /#services -->


		
        <!-- <div class="content-section" id="portfolio">
            <div class="container">
                <div class="row">
                    <div class="heading-section col-md-12 text-center">
                        <h2>Our Portfolio</h2>
                        <p>Amazing work for our clients</p>
                    </div> /.heading-section
                </div> /.row
                <div class="row">
                    <div class="portfolio-item col-md-3 col-sm-6">
                        <div class="portfolio-thumb">
                            <img src="images/gallery/p1.jpg" alt="">
                            <div class="portfolio-overlay">
                                <h3>New Walk</h3>
                                <p>Asperiores commodi illo fuga perferendis dolore repellendus sapiente ipsum.</p>
                                <a href="images/gallery/p1.jpg" data-rel="lightbox" class="expand">
                                    <i class="fa fa-search"></i>
                                </a>
                            </div> /.portfolio-overlay
                        </div> /.portfolio-thumb
                    </div> /.portfolio-item
                    <div class="portfolio-item col-md-3 col-sm-6">
                        <div class="portfolio-thumb">
                            <img src="images/gallery/p2.jpg" alt="">
                            <div class="portfolio-overlay">
                                <h3>Boat</h3>
                                <p>Asperiores commodi illo fuga perferendis dolore repellendus sapiente ipsum.</p>
                                <a href="images/gallery/p2.jpg" data-rel="lightbox" class="expand">
                                    <i class="fa fa-search"></i>
                                </a>
                            </div> /.portfolio-overlay
                        </div> /.portfolio-thumb
                    </div> /.portfolio-item
                    <div class="portfolio-item col-md-3 col-sm-6">
                        <div class="portfolio-thumb">
                            <img src="images/gallery/p7.jpg" alt="">
                            <div class="portfolio-overlay">
                                <h3>Urban</h3>
                                <p>Asperiores commodi illo fuga perferendis dolore repellendus sapiente ipsum.</p>
                                <a href="images/gallery/p7.jpg" data-rel="lightbox" class="expand">
                                    <i class="fa fa-search"></i>
                                </a>
                            </div> /.portfolio-overlay
                        </div> /.portfolio-thumb
                    </div> /.portfolio-item
                    <div class="portfolio-item col-md-3 col-sm-6">
                        <div class="portfolio-thumb">
                            <img src="images/gallery/p8.jpg" alt="">
                            <div class="portfolio-overlay">
                                <h3>Cycling</h3>
                                <p>Asperiores commodi illo fuga perferendis dolore repellendus sapiente ipsum.</p>
                                <a href="images/gallery/p8.jpg" data-rel="lightbox" class="expand">
                                    <i class="fa fa-search"></i>
                                </a>
                            </div> /.portfolio-overlay
                        </div> /.portfolio-thumb
                    </div> /.portfolio-item
                    <div class="portfolio-item col-md-3 col-sm-6">
                        <div class="portfolio-thumb">
                            <img src="images/gallery/p3.jpg" alt="">
                            <div class="portfolio-overlay">
                                <h3>Digital Era</h3>
                                <p>Asperiores commodi illo fuga perferendis dolore repellendus sapiente ipsum.</p>
                                <a href="images/gallery/p3.jpg" data-rel="lightbox" class="expand">
                                    <i class="fa fa-search"></i>
                                </a>
                            </div> /.portfolio-overlay
                        </div> /.portfolio-thumb
                    </div> /.portfolio-item
                    <div class="portfolio-item col-md-3 col-sm-6">
                        <div class="portfolio-thumb">
                            <img src="images/gallery/p4.jpg" alt="">
                            <div class="portfolio-overlay">
                                <h3>Horizon</h3>
                                <p>Asperiores commodi illo fuga perferendis dolore repellendus sapiente ipsum.</p>
                                <a href="images/gallery/p4.jpg" data-rel="lightbox" class="expand">
                                    <i class="fa fa-search"></i>
                                </a>
                            </div> /.portfolio-overlay
                        </div> /.portfolio-thumb
                    </div> /.portfolio-item
                    <div class="portfolio-item col-md-3 col-sm-6">
                        <div class="portfolio-thumb">
                            <img src="images/gallery/p5.jpg" alt="">
                            <div class="portfolio-overlay">
                                <h3>Aquatic City</h3>
                                <p>Asperiores commodi illo fuga perferendis dolore repellendus sapiente ipsum.</p>
                                <a href="images/gallery/p5.jpg" data-rel="lightbox" class="expand">
                                    <i class="fa fa-search"></i>
                                </a>
                            </div> /.portfolio-overlay
                        </div> /.portfolio-thumb
                    </div> /.portfolio-item
                    <div class="portfolio-item col-md-3 col-sm-6">
                        <div class="portfolio-thumb">
                            <img src="images/gallery/p6.jpg" alt="">
                            <div class="portfolio-overlay">
                                <h3>New Path</h3>
                                <p>Asperiores commodi illo fuga perferendis dolore repellendus sapiente ipsum.</p>
                                <a href="images/gallery/p6.jpg" data-rel="lightbox" class="expand">
                                    <i class="fa fa-search"></i>
                                </a>
                            </div> /.portfolio-overlay
                        </div> /.portfolio-thumb
                    </div> /.portfolio-item
                </div> /.row
            </div> /.container
        </div> --> <!-- /#portfolio -->



		<!-- 팀 소개하느 페이지에서 쓰자 -->
        <div class="content-section" id="our-team">
            <div class="container">
                <div class="row">
                    <div class="heading-section col-md-12 text-center">
                        <h2>KINGBIRD회원들의 개발언어</h2>
                        <p>당신의 성공을 응원합니다</p>
                    </div> <!-- /.heading-section -->
                </div> <!-- /.row -->
                <div class="row">
                    <!-- <div class="team-member col-md-3 col-sm-6">
                        <div class="member-thumb">
                            <img src="images/member1.jpg" alt="">
                            <div class="team-overlay">
                                <h3>Tracy</h3>
                                <span>Designer</span>
                                <ul class="social">
                                    <li><a href="#" class="fa fa-facebook"></a></li>
                                    <li><a href="#" class="fa fa-twitter"></a></li>
                                    <li><a href="#" class="fa fa-linkedin"></a></li>
                                </ul>
                            </div> /.team-overlay
                        </div> /.member-thumb
                    </div> /.team-member
                    <div class="team-member col-md-3 col-sm-6">
                        <div class="member-thumb">
                            <img src="images/member2.jpg" alt="">
                            <div class="team-overlay">
                                <h3>Cindy</h3>
                                <span>Developer</span>
                                <ul class="social">
                                    <li><a href="#" class="fa fa-facebook"></a></li>
                                    <li><a href="#" class="fa fa-twitter"></a></li>
                                    <li><a href="#" class="fa fa-linkedin"></a></li>
                                </ul>
                            </div> /.team-overlay
                        </div> /.member-thumb
                    </div> /.team-member
                    <div class="team-member col-md-3 col-sm-6">
                        <div class="member-thumb">
                            <img src="images/member3.jpg" alt="">
                            <div class="team-overlay">
                                <h3>Mary</h3>
                                <span>Director</span>
                                <ul class="social">
                                    <li><a href="#" class="fa fa-facebook"></a></li>
                                    <li><a href="#" class="fa fa-twitter"></a></li>
                                    <li><a href="#" class="fa fa-linkedin"></a></li>
                                </ul>
                            </div> /.team-overlay
                        </div> /.member-thumb
                    </div> /.team-member
                    <div class="team-member col-md-3 col-sm-6">
                        <div class="member-thumb">
                            <img src="images/member4.jpg" alt="">
                            <div class="team-overlay">
                                <h3>Linda</h3>
                                <span>Chief Executive</span>
                                <ul class="social">
                                    <li><a href="#" class="fa fa-facebook"></a></li>
                                    <li><a href="#" class="fa fa-twitter"></a></li>
                                    <li><a href="#" class="fa fa-linkedin"></a></li>
                                </ul>
                            </div> /.team-overlay
                        </div> /.member-thumb
                    </div> /.team-member -->
                </div> <!-- /.row -->
                <div class="row">
                    <div class="col-md-12 text-center">
                        <div class="skills-heading">
                            <h3 class="skills-title">Develope Skills</h3>
                            <p class="small-text">이 차트는 현재 개발시장의 트렌드와 앞으로의 개발언어 트렌드를 예상하도록 도와줍니다</p>
                        </div>
                    </div> <!-- /.col-md-12 -->
                </div> <!-- /.row -->
                <div class="row">
                    <div class="col-md-8 col-sm-6">
                        <p>현재 KINGBIRD 회원들 사이에서 가장 많이 쓰이는 개발언어<br><br>
						국재 개발자 시장을 정확히 분석, 가장 완벽한 국내 개발 시장 분석<br><br>
						</p>
                    </div> <!-- /.col-md-8 -->
                    <div class="col-md-4 col-sm-6">
                        <ul class="progess-bars">
                            <li>
                                <div class="progress">
                                    <div class="progress-bar" role="progressbar" aria-valuenow="90" aria-valuemin="0" aria-valuemax="100" style="width: 90%;">Photoshop 90%</div>
                                </div>
                            </li>
                            <li>
                                <div class="progress">
                                    <div class="progress-bar" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%;">HTML CSS 80%</div>
                                </div>
                            </li>
                            <li>
                                <div class="progress">
                                    <div class="progress-bar" role="progressbar" aria-valuenow="70" aria-valuemin="0" aria-valuemax="100" style="width: 70%;">Development 70%</div>
                                </div>
                            </li>
                            <li>
                                <div class="progress">
                                    <div class="progress-bar" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%;">Marketing 80%</div>
                                </div>
                            </li>
                        </ul>
                    </div> <!-- /.col-md-4 -->
                </div> <!-- /.row -->
            </div> <!-- /.container -->
        </div> <!-- /#our-team -->


	<!-- 지도포함한 컨택트 DIV -->
        <!-- <div class="content-section" id="contact">
            <div class="container">
                <div class="row">
                    <div class="heading-section col-md-12 text-center">
                        <h2>Contact</h2>
                        <p>Send a message to us</p>
                    </div> /.heading-section
                </div> /.row
                <div class="row">
                    <div class="col-md-12">
                       <div class="googlemap-wrapper">
                            <div id="map_canvas" class="map-canvas"></div>
                        </div> /.googlemap-wrapper
                    </div> /.col-md-12
                </div> /.row
                <div class="row">
                    <div class="col-md-7 col-sm-6">
                        <p>Flex is a Bootstrap v3.1.1 HTML CSS web template by <span class="blue">template</span><span class="green">mo</span>. Slider images and portfolio images are from <a rel="nofollow" href="http://unsplash.com" target="_parent">Unsplash</a> website. Thank you for visiting. Please tell your friends about templatemo.<br><br>
                        Hic, suscipit, praesentium earum quod ea distinctio impedit ullam deserunt minus dolore quibusdam quis saepe aliquam doloribus voluptatibus eum excepturi. Aenean semper erat neque. Nunc et scelerisque nunc, in adipiscing magna.<br><br>
				    Duis ullamcorper tortor tellus. Ut diam libero, ultricies non augue a, mollis congue risus. Fusce a quam eget nisi luctus imperdiet. Consectetur quod at aperiam corporis totam. Nesciunt minima laborum sapiente totam facere unde est cum quia. 
                    	</p>
                        <ul class="contact-info">
                            <li>Phone: 033-033-0660</li>
                            <li>Email: <a href="mailto:info@company.com">info@company.com</a></li>
                            <li>Address: 880 De Best Studio, Fork Street, San Francisco</li>
                        </ul>
                        spacing for mobile viewing<br><br>
                    </div> /.col-md-7
                    <div class="col-md-5 col-sm-6">
                        <div class="contact-form">
                            <form method="post" name="contactform" id="contactform">
                                <p>
                                    <input name="name" type="text" id="name" placeholder="Your Name">
                                </p>
                                <p>
                                    <input name="email" type="text" id="email" placeholder="Your Email"> 
                                </p>
                                <p>
                                    <input name="subject" type="text" id="subject" placeholder="Subject"> 
                                </p>
                                <p>
                                    <textarea name="comments" id="comments" placeholder="Message"></textarea>    
                                </p>
                                <input type="submit" class="mainBtn" id="submit" value="Send Message">
                            </form>
                        </div> /.contact-form
                    </div> /.col-md-5
                </div> /.row
            </div> /.container
        </div> --> <!-- /#contact -->
            
        <div id="footer" style="height:120px;background-color:#007FFF;">
            <div class="container">
                <div class="row">
                    <div class="col-md-8 col-xs-12 text-left">
                        <span>Copyright &copy; 2014 Company Name</span>
                  </div> <!-- /.text-center -->
                    <div class="col-md-4 hidden-xs text-right">
                        <a href="#top" id="go-top">Back to top</a>
                    </div> <!-- /.text-center -->
                </div> <!-- /.row -->
            </div> <!-- /.container -->
        </div> <!-- /#footer -->
        
        <script src="js/vendor/jquery-1.11.0.min.js"></script>
        <script>window.jQuery || document.write('<script src="js/vendor/jquery-1.11.0.min.js"><\/script>')</script>
        <script src="js/bootstrap.js"></script>
        <script src="js/plugins.js"></script>
        <script src="js/main.js"></script>

        <!-- Google Map -->
        <script src="http://maps.google.com/maps/api/js?sensor=true"></script>
        <script src="js/vendor/jquery.gmap3.min.js"></script>
        
        <!-- Google Map Init-->
        <script type="text/javascript">
            jQuery(function($){
                $('#map_canvas').gmap3({
                    marker:{
                        address: '37.769725, -122.462154' 
                    },
                        map:{
                        options:{
                        zoom: 15,
                        scrollwheel: false,
                        streetViewControl : true
                        }
                    }
                });

                /* Simulate hover on iPad
                 * http://stackoverflow.com/questions/2851663/how-do-i-simulate-a-hover-with-a-touch-in-touch-enabled-browsers
                 --------------------------------------------------------------------------------------------------------------*/ 
                $('body').bind('touchstart', function() {});
            });
        </script>
        <!-- templatemo 406 flex -->
    </body>
</html>