import java.sql.Connection;
import java.sql.PreparedStatement;

import kr.or.kosa.SingletonHelper;

public class Ex06_Oracle_Prepare_DML {

	public static void main(String[] args) {

		// INSERT
		// insert into dmlemp(empno, ename, deptno) values(?, ?, ?)

		// UPDATE
		// update dmlemp set ename = ?, sal = ?, job = ?, deptno = ?
		// where empno = ?

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = SingletonHelper.getConnection("oracle");
			String sql = "update dmlemp set ename = ?, sal = ?, job = ?, deptno = ? where empno = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "아무개"); // ename = '아무개'
			pstmt.setInt(2, 22222); // sal = 22222
			pstmt.setString(3, "IT"); // job = 'IT'
			pstmt.setInt(4, 20); // deptno = 20
			pstmt.setInt(5, 7900);

			// 실행
			int row = pstmt.executeUpdate(); // parameter만 DB 서버로 전송
			if (row > 0) {
				System.out.println("update row count: " + row);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(pstmt);
		}
	}
}
