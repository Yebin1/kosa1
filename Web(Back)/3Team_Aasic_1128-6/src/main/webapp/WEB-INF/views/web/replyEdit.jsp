<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<body>
		<c:set var="idx" value="${requestScope.idx }" />
		<c:set var="seq" value="${requestScope.seq }" />
		<textarea class="form-control" id="reply_content_update" name="reply_content_update" rows="2"
			style="height: 150px;" placeholder="Leave a comment here" required></textarea> <br>
		<button seq="${seq}" idx="${idx}" type="button" id="reply_update"
			class="btn btn-info rounded-pill m-2">등록</button>
		<button class="btn btn-info rounded-pill m-2" type="reset" id="reply_cancel">취소</button>	
</body>
</html>