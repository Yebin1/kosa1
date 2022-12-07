package kr.or.bit.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.BoardDao;
import kr.or.bit.dto.Reply;

public class ReplyAddService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

		String writer = request.getParameter("reply_writer");
		String content = request.getParameter("reply_content");
		String pwd = request.getParameter("reply_pwd");
		String idx_fk = request.getParameter("idx");
		String userid = "empty";
		List<Reply> replyList = new ArrayList<>();
		System.out.println("writer: " + writer);
		System.out.println("content: " + content);
		System.out.println("pwd: " + pwd);
		System.out.println("idx: " + idx_fk);
		System.out.println("userid: " + userid);

		System.out.println("service");
		try {
			BoardDao dao = new BoardDao();
			int result = dao.replywrite(Integer.parseInt(idx_fk), writer, userid, content, pwd);
			replyList = dao.replylist(idx_fk);
			System.out.println(result);
		} catch (Exception e) {
			e.getStackTrace();
		}
			
		request.setAttribute("replyList", replyList);
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/views/include/bottom.jsp");

		//System.out.println(forward);
		return forward;
	}
}
