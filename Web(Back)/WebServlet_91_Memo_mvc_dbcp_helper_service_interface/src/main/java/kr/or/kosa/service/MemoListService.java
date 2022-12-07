package kr.or.kosa.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.MemoDao;
import kr.or.kosa.dto.Memo;

public class MemoListService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		MemoDao dao = new MemoDao();
		ActionForward forward = null;

		try {
			List<Memo> memolist = dao.getMemoAllList();
			request.setAttribute("memolist", memolist);

			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/views/memolist.jsp");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return forward;
	}

}
