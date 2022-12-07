package kr.or.kosa.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.service.MemoAddService;
import kr.or.kosa.service.MemoIdCheckService;
import kr.or.kosa.service.MemoListService;

@WebServlet("*.memo")
public class FrontMemoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FrontMemoController() {
		super();
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// request.setCharacterEncoding("UTF-8");
		// 한글 처리 Filter로 대체
		
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String urlcommand = requestURI.substring(contextPath.length());

		Action action = null;
		ActionForward forward = null;

		if (urlcommand.equals("/MemoAdd.memo")) {
			// 글쓰기
			// UI + 로직
			action = new MemoAddService();
			forward = action.execute(request, response);

		} else if (urlcommand.equals("/MemoList.memo")) {
			// 목록 보기
			// UI + 로직
			action = new MemoListService();
			forward = action.execute(request, response);

		} else if (urlcommand.equals("/MemoId.memo")) {
			// 비동기 사용 유무 (별도의 servlet)
			// 비동기도 동일한 로직으로 처리할지 고민
			// UI + 로직
			action = new MemoIdCheckService();
			forward = action.execute(request, response);

		} else if (urlcommand.equals("/MemoView.memo")) {
			// 만약 상세보기가 있다면
			// ID 중복 확인
			// UI 제공
			
			forward = new ActionForward();
			
			//주소 변경없이 jsp 페이지의 내용을 보여준다.
			forward.setRedirect(false);
			forward = action.execute(request, response);
		}

		
		// ActionForward 객체가 가진 값에 따라 화면 이동을 처리한다.
		// isRedirext가 true 이면 sendRedirect( )를 통해 화면 이동을 처리
		// false라면 forward( )를 통해 화면 이동을 처리한다.
		
		// 페이지 처리 
		if (forward != null) {
			if (forward.isRedirect()) {
				// true 페이지 재 요청 (location.href="페이지"
				response.sendRedirect(forward.getPath());
			} else {
				// 기본적으로 forward ....
				// 1. UI 전달된 경우
				// 2. UI + 로직
				RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
				dis.forward(request, response);
			}
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

}
