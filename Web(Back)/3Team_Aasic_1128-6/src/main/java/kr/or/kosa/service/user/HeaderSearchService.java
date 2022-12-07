package kr.or.kosa.service.user;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.MemberDao;
import kr.or.kosa.dto.Board;

public class HeaderSearchService implements Action {

   @Override
   public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
      ActionForward forward = null;

      try {

         MemberDao memberDao = new MemberDao();

         String boardheader = request.getParameter("boardheader");
         String boardname = request.getParameter("boardname");
         
         int totalboardcount = memberDao.headerCount(boardheader);

         String ps = request.getParameter("ps");
         String cp = request.getParameter("cp");

         if (ps == null || ps.trim().equals("")) {
            ps = "5";
         }
         if (cp == null || cp.trim().equals("")) {
            cp = "1";
         }
         int pagesize = Integer.parseInt(ps);
         int cpage = Integer.parseInt(cp);
         int pagecount = 0;

         if (totalboardcount % pagesize == 0) {
            pagecount = totalboardcount / pagesize;
         } else {
            pagecount = (totalboardcount / pagesize) + 1;
         }
         
         List<Board> boardList = new ArrayList<Board>();
         
         if (boardheader.equals("일상") || boardheader.equals("고민")) {
            boardList = memberDao.headerSearch(cpage, pagesize, boardheader);
		} /*
			 * else if (boardheader.equals("전체")) { boardList = memberDao.headerAll(cpage,
			 * pagesize, boardheader); }
			 */
         
         int pagersize = 3;

         request.setAttribute("pagesize", pagesize);
         request.setAttribute("cpage", cpage);
         request.setAttribute("pagecount", pagecount);
         request.setAttribute("boardList", boardList);
         request.setAttribute("boardname", boardname);
         request.setAttribute("totalboardcount", totalboardcount);

         forward = new ActionForward();
         forward.setRedirect(false);
         forward.setPath("/WEB-INF/views/common/free_board_list_css.jsp");

      } catch (Exception e) {
      }

      return forward;

   }
}