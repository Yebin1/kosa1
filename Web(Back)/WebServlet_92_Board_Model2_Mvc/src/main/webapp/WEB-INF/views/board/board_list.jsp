<%@page import="kr.or.bit.utils.ThePager"%>
<%@page import="kr.or.bit.dto.Board"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="Stylesheet" href="${request.getContextPath}style/default.css" />
</head>
<body>
   <c:import url="/WEB-INF/views/include/header.jsp" />
   게시판 목록
   <br>
   <%
      /* BoardService service = BoardService.getInBoardService();
      
      //게시물 총 건수
      int totalboardcount = service.totalBoardCount();
      
      //상세보기 >> 다시  LIST 넘어올때  >> 현재 페이지 설정
      String ps = request.getParameter("ps"); //pagesize
      String cp = request.getParameter("cp"); //current page
      
      //List 페이지 처음 호출 ...
      if(ps == null || ps.trim().equals("")){ //처음에 페이지당 5개씩 보여주는게 기본값
         //default 값 설정
         ps = "5"; //5개씩 
      }
   
      if(cp == null || cp.trim().equals("")){  //처음 띄워주는 페이지 1번 페이지
         //default 값 설정
         cp = "1"; // 1번째 페이지 보겠다 
      }
      
      int pagesize = Integer.parseInt(ps);  //문자열로 받아오니까 숫자로 변환
      int cpage = Integer.parseInt(cp);
      int pagecount=0;
      
      //23건  % 5
      if(totalboardcount % pagesize == 0){  //전체 게시물을 페이지 사이즈로 나눠서 전체 페이지수를 정함
         pagecount = totalboardcount / pagesize; //  20 << 100/5
      }else{
         pagecount = (totalboardcount / pagesize) + 1;  //마지막 페이지 +1 하고 거기에 나머지 게시물 수 넣음
      }
      
      //102건 : pagesize=5 >> pagecount=21페이지
      
      //전체 목록 가져오기
      List<Board> list = service.list(cpage, pagesize); //list >> 1 , 20
       */
    %>
   <c:set var="pagesize" value="${requestScope.pagesize}" />
   <c:set var="cpage" value="${requestScope.cpage}" />
   <c:set var="pagecount" value="${requestScope.pagecount}" />
   <c:set var="list" value="${requestScope.list}" />
   <c:set var="totalboardcount" value="${requestScope.totalboardcount}" />
   <c:set var="pager" value="${requestScope.pager}" />
   
   <div id="pagecontainer">
      <div style="padding-top: 30px; text-align: cetner">
         <table width="80%" border="1" cellspacing="0" align="center">
            <tr>
               <td colspan="5">  <!-- <td>의 갯수 5개를 합친 너비  -->
                  <!--  
                     form 태그 action 전송 주소(목적지) >> submit()
                     >> form name="list" ... action 없다면.. 
                     >> [현재 URL 창에 있는 주소] 그대로  .....   
                     >> board_list.jsp?ps=select 태그 값으로 .... 다시 호출 .....
                     >>http://192.168.0.169:8090/WebServlet_5_Board_Model1_Sample/board/board_list.jsp?ps=10               
                  -->
                  <form name="list" >
                   PageSize설정: 
                     <select name="ps" onchange="submit()">
                        <c:forEach var="i" begin="5" end="20" step="5">
                              <c:choose>
                                 <c:when test="${pagesize == i}">
                                    <option value="${i}" selected>${i}건</option>
                                 </c:when>
                                 <c:otherwise>
                                    <option value="${i}">${i}건 </option>
                                 </c:otherwise>
                              </c:choose>
                        </c:forEach>
                        </select>
                  </form>
               </td>
            </tr>
            <tr>
               <th width="10%">순번</th>
               <th width="40%">제목</th>
               <th width="20%">글쓴이</th>
               <th width="20%">날짜</th>
               <th width="10%">조회수</th>
            </tr>
            <!-- 데이터가 한건도 없는 경우  -->
            <%-- <%
                 if(list == null || list.size() == 0){
                    out.print("<tr><td colspan='5'>데이터가 없습니다</td></tr>");
                 }
              %> --%>
            <!-- forEach()  목록 출력하기  -->
            <c:forEach var="board" items="${list}">
               <tr onmouseover="this.style.backgroundColor='gray'" onmouseout="this.style.backgroundColor='white'">
                  <td align="center">${board.idx}</td>
                  <td align="left">
                     <c:forEach var="i" begin="1" end="${board.depth}" step="1">
                        &nbsp;&nbsp;&nbsp;
                     </c:forEach>
                     <c:if test="${board.depth > 0}">
                        <img src="${pageContext.request.contextPath}/images/re.gif">
                     </c:if>
                     <a href="boardContent.do?idx=${board.idx}&cp=${cpage}&ps=${pagesize}">
                        <c:choose>
                           <c:when test="${board.subject != null && fn:length(board.subject) > 10}">
                              ${fn:substring(board.subject,0,10)}...
                           </c:when>
                           <c:otherwise>
                              ${board.subject}
                           </c:otherwise>
                        </c:choose>
                     </a>
                  </td>
                  <td align="center">${board.writer}</td>
                  <td align="center">${board.writedate}</td>
                  <td align="center">${board.readnum}</td>
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
               <!--  
               원칙적인 방법 아래 처럼 구현
               [1][2][3][다음]
               [이전][4][5][6][다음]
               [이전][7][8][9][다음]
               [이전][10][11]
               
               현재 아래 코드 [][][][][][][]...
               -->
               
                  <!--이전 링크 --> 
                  <c:if test="${cpage > 1}">
                     <a href="boardlist.do?cp=${cpage-1}&ps=${pagesize}">이전</a>
                  </c:if>
                  <!-- page 목록 나열하기 -->
                  <c:forEach var="i" begin="1" end="${pagecount}" step="1">
                     <c:choose>
                        <c:when test="${cpage==i}">
                              <font color="red" >[${i}]</font>
                        </c:when>
                        <c:otherwise>
                           <a href="boardlist.do?cp=${i}&ps=${pagesize}">[${i}]</a>
                        </c:otherwise>
                     </c:choose>
                  </c:forEach>
                  <!--다음 링크 --> 
                  <c:if test="${cpage < pagecount}">
                     <a href="boardlist.do?cp=${cpage+1}&ps=${pagesize}">다음</a>
                  </c:if>
               </td>
               <td colspan="2" align="center">총 게시물 수 : ${totalboardcount}
               </td>
            </tr>
            <tr>
               <%-- <td colspan="5" align="center">
               ${pager}
               <%
                  int pagersize=3; //[1][2][3]
                  ThePager pager = new ThePager(totalboardcount,cpage,pagesize,pagersize,"board_list.jsp");
               %>
               <%= pager.toString() %>
               </td> --%>
         </table>
      </div>
   </div>
</body>
</html>


