package kr.or.kosa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

	Connection conn = null;

	public MemoDao() {
		conn = SingletonHelper.getConnection("oracle");
	}

	// 전체 조회
	public List<Memo> getMemoAllList() {

		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<Memo> memolist = new ArrayList<Memo>();

		try {

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
		}
		return memolist;
	}

	// 조건 조회
	public Memo getMemoListById(String id) {

		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Memo memo = null;

		try {

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
		}
		return memo;
	}

	// 데이터 삽입
	public int insertMemo(Memo memo) {

		PreparedStatement pstmt = null;
		int rowcount = 0;

		try {

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
		}
		return rowcount;
	}

	// 데이터 수정
	public int updateMemo(Memo memo) {

		PreparedStatement pstmt = null;
		int rowcount = 0;

		try {

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
		}
		return rowcount;
	}

	// 데이터 삭제
	public int deleteMemo(String id) {

		PreparedStatement pstmt = null;
		int rowcount = 0;

		try {

			String sql = "delete from memo where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rowcount = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(pstmt);
		}
		return rowcount;
	}

	// 이름 검색
	public List<Memo> getMemoAllListById(String id) { // Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; // POINT
		List<Memo> memolist = new ArrayList<Memo>();

		try {
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
		}

		return memolist;
	}

	// ID 유무 함수
	public String isCheckById(String id) {

		String ismemoid = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select id from memo where id=?";

		try {
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
		}

		return ismemoid;

	}

}
