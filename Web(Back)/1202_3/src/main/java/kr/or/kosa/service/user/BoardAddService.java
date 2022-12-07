package kr.or.kosa.service.user;

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.MemberDao;
import kr.or.kosa.dto.Board;
import kr.or.kosa.dto.Files;
import kr.or.kosa.dto.Recruitboard;

public class BoardAddService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;

		try {
			String category = "";
			String title = "";
			String content = "";
			String filename = "";
			String boardname = "";
			int filesize = 0;
			int size = 1024 * 1024 * 10;
			HttpSession session = request.getSession();
			String userid = (String) session.getAttribute("userid");
			String root = session.getServletContext().getRealPath("/");
			String savepath = "upload";
			String uploadpath = root + savepath;
			String apply = "";
			String endday = "";
			String startday = "";
			Recruitboard recruitboard = null;
			String transDate = "";

			Date writedateD = null;
			// 파라미터
			String latclick = (String) session.getAttribute("latclick");
			String lngclick = (String) session.getAttribute("lngclick");
			String fulladdress = (String) session.getAttribute("fulladdress");
			if (latclick == null)
				latclick = "1";
			if (lngclick == null)
				lngclick = "1";
			if(fulladdress == null)
				fulladdress = ".";
			
			int result = 0;

			try {
				MultipartRequest multi = new MultipartRequest(request, uploadpath, size, "UTF-8",
						new DefaultFileRenamePolicy());
				Enumeration filenames = multi.getFileNames();
				category = multi.getParameter("category");
				title = multi.getParameter("title");
				content = multi.getParameter("content");
				boardname = multi.getParameter("boardname");
				if (boardname.equals("프로젝트모집")) {
					startday = multi.getParameter("startday");
					endday = multi.getParameter("endday");
					apply = multi.getParameter("apply");
				}

				String file = (String) filenames.nextElement();
				filename = multi.getFilesystemName(file);
				File fileObj = multi.getFile(file);
				if (filename != null) {
					filesize = (int) fileObj.length();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			Board board = new Board();
			board.setUserid(userid);
			board.setTitle(title);
			board.setBoardname(boardname);
			board.setContent(content);
			board.setBoardheader(category);

			if (boardname.equals("프로젝트모집")) {
				recruitboard = new Recruitboard();
				SimpleDateFormat afterFormat = new SimpleDateFormat("yyyy-mm-dd");
				java.util.Date tempDate = null;

				if (!endday.equals("")) {
					tempDate = afterFormat.parse(startday);
					transDate = afterFormat.format(tempDate);
					writedateD = Date.valueOf(transDate);
					recruitboard.setStartdate(writedateD);
				}

				if (!endday.equals("")) {
					tempDate = afterFormat.parse(endday);
					transDate = afterFormat.format(tempDate);
					writedateD = Date.valueOf(transDate);
					recruitboard.setEnddate(writedateD);
				}

				recruitboard.setLatitudemap(Double.parseDouble(latclick));
				recruitboard.setLogitudemap(Double.parseDouble(lngclick));
				recruitboard.setPlacename(fulladdress);
				recruitboard.setApply(apply);

			}

			MemberDao memberDao = new MemberDao();

			if (filename == null) {
				if (boardname.equals("프로젝트모집")) {
					result = memberDao.projectWrite(recruitboard, board);
				} else {
					result = memberDao.writeok(board);
				}
			} else {
				Files file = new Files();
				file.setFilename(filename);
				file.setFilesize(filesize);
				if (boardname.equals("프로젝트모집")) {
					result = memberDao.projectWrite(recruitboard, board, file);
				} else {
					result = memberDao.writeok(board, file);
				}

			}

			String msg = "";
			String url = "";
			if (result > 0) {
				msg = "insert success";
				url = "boardList.user?boardname=" + boardname;
			} else {
				msg = "insert fail";
				url = "boardWrite.do";
			}

			request.setAttribute("board_msg", msg);
			request.setAttribute("board_url", url);

			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/views/web/redirect.jsp");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return forward;
	}

}
