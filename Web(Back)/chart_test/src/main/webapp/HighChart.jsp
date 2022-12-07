<%@page import="kr.or.kosa.dto.Emp"%>
<%@page import="net.sf.json.JSON"%>
<%@page import="net.sf.json.JSONArray"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	//CROS
	//비동기 작업 : 다른 출처 허용 안되요
	//("Access-Control-Arrow-origin", "*");
	response.addHeader("Access-Control-Allow-Origin", "*");
	
	Class.forName("oracle.jdbc.OracleDriver");
	Connection conn = null; //Connection 인터페이스 ...
	conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kosa", "1004");
	
	Statement stmt = conn.createStatement(); //명령 객체 얻어오기
	String sql = "select job, round(avg(sal)) from emp group by job";
	ResultSet rs = stmt.executeQuery(sql); //DB서버에서 실행되고 결과를 생성
	
	//POINT
	//DTO 객체 데이터 담아야 JSON 형태로 바뀜
	List<Emp> list = new ArrayList<Emp>();
	
	while(rs.next()){
		Emp emp = new Emp();
		emp.setJob(rs.getString(1));
		emp.setSal(rs.getInt(2));
		
		list.add(emp);
	}
	/*
	for(Emp e : list){
		System.out.println(e.toString());
	}
	*/
	// [{},{},{},{}.......]
			
	JSONArray jsonlist = JSONArray.fromObject(list);
	stmt.close();
	rs.close();
	conn.close();
	
	/*
	주의사항
	JSONArray : java,lang.reflect.InvocationTargretEx
	*/
	
%>
<%=jsonlist%>