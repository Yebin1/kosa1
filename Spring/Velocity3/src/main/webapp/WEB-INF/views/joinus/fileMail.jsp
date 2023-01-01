<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<title>fileMail</title>
<style>
#container {
	width: 100%;
	height: 100%;
	position: relative;
}

.dpn {
	display: none !important;
}

.join_wrap {
	width: 550px;
	margin: 200 auto;
	border: 1px solid #dadada;
	padding: 24px;
	border-radius: 5px;
	/* margin-top: 20px; */
}

.join_title {
	width: 100%;
	height: 35px;
	font-size: 19px;
	font-weight: bold;
	padding-left: 10px;
	padding: 0 0 10px 10px;
}

.join_box {
	width: 100%;
}

.join_box input {
	width: 100%;
	height: 50px;
	border: 1px solid #dadada;
	padding: 17px;
	border-radius: 5px;
	margin-top: 20px;
}

.join_box span {
	display: inline-block;
	color: red;
	font-size: 12px;
	padding-left: 1px;
	padding-top: 8px;
}

.email_auth {
	width: 100%;
	margin-top: 10px;
}

.email_auth input {
	display: inline-block;
	width: calc(100%);
	vertical-align: top;
	margin: 10px 0px 0px 0px;
}

.email_auth_btn {
	display: inline-block;
	width: 115px;
	height: 50px;
	padding: 17px 0 15px;
	border-radius: 6px;
	border: solid 1px rgba(0, 0, 0, .15);
	background-color: #03c75a;
	color: white;
	font-size: 17px;
	font-weight: bold;
	line-height: 1;
}

.join_btn {
	display: block;
	width: 100%;
	padding: 17px 0 15px;
	border-radius: 6px;
	border: solid 1px rgba(0, 0, 0, .15);
	background-color: #03c75a;
	color: white;
	font-size: 19px;
	font-weight: bold;
	margin-top: 20px;
}
</style>
</head>
<body>
<div id="container" class="container">
      <div class="content">
         <div class="join_wrap">
            <form id="join_frm" action="${pageContext.request.contextPath}/joinus/fileMail" method="post" enctype="multipart/form-data">
               <div class="join_title">파일 첨부 메일 보내기</div>
               <div class="join_box">
                  <input type="text" id="to" name="to" size="120" style="width: 100%; margin: 0;" placeholder="받는 이" class="form-control">
                  <input type="text" id="subject" name="subject" size="120" style="width: 100%" placeholder="제목을 입력해주세요" class="form-control">
                     <div class="mb-3">
                       <input class="form-control form-control-sm" id="file" type="file" name="file">
                     </div>
                     <!-- 내용 -->
                     <textarea name="text" id="text" cols="120" rows="12"
                        style="width: 100%; resize: none" placeholder="내용을 입력해 주세요" class="form-control ckeditor"></textarea>
               </div>
               <button type="submit" id="join" class="join_btn">메일 보내기</button>
            </form>
         </div>
      </div>
   </div>
</body>