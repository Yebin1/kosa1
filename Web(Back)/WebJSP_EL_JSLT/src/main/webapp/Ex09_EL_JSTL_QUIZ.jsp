<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="DTO.Emp"%>
<%@page import="DAO.EmpDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.Connection"%>
<%@page import="UTILS.SingletonHelper"%>

<!--  
종합 퀴즈 (조별 퀴즈)

EMP 테이블에서 사원전체 데이터를 출력하는 DTO , DAO 를 작성하세요 (JDBC 참고)
그리고 그 데이터 14건을 
EL & JSTL 을 사용해서 출력하세요
단)부트템플릿 사용하세요
-->
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

<%
/* EmpDao ed = new EmpDao();
List<Emp> emplist = ed.getEmpAllList(); */
request.setAttribute("e", new EmpDao().getEmpAllList());
%>

	<%-- <c:set var="emplist" value="${requestScope.e}"></c:set> --%>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">EMPNO</th>
				<th scope="col">ENAME</th>
				<th scope="col">JOB</th>
				<th scope="col">MGR</th>
				<th scope="col">HIREDATE</th>
				<th scope="col">SAL</th>
				<th scope="col">COMM</th>
				<th scope="col">DEPTNO</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="e" items="${e}">
			<!-- c:forEach var="e" items="${emplist}" -->
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
			</c:forEach>
		</tbody>
	</table>


</body>

</html>