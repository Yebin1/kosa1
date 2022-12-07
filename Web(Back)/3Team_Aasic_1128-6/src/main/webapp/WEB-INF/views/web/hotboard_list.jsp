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
 <c:set var="hotList" value="${requestScope.hotList}" />
<h4 class="mb-4"><b><span style="color:red;">HOT</span>게시판</b></h4>                           
                            <table class="table" id="hotboard">
                                <thead>
                                    <tr>
                                    	<th scope="col">게시판</th>
                                        <th scope="col">제목</th>
                                        <th scope="col">글쓴이</th>
                                        <!-- <th scope="col">추천수</th> -->
										<th scope="col">추천</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="hotList" items="${hotList}">
                                    <tr onmouseover="this.style.backgroundColor='skyblue'"
											onmouseout="this.style.backgroundColor='white'">
                                       <td align="center"><a href="boardList.user?boardname=${hotList.boardname}">[${hotList.boardname}]</a></td>
                                        <td align="left"><a href="boardContent.user?boardname=${hotList.boardname}&idx=${hotList.idx}&cp=${cpage}&ps=${pagesize}">
													<c:choose>
														<c:when test="${hotList.title != null && fn:length(hotList.title) > 20}">
															${fn:substring(hotList.title,0,20)}...
														</c:when>
														<c:otherwise>
															${hotList.title}
														</c:otherwise>
													</c:choose>
											</a></td>
											<%-- <td align="center">${board.lovenum}</td> --%>
											<td>${hotList.userid}</td>
											<td align="center">${hotList.lovenum}</td>
											</tr>
                                        </c:forEach>
                                </tbody>
                            </table>
</body>
</html>