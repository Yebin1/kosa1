<%@page import="kr.or.kosa.dto.Board"%>
<%@page import="net.sf.json.JSONArray"%>
<%@page import="net.sf.json.JSON"%>
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
Connection conn = null;
conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.56:1521:xe", "KING05", "1004");

Statement stmt = conn.createStatement(); 
String sql1 = "select boardname, title, idx from " + 
		"(select boardname, title from board order by lovenum desc) where rownum <= 5";
ResultSet rs = stmt.executeQuery(sql1);


List<Board> hotList = new ArrayList<Board>();

while (rs.next()) {
	Board board = new Board();
	board.setBoardname(rs.getString("boardname"));
	board.setTitle(rs.getString("title"));
	board.setIdx(rs.getInt("idx"));
	hotList.add(board);
}
for (Board b : hotList) {
	System.out.println(b.toString());
}

JSONArray jsonlist = JSONArray.fromObject(hotList);
stmt.close();
rs.close();
conn.close();

%>


<% System.out.println(jsonlist); %>