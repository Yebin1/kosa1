package kr.or.kosa.controller;

// ctrl+shift+O
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.dao.MemoDao;
import kr.or.kosa.dto.Memo;

@WebServlet("/MemoList")
public class MemoList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemoList() {
		super();
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("목록 보기");
		
		// 요청 http://192.168.0.56:9000/WebServlet_4_Memo_mvc/MemoList
		MemoDao dao = new MemoDao();
		
		try {
			List<Memo> memolist = dao.getMemoAllList();
			
			// 데이터 저장
			request.setAttribute("memolist", memolist);
			
			// view 지정
			RequestDispatcher dis = request.getRequestDispatcher("/memolist.jsp");
			
			// forward
			dis.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
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
