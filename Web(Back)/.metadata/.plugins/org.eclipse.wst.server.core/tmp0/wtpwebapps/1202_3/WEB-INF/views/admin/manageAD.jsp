<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<title>AD관리</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<meta content="" name="keywords">
<meta content="" name="description">

<!-- Favicon -->
<link href="images/kingbird.ico" rel="icon">
<!-- Google Web Fonts -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Heebo:wght@400;500;600;700&display=swap"
	rel="stylesheet">

<!-- Icon Font Stylesheet -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css"
	rel="stylesheet">

<!-- Libraries Stylesheet -->
<link href="lib/owlcarousel/assets/owl.carousel.min.css"
	rel="stylesheet">
<link href="lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css"
	rel="stylesheet" />

<!-- Customized Bootstrap Stylesheet -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Template Stylesheet -->
<link href="css/style.css" rel="stylesheet">
<style>
th, td {
	text-align: center;
}
</style>
<script src="http://code.jquery.com/jquery-latest.js"></script> 
<script>
$(function(){
 	$(document).on(
	         "click",
	         "#upload",
	         function() {
	            //파일 업로드 비동기처리
	            const content = $('#file').val();

	            if (content == "") {
	               alert("파일을 선택하세요");
	            } else if (confirm("파일을 업로드 하시겠습니까?") == true) { //확인
	               //비동기 함수 호출

	               $.ajax({
	                  url : "ADupload.admin", //보낼 URL
	                  type : "GET", //보내는 방식
	                  dataType : "html", //데이터 타입
	                  data : {
	                     'file' : $('#file').val(), //업로드한 파일
	                  },
	                  success : function(element) {
	                	 $('#preview').empty();
	                     $('#preview').append(element); //미리보기 div에 추가
	                  },
	                  error : function(request, status, error) { //에러 
	                     alert("code:" + request.status + "\n"
	                           + "message:" + request.responseText
	                           + "\n" + "error:" + error);
	                  }
	               });
	            } else { //취소
	               alert("업로드 취소");
	               return false;
	            }
	         });
}); 

</script>
</head>
<body>
	<!-- 사이드바 들어갈 자리 -->
	<jsp:include page="/WEB-INF/views/include/adminsidebar_css.jsp"></jsp:include>
	<!-- Content Start -->
	<div class="content">
		<!-- 헤더 -->
		<jsp:include page="/WEB-INF/views/include/adminheader_css.jsp"></jsp:include>

		<c:set var="categoryList" value="${requestScope.categoryList}" />
		<c:set var="totalcount" value="${requestScope.totalcount}" />

		<div id="pagecontainer">
			<div class="bg-light rounded h-100 p-4">
				<h4 class="mb-4">
					<b><span style="color: #2C91F7;">KINGBIRD </span>AD관리</b>
				</h4>
				<br>
			</div>
			
<!-- 			<form name="bbs" action="ADupload.admin" method="POST" enctype="multipart/form-data">
 -->            <h6>업로드 할<span style="color: #2C91F7;"> AD</span> 파일 #1</h6>
         
            <span><input type="file" name="file" class="form-control" id="formFile" style="width:400px; margin-right:0px"></span>
            
            <span><button class="btn btn-primary rounded-pill m-2" id="upload">업로드</button></span>
            파일 명 : ${requestScope.filename}
            <div><b>미리보기</b></div>
            <div id="preview">
            	<jsp:include page="/WEB-INF/views/web/file_preview.jsp"></jsp:include>
            </div>
            
			<h6>업로드 할<span style="color: #2C91F7;"> AD</span> 파일 #2</h6>
            <div width="90%" align="left">
            	<input type="file" name="file2" class="form-control" id="formFile" style="width:400px; margin-bottom:20px;">
            </div>
            <h6>업로드 할<span style="color: #2C91F7;"> AD</span> 파일 #3</h6>
            <div width="90%" align="left">
            	<input type="file" name="file3" class="form-control" id="formFile" style="width:400px; margin-bottom:20px;">
            </div>
            <h6>업로드 할<span style="color: #2C91F7;"> AD</span> 파일 #4</h6>
            <div width="90%" align="left">
            	<input type="file" name="file4" class="form-control" id="formFile" style="width:400px; margin-bottom:20px;">
            </div>
            <!--  </form> -->
		</div>
		<!-- Footer Start -->
		<jsp:include page="/WEB-INF/views/include/footer_css.jsp"></jsp:include>
		<!-- Footer End -->
	</div>
	<!-- Content End -->


	<!-- Back to Top -->
	<a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top">
	<i class="bi bi-arrow-up"></i></a>
	</div>

	<!-- JavaScript Libraries -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
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