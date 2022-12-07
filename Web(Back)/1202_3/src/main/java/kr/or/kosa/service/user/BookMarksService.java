package kr.or.kosa.service.user;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.MemberDao;
import kr.or.kosa.dto.Bookmarks;

public class BookMarksService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		try {
			MemberDao memberdao = new MemberDao();
			Bookmarks bookmarks = new Bookmarks();

			int idx = Integer.parseInt(request.getParameter("idx"));
			HttpSession session = request.getSession();
			String userid = (String) session.getAttribute("userid");
			bookmarks.setIdx(idx);
			bookmarks.setUserid(userid);

			int resultrow = memberdao.bookmarkCheck(bookmarks);
			request.setAttribute("bookMarking", resultrow);

			if (resultrow == 0) {

				int bookMarking = memberdao.bookmarkUpdate(bookmarks);
				forward = new ActionForward();
				forward.setRedirect(false);
				forward.setPath("/WEB-INF/views/web/bookMark.jsp");

			} else if (resultrow == 1) {
				int bookMarking = memberdao.bookmarkUpdate(bookmarks);

				forward = new ActionForward();
				forward.setRedirect(false);
				forward.setPath("/WEB-INF/views/web/bookMark.jsp");
			}
		} catch (Exception e) {
			e.getStackTrace();
		}

		return forward;
	}

}