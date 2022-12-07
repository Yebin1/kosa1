package kr.or.kosa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import kr.or.kosa.dto.Board;


public class BoardDao {
	DataSource ds = null;
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private String sql;
	private int resultRow;
	private Board Dto;
	private List<Board> dtoList;
	private String pwdCheck; 
	private int totalcount;
	
	
	public BoardDao() throws NamingException {
		Context context = new InitialContext();
		ds = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
		conn = null;
		pstmt = null;
		rs = null;
		resultRow = 0;
		sql = "";
		dtoList = null;
	}
	
	//글쓰기(원본글)
	
	
	//게시물 총 건수 구하기
	public int totalBoardCount() {
		try {
			conn = ds.getConnection();
			sql = "select count(*) cnt from jspboard";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				totalcount = rs.getInt("cnt");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				rs.close();
				conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return totalcount;
	}
	
	//게시물 목록보기
	public List<Board> list(int cpage, int pagessize){
		
		try {
			conn = ds.getConnection();
			sql = "select * from " +
				  "(select rownum rn,idx,writer,email,homepage,pwd," +
				  "subject,content,writedate,readnum,filename,filesize" +
				  ",refer,depth,step from"+ 
				  "( select * from jspboard order by refer desc, step asc)" +
				  " where rownum <= ?) " +  //endrow
				  "where rn >= ?";   // startrow
					
			
			dtoList = new ArrayList<Board>();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return dtoList;
	}
	
	
}
