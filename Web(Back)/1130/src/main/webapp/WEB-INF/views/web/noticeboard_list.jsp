<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
       th, td {
        text-align: center;
      }
    </style>
</head>
<body>
 <c:set var="noticeList" value="${requestScope.noticeList}" />
 <h4 class="mb-4"><b><span style="color:#009CFF;">공지</span>사항</b></h4>                           
                            <table class="table" id="noticeboard">
                                <thead>
                                    <tr>
                                    	<th scope="col">분류</th>
                                        <th scope="col">제목</th>
                                        <th scope="col">글쓴이</th>
                                        <!-- <th scope="col">추천수</th> -->
										<!-- <th scope="col">추천</th> -->
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="noticeList" items="${noticeList}">
                                    <tr onmouseover="this.style.backgroundColor='skyblue'"
											onmouseout="this.style.backgroundColor='white'">
                                       <td align="center"><span style="color:red;">[공지]</span></td>
                                        <td align="left"><a href="boardContent.user?boardname=${noticeList.boardname}&idx=${noticeList.idx}&cp=${cpage}&ps=${pagesize}">
													<c:choose>
														<c:when test="${noticeList.title != null && fn:length(noticeList.title) > 20}">
															${fn:substring(noticeList.title,0,20)}...
														</c:when>
														<c:otherwise>
															${noticeList.title}
														</c:otherwise>
													</c:choose>
											</a></td>
											<%-- <td align="center">${board.lovenum}</td> --%>
											<td>${noticeList.userid}</td>
											</tr>
                                        </c:forEach>
                                </tbody>
                            </table>
</body>
</html>