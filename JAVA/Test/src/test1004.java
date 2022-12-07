import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class test1004 {
	
	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "KOSA", "1004");
			stmt = conn.createStatement();
			
			int deptno = 0;
			String dname = "";
			String loc = "";
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			
		}
		
	}

}
