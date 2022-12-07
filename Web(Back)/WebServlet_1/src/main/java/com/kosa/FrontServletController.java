package com.kosa;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(description = "설명란", urlPatterns = { "/action.do" })
public class FrontServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FrontServletController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("GET");
		// http://192.168.0.56:9000/WebServlet_1/action.do?cmd=greeting
		
		// 1. 한글 처리
		request.setCharacterEncoding("UTF-8");
		
		// 2. 데이터 받기
		String cmd = request.getParameter("cmd");
		
		// 3. 로직 (요청 판단)
		String msg = "";
		if (cmd.equals("greeting")) {
			// java 파일 사용 용이 (DAO, DTO)
			Message message = new Message();
			msg = message.getMessage(cmd);
		} else {
			
		}
		
		// 4. 데이터 저장
		request.setAttribute("msg", msg);
		
		// 5. view 페이지 설정
		// Dispatcher: View 지정하기
		RequestDispatcher dis = request.getRequestDispatcher("/greeting.jsp");
		
		// 6. view 페이지 전달 (forward)
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("POST");
	}

}
