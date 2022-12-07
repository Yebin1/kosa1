<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%@page import="kr.or.kosa.dto.Reply"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.kosa.dto.Board"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>ADMIN Delete</title>
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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    
    <!-- 다영 회원 활성/비활성 토글 함수 -->
    <script type="text/javascript">
	$(function(){
		  $(document).on(
	    	    "click",
	    	     "#activation",
	    	      function() { 
	    	    	console.log();
	    	       $.ajax({
			    	           url: "activation.admin",
			    	           type: "POST",
			    	           dataType: "html",
			    	           data : {
			    	           userid : $(this).attr("userid"),
			    	           status : $(this).attr("status") 
			    	           //앞에 꺼가 service로 보내서 getParameter('')안에 들어갈 변수

	    	             		},
	    	              success:function(data){
	    	            	  location.href = "activation_delete.admin";
	    	              },
	    	              error:function(request,status,error){
	    	              alert("비활성화 실패");
	    	              alert("code:" +request.status+"\n" + "message:"+request.responseText+"\n"+"error:"+error);
	    	              }
	    	        });
	    	    });

 	}); 
 </script>
</head>

<body>

	<c:set var="pagesize" value="${requestScope.pagesize}" />
	<c:set var="cpage" value="${requestScope.cpage}" />
	<c:set var="pagecount" value="${requestScope.pagecount}" />
	<c:set var="searchUseridList" value="${requestScope.searchUseridList}" />
	<c:set var="totalsearchcount" value="${requestScope.totalsearchcount}" />
	<c:set var="pager" value="${requestScope.pager}" />
	<c:set var="searchUserid" value="${requestScope.searchUserid}" />
	<c:set var="member" value="${requestScope.member}" />


		<!-- 사이드바 들어갈 자리 -->
		<jsp:include page="/WEB-INF/views/include/adminsidebar_css.jsp"></jsp:include>
        <!-- Content Start -->
        <div class="content">
        <!-- 헤더 -->
        <jsp:include page="/WEB-INF/views/include/adminheader_css.jsp"></jsp:include>
    

<!-- content -->
          <!-- 다영 사용가 아이디 검색 기능 -->
		  <div class="searchUserid"  style="padding-top:100px;">
		  <%--  <h4 class="mb-4"><b><span style="color:#2C91F7;">${boardname}</span>아이디 "${searchUserid}" 조회 결과</b></h4><br> --%>
          <form class="d-none d-md-flex ms-4" name="searchUserid" action="searchUserid.admin" method="post">
               	<input class="form-control border-0" type="search" name="searchUserid" id="searchUserid" placeholder="Searching User ID" style="width:250px;">
				<input class="btn btn-outline-primary m-2" type="submit" value="Search">
		  </form>
		  </div>
		  
          
          <table class = "table table-blue">
          
			<tr align="center" style="vertical-align:middle">
				<th>활성화 여부</th>	
				<th>ID</th>
				<th>이름</th>	
				<th>Email</th>
				<th>전화번호</th>
				<th>성별</th>
				<th>가입일</th>
			</tr>
			
			<c:forEach var="searchUseridList" items="${searchUseridList}" varStatus="status">
				
					<tr align="center" style="vertical-align:middle">
						<!-- <td><input class="btn btn-primary rounded-pill m-2" type="button" onclick="check();" value="비활성화"></td> -->
						<c:forEach var="member" items="${requestScope.member}">
							
								<c:if test="${searchUseridList.userid eq member.userid}">
								<td width="30%" id="activation" userid="${member.userid}" status="${member.status}">
									<c:choose>
									<c:when test="${member.status == 0}">
										<a href='#' onclick="alert('활성화 성공!');"><img src='./images/Button_Icon_Red.svg' width="18px" heigth="18px" id='activation_img'>
									</c:when>
									<c:otherwise>
										<a href='#' onclick="alert('비활성화 성공!');"><img src='./images/activation_button.png' width="18px" heigth="18px"  id='activation_img' ></a>
									</c:otherwise>
									</c:choose>
								</td>
								</c:if>

						</c:forEach>
							<td name="userid" id="userid">${searchUseridList.userid}</td>
							<td>${searchUseridList.name}</td>
							<td>${searchUseridList.email}</td>
							<td>${searchUseridList.phone}</td>
							<td>${searchUseridList.gender}</td>
							<td>${searchUseridList.startdate}</td>
							<%-- <input type="hidden" name="userid" value="${this.userid}"> --%>
					</tr>
		</c:forEach>

		</table>
		
		
 			
			<br>
			


	  <!-- content -->

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