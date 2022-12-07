package kr.or.kosa.action;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//생성하는 모든 서비스는 Action 인터페이스를 구현했으면 좋겠다

// 어떤 클래스를 구현해도 Action을 상속
public interface Action {
	public ActionForward execute(HttpServletRequest request , HttpServletResponse response) throws IOException;
}

