<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <div class="container-xxl position-relative bg-white d-flex p-0">
        <!-- Spinner Start -->
        <div id="spinner" class="show bg-white position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
            <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
                <span class="sr-only">Loading...</span>
            </div>
        </div>
        <!-- Spinner End -->



<!-- 
 <li><a href="boardList.user?boardname=트러블슈팅">트러블슈팅</a></li>
					<li><a href="boardList.user?boardname=질문과답변">질문과답변</a></li>
					<li><a href="boardList.user?boardname=프로젝트모집">프로젝트모집</a></li>
					<li><a href="boardList.user?boardname=자유게시판">자유게시판</a></li>
					<li><a href="boardList.user?boardname=공지사항">공지사항</a></li>
 -->

        <!-- Sidebar Start -->
        <div class="sidebar pe-4 pb-3">
            <nav class="navbar bg-light navbar-light">
                <a href="index2.jsp" class="navbar-brand mx-4 mb-3">
                    <h3 class="text-primary"><i class="fa fa-hashtag me-2"></i>극락조 화이팅~</h3>
                </a>
                <div class="d-flex align-items-center ms-4 mb-4">
                    <div class="position-relative">
                        <img class="rounded-circle" src="img/user.jpg" alt="" style="width: 40px; height: 40px;">
                        <div class="bg-success rounded-circle border border-2 border-white position-absolute end-0 bottom-0 p-1"></div>
                    </div>
                    <div class="ms-3">
                        <h6 class="mb-0">Jhon Doe</h6>
                        <span>Admin</span>
                    </div>
                </div>
                <div class="navbar-nav w-100">
                    <a href="index.html" class="nav-item nav-link active"><i class="fa fa-tachometer-alt me-2"></i>메인</a>
                    
                    <a href="boardList.user?boardname=트러블슈팅" class="nav-item nav-link"><i class="fa fa-tachometer-alt me-2"></i>트러블슈팅</a>
                    <a href="boardList.user?boardname=질문과답변" class="nav-item nav-link"><i class="fa fa-th me-2"></i>질문과답변</a>
                    <a href="boardList.user?boardname=프로젝트모집" class="nav-item nav-link"><i class="fa fa-keyboard me-2"></i>프로젝트모집</a>
                    <a href="boardList.user?boardname=자유게시판" class="nav-item nav-link"><i class="fa fa-table me-2"></i>자유게시판</a>
                    <a href="boardList.user?boardname=공지사항" class="nav-item nav-link"><i class="fa fa-chart-bar me-2"></i>공지사항</a>
        
                    </div>
                </div>
            </nav>
        </div>
        <!-- Sidebar End -->