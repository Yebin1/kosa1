package action;

/*
 servelt(front) 요청을 받음
 1. 화면 보여주세요
 2. 로직을 처리해주세요
 
 화면 아니면 로직
 */

public class ActionForward {
	private boolean isRedirect=false; //view의 전환여부..redirect or forward >> 결론은 forward
	private String path = null; //이동 경로(뷰의 주소)
	
	public boolean isRedirect() {
		return isRedirect;
	}
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
