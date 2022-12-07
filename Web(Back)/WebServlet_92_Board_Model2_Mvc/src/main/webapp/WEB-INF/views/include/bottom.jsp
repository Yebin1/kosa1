<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script type="text/javascript">
/* 	$(function() {


	}); */
</script>

</head>
<body>
	<c:set var="replyList" value="${requestScope.replyList}" />
	<c:if test="${not empty replyList}">
		<tr>
			<th colspan="2">REPLY LIST</th>
		</tr>
		<c:forEach var="reply" items="${replyList}">
			<table width="80%" border="1">
				<tr align="left">
					<td width="80%">[${reply.writer}] : ${reply.content} <br>
						작성일:${reply.writedate}
					</td>
					<td width="20%">
						<form action="ReplyDeleteOk.do" method="POST" name="replyDel">
							<input type="hidden" name="no" id="no" value="${reply.no}">
							<input type="hidden" name="idx" value="${reply.idx_fk}">
							password :<input type="password" name="delPwd" id="delPwd"
								size="4"> <input type="button" value="삭제" id="deleteBtn">
						</form>
					</td>
				</tr>
			</table>
		</c:forEach>
	</c:if>
</body>
</html>