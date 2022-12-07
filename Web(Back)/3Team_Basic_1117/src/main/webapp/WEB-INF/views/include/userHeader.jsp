<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<header>
    
    <div class="title">
    	<a href="${pageContext.request.contextPath}">Main(index페이지 호출)</a>
    </div>
    
    <div class="links">        
		<c:choose>
		    <c:when test="${sessionScope.id ne null}">
		          ${sessionScope.id } 님
		          <span href = "logout.do">log out</span>
		    </c:when>
		    <c:otherwise>        
		        <span href = "login.do">sign in</span>
		    </c:otherwise>
		</c:choose>
		           
		<c:choose>
		    <c:when test="${sessionScope.id ne null}">
		         <span href = "logout.do">로그아웃</span>
		    </c:when>
		    <c:otherwise>
		        <span href = "login.do">로그인</span>
		    </c:otherwise>
		</c:choose>
		
		<c:choose>
			<c:when test="${sessionScope.id ne null}">
			    <a href="logout.do"><i></i>
			    <span>Sign Out</span></a>
			</c:when>
			<c:otherwise>
			   <a href="login.do">
			   <span>Sign in</span></a>    
			</c:otherwise>
		</c:choose>
    </div>
    <br>
    <div id="menu">
                <div style="text-align:center;margin-top:1px;
        	border:solid 1px;padding:5px">
                	<!-- a : 페이지 이동을 처리하는 마크업 -->
					<a href="${pageContext.request.contextPath}/TroubleShooting.board">트러블 슈팅</a>&emsp;&emsp;
					<a href="${pageContext.request.contextPath}/QnA.board">질문과 답변</a>&emsp;&emsp;
					<a href="${pageContext.request.contextPath}/ProjectTogether.board">프로젝트 모집</a>&emsp;&emsp;
					<a href="${pageContext.request.contextPath}/FreeBoard.board">자유게시판</a>&emsp;&emsp;
					<a href="${pageContext.request.contextPath}/Notice.board">공지사항</a>
            </div>
        </div>
        
</header>