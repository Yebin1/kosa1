<%@page import="java.util.LinkedHashMap"%>
<%@page import="net.sf.json.JSONArray"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.kosa.dto.Board"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
response.addHeader("Access-Control-Allow-origin", "*");

Class.forName("oracle.jdbc.OracleDriver");
Connection conn = null;
conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "KINGBIRD", "1004");

Statement stmt = conn.createStatement();

String sql = "select boardname, count(boardname) as boardcnt from board group by boardname order by boardcnt desc";
ResultSet rs1 = stmt.executeQuery(sql);

List<Object> list = new ArrayList<>();

while (rs1.next()) {
	LinkedHashMap<String, String> board = new LinkedHashMap<>();

	board.put("boardname", rs1.getString("boardname"));
	board.put("boardcnt", rs1.getString("boardcnt"));

	list.add(board);
}

JSONArray jsonlist = JSONArray.fromObject(list);
stmt.close();
rs1.close();
conn.close();
%>
<%=jsonlist%>