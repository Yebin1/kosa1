package kr.or.kosa.service.user;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.MemberDao;
import kr.or.kosa.dto.Board;

public class idCheckService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

		String newid = request.getParameter("userid");

		MemberDao member;
		ActionForward forward = null;
		String msg = "";
		String url = "";
		try {

			member = new MemberDao();
			int idcheck = member.signIdCheck(newid);

			if (idcheck == 0) {
				forward = new ActionForward();
				forward.setRedirect(false);
				forward.setPath("/WEB-INF/views/web/idOverLapFalse.jsp");
			} else {
				forward = new ActionForward();
				forward.setRedirect(false);
				forward.setPath("/WEB-INF/views/web/idOverLap.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return forward;
	}

}
