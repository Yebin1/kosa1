package kr.or.kosa.service.common;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.CommonDao;
import kr.or.kosa.dto.Board;

public class SearchWordService implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		System.out.println("SearchWordService 입장");
		
		
		try {
			CommonDao commonDao = new CommonDao();
			String searchWord = request.getParameter("searchWord");
			System.out.println("서비스단의  try문 안의 searchWord: "+ searchWord);
			String boardname = request.getParameter("boardname");
			
			//검색된 게시글 총 건수
			int totalsearchcount = commonDao.totalSearchCount(searchWord);
			
			String ps = request.getParameter("ps");
			String cp = request.getParameter("cp");
			System.out.println(ps);
			System.out.println(cp);
			System.out.println(searchWord);
			
			// List 페이지 처음 호출 ... 기본 값 설정
			if (ps == null || ps.trim().equals("")) {
			// default 값 설정
			ps = "5"; // 5개씩
			}
			// List 페이지 처음 호출 ... 기본 값 설정
			if (cp == null || cp.trim().equals("")) {
			// default 값 설정
			cp = "1"; // 1번째 페이지 보겠다
			}
			int pagesize = Integer.parseInt(ps);
			int cpage = Integer.parseInt(cp);
			int pagecount = 0;
			
			// 23건 % 5
			if (totalsearchcount % pagesize == 0) {
			pagecount = totalsearchcount / pagesize; // 20 << 100/5
			} else {
			pagecount = (totalsearchcount / pagesize) + 1;
			}
			
			//목록 가져오기
			List<Board> searchboardList = commonDao.getBoardSearch(cpage, pagesize, searchWord);
			System.out.println("searchboardList: " + searchboardList.toString());
			
			///11/28 일 여기까지 했다///////////////////////////////////////////////
			request.setAttribute("pagesize", pagesize);
			request.setAttribute("cpage", cpage);
			request.setAttribute("pagecount", pagecount);
			request.setAttribute("searchboardList", searchboardList);
			request.setAttribute("totalsearchcount", totalsearchcount);
			request.setAttribute("searchWord", searchWord);
			request.setAttribute("boardname", boardname);
			
			forward = new ActionForward();
			forward.setRedirect(false); //forward
			forward.setPath("/WEB-INF/views/common/searchList.jsp");

		} catch (Exception e) {
			// TODO: handle exception
		}

		return forward;
	}

}
