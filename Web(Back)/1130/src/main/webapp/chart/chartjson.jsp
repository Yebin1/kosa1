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

	

	// CORS
	// 비동기 작업에서 다른 출처 허용을 막음
	
	
	//^ CORS 허용
	response.addHeader("Access-Control-Allow-origin","*");

	Class.forName("oracle.jdbc.OracleDriver");
	Connection conn = null; //Connection 인터페이스 ...
	conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.56:1521:xe","KING05","1004");
	
	Statement stmt = conn.createStatement(); //명령 객체 얻어오기
	/* String sql = "select boardname,count(boardname) as boardcnt from board group by boardname"; */
	String sql ="select boardname, count(boardname) as boardcnt from board group by boardname order by boardcnt desc";
	ResultSet rs1 = stmt.executeQuery(sql); //DB서버에서 실행되고 결과를 생성
	
	// POINT
	// DTO 객체 데이터 담아야 JSON 변환 가능
	List<Object> list = new ArrayList<>();
	
	while(rs1.next()){
		LinkedHashMap<String,String> board = new LinkedHashMap<>();

		board.put("boardname", rs1.getString("boardname"));
		board.put("boardcnt", rs1.getString("boardcnt"));
		/* board.setBoardcnt(rs.getInt("boardcnt")); */
		list.add(board);
	}
	/* for(Emp e : list){
		System.out.println(e.toString());
	} */
	// [{},{},{},{} ....]
	// String json = "[" + "{" + "empno : " + rs.get  
	JSONArray jsonlist = JSONArray.fromObject(list);
	stmt.close();
	rs1.close();
	conn.close();
	
	
%>
<%=jsonlist%>