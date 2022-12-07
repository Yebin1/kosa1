package kr.or.kosa.service.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.MemberDao;

public class BoardReplyAnswerAddService implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
			try {
				HttpSession session = request.getSession();//세션객체생성은 로그인체크에서만.
				String userid = (String)session.getAttribute("userid");
				String content = request.getParameter("reply_content");
				int idx = Integer.parseInt(request.getParameter("idx"));
				int seq = Integer.parseInt(request.getParameter("seq"));
				MemberDao memberDao = new MemberDao();

				int result = memberDao.replyAnswerWrite(idx,seq, userid, content);
				
				
			} catch (Exception e) {
				e.getStackTrace();
			}
			return null;
		}
	}


