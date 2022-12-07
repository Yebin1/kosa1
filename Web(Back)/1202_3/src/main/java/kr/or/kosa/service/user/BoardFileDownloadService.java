package kr.or.kosa.service.user;

import java.io.FileInputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;

public class BoardFileDownloadService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// 다운로드할 파일명 얻기
		String filename = request.getParameter("filename");
		ActionForward forward = null;

		// 물리적 경로 얻기
		HttpSession session = request.getSession();
		String root = session.getServletContext().getRealPath("/");
		ServletContext context = request.getSession().getServletContext();
		String savepath = "upload";
		String downloadpath = root + savepath + "\\" + filename;

		byte[] b;
		FileInputStream in;

		try {

			b = new byte[4096];
			in = new FileInputStream(downloadpath);

			String sMimeType = context.getMimeType(downloadpath);
			if (sMimeType == null) {

				sMimeType = "application/octet-stream";
			}

			response.setContentType(sMimeType);

			response.setHeader("Content-Disposition",
					"attachment;filename=" + new String(filename.getBytes(), "ISO8859_1"));

			ServletOutputStream out2 = response.getOutputStream();
			int numread;
			while ((numread = in.read(b, 0, b.length)) != -1) {
				out2.write(b, 0, numread);
			}

			out2.flush();
			out2.close();
			in.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("/WEB-INF/views/web/redirect.jsp");
		return forward;
	}
}
