<%@page import="net.sf.json.JSONArray"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="net.sf.json.JSONObject"%>
<%@page import="kr.or.kosa.dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
// 객체를 json 객체로 변환
// 1. JSONObject 사용 >> {} 객체 하나 생성
// 2. JSONArray 사용 >> [{}, {}, {}]
Member member = new Member();

// json
// String jsonmember = "{" + username ... 
JSONObject objmember = JSONObject.fromObject(member);
// {"address":"서울시 강남구","admin":"1","password":"1004","username":"kosa"}
%>
<%=objmember%>

<hr>
<%
List<Member> memberlist = new ArrayList<>();
memberlist.add(new Member("hong", "1004", "서울시 강남구", "0"));
memberlist.add(new Member("kim", "1004", "서울시 용산구", "1"));
memberlist.add(new Member("park", "1004", "서울시 종로구", "0"));

JSONArray memberarray = JSONArray.fromObject(memberlist);
// [{"address":"서울시 강남구","admin":"0","password":"1004","username":"hong"},
// {"address":"서울시 용산구","admin":"1","password":"1004","username":"kim"},
// {"address":"서울시 종로구","admin":"0","password":"1004","username":"park"}]
%>
<%=memberarray%>