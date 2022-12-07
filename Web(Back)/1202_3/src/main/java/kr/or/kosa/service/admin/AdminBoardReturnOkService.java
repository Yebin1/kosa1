package kr.or.kosa.service.admin;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.CommonDao;

public class AdminBoardReturnOkService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String idx = request.getParameter("idx");

		String boardname = request.getParameter("boardname");

		String msg = "";
		String url = "";

		CommonDao dao;
		try {
			dao = new CommonDao();
			int result = 0;

			result = dao.adminReturnOk(idx);

			if (result > 0) {
				msg = "복구 완료";
				url = "AdminBoardReturn.admin";
			} else {
				msg = "복구 완료";
				url = "AdminBoardReturn.admin";
			}

		} catch (NamingException e) {
			e.printStackTrace();
		}

		request.setAttribute("board_msg", msg);
		request.setAttribute("board_url", url);

		ActionForward forward = new ActionForward();
		forward.setRedirect(false); 
		forward.setPath("/WEB-INF/views/web/redirect.jsp");

		return forward;
	}

}
