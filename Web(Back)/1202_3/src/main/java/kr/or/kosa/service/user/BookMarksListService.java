package kr.or.kosa.service.user;

import java.sql.Date;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.MemberDao;
import kr.or.kosa.dto.Board;
import kr.or.kosa.dto.Bookmarks;

public class BookMarksListService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		HttpSession session = request.getSession();

		try {
			MemberDao memberDao = new MemberDao();
			String userid = (String) session.getAttribute("userid");
			String boardname = request.getParameter("boardname");
			int totalbookmarkcount = memberDao.totalBookmarksCount(userid);
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

			if (totalbookmarkcount % pagesize == 0) {
				pagecount = totalbookmarkcount / pagesize;
			} else {
				pagecount = (totalbookmarkcount / pagesize) + 1;
			}

			List<Bookmarks> bookmarklist = memberDao.BookmarksList(cpage, pagesize, userid);
			int pagersize = 3;

			request.setAttribute("pagesize", pagesize);
			request.setAttribute("cpage", cpage);
			request.setAttribute("pagecount", pagecount);
			request.setAttribute("bookmarklist", bookmarklist);
			request.setAttribute("totalboardcount", totalbookmarkcount);
			request.setAttribute("userid", userid);
			request.setAttribute("boardname", boardname);

			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/views/web/bookMarkList.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return forward;
	}

}