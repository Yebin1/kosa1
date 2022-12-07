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


        <!-- Sidebar Start -->
        <div class="sidebar pe-4 pb-3">
        <a href="adminMain.admin"><img src="images/KINGBIRD.png" style="width:200px; padding-left:20px; padding-top:8px; padding-bottom:15px;"></a>
            <nav class="navbar bg-light navbar-light">
               
               
                <div class="navbar-nav w-100">
                    <a href="adminMain.admin" class="nav-item nav-link active"><i class="fa fa-tachometer-alt me-2"></i>메인</a>
                    <a href="userDelete.admin" class="nav-item nav-link"><i class="fa fa-th me-2"></i>사용자 관리</a>
                    <a href="adminCategory.admin" class="nav-item nav-link"><i class="fa fa-keyboard me-2"></i>게시판 관리</a>
                    <a href="table.html" class="nav-item nav-link"><i class="fa fa-table me-2"></i>이벤트 AD 관리</a>
                    <a href="chart.html" class="nav-item nav-link"><i class="fa fa-chart-bar me-2"></i>쪽지관리</a>
                    <a href="chart.html" class="nav-item nav-link"><i class="fa fa-chart-bar me-2"></i>시스템 관리</a>
                   
                </div>
            </nav>
        </div>
        <!-- Sidebar End -->