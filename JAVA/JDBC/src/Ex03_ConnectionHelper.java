// 1004

import java.sql.Connection;
import java.sql.SQLException;

import kr.or.kosa.ConnectionHelper;

public class Ex03_ConnectionHelper {

	public static void main(String[] args) throws SQLException {
		
		Connection conn = null;
		conn = ConnectionHelper.getConnection("oracle");
		System.out.println(conn.toString()); // oracle.jdbc.driver.T4CConnection@459e9125
		System.out.println(conn.getMetaData().getDatabaseProductName()); // Oracle
		System.out.println(conn.getMetaData().getDatabaseProductVersion()); // Oracle Database 11g Express Edition Release 11.2.0.2.0 - 64bit Production
		System.out.println(conn.isClosed()); // false
		
		ConnectionHelper.close(conn);
		System.out.println(conn.isClosed()); // true
		
		// 위와 같이 작업하면 연결할 때마다 새로운 객체가 생성된다
		conn = ConnectionHelper.getConnection("oracle");
		System.out.println(conn.toString()); // oracle.jdbc.driver.T4CConnection@6babf3bf
		
		// 하나의 객체를 생성 후 공유할 수 있는 방법?
		// singleton
		
		
		/*
		Connection conn2 = null;
		conn2 = ConnectionHelper.getConnection("oracle", "HR", "1004");
		System.out.println(conn.toString()); // oracle.jdbc.driver.T4CConnection@459e9125
		*/
	}

}
