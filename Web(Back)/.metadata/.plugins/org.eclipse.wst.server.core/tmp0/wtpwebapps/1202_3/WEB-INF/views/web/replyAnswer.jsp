<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="images/kingbird.ico" rel="icon">
<title>Insert title here</title>
</head>
<body>
		<td id="replyAnswerList" align="right">
			<c:set var="idx" value="${requestScope.idx }" />
			<c:set var="seq" value="${requestScope.seq }" />
			<textarea class="form-control" id="replyAnswer_content_insert" name="replyAnswer_content_insert" 
				style="height: 150px;" placeholder="Leave a comment here" required></textarea> <br>
			<button seq="${seq}" idx="${idx}" type="button" id="replyAnswer_insert"
				class="btn btn-outline-primary">등록</button>
			<button class="btn btn-outline-primary" type="reset" id="replyAnswer_cancel">취소</button>
		</td>
</body>
</html>