<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<jsp:include page="/WEB-INF/views/include/userHeader.jsp"></jsp:include>
	<br>

	<c:set var="pagesize" value="${requestScope.pagesize}" />
	<c:set var="cpage" value="${requestScope.cpage}" />
	<c:set var="pagecount" value="${requestScope.pagecount}" />
	<c:set var="myList" value="${requestScope.myReplyList}" />
	<c:set var="totalboardcount" value="${requestScope.totalreplycount}" />

	<div id="pagecontainer">
		<div>
			<table width="80%" border="1" cellspacing="0" align="center">
				<tr>
					<td colspan="5">
						<form name="myReplyList">
							PageSize설정: <select name="ps" onchange="submit()">
								<c:forEach var="i" begin="5" end="20" step="5">
									<c:choose>
										<c:when test="${pagesize == i}">
											<option value="${i}" selected>${i}건</option>
										</c:when>
										<c:otherwise>
											<option value="${i}">${i}건</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
						</form>
					</td>
				</tr>
				<tr>
					<th width="5%">순번</th>
					<!-- <th width="15%">게시판</th> -->
					<th width="25%">글 제목</th>
					<th width="30%">댓글 내용</th>
					<th width="15%">날짜</th>
					<th width="15%">추천수</th>
				</tr>
				<c:forEach var="board" items="${myReplyList}">
					<tr onmouseover="this.style.backgroundColor='skyblue'"
						onmouseout="this.style.backgroundColor='white'">
						<td align="center">${reply.idx}</td>
						<%-- <td align="center">${board.boardname}</td> --%>
						<td align="left"><a
							href="boardContent.user?boardname=${boardname}&idx=${reply.idx}&cp=${cpage}&ps=${pagesize}">
								<c:choose>
									<c:when
										test="${reply.content != null && fn:length(reply.content) > 20}">
										${fn:substring(reply.content,0,20)}...
									</c:when>
									<c:otherwise>
										${reply.content}
									</c:otherwise>
								</c:choose>
						</a></td>
						<%-- <td align="center">${board.userid}</td> --%>
						<td align="center">${board.writedate}</td>
						<td align="center">${board.refernum}</td>
					</tr>
				</c:forEach>
				<!-- forEach()  -->
				<tr>
					<td colspan="5" align="center">
						<hr width="100%" color="red">
					</td>
				</tr>
				<tr>
					<td colspan="3" align="center">
						<!--이전 링크 --> <c:if test="${cpage > 1}">
							<a
								href="myboardList.user?cp=${cpage-1}&ps=${pagesize}">이전</a>
						</c:if> <!-- page 목록 나열하기 --> <c:forEach var="i" begin="1"
							end="${pagecount}" step="1">
							<c:choose>
								<c:when test="${cpage==i}">
									<font color="red">[${i}]</font>
								</c:when>
								<c:otherwise>
									<a
										href="myboardList.user?cp=${i}&ps=${pagesize}">[${i}]</a>
								</c:otherwise>
							</c:choose>
						</c:forEach> <!--다음 링크 --> <c:if test="${cpage < pagecount}">
							<a
								href="myboardList.user?cp=${cpage+1}&ps=${pagesize}">다음</a>
						</c:if>
					</td>
					<td colspan="2" align="center">총 게시물 수 : ${totalboardcount}</td>
				</tr>
				<tr>
					<td colspan="5" align="center"></td>
			</table>
		</div>
	</div>
	<div>
		<a href="myboardList.user">글 목록 보기</a>
	</div>
</body>
</html>