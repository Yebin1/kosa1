<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 글쓰기</title>
<script src="https://cdn.ckeditor.com/4.16.0/standard/ckeditor.js"></script>
<link rel="Stylesheet"
	href="${pageContext.request.contextPath}/style/default.css" />
<SCRIPT type="text/javascript">
	function check() {
		/*
		if (!freeboard.title.value) {
			alert("제목을 입력하세요");
			freeboard.title.focus();
			return false;
		}
		if (!freeboard.writer.value) {
			alert("이름을 입력하세요");
			freeboard.writer.focus();
			return false;
		}
		/*  if(!freeboard.content.value){            
		     alert("글 내용을 입력하세요");
		     freeboard.content.focus();
		     return false;
		 } */
		// document.bbs.submit();
		console.log("check 함수");
		document.freeboard.submit();
		console.log("submit 완료");

	}
</SCRIPT>
</head>
<body>
	<c:import url="/WEB-INF/views/include/userHeader.jsp" />

	<div id="pageContainer">
		<div style="padding-top: 25px; text-align: center">
			<!-- form 시작 ---------->
			<form name="freeboard"
				action="${pageContext.request.contextPath}/BoardWriteOkService.board"
				method="POST" enctype="multipart/form-data">
				<table width="95%" border="2" align="center">
					<tr>
						<td width="20%" align="center">제목</td>
						<td width="80%" align="left"><input type="text"
							name="title" size="40"></td>
					</tr>
					<tr>
						<td width="20%" align="center">글쓴이</td>
						<td width="80%" align="left"><input type="text" name="writer" value="${sessionScope.id}" readonly 
							size="40" style="background-color: #EAEAEA; color:#8C8C8C;"></td>
					</tr>
					<tr>
						<td width="20%" align="center">글내용</td>
						<td width="80%" align="left"><textarea rows="10" cols="60"
								name="content" class="ckeditor"></textarea></td>
					</tr>
					<tr>
						<td width="20%" align="center">첨부파일</td>
						<td width="80%" align="left"><input type="file"
							name="filename"></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="button"
							value="글쓰기" onclick="check();"></td>
					</tr>
				</table>
			</form>

		</div>
	</div>
</body>
</html>