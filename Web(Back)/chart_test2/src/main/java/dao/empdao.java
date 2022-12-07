package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import net.sf.json.JSONArray;
import utils.ConnectionHelper;

public class empdao {
	public JSONArray getemp() {
		JSONArray ja = new JSONArray();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		JSONArray col = new JSONArray();//컬타이틀
		col.add("부서");
		col.add("평균 월급");
		ja.add(col);
		
		try {
			conn = ConnectionHelper.getConnection("oracle");
			String sql = "select d.dname as d, ceil(avg(e.sal)) as c from emp e right JOIN dept d on e.deptno = d.deptno group by d.dname";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				JSONArray row = new JSONArray();
				row.add(rs.getString("d"));
				row.add(rs.getInt("c"));
				
				ja.add(row);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				ConnectionHelper.close(rs);
				ConnectionHelper.close(pstmt);
				ConnectionHelper.close(conn);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	System.out.println(ja);
		return ja;
	}
}
