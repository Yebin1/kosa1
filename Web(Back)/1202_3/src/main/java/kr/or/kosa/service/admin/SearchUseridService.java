package kr.or.kosa.service.admin;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.AdminDao;
import kr.or.kosa.dto.Member;
import kr.or.kosa.dto.MemberDetail;

public class SearchUseridService implements Action{
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		
		
		try {
			AdminDao adminDao = new AdminDao();
			String searchUserid = request.getParameter("searchUserid"); //Service 단에서는 view에서 지정해둔 form 안의 name 값으로 가져온다..
		
			
			//검색된 사용자 총 수
			int totalsearchcount = adminDao.totalSearchCount(searchUserid);
			
			String ps = request.getParameter("ps");
			String cp = request.getParameter("cp");
			
			
			//List 페이지 처음 호출 ... 기본 값 설정
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
				List<Member> member = adminDao.SearchUserStatusList(cpage, pagesize, searchUserid);		
				
				
				
				List<MemberDetail> searchUseridList = adminDao.SearchUseridList(cpage, pagesize, searchUserid);
			
				
				
				
				request.setAttribute("pagesiz", pagesize);
				request.setAttribute("cpage", cpage);
				request.setAttribute("pagecount", pagecount);
				request.setAttribute("member", member);
				request.setAttribute("searchUseridList", searchUseridList);
				request.setAttribute("totalsearchcount", totalsearchcount);
				request.setAttribute("searchUserid", searchUserid);

				
				forward = new ActionForward();
				forward.setRedirect(false);
				forward.setPath("/WEB-INF/views/admin/admin_delete.jsp");
			
		}catch(Exception e){
			System.out.println("e: " + e);
			e.printStackTrace();			
		}
		
		return forward;
	}


}
