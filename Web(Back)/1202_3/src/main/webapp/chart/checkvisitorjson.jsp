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

String sql = "select TO_CHAR(V.V_DATE, 'YYYY-MM-DD') as perdate, COUNT(B.BOARDNAME) as boardcnt,count(V.V_DATE) as visitor from  VISIT V LEFT OUTER JOIN BOARD B ON V.V_DATE = TO_CHAR(B.WRITEDATE,'YYYY-MM-DD')GROUP BY to_char(V_DATE, 'YYYY-MM-DD') order by to_char(V.V_DATE, 'YYYY-MM-DD')";
ResultSet rs1 = stmt.executeQuery(sql);

List<Object> list = new ArrayList<>();

while (rs1.next()) {
	LinkedHashMap<String, String> memberdetail = new LinkedHashMap<>();

	memberdetail.put("perdate", rs1.getString("perdate"));
	memberdetail.put("boardcnt", rs1.getString("boardcnt"));
	memberdetail.put("visitor", rs1.getString("visitor"));

	list.add(memberdetail);
}

JSONArray jsonlist = JSONArray.fromObject(list);
stmt.close();
rs1.close();
conn.close();
%>
<%=jsonlist%>