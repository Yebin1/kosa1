package kr.or.kosa.service.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.MemberDao;
import kr.or.kosa.dto.Board;

public class MyBoardListService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;

		try {
			MemberDao memberDao = new MemberDao();

			HttpSession session = request.getSession();
			String userid = (String) session.getAttribute("userid");

			String boardname = request.getParameter("boardname");
			int totalboardcount = memberDao.myBoardCount(userid);
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

			if (totalboardcount % pagesize == 0) {
				pagecount = totalboardcount / pagesize;
			} else {
				pagecount = (totalboardcount / pagesize) + 1;
			}

			List<Board> myList = memberDao.myList(cpage, pagesize, userid);

			int pagersize = 3;

			request.setAttribute("pagesize", pagesize);
			request.setAttribute("cpage", cpage);
			request.setAttribute("pagecount", pagecount);
			request.setAttribute("myList", myList);
			request.setAttribute("totalboardcount", totalboardcount);
			request.setAttribute("boardname", boardname);
			request.setAttribute("userid", userid);

			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/views/web/myboard_list.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return forward;
	}

}