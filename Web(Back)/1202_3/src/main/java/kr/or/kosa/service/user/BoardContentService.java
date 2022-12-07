package kr.or.kosa.service.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.MemberDao;
import kr.or.kosa.dto.Board;
import kr.or.kosa.dto.Recruitboard;
import kr.or.kosa.dto.Reply;

public class BoardContentService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		try {
			String idx = request.getParameter("idx");
			String cpage = request.getParameter("cp"); 
			String pagesize = request.getParameter("ps"); 
			String boardname = request.getParameter("boardname");
			boolean isread = false;
			String filename = "";
			List<Object> replyAnswerList = new ArrayList<>();
			List<Recruitboard> recruitboardList = new ArrayList<>();
			List<Reply> replyList = new ArrayList<>();
			Board board = new Board();
			MemberDao memberDao = new MemberDao();
			Recruitboard recruitboard = new Recruitboard();
			filename = memberDao.FileList(idx);

			if (idx == null || idx.trim().equals("")) {
				response.sendRedirect("BoardList.user?boardname=" + boardname);
				return null;
			}

			idx = idx.trim();

			if (cpage == null || cpage.trim().equals("")) {
				cpage = "1";
			}

			if (pagesize == null || pagesize.trim().equals("")) {
				pagesize = "5";
			}

			int idx2 = Integer.parseInt(idx);

			isread = memberDao.getReadNum(idx);

			if (isread) {
				board = memberDao.getContent(Integer.parseInt(idx));
				replyList = memberDao.replylist(Integer.parseInt(idx));
				replyAnswerList = memberDao.replyAnswerList(Integer.parseInt(idx));
				recruitboardList = memberDao.recruitboardList(Integer.parseInt(idx));
			}
			
			int lovecount = memberDao.loveCount(idx2);

			request.setAttribute("board", board);
			request.setAttribute("idx", idx);
			request.setAttribute("cp", cpage);
			request.setAttribute("ps", pagesize);
			request.setAttribute("filename", filename);
			request.setAttribute("replyList", replyList);
			request.setAttribute("lovecount", lovecount);
			request.setAttribute("replyAnswerList", replyAnswerList);
			request.setAttribute("recruitboardList", recruitboardList);

			forward = new ActionForward();
			forward.setRedirect(false);
			if (boardname.equals("공지사항")) {
				forward.setPath("/WEB-INF/views/web/noticeBoard_content.jsp");
			} else if (boardname.equals("자유게시판")) {
				forward.setPath("/WEB-INF/views/web/freeBoard_content.jsp");
			} else if (boardname.equals("질문과답변")) {
				forward.setPath("/WEB-INF/views/web/qnaBoard_content.jsp");
			} else if (boardname.equals("트러블슈팅")) {
				forward.setPath("/WEB-INF/views/web/troubleshootingBoard_content.jsp");
			} else if (boardname.equals("프로젝트모집")) {
				forward.setPath("/WEB-INF/views/web/projectBoard_content.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return forward;
	}

}
