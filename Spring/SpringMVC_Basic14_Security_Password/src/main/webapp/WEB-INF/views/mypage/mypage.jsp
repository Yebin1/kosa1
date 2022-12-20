<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<title>index</title>
		<link href="login.css" type="text/css" rel="stylesheet" />
	</head>
	<body>
		<jsp:include page="/WEB-INF/views/inc/header.jsp" />
		<jsp:include page="inc/visual.jsp" />
		<div id="main">
			<div class="top-wrapper clear">
				<div id="content">
					<h2>마이페이지</h2>
					<h3 class="hidden">방문페이지 로그</h3>
					<ul id="breadscrumb" class="block_hlist clear">
						<li>
							HOME
						</li>
						<li>
							마이페이지
						</li>
						<li>
							본인 확인
						</li>
					</ul>
					<h3 class="hidden">마이페이지</h3>
					<div id="join-form" class="join-form margin-large" >						
						<c:if test="${param.error != null}">
   							<div>
     							본인 확인 실패<br>
     							<c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
     							 	이유 : <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />
    							</c:if>
   							</div>
  						</c:if>  
						
					<form action="${pageContext.request.contextPath}/mypage" method="post">                            
						<fieldset>
                                <legend class="hidden">로그인 폼</legend>
                                <h3><img src="images/txtTitle.png" /></h3>
                                <ul id="mypageBox">
                                    <li><label for="pwd">비밀번호</label>
                                    			<input type="password" name="password" class="text" /></li>
                                </ul>
                                <p><input type="submit" id="btnMypage" value="" /></p>
                            </fieldset>
						</form>
					</div>
					
				</div>
				<jsp:include page="inc/aside.jsp" />
			</div>
		</div>
		<jsp:include page="../inc/footer.jsp" />
	</body>
</html>
