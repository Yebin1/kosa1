import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import kr.or.kosa.ConnectionHelper;

// 1004

/*
DML (insert, update, delete)
JDBC API 통해 작업

1. 결과 집합이 없다 (ResultSet 사용X)
2. 반영 결과 확인 가능 (return 행의 개수) >> update 5건 > return 5

Java 코드
update emp set sal = 0 실행 >> update 14건 > return 14
update emp set sal = 100 where empno = 4444 > update 0건 > return 0

결과를 java 코드로 로직 처리
Key Point)
1. Oracle DML(developer, cmd, Tool) >> commit, rollback 강제
2. JDBC API를 사용한 java 코드 >> DML >> default로 autocommit; >> 실반영
3. JDBC API 통해 delete from emp >> 자동 commit >> 실반영
4. 필요에 따라 commit(), rollback 처리해야 하는 코드 ...

begin
	A계좌 인출 (update)
	...
	B계좌 입금 (update)
end
>> 하나의 논리적인 단위 업무 (transaction)
>> 전체 commit, 전체 rollback

>> 업무 처리 >> JDBC >> autocommit 옵션을 false로 전환 가능
>> 반드시 java 코드에서 DML 작업에 대해 commit, rollback 호출


*/

public class Ex02_Oracle_DML_insert {

	public static void main(String[] args) {
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			// 드라이버 로딩
			// Class.forName("oracle.jdbc.OracleDriver"); 생략 가능
			
			// Connection interface를 구현하고 있는 객체의 주소가 return
			// 다형성을 통해 Connection interface 타입의 conn 변수가 주소값을 받음
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "KOSA", "1004");
			stmt = conn.createStatement(); // Statement interface를 구현하고 있는 객체의 주소 return
			
			// Insert
			int empno = 0;
			String ename = "";
			
			// Update
			int deptno = 0;
			
			
			Scanner sc = new Scanner(System.in);
			
			/*
			System.out.println("사번 입력");
			empno = Integer.parseInt(sc.nextLine());
			System.out.println("이름 입력");
			ename = sc.nextLine();
			*/
			
			System.out.println("부서 번호 입력");
			deptno = Integer.parseInt(sc.nextLine());
			
			// update dmlemp set sal = 0 where deptno = 부서 번호
			String sq = "update dmlemp set sal = 0 where deptno = " + deptno;
			System.out.println(sq);
			
			// insert into dememp(empno, ename, deptno) values( ...
			// 고전적인 방법
			String sql = "insert into dmlemp(empno, ename, deptno) ";
			sql += "values(" + empno + ", '" + ename + "', " + deptno + ")";
			
			// 현재
			// values(?, ?, ?) >> ? parameter 별도로 설정
			
			// executeUpdate() >> insert, update, delete 모두 수행
			int resultrow = stmt.executeUpdate(sql);
			
			if (resultrow > 0) {
				System.out.println("반영된 행의 개수: " + resultrow);
			} else {
				System.out.println("예외 발생 X, 반영된 행이 존재하지 않음");
			}
			
		} catch (Exception e) {
			// 중복 데이터 insert로 문제가 생긴다면 executeUpdate()에서 예외 발생
			// 예외 코드 처리
			System.out.println("SQL 예외 발생: " + e.getMessage());
		} finally {
			// 예외 발생 여부와 상관 없이 강제 실행되는 블록
			// 자원 해제
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
