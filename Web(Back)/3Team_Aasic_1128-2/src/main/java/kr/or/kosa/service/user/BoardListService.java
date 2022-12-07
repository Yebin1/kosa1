package kr.or.kosa.service.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.MemberDao;
import kr.or.kosa.dto.Board;

public class BoardListService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;

		try {
			MemberDao memberDao = new MemberDao();
			String boardname = request.getParameter("boardname");
			int totalboardcount = memberDao.totalBoardCount(boardname);

			String ps = request.getParameter("ps"); // pagesize
			String cp = request.getParameter("cp"); // current page
			
			if (ps == null || ps.trim().equals("")) {
				ps = "5"; // 5개씩
			}
			if (cp == null || cp.trim().equals("")) {
				cp = "1"; // 1번째 페이지 보겠다
			}
			int pagesize = Integer.parseInt(ps);
			int cpage = Integer.parseInt(cp);
			int pagecount = 0;

			// 23건 % 5
			if (totalboardcount % pagesize == 0) {
				pagecount = totalboardcount / pagesize; // 20 << 100/5
			} else {
				pagecount = (totalboardcount / pagesize) + 1;
			}

		
			List<Board> boardList = memberDao.list(cpage, pagesize, boardname); // list >> 1 , 20

			int pagersize = 3;

			request.setAttribute("pagesize", pagesize);
			request.setAttribute("cpage", cpage);
			request.setAttribute("pagecount", pagecount);
			request.setAttribute("boardList", boardList);
			request.setAttribute("totalboardcount", totalboardcount);
			request.setAttribute("boardname", boardname);
//			request.setAttribute("pager", pager);

			forward = new ActionForward();
			forward.setRedirect(false); // forward
			forward.setPath("/WEB-INF/views/common/board_list_css.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return forward;
	}

}
