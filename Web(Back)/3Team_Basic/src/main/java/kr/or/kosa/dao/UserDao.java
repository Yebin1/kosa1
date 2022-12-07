package kr.or.kosa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import kr.or.kosa.dto.User;

public class UserDao {

DataSource ds = null;
private Connection conn;
private PreparedStatement pstmt;
private ResultSet rs;
private String sql;
private int resultRow;
private boolean idCheck; //아이디 체크여부
private User Dto;
private List<User> dtoList;
private String pwdCheck;



	public UserDao() throws NamingException {
		Context context = new InitialContext();
		ds = (DataSource)context.lookup("java:comp/env/jdbc/oracle");
		conn = null;
		pstmt = null;
		rs = null;
		resultRow = 0;
		idCheck = false;
		sql = "";
		dtoList = null;
	}
	/* pstmt.setDate(11,new java.sql.Date(dto.getStartDate().getTime())); */	
	//아이디 체크
	public boolean idCheck(String id, String pwd) {	   
		   try {		   
			   conn = ds.getConnection();
			   sql = "select id, pwd from users where id=?";
			   pstmt = conn.prepareStatement(sql);
			   pstmt.setString(1, id);
			   rs= pstmt.executeQuery();
			   		   
			   if (rs.next()) {
		            pwdCheck = rs.getString("pwd");
		            if(pwdCheck.equals(pwd)){
		            	idCheck =  true; // 아이디, 비밀번호 일치
		            }else{
		            	idCheck = false; // 비밀번호 불일치
		            }
		       }
		   } catch (Exception e) {
				System.out.println(e.getMessage());
		   }finally {
			   try {
				   pstmt.close();
				   rs.close();
				   conn.close();
			   } catch (Exception e2) {
				
			   }
		   }	   
		   return idCheck;
	}
	
	public List<User>getUserList(){
		
		
		return dtoList;
	}
	
	
	//writeOk ...
	//회원가입
	public int writeOk(User dto) {
		try {
				conn = ds.getConnection();
				String sql="insert into users(id, pwd, renumber, name, age, email, phone, address, gender, status, startdate, ip)"
						+ " values(?,?,?,?,?,?,?,?,?,1,sysdate,?)";
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1,dto.getId());
				pstmt.setString(2,dto.getPwd());
				pstmt.setString(3,dto.getRenumber());
				pstmt.setString(4,dto.getName());
				pstmt.setInt(5,dto.getAge());
				pstmt.setString(6,dto.getEmail());
				pstmt.setString(7,dto.getPhone());
				pstmt.setString(8,dto.getAddress());
				pstmt.setString(9,dto.getGender());
				pstmt.setString(10, dto.getIp());
				resultRow = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (Exception e2) {

			}
		
		}
		return resultRow;
	}
	
	   //회원테이블 전체조회
    public List<User> getAllTableList(){
	   try {
		   conn = ds.getConnection();
		   
		   dtoList = new ArrayList<User>();
		   
		   sql = "select id, ip from users";
		   pstmt = conn.prepareStatement(sql);
		   rs = pstmt.executeQuery();
		   
		   while(rs.next()) {
			   Dto = new User();
			   Dto.setId(rs.getString("id"));
			   Dto.setIp(rs.getString("ip"));
			   dtoList.add(Dto);
		   }
	   } catch (Exception e) {
		   System.out.println(e.getMessage());
	   }finally {
		   try {
			   pstmt.close();
			   rs.close();
			   conn.close();
     	   } catch (Exception e2) {
			
		   }
		   
	   }
		   return dtoList;
    }
}
