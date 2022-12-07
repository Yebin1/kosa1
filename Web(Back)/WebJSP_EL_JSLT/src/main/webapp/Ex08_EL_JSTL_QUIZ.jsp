<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
//request.getParameter(name)   >> jsp?id=kglim&pwd=1004
//String[] hobby = request.getParameterValues("subject")  >>jsp?subject=농구&subject=축구

//JSTL : paramValues   >> java : request.getParameterValues
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
		subject 다중값을 받아서 choose 구문을 사용하여 값이 하나도 선택되지 않았다면
		"선택을 하세요" 라는 문자를 출력하고 
		값이 하나라도 넘어 왔다면 ... <ul><li>java-0-1</li><li>jsp-1-2</li></ul> 과 같은 형식으로
		출력하도록  forEach 를 작성하세요
		추가사항) 출력시  값-index-count 형식으로 나오게 출력하세요
	 -->

	<c:choose>
		<c:when test="${paramValues.subject == null}">
		하나 이상 선택하세요.
		</c:when>
		<c:otherwise>
			<ul>
				<c:forEach items="${paramValues.subject}" var="item" varStatus="status">
        			<li>${item}-${status.index}-${status.count}</li>
				</c:forEach>
			</ul>
		</c:otherwise>
	</c:choose>

</body>
</html>