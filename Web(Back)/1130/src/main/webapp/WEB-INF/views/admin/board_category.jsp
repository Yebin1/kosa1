<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<title>게시판 관리</title>
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
					<b>KINGBIRD<span style="color: #2C91F7;"> 게시판 목록</span></b>
				</h4>
				<br>
				<table class="table" width="80%" cellspacing="0" align="center">

					<tr>
						<th width="60%">게시판</th>
						<th width="20%">삭제 대기글</th>
						<th width="20%">대기글 삭제</th>
					</tr>
					<c:forEach var="category" items="${categoryList}">
						<tr onmouseover="this.style.backgroundColor='skyblue'" onmouseout="this.style.backgroundColor='white'">
							<td align="center" colspan="1"><a href="boardList.user?boardname=${category.boardname}">${category.boardname}</a>
							</td>
							<td colspan="1">
							<c:forEach var="count" items="${count}">
							<c:if test="${count.key eq category.boardname}"><a href="statusZero.admin?boardname=${category.boardname}">
							${count.value}</a>
							</c:if>
							</c:forEach>
							</td>
							
							<td colspan="3"><button type="button" class="btn btn-primary rounded-pill m-2"
								onclick="location.href='myreplyList.user';">삭제</button></td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="1" align="center">전체</td>
						<td colspan="1" align="center">${totalcount}</td>
						<td colspan="3"><button type="button" class="btn btn-primary rounded-pill m-2"
								onclick="location.href='myreplyList.user';">삭제</button></td>
					</tr>

				</table>
			</div>
		</div>
		<!-- Footer Start -->
		<jsp:include page="/WEB-INF/views/include/footer_css.jsp"></jsp:include>
		<!-- Footer End -->
	</div>
	<!-- Content End -->


	<!-- Back to Top -->
	<a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i
		class="bi bi-arrow-up"></i></a>
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