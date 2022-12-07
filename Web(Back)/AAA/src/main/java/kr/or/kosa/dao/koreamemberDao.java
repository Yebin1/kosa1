package kr.or.kosa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.bit.utils.Singleton_Helper;
import kr.or.kosa.dto.koreamemberDto;
import kr.or.kosa.utils.ConnectionHelper;

/*
1. DB연결 POOL
2. insert 작업 
insert into mvcregister(id,pwd,email) values(?,?,?)

*/
public class koreamemberDao {
   private Connection conn;
   private PreparedStatement pstmt;
   private ResultSet rs;
   private String sql;
   private int resultrow;
   private boolean ischeck;
   private koreamemberDto Dto;
   private List<koreamemberDto> dtoList;
   
   public koreamemberDao() {
	   conn = null;
	   pstmt = null;
	   rs = null;
	   resultrow = 0;
	   ischeck = false;
	   sql = "";
	   dtoList = null;
  }
  
   
   //계정 수정 조회
   public koreamemberDto getUpdateMember(String id){
	   try {
		   
		   conn = ConnectionHelper.getConnection("oracle");
		   sql = "select id, pwd, name, age, trim(gender),email from koreamember where id=?";
		   pstmt = conn.prepareStatement(sql);
		   pstmt.setString(1, id);
		   
		   rs= pstmt.executeQuery();
		   
		   if (rs.next()) {
			   Dto = new koreamemberDto();
			   Dto.setId(rs.getString(1));
			   Dto.setPwd(rs.getString(2));
			   Dto.setName(rs.getString(3));
			   Dto.setAge(rs.getInt(4));
			   Dto.setGender(rs.getString(5));
			   Dto.setEmail(rs.getString(6));
	       }
		   
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			ConnectionHelper.close(pstmt);	
			ConnectionHelper.close(rs);
			ConnectionHelper.close(conn);
		}
	   return Dto;
   }
  
   //계정 수정
   public int update(koreamemberDto dto) {	   
	   try {
		   String pwdCheck;
		   conn = ConnectionHelper.getConnection("oracle");
		   sql="update koreamember set name=? , age=? , email=? , gender=? where id=?";
		   pstmt = conn.prepareStatement(sql);
		   
		   pstmt.setString(1, dto.getName());
		   pstmt.setInt(2, dto.getAge());
		   pstmt.setString(3, dto.getEmail());
		   pstmt.setString(4, dto.getGender());
		   pstmt.setString(5, dto.getId());
		   
		   resultrow = pstmt.executeUpdate(); 
		  		 
	   } catch (Exception e) {
			System.out.println(e.getMessage());
	   }finally {
		   ConnectionHelper.close(pstmt);
		   ConnectionHelper.close(conn);
	   }	   
	   return resultrow;
   }
   
   
   //아이디 체크
   public boolean idCheck(String id, String pwd) {	   
	   try {
		   String pwdCheck;
		   conn = ConnectionHelper.getConnection("oracle");
		   sql="select id, pwd from koreaMember where id=?";
		   pstmt = conn.prepareStatement(sql);
		   pstmt.setString(1, id);
		  		   
		   rs= pstmt.executeQuery();
		   		   
		   if (rs.next()) {

	            pwdCheck = rs.getString("pwd");
	
	            
	            if(pwdCheck.equals(pwd)){
	            	ischeck =  true; // 아이디, 비밀번호 일치
	            }else{
	            	ischeck = false; // 비밀번호 불일치
	            }
	       }
		   else {
			   ischeck = false;
		   }   // 아이디 존재하지 않음
	   } catch (Exception e) {
			System.out.println(e.getMessage());
	   }finally {
		   ConnectionHelper.close(pstmt);
		   ConnectionHelper.close(rs);
		   ConnectionHelper.close(conn);
	   }	   
	   return ischeck;
   }
  
   
   
   //회원테이블 전체조회
   
   public List<koreamemberDto> getAllTableList(){
	   try {
		   dtoList = new ArrayList<koreamemberDto>();
		   conn = ConnectionHelper.getConnection("oracle");
		   sql = "select id, ip from koreamember";
		   pstmt = conn.prepareStatement(sql);
		   rs = pstmt.executeQuery();
		   
		   while(rs.next()) {
			   Dto = new koreamemberDto();
			   Dto.setId(rs.getString("id"));
			   Dto.setIp(rs.getString("ip"));
			   dtoList.add(Dto);
		   }
	   } catch (Exception e) {
		   System.out.println(e.getMessage());
	   }finally {
		   ConnectionHelper.close(pstmt);
			ConnectionHelper.close(rs);
			ConnectionHelper.close(conn);
	   }
		   return dtoList;
   }
   
   //회원테이블 상세조회
   
   public koreamemberDto getIdTableList(String id){
	   try {
		   conn = ConnectionHelper.getConnection("oracle");
		   sql = "select id,pwd,name,age,gender,email from koreamember where id=?";
		   pstmt = conn.prepareStatement(sql);
		   pstmt.setString(1, id);
		   rs=pstmt.executeQuery();
		   
		   while(rs.next()) {
			   Dto = new koreamemberDto();
			   Dto.setId(rs.getString("id"));
			   Dto.setPwd(rs.getString("pwd"));
			   Dto.setName(rs.getString("name"));
			   Dto.setAge(rs.getInt("age"));
			   Dto.setGender(rs.getString("gender"));
			   Dto.setEmail(rs.getString("email"));
		   }
		   
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			ConnectionHelper.close(pstmt);	
			ConnectionHelper.close(rs);
			ConnectionHelper.close(conn);
		}
	   return Dto;
   }
   
   
   
   //회원가입
   public int writeOk(koreamemberDto dto) {
          
      int resultrow=0;
      try {
            conn = ConnectionHelper.getConnection("oracle");
            sql="insert into koreaMember(id, pwd, name, age, gender, email, ip) values(?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            

            pstmt.setString(1,dto.getId());
            pstmt.setString(2,dto.getPwd());
            pstmt.setString(3, dto.getName());
            pstmt.setInt(4,dto.getAge());
            pstmt.setString(5, dto.getGender());
    		pstmt.setString(6, dto.getEmail());
    		pstmt.setString(7, dto.getIp());
            
            resultrow = pstmt.executeUpdate();
      } catch (SQLException e) {      
         e.printStackTrace();
      }finally {
         ConnectionHelper.close(pstmt);
         ConnectionHelper.close(conn);
      }
      return resultrow;
   }
   
   
   //삭제   
   public int delete(String id) {
	   
	   try {
		   conn = ConnectionHelper.getConnection("oracle");
		   sql = "delete from koreamember where id=?";
		   pstmt = conn.prepareStatement(sql);
		   pstmt.setString(1, id);
		   
		   resultrow = pstmt.executeUpdate();
		   
		   
	   } catch (Exception e) {
		   e.printStackTrace();
	   }finally {
		   ConnectionHelper.close(pstmt);
		   ConnectionHelper.close(conn);
	   }
	   
	   return resultrow;
   }

}