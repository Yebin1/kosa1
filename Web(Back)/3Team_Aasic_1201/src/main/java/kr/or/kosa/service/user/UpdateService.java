package kr.or.kosa.service.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.MemberDao;
import kr.or.kosa.dto.Member;
import kr.or.kosa.dto.MemberDetail;

public class UpdateService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();	//현재 로그인 한 아이디
		//파라미터
		String userid = request.getParameter("userid");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String firstEmail = request.getParameter("firstEmail");
		String lastEmail = request.getParameter("lastEmail");
		String email = firstEmail + "@" + lastEmail;
		String firstNumber = request.getParameter("firstNumber");
		String phoneNumber = request.getParameter("phoneNumber");
		String phone = (firstNumber + phoneNumber);
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String ip = request.getRemoteAddr();		
		
		MemberDetail memberdetail;
		MemberDao dao;
		ActionForward forward = new ActionForward();
		int check = 0;
		//List<Member> memberlist;
		try {
			dao = new MemberDao();
			memberdetail = new MemberDetail();
			memberdetail.setUserid(userid);
			memberdetail.setName(name);
			memberdetail.setEmail(email);
			memberdetail.setGender(gender);
			memberdetail.setAddress(address);
			memberdetail.setPwd(pwd);
			memberdetail.setPhone(phone);
			String msg="";
		    String url="";
			System.out.println("memberdetail : "+memberdetail);
			check = dao.update(memberdetail);
			if (check > 0) {
				msg="회원정보 수정 완료";
			    url="index.user";
			    
			    request.setAttribute("board_msg", msg);
				request.setAttribute("board_url", url);
				
				forward = new ActionForward();
				forward.setRedirect(false);
				forward.setPath("/WEB-INF/views/web/redirect.jsp");
			} else {
				msg="다시 제대로 입력해 주세요";
			    url="updateView.user";
			    
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
