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

String sql = "select gender,count(gender) as gendercount from memberdetail where gender = '남'or gender = '여' group by gender order by gender desc";
ResultSet rs1 = stmt.executeQuery(sql);

List<Object> list = new ArrayList<>();

while (rs1.next()) {
	LinkedHashMap<String, String> memberdetail = new LinkedHashMap<>();

	memberdetail.put("gender", rs1.getString("gender"));
	memberdetail.put("gendercount", rs1.getString("gendercount"));

	list.add(memberdetail);
}

JSONArray jsonlist = JSONArray.fromObject(list);
stmt.close();
rs1.close();
conn.close();
%>
<%=jsonlist%>