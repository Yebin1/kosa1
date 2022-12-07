import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.or.kosa.SingletonHelper;

// 1004

/*
PreparedStatement (준비된 Statement)

(1) 설명 
미리 SQL문이 셋팅된 Statement가 DB에 전송되어 컴파일되고, SQL문의 ?만 나중에 추가 셋팅해서 실행되는 준비된 Statement 
ex)	select * from emp where empno = 7788
	select * from emp where EMPNO = 7788
	>> oracle에서는 다른 query로 인식
	
	>> select * from emp where empno = ?
	parameter 없는 query를 미리 컴파일, 나중에 parameter만 전송
	새로운 query X, 같은 query로 인식해 성능 향상

(2) 장점
<1> Statement에 비해 반복적인 SQL문을 사용할 경우 더 빠르다. (특히 검색문)
<2> DB 컬럼 타입과 상관 없이 ? 하나로 표시하므로 개발자가 헷갈리지 않고 쉽다. (특히 INSERT문)
(이유: ?를 제외한 SQL문이 DB에서 미리 컴파일된 후 대기)

(3) 단점
SQL문마다 PreparedStatement 객체를 각각 생성해야 하므로 재사용 불가
(but, Statement 객체는 SQL문이 달라지더라도 한 개만 생성해서 재사용이 가능하다. )

(4) 특징
<1> Statement stmt = con.createStatement(); //생성 stmt.execute(sql);//실행
<2> PreparedStatement pstmt = con.prepareStatement(sql); //생성 pstmt.execute(); //실행

(5) 주의
DB 객체들(table, ..)의 뼈대(테이블명 or 컬럼명 or 시퀀스명 등의 객체나 속성명)은 ?로 표시할 수 없다.
즉 data 자리에만 ?로 표시할 수 있다.
cf) 그래서 DDL문에서는 PreparedStatement를 사용하지 않는다.


장점
- 보안 (전체 문장을 DB 서버에 전송하지 않고 나누어 보냄) parameter가 제외된 SQL문 전송하여 컴파일, 이후 parameter만 전송
- query문 미리 컴파일 >> DB 서버에서 query문을 보관 >> 이후 parameter만 전송 >> 네트워크 트래픽 감소

단점
- query문 변경시 재컴파일
*/

public class Ex05_Oracle_PrepareStatement {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = SingletonHelper.getConnection("oracle");
			String sql = "select empno, ename from emp where deptno = ?";
			// where id = ? and name = ? and job = ? >> 순서 중요
			// ? >> parameter
			pstmt = conn.prepareStatement(sql); // 미리 컴파일 (쿼리를 DB 서버가 보관)

			// 이후 parameter 설정하여 DB 서버에 전송
			pstmt.setInt(1, 30); // where deptno = 30;

			rs = pstmt.executeQuery();
			// 기존: stmt.executeQuery(sql)
			// (): 이미 DB에 쿼리문이 보관되어 있음
			// 공식 같은 로직
			// 데이터 1건, 1건 이상, 없는 경우
			if (rs.next()) { // true >> 최소 한 건 이상
				do {
					System.out.println(rs.getInt(1) + " / " + rs.getString(2));
				} while (rs.next());
			} else { // false >> 데이터가 없다
				System.out.println("조회된 데이터가 없습니다.");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
		}

	}

}
