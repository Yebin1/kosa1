package kr.or.kosa.service.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.MemberDao;
import kr.or.kosa.dto.Board;

public class BoardContentService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

		ActionForward forward = null;

		try {
			
			String idx = request.getParameter("idx");
			// int idx = Integer.parseInt(request.getParameter("idx"));
			String cpage = request.getParameter("cp"); // current page
			String pagesize = request.getParameter("ps"); // pagesize
			boolean isread = false;

			Board board = new Board();

			MemberDao memberDao = new MemberDao();
		
			 // 글 번호를 가지고 오지 않았을 경우 예외처리 
			if (idx == null || idx.trim().equals("")) {
			 System.out.println("여기안옴"); 
			 response.sendRedirect("BoardList.user"); 
			 return
			 null; }
			 
			 idx = idx.trim();
			

			// List 페이지 처음 호출
			if (cpage == null || cpage.trim().equals("")) {
				// default 값 설정
				cpage = "1";
			}

			if (pagesize == null || pagesize.trim().equals("")) {
				// default 값 설정
				pagesize = "5";
			}

			int idx2 = Integer.parseInt(idx);
					
			isread = memberDao.getReadNum(idx2);

			if (isread) {
				board = memberDao.getContent(idx2);
			}

			int lovecount = memberDao.loveCount(idx2);
			
			request.setAttribute("board", board);
			request.setAttribute("idx", idx2);
			request.setAttribute("cp", cpage);
			request.setAttribute("ps", pagesize);
			request.setAttribute("lovecount", lovecount);

			forward = new ActionForward();
			forward.setRedirect(false); // forward
			forward.setPath("/WEB-INF/views/web/board_content.jsp");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return forward;
	}

}
