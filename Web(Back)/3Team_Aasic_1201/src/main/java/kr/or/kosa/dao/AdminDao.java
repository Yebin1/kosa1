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

import kr.or.kosa.dto.Category;
import kr.or.kosa.dto.Member;
import kr.or.kosa.dto.MemberDetail;

public class AdminDao {
	DataSource ds = null;
	private Connection conn;
	private PreparedStatement pstmt1;
	private PreparedStatement pstmt2;
	private ResultSet rs1;
	private String sql1;
	private String sql2;
	private int resultRow;
	private boolean idCheck; // 아이디 체크여부
	private Member member;
	private MemberDetail memberDetail;
	private List<Member> memberList;
	private List<MemberDetail> memberDetailList;
	private String pwdCheck;
	private Category category;
	private List<Category> categoryList;
	private int totalcount;
	
	public AdminDao() throws NamingException {
		Context context = new InitialContext();
		ds = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
		conn = null;
		pstmt1 = null;
		pstmt2 = null;
		rs1 = null;
		resultRow = 0;
		idCheck = false;
		sql1 = "";
		sql2 = "";
	}
	
	

	
	// 회원테이블 전체조회 (Member)
    public List<Member> getAllTableList(){
	   try {
		   conn = ds.getConnection();
		   memberList = new ArrayList<Member>();
		   
		   sql1 = "select userid, ip from member";
		   pstmt1 = conn.prepareStatement(sql1);
		   rs1 = pstmt1.executeQuery();
		   
		   while(rs1.next()) {
			   member = new Member();
			   member.setUserid(rs1.getString("userid"));;
			   member.setIp(rs1.getString("ip"));
			   memberList.add(member);
		   }
	   } catch (Exception e) {
		   System.out.println(e.getMessage());
	   }finally {
		   try {
			   pstmt1.close();
			   rs1.close();
			   conn.close();
     	   } catch (Exception e2) {
			
		   }
		   
	   }
		   return memberList;
    }
    
    //전체조회 (MemberDetail)
    public List<MemberDetail> getAllMemberList(){
 	   try {
 		   conn = ds.getConnection();
 		   memberDetailList = new ArrayList<MemberDetail>();
 		   
 		   sql1 = "select userid, name, email, phone, gender, joindate from memberdetail"
 		   		+ " where userid in (select userid from member where status = 1)";
 		   pstmt1 = conn.prepareStatement(sql1);
 		   rs1 = pstmt1.executeQuery();
 		   
 		   while(rs1.next()) {
 			   memberDetail = new MemberDetail();
 			   memberDetail.setUserid(rs1.getString("userid"));;
 			   memberDetail.setName(rs1.getString("name"));
 			   memberDetail.setEmail(rs1.getString("email"));
 			   memberDetail.setPhone(rs1.getString("phone"));
 			   memberDetail.setGender(rs1.getString("gender"));
 			   memberDetail.setStartdate(rs1.getDate("joindate"));
 			
 			   memberDetailList.add(memberDetail);
 		   }
 	   } catch (Exception e) {
 		   e.printStackTrace();
 	   }finally {
 		   try {
 			   pstmt1.close();
 			   rs1.close();
 			   conn.close();
      	   } catch (Exception e2) {
 			
 		   }
 		   
 	   }
 		   return memberDetailList;
     }
    
	//계정 활성화
	public int activate(String userid) {
		   try {
			   conn = ds.getConnection();
			   sql1 = "update member set status =1 where userid=?";
			   pstmt1 = conn.prepareStatement(sql1);
			   pstmt1.setString(1, userid);
			   resultRow = pstmt1.executeUpdate();
			   
		   } catch (Exception e) {
			   e.printStackTrace();
		   }finally {
			   try {
				pstmt1.close();
				conn.close();
			   } catch (Exception e2) {
				
			   }
		   }
		   return resultRow;
	}    
	//계정 정지
	public int stop(String userid) {
	   try {
		   conn = ds.getConnection();
		   sql1 = "update member set status =0 where userid=?";
		   pstmt1 = conn.prepareStatement(sql1);
		   pstmt1.setString(1, userid);
		   resultRow = pstmt1.executeUpdate();
		   
	   } catch (Exception e) {
		   e.printStackTrace();
	   }finally {
		   try {
			pstmt1.close();
			conn.close();
		   } catch (Exception e2) {
			
		   }
	   }
	   return resultRow;
   }
	
	// 삭제 대기 게시물 총 건수 구하기
		public int totalCount0() {
			try {
				conn = ds.getConnection();
				sql1 = "select count(idx) cnt from board where boardstatus=0";
				pstmt1 = conn.prepareStatement(sql1);

				rs1 = pstmt1.executeQuery();
				if (rs1.next()) {
					totalcount = rs1.getInt("cnt");
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					pstmt1.close();
					rs1.close();
					conn.close();
				} catch (Exception e2) {

				}
			}
			return totalcount;
		}
		
		// 게시판별 삭제 대기 게시물 개수
		public Integer totalCountStatus(String boardname) {
			int count = 0;
			try {
				conn = ds.getConnection();
				sql1 = "select count(idx) cnt from board where boardname=? and boardstatus=0";
				pstmt1 = conn.prepareStatement(sql1);
				pstmt1.setString(1, boardname);
				rs1 = pstmt1.executeQuery();

				while(rs1.next()) {
					count = rs1.getInt("cnt");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					pstmt1.close();
					rs1.close();
					conn.close();
				} catch (Exception e2) {
				}
			}
			return count;
		}
		
		// 게시판별 삭제대기글 완전삭제
		public int adminDeleteBoard(String boardname) {
			try {
				conn = ds.getConnection();
				conn.setAutoCommit(false);

				sql1 = "delete board where boardname? and boardstatus=0";
				pstmt1 = conn.prepareStatement(sql1);
				pstmt1.setString(1, boardname);
				resultRow = pstmt1.executeUpdate();

				conn.commit();
				conn.setAutoCommit(true);
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					pstmt1.close();
					conn.close();
				} catch (Exception e2) {

				}
			}
			return resultRow;
		}
		// 게시판 카테고리 출력
		public List<Category> categoryList() {
			try {
				conn = ds.getConnection();
				categoryList = new ArrayList<Category>();

				sql1 = "select boardname from category";
				pstmt1 = conn.prepareStatement(sql1);
				rs1 = pstmt1.executeQuery();

				while (rs1.next()) {
					category = new Category();
					category.setBoardname(rs1.getString("boardname"));
					categoryList.add(category);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					pstmt1.close();
					rs1.close();
					conn.close();
				} catch (Exception e2) {
				}
			}
			return categoryList;
		}
}
