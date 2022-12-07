package kr.or.kosa.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;

//서비스를 지원하는 모드 객체는 Action 인터페이스를 구현하기를 원해요
// 당신은 ActionForward execute 반드시 구현해야 한다
public class RegisterServiceAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		//ActionForward action = new ActionForward();
		//action.setRedirect(true);
		//action.setPath("/WEB-INF/views/register/register.jsp");
		return null;
	}

}
