import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

// 1004

public class Ex02_Oracle_DML_delete {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "KOSA", "1004");
			stmt = conn.createStatement();
			
			// Delete
			// delete from dmlemp where deptno = 부서 번호
			int deptno = 0;
			
			Scanner sc = new Scanner(System.in);
			System.out.println("부서 번호 입력");
			deptno = Integer.parseInt(sc.nextLine());
			
			// delete dmlemp where deptno = 부서 번호
			String sql = "delete dmlemp where deptno = " + deptno;
			System.out.println(sql);
						
			// executeUpdate() >> insert, update, delete 모두 수행
			int resultrow = stmt.executeUpdate(sql);
			
			if (resultrow > 0) {
				System.out.println("반영된 행의 개수: " + resultrow);
			} else {
				System.out.println("예외 발생 X, 반영된 행이 존재하지 않음");
			}
			
		} catch (Exception e) {
			System.out.println("SQL 예외 발생: " + e.getMessage());
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
