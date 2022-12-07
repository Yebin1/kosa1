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
	<c:set var="totalreplycount" value="${requestScope.totalreplycount}" />

	<div id="pagecontainer">
		<div>
			<table width="80%" border="1" cellspacing="0" align="center">
				<tr>
					<td colspan="6">
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
					<th width="15%">게시판</th>
					<th width="25%">글 제목</th>
					<th width="35%">댓글 내용</th>
					<th width="15%">날짜</th>
					<th width="10%">추천수</th>
				</tr>

				<c:forEach var="list" items="${myReplyList}">
					<tr align="center">
						<c:forEach var="i" items="${list}">
							<td>${i.value}</td>
						</c:forEach>
					</tr>
				</c:forEach>
				<!-- forEach()  -->
				<tr>
					<td colspan="6" align="center">
						<hr width="100%" color="blue">
					</td>
				</tr>
				<tr>
					<td colspan="4" align="center">
						<!--이전 링크 --> <c:if test="${cpage > 1}">
							<a href="myreplyList.user?cp=${cpage-1}&ps=${pagesize}">이전</a>
						</c:if> <!-- page 목록 나열하기 --> <c:forEach var="i" begin="1"
							end="${pagecount}" step="1">
							<c:choose>
								<c:when test="${cpage==i}">
									<font color="blue">[${i}]</font>
								</c:when>
								<c:otherwise>
									<a href="myreplyList.user?cp=${i}&ps=${pagesize}">[${i}]</a>
								</c:otherwise>
							</c:choose>
						</c:forEach> <!--다음 링크 --> <c:if test="${cpage < pagecount}">
							<a href="myreplyList.user?cp=${cpage+1}&ps=${pagesize}">다음</a>
						</c:if>
					</td>
					<td colspan="3" align="center">총 게시물 수 : ${totalreplycount}</td>
				</tr>
				<tr>
					<td colspan="6" align="center"></td>
			</table>
		</div>
	</div>
	<div>
		<a href="myboardList.user"> 내 글 보기</a>
	</div>
</body>
</html>