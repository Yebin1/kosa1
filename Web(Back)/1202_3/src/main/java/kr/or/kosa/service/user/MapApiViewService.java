package kr.or.kosa.service.user;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.MemberDao;
import kr.or.kosa.dto.Recruitboard;

public class MapApiViewService implements Action {
	ActionForward forward = null;

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			String idx = request.getParameter("idx");
			List<Recruitboard> recruitboardList = new ArrayList<>();
			MemberDao memberDao = new MemberDao();
			recruitboardList = memberDao.recruitboardList(Integer.parseInt(idx));
			request.setAttribute("recruitboardList", recruitboardList);
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/views/web/MapApiView.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return forward;
	}

}
