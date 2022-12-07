package kr.or.kosa.service.common;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.AdminDao;
import kr.or.kosa.dao.CommonDao;
import kr.or.kosa.dto.Category;
import kr.or.kosa.dto.Member;

public class LoginCheckService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;

		try {
			HttpSession session = request.getSession();

			String userid = request.getParameter("userid");
			String pwd = request.getParameter("pwd");
			String idCheck = null;

			CommonDao commonDao = new CommonDao();
			AdminDao adminDao = new AdminDao();

			List<Member> memberList;
			
			boolean idStatus = false;
			idStatus =	commonDao.idStatus(userid); // 정지된 계정 확인
			String msg = "";
			String url = "";
			
			if(idStatus == false) {
				msg = "계정이 정지 되었습니다.";
				url = "login.do";

				request.setAttribute("board_msg", msg);
				request.setAttribute("board_url", url);
				forward = new ActionForward();
				forward.setRedirect(false);
				forward.setPath("/WEB-INF/views/web/redirect.jsp");
				return forward;
			}

			boolean success = commonDao.idCheck(userid, pwd);
			if (success == true) {
				session.setAttribute("userid", userid);

				if (userid.equals("admin")) {
					memberList = adminDao.getAllTableList();
					request.setAttribute("memberList", memberList);
					forward = new ActionForward();
					forward.setRedirect(false);
					forward.setPath("/WEB-INF/views/admin/admin.jsp");
				} else {
					List<Category> categoryList;
					categoryList = commonDao.getAllCategory();
					request.setAttribute("categoryList", categoryList);
					forward = new ActionForward();
					forward.setRedirect(false);
					forward.setPath("/WEB-INF/views/web/web.jsp");
				}
			} else { // 비밀번호 틀렸을때
				msg = "아이디 또는 비밀번호가 틀립니다.";
				url = "login.do";

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
