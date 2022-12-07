package Controller;

// ctrl+shift+O
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.EmpDao;
import DTO.Emp;

@WebServlet("/EmpList")
public class EmpList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmpList() {
		super();
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("목록 보기");

		request.setCharacterEncoding("UTF-8");

		int id = Integer.parseInt(request.getParameter("eno"));

		EmpDao dao = new EmpDao();

		try {

			Emp emplist = dao.getEmpListByEmpNo(id);

			// List<Emp> emplist = dao.getEmpAllList();

			// 데이터 저장
			request.setAttribute("emplist", emplist);

			// view 지정
			RequestDispatcher dis = request.getRequestDispatcher("/emplist.jsp");

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