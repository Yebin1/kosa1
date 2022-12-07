package com;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 
SimpleController extends HttpServlet
SimpleController는 HttpServlet 하고 있음

SimpleContorrler.java 파일 >> 서블릿 (일반 자바 파일을 웹에서 사용할 수 있게 만든 것)

HttpServletRequest request = new HttpServletRequest();
자동 실행 ... request 클라이언트 정보를 담아 ... 필요한 정보를 사용

jsp 파일 같은 경우
주소창에: http:// ... /login.jsp

servlet 파일 같은 경우
주소창에: http:// ... /SimpleControlloer.java ... (x)

web.xml 파일에서 설정
어떤 요청이 들어오면 SimpleController 자바 파일을 컴파일하고 실행하게 할지
어떠한 주소로 요청되면 SimpleController 자바 파일을 컴파일하고 실행하게 할지

<servlet-name>simplecontroller</servlet-name>
<url-pattern>/simple</url-pattern>

http://192.168.0.56:9000/WebServlet_1/simple 요청이 들어오면
해당 요청에 대한 mapping이 존재하는지 확인하고 (web.xml)
컴파일 후 실행

서블릿 조건: 일반 java 파일이 extends HttpServlet 상속 >> 웹 요청(request), 응답(response) 객체 사용
>> Servlet은 url에 바로 요청 X >> 특정 요청에 대해 mapping하는 작업 필요 >> 요청 주소

설정
1. web.xml (구식)
2. @WebServlet (현재) 매핑 작업

- extends HttpServlet
- SimpleController 서블릿 (웹 전용)
- servlet 파일은 이벤트를 기반으로 동작 (다양한 함수는 특정 사건 (이벤트)가 발생하면 호출)

- 자동 호출 함수
protected void doGet
>> http://localhost:9000/WebServlet_1/simple 요청 방식 GET >> doGET 자동 호출

protected void doPost
>> http://localhost:9000/WebServlet_1/simple 요청 방식 POST >> doPOST 자동 호출
>> <form action="" method="POST" ... 인 경우

doGet() 함수와 doPOST()
1. request, response 객체를 받을 수 있도록 설계되어 있음
	(HttpServletRequest request, HttpServletResponse response)
	함수 내 request 객체와 response를 사용해 웹 작업



 */

public class SimpleController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SimpleController() {
		super();
		System.out.println("SimpleController 생성자 함수 실행: 초기화");
	}

	// 요청이 GET 방식인 경우 자동 실행되는 함수
	// 요청에 어떠한 것도 지정하지 않으면 모든 요청은 GET으로 판단
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("클라이언트 요청: GET");

		// 로직 코드
		// JSP에서 사용했던 방식과 같음

		// 1. 한글 처리
		request.setCharacterEncoding("UTF-8");

		// 2. 데이터 받기 (요청에 대한 의도 파악)
		String type = request.getParameter("type");

		// 3. 로직 (업무 수행) >> service 수행
		Object resultobj = null;
		if (type == null || type.equals("greeting")) {
			resultobj = "hello world";
		} else if (type.equals("date")) {
			resultobj = new Date();
		} else {
			resultobj = "invalid String type";
		}

		// 4. 요청 완료에 따른 결과를 저장
		// MVC 패턴 >> JSP (화면) >> 서블릿 요청 파악 처리 >> View 전달 (JSP)
		// 결과를 저장: application, session, request
		// 내가 만든 자원이 모든 페이지에서 필요하지 않다면 application, session 배제
		// request는 해당 페이지에서만 사용되지만 jsp:include, forward를 만나면 ...
		// 답안: request
		request.setAttribute("result", resultobj); // 함수 내에서만 사용 가능한 result

		// 5. 저장한 결과를 JSP 페이지에게 전달 (UI 구성하도록)
		// forward 방식으로 JSP까지
		// forward: 요청한 주소는 변하지 않고 다른 페이지 내용을 서비스할 수 있다는 것이 장점
		RequestDispatcher dis = request.getRequestDispatcher("/simpleview.jsp");
		
		// 특정 페이지에 원하는 정보를 전달 (forward)
		dis.forward(request, response); // request 객체의 주소값을 같이 넘긴다 (parameter로)
		// servlet이 가지고 있는 request 객체의 주소와 response 객체의 주소를
	}

	// 요청이 POST 방식인 경우 자동 실행되는 함수
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("클라이언트 요청: POST");

		// 로직 코드

	}

}
