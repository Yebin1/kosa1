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

import kr.or.kosa.dto.Board;
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
	private StringBuffer sql4;
	private int resultRow;
	private String userid;
	private int status;
	private boolean idCheck; // 아이디 체크여부
	private Member member;
	private MemberDetail memberDetail;
	private List<Member> memberList;
	private List<MemberDetail> memberDetailList;
	private String pwdCheck;
	private Category category;
	private List<Category> categoryList;
	private int totalcount;
	private List<Board> boardDeleteList;
	private Board board;

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
	public List<Member> getAllTableList() {
		try {
			conn = ds.getConnection();
			memberList = new ArrayList<Member>();

			sql1 = "select userid, ip from member";
			pstmt1 = conn.prepareStatement(sql1);
			rs1 = pstmt1.executeQuery();

			while (rs1.next()) {
				member = new Member();
				member.setUserid(rs1.getString("userid"));
				;
				member.setIp(rs1.getString("ip"));
				memberList.add(member);
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
		return memberList;
	}

	// 전체조회 (MemberDetail)
	public List<MemberDetail> getAllMemberList() {
		try {
			conn = ds.getConnection();
			memberDetailList = new ArrayList<MemberDetail>();

			sql1 = "select userid, name, email, phone, gender, joindate from memberdetail"
					+ " where userid in (select userid from member where status = 1)";
			pstmt1 = conn.prepareStatement(sql1);
			rs1 = pstmt1.executeQuery();

			while (rs1.next()) {
				memberDetail = new MemberDetail();
				memberDetail.setUserid(rs1.getString("userid"));
				;
				memberDetail.setName(rs1.getString("name"));
				memberDetail.setEmail(rs1.getString("email"));
				memberDetail.setPhone(rs1.getString("phone"));
				memberDetail.setGender(rs1.getString("gender"));
				memberDetail.setStartdate(rs1.getDate("joindate"));

				memberDetailList.add(memberDetail);
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
		return memberDetailList;
	}

	// 계정 활성화
	public int activate(String userid) {
		try {
			conn = ds.getConnection();
			sql1 = "update member set status =1 where userid=?";
			pstmt1 = conn.prepareStatement(sql1);
			pstmt1.setString(1, userid);
			resultRow = pstmt1.executeUpdate();

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

	// 계정 정지
	public int stop(String userid) {
		try {
			conn = ds.getConnection();
			sql1 = "update member set status =0 where userid=?";
			pstmt1 = conn.prepareStatement(sql1);
			pstmt1.setString(1, userid);
			resultRow = pstmt1.executeUpdate();

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

			while (rs1.next()) {
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

	// 게시물 목록보기
	public List<Board> list(int cpage, int pagesize) {
		try {
			conn = ds.getConnection();
			sql1 = "SELECT *  FROM (SELECT ROWNUM RNUM, board.*  FROM "
					+ "(SELECT * FROM board where boardstatus = 0 ORDER BY idx DESC) board) "
					+ "WHERE RNUM >= ? AND RNUM <= ?";

			pstmt1 = conn.prepareStatement(sql1);

			int start = cpage * pagesize - (pagesize - 1);
			int end = cpage * pagesize;
			pstmt1.setInt(1, start);
			pstmt1.setInt(2, end);
			rs1 = pstmt1.executeQuery();
			boardDeleteList = new ArrayList<Board>();

			while (rs1.next()) {
				board = new Board();
				board.setIdx(rs1.getInt("idx"));
				board.setBoardname(rs1.getString("boardname"));
				board.setTitle(rs1.getString("title"));
				board.setUserid(rs1.getString("userid"));
				board.setWritedate(rs1.getDate("writedate"));
				board.setReadnum(rs1.getInt("readnum"));
				board.setLovenum(rs1.getInt("lovenum"));
				boardDeleteList.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt1.close();
				rs1.close();
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return boardDeleteList;
	}
	
////다영: 회원 활성화 및 비활성화 ////////////////////////////////////////////////////////
		//활성화 여부 검사
		public int activationCheck(Member member) {
			int activationCheck = -1; //아예 동작 하지 않을 경우 대비해서 -1로 초기화
			
			try {
				conn = ds.getConnection();
				sql1 = "select userid, status from member where userid = ?";
				pstmt1 = conn.prepareStatement(sql1);
				pstmt1.setString(1, member.getUserid());
				rs1 = pstmt1.executeQuery();
				
				if(rs1.next()) {
					activationCheck = rs1.getInt("status");
				}

			}catch(Exception e7) {
				System.out.println("e7: "+ e7);
				e7.getStackTrace();
			}finally {
				try {
					pstmt1.close();
					rs1.close();
					conn.close();
				} catch (Exception e8) {
					System.out.println("e8: " + e8.getMessage());
					e8.getStackTrace();
				}
			}
			
			return activationCheck;
		}
		
		//다영
		//활성화 update
		public int activationUpdate(int status, Member member) {
			
			try {
				conn = ds.getConnection();
				conn.setAutoCommit(false);
				
				if(status ==0) {
					sql1 = "update member set status=1 where userid=?";
					pstmt1 = conn.prepareStatement(sql1);
					pstmt1.setString(1, member.getUserid());
					resultRow = pstmt1.executeUpdate();
				}else if(status ==1) {
					sql1 = "update member set status=0 where userid=?";
					pstmt1 = conn.prepareStatement(sql1);
					pstmt1.setString(1, member.getUserid());
					resultRow = pstmt1.executeUpdate();

				}
				conn.commit();
				conn.setAutoCommit(true);
						
			} catch (Exception e) {
				// TODO: handle exception
			}finally {
				try {
					pstmt1.close();
					conn.close();
				} catch (Exception e8) {
					System.out.println("e8: " + e8.getMessage());
					e8.getStackTrace();
				}
			}
			return resultRow;		
		}
		
		

		////다영: 회원 조회//////////////////////////////////////////////////////////////
		
		//다영: 아이디 조회 시 총 검색된 사용자 수
		public int totalSearchCount(String searchID) {
			sql4 = new StringBuffer();
			try {
				conn=ds.getConnection();
				sql4.append("SELECT count(*) cnt FROM memberdetail where userid LIKE ?");
				pstmt1 = conn.prepareStatement(sql4.toString());
				pstmt1.setString(1, "%" + searchID + "%");
				
				rs1 = pstmt1.executeQuery();
				if(rs1.next()) {
					totalcount = rs1.getInt("cnt");
				}
			}catch(Exception e5) {
					System.out.println("e2: " + e5);
					e5.getStackTrace();
				} finally {
					try {
						pstmt1.close();
						rs1.close();
						conn.close();
					} catch (Exception e6) {
						e6.getStackTrace();
					}
				}

			System.out.println(totalcount);
			return totalcount;
			
			}
		
		// 다영: 검색어로 사용자 조회
		  // 유저 status  조회
	      public List<Member> SearchUserStatusList(int cpage, int pagesize, String searchUserid){
	    	  List<Member> memberList = new ArrayList<Member>();	    	  
	    	  sql4 = new StringBuffer();
	    	  
	    	  try {
	    		  conn = ds.getConnection();
		          sql4.append("select * from (select rownum rnum, d.* from "
		                  + "(select member.userid, status from member "
		        		  + "join memberdetail on member.userid=memberdetail.userid "
		                  + "where member.userid like ? order by memberdetail.joindate desc) d) "
		                  + "where rnum >=? and rnum <=? ");	 
		          
		          
		            int start = cpage * pagesize - (pagesize - 1);
		            int end = cpage * pagesize;
		            
		            pstmt1 = conn.prepareStatement(sql4.toString());
		            pstmt1.setString(1, "%" + searchUserid + "%");
		            pstmt1.setInt(2, start);
		            pstmt1.setInt(3, end);
		            
		            rs1 = pstmt1.executeQuery();
		            
		            while(rs1.next()) {
		            	Member member = new Member(); 
			               member.setUserid(rs1.getString("userid"));
			               member.setStatus(rs1.getInt("status"));
			               memberList.add(member);
		            }
	    		  
				
			} catch (Exception e17) {
	            e17.printStackTrace();
	         } finally {
	            try {
	               pstmt1.close();
	               rs1.close();
	               conn.close();
	            } catch (Exception e18) {
	               e18.printStackTrace();
	            }
	         }

	         return memberList; 
	      }

		//다영: 검색어로 사용자 조회
		// 유저 검색 조회
	      public List<MemberDetail> SearchUseridList(int cpage, int pagesize, String searchUserid) {
	         List<MemberDetail> memberDetailList = new ArrayList<MemberDetail>(); 
	         sql4 = new StringBuffer();	         
	         try {	            
	            conn = ds.getConnection();
	            sql4.append("select * from (select rownum rnum, d.* from "
	                  + "(select userid, name, email, phone, gender, joindate from memberdetail "
	                  + "where userid like ? order by joindate desc) d) "
	                  + "where rnum >=? and rnum <=?");	       

	            int start = cpage * pagesize - (pagesize - 1);
	            int end = cpage * pagesize;
	            
	            pstmt1 = conn.prepareStatement(sql4.toString());
	            pstmt1.setString(1, "%" + searchUserid + "%");
	            pstmt1.setInt(2, start);
	            pstmt1.setInt(3, end);
	            
	            rs1 = pstmt1.executeQuery();

	            while (rs1.next()) {
	               MemberDetail memberDetail = new MemberDetail(); 
	               memberDetail.setUserid(rs1.getString("userid"));
	               memberDetail.setName(rs1.getString("name"));
	               memberDetail.setEmail(rs1.getString("email"));
	               memberDetail.setPhone(rs1.getString("phone"));
	               memberDetail.setGender(rs1.getString("gender"));
	               memberDetail.setStartdate(rs1.getDate("joindate"));
	               
	               memberDetailList.add(memberDetail);

	               
	            }

	         } catch (Exception e15) {
	            e15.printStackTrace();
	         } finally {
	            try {
	               pstmt1.close();
	               rs1.close();
	               conn.close();
	            } catch (Exception e16) {
	               e16.printStackTrace();
	            }
	         }

	         return memberDetailList; 
	      }
}
