package kr.or.kosa.service.user;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.MemberDao;

public class ReplyAnswer implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		
		try {
			String seq = request.getParameter("seq");
			String idx = request.getParameter("idx");
			List<Object> replyAnswerList = new ArrayList<>();
			MemberDao memberDao = new MemberDao();
			
			replyAnswerList =  memberDao.replyAnswerList(Integer.parseInt(idx));
			System.out.println(replyAnswerList.toString());
			request.setAttribute("seq", seq);
			request.setAttribute("idx", idx);
			request.setAttribute("replyAnswerList", replyAnswerList);
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/views/web/replyAnswer.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return forward;		
	}

}
