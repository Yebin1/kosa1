<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
<c:set var="idx" value="${requestScope.idx }"/>
<c:set var="seq" value="${requestScope.seq }"/>
<c:set var="replyList" value="${requestScope.replyList}"/>
	
	<c:forEach var="reply" items="${replyList}">
		<c:if test="${reply.parentreply eq seq}">
			<tr>
			<th colspan="2">${reply.replynum} 번째 댓글
				(${idx}번 게시물)
					${reply.parentreply}</th>
			</tr>
			<tr align="left" >
				<td width="80%" seq2="${reply.replynum}">[${reply.userid}] : ${reply.content} <br>
					작성일:${reply.replydate}
				</td>
				<c:if test="${sessionScope.userid eq reply.userid}">
				<td>
					<button class="btn btn-primary rounded-pill m-2" seq="${reply.replynum}" idx="${idx}"
						id="reply_modify">수정</button>
					<button class="btn btn-primary rounded-pill m-2" seq="${reply.replynum}" idx="${idx}" id="reply_del">삭제</button>
				</td>
				</c:if>
			</tr>
		</c:if>	
	</c:forEach>
</body>
</html>