<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<title>index</title>
		<link href="../css/customer.css" type="text/css" rel="stylesheet" />
	</head>
	<body>
		<jsp:include page="/WEB-INF/views/inc/header.jsp" />
		<jsp:include page="inc/visual.jsp" />
		<div id="main">
			<div class="top-wrapper clear">
				<div id="content">
					<h2>공지사항</h2>
					<h3 class="hidden">방문페이지위치</h3>
					<ul id="breadscrumb" class="block_hlist">
						<li>HOME</li>
						<li>
							고객센터
						</li>
						<li>
							공지사항등록
						</li>
					</ul>
						<form action="" method="post"  enctype="multipart/form-data">
						<div id="notice-article-detail" class="article-detail margin-large" >						
						<dl class="article-detail-row">
							<dt class="article-detail-title">
								사번
							</dt>
							<dd class="article-detail-data">
								<input name="empno">
							</dd>
						</dl>
						<dl class="article-detail-row">
							<dt class="article-detail-title">
								사원
							</dt>
							<dd class="article-detail-data">
								<input name="ename">
							</dd>
						</dl>
						<dl class="article-detail-row half-row">
							<dt class="article-detail-title">
								직종
							</dt>
							<dd class="article-detail-data half-data">
								<input name="job">
							</dd>
						</dl>
						<dl class="article-detail-row">
							<dt class="article-detail-title">
								연봉
							</dt>
							<dd class="article-detail-data">
								<input name="sal">
							</dd>
						</dl>
						<dl class="article-detail-row">
							<dt class="article-detail-title">
								성과급
							</dt>
							<dd class="article-detail-data">
								<input name="comm">
							</dd>
							<dl class="article-detail-row">
							<dt class="article-detail-title">
								부서 번호
							</dt>
							<dd class="article-detail-data">
								<input name="deptno">
							</dd>
						</dl>
						<dl class="article-detail-row">
							<dt class="article-detail-title">
								매니저 번호
							</dt>
							<dd class="article-detail-data">
								<input name="mgr">
							</dd>
						</dl>
					</div>
						<p class="article-comment margin-small">						
							<input class="btn-save button" type="submit" value="저장" />
							<a class="btn-cancel button" href="emp.htm">취소</a>						
						</p>
					</form>							
				</div>				
				<jsp:include page="inc/aside.jsp" />
			</div>
		</div>
		<jsp:include page="../inc/footer.jsp" />
	</body>
</html>
