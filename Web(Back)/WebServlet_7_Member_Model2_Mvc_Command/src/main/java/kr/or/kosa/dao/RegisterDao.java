package kr.or.kosa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.or.kosa.dto.RegisterDto;
import kr.or.kosa.utils.ConnectionHelper;

/**

1. DB 연결 POOL 방식
2. insert 작업 insert into mvcregister(id, pwd, email) values(?, ?, ?)

*/



public class RegisterDao {
	
	public int writeOk(RegisterDto r) {
		System.out.println(r.toString());
		int resultrow = 0;

		PreparedStatement pstmt = null;
		String sql = "insert into mvcregister(id, pwd, email) values(?, ?, ?)";

		// POOL
		Connection conn = null;

		try {
			// POOL
			conn = ConnectionHelper.getConnection("oracle");

			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, r.getId());
			pstmt.setString(2, r.getPwd());
			pstmt.setString(3, r.getEmail());
			
			resultrow = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionHelper.close(pstmt);
			try {
				ConnectionHelper.close(conn); // 반환하기
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

		return resultrow;
	}

}
