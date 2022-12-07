package kr.or.kosa.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.dao.MemoDao;
import kr.or.kosa.dto.Memo;

@WebServlet("/MemoId")
public class MemoId extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MemoId() {
        super();
    }

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 비동기 요청 받기
		// 클라이언트가 전달한 id값 받기
		// DB 연결, 쿼리문 (select id from memo where id=?)
		// isCheckById(String id)
		
		// isCheckById 호출 >> return값 받아서
		
		// view 페이지 만들지 말고 out 객체 사용 (out.print) true, false 값 ...
		System.out.println(request.getParameter("id"));
		
		// 서버 입장에서는 동기, 비동기 상관X
		// forward 안 하는 이유: 굳이 jsp 하나 더 만들 필요가 없으므로
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String id = request.getParameter("id");
		MemoDao dao = new MemoDao();
		String idcheck = dao.isCheckById(id);
		
		// 비동기이므로 클라이언트에게 true, false값 직접 전달
		out.print(idcheck);

	}
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doProcess(request, response);
	}

}
