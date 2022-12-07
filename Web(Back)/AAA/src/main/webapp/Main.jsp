<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
	border: solid 2px black;
	border-collapse: collapse;
}

tr {
	border: solid 1px blue;
	background-color: white;
	color: black;
}

td {
	border: solid 1px red;
}
</style>
</head>
<body>
	<table
		style="width: 900px; height: 500px; margin-left: auto; margin-right: auto;">
		<tr>
			<td colspan="2">
				<jsp:include page="/common/Top.jsp"></jsp:include>
			</td>
		</tr>
		<tr>
			<td style="width: 200px">
				<jsp:include page="/common/Left.jsp"></jsp:include>
			</td>
			<td style="width: 700px">
				<!-- MAIN PAGE CONTENT  -->
				<%
					String id = null;
					id = (String)session.getAttribute("id");
					
					if(id == null){
						out.print("<hr>회원가입을 해주세요^^</hr>");
					}
					else{
						out.print("<script>");
						out.print("alert('로그인되었습니다.');");
						out.print("</script>");
						if(id.equals("admin"))
						{
							out.print("<a href='memberlist.do'>회원관리</a>");
						}
							
					}

				%>
			</td>
		</tr>
		<tr>
			<td colspan="2"><jsp:include page="/common/Bottom.jsp"></jsp:include></td>
		</tr>
	</table>
</body>
</html>


