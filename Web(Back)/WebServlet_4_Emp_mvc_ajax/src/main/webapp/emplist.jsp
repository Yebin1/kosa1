<%@page import="DAO.EmpDao"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>emplist</title>

</head>
<body>

	<table class="table">

		<tbody>
			<c:set var="e" value="${requestScope.emplist}" />
			<tr>
				<td>${e.empno}</td>
				<td>${e.ename}</td>
				<td>${e.job}</td>
				<td>${e.mgr}</td>
				<td>${e.hiredate}</td>
				<td>${e.sal}</td>
				<td>${e.comm}</td>
				<td>${e.deptno}</td>
			</tr>
		</tbody>
	</table>


</body>

</html>



