package kr.or.kosa.service.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.AdminDao;
import kr.or.kosa.dto.Board;

public class AdminBoardReturnListService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;

		try {

			AdminDao adminDao = new AdminDao();

			int totalcount = adminDao.totalCount0();

			String ps = request.getParameter("ps");
			String cp = request.getParameter("cp");

			if (ps == null || ps.trim().equals("")) {
				ps = "5";
			}

			if (cp == null || cp.trim().equals("")) {
				cp = "1";
			}
			int pagesize = Integer.parseInt(ps);
			int cpage = Integer.parseInt(cp);
			int pagecount = 0;

			if (totalcount % pagesize == 0) {
				pagecount = totalcount / pagesize;
			} else {
				pagecount = (totalcount / pagesize) + 1;
			}

			List<Board> boardDeleteList = adminDao.list(cpage, pagesize);

			request.setAttribute("pagesize", pagesize);
			request.setAttribute("cpage", cpage);
			request.setAttribute("pagecount", pagecount);
			request.setAttribute("boardDeleteList", boardDeleteList);
			request.setAttribute("totalcount", totalcount);

			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/views/admin/board_category_return.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return forward;
	}

}
