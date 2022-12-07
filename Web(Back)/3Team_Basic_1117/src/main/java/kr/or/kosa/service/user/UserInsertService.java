package kr.or.kosa.service.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.UserDao;
import kr.or.kosa.dto.User;
import kr.or.kosa.dto.UserDetail;

public class UserInsertService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;

		try {
			
			User user = new User();
			UserDetail userDetail = new UserDetail();
			UserDao dao = new UserDao();
			
			// userDetail
			String userId = request.getParameter("id");
			String password = request.getParameter("password");
			String name = request.getParameter("name");
			String email1 = request.getParameter("email1");
			String email2 = request.getParameter("email2");
			String email = (email1 + "@" + email2);
			
			String phone = request.getParameter("phone");
			
			String address = request.getParameter("address");
			String gender = request.getParameter("gender");
			String profilephoto = request.getParameter("profilephoto");
	
			userDetail.setUserId(userId);
			userDetail.setPassword(password);
			userDetail.setName(name);
			userDetail.setEmail(email);
			userDetail.setPhone(phone);
			userDetail.setAddress(address);
			userDetail.setGender(gender);
			userDetail.setProfilephoto(profilephoto);
			
			// users
			String ip = request.getRemoteAddr();
			
			user.setUserId(userId);
			user.setIp(ip);
			
			int check = 0;
			check = dao.registerUser(userDetail, user);
						
			forward = new ActionForward();
			forward.setRedirect(false);

			if (check > 0) {
				forward.setPath("/WEB-INF/views/common/login.jsp");
			} else {
				forward.setPath("/WEB-INF/views/common/register.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return forward;
	}

}
