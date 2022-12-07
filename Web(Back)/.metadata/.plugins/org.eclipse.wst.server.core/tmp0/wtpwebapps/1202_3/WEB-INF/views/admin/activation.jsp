
<%@page import="java.util.List"%>
<%@page import="kr.or.kosa.dto.Member"%>
<%@page import="kr.or.kosa.dto.MemberDetail"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


	<c:choose>
		<c:when test="${requestScope.userStatus == 0}">
			<a href='#' onclick="alert('비활성화 성공!');"><img src='./images/Button_Icon_Red.svg' width="18px" heigth="18px" id='activation_img'>
		</c:when>
		<c:otherwise>
			<a href='#' onclick="alert('활성화 성공!');"><img src='./images/activation_button.png' width="18px" heigth="18px"  id='activation_img' ></a>
		</c:otherwise>
	</c:choose>