package kr.or.kosa.service.common;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.CommonDao;
import kr.or.kosa.dao.MemberDao;

public class BoardDeleteOk implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();		
		String idx = request.getParameter("idx");  //글번호 받아오고
		//String pwd = request.getParameter("pwd");  //비밀번호 받아오고
		String userid = (String)session.getAttribute("userid");
		String writeruserid = request.getParameter("userid");
		String boardname = request.getParameter("boardname");
		
		System.out.println("idx : "+idx);
		System.out.println("userid : "+userid);
		System.out.println("writeruserid : "+writeruserid);
		System.out.println("삭제OK서비스-boardname : "+boardname);
		
		String msg="";
		String url="";
		
		CommonDao dao;
		try {
			dao = new CommonDao();
			if(!(userid.equals(writeruserid))) {
				msg="작성자 본인이 아닙니다";
				url="boardList.user?boardname="+boardname;
			} else{
				System.out.println("DAO를 향해");
				int result = dao.deleteOk(idx, userid);
				System.out.println("DAO를 향해 - 1");
				if(result > 0){
					msg="delete success";
					url="boardList.user?boardname="+boardname;
				}else{
					msg="delete fail";
					url="boardList.user?boardname="+boardname;
				}
			}
			
			
			
		} catch (NamingException e) {
			// TOboard Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("board_msg",msg);
		request.setAttribute("board_url",url);
		
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false); // forward
		forward.setPath("/WEB-INF/views/web/redirect.jsp");

		return forward;
	}

}
