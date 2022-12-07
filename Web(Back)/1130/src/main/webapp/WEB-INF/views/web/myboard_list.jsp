<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>나의 활동</title>
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
    <style>
       th, td {
        text-align: center;
      }
    </style>
</head>
<body>
      <!-- 사이드바 들어갈 자리 -->
      <jsp:include page="/WEB-INF/views/include/sidebar_css.jsp"></jsp:include>
      <!-- Content Start -->
      <div class="content">
      <!-- 헤더 -->
      <jsp:include page="/WEB-INF/views/include/userheader_css.jsp"></jsp:include>
	
	<c:set var="pagesize" value="${requestScope.pagesize}" />
	<c:set var="cpage" value="${requestScope.cpage}" />
	<c:set var="pagecount" value="${requestScope.pagecount}" />
	<c:set var="myList" value="${requestScope.myList}" />
	<c:set var="totalboardcount" value="${requestScope.totalboardcount}" />
	<c:set var="userid" value="${requestScope.userid}" />

	<div id="pagecontainer">
		<div class="bg-light rounded h-100 p-4">
		<h4 class="mb-4"><b>내가 쓴<span style="color:#2C91F7;"> 게시물</span></b></h4><br>
			<table class="table" width="80%" cellspacing="0" align="center">
				<tr>
					<td colspan="6">
						<form name="myList">
							 <select class="form-select form-select-sm mb-3" aria-label=".form-select-sm example" 
							 name="ps" onchange="submit()" style="width:100px;">
								<c:forEach var="i" begin="5" end="20" step="5">
									<c:choose>
										<c:when test="${pagesize == i}">
											<option value="${i}" selected>${i}건</option>
										</c:when>
										<c:otherwise>
											<option value="${i}">${i}건</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
						</form>
					</td>
				</tr>
				<tr>
					<th width="10%">순번</th>
					<th width="15%">게시판</th>
					<th width="40%">제목</th>
					<th width="15%">날짜</th>
					<th width="10%">추천수</th>
					<th width="10%">조회수</th>
				</tr>
				<c:forEach var="board" items="${myList}">
					<tr onmouseover="this.style.backgroundColor='skyblue'"
						onmouseout="this.style.backgroundColor='white'">
						<td align="center">${board.idx}</td>
						<td align="center">${board.boardname}</td>
						<td align="left"><a
							href="boardContent.user?boardname=${boardname}&idx=${board.idx}&cp=${cpage}&ps=${pagesize}">
								<c:choose>
									<c:when
										test="${board.title != null && fn:length(board.title) > 20}">
										${fn:substring(board.title,0,20)}...
									</c:when>
									<c:otherwise>
										${board.title}
									</c:otherwise>
								</c:choose>
						</a></td>
						<%-- <td align="center">${board.userid}</td> --%>
						<td align="center">${board.writedate}</td>
						<td align="center">${board.lovenum}</td>
						<td align="center">${board.readnum}</td>
					</tr>
				</c:forEach>
				<!-- forEach()  -->
				<tr>
					<td colspan="6" align="center">
						<hr width="100%" color="red">
					</td>
				</tr>
				<tr>
					<td colspan="3" align="center">
						<!--이전 링크 --> <c:if test="${cpage > 1}">
							<a
								href="myboardList.user?&userid=${userid}&cp=${cpage-1}&ps=${pagesize}">이전</a>
						</c:if> <!-- page 목록 나열하기 --> <c:forEach var="i" begin="1"
							end="${pagecount}" step="1">
							<c:choose>
								<c:when test="${cpage==i}">
									<font color="red">[${i}]</font>
								</c:when>
								<c:otherwise>
									<a
										href="myboardList.user?cp=${i}&ps=${pagesize}">[${i}]</a>
								</c:otherwise>
							</c:choose>
						</c:forEach> <!--다음 링크 --> <c:if test="${cpage < pagecount}">
							<a
								href="myboardList.user?&userid=${userid}&cp=${cpage+1}&ps=${pagesize}">다음</a>
						</c:if>
					</td>
					<td colspan="3" align="center">총 게시물 수 : ${totalboardcount}</td>
				</tr>
				<tr>
					<td colspan="6" align="center"></td>
			</table>
		</div>
	</div>
	<div>
		 <button type="button" class="btn btn-primary rounded-pill m-2" onclick="location.href='myreplyList.user';">내가 쓴 댓글</button>
		<!-- <a href="myreplyList.user">댓글 목록 보기</a> -->
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