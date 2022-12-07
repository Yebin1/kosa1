package kr.or.kosa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.or.kosa.dto.Board;
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
	private int totalcount;
	private Love love;
	private Grade grade;
	private UserGrade usergrade;
	private Follow follow;
	private boolean pwdCheck2;

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
			System.out.println("sql구문출력 : " + sql1);

			pstmt1.setString(1, memberdetail.getPwd());
			pstmt1.setString(2, memberdetail.getName());
			pstmt1.setString(3, memberdetail.getEmail());
			pstmt1.setString(4, memberdetail.getPhone());
			pstmt1.setString(5, memberdetail.getAddress());
			pstmt1.setString(6, memberdetail.getGender());
			// pstmt.setDate(5, memberdetail.getStartDate());
			// setDate(5, new java.sql.Date(memberdetail.getStartDate().getTime()));
			pstmt1.setString(7, memberdetail.getUserid());
			System.out.println();
			System.out.println("memberdetail출력 : " + memberdetail.toString());
			resultRow = pstmt1.executeUpdate();
			System.out.println("resultRow 출력 : " + resultRow);
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
		return resultRow;
	}

	// 카테고리별 게시물 총 건수 구하기
	public int totalBoardCount(String boardname) {
		try {
			conn = ds.getConnection();
			sql1 = "select count(*) cnt from board where boardname = ?";
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
			sql1 = "select count(*) cnt from board";
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
			sql1 = "select * from (select rownum as num, b.* from " + "board b where boardname = ? order by idx desc) "
					+ "where num <= ? " + // end
					"and num >= ?" // start
					+ "and boardstatus =1";
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
			sql1 = "select * from (select rownum as num, b.* from " + "board b order by lovenum desc, idx asc) "
					+ "where num <= ? " + // end
					"and num >= ?" // start
					+ "and boardstatus =1";

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
			sql2 = "insert into board(idx,userid,boardname,title,content,writedate,readnum,lovenum,boardstatus) "
					+ "values(board_idx.nextval,?,?,?,?,sysdate,0,0,1)";
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
				// TODO: handle exception
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
				rs1.close();
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
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
	// public memberGrade(S)

	// 게시글 수정하기 화면(답글)
	public Board getEditContent(String idx) {
		return this.getContent(Integer.parseInt(idx));
		// 조회화면 동일 (기존에 있는 함수 재활용)
	}

	// 게시글 수정하기 처리
	// public int boardEdit(HttpServletRequest boarddata) {
	public int boardEdit(String idx, String userid, String content, String title, String filename) {
//			String idx = boarddata.getParameter("idx");
//			String userid = boarddata.getParameter("userid");
//			String title = boarddata.getParameter("title");
//			String content = boarddata.getParameter("content");
		// String filename = boarddata.getParameter("filename");
		System.out.println("게시물 수정 처리 DAO에 왔는지");
		System.out.println("수정 DAo idx : " + idx);
		System.out.println("수정 DAo userid : " + userid);
		// System.out.println("수정 DAo filename : " + filename);
//			System.out.println("보드데이터 투스트링 : "+boarddata);

		try {
			conn = ds.getConnection();
			String sql_userid = "select userid from board where idx=?";// and userid=?
			String sql_udpate = "update board set userid=? , title=? , content=? where idx=?";
			pstmt1 = conn.prepareStatement(sql_userid);
			pstmt1.setString(1, idx);
			// pstmt1.setString(2, pwd);
			rs1 = pstmt1.executeQuery();
			System.out.println("pstmt1 : " + pstmt1);
			System.out.println("2 idx:" + idx);
			// 판단 (데이터 있다며 : 수정가능 , 없다면 : 수정불가
			if (rs1.next()) {
				System.out.println("if문 들어오는지");
				// 경고
				pstmt1.close();
				// 업데이트
				pstmt1 = conn.prepareStatement(sql_udpate);
				pstmt1.setString(1, userid);
				// pstmt1.setString(2, email);
				// pstmt1.setString(3, homepage);
				pstmt1.setString(2, title);
				pstmt1.setString(3, content);
				pstmt1.setString(4, idx);
				// pstmt1.setString(5, filename);
				resultRow = pstmt1.executeUpdate();
				System.out.println("마지막 resultrow : " + resultRow);
				System.out.println("DAO의 끝까지 왔는지");
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
				System.out.println("filename : " + filename);
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

	public int replyWrite(int idx_fk, String userid, String content) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		int row = 0;
		try {
			conn = ds.getConnection();
			String sql = "insert into reply(replynum,idx,userid,content,replycheck, replydate, replystatus) values(reply_idx.nextval,?,?,?,0,sysdate,1)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, idx_fk);
			pstmt.setString(2, userid);
			pstmt.setString(3, content);

			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();// 반환
			} catch (Exception e) {

			}
		}

		return row;
	}

	// 댓글 조회하기
	public List<Reply> replylist(int idx) {
		System.out.println(idx);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Reply> list = null;

		try {
			System.out.println("조회까지 왔을까");
			conn = ds.getConnection();
			String reply_sql = "select * from reply where idx= ? order by replynum desc";

			pstmt = conn.prepareStatement(reply_sql);
			pstmt.setInt(1, idx);

			rs = pstmt.executeQuery();

			list = new ArrayList<>();
			while (rs.next()) {
			
				Reply replydto = new Reply();
				replydto.setReplynum(Integer.parseInt(rs.getString("replynum")));
				replydto.setParentreply(rs.getInt("parentreply"));
				replydto.setUserid(rs.getString("userid"));
				replydto.setRefernum(rs.getInt("refernum"));
				replydto.setDepth(rs.getInt("depth"));
				replydto.setReplycheck(rs.getInt("replycheck"));
				replydto.setContent(rs.getString("content"));
				replydto.setReplydate(rs.getDate("replydate"));
				replydto.setIdx(Integer.parseInt(rs.getString("idx")));
				replydto.setReplystatus(rs.getInt("replystatus"));
				list.add(replydto);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				rs.close();
				conn.close();// 반환
			} catch (Exception e) {

			}
		}

		return list;
	}

	public int replyDelete(String no) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int row = 0;

		try {
			System.out.println("MemberDao" + no);
			/* String replyselect = "select pwd from reply where no=?"; */
			String replydelete = "delete from reply where replynum=?";

			conn = ds.getConnection();

			pstmt = conn.prepareStatement(replydelete);
			pstmt.setString(1, no);
			row = pstmt.executeUpdate();

		} catch (Exception e) {

		} finally {
			try {
				pstmt.close();
				rs.close();
				conn.close();// 반환
			} catch (Exception e) {

			}
		}

		return row;
	}

	public int sendMessage(String senduserid, String userid, String messagetitle, String messagecontent) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int row = 0;
		try {
			conn = ds.getConnection();
			String sql = "INSERT INTO MESSAGE(MESSAGEIDX, USERID, SENDUSERID, MESSAGETITLE, MESSAGECONTENT ,MESSAGECHECK)"
					+ "VALUES (MESSAGE_IDX.NEXTVAL, ?,?,?,?,1)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, userid);
			pstmt.setString(2, senduserid);
			pstmt.setString(3, messagetitle);
			pstmt.setString(4, messagecontent);

			row = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();// 반환
			} catch (Exception e) {

			}
		}

		return row;
	}

}
