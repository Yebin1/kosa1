<%@page import="DTO.Dept"%>
<%@page import="java.util.List"%>
<%@page import="DAO.DeptDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
DeptDao deptdao = new DeptDao();
List<Dept> deptlist = deptdao.getDeptAllList();
request.setAttribute("d", deptlist);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
	padding: 1.5em;
	background: #f5f5f5
}

table {
	border: 1px #a39485 solid;
	font-size: .9em;
	box-shadow: 0 2px 5px rgba(0, 0, 0, .25);
	width: 100%;
	border-collapse: collapse;
	border-radius: 5px;
	overflow: hidden;
}

th {
	text-align: left;
}

thead {
	font-weight: bold;
	color: #fff;
	background: #73685d;
}

td, th {
	padding: 1em .5em;
	vertical-align: middle;
}

td {
	border-bottom: 1px solid rgba(0, 0, 0, .1);
	background: #fff;
}

a {
	color: #73685d;
}

@media all and (max-width: 768px) {
	table, thead, tbody, th, td, tr {
		display: block;
	}
	th {
		text-align: right;
	}
	table {
		position: relative;
		padding-bottom: 0;
		border: none;
		box-shadow: 0 0 10px rgba(0, 0, 0, .2);
	}
	thead {
		float: left;
		white-space: nowrap;
	}
	tbody {
		overflow-x: auto;
		overflow-y: hidden;
		position: relative;
		white-space: nowrap;
	}
	tr {
		display: inline-block;
		vertical-align: top;
	}
	th {
		border-bottom: 1px solid #a39485;
	}
	td {
		border-bottom: 1px solid #e5e5e5;
	}
}
</style>
</head>
<body>

<c:set var="deptlist" value="${requestScope.d}"></c:set>
<table class="table">
<thead>
<tr>
<th scope="col">DEPTNO</th>
<th scope="col">DNAME</th>
<th scope="col">LOC</th>
</tr>
</thead>
<tbody>
<c:forEach var="d" items="${deptlist}">
<tr>
<td>${d.deptno}</td>
<td>${d.dname}</td>
<td>${d.loc}</td>
</tr>
</c:forEach>
</tbody>
</table>


</body>
</html>