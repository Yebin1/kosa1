package kr.or.kosa.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.RegisterDao;
import kr.or.kosa.dto.RegisterDto;

//회원가입 처리를 목적으로 하는 서비스 구현 .... Action 구현
//강제사항 ActionForward execute 구현해야 한다
public class RegisterOkServiceAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		
		RegisterDao dao = new RegisterDao();
		
		RegisterDto dto = new RegisterDto();
		dto.setId(id);
		dto.setPwd(pwd);
		dto.setEmail(email);
		
		int result = dao.writeOk(dto);
		
		String resultdata="";
		if(result > 0) {
			resultdata = "welcome to kosa " + dto.getId() + "님";
		}else {
			resultdata = "Insert Fail ..... retry...";
		}
		
	   //데이터 저장
		request.setAttribute("data", resultdata);
	   
		//뷰설정하기
	    //viewpage="/WEB-INF/views/register/register_welcome.jsp";
	    ActionForward forward = new ActionForward();
	    forward.setRedirect(false); //True 클라이언트가 새로운 페이지를 요청하게 할 거예요 
		forward.setPath("/WEB-INF/views/register/register_welcome.jsp");
		return forward;
	}

}
