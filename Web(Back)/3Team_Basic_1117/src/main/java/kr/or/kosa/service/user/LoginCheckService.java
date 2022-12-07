package kr.or.kosa.service.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.UserDao;
import kr.or.kosa.dto.User;
import kr.or.kosa.dto.UserDetail;

public class LoginCheckService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		
		try {
			HttpSession session = request.getSession();
			forward = new ActionForward();
			forward.setRedirect(false);
			
			String userId = request.getParameter("id");
			String password = request.getParameter("password");
			String idCheck = null;

			UserDetail userDetail = new UserDetail();
			
			UserDao dao = new UserDao();
			List<User> dtoList;
			boolean success = dao.idCheck(userId, password);
			
			if (success == true) {
				userDetail.setUserId(userId);
				userDetail.setPassword(password);

				session.setAttribute("id", userId); // 세션ID 생성
				
				if (userId.equals("admin")) {
					dtoList = dao.getAllTableList();
					request.setAttribute("dtolist", dtoList);
					forward.setPath("/WEB-INF/views/admin/admin.jsp");
				} else {
					forward.setPath("/WEB-INF/views/web/web.jsp");// 사용자 페이지
				}
			} else {
				forward.setPath("/WEB-INF/views/common/login.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return forward;
	}

}
