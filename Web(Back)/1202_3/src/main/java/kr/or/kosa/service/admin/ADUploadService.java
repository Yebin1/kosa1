package kr.or.kosa.service.admin;

import java.io.File;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.dao.MemberDao;
import kr.or.kosa.dto.AdFiles;
import kr.or.kosa.dto.Board;
import kr.or.kosa.dto.Files;

public class ADUploadService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;

		try {
			String filename = "";
			int filesize = 0;
			int size = 1024 * 1024 * 10;
			HttpSession session = request.getSession();
			String userid = (String) session.getAttribute("userid");
			String root = session.getServletContext().getRealPath("/");
			String savepath = "ADupload";
			String uploadpath = root + savepath;
			int result = 0;

			try {
				MultipartRequest multi = new MultipartRequest(request, uploadpath, size, "UTF-8",
						new DefaultFileRenamePolicy());
				Enumeration filenames = multi.getFileNames();
				String file = (String) filenames.nextElement();
				filename = multi.getFilesystemName(file);
				File fileObj = multi.getFile(file);

				if (filename != null) {
					filesize = (int) fileObj.length();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			MemberDao memberDao = new MemberDao();

			AdFiles adfile = new AdFiles();
			adfile.setAdfilename(filename);
			adfile.setAdfilesize(filesize);
			result = memberDao.ADUploadOk(adfile);

			request.setAttribute("filename", filename);
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/views/web/file_preview.jsp");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return forward;
	}

}
