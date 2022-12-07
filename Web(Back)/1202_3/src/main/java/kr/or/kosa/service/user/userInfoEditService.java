package kr.or.kosa.service.user;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.MemberDao;
import kr.or.kosa.dto.Board;

public class userInfoEditService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		String userid = (String) session.getAttribute("userid");
		String pwd = request.getParameter("pwd");
		String msg = "";
		String url = "";

		MemberDao member;
		ActionForward forward = null;
		try {
			member = new MemberDao();
			boolean pwdcheck = member.passwordCheck(userid, pwd);

			if (pwdcheck == false) {
				msg = "비밀번호가 틀립니다";
				url = "javascript:history.back()";
				request.setAttribute("board_msg", msg);
				request.setAttribute("board_url", url);

				forward = new ActionForward();
				forward.setRedirect(false);
				forward.setPath("/WEB-INF/views/web/redirect.jsp");
			} else {
				msg = "비밀번호가 맞습니다. 회원정보 수정페이지로 이동합니다";
				url = "updateView.user";

				request.setAttribute("board_msg", msg);
				request.setAttribute("board_url", url);

				forward = new ActionForward();
				forward.setRedirect(false);
				forward.setPath("/WEB-INF/views/web/redirect.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return forward;
	}

}
