<%@page import="kr.or.kosa.dto.Board"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script src="https://cdn.ckeditor.com/4.16.0/standard/ckeditor.js"></script>
	<title>Insert title here</title>
	<script type="text/javascript">
	
	function editCheck() {

		/* if (!edit.userid.value) {

			alert("이름을 입력하세요");
			edit.userid.focus();
			return false;
		} */
		/* if (!edit.pwd.value) {
			alert("비밀번호를 입력해야 합니다.");
			edit.pwd.focus();
			return false;
		} */

		/* if (!edit.email.value) {
			alert("이메일을 입력해야합니다.");
			edit.email.focus();
			return false;
		} */

		if (!edit.title.value) {
			alert("제목을 입력하세요");
			edit.title.focus();
			return false;
		}

		if (!edit.content.value) {
			alert("글 내용을 입력하세요");
			edit.content.focus();
			return false;
		}

		document.edit.submit();

	}
</script>
</head>
<body>
<c:choose>
	<c:when test="${sessionScope.userid == 'admin'}"> <!-- 관리자일때 -->
		<!-- 사이드바 들어갈 자리 -->
      <jsp:include page="/WEB-INF/views/include/adminsidebar_css.jsp"></jsp:include>
        <!-- Content Start -->
        <div class="content">
        <!-- 헤더 -->
         <jsp:include page="/WEB-INF/views/include/adminheader_css.jsp"></jsp:include>
	</c:when>
	<c:when test="${sessionScope.userid ne null and sessionScope.userid ne admin}"> <!-- 일반사용자 -->
		 <!-- 사이드바 들어갈 자리 -->
         <jsp:include page="/WEB-INF/views/include/sidebar_css.jsp"></jsp:include>
         <!-- Content Start -->
         <div class="content">
         <!-- 헤더 -->
         <jsp:include page="/WEB-INF/views/include/userheader_css.jsp"></jsp:include>
	</c:when>
</c:choose>
<c:set var="idx" value="${requestScope.idx}" />
	<c:set var="board" value="${requestScope.board}" />
	<c:set var="boardname" value="${requestScope.boardname}" />
	<c:set var="filename" value="${requestScope.filename}" />
	<c:set var="boardheader" value="${requestScope.boardheader}" />

    <div id="pageContainer">
		<div style="padding-top: 25px; text-align: center">
		<h4 class="mb-4"><b><span style="color:red;">${boardname}</span>-게시물 수정</b></h4><br>
			<!-- form 시작 -->
			<form name="edit" action="boardEditOk.user" method="POST">
				<center>
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
							<td width="10%" align="center"><b> 글번호 </b></td>
							<td width="30%">
									${idx}
									<input type="hidden" name="idx" value="${idx}"></td>
							</tr>
							<tr>
							<td width="10%" align="center"><b>작성일</b></td>
							<td width="30%" align="left">${board.writedate}</td>
						</tr>
						<tr>
							<td width="20%" align="center"><b>글쓴이</b></td>
							<td width="30%">
								<input type="text" name="userid" value="${board.userid}" class="form-control" style="width:400px;" readonly>
							</td>
							<!-- <td width="20%" align="center"><b>홈페이지</b></td> -->
							<%-- <td>
								<input type="text" name="homepage" value="${board.homepage}">
							</td> --%>
						</tr>
						<tr>
<!-- 							<td width="20%" align="center"><b>비밀번호(기존)</b></td>
 -->							<!-- <td>
								<input type="password" name="pwd">
							</td> -->
<!-- 							<td width="20%" align="center"><b>이메일</b></td>
 -->							<%-- <td>
								<input type="text" name="email" value="${board.email}">
							</td> --%>
						</tr>

						<tr>
							<td width="20%" align="center"><b>제목</b></td>
							<td colspan="3">
								<input type="text" name="title" value="${board.title}" size="40" class="form-control" style="width:400px;">
							</td>
						</tr>
						<tr>
                        <td width="10%" align="center">글내용</td>
                        <td width="80%" align="left"><textarea rows="10" cols="60" name="content" class="ckeditor" placeholder="이곳에 내용을 작성하세요.">${board.content}</textarea></td>
                    	<td width="40%"></td>
                    </tr>

						<tr>
							<td width="20%" align="center"><b>첨부파일</b></td>
							<td colspan="3">${filename} (${files.filesize}bytes)<br /> 
								<input type="file" name="filename" class="form-control" id="formFile" style="width:400px; margin-bottom:20px;">
							</td>
						</tr>
						<tr>
							<td colspan="4" align="center">
								<button class="btn btn-primary rounded-pill m-2" value="수정하기" onclick="editCheck();">수정하기</button>
								<!-- <input type="reset" value="다시쓰기"> -->
							</td>
						</tr>
						<%-- <tr>
							<td colspan="4" align="center">
								<a href="boardList.user?boardname=${board.boardname}}">목록</a>
							</td>
						</tr> --%>
					</table>
				</center>
				<input type="hidden" name="boardname" value="${board.boardname}"> 
				<!-- <input type="hidden" name="boardname" value=${boardname}> --> 
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