<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>DASHMIN - Bootstrap Admin Template</title>
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
    
    <script src="https://cdn.ckeditor.com/4.16.0/standard/ckeditor.js"></script>
	<SCRIPT type="text/javascript">
		function check(){
		    if(!bbs.title.value){
		        alert("제목을 입력하세요");
		        bbs.title.focus();
		        return false;
		    }
		 
		    document.bbs.submit();
		 
		}
</SCRIPT>
</head>

<body>
<!-- 사이드바 들어갈 자리 -->
      <jsp:include page="/WEB-INF/views/include/sidebar_css.jsp"></jsp:include>

        <!-- Content Start -->
        <div class="content">
        <!-- 헤더 -->
          <jsp:include page="/WEB-INF/views/include/userheader_css.jsp"></jsp:include>
		<c:set var="boardname" value="${requestScope.boardname}" />

    <div id="pageContainer">
    
        <div style="padding-top: 25px; text-align: center">
        <h4 class="mb-4"><b><span style="color:red;">${boardname}</span>게시판</b></h4><br>
        
            <!-- form 시작 ---------->
            <form name="bbs" action="boardWriteOK.user" method="POST" enctype="multipart/form-data">
               
                <table class="table" width="95%" align="center">
                 <tr>
                        <td width="20%" align="center">말머리 선택</td>
                        <td width="80%" align="left">
                        	<select class="form-select mb-3" aria-label="Default select example" name="category" style="width:400px;">
                                <option value="[일상]"> [일상]</option>
                                <option value="[고민]"> [고민]</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td width="10%" align="center">제목</td>
                        <td width="90%" align="left"><input type="text" name="title" size="40" maxlength="25" class="form-control" style="width:400px;" placeholder="이곳에 제목을 작성하세요."></td>
                    </tr>
                    <tr>
                        <td width="10%" align="center">글내용</td>
                        <td width="50%" align="left"><textarea rows="10" cols="60" name="content" class="ckeditor" placeholder="이곳에 내용을 작성하세요."></textarea></td>
                    	<td width="40%"></td>
                    </tr>
                    <tr>
                        <td width="10%" align="center">첨부파일</td>
                        <td width="90%" align="left"><input type="file" name="filename" class="form-control" id="formFile" style="width:400px; margin-bottom:20px;"></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <button type="button" class="btn btn-primary rounded-pill m-2" value="글쓰기" onclick="check();">글쓰기</button>
                        </td>
                    </tr>
                </table>
                <input type="hidden" name="boardname" value="${boardname}">
              </form>
        </div>
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
</body>
</html>