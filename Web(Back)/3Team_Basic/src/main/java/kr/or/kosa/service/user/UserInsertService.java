package kr.or.kosa.service.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.UserDao;
import kr.or.kosa.dto.User;

public class UserInsertService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
				
		try {
			//파라미터
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String firstRenumber = request.getParameter("firstRenumber");
			String lastRenumber = request.getParameter("lastRenumber");
			String reNumber = firstRenumber + lastRenumber;
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));
			String email = request.getParameter("email");
			String firstNumber = request.getParameter("firstNumber");
			String phoneNumber = request.getParameter("phoneNumber");
			String Phone = (firstNumber + phoneNumber);
			String address = request.getParameter("address");
			String gender = request.getParameter("gender");
			String ip = request.getRemoteAddr();		

			User dto = new User();
			UserDao dao = new UserDao();
			List<User> dtoList;
			int check = 0;
		    dto.setId(id);
		    dto.setPwd(pwd);
		    dto.setRenumber(reNumber);
		    dto.setName(name);
		    dto.setAge(age);
		    dto.setEmail(email);
		    dto.setPhone(Phone);
		    dto.setAddress(address);
		    dto.setGender(gender);
		    dto.setIp(ip);
		    
		    check = dao.writeOk(dto);
		    forward = new ActionForward();
		    forward.setRedirect(false);
		    if(check>0) {
		 	   forward.setPath("/WEB-INF/views/common/login.jsp");
		    }else {
		 	   forward.setPath("/WEB-INF/views/web/register.jsp");
		    }		    
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return forward;
	}

}
