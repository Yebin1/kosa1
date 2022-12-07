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
import kr.or.kosa.dto.File;

public class BoardDao {
	DataSource ds = null;
	private Connection conn;
	private PreparedStatement pstmt;
	private PreparedStatement pstmt1;
	private PreparedStatement pstmt2;
	private ResultSet rs;
	private String sql;
	private int resultRow;
	private Board board;
	private List<Board> boardList;
	private int totalcount; // 총 게시글 카운트

	public BoardDao() throws NamingException {
		Context context = new InitialContext();
		ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
		conn = null;
		pstmt = null;
		rs = null;
		resultRow = 0;
		sql = "";
		boardList = null;
	}

	// 첨부파일 없는 글쓰기
	public int writeBoard(Board boardData) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int row = 0;
		try {
			conn = ds.getConnection();

			String sql = "insert into board(idx, userid, boardname, title, content, writedate, readnum, refernum, boardstatus)"
					+ "values(board_idx.nextval, ?, ?, ?, ?, sysdate, ?, ?, 4)";
			pstmt = conn.prepareStatement(sql);

			System.out.println("첨부파일 없는 글쓰기: " + sql);

			pstmt.setString(1, boardData.getUserId());
			pstmt.setString(2, boardData.getBoardName());
			pstmt.setString(3, boardData.getTitle());
			pstmt.setString(4, boardData.getContent());
			pstmt.setInt(5, boardData.getReadNum());
			pstmt.setInt(6, boardData.getReferNum());

			System.out.println("update 이전: " + boardData.toString());

			row = pstmt.executeUpdate();

			System.out.println("update 이후: " + boardData.toString());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();// 반환하기
			} catch (Exception e2) {

			}
		}

		return row;
	}

	// 첨부파일 있는 글쓰기
	public int writeBoard(Board boardData, File fileData) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int row = 0;
		try {
			conn = ds.getConnection();

			String sql1 = "insert into board(idx, userid, boardname, title, content, writedate, readnum, refernum, boardstatus)"
					+ "values(board_idx.nextval, ?, ?, ?, ?, sysdate, ?, ?, 4)";
			pstmt1 = conn.prepareStatement(sql);

			pstmt1.setString(1, boardData.getUserId());
			pstmt1.setString(2, boardData.getBoardName());
			pstmt1.setString(3, boardData.getTitle());
			pstmt1.setString(4, boardData.getContent());
			pstmt1.executeUpdate();

			String sql2 = "insert into file(filenum, idx, filename, filesize)" + "values(?, file_idx.nextval, ?, ?";
			pstmt2 = conn.prepareStatement(sql);
			pstmt2.setInt(1, fileData.getFileNum());
			pstmt2.setString(2, fileData.getFileName());
			pstmt2.setInt(3, fileData.getFileSize());
			row = pstmt2.executeUpdate();

		} catch (Exception e) {
			e.fillInStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();// 반환하기
			} catch (Exception e2) {

			}
		}

		return row;
	}

	// 게시물 총 건수 구하기
	public int totalBoardCount() {
		try {
			conn = ds.getConnection();
			sql = "select count(*) cnt from board where boardstatus=4";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				totalcount = rs.getInt("cnt");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				rs.close();
				conn.close();
			} catch (Exception e2) {

			}
		}
		return totalcount;
	}

	// 게시물 목록보기
	public List<Board> list(int cpage, int pagesize) {
		try {
			conn = ds.getConnection();

			sql = "select * from" + "(select rownum, idx, title, userid, writedate from "
					+ "(SELECT * FROM board where boardstatus=4 ORDER BY idx DESC)"
					+ "where rownum <= ?"
					+ ") where rownum >= ?";

			pstmt = conn.prepareStatement(sql);

			System.out.println("목록 보기: " + sql);

			int start = cpage * pagesize - (pagesize - 1);
			int end = cpage * pagesize;
			
			pstmt.setInt(1, end);
			pstmt.setInt(2, start);
			rs = pstmt.executeQuery();
			boardList = new ArrayList<Board>();

			while (rs.next()) {
				board = new Board();
				board.setIdx(rs.getInt("idx"));
				board.setTitle(rs.getString("title"));
				board.setUserId(rs.getString("userid"));
				//board.setReferNum(rs.getInt("refernum"));
				board.setWriteDate(rs.getDate("writedate"));
				boardList.add(board);
			}
		} catch (Exception e) {
			System.out.println("오류 : " + e.getMessage());
		} finally {
			try {
				pstmt.close();
				rs.close();
				conn.close(); // 반환
			} catch (Exception e2) {
			}
		}
		return boardList;
	}

	// 게시글 조회수 증가
	public boolean getReadNum(String idx) {
		conn = null;
		pstmt = null;
		boolean result = false;
		try {
			conn = ds.getConnection();
			String sql = "update board set readnum = readnum + 1 where idx=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, idx);

			int row = pstmt.executeUpdate();
			if (row > 0) {
				result = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();// 반환
			} catch (Exception e) {

			}
		}
		return result;
	}
	
	

}
