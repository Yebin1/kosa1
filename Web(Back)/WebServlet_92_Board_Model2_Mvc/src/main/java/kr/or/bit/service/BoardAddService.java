package kr.or.bit.service;

import java.util.Enumeration;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.or.bit.action.Action;
import kr.or.bit.action.ActionForward;
import kr.or.bit.dao.BoardDao;
import kr.or.bit.dto.Board;

public class BoardAddService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

		String msg = "";
		String url = "";

		int result = 0;

		String uploadpath = request.getSession().getServletContext().getRealPath("upload");
		int size = 1024 * 1024 * 10;

		try {

			MultipartRequest multi = new MultipartRequest(request, uploadpath, size, "UTF-8",
					new DefaultFileRenamePolicy());
			
			String subject = multi.getParameter("subject");
			String writer = multi.getParameter("writer");
			String email = multi.getParameter("email");
			String homepage = multi.getParameter("homepage");
			String content = multi.getParameter("content");
			String pwd = multi.getParameter("pwd");

			Enumeration filenames = multi.getFileNames();

			String file1 = (String) filenames.nextElement();
			String filename1 = multi.getFilesystemName(file1);

			BoardDao dao = new BoardDao();
			Board board = new Board();

			board.setSubject(subject);
			board.setWriter(writer);
			board.setEmail(email);
			board.setHomepage(homepage);
			board.setContent(content);
			board.setPwd(pwd);
			if (filename1 == null) {
				board.setFilename("");
			} else {
				board.setFilename(filename1);
			}

			result = dao.writeok(board);

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (result > 0) {
			msg = "insert success";
			url = "BoardList.do";
		} else {
			msg = "insert fail";
			url = "BoardWrite.do";
		}

		request.setAttribute("board_msg", msg);
		request.setAttribute("board_url", url);

		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/views/board/redirect.jsp");

		return forward;

	}

}