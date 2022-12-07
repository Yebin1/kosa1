<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <!-- Navbar Start -->
            <nav class="navbar navbar-expand bg-light navbar-light sticky-top px-4 py-0">
                <a href="index.do" class="navbar-brand d-flex d-lg-none me-4">
                    <h2 class="text-primary mb-0"><i class="fa fa-hashtag"></i></h2>
                </a>
                <a href="#" class="sidebar-toggler flex-shrink-0">
                    <i class="fa fa-bars"></i>
                </a>
                <form class="d-none d-md-flex ms-4" action="searchWord.do" name="searchWord" id="searchWord" method="post">
	<input class="form-control border-0" type="search" name="searchWord" id="searchWord" placeholder="Search">
	<input class="btn btn-outline-primary m-2" type="submit" value="Search">
</form>
                <div class="navbar-nav align-items-center ms-auto">
                 <a href="logout.do" class="dropdown-item"><small>Log Out</small></a>
                    
                
                    <div class="nav-item dropdown">
                        <a href="#" class="nav-link dropdown-toggle" data-bs-toggle="dropdown">
<!--                             <img class="rounded-circle me-lg-2" src="images/dayoung.jpg" alt="" style="width: 40px; height: 40px;">
 -->                            <span class="d-none d-lg-inline-flex">${sessionScope.userid}</span>
                        </a>
                        <div class="dropdown-menu dropdown-menu-end bg-light border-0 rounded-0 rounded-bottom m-0">
                            <a href="userEditInfo.user?userid=${sessionScope.userid}" class="dropdown-item">회원정보 수정</a>
                            <a href="myboardList.user" class="dropdown-item">나의 활동</a>
                            <a href="bookMarksList.user" class="dropdown-item">나의 북마크</a>
                            <a href="userDelete.do" class="dropdown-item">탈퇴하기</a>
                            <a href="logout.do" class="dropdown-item">Log Out</a>
                        </div>
                    </div>
                </div>
            </nav>
            <!-- Navbar End -->