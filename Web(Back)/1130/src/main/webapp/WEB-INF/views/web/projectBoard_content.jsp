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
   

   
   $(document).on(
         "click",
         "#reply_check",
         function() {
            //?????? ?????? ???????????????
            const content = $('#reply_content').val();

            if (content == "") {
               alert("????????? ???????????????");
            } else if (confirm("????????? ?????????????????????????") == true) { //??????
               //????????? ?????? ??????

               $.ajax({
                  url : "boardReplyOk.user", //?????? URL
                  type : "GET", //????????? ??????
                  dataType : "html", //????????? ??????
                  data : {
                     'reply_userid' : $('#reply_userid').val(), //?????? ????????? ???
                     'reply_content' : $('#reply_content').val(),//?????? ?????? ???
                     /* 'reply_pwd' : $('#reply_pwd').val(),      //???????????? ??? */
                     'idx' : $('#idx').val()
                  //??? ??????
                  },
                  success : function(data) {
                     $('#newView').append(data); //?????? ?????? ??? ??????(append)
                  },
                  error : function(request, status, error) { //?????? ?????? ?????? 
                     alert("code:" + request.status + "\n"
                           + "message:" + request.responseText
                           + "\n" + "error:" + error);
                  }
               });
            } else { //??????
               alert("?????????????????????.");
               return false;
            }
         });
   

   //?????? ?????? ????????? ??????
   $(document).on(
         "click",
         "#reply_del",
         function(e) {
            
            if (confirm("?????? ?????????????????????????") == true) { //??????
               //????????? ?????? ??????
               $.ajax({
                  type : "post", //????????? ??????
                  url : "boardReplyDeleteOk.user", //?????? URL
                  dataType : "html", //????????? ??????
                  data : {
                     no : $(this).attr("seq"),
                     idx : $(this).attr("idx")

                  },
                  success : function(data) {
                     $('#newView').append(data); //????????? ?????? ?????? ????????? ??????
                  },
                  error : function(request, status, error) {
                     alert("code:" + request.status + "\n"
                           + "message:" + request.responseText
                           + "\n" + "error:" + error);
                     console.log(error);
                  }
               });
            } else { //??????
               alert("?????????????????????.");
               return false;
            }
         });
   
    
   
   //?????? ?????? ????????????  nhj
    
    $(document).on("click","#reply_modify",function() {    
       if (confirm("?????? ?????????????????????????") == true) {
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
          alert("?????????????????????.");
            return false;
       }
    });

    $(document).on("click","#reply_cancel",function() {    
       if (confirm("?????? ?????? ?????????????????????????") == true) {
              $(this).parent().parent().children('td:eq(0)').show();
              $(this).parent().parent().children('td:eq(1)').show();
               $(this).parent().remove();
       }else{
          alert("?????????????????????.");
            return false;
       }
    });
    
   
   //?????? ?????? dao ??????    nhj
    $(document).on("click","#reply_update",function() {    
       if (confirm("?????? ?????? ?????? ???????????????????") == true) {
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
          alert("?????? ???????????????.");
            return false;
       }
      });
   
   
    //?????? ?????? view  nhj  ?????????
    
     $(document).on("click","#reply_answer",function() {    
      if (confirm("????????? ???????????????????") == true) {
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
       alert("?????? ???????????????.");
         return false;
      }
       });
    
    
    //?????? ?????? ?????? dao ??????    nhj
    $(document).on("click","#replyAnswer_insert",function() {    
       if (confirm("????????? ?????? ???????????????????") == true) {
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
          alert("?????? ???????????????.");
            return false;
       }
      });

    
    
    //?????? ????????????.
    $(document).on("click","#replyAnswer_cancel",function() {    
   
       if (confirm("?????? ???????????????????") == true) {
          $('#replyAnswerList').remove();
      }else{
         alert("?????? ???????????????.");
         return false;
      }
    });
   

    //?????? ??????   nhj 
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
    
    

/*    $(document).on("click", "#clickDiv", function(){

          alert("asd");
         $("#nhj").append(this);
         console.log($(this));
   }); */
   
   
   //???????????? ???????????? ????????? 
   $('#fileDetail').click(function(){
      //????????? ?????? ??????
      $.ajax(
         {
            url:"fileDetailList.user",  //URL ?????????
            type:"GET",                //??????
            dataType:"html",            //????????? ??????
            data : {
               'idx' : $('#idx').val()  //????????? 
            },
            success:function(data){
            $('#fileList').empty(data);
            $('#fileList').append(data); //???????????? <div>??? fileList?????? ?????? ?????????(append)
            },
            error:function(request,status,error){
                  alert("code:" +request.status+"\n" + "message:"+request.responseText+"\n"+"error:"+error);
                  console.log(error);
            }
            
         }      
      );
   });
   
   // ?????? ?????? ????????? ?????? ?????? ??????
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
              console.log("?????? ?????? ??????");
              console.log("????????????"+error);
          }
      });
   }));

   

 //????????? ??????(?????????)
 //????????? ????????? ??????.
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
                     alert("????????? ?????? ??????");
                      alert("code:" +request.status+"\n" + "message:"+request.responseText+"\n"+"error:"+error);
                 }
        });
    });

      
});
</script>
</head>
<body>
      <!-- ???????????? ????????? ?????? -->
      <jsp:include page="/WEB-INF/views/include/sidebar_css.jsp"></jsp:include>
        <!-- Content Start -->
      <div class="content">
        <!-- ?????? -->
      <jsp:include page="/WEB-INF/views/include/userheader_css.jsp"></jsp:include>

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
				<h3><b>?????? : ${board.title}</b></h3>
				<div style="padding-top: 25px; text-align: center; width:89%;" >
				
				<table class="table" width="95%" align="center">
					<tr>
						<td width="20%" align="center"><b> ????????? </b></td>
						<td width="30%">${idx}</td>
						<td width="20%" align="center"><b>?????????</b></td>
						<td>${board.writedate}</td>
					</tr>
					<tr>
						<td width="20%" align="center"><b>?????????</b></td>
						<td width="30%">${board.userid}</td>
						<td width="20%" align="center"><b>?????????</b></td>
						<td>${board.readnum}</td>
					</tr>
					<!-- //////////////// -->
					<tr>
						<td width="20%" align="center"><b>????????? ??????</b></td>
						<td width="30%" id="bookmarking">
						<jsp:include page="/WEB-INF/views/web/bookMark.jsp"></jsp:include>
						</td>
						<td width="20%" align="center"><b>?????????</b></td>
							<td colspan="3"><a id="love1">${lovecount}</a></td>			
					</tr>
					<!-- //////////////// -->
					<tr>
							<td width="20%" align="center"><b>????????????</b></td>
						<td><c:choose>
								<c:when test="${filename != null && fn:length(filename) > 10}">
									${fn:substring(filename,0,15)}...
									<button class="btn btn-primary rounded-pill m-2" type="button" href="#" id="fileDetail">????????????</button>
								</c:when>
								<c:otherwise>
									${filename}<button class="btn btn-primary rounded-pill m-2" type="button" href="#" id="fileDetail">
										????????????</button>
								</c:otherwise>
							</c:choose><div id="fileList"></div> <!-- style="display: none; --></td>
							<td width="20%" align="center"><b>??????/?????? ??????</b></td>
							</td>
							<td>
                      
                        		<div class="col-sm-12 col-md-6 col-xl-4" style="margin-left:70px;">
			                            <div><input type="date" name="startday"></div>
			
			                            <div><input type="date" name="endday"></div>
                    			</div>
                        </td>
					</tr>
					<%-- <tr>
						<td width="20%" align="center"><b>??????</b></td>
						<td colspan="3">${board.title}</td>
					</tr> --%>
					<tr>
						<td colspan="4" align="center"><div><b>?????????</b></div></td>
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
						<td colspan="4" align="center"><button class="btn btn-primary rounded-pill m-2" onclick="location.href='javascript:history.back();'" >??????</button>
						|<button class="btn btn-primary rounded-pill m-2" onclick="location.href='boardEdit.user?boardname=${board.boardname}&idx=${idx}&cp=${cpage}&ps=${pagesize}&filename=${filename}'" >??????</button>
						|<button class="btn btn-primary rounded-pill m-2" onclick="location.href='boardDelete.user?boardname=${board.boardname}&idx=${idx}&cp=${cpage}&ps=${pagesize}&writerid=${board.userid}'">??????</button>
							<%-- <a href="BoardRewrite.board?idx=${idx}&cp=${cpage}&ps=${pagesize}&subject=${board.title}">??????</a> --%>
						| <button class="btn btn-primary rounded-pill m-2" type="button" id="lovecheck"  uuid ="${board.userid}" value="??????">??????</button></td>

					</tr>
				</table>
				<div><input type="date" name="startday"></div>
				</div>
				<!--  ????????? ?????? ????????? -->
            <!-- <form name="reply" action="ReplyOk.board" method="POST"> -->
            <!-- hidden ??????  ?????? ????????? ??????  -->
            <c:if test="${sessionScope.userid ne null }">
               <input type="hidden" id="idx" name="idx" value="${idx}">
               <input type="hidden" name="userid" value="">
               <!-- ?????? ????????? ??????  -->
               <!-- hidden data -->
               <div style="padding-top: 25px; text-align: center; width:70%;">
                  <table class="table" width="80%" >
                  <tr>
                     <th colspan="2">?????? ??????</th>
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
                           >??????</button></td>
                  </tr>

               </table>
               </div>
               

            </c:if>

            <br>
            <!--  -->
            <!-- ????????? ?????? ????????? -->
            <div id="nhj"></div>
            <div id="newView">
               <c:if test="${not empty replyList}">
                  <c:forEach var="reply" items="${replyList}">
                  <c:if test="${reply.parentreply eq 0}">
                  <div id="clickDiv" class="alert alert-info" align="center" style="width:90%;">
                     <table width="90%"  >
                           <tr>
                              <th colspan="2">${reply.replynum} ?????? ??????
                                 (${idx}??? ?????????)</th>
                           </tr>
                           <tr align="left" >
                              <td width="80%" seq2="${reply.replynum}">[${reply.userid}] : ${reply.content} <br>
                                 <small><small>?????????:${reply.replydate}</small></small>
                                 <c:forEach var="replyAnswerList" items="${replyAnswerList}">
                                    <c:if test="${reply.replynum eq replyAnswerList.parentreply}">
                                        <div class="nav-item dropdown">
                                           <button class="btn btn-primary rounded-pill m-2 nav-link dropdown-toggle" data-bs-toggle="dropdown" seq="${reply.replynum}" idx="${idx}" id="reply_comment">??????</button>
                                        </div>
                                    </c:if>
                                 </c:forEach> 
                              </td>
                              <c:if test="${sessionScope.userid eq reply.userid}">
                                 <td>
                                    <button class="btn btn-primary rounded-pill m-2" seq="${reply.replynum}" idx="${idx}"
                                       id="reply_modify">??????</button>
                                    <button class="btn btn-primary rounded-pill m-2" seq="${reply.replynum}" idx="${idx}" id="reply_del">??????</button>
                                    <button class="btn btn-primary rounded-pill m-2" seq="${reply.replynum}" idx="${idx}" id="reply_answer">????????????</button>

                                 </td>
                              </c:if>
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