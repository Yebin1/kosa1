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
         if(boardname.equals("자유게시판")) {
        	 if (boardheader.equals("일상") || boardheader.equals("고민")) {
                 boardList = memberDao.headerSearch(cpage, pagesize, boardheader);
                 System.out.println("Service boardList: " + boardList.toString());
              } else {
                 boardList = memberDao.headerAll(cpage, pagesize, boardheader);
              }
         }else if(boardname.equals("트러블슈팅")) {
        	 if (boardheader.equals("[SQL]") || boardheader.equals("[JAVA]")|| boardheader.equals("[C언어]")|| boardheader.equals("[HTML/CSS]")|| boardheader.equals("[JAVASCRIPT]")) {
                 boardList = memberDao.headerSearch(cpage, pagesize, boardheader);
                 System.out.println("Service boardList: " + boardList.toString());
              } else {
                 boardList = memberDao.headerAll(cpage, pagesize, boardheader);
              }
         }else if(boardname.equals("프로젝트모집")) {
        	 if (boardheader.equals("[소형 프로젝트]") || boardheader.equals("[중대형 프로젝트]")) {
                 boardList = memberDao.headerSearch(cpage, pagesize, boardheader);
                 System.out.println("Service boardList: " + boardList.toString());
              } else {
                 boardList = memberDao.headerAll(cpage, pagesize, boardheader);
              }
         }else if(boardname.equals("질문과답변")) {
        	 if (boardheader.equals("[채택]") || boardheader.equals("[미채택]")) {
                 boardList = memberDao.headerSearch(cpage, pagesize, boardheader);
                 System.out.println("Service boardList: " + boardList.toString());
              } else {
                 boardList = memberDao.headerAll(cpage, pagesize, boardheader);
              }
         }
        
         
         int pagersize = 3;

         request.setAttribute("pagesize", pagesize);
         request.setAttribute("cpage", cpage);
         request.setAttribute("pagecount", pagecount);
         request.setAttribute("boardList", boardList);
         request.setAttribute("boardname", boardname);
         request.setAttribute("boardheader", boardheader);
         request.setAttribute("totalboardcount", totalboardcount);

         forward = new ActionForward();
         forward.setRedirect(false);
         
         if(boardname.equals("공지사항")){
        	 forward.setPath("/WEB-INF/views/common/notice_board_list_css.jsp"); 			
 		}else if(boardname.equals("자유게시판")) {
 			 forward.setPath("/WEB-INF/views/common/free_board_list_css.jsp");
 		}else if(boardname.equals("질문과답변")) {
 			 forward.setPath("/WEB-INF/views/common/qna_board_list_css.jsp");
 		}else if(boardname.equals("트러블슈팅")) {
 			 forward.setPath("/WEB-INF/views/common/troubleshooting_board_list_css.jsp");
 		}else if(boardname.equals("프로젝트모집")) {
 			 forward.setPath("/WEB-INF/views/common/project_board_list_css.jsp");
 		}
//         if (boardname.equals("자유게시판"))
//         forward.setPath("/WEB-INF/views/common/free_board_list_css.jsp");

      } catch (Exception e) {
      }

      return forward;

   }
}