package kr.or.kosa.service.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.MemberDao;
import kr.or.kosa.dto.Board;
import kr.or.kosa.dto.Reply;

public class ReplyContent implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;

		try {
			String seq = request.getParameter("seq");
			String idx = request.getParameter("idx");
			MemberDao memberDao = new MemberDao();
			List<Reply> replyList = memberDao.replylist(Integer.parseInt(idx));

			request.setAttribute("seq", seq);
			request.setAttribute("idx", idx);
			request.setAttribute("replyList", replyList);

			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/views/web/replyContent.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return forward;
	}

}
