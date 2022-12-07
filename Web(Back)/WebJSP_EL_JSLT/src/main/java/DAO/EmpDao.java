package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DTO.Emp;
import UTILS.SingletonHelper;

public class EmpDao {
	
	Connection conn = null;
	
	public EmpDao() {
		conn = SingletonHelper.getConnection("oracle");
	}
	
	// 전체 조회
	public List<Emp> getEmpAllList() {
		
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		List<Emp> emplist = new ArrayList<Emp>();
		
		try {
			
			String sql = "select empno, ename, job, mgr, hiredate, sal, comm, deptno from emp";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Emp emp = new Emp();
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setMgr(rs.getInt("mgr"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setSal(rs.getInt("sal"));
				emp.setComm(rs.getInt("comm"));
				emp.setDeptno(rs.getInt("deptno"));
				emplist.add(emp);
			}	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			SingletonHelper.close(rs);
			SingletonHelper.close(pstmt);
		}
		return emplist;
	}
	
	// 조건 조회
		public Emp getEmpListByEmpNo(int empno) {

			ResultSet rs = null;
			PreparedStatement pstmt = null;
			Emp emp = null;

			try {

				String sql = "select empno, ename, job, mgr, hiredate, sal, comm, deptno from emp where empno = ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, empno);
				rs = pstmt.executeQuery();

				while (rs.next()) {
					emp = new Emp();
					emp.setEmpno(rs.getInt("empno"));
					emp.setEname(rs.getString("ename"));
					emp.setJob(rs.getString("job"));
					emp.setMgr(rs.getInt("mgr"));
					emp.setHiredate(rs.getDate("hiredate"));
					emp.setSal(rs.getInt("sal"));
					emp.setComm(rs.getInt("comm"));
					emp.setDeptno(rs.getInt("deptno"));
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				SingletonHelper.close(rs);
				SingletonHelper.close(pstmt);
			}
			return emp;
		}
		
		// 이름 검색
		public List<Emp> getEmpAllListByEmpno(int empno){		//Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;		//POINT
			List<Emp> emplist = new ArrayList<Emp>();
			try {
				String sql = "select empno, ename, job, nvl(mgr,''), hiredate, sal, nvl(comm,0), deptno from emp where empno like ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%" + empno + "%"); //like '%SEOUL%'
				rs = pstmt.executeQuery();

				while (rs.next()) {
					Emp emp = new Emp(); // 하나의 row 담기 위한 객체
					emp.setEmpno(rs.getInt(1));
					emp.setEname(rs.getString(2));
					emp.setJob(rs.getString(3));
					emp.setMgr(rs.getInt(4));
					emp.setHiredate(rs.getDate(5));
					emp.setSal(rs.getInt(6));
					emp.setComm(rs.getInt(7));
					emp.setDeptno(rs.getInt(8));
					emplist.add(emp); // 배열에 객체 담는 것
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				SingletonHelper.close(rs);
				SingletonHelper.close(pstmt);
			}

			return emplist;
		}

}

