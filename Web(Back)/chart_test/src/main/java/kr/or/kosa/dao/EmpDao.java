package kr.or.kosa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.kosa.dto.Emp;
import kr.or.kosa.utils.ConnectionHelper;


public class EmpDao {

	
	
	
	//job sal data
	public List<Emp> getJobData() throws SQLException{
		
		PreparedStatement pstmt = null;
		String sql="select job, round(avg(sal)) from emp group by job";
		
		///POOL///////////////////////
		Connection conn = ConnectionHelper.getConnection("oracle");
		//////////////////////////////
		
		pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		List<Emp> emplist = new ArrayList<Emp>(); //POINT
		//[new memo()][new memo()][new memo()][new memo()]
		while(rs.next()) {
			Emp e = new Emp();
			e.setJob(rs.getString("job"));
			e.setSal(rs.getInt("sal"));
			
			emplist.add(e);
		}
		
		ConnectionHelper.close(rs);
		ConnectionHelper.close(pstmt);
		
		//POOL 에게 연결객체 반환////////////
		ConnectionHelper.close(conn);
		////////////////////////////////
		
		return emplist;
	}
}