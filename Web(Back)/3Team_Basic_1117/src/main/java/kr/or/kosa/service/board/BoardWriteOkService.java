package kr.or.kosa.service.board;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.BoardDao;
import kr.or.kosa.dto.Board;
import kr.or.kosa.dto.File;

public class BoardWriteOkService implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;

		String uploadpath = request.getSession().getServletContext().getRealPath("upload");
		int size = 1024 * 1024 * 10;

		try {

			MultipartRequest multi = new MultipartRequest(request, uploadpath, size, "UTF-8",
					new DefaultFileRenamePolicy());
			Enumeration filenames = multi.getFileNames();

			String file1 = (String) filenames.nextElement();
			String filename1 = multi.getFilesystemName(file1);

			Board board = new Board();
			BoardDao boardDao = new BoardDao();
			File file = new File();

			String title = multi.getParameter("title");
			String userid = multi.getParameter("writer");
			String content = multi.getParameter("content");

			board.setTitle(title);
			board.setUserId(userid);
			board.setContent(content);

			String fileName = "";
			int check = 0;

			if (fileName != "") {
				fileName = request.getParameter("filename");
				file.setFileName(fileName);
				check = boardDao.writeBoard(board, file);
			} else {
				check = boardDao.writeBoard(board);
			}

			forward = new ActionForward();
			forward.setRedirect(false);

			String url = "";
			if (check > 0) { // 결과가 있을 때
				url = "FreeBoard.board";
			} else {
				url = "BoardWrite.board";
			}
			request.setAttribute("board_url", url);

			forward.setPath("/WEB-INF/views/board/redirect.jsp");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return forward;
	}
}
