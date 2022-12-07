package kr.or.kosa.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.or.kosa.dto.Board;
import kr.or.kosa.dto.Bookmarks;
import kr.or.kosa.dto.Files;
import kr.or.kosa.dto.Follow;
import kr.or.kosa.dto.Grade;
import kr.or.kosa.dto.Love;
import kr.or.kosa.dto.MemberDetail;
import kr.or.kosa.dto.Reply;
import kr.or.kosa.dto.UserGrade;

public class MemberDao {
	DataSource ds = null;
	private Connection conn;
	private PreparedStatement pstmt1;
	private PreparedStatement pstmt2;
	private PreparedStatement pstmt3;
	private ResultSet rs1;
	private String sql1;
	private String sql2;
	private String sql3;
	private int idx;
	private int resultRow;
	private String pwdCheck;
	private Board board;
	private List<Board> boardList;
	private List<Board> myList;
	private int totalcount;
	private Love love;
	private Grade grade;
	private UserGrade usergrade;
	private Follow follow;
	private boolean pwdCheck2;
	private List<Object> myReplyList;

	public MemberDao() throws NamingException {
		Context context = new InitialContext();
		ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
		conn = null;
		pstmt1 = null;
		pstmt2 = null;
		pstmt3 = null;
		rs1 = null;
		resultRow = 0;
		sql1 = "";
		sql2 = "";
		sql3 = "";
		idx = 0;
		pwdCheck2 = false;
	}

	// 계정 수정
	public int update(MemberDetail memberdetail) {
		try {
			// String pwdCheck;
			conn = ds.getConnection();
			sql1 = "update MemberDetail set pwd=?, name=?, email=?, phone=?, address=?, gender=? where userid=?";
			pstmt1 = conn.prepareStatement(sql1);
			pstmt1.setString(1, memberdetail.getPwd());
			pstmt1.setString(2, memberdetail.getName());
			pstmt1.setString(3, memberdetail.getEmail());
			pstmt1.setString(4, memberdetail.getPhone());
			pstmt1.setString(5, memberdetail.getAddress());
			pstmt1.setString(6, memberdetail.getGender());
			pstmt1.setString(7, memberdetail.getUserid());
			resultRow = pstmt1.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt1.close();
				rs1.close();
				conn.close();
			} catch (Exception e2) {
			}
		}
		return resultRow;
	}

	// 카테고리별 게시물 총 건수 구하기
	public int totalBoardCount(String boardname) {
		try {
			conn = ds.getConnection();
			sql1 = "select count(*) cnt from board where boardname = ? and boardstatus=1";
			pstmt1 = conn.prepareStatement(sql1);
			pstmt1.setString(1, boardname);

			rs1 = pstmt1.executeQuery();
			if (rs1.next()) {
				totalcount = rs1.getInt("cnt");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt1.close();
				rs1.close();
				conn.close();
			} catch (Exception e2) {

			}
		}
		return totalcount;
	}

	// 게시물 총 건수 구하기
	public int totalBoardCount() {
		try {
			conn = ds.getConnection();
			sql1 = "select count(*) cnt from board where boardstatus=1";
			pstmt1 = conn.prepareStatement(sql1);
			rs1 = pstmt1.executeQuery();
			if (rs1.next()) {
				totalcount = rs1.getInt("cnt");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt1.close();
				rs1.close();
				conn.close();
			} catch (Exception e2) {

			}
		}
		return totalcount;
	}

	// 카테고리별 게시물 목록보기
	public List<Board> list(int cpage, int pagesize, String boardname) {
		try {
			conn = ds.getConnection();

			sql1 = "SELECT *  FROM (SELECT ROWNUM RNUM, board.*  FROM "
					+ "(SELECT * FROM board where boardname=? and boardstatus=1 ORDER BY idx DESC) board) "
					+ "WHERE RNUM <=?  AND RNUM >=?";
			pstmt1 = conn.prepareStatement(sql1);

			int start = cpage * pagesize - (pagesize - 1);
			int end = cpage * pagesize;
			pstmt1.setString(1, boardname);
			pstmt1.setInt(2, end);
			pstmt1.setInt(3, start);
			rs1 = pstmt1.executeQuery();
			boardList = new ArrayList<Board>();

			while (rs1.next()) {
				board = new Board();
				board.setIdx(rs1.getInt("idx"));
				board.setTitle(rs1.getString("title"));
				board.setUserid(rs1.getString("userid"));
				board.setWritedate(rs1.getDate("writedate"));
				board.setReadnum(rs1.getInt("readnum"));
				board.setBoardheader(rs1.getString("boardheader"));
				// 계층형
				board.setLovenum(rs1.getInt("lovenum"));
				boardList.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt1.close();
				rs1.close();
				conn.close();// 반환
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return boardList;
	}

	// 게시물 목록보기
	public List<Board> list(int cpage, int pagesize) {
		try {
			conn = ds.getConnection();
			sql1 = "SELECT *  FROM (SELECT ROWNUM RNUM, board.*  FROM "
					+ "(SELECT * FROM board where boardstatus=1 ORDER BY idx DESC) board) "
					+ "WHERE RNUM >= ? AND RNUM <= ?";

			pstmt1 = conn.prepareStatement(sql1);

			int start = cpage * pagesize - (pagesize - 1);
			int end = cpage * pagesize;
			pstmt1.setInt(1, end);
			pstmt1.setInt(2, start);
			rs1 = pstmt1.executeQuery();
			boardList = new ArrayList<Board>();

			while (rs1.next()) {
				board = new Board();
				board.setIdx(rs1.getInt("idx"));
				board.setTitle(rs1.getString("title"));
				board.setUserid(rs1.getString("userid"));
				board.setWritedate(rs1.getDate("writedate"));
				board.setReadnum(rs1.getInt("readnum"));
				// 계층형
				board.setLovenum(rs1.getInt("lovenum"));
				boardList.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt1.close();
				rs1.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return boardList;
	}

	// 글쓰기
	public int writeok(Board board) {
		try {
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			String boardname = "";
			sql1 = "select boardname from category where boardname=?";
			pstmt1 = conn.prepareStatement(sql1);
			pstmt1.setString(1, board.getBoardname());
			rs1 = pstmt1.executeQuery();
			sql2 = "insert into board(idx,userid,boardname,title,content,writedate,readnum,lovenum,boardstatus,boardheader) "
					+ "values(board_idx.nextval,?,?,?,?,sysdate,0,0,1,?)";
			if (rs1.next()) {
				boardname = rs1.getString("boardname");
			} else {
				boardname = "";
			}
			pstmt2 = conn.prepareStatement(sql2);
			pstmt2.setString(1, board.getUserid());
			pstmt2.setString(2, boardname);
			pstmt2.setString(3, board.getTitle());
			pstmt2.setString(4, board.getContent());
			pstmt2.setString(5, board.getBoardheader());
			System.out.println(board.toString());
			resultRow = pstmt2.executeUpdate();

			conn.commit();
			conn.setAutoCommit(true);

		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				pstmt1.close();
				rs1.close();
				pstmt2.close();
				conn.close();
			} catch (Exception e2) {

			}
		}
		return resultRow;
	}

	// 글쓰기(파일 추가)
	public int writeok(Board board, Files file) {
		try {
			resultRow = writeok(board);
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			if (resultRow > 0) {
				sql1 = "select max(idx) as idx from board";
				pstmt1 = conn.prepareStatement(sql1);
				rs1 = pstmt1.executeQuery();
				if (rs1.next()) {
					idx = rs1.getInt("idx");
					sql2 = "insert into files(filenum,idx,filename,filesize) " + "values(files_idx.nextval,?,?,?)";
					pstmt2 = conn.prepareStatement(sql2);
					pstmt2.setInt(1, idx);
					pstmt2.setString(2, file.getFilename());
					pstmt2.setInt(3, file.getFilesize());
					resultRow = pstmt2.executeUpdate();
				}
			}

			conn.commit();
			conn.setAutoCommit(true);

		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				pstmt1.close();
				rs1.close();
				pstmt2.close();
				conn.close();
			} catch (Exception e2) {

			}
		}
		return resultRow;
	}

	// 게시물 상세보기
	public Board getContent(int idx) {
		try {
			conn = ds.getConnection();
			sql1 = "select idx, userid, boardname, title, content, writedate, "
					+ "readnum, lovenum, boardstatus from board where idx=?";
			pstmt1 = conn.prepareStatement(sql1);
			pstmt1.setInt(1, idx);
			rs1 = pstmt1.executeQuery();
			if (rs1.next()) {
				board = new Board();
				board.setIdx(rs1.getInt("idx"));
				board.setUserid(rs1.getString("userid"));
				board.setBoardname(rs1.getString("boardname"));
				board.setTitle(rs1.getString("title"));
				board.setContent(rs1.getString("content"));
				board.setBoardstatus(rs1.getInt("boardstatus"));
				board.setReadnum(rs1.getInt("readnum"));
				board.setLovenum(rs1.getInt("lovenum"));
				board.setWritedate(rs1.getDate("writedate"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt1.close();
				rs1.close();
				conn.close();
			} catch (Exception e2) {

			}
		}
		return board;
	}

	// 게시글 조회수 증가
	public boolean getReadNum(String idx) {
		boolean result = false;
		try {
			conn = ds.getConnection();
			sql1 = "update board set readnum = readnum + 1 where idx=?";
			pstmt1 = conn.prepareStatement(sql1);
			pstmt1.setString(1, idx);
			resultRow = pstmt1.executeUpdate();
			if (resultRow > 0) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt1.close();
				conn.close();
			} catch (Exception e2) {

			}
		}
		return result;
	}

	// 추천 여부 검사
	public int loveCheck(Love love) {

		int lovecheck = -1; // 아예 동작하지 않을 경우 대비해서 -1로 초기화

		try {
			conn = ds.getConnection();
			sql1 = "select count(*) cnt from love where idx = ? and userid = ?";
			pstmt1 = conn.prepareStatement(sql1);
			pstmt1.setInt(1, love.getIdx());
			pstmt1.setString(2, love.getUserid());
			rs1 = pstmt1.executeQuery();

			if (rs1.next()) {
				lovecheck = rs1.getInt("cnt");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt1.close();
				rs1.close();
				conn.close();
			} catch (Exception e2) {

			}
		}
		return lovecheck;
	}

	// 추천 insert, delete
	public int loveUpdate(Love love) {

		int lovecheck = -1;

		try {
			lovecheck = loveCheck(love);

			conn = ds.getConnection();
			conn.setAutoCommit(false);

			if (lovecheck == 0) {

				sql1 = "insert into love(loveidx, idx, userid) values(love_idx.nextval, ?, ?)";
				pstmt1 = conn.prepareStatement(sql1);
				pstmt1.setInt(1, love.getIdx());
				pstmt1.setString(2, love.getUserid());
				pstmt1.executeUpdate();

				sql3 = "update board set lovenum=lovenum+1 where idx=?";
				pstmt3 = conn.prepareStatement(sql3);
				pstmt3.setInt(1, love.getIdx());
				resultRow = pstmt3.executeUpdate();

			} else if (lovecheck == 1) {

				sql3 = "update board set lovenum=lovenum-1 where idx=?";
				pstmt3 = conn.prepareStatement(sql3);
				pstmt3.setInt(1, love.getIdx());
				pstmt3.executeUpdate();

				sql1 = "delete from love where idx=? and userid=?";
				pstmt1 = conn.prepareStatement(sql1);
				pstmt1.setInt(1, love.getIdx());
				pstmt1.setString(2, love.getUserid());
				resultRow = pstmt1.executeUpdate();

			}

			conn.commit();
			conn.setAutoCommit(true);

		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			} finally {
				try {
					pstmt1.close();
					conn.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
		return resultRow;
	}

	// 추천수 카운트
	public int loveCount(int idx) {

		int lovecount = 0;

		try {
			conn = ds.getConnection();

			sql1 = "select lovenum from board where idx=?";
			pstmt1 = conn.prepareStatement(sql1);
			pstmt1.setInt(1, idx);
			rs1 = pstmt1.executeQuery();

			if (rs1.next()) {
				lovecount = rs1.getInt("lovenum");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt1.close();
				rs1.close();
				conn.close();
			} catch (Exception e2) {
			}
		}
		return lovecount;
	}

	// 회원 총 추천수 SUM
	public int totalLoveCount(String userid) {

		try {

			conn = ds.getConnection();

			sql1 = "select sum(lovenum) from board where userid=?";
			pstmt1 = conn.prepareStatement(sql1);
			pstmt1.setString(1, userid);
			rs1 = pstmt1.executeQuery();

			if (rs1.next()) {
				resultRow = rs1.getInt("cnt");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt1.close();
				rs1.close();
				conn.close();
			} catch (Exception e2) {

			}
		}
		return resultRow;
	}

	// 회원 등급 변경

	// 게시글 수정하기 화면(답글)
	public Board getEditContent(String idx) {
		return this.getContent(Integer.parseInt(idx));
		// 조회화면 동일 (기존에 있는 함수 재활용)
	}

	// 게시글 수정하기 처리
	public int boardEdit(String idx, String userid, String content, String title, String filename) {

		try {
			conn = ds.getConnection();
			String sql_userid = "select userid from board where idx=?";// and userid=?
			String sql_udpate = "update board set userid=? , title=? , content=? where idx=?";
			pstmt1 = conn.prepareStatement(sql_userid);
			pstmt1.setString(1, idx);
			rs1 = pstmt1.executeQuery();
			// 판단 (데이터 있다며 : 수정가능 , 없다면 : 수정불가
			if (rs1.next()) {
				// 경고
				pstmt1.close();
				// 업데이트
				pstmt1 = conn.prepareStatement(sql_udpate);
				pstmt1.setString(1, userid);
				pstmt1.setString(2, title);
				pstmt1.setString(3, content);
				pstmt1.setString(4, idx);

				resultRow = pstmt1.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt1.close();
				rs1.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return resultRow;
	}

	// 파일보기
	public String FileList(String idx_fk) {
		String filename = "";
		try {
			String replyselect = "select filename from files where idx=?";

			conn = ds.getConnection();
			pstmt1 = conn.prepareStatement(replyselect);
			pstmt1.setString(1, idx_fk);
			rs1 = pstmt1.executeQuery();
			if (rs1.next()) {
				filename = rs1.getString("filename");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt1.close();
				rs1.close();
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return filename;
	}

	// 회원정보 수정 시 비밀번호 체크
	public boolean passwordCheck(String userid, String pwd) {

		try {
			conn = ds.getConnection();
			sql1 = "select userid , pwd from memberdetail where userid=?";
			pstmt1 = conn.prepareStatement(sql1);
			pstmt1.setString(1, userid);
			rs1 = pstmt1.executeQuery();

			if (rs1.next()) {
				pwdCheck = rs1.getString("pwd");
				if (pwdCheck.equals(pwd)) {
					pwdCheck2 = true; // 비밀번호 일치
				} else {
					pwdCheck2 = false; // 비밀번호 불일치
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				pstmt1.close();
				rs1.close();
				conn.close();
			} catch (Exception e2) {

			}
		}
		return pwdCheck2;
	}

	// 회원가입 시 아이디 체크
	public int signIdCheck(String newid) {
		try {
			conn = ds.getConnection();
			sql1 = "select userid from member where userid=?";
			pstmt1 = conn.prepareStatement(sql1);
			pstmt1.setString(1, newid);
			rs1 = pstmt1.executeQuery();

			if (rs1.next() || newid.equals("")) {
				resultRow = 0; // DB에 있는 아이디일 때 =0
			} else {
				resultRow = 1; // DB에 없는 아이디일 때 =1
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt1.close();
				rs1.close();
				conn.close();
			} catch (Exception e2) {

			}
		}
		return resultRow;
	}

	// 댓글 쓰기
	public int replyWrite(int idx_fk, String userid, String content) {
		int row = 0;
		try {
			conn = ds.getConnection();
			String sql = "insert into reply(replynum,idx,userid,content,replycheck, replydate, replystatus) values(reply_idx.nextval,?,?,?,0,sysdate,1)";

			pstmt1 = conn.prepareStatement(sql);

			pstmt1.setInt(1, idx_fk);
			pstmt1.setString(2, userid);
			pstmt1.setString(3, content);

			row = pstmt1.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt1.close();
				conn.close();// 반환
			} catch (Exception e) {

			}
		}

		return row;
	}

	// 댓글 수정
	public int replyUpdate(int seq, String content) {
		try {
			conn = ds.getConnection();
			sql1 = "update reply set content= ? where replynum = ?";
			pstmt1 = conn.prepareStatement(sql1);
			pstmt1.setString(1, content);
			pstmt1.setInt(2, seq);
			resultRow = pstmt1.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt1.close();
				conn.close();// 반환
			} catch (Exception e) {

			}
		}
		return resultRow;
	}

	// 댓글 조회하기
	public List<Reply> replylist(int idx) {
		ArrayList<Reply> list = null;

		try {

			conn = ds.getConnection();
			String reply_sql = "select * from reply where idx= ? order by replynum desc";

			pstmt1 = conn.prepareStatement(reply_sql);
			pstmt1.setInt(1, idx);

			rs1 = pstmt1.executeQuery();

			list = new ArrayList<>();
			while (rs1.next()) {

				Reply replydto = new Reply();
				replydto.setReplynum(Integer.parseInt(rs1.getString("replynum")));
				replydto.setParentreply(rs1.getInt("parentreply"));
				replydto.setUserid(rs1.getString("userid"));
				replydto.setRefernum(rs1.getInt("refernum"));
				replydto.setDepth(rs1.getInt("depth"));
				replydto.setReplycheck(rs1.getInt("replycheck"));
				replydto.setContent(rs1.getString("content"));
				replydto.setReplydate(rs1.getDate("replydate"));
				replydto.setIdx(Integer.parseInt(rs1.getString("idx")));
				replydto.setReplystatus(rs1.getInt("replystatus"));
				list.add(replydto);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt1.close();
				rs1.close();
				conn.close();// 반환
			} catch (Exception e) {

			}
		}

		return list;
	}

	public int replyDelete(String no) {
		try {
			String replydelete = "delete from reply where replynum=?";

			conn = ds.getConnection();

			pstmt1 = conn.prepareStatement(replydelete);
			pstmt1.setString(1, no);
			resultRow = pstmt1.executeUpdate();

		} catch (Exception e) {

		} finally {
			try {
				pstmt1.close();
				rs1.close();
				conn.close();// 반환
			} catch (Exception e) {

			}
		}

		return resultRow;
	}

	// 답글 쓰기
	public int replyAnswerWrite(int idx, int seq, String userid, String content) {

		try {
			conn = ds.getConnection();
			String sql = "insert into reply(replynum,idx,parentreply,userid,content,replycheck, replydate, replystatus) "
					+ "   values(reply_idx.nextval,?,?,?,?,0,sysdate,1)";

			pstmt1 = conn.prepareStatement(sql);

			pstmt1.setInt(1, idx);
			pstmt1.setInt(2, seq);
			pstmt1.setString(3, userid);
			pstmt1.setString(4, content);

			resultRow = pstmt1.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt1.close();
				conn.close();// 반환
			} catch (Exception e1) {

			}
		}

		return resultRow;
	}

	public int sendMessage(String senduserid, String userid, String messagetitle, String messagecontent) {
		try {
			conn = ds.getConnection();
			String sql = "INSERT INTO MESSAGE(MESSAGEIDX, USERID, SENDUSERID, MESSAGETITLE, MESSAGECONTENT ,MESSAGECHECK)"
					+ "VALUES (MESSAGE_IDX.NEXTVAL, ?,?,?,?,1)";

			pstmt1 = conn.prepareStatement(sql);

			pstmt1.setString(1, userid);
			pstmt1.setString(2, senduserid);
			pstmt1.setString(3, messagetitle);
			pstmt1.setString(4, messagecontent);

			resultRow = pstmt1.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt1.close();
				conn.close();// 반환
			} catch (Exception e) {

			}
		}

		return resultRow;
	}

	// DYDYDY
	// 북마크 여부 검사
	public int bookmarkCheck(Bookmarks bookmarks) {
		int bookmarkcheck = -1; // 아예 동작하지 않을 경우 대비해서 -1로 초기화

		try {
			conn = ds.getConnection();
			sql1 = "select count(*) cnt from bookmarks where idx = ? and userid = ?";
			pstmt1 = conn.prepareStatement(sql1);
			pstmt1.setInt(1, bookmarks.getIdx());
			pstmt1.setString(2, bookmarks.getUserid());
			rs1 = pstmt1.executeQuery();

			if (rs1.next()) {
				bookmarkcheck = rs1.getInt("cnt");
			}
		} catch (Exception e2) {
			System.out.println("e2: " + e2.getMessage());
			e2.getStackTrace();
		} finally {
			try {
				pstmt1.close();
				rs1.close();
				conn.close();
			} catch (Exception e3) {
				System.out.println("e3: " + e3.getMessage());
				e3.getStackTrace();
			}
		}

		return bookmarkcheck;
	}

	// DYDYDY
	// 북마크 insert, delete
	public int bookmarkUpdate(Bookmarks bookmarks) {
		int bookmarkcheck = -1;

		try {
			bookmarkcheck = bookmarkCheck(bookmarks);
			conn = ds.getConnection();
			conn.setAutoCommit(false);

			if (bookmarkcheck == 0) {
				resultRow = writeok(board);
				sql1 = "select idx,userid,title,to_char(writedate,'yyyy-MM-dd') as writedate, lovenum, boardname from board where idx = ? and boardstatus=1";
				pstmt1 = conn.prepareStatement(sql1);
				pstmt1.setInt(1, bookmarks.getIdx());

				rs1 = pstmt1.executeQuery();

				if (rs1.next()) {
					idx = rs1.getInt("idx");
					String writerid = rs1.getString("userid"); // board 테이블의 userid, 즉 작성자의 id
					String title = rs1.getString("title");
					String writedate = rs1.getString("writedate"); // board 테이블의 writedate
					int lovenum = rs1.getInt("lovenum");
					String boardname = rs1.getString("boardname");

					SimpleDateFormat afterFormat = new SimpleDateFormat("yyyy-mm-dd");
					java.util.Date tempDate = null;
					tempDate = afterFormat.parse(writedate);
					String transDate = afterFormat.format(tempDate);
					Date writedateD = Date.valueOf(transDate);

					sql2 = "insert into bookmarks (bookidx, idx, userid, writerid, title, writedate, lovenum, boardname) "
							+ "values (book_idx.nextval, ?, ?, ?, ?, ?, ?, ?)";
					pstmt2 = conn.prepareStatement(sql2);
					pstmt2.setInt(1, idx);
					pstmt2.setString(2, bookmarks.getUserid()); // bookmarks.getUserid(): session에 있는 userid, 즉 로그인 되어
																// 있는 userid
					pstmt2.setString(3, writerid);
					pstmt2.setString(4, title);
					pstmt2.setDate(5, writedateD);
					pstmt2.setInt(6, lovenum);
					pstmt2.setString(7, boardname);
					resultRow = pstmt2.executeUpdate();
				}

			} else if (bookmarkcheck == 1) {
				sql2 = "delete from bookmarks where idx=? and userid=?";
				pstmt2 = conn.prepareStatement(sql2);
				pstmt2.setInt(1, bookmarks.getIdx());
				pstmt2.setString(2, bookmarks.getUserid());
				resultRow = pstmt2.executeUpdate();
			}

			conn.commit();
			conn.setAutoCommit(true);

		} catch (Exception e4) {
			System.out.println("e4: " + e4.getMessage());
			e4.getStackTrace();
			try {
				conn.rollback();
			} catch (Exception e5) {
				System.out.println("e5: " + e5.getMessage());
				e5.printStackTrace();
			} finally {
				try {
					pstmt1.close();
					conn.close();
				} catch (Exception e6) {
					System.out.println("e6: " + e6.getMessage());
					e6.getStackTrace();
				}
			}
		}
		return resultRow;
	}

	// DYDYDY
	// 회원별 총 북마크 수
	public int totalBookmarksCount(String userid) {
		try {
			conn = ds.getConnection();
			sql1 = "select count(*) cnt from bookmarks where userid = ?";
			pstmt1 = conn.prepareStatement(sql1);
			pstmt1.setString(1, userid);

			rs1 = pstmt1.executeQuery();
			if (rs1.next()) {
				totalcount = rs1.getInt("cnt");
			}
		} catch (Exception e7) {
			System.out.println("e7: " + e7);
			e7.printStackTrace();
		} finally {
			try {
				pstmt1.close();
				rs1.close();
				conn.close();
			} catch (Exception e8) {
				System.out.println("e8: " + e8);
				e8.printStackTrace();
			}

		}
		return totalcount;
	}

	// DYDYDY
	// 북마크 전체 목록 조회
	public List<Bookmarks> BookmarksList(int cpage, int pagesize, String userid) {
		sql1 = "select * from (select rownum, b.* from bookmarks b where userid=? order by bookidx desc) "
				+ "where rownum <= ? " + // end
				"and rownum >= ?";// start

		List<Bookmarks> bookMarksList = new ArrayList<Bookmarks>();
		try {
			conn = ds.getConnection();
			pstmt1 = conn.prepareStatement(sql1);
			int start = cpage * pagesize - (pagesize - 1);
			int end = cpage * pagesize;
			pstmt1.setString(1, userid);
			pstmt1.setInt(2, end);
			pstmt1.setInt(3, start);
			rs1 = pstmt1.executeQuery();

			while (rs1.next()) {
				Bookmarks bookmarks = new Bookmarks();
				bookmarks.setIdx(rs1.getInt("idx"));
				bookmarks.setTitle(rs1.getString("title"));
				bookmarks.setUserid(rs1.getString("userid"));
				bookmarks.setWritedate(rs1.getDate("writedate"));
				bookmarks.setLovenum(rs1.getInt("lovenum"));
				bookmarks.setBoardname(rs1.getString("boardname"));
				// 계층형
				// board.setLovenum(rs1.getInt("lovenum"));
				// bookMarksList.add(board);

				bookMarksList.add(bookmarks);
			}
		} catch (Exception e9) {
			System.out.println("e9: " + e9);
			e9.printStackTrace();
		} finally {
			try {
				pstmt1.close();
				rs1.close();
				conn.close();
			} catch (Exception e10) {
				System.out.println("e10: " + e10);
				e10.printStackTrace();
			}

		}
		return bookMarksList;
	}

	// 회원 등급 변경
	public int memberGrade(String userid) {
		try {

			conn = ds.getConnection();

			sql1 = "update usergrade set gradename  = case "
					+ "when (select sum(lovenum) from board where userid=?) >= (select graderange from grade where gradename='gold') then 'gold' "
					+ "when (select sum(lovenum) from board where userid=?) >= (select graderange from grade where gradename='silver') and "
					+ "(select sum(lovenum) from board where userid=?) < (select graderange from grade where gradename='gold') then 'silver' "
					+ "else 'bronze' end " + "where userid=?";

			pstmt1 = conn.prepareStatement(sql1);
			pstmt1.setString(1, userid);
			pstmt1.setString(2, userid);
			pstmt1.setString(3, userid);
			pstmt1.setString(4, userid);

			resultRow = pstmt1.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt1.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return resultRow;

	}

	// 마이페이지 댓글 리스트
	public List<Object> myReplyList(int cpage, int pagesize, String userid) {
		try {
			conn = ds.getConnection();
			
			System.out.println("DAO 시작");
					
			sql1 = "select * from (select rownum rnum, rb.* from "
						+"(select to_char(reply.replydate), reply.refernum, reply.content, reply.replynum, board.boardname, board.title from reply, board where reply.idx=board.idx "
						+ "and reply.replystatus=1 and reply.userid=? order by reply.replynum desc) rb)"
						+"	where rnum <= ?  and rnum >=?";
			
			System.out.println("DAO sql: " + sql1);

			pstmt1 = conn.prepareStatement(sql1);

			int start = cpage * pagesize - (pagesize - 1);
			int end = cpage * pagesize;
			
			System.out.println("DAO SET 직전");

			pstmt1.setString(1, userid);
			pstmt1.setInt(2, end);
			pstmt1.setInt(3, start);
			
			System.out.println("DAO SET 완료");
			
			rs1 = pstmt1.executeQuery();
			
			System.out.println("executeQuery 완료");

			myReplyList = new ArrayList<>();
			
			System.out.println("ArrayList");

			while (rs1.next()) {
				
				System.out.println("DAO while문 시작");
				
				LinkedHashMap<String, String> hm = new LinkedHashMap<>();
				
				System.out.println("hashmap 선언됨");
				
				hm.put("replynum", Integer.toString(rs1.getInt("replynum")));
				hm.put("boardname", rs1.getString("boardname"));
				hm.put("title", rs1.getString("title"));
				hm.put("content", rs1.getString("content"));
				hm.put("refernum", Integer.toString(rs1.getInt("refernum")));

				System.out.println("put 완료");
				
				myReplyList.add(hm);
				
				System.out.println(myReplyList);
				System.out.println("-----------------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt1.close();
				rs1.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return myReplyList;
	}

	// 특정 회원 댓글 총 건수 구하기
	public int myReplyCount(String userid) {
		try {
			conn = ds.getConnection();
			sql1 = "select count(*) cnt from reply where userid = ? and replystatus=1";
			pstmt1 = conn.prepareStatement(sql1);
			pstmt1.setString(1, userid);

			rs1 = pstmt1.executeQuery();
			if (rs1.next()) {
				totalcount = rs1.getInt("cnt");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt1.close();
				rs1.close();
				conn.close();
			} catch (Exception e2) {

			}
		}
		return totalcount;
	}

	// 말머리 검색 조건
	public List<Board> headerSearch(int cpage, int pagesize, String boardheader) {

		try {
			conn = ds.getConnection();
			sql1 = "select * from board where boardheader LIKE ? and boardstatus=1";
			
			pstmt1 = conn.prepareStatement(sql1);
			pstmt1.setString(1, "%" + boardheader + "%");
			rs1 = pstmt1.executeQuery();
	
			boardList = new ArrayList<Board>();

			while (rs1.next()) {
				board = new Board();
				board.setIdx(rs1.getInt("idx"));
				board.setTitle(rs1.getString("title"));
				board.setUserid(rs1.getString("userid"));
				board.setWritedate(rs1.getDate("writedate"));
				board.setReadnum(rs1.getInt("readnum"));
				board.setLovenum(rs1.getInt("lovenum"));
				board.setBoardname(rs1.getString("boardname"));
				board.setBoardheader(rs1.getString("boardheader"));
				boardList.add(board);
				
				System.out.println("board.toString: " + board.toString());
				System.out.println("말머리 O: " + boardList.toString());

			}
		} catch (Exception e2) {
			System.out.println("dao e2: " + e2.getMessage());
			e2.getStackTrace();
		} finally {
			try {
				pstmt1.close();
				rs1.close();
				conn.close();
			} catch (Exception e3) {
				System.out.println("e3: " + e3.getMessage());
				e3.getStackTrace();
			}
		}
		return boardList;
	}
	
	// 말머리 전체 선택
		public List<Board> headerAll(int cpage, int pagesize, String boardname) {

			try {
				conn = ds.getConnection();
				sql1 = "select * from board where boardname=? boardstatus=1";
				
				pstmt1 = conn.prepareStatement(sql1);
				pstmt1.setString(1,boardname);
				rs1 = pstmt1.executeQuery();
		
				boardList = new ArrayList<Board>();

				while (rs1.next()) {
					board = new Board();
					board.setIdx(rs1.getInt("idx"));
					board.setTitle(rs1.getString("title"));
					board.setUserid(rs1.getString("userid"));
					board.setWritedate(rs1.getDate("writedate"));
					board.setReadnum(rs1.getInt("readnum"));
					board.setLovenum(rs1.getInt("lovenum"));
					board.setBoardname(rs1.getString("boardname"));
					board.setBoardheader(rs1.getString("boardheader"));
					boardList.add(board);
					
					System.out.println("전체: " + boardList.toString());
				}
			} catch (Exception e2) {
				System.out.println("dao e2: " + e2.getMessage());
				e2.getStackTrace();
			} finally {
				try {
					pstmt1.close();
					rs1.close();
					conn.close();
				} catch (Exception e3) {
					System.out.println("e3: " + e3.getMessage());
					e3.getStackTrace();
				}
			}
			return boardList;
		}

	// 말머리 검색 건수
	public int headerCount(String boardheader) {
		try {
			conn = ds.getConnection();
			sql1 = "select count(idx) cnt from board where boardheader LIKE ? and boardstatus=1";
						
			pstmt1 = conn.prepareStatement(sql1);
			pstmt1.setString(1, "%" + boardheader + "%");			
			rs1 = pstmt1.executeQuery();

			if (rs1.next()) {
				totalcount = rs1.getInt("cnt");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt1.close();
				rs1.close();
				conn.close();
			} catch (Exception e2) {
			}
		}
		
		System.out.println("totalcount: " + totalcount);
		
		return totalcount;
	}

	// 마이페이지 게시글 리스트
	public List<Board> myList(int cpage, int pagesize, String userid) {
		try {
			conn = ds.getConnection();
			sql1 = "select * from (select rownum, b.* from board b order by idx "
					+ "desc) where rownum <= ? and rownum >= ? and boardstatus =1 and userid=?";
			pstmt1 = conn.prepareStatement(sql1);

			int start = cpage * pagesize - (pagesize - 1);
			int end = cpage * pagesize;
			pstmt1.setInt(1, end);
			pstmt1.setInt(2, start);
			pstmt1.setString(3, userid);
			rs1 = pstmt1.executeQuery();
			myList = new ArrayList<Board>();

			while (rs1.next()) {
				board = new Board();
				board.setIdx(rs1.getInt("idx"));
				board.setTitle(rs1.getString("title"));
				board.setUserid(rs1.getString("userid"));
				board.setBoardname(rs1.getString("boardname"));
				board.setWritedate(rs1.getDate("writedate"));
				board.setReadnum(rs1.getInt("readnum"));
				board.setLovenum(rs1.getInt("lovenum"));
				myList.add(board);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt1.close();
				rs1.close();
				conn.close();// 반환
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return myList;
	}
	
	// 특정 회원 게시물 총 건수 구하기
		public int myBoardCount(String userid) {
			try {
				conn = ds.getConnection();
				sql1 = "select count(*) cnt from board where userid = ?";
				pstmt1 = conn.prepareStatement(sql1);
				pstmt1.setString(1, userid);

				rs1 = pstmt1.executeQuery();
				if (rs1.next()) {
					totalcount = rs1.getInt("cnt");
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					pstmt1.close();
					rs1.close();
					conn.close();
				} catch (Exception e2) {

				}
			}
			return totalcount;
		}
	
}
