package kr.or.kosa.service.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.MemberDao;
import kr.or.kosa.dto.Board;
import kr.or.kosa.dto.Reply;



public class BoardContentService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		try {
			String idx = request.getParameter("idx");
			String cpage = request.getParameter("cp"); // current page
			String pagesize = request.getParameter("ps"); // pagesize
			String boardname = request.getParameter("boardname");
			boolean isread = false;
			String filename = "";
			List<Object> replyAnswerList = new ArrayList<>();
			
			List<Reply> replyList = new ArrayList<>();
			Board board = new Board();
			MemberDao dao = new MemberDao();
			filename = dao.FileList(idx);
//			filename = "aaa";
			MemberDao memberDao = new MemberDao();
			// 글 번호를 가지고 오지 않았을 경우 예외처리
			if (idx == null || idx.trim().equals("")) {
				response.sendRedirect("BoardList.user?boardname="+boardname);
				return null;
			}
			
			idx = idx.trim();

			//List 페이지 처음 호출 ...
			if(cpage == null || cpage.trim().equals("")){
				//default 값 설정
				cpage = "1"; 
			}
		
			if(pagesize == null || pagesize.trim().equals("")){
				//default 값 설정
				pagesize = "5"; 
			}
			
			int idx2 = Integer.parseInt(idx);

			isread = memberDao.getReadNum(idx);
			
			if(isread) {
				board = memberDao.getContent(Integer.parseInt(idx));
				replyList = memberDao.replylist(Integer.parseInt(idx));
				replyAnswerList =  memberDao.replyAnswerList(Integer.parseInt(idx));
			}
			
			int lovecount = memberDao.loveCount(idx2);
			
			request.setAttribute("board", board);
			request.setAttribute("idx", idx);
			request.setAttribute("cp", cpage);
			request.setAttribute("ps", pagesize);
			request.setAttribute("filename", filename);
			request.setAttribute("replyList", replyList);
			request.setAttribute("lovecount", lovecount);
			request.setAttribute("replyAnswerList", replyAnswerList);
			
			forward = new ActionForward();
			forward.setRedirect(false); // forward
			if(boardname.equals("공지사항"))
    		{
    			forward.setPath("/WEB-INF/views/web/noticeBoard_content.jsp");    			
    		}else if(boardname.equals("자유게시판")) {
        		forward.setPath("/WEB-INF/views/web/freeBoard_content.jsp");
    		}else if(boardname.equals("질문과답변")) {
        		forward.setPath("/WEB-INF/views/web/qnaBoard_content.jsp");
    		}else if(boardname.equals("트러블슈팅")) {
        		forward.setPath("/WEB-INF/views/web/troubleshootingBoard_content.jsp");    			
    		}else if(boardname.equals("프로젝트모집")) {
        		forward.setPath("/WEB-INF/views/web/projectBoard_content.jsp");
    		}
			//forward.setPath("/WEB-INF/views/web/board_content.jsp");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return forward;
	}

}
