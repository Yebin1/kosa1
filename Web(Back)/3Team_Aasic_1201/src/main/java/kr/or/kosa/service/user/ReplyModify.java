package kr.or.kosa.service.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;

public class ReplyModify implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		
		try {
			String seq = request.getParameter("seq");
			String idx = request.getParameter("idx");
			
			request.setAttribute("seq", seq);
			request.setAttribute("idx", idx);

			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/views/web/replyEdit.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return forward;
	}

}
