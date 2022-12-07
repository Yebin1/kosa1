package kr.or.kosa.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.MemoDao;
import kr.or.kosa.dto.Memo;

public class MemoAddService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String id = request.getParameter("id");
		String email = request.getParameter("email");
		String content = request.getParameter("content");

		MemoDao dao = new MemoDao();
		int result = dao.insertMemo(new Memo(id, email, content));

		// 규칙: 성공하든 실패하든 msg가 작성되고, 조건에 따라 이동하는 페이지 생성
		String msg = "";
		String url = "";

		if (result > 0) {
			msg = "등록 성공";
			url = "MemoList.memo"; // 요청 서블릿 주소
		} else {
			msg = "등록 실패";
			url = "memo.html";
		}

		request.setAttribute("board_msg", msg);
		request.setAttribute("board_url", url);

		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/views/redirect.jsp");

		return forward;
	}

}
