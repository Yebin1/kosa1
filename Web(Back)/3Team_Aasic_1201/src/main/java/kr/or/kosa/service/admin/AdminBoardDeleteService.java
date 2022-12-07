package kr.or.kosa.service.admin;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.CommonDao;

public class AdminBoardDeleteService implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		String boardname = request.getParameter("boardname");
		
		
		String msg="";
		String url="";
		
		CommonDao commondao;
		try {
			commondao = new CommonDao();
				int result = 0;
			result = commondao.adminDelete(boardname);
			
				if(result > 0){
					msg="삭제완료";
					url="adminCategory.admin";
				}else{
					msg="삭제실패";
					url="adminCategory.admin";
				}
			
			
			
			
		} catch (NamingException e) {
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
