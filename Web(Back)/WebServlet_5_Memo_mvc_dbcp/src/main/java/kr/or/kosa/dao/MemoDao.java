package kr.or.kosa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.or.kosa.dto.Memo;
import kr.or.kosa.utils.SingletonHelper;

/**
 * 
 * DB연결 CRUD 함수 생성 > memo table에 대해 1. 전체조회: select id, email, content from memo
 * 2. 조건조회: select id, email, content from memo where id=? (id: pk 제약 가정) 3. 삽입:
 * insert into memo(id, email, content) values(?, ?, ?) 4. 삭제: delete from memo
 * where id=? 5. 수정: update memo set email=?, content=? where id=? + LIKE 검색
 * (where email like '%naver%')
 * 
 * java로 함수 생성, 처리 >> 거의 똑같음 ArrayList HashMap Generic
 * 
 */

public class MemoDao {

	/*
	 * 싱글톤 방식 Connection conn = null;
	 * 
	 * public MemoDao() { conn = SingletonHelper.getConnection("oracle"); }
	 */

	// 커넥션 풀 방식
	DataSource ds = null;

	public MemoDao() {
		try {
			// JNDI 작업
			// 현재 프로젝트에서 특정 이름을 가진 객체를 검색해 사용할 수 있게 만든다. (이름 기반 검색)
			Context context = new InitialContext();

			// context.xml에서 설정한 name "jdbc/oracle"
			// java:comp/env/ ...
			ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
			// lookup된 객체의 타입: DateSource
			// object라서 다운캐스팅 필요
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 전체 조회
	public List<Memo> getMemoAllList() {

		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<Memo> memolist = new ArrayList<Memo>();

		// 커넥션 풀
		Connection conn = null;

		try {

			// 커넥션 풀
			conn = ds.getConnection();

			String sql = "select id, email, content from memo";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Memo memo = new Memo();
				memo.setId(rs.getString("id"));
				memo.setEmail(rs.getString("email"));
				memo.setContent(rs.getString("content"));
				memolist.add(memo);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
			try {
				// 반환하기
				conn.close();
			} catch (Exception e2) {
			}
		}

		return memolist;
	}

	// 조건 조회
	public Memo getMemoListById(String id) {

		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Memo memo = null;

		// 커넥션 풀
		Connection conn = null;

		try {

			// 커넥션 풀
			conn = ds.getConnection();

			String sql = "select id, email, content from memo where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				memo = new Memo();
				memo.setId(rs.getString("id"));
				memo.setEmail(rs.getString("email"));
				memo.setContent(rs.getString("content"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
			try {
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return memo;
	}

	// 데이터 삽입
	public int insertMemo(Memo memo) {

		PreparedStatement pstmt = null;
		int rowcount = 0;

		// 커넥션 풀
		Connection conn = null;

		try {

			// 커넥션 풀
			conn = ds.getConnection();

			String sql = "insert into memo(id, email, content) values(?, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, memo.getId());
			pstmt.setString(2, memo.getEmail());
			pstmt.setString(3, memo.getContent());
			rowcount = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(pstmt);
			try {
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return rowcount;
	}

	// 데이터 수정
	public int updateMemo(Memo memo) {

		PreparedStatement pstmt = null;
		int rowcount = 0;

		// 커넥션 풀
		Connection conn = null;

		try {

			// 커넥션 풀
			conn = ds.getConnection();

			String sql = "update memo set email=?, content=? where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memo.getId());
			pstmt.setString(2, memo.getEmail());
			pstmt.setString(3, memo.getContent());
			rowcount = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(pstmt);
			try {
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return rowcount;
	}

	// 데이터 삭제
	public int deleteMemo(String id) {

		PreparedStatement pstmt = null;
		int rowcount = 0;

		// 커넥션 풀
		Connection conn = null;

		try {

			// 커넥션 풀
			conn = ds.getConnection();

			String sql = "delete from memo where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rowcount = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(pstmt);
			try {
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return rowcount;
	}

	// 이름 검색
	public List<Memo> getMemoAllListById(String id) { // Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; // POINT
		List<Memo> memolist = new ArrayList<Memo>();

		// 커넥션 풀
		Connection conn = null;

		try {

			// 커넥션 풀
			conn = ds.getConnection();
			String sql = "select id, email, content from memo where email like '%naver%'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Memo memo = new Memo(); // 하나의 row 담기 위한 객체
				memo.setId(rs.getString(1));
				memo.setEmail(rs.getString(2));
				memo.setContent(rs.getString(3));
				memolist.add(memo); // 배열에 객체 담는 것
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
			try {
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

		return memolist;
	}

	// ID 유무 함수
	public String isCheckById(String id) {

		String ismemoid = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select id from memo where id=?";

		// 커넥션 풀
		Connection conn = null;

		try {

			// 커넥션 풀
			conn = ds.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				// 같은 ID 존재
				ismemoid = "false";
			} else {
				// 사용가능한 ID
				ismemoid = "true";
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
			try {
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

		return ismemoid;

	}

}
