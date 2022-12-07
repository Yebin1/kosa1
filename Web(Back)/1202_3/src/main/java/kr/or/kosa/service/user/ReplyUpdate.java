package kr.or.kosa.service.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.MemberDao;

public class ReplyUpdate implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

		try {
			int seq = Integer.parseInt(request.getParameter("seq"));
			String content = request.getParameter("reply_content");
			MemberDao memberDao = new MemberDao();
			int result = memberDao.replyUpdate(seq, content);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
