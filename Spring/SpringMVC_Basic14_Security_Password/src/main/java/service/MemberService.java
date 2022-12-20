package service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.MemberDao;
import dto.Member;
import kr.co.test.model.dao.MemberDAO;

@Service
public class MemberService {
	
	private SqlSession sqlsession;
	
	@Autowired
	public void setSqlsession(SqlSession sqlsession) {
		this.sqlsession = sqlsession;
	}
	
	public int insertMember(Member member) {
		int result = 0;
		MemberDao dao = sqlsession.getMapper(MemberDao.class);
		result = dao.insertMember(member);
		return result;
	}
	
	public int passwordCheck(String userid, String password){
		MemberDao dao = sqlsession.getMapper(MemberDao.class);
		int result = dao.passwordCheck(userid, password);
		return result;
	}

}
