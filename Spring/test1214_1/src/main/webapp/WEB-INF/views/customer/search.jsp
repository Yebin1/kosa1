<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<title>index</title>
		<link href="notice.css" type="text/css" rel="stylesheet" />
	</head>
	<body>
		<jsp:include page="/WEB-INF/views/inc/header.jsp" />
		<jsp:include page="inc/visual.jsp" />
	
		<div id="main">
			<div class="top-wrapper clear">
				<div id="content">
					<h2>공지사항</h2>
					<h3 class="hidden">방문페이지 로그</h3>
					<ul id="breadscrumb" class="block_hlist clear">
						<li>HOME</li>
						<li>
							고객센터
						</li>
						<li>
							공지사항목록
						</li>
					</ul>
					<h3 class="hidden">공지사항 목록</h3>
					<form id="content-searchform" class="article-search-form" action="emp.jsp" method="get">
						<fieldset>
							<legend class="hidden">
								목록 검색 폼
							</legend>
							<input type="hidden" name="pg" value="" />
							<label for="f"
							class="hidden">검색필드</label>
							<label class="hidden" for="q">검색어</label>
							<input type="text"
							name="q" value="" />
							<input type="submit" value="검색" />
						</fieldset>
					</form>
					<table class="article-list margin-small">
						<caption class="hidden">
							사원 목록
						</caption>
						<thead>
							<tr >
								<th class="empno">사번</th>
								<th class="ename">사원</th>
								</tr>
						</thead>
						<tbody>
							<c:forEach items="${list}" var="n">
							<tr>
								<td class="empno">${n.empno}&emsp;|&emsp;</td>
								<td class="ename">${n.ename}&emsp;|&emsp;</td>
								<td class="job">${n.job}&emsp;|&emsp;</td>
								<td class="mgr">${n.mgr}&emsp;|&emsp;</td>
								<td class="hiredate">${n.hiredate}&emsp;|&emsp;</td>
								<td class="sal">${n.sal}&emsp;|&emsp;</td>
								<td class="comm">${n.comm}&emsp;|&emsp;</td>
								<td class="deptno">${n.deptno}&emsp;|&emsp;</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
					<p class="article-comment margin-small">
						<button id="insertbtn" href="noticeReg.htm">사원 추가</button>
					</p>
					
				</div>
				<jsp:include page="inc/aside.jsp" />
			</div>
		</div>
		
		<jsp:include page="../inc/footer.jsp" />
	</body>
</html>
