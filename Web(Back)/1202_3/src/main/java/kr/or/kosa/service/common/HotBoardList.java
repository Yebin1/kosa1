package kr.or.kosa.service.common;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.CommonDao;
import kr.or.kosa.dto.Board;

public class HotBoardList implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;

		try {

			CommonDao commonDao = new CommonDao();

			List<Board> hotList = commonDao.hotBoardList();

			request.setAttribute("hotList", hotList);

			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/views/web/hotboard_list.jsp");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return forward;
	}

}