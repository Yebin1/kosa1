package kr.or.kosa.service.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.MemberDao;

public class ReplyCompareService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String replyContent = request.getParameter("replyContent");
		String idx = request.getParameter("idx");
	
		String msg = "";
		String url = "";
		try {
			if (replyContent == null) {
				msg = "유효하지 않은 댓글입니다.";
				url = "BoardContent.board?idx=" + idx;
			} else {
				
				MemberDao dao = new MemberDao();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("idx_fk", idx);
		request.setAttribute("replyContent", replyContent);
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/views/web/reply_compare.jsp"); 

		return forward;
	}

}
