import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import kr.or.kosa.SingletonHelper;

// 1005

/*
create table trans_A(
num number,
name varchar2(20)
);

create table trans_B(
num number constraint pk_trans_B_num primary key,
name varchar2(20)
);

JDBC >> default (dml) autocommit >> 실반영
JDBC >> autocommit >> 개발자의 편의에 따라 false로 변경 >> 반드시 commit, rollback 강제


*/


public class Ex07_Transaction {

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;

		conn = SingletonHelper.getConnection("oracle");
		
		String sql = "insert into trans_A(num, name) values(100, 'A')";
		String sql2 = "insert into trans_B(num, name) values(100, 'B')";
		
		try {
			
			conn.setAutoCommit(false); // JDBC 개발자 commit, rollback 강제
			
			// begin tran
			pstmt = conn.prepareStatement(sql);
			pstmt.executeQuery();
			
			pstmt2 = conn.prepareStatement(sql2);
			pstmt2.executeQuery();
			// end tran
			
			conn.commit();
			// 둘 다 정상적으로 실행되고 예외가 발생하지 않으면 commit
			
		} catch (Exception e) {
			System.out.println("문제 발생: " + e.getMessage());
			try {
				conn.rollback();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		} finally {
			SingletonHelper.close(pstmt);
			SingletonHelper.close(pstmt2);
		}
		
	}

}
