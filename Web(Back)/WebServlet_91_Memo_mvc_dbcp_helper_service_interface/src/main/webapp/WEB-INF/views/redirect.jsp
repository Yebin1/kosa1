<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- client에게 forward되는 페이지 -->

<%
String msg = (String) request.getAttribute("board_msg");
String url = (String) request.getAttribute("board_url");

if (msg != null && url != null) {
%>
<script>
alert('<%=msg%>');
location.href='<%=url%>';
</script>
<%
}
%>