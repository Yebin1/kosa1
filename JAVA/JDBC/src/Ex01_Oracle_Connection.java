// 1004

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/*
JDBC
1. Java 언어(APP)를 통해 Oracle(소프트웨어) 연결 >> CRUD 작업
2. Java App: Oracle, Mysql, MS-SQL 등등 database에 연결, 작업 가능
	2.1. 각각의 제품에 맞는 드라이버를 가지고 있어야 함
	CASE 1: 삼성 노트북 >> HP 프린터 연결 >> HP 프린터 드라이버 설치 >> 노트북에서 프린터 인지
	CASE 2: HP 프린터 제조 회사 >> 삼성, LG 마다 적용할 수 있는 드라이버 별도 제작
	
각 언어에 맞는 드라이버 다운로드, 제품에 맞게 설치
Oracle (C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib)
Mysql (https://dev.mysql.com/downloads/connector/j/)

C:\KOSA_IT\DataBase\JDBC\ConnectionUtils\Oracle >> ojdbc6.jar

3. 드라이버 참조 (현재 프로젝트에서 사용) >> Java project > properties > java build path > add external jars
	3.1. 드라이버 사용 준비 완료 >> 메모리에 load, 사용
	3.2. Class.forName("oracle.jdbc.OracleDriver"); >> new 객체 생성
4. Java code (CRUD) >> JDBC API 제공 받음
	4.1. import java.sql.* >> interface, class 제공
	4.2. 개발자는 interface를 통해 표준화된 DB 작업 수행
	
POINT) 왜 interface 형태로 제공할까?
- JDBC API >> oracle, mysql, ...
- Connection >> oracle, mysql 각각 있는 경우
	- OracleConnection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "KOSA", "1004");
	- MysqlConnection conn = DriverManager.getConnection("jdbc:mysql://192.168.0.3:3306/sampledb?characterEncoding=UTF-8&serverTimezone=UTC&useSSL=true","kosa","1004");
	>> 모두 Connection interface를 구현 >> 다형성 >> Connection 부모 타입 >> 유연한 프로그래밍

>> 다형성 구현 (인터페이스 활용)
import java.sql.Connection
import java.sql.ResultSet
import java.sql.Statement

5. 작업 순서
	5.1. DB 연결 > 명령 생성 > 명령 실행 > 명령 처리 > 자원 해제
	5.2. 명령 생성: DDL (create, alter, drop) >> CRUD (insert, select, update, delete)
		 명령 실행: 쿼리문을 DB 서버에 전달
		 명령 처리: 결과를 받아 화면에 출력하거나 다른 프로그램에 전달 등
		 자원 해제: 연결 해제
*/

public class Ex01_Oracle_Connection {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// DB 연결 > 명령 생성 > 실행 > 처리
		Class.forName("oracle.jdbc.OracleDriver");
		System.out.println("오라클 드라이버 로딩...");

		// loading된 드라이버를 통해 oracle 연결
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "KOSA", "1004");
		System.out.println(conn.isClosed() + " 정상: false");

		Statement stmt = conn.createStatement(); // 명령 객체 얻어오기

		// CRUD
		String sql = "select empno, ename, sal from emp";

		ResultSet rs = stmt.executeQuery(sql); // 명령 실행

		ResultSetMetaData rsmd = rs.getMetaData();

		System.out.println("Total columns: " + rsmd.getColumnCount());
		System.out.println("Column Name of 1st column: " + rsmd.getColumnName(1));
		System.out.println("Column Type Name of 1st column: " + rsmd.getColumnTypeName(1));

		// rs를 통해 DB 서버 memory에 생성된 정보 조회
		// 처리 (화면 조회)
		// 연결 기반 >> DB-웹 서버 연결된 동안에만 작업 가능
		while (rs.next()) {
			System.out.println(rs.getInt("empno") + " / " + rs.getString("ename") + " / " + rs.getInt("sal"));
		}
		stmt.close();
		rs.close();
		conn.close();
		System.out.println("DB 연결 종료: " + conn.isClosed());

	}

}
