package kr.or.kosa.service.common;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.CommonDao;
import kr.or.kosa.dto.Board;

public class SearchWordService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;

		try {
			CommonDao commonDao = new CommonDao();
			String searchWord = request.getParameter("searchWord");
			String boardname = request.getParameter("boardname");

			int totalsearchcount = commonDao.totalSearchCount(searchWord);

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

			if (totalsearchcount % pagesize == 0) {
				pagecount = totalsearchcount / pagesize;
			} else {
				pagecount = (totalsearchcount / pagesize) + 1;
			}

			List<Board> searchboardList = commonDao.getBoardSearch(cpage, pagesize, searchWord);

			request.setAttribute("pagesize", pagesize);
			request.setAttribute("cpage", cpage);
			request.setAttribute("pagecount", pagecount);
			request.setAttribute("searchboardList", searchboardList);
			request.setAttribute("totalsearchcount", totalsearchcount);
			request.setAttribute("searchWord", searchWord);
			request.setAttribute("boardname", boardname);

			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/views/common/searchList.jsp");

		} catch (Exception e) {
		}

		return forward;
	}

}
