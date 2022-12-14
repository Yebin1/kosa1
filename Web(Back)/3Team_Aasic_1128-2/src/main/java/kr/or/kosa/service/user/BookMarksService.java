package kr.or.kosa.service.user;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.MemberDao;
import kr.or.kosa.dto.Bookmarks;

public class BookMarksService implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		System.out.println("세션 userid"+(String) request.getSession().getAttribute("userid"));
		try {
			MemberDao memberdao = new MemberDao();
			Bookmarks bookmarks = new Bookmarks();
			
			String msg="";
		    String url="";

			
			int idx = Integer.parseInt(request.getParameter("idx")); //board_content.jsp의 name을 getParameter로 가져온다
			HttpSession session = request.getSession();//세션객체생성은 로그인체크에서만.
			String userid = (String)session.getAttribute("userid");
			System.out.println("원래 코드 userid : " + userid);
			bookmarks.setIdx(idx);
			bookmarks.setUserid(userid);
		
	
			int resultrow = memberdao.bookmarkCheck(bookmarks);
			
			System.out.println(resultrow);
			
			if(resultrow ==0) {
				//북마크 하기
				System.out.println("북마크 새로 할 경우");
				int bookMarking = memberdao.bookmarkUpdate(bookmarks);
				//bookMarking =1;
				 msg ="북마크 성공!";
				
				request.setAttribute("bookMarking", bookMarking);
				
				
				
				
				/* forward.setPath("/WEB-INF/views/common/redirect.jsp"); */
				
			} else if(resultrow ==1) {
				//이미 북마크 한 경우
				System.out.println("이미 북마크 한 경우");
				 msg ="북마크 해제!";
				int bookMarking = memberdao.bookmarkUpdate(bookmarks);
				
				//bookMarking =0;
				
				request.setAttribute("bookMarking", bookMarking);
		
				
			}
			
			request.setAttribute("board_msg", msg);
			request.setAttribute("board_url", url);
			System.out.println(msg);
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/views/web/redirect.jsp");
			
		} catch (Exception e) {
			System.out.println("The error e is " + e.getMessage());
			e.getStackTrace();
		}
		
		
		return forward;
	}
	

}
