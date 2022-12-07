package kr.or.kosa.service.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.MemberDao;
import kr.or.kosa.dto.Board;

public class HeaderSearchService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;

		try {
			
			MemberDao memberDao = new MemberDao();
			
			String boardheader = request.getParameter("boardheader");
			int headerCount = memberDao.headerCount(boardheader);
			
			System.out.println("Service boardheader: " + boardheader);
			System.out.println("Service keywordCount: " + headerCount);
			
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

			if (headerCount % pagesize == 0) {
				pagecount = headerCount / pagesize;
			} else {
				pagecount = (headerCount / pagesize) + 1;
			}

			List<Board> searchList = memberDao.headerSearch(cpage, pagesize, boardheader);
			int pagersize = 3;

			request.setAttribute("pagesize", pagesize);
			request.setAttribute("cpage", cpage);
			request.setAttribute("pagecount", pagecount);
			request.setAttribute("searchList", searchList);
			request.setAttribute("headerCount", headerCount);
						
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/views/web/header_search_list.jsp");

		} catch (Exception e) {
		}

		return forward;

	}
}
