package kr.or.kosa.service.admin;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.AdminDao;
import kr.or.kosa.dto.Category;

public class AdminBoardCategory implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
				
		try {
			
			AdminDao adminDao = new AdminDao();
			List<Category> categoryList = adminDao.categoryList();
			
			HashMap<String, Integer> count = new HashMap<>();
			for(Category c : categoryList) {
				int cnt = adminDao.totalCountStatus(c.getBoardname());
				count.put(c.getBoardname(), cnt);
			}
			
			int totalcount = adminDao.totalCount0();

			request.setAttribute("categoryList", categoryList);
			request.setAttribute("totalcount", totalcount);
			request.setAttribute("count", count);
			
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/views/admin/board_category.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	return forward;
	}

}
