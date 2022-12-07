<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
// JAVA 코드를 쓰는 영역
// JSP 파일에서 우리가 원하는 모든 작업 가능 (DB 연결, DB 실행, 결과, 화면 출력)
// 장점: 쉬움
// 단점: 분업화 불가, 유지보수 시간 증가 >> 관심사 분리 X

Date date = new Date();
/*
JSP 페이지: UI(html + css + javascript) + JAVA 코드 (<% 스크립트릿 안에 구현)
>> 디자인 코드 + 서버로의 로직 코드 혼재된 방식 (협업, 유지 보수 어려움)
		
servlet(웹 전용 JAVA 파일) (형) + jsp (동생)
>> java 웹 기반 기술 X >> 계산기, 그림판, 윈도우 프로그램 >> 웹 (web.java) >> 웹 전용(request, response)
>> java 페이지로 Web 서비스 >> login.java >> 단점: 어려움 >> 디자인 작업 (협업 불가)
>> jsp 탄생 >> 장점: UI 작업 >> Page >> HTML 기반 디자인 작업 O >> 단점: JAVA <% 안에 사용
>> 혼재 (java + UI 코드)
	
정리)
서로의 장점을 살리자 (현대적인 프로그래밍은 잘하는 것을 기반으로 업무) >> MVC 대두
>> JSP (UI) + JAVA (순수한 자바 코드) + Servlet (웹용 자바)

결국
Model		(DAO, DTO(VO))	>> 순수 JAVA 
View		(UI)			>> JSP
Controller	(응답, 요청 제어)	>> Servlet

MVC 패턴으로 개발 진행 (현재까지의 현업에서)
>> 중간 프로젝트: model2 기반 MVC 패턴 >> model2 (servlet 모든 요청과 처리 담당)
>> model1 >> JSP가 모든 요청, 처리 담당


JSP + HTML 차이점
서비스 하기 위해 공통점: 아파치 톰캣

1. html: web server (아파치): 클라이언트 요청 (ex: http:// www.it.co.kr/login.html)
 		>> web server가 요청 받음 >> login.html 있다면 >> 클라이언트에게 전달 (응답)

2. jsp: was(tomcat)을 통해 컴파일 >> class 파일 생성 >> 생성 파일 실행 (정적 데이터 + 동적 데이터) >> 응답
(ex. http://www.it.co.kr/login.jsp)
 2.1 WAS (jsp) >> compile(login.jsp.java) >> login.jaba.class >> 실행 (정적 데이터 + 동적 데이터  >> 응답
컴파일된 소스 (핵심 경로 ~Catalina\localhost)
C:\KOSA_IT\Web(Back)\Labs\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\work\Catalina\localhost\WebJSP\org\apache\jsp

문제: ASP, ASPX, PHP, JSP 공통 장점
>> 코드 노출 X >> 보안 좋음 >> 클라이언트는 실행된 결과만 본다 (text)

서버 구성: default.jsp
2022년 14:10 서버 오픈
홍길동 최초 요청자 > http://www.it.or.kr/default.jsp > was > 처음 실행인지, 기존에 실행된 적 있는지
처음 실행 (실행 파일 없을 때) >> 컴파일 >> default.jsp.class >> 실행, 메모리 >> 정적 데이터 + 동적 데이터 >> 결과 클라이언트 서비스

김유신 두번째 요청자 > http://www.it.or.kr/default.jsp > was > 처음 실행인지, 기존에 실행된 적 있는지
기존에 실행된 적 있음 >> 실행, 메모리 >> 정적 데이터 + 동적 데이터 >> 결과 클라이언트 서비스

다시 컴파일하고 실행 단계는 어떤 상황
>> 개발자가 코드를 수정했을 경우
>> 웹서버를 재시작한 경우
 	
*/
%>

<%
/*
JSP 구성 요소
1. 선언부: page 지시자 >> 사용 언어, 인코딩, import
<%@ page language="java" ...

2. 스크립트 요소
 2.1. 스크립트릿 <% java code ...
 2.2. 표현식 (출력 방법): 출력 대상(Client 브라우저): <%=  >> response.write
 2.3. 선언부 (공통자원: 공통함수: page scope): <%!
 
*/
%>

<%
// 이 안에 자바 코드
String name = "hello world";
%>

<%!// 공통함수 영역
	// page 안에서만 사용
	public int add(int i, int j) {
		return i + j;
	}%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>JSP 실행하기</h3>
	<%=name%><br>
	<%=add(10, 20)%><br>
	<hr>
	<%
	int result = add(100, 200);
	%>
	<%=result%>
</body>
</html>