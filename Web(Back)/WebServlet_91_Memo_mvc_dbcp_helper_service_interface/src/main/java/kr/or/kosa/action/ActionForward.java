package kr.or.kosa.action;

/*
servelt(front) 요청 받아요
1. 화면보여주세요
2. 로직 처리해 주세요  
  
화면 아니면 로직  
*/

/*
ActionForward 클래스는 Action 인터페이스에서 명령을 수행하고 결과 값을 가지고 forward 할 때 사용되는 클래스이다.
(ActionForward는 페이지 이동을 처리하기 위해 필요한 클래스이다. )
이 클래스는 Redirect 여부 값과 forwarding할 페이지 위치를 가지고 있다.
이 값들은 FrontController에서 ActionForward 클래스 타입으로 반환 값을 가져오면 그 값을 확인하여 해당하는 요청 페이지로 forwarding 처리한다.
*/

public class ActionForward {
	private boolean isRedirect = false; // sendRedirect와 forward 중 어떤 것을 이용해서 페이지 이동할지를 결정하기 위한 boolean 변수
	private String path = null; // Path : 이동할 페이지 경로값을 갖고있는 변수
	
	// property redirect 의 is 메소드
	public boolean isRedirect() {
		// 프로퍼티 타입이 boolean일 경우 get 대신 is를 앞에 붙일 수 있다.
		return isRedirect;
	}

	// property redirect의 set 메소드
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
