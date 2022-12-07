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
	<c:set var="myList" value="${requestScope.myList}" />
	<c:set var="totalboardcount" value="${requestScope.totalboardcount}" />
	<c:set var="userid" value="${requestScope.userid}" />

	<div id="pagecontainer">
		<div>
			<table width="80%" border="1" cellspacing="0" align="center">
				<tr>
					<td colspan="6">
						<form name="myList">
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
					<th width="10%">순번</th>
					<th width="15%">게시판</th>
					<th width="40%">제목</th>
					<th width="15%">날짜</th>
					<th width="10%">추천수</th>
					<th width="10%">조회수</th>
				</tr>
				<c:forEach var="board" items="${myList}">
					<tr onmouseover="this.style.backgroundColor='skyblue'"
						onmouseout="this.style.backgroundColor='white'">
						<td align="center">${board.idx}</td>
						<td align="center">${board.boardname}</td>
						<td align="left"><a
							href="boardContent.user?boardname=${boardname}&idx=${board.idx}&cp=${cpage}&ps=${pagesize}">
								<c:choose>
									<c:when
										test="${board.title != null && fn:length(board.title) > 20}">
										${fn:substring(board.title,0,20)}...
									</c:when>
									<c:otherwise>
										${board.title}
									</c:otherwise>
								</c:choose>
						</a></td>
						<%-- <td align="center">${board.userid}</td> --%>
						<td align="center">${board.writedate}</td>
						<td align="center">${board.lovenum}</td>
						<td align="center">${board.readnum}</td>
					</tr>
				</c:forEach>
				<!-- forEach()  -->
				<tr>
					<td colspan="6" align="center">
						<hr width="100%" color="red">
					</td>
				</tr>
				<tr>
					<td colspan="3" align="center">
						<!--이전 링크 --> <c:if test="${cpage > 1}">
							<a
								href="myboardList.user?&userid=${userid}&cp=${cpage-1}&ps=${pagesize}">이전</a>
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
								href="myboardList.user?&userid=${userid}&cp=${cpage+1}&ps=${pagesize}">다음</a>
						</c:if>
					</td>
					<td colspan="3" align="center">총 게시물 수 : ${totalboardcount}</td>
				</tr>
				<tr>
					<td colspan="6" align="center"></td>
			</table>
		</div>
	</div>
	<div>
		<a href="myreplyList.user">댓글 목록 보기</a>
	</div>
</body>
</html>