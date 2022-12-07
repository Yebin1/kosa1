<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

  String msg = (String)request.getAttribute("board_msg");
  String url = (String)request.getAttribute("board_url");
  
  if(msg != null && url != null){
%>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script>
		alert('<%= msg %>');
		<%--  ("알림","<%= msg %>","success"); --%>
	    location.href='<%=url%>';
	</script>
	
<%	  
  }
%>