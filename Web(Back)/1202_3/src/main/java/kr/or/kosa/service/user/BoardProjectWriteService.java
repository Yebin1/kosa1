package kr.or.kosa.service.user;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;

public class BoardProjectWriteService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;

		try {
			String latclick = request.getParameter("latclick");
			String lngclick = request.getParameter("lngclick");
			String pname = request.getParameter("pname");
			String paddress = request.getParameter("paddress");
			String fulladdress = "[" + pname + "]" + paddress;
			

			HttpSession session = request.getSession();
			session.setAttribute("latclick", latclick); // 세션ID 생성
			session.setAttribute("lngclick", lngclick); // 세션ID 생성
			session.setAttribute("fulladdress", fulladdress); // 세션ID 생성
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/views/web/MapAPI.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return forward;
	}

}
