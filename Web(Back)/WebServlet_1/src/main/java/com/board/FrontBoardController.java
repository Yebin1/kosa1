package com.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(description = "게시판 컨트롤러", urlPatterns = { "/Board" })
public class FrontBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FrontBoardController() {
		super();

	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response, String method)
			throws ServletException, IOException {

		// GET 혹은 POST 방식의 요청을 doProcess 함수에서 처리
		// method parameter 요청 방식 파악
		System.out.println("클라이언트 요청 방식: " + method);
		
		// 1. 한글 처리
		// 2. 데이터 받기 (요청 받기) request 사용
		// 3. 요청 판단 (판단의 기준: cmd=value >> command 방식)
		//  3.1. http://192.168.0.56:9000/WebServlet_1/Board?cmd=login&id=kglim&pwd=1004 서버로 요청 보냄
		//	3.2. cmd 값으로 판단 >> 로그인 처리 >> id, pwd 값을 받아서 ... >> parameter 값으로 판단하는 command 방식
		//	단점: parameter를 받지 않으면 안됨
		//	cmd=list >> 게시판 목록 >> 처럼 개발자가 정함
		
		// 4. 결과 저장 (request, session, application)
		// session: WAS 전체에서 모든 페이지 공유할 때 사용
		// application: 조회수 볼 때 사용 (ex: 사이트 접속 횟수 카운트)
		// request 내 페이지에서만 동작 (해당 단점 보완 >> jsp:include, jsp:forward)
		
		// 5. View 지정
		// 6. View 에게 데이터 전달 (forward)
		
		request.setCharacterEncoding("UTF-8");
		
		String cmd = request.getParameter("cmd");
		
		String viewpage = null;
		
		// cmd가 null이라면 error.jsp
		// cmd가 boardlist라면 list.jsp
		// cmd가 boardwrite라면 write.jsp 를 클라이언트에게 서비스
		if (cmd == null) {
			viewpage = "/error/Error.jsp";
		} else if (cmd.equals("boardlist")) {
			// 실제 코드
			/*
			DB 연결 > select > 객체에 담기
			boardDao dao = boardDao();
			List<board> boardlist = dao.selectBoardList(); 
			request.setAttribute("list", boardlist);
			forward > view에 객체 전달 > JSP request.getAttribute("list"); 한 후 출력
			*/
			
			viewpage = "/board/boardlist.jsp";
		
		} else if (cmd.equals("boardwrite")) {
			viewpage = "/board/boardwrite.jsp";
		} else if (cmd.equals("boarddelete")) {
			viewpage = "/board/boarddelete.jsp";
		} else if (cmd.equals("login")) {
			viewpage = "/WEB-INF/views/login/login.jsp"; // 실무 코드
		} else {
			viewpage = "/error/Error.jsp";
		}
		
		// 결과 저장
		// List<board> boardlist = dao.selectBoardList(); 
		// request.setAttribute("list", boardlist);
		
		// view 지정
		RequestDispatcher dis = request.getRequestDispatcher(viewpage);
		
		// 데이터 전달 (forward)
		dis.forward(request, response); // request 객체 view에게 통으로 전달
		
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 같은 로직
		doProcess(request, response, "GET");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 같은 로직
		doProcess(request, response, "POST");
	}

}
