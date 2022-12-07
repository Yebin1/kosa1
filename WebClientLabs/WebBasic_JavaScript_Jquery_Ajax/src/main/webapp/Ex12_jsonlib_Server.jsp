<%@page import="net.sf.json.JSONArray"%>
<%@page import="net.sf.json.JSON"%>
<%@page import="kr.or.kosa.dto.Emp"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%

// CORS
// 비동기 작업: 다른 출처 허용 X 같은 출처만
response.addHeader("Access-Control-Allow-origin", "*");

Class.forName("oracle.jdbc.OracleDriver");
Connection conn = null; //Connection 인터페이스 ...
conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kosa", "1004");

Statement stmt = conn.createStatement(); //명령 객체 얻어오기
String sql = "select empno , ename , sal , job ,comm from emp";
ResultSet rs = stmt.executeQuery(sql); //DB서버에서 실행되고 결과를 생성

// POINT
// DTO 객체 데이터를 담아야 JSON 변환 가능
List<Emp> list = new ArrayList<Emp>();

while (rs.next()) {
	Emp emp = new Emp();
	emp.setEmpno(rs.getInt("empno"));
	emp.setEname(rs.getString("ename"));
	emp.setSal(rs.getInt("sal"));
	emp.setJob(rs.getString("job"));
	emp.setComm(rs.getInt("comm"));

	list.add(emp);
}
for (Emp e : list) {
	System.out.println(e.toString());
}

// [ {}, {}, {} ... ]
// String json = "[" + "{" + "empno: " + "rs."

JSONArray jsonlist = JSONArray.fromObject(list);
stmt.close();
rs.close();
conn.close();

%>


<%=jsonlist%>