package kr.or.kosa.service.user;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.MemberDao;
import kr.or.kosa.dto.Board;
import kr.or.kosa.dto.Files;

public class BoardEditService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

		String idx = request.getParameter("idx");
		String boardname = request.getParameter("boardname");
		String filename = request.getParameter("filename");
		String boardheader = request.getParameter("boardheader");
		String msg = "";
		String url = "";

		MemberDao member;
		Files files = new Files();
		ActionForward forward = null;
		try {
			if (idx == null || idx.trim().equals("")) {
				response.sendRedirect("boardList.user");
				return null;
			}

			member = new MemberDao();

			Board board = member.getEditContent(idx);

			if (board == null) {
				msg = "데이터 오류";
				url = "boardList.user?boardname=" + boardname;

				request.setAttribute("board_msg", msg);
				request.setAttribute("board_url", url);
				request.setAttribute("boardname", boardname);
				request.setAttribute("filename", filename);
				request.setAttribute("files", files);
				request.setAttribute("boardheader", boardheader);

				forward = new ActionForward();
				forward.setRedirect(false);
				forward.setPath("/WEB-INF/views/web/redirect.jsp");
			} else {
				request.setAttribute("idx", idx);
				request.setAttribute("board", board);
				request.setAttribute("boardname", boardname);
				request.setAttribute("filename", filename);
				request.setAttribute("files", files);
				request.setAttribute("boardheader", boardheader);
				forward = new ActionForward();
				forward.setRedirect(false);

				if (boardname.equals("공지사항")) {
					forward.setPath("/WEB-INF/views/admin/noticeBoardEdit.jsp");
				} else if (boardname.equals("자유게시판")) {
					forward.setPath("/WEB-INF/views/web/freeBoardEdit.jsp");
				} else if (boardname.equals("질문과답변")) {
					forward.setPath("/WEB-INF/views/web/qnaBoardEdit.jsp");
				} else if (boardname.equals("트러블슈팅")) {
					forward.setPath("/WEB-INF/views/web/troubleBoardEdit.jsp");
				} else if (boardname.equals("프로젝트모집")) {
					forward.setPath("/WEB-INF/views/web/projectBoardEdit.jsp");
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return forward;
	}

}
