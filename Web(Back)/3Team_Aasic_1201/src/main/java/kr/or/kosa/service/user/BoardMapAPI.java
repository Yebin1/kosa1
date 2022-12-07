package kr.or.kosa.service.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.MemberDao;
import kr.or.kosa.dto.Board;
import kr.or.kosa.dto.Reply;

public class BoardMapAPI implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		
		try {
			
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/views/web/MapAPI.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return forward;		
	}

}
