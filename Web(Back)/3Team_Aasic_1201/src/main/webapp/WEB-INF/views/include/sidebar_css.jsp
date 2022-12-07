<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
    
    
    <div class="links">        
    <c:choose>
			<c:when test="${sessionScope.userid ne null}">
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
        <a href="index.user"><img src="images/KINGBIRD.png" style="width:200px; padding-left:20px; padding-top:8px; padding-bottom:15px;"></a>
            <nav class="navbar bg-light navbar-light">
                <div class="navbar-nav w-100">
                    <a href="index.do" class="nav-item nav-link active"><i class="fa fa-tachometer-alt me-2"></i>홈</a>
                    
                    <a href="boardList.user?boardname=트러블슈팅" class="nav-item nav-link"><i class="fa fa-tachometer-alt me-2"></i>트러블슈팅</a>
                    <a href="boardList.user?boardname=질문과답변" class="nav-item nav-link"><i class="fa fa-th me-2"></i>질문과답변</a>
                    <a href="boardList.user?boardname=프로젝트모집" class="nav-item nav-link"><i class="fa fa-keyboard me-2"></i>프로젝트모집</a>
                    <a href="boardList.user?boardname=자유게시판" class="nav-item nav-link"><i class="fa fa-table me-2"></i>자유게시판</a>
                    <a href="boardList.user?boardname=공지사항" class="nav-item nav-link"><i class="fa fa-chart-bar me-2"></i>공지사항</a>
        
                    </div>
                </div>
            </nav>
        </div>
				
			</c:when>
    		<c:otherwise>
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
        <a href="index.do"><img src="images/KINGBIRD로고.png" style="width:200px; padding-left:20px; padding-top:8px; padding-bottom:15px;"></a>
            <nav class="navbar bg-light navbar-light">
                <div class="navbar-nav w-100">
                    <a href="index.do" class="nav-item nav-link active"><i class="fa fa-tachometer-alt me-2"></i>홈</a>
                    
                    <a href="login.do" class="nav-item nav-link"><i class="fa fa-tachometer-alt me-2"></i>트러블슈팅</a>
                    <a href="login.do" class="nav-item nav-link"><i class="fa fa-th me-2"></i>질문과답변</a>
                    <a href="login.do" class="nav-item nav-link"><i class="fa fa-keyboard me-2"></i>프로젝트모집</a>
                    <a href="login.do" class="nav-item nav-link"><i class="fa fa-table me-2"></i>자유게시판</a>
                    <a href="login.do" class="nav-item nav-link"><i class="fa fa-chart-bar me-2"></i>공지사항</a>
        
                    </div>
                </div>
            </nav>
        </div>
			</c:otherwise>
		</c:choose>
    
    
    

        </div>