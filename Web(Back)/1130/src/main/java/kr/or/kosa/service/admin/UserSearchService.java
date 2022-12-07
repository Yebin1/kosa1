package kr.or.kosa.service.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.AdminDao;
import kr.or.kosa.dto.MemberDetail;

public class UserSearchService implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
	
		try {
			AdminDao adminDao = new AdminDao();
			String searchUserid = request.getParameter("searchUserid");
			
			int totalusercount = adminDao.userSearchCount(searchUserid);
			
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
			
			if (totalusercount % pagesize == 0) {
			pagecount = totalusercount / pagesize;
			} else {
			pagecount = (totalusercount / pagesize) + 1;
			}
			
			List<MemberDetail> userSearchList = adminDao.userSearchList(cpage, pagesize, searchUserid);
			System.out.println("searchboardList: " + userSearchList.toString());
			
			request.setAttribute("pagesize", pagesize);
			request.setAttribute("cpage", cpage);
			request.setAttribute("pagecount", pagecount);
			request.setAttribute("searchboardList", userSearchList);
			request.setAttribute("totalusercount", totalusercount);
			request.setAttribute("searchUserid", searchUserid);
			
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/views/admin/admin_delete.jsp");

		} catch (Exception e) {
		}

		return forward;
	}

}
