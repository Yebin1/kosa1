package kr.or.kosa.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosa.action.Action;
import kr.or.kosa.action.ActionForward;
import kr.or.kosa.service.common.BoardDeleteOk;
import kr.or.kosa.service.common.BoardDeleteService;
import kr.or.kosa.service.user.BoardAddService;
import kr.or.kosa.service.user.BoardContentService;
import kr.or.kosa.service.user.BoardEditOk;
import kr.or.kosa.service.user.BoardEditService;
import kr.or.kosa.service.user.userInfoEditService;
import kr.or.kosa.service.user.BoardFileDownloadService;
import kr.or.kosa.service.user.BoardListService;
import kr.or.kosa.service.user.BoardModifyService;
import kr.or.kosa.service.user.BoardReplyAddService;
import kr.or.kosa.service.user.BoardReplyAnswerAddService;
import kr.or.kosa.service.user.BoardReplyDeleteService;
import kr.or.kosa.service.user.BoardViewService;
import kr.or.kosa.service.user.BookMarksListService;
import kr.or.kosa.service.user.BookMarksService;
import kr.or.kosa.service.user.FileService;
import kr.or.kosa.service.user.HeaderSearchService;
import kr.or.kosa.service.user.LoveUpdate;
import kr.or.kosa.service.user.MyBoardListService;
import kr.or.kosa.service.user.MyReplyListService;
import kr.or.kosa.service.user.ReplyAnswer;
import kr.or.kosa.service.user.ReplyCompareService;
import kr.or.kosa.service.user.ReplyContent;
import kr.or.kosa.service.user.ReplyModify;
import kr.or.kosa.service.user.ReplyUpdate;
import kr.or.kosa.service.user.UpdateService;
import kr.or.kosa.service.user.UserSendMessageService;
import kr.or.kosa.service.user.idCheckService;

@WebServlet("*.user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserController() {
		super();
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String urlcommand = requestURI.substring(contextPath.length());
		Action action = null;
		ActionForward forward = null;

		if (urlcommand.equals("/index.user")) { // 메인페이지(홈버튼)
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/views/web/web.jsp");
		} else if (urlcommand.equals("/userEditInfo.user")) { 
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/views/web/userInfoEdit.jsp");
		} else if (urlcommand.equals("/update.user")) {
			action = new userInfoEditService();
			forward = action.execute(request, response);
		} else if (urlcommand.equals("/updateView.user")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("/WEB-INF/views/web/edit.jsp");
		} else if (urlcommand.equals("/updateOK.user")) {
			action = new UpdateService();
			forward = action.execute(request, response);
		} else if (urlcommand.equals("/boardList.user")) {// 게시글 리스트출력
			action = new BoardListService();
			forward = action.execute(request, response);
		} else if (urlcommand.equals("/boardWrite.user")) {// 게시글 작성
			action = new BoardViewService();
			forward = action.execute(request, response);
		} else if (urlcommand.equals("/boardWriteOK.user")) {
			System.out.println("여기타는지 확인");
			action = new BoardAddService();
			forward = action.execute(request, response);
		} else if (urlcommand.equals("/boardContent.user")) { // 만약 있다면 상세보기
			action = new BoardContentService();
			forward = action.execute(request, response);
		} else if (urlcommand.equals("/boardEdit.user")) { //// 게시글 내용 수정 부분
			action = new BoardEditService();
			forward = action.execute(request, response);
		} else if (urlcommand.equals("/boardEditOk.user")) { // 트러블슈팅 게시물 수정 처리
			action = new BoardEditOk();
			forward = action.execute(request, response);
		} else if (urlcommand.equals("/boardDelete.user")) { // 트러블슈팅 게시물 수정 처리
			action = new BoardDeleteService();
			forward = action.execute(request, response);
		} else if (urlcommand.equals("/boardDeleteOk.user")) { // 트러블슈팅 게시물 수정 처리
			action = new BoardDeleteOk();
			forward = action.execute(request, response);
		} else if (urlcommand.equals("/fileDetailList.user")) { // 트러블슈팅 파일 상세보기 비동기
			action = new FileService();
			forward = action.execute(request, response);
		} else if (urlcommand.equals("/filedownload.user")) { // 트러블슈팅 파일 상세보기 비동기
			action = new BoardFileDownloadService();
			forward = action.execute(request, response);
		} else if (urlcommand.equals("/idOverlapCheck.user")) { // 트러블슈팅 파일 상세보기 비동기
			action = new idCheckService();
			forward = action.execute(request, response);
		} else if (urlcommand.equals("/loveUpdate.user")) { // 추천 업데이트
			action = new LoveUpdate();
			forward = action.execute(request, response);
		} else if (urlcommand.equals("/boardReplyOk.user")) { // 댓글 작성
			action = new BoardReplyAddService();
			forward = action.execute(request, response);
		} else if (urlcommand.equals("/boardReplyDeleteOk.user")) { // 댓글 삭제
			action = new BoardReplyDeleteService();
			forward = action.execute(request, response);
		} else if (urlcommand.equals("/boardModify.user")) { // 댓글 수정
			action = new BoardModifyService();
			forward = action.execute(request, response);
		} else if (urlcommand.equals("/sendMessage.user")) { // 쪽지 보내기
			action = new UserSendMessageService();
			forward = action.execute(request, response);
		} else if (urlcommand.equals("/bookMarksList.user")) { // userHeader.jsp 에서 북마크 목록 버튼 눌리면 일로 온다
			action = new BookMarksListService();
			forward = action.execute(request, response);
		} else if (urlcommand.equals("/bookMarks.user")) { // board_content에서 북마크 버튼 눌리면 일로 온다
			action = new BookMarksService();
			forward = action.execute(request, response);
		} else if (urlcommand.equals("/replyModify.user")) { // 댓글 수정 view
			action = new ReplyModify();
			forward = action.execute(request, response);
		} else if (urlcommand.equals("/replyUpdate.user")) { // 댓글 수정하기 dao
			action = new ReplyUpdate();
			forward = action.execute(request, response);
		} else if (urlcommand.equals("/replyAnswer.user")) { // 답글 view
			action = new ReplyAnswer();
			forward = action.execute(request, response);
		} else if (urlcommand.equals("/replyAnswerInsert.user")) { // 답글 입력
			action = new BoardReplyAnswerAddService();
			forward = action.execute(request, response);
		} else if (urlcommand.equals("/myreplyList.user")) { // 내가 쓴 댓글 목록 보기
			action = new MyReplyListService();
			forward = action.execute(request, response);
		} else if (urlcommand.equals("/myboardList.user")) { // 내가 쓴 글 목록 보기
			action = new MyBoardListService();
			forward = action.execute(request, response);
		} else if (urlcommand.equals("/replyComment.user")) { // 대댓글 답글 입력
			action = new ReplyContent();
			forward = action.execute(request, response);
		} else if (urlcommand.equals("/HeaderSearchService.user")) {
			action = new HeaderSearchService();
			forward = action.execute(request, response);
		} else if (urlcommand.equals("/replyCompare.user")) {
			action = new ReplyCompareService();
			forward = action.execute(request, response);
		}

		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dis = request.getRequestDispatcher(forward.getPath());
				dis.forward(request, response);
			}
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

}
