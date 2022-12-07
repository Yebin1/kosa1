package kr.or.kosa.service.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.UserDao;
import kr.or.kosa.dto.User;

public class LoginCheckService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		
		
		try {
			HttpSession session = request.getSession();//세션객체생성은 로그인체크에서만.
			//파라미터
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String idCheck=null;
			
			
			User dto = new User();
			UserDao dao = new UserDao();
			List<User> dtoList;
			boolean success = dao.idCheck(id, pwd);

			
			if(success == true) {
				dto.setId(id);
				dto.setPwd(pwd);
				
				session.setAttribute("id", id); //세션ID 생성
				
				if(id.equals("admin")) {
					dtoList = dao.getAllTableList();
		     		request.setAttribute("dtolist", dtoList);
					forward = new ActionForward();
					forward.setRedirect(false);
					forward.setPath("/WEB-INF/views/admin/admin.jsp");
				}
				else {
					forward = new ActionForward();
					forward.setRedirect(false);
					forward.setPath("/WEB-INF/views/web/web.jsp");//사용자 페이지
				}
			}
			else {
				forward.setPath("/WEB-INF/views/common/login.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return forward;
	}

}
