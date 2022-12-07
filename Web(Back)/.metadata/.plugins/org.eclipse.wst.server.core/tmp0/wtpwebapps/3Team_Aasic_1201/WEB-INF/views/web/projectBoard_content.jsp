<%@page import="kr.or.kosa.dto.Reply"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.kosa.dto.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>board_content</title>
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="https://kit.fontawesome.com/def66b134a.js" crossorigin="anonymous"></script>
<script src="https://kit.fontawesome.com/21b939066c.js" crossorigin="anonymous"></script>
<script type="text/javascript">

$(function(){
   let answerCnt = 0;
   var viewCnt = 0;

   
   $(document).on(
         "click",
         "#reply_check",
         function() {
            //댓글 달기 비동기처리
            const content = $('#reply_content').val();

            if (content == "") {
               alert("내용을 입력하세요");
            } else if (confirm("댓글을 등록하시겠습니까?") == true) { //확인
               //비동기 함수 호출

               $.ajax({
                  url : "boardReplyOk.user", //보낼 URL
                  type : "GET", //보내는 방식
                  dataType : "html", //데이터 타입
                  data : {
                     'reply_userid' : $('#reply_userid').val(), //댓글 작성자 값
                     'reply_content' : $('#reply_content').val(),//댓글 내용 값
                     /* 'reply_pwd' : $('#reply_pwd').val(),      //비밀번호 값 */
                     'idx' : $('#idx').val()
                  //글 번호
                  },
                  success : function(data) {
                     $('#newView').append(data); //댓글 목록 에 추가(append)
                  },
                  error : function(request, status, error) { //에러 났을 경우 
                     alert("code:" + request.status + "\n"
                           + "message:" + request.responseText
                           + "\n" + "error:" + error);
                  }
               });
            } else { //취소
               alert("취소하였습니다.");
               return false;
            }
         });
   

   //댓글 삭제 비동기 처리
   $(document).on(
         "click",
         "#reply_del",
         function(e) {
            
            if (confirm("정말 삭제하시겠습니까?") == true) { //확인
               //비동기 함수 호출
               $.ajax({
                  type : "post", //보내는 방식
                  url : "boardReplyDeleteOk.user", //보낼 URL
                  dataType : "html", //데이터 타입
                  data : {
                     no : $(this).attr("seq"),
                     idx : $(this).attr("idx")

                  },
                  success : function(data) {
                     $('#newView').append(data); //삭제한 결과 댓글 목록에 반영
                  },
                  error : function(request, status, error) {
                     alert("code:" + request.status + "\n"
                           + "message:" + request.responseText
                           + "\n" + "error:" + error);
                     console.log(error);
                  }
               });
            } else { //취소
               alert("취소하였습니다.");
               return false;
            }
         });
   
    
   
   //댓글 수정 뷰페이지  nhj
    
    $(document).on("click","#reply_modify",function() {    
       if (confirm("정말 수정하시겠습니까?") == true) {
        $.ajax({
          url : "replyModify.user",
          type : "POST",
          dataType : "html",
          data : {
             seq : $(this).attr("seq"),
             idx : $(this).attr("idx")
          },
          context: this,
          success : function(data){
              $(this).parent().parent().children('td:eq(0)').hide();
              $(this).parent().parent().children('td:eq(1)').hide();
              $(this).parent().parent().parent().children('tr:eq(1)').append("<td>"+data+"</td>");
          },
          error : function(request,status,error){
             alert("code:" +request.status+"\n" + "message:"+request.responseText+"\n"+"error:"+error);
          }
        });
       }else{
          alert("취소하였습니다.");
            return false;
       }
    });

    $(document).on("click","#reply_cancel",function() {    
       if (confirm("정말 수정 취소하시겠습니까?") == true) {
              $(this).parent().parent().children('td:eq(0)').show();
              $(this).parent().parent().children('td:eq(1)').show();
               $(this).parent().remove();
       }else{
          alert("취소하였습니다.");
            return false;
       }
    });
    
   
   //댓글 수정 dao 시작    nhj
    $(document).on("click","#reply_update",function() {    
       if (confirm("댓글 수정 완료 하시겠습니까?") == true) {
        $.ajax({
          url : "replyUpdate.user",
          type : "POST",
          dataType : "html",
          data : {
             seq : $(this).attr("seq"),
             idx : $(this).attr("idx"),
             reply_content : $('#reply_content_update').val()
          },
          context: this,
          success : function(data){      
             location.href = "boardContent.user?boardname="+'${board.boardname}'+"&idx="+${idx}+"&cp="+${requestScope.cp}+"&ps="+${requestScope.ps};             
          },
          error : function(request,status,error){
             alert("code:" +request.status+"m\n" + "message:"+request.responseText+"\n"+"error:"+error);
          }
        });
       }else{
          alert("취소 하였습니다.");
            return false;
       }
      });
   
   
    //답글 달기 view  nhj  수정중
    
     $(document).on("click","#reply_answer",function() {    
      if (confirm("답글을 다시겠습니까?") == true) {
       $.ajax({
          url : "replyAnswer.user",
          type : "POST",
          dataType : "html",
          data : {
             seq : $(this).attr("seq"),
             idx : $(this).attr("idx")
          },
          context: this,
          success : function(data){
                $(this).parent().parent().parent().parent().children('tbody:eq(0)').append("<tr>"+data+"</tr>");
          },
          error : function(request,status,error){
             alert("code:" +request.status+"\n" + "message:"+request.responseText+"\n"+"error:"+error);
          }
        });
       
      }else{
       alert("취소 하였습니다.");
         return false;
      }
       });
    
    
    //댓글 답글 수정 dao 시작    nhj
    $(document).on("click","#replyAnswer_insert",function() {    
       if (confirm("답글을 입력 하시겠습니까?") == true) {
        $.ajax({
          url : "replyAnswerInsert.user",
          type : "POST",
          dataType : "html",
          data : {
             seq : $(this).attr("seq"),
             idx : $(this).attr("idx"),
             reply_content : $('#replyAnswer_content_insert').val()
          },
          context: this,
          success : function(data){      
             location.href = "boardContent.user?boardname="+'${board.boardname}'+"&idx="+${idx}+"&cp="+${requestScope.cp}+"&ps="+${requestScope.ps};             
          },
          error : function(request,status,error){
             alert("code:" +request.status+"m\n" + "message:"+request.responseText+"\n"+"error:"+error);
          }
        });
       }else{
          alert("취소 하였습니다.");
            return false;
       }
      });

    
    
    //답글 취소하기.
    $(document).on("click","#replyAnswer_cancel",function() {    
   
       if (confirm("취소 하시겠습니까?") == true) {
          $('#replyAnswerList').remove();
      }else{
         alert("취소 하였습니다.");
         return false;
      }
    });
   

    //대댓 답글   nhj 
    $(document).on("click","#reply_comment",function() {
       $.ajax({
          url : "replyComment.user",
          type : "POST",
          dataType : "html",
          data : {
             seq : $(this).attr("seq"),
             idx : $(this).attr("idx")
          },
          context: this,
          success : function(data){
             if(answerCnt == 0){
                 $('#test').remove();
                $(this).parent().parent().parent().parent().parent().children('tbody:eq(0)').append("<table id = test>"+data+"</table>");
                answerCnt++;
             }else{
                $('#test').remove();
                answerCnt = 0;
             }

          },
          error : function(request,status,error){
             alert("code:" +request.status+"\n" + "message:"+request.responseText+"\n"+"error:"+error);
          }
        });
      });
    
   //토클
   //첨부파일 상세보기 비동기 
   $('#fileDetail').click(function(){
      //비동기 함수 호출
      $.ajax(
         {
            url:"fileDetailList.user",  //URL 보내기
            type:"GET",                //방식
            dataType:"html",            //데이터 타입
            data : {
               'idx' : $('#idx').val()  //글번호 
            },
            success:function(data){
            if(viewCnt == 0){
	            $('#fileList').empty(data);
	            $('#fileList').append(data); //비어있는 <div>인 fileList에다 사진 붙여줌(append)
	            viewCnt++;
            }else{
	            $('#fileList').empty(data);
	            viewCnt = 0;
            }
            },
            error:function(request,status,error){
                  alert("code:" +request.status+"\n" + "message:"+request.responseText+"\n"+"error:"+error);
                  console.log(error);
            }
            
         }      
      );
   });
   
   // 추천 버튼 클릭시 추천 여부 검사
   $('#lovecheck').on("click",(function(){
         
      $.ajax({
         url: 'loveUpdate.user',
         type: 'POST',
         dataType: 'html',
         data : {
            'idx' : ${requestScope.idx},
            userid2: $(this).attr("uuid"),
         },            
         success: function(data){ 
              $('#love1').empty(data);
            $('#love1').append(data);
          },
          error:function(request,status,error){
             alert("code:" +request.status+"\n" + "message:"+request.responseText+"\n"+"error:"+error);
              console.log("추천 체크 실패");
              console.log("에러표시"+error);
          }
      });
   }));

   

 //북마크 함수(비동기)
 //북마크 노다영 바보.
    $(document).on(
       "click",
       "#bookmarking",
          function() {
          $.ajax({
                url: "bookMarks.user",
                type: "POST",
                dataType: "html",
                data : {
                   'idx' : '${requestScope.idx}',
                },
                success:function(data){ 
                   $('#bookmarking').empty();
                   $('#bookmarking').append(data);
                 },
                 error:function(request,status,error){
                     alert("북마크 체크 실패");
                      alert("code:" +request.status+"\n" + "message:"+request.responseText+"\n"+"error:"+error);
                 }
        });
    });

      
});
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
	<c:set var="board" value="${requestScope.board}" />
	<c:set var="idx" value="${requestScope.idx }" />
	<c:set var="cpage" value="${requestScope.cp}" />
	<c:set var="pagesize" value="${requestScope.ps}" />
	<c:set var="replyList" value="${requestScope.replyList}" />
	<c:set var="replyAnswerList" value="${requestScope.replyAnswerList}" />
	<c:set var="boardname" value="${requestScope.boardname}" />
	<c:set var="lovecount" value="${requestScope.lovecount}" />
	<c:set var="filename" value="${requestScope.filename}" />
	<c:set var="bookmark" value="${requestScope.bookmarking}"/>



	<div id="pageContainer">
		<div style="padding-top: 30px; text-align: center">
			<center>
				<h3><b>제목 : ${board.title}</b></h3>
				<div style="padding-top: 25px; text-align: center; width:89%;" >
				
				<table class="table" width="95%" align="center">
					<tr>
						<td width="20%" align="center"><b> 글번호 </b></td>
						<td width="30%">${idx}</td>
						<td width="20%" align="center"><b>작성일</b></td>
						<td>${board.writedate}</td>
					</tr>
					<tr>
						<td width="20%" align="center"><b>글쓴이</b></td>
						<td width="30%">${board.userid}</td>
						<td width="20%" align="center"><b>조회수</b></td>
						<td>${board.readnum}</td>
					</tr>
					<!-- //////////////// -->
					<tr>
						<td width="20%" align="center"><b>북마크 여부</b></td>
						<td width="30%" id="bookmarking">
						<jsp:include page="/WEB-INF/views/web/bookMark.jsp"></jsp:include>
						</td>
						<td width="20%" align="center"><b>추천수</b></td>
							<td colspan="3"><a id="love1">${lovecount}</a></td>			
					</tr>
					<tr>
							<td width="20%" align="center"><b>첨부파일</b></td>
						<td><c:choose>
								<c:when test="${filename != null && fn:length(filename) > 10}">
									${fn:substring(filename,0,15)}...
									<button class="btn btn-primary rounded-pill m-2" type="button" href="#" id="fileDetail">상세보기</button>
								</c:when>
								<c:otherwise>
									${filename}<button class="btn btn-primary rounded-pill m-2" type="button" href="#" id="fileDetail">
										상세보기</button>
								</c:otherwise>
							</c:choose><div id="fileList"></div> <!-- style="display: none; --></td>
							<td width="20%" align="center"><b>시작/종료 날짜</b></td>
							</td>
							<td>
                      
                        		<div class="col-sm-12 col-md-6 col-xl-4" style="margin-left:70px;">
                        		<c:forEach var="recruitboard" items="${recruitboardList}">
                        			<div>${recruitboard.startdate}</div> ~ <div>${recruitboard.enddate}</div>
								</c:forEach>
			
			        			</div>
                        </td>
					</tr>
					<%-- <tr>
						<td width="20%" align="center"><b>제목</b></td>
						<td colspan="3">${board.title}</td>
					</tr> --%>
					<tr>
						<td colspan="4" align="center"><div><b>글내용</b></div></td>
						<td colspan="2"></td>
						</tr>
						
						<tr  height="230">
						<td colspan="4" align="left">${fn:replace(board.content, newLineChar,"<br>")}							
						</td>
					</tr>
					<%-- <tr>
						<td colspan="4" align="center"><a id="love1">${lovecount}</a></td>
					</tr> --%>
					<tr>
						<td colspan="4" align="center"><button class="btn btn-primary rounded-pill m-2" onclick="location.href='javascript:history.back();'" >목록</button>
						|<button class="btn btn-primary rounded-pill m-2" onclick="location.href='boardEdit.user?boardname=${board.boardname}&idx=${idx}&cp=${cpage}&ps=${pagesize}&filename=${filename}'" >편집</button>
						<c:choose>
										<c:when test="${sessionScope.userid ne 'admin'}"> 
										|<button class="btn btn-primary rounded-pill m-2"
										onclick="location.href='boardDelete.user?boardname=${board.boardname}&idx=${idx}&cp=${cpage}&ps=${pagesize}&writerid=${board.userid}'">삭제</button>
										</c:when>
										
										<c:otherwise> 
											|<button class="btn btn-primary rounded-pill m-2"
										onclick="location.href='boardDelete.user?boardname=${board.boardname}&idx=${idx}&cp=${cpage}&ps=${pagesize}&writerid=${board.userid}'">삭제</button>
									   </c:otherwise>
									</c:choose> 
							<%-- <a href="BoardRewrite.board?idx=${idx}&cp=${cpage}&ps=${pagesize}&subject=${board.title}">답글</a> --%>
						| <button class="btn btn-primary rounded-pill m-2" type="button" id="lovecheck"  uuid ="${board.userid}" value="추천">추천</button></td>

					</tr>
					<tr>
						<td colspan="1" align="center"><b>모집 신청</b></td>
						<td colspan="3" align="left"><c:choose>
								<c:when test="${apply != null && fn:length(apply) > 10}">
									<a href="${apply}">${fn:substring(apply,0,15)}...</a>
								</c:when>
								<c:otherwise>
									<a href="${apply}">${apply}</a>
								</c:otherwise>
							</c:choose></td>
					</tr>
				</table>
				</div>
				<!--  꼬리글 달기 테이블 -->
            <!-- <form name="reply" action="ReplyOk.board" method="POST"> -->
            <!-- hidden 태그  값을 숨겨서 처리  -->
            <c:if test="${sessionScope.userid ne null }">
               <input type="hidden" id="idx" name="idx" value="${idx}">
               <input type="hidden" name="userid" value="">
               <!-- 추후 필요에 따라  -->
               <!-- hidden data -->
               <div style="padding-top: 25px; text-align: center; width:70%;">
                  <table class="table" width="80%" >
                  <tr>
                     <th colspan="2">덧글 쓰기</th>
                  </tr>
                  <tr>
                     <td align="left"><input type="hidden" id="reply_userid"
                        name="reply_userid" value="${sessionScope.userid}" readonly><br />
                        <div class="form-floating">
                                <textarea class="form-control" placeholder="Leave a comment here"
                                    id="reply_content" style="height: 150px;"></textarea>
                                <label for="floatingTextarea">Comments</label>
                            </div> <br>
                        <button class="btn btn-primary rounded-pill m-2" type="button" id="reply_check"
                           >등록</button></td>
                  </tr>

               </table>
               </div>
               

            </c:if>

            <br>
            <!--  -->
            <!-- 꼬리글 목록 테이블 -->
            <div id="nhj"></div>
            <div id="newView">
               <c:if test="${not empty replyList}">
                  <c:forEach var="reply" items="${replyList}">
                  <c:if test="${reply.parentreply eq 0}">
                  <div id="clickDiv" align="center" style="width:90%; border-radius:50px; background-color:#E3F1FF; margin-bottom:20px;">
                     <table width="90%"  >
                           <tr>
                              <th colspan="2">
                                 [${reply.userid}]&ensp; <small><small>작성일: ${reply.replydate}</small></small></th>
                           </tr>
                           <tr align="left" >
                              <td width="80%" seq2="${reply.replynum}">${reply.content} <br>
                                 
                                 <c:forEach var="replyAnswerList" items="${replyAnswerList}">
                                    <c:if test="${reply.replynum eq replyAnswerList.parentreply}">
                                        <div class="nav-item dropdown">
                                           <button class="btn btn-primary rounded-pill m-2 nav-link dropdown-toggle" data-bs-toggle="dropdown" seq="${reply.replynum}" idx="${idx}" id="reply_comment" style="background-color:transparent; color:#17A4FF;"><small>답글</small></button>
                                        </div>
                                    </c:if>
                                 </c:forEach> 
                              </td>
                                </tr>
                                <tr>
                                <c:choose>
                                 <c:when test="${sessionScope.userid eq reply.userid}">
                                 <td align="right">
			                           
				                                <button type="button" class="btn btn-outline-primary" seq="${reply.replynum}" idx="${idx}" id="reply_modify" ><small>수정</small></button>
				                                <button type="button" class="btn btn-outline-primary" seq="${reply.replynum}" idx="${idx}" id="reply_del"><small>삭제</small></button>
				                                <button type="button" class="btn btn-outline-primary" seq="${reply.replynum}" idx="${idx}" id="reply_answer"><small>답글달기</small></button>
				                                 <button type="button" class="btn btn-outline-primary" seq="${reply.content}" idx="${idx}" id="replycompare"><small>비교하기</small></button>
				                         
                                 </td>
                              </c:when>
                              <c:otherwise>
                              <td align="right">
                              		 		
				                                <button type="button" class="btn btn-outline-primary" seq="${reply.replynum}" idx="${idx}" id="reply_answer"><small>답글달기</small></button>
				                                 <button type="button" class="btn btn-outline-primary" seq="${reply.content}" idx="${idx}" id="replycompare"><small>비교하기</small></button>
				                         
				              </td>
                              </c:otherwise>
                              </c:choose>
                           </tr>
                     </table>
                     </div>
                     </c:if>
                  </c:forEach>
               </c:if>
            </div>
         </center>
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