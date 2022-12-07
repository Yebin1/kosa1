package kr.or.kosa.service.user;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.MemberDao;
import kr.or.kosa.dto.Board;
import kr.or.kosa.dto.Recruitboard;

public class BoardListService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;

		try {
			MemberDao memberDao = new MemberDao();
			String boardname = request.getParameter("boardname");
			String boardheader = request.getParameter("boardheader");


			int totalboardcount = memberDao.totalBoardCount(boardname);
			if(boardheader != null) {
				totalboardcount = Integer.parseInt(request.getParameter("totalboardcount"));
			}
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

			List<Board> boardList = memberDao.list(cpage, pagesize, boardname);
			List<Recruitboard> recruitboardList = memberDao.recruitboardList();

			int pagersize = 3;

			request.setAttribute("pagesize", pagesize);
			request.setAttribute("cpage", cpage);
			request.setAttribute("pagecount", pagecount);
			request.setAttribute("boardList", boardList);
			request.setAttribute("totalboardcount", totalboardcount);
			request.setAttribute("boardname", boardname);
			request.setAttribute("recruitboardList", recruitboardList);
			forward = new ActionForward();
			forward.setRedirect(false);

			if (boardname.equals("공지사항")) {
				forward.setPath("/WEB-INF/views/common/notice_board_list_css.jsp");
			} else if (boardname.equals("자유게시판")) {
				forward.setPath("/WEB-INF/views/common/free_board_list_css.jsp");
			} else if (boardname.equals("질문과답변")) {
				forward.setPath("/WEB-INF/views/common/qna_board_list_css.jsp");
			} else if (boardname.equals("트러블슈팅")) {
				forward.setPath("/WEB-INF/views/common/troubleshooting_board_list_css.jsp");
			} else if (boardname.equals("프로젝트모집")) {
				forward.setPath("/WEB-INF/views/common/project_board_list_css.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return forward;
	}

}
