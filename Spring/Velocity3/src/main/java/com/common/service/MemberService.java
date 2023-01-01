package com.common.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.common.dao.MemberDao;
import com.common.dto.Member;


@Service
public class MemberService {

	// Mybatis 작업
	private SqlSession sqlsession;

	@Autowired
	public void setSqlsession(SqlSession sqlsession) {
		this.sqlsession = sqlsession;
	}
	
	
	// 회원 가입
		public String insert(Member member) {
			String check=null;
			try {
				//동기화/////////////////////////////////////////////////////
				MemberDao memberdao = sqlsession.getMapper(MemberDao.class);
					///////////////////////////////////////////////////////////
				memberdao.insert(member);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return check;
		}

	//member idChek
			public String memberDetail(String userid) {
				String member = "Y";
				String check="Y";
				try {
					System.out.println(userid);
						//동기화/////////////////////////////////////////////////////
					MemberDao memberdao = sqlsession.getMapper(MemberDao.class);
						///////////////////////////////////////////////////////////
					member = memberdao.idCheck(userid);
					
					if(member != null) {
						check="N"; //중복
					} else {
						check="Y";
					}			
				} catch (ClassNotFoundException e) {
								e.printStackTrace();
				} catch (SQLException e) {
								e.printStackTrace();
				}
				return check;		
			}
	
	// Emp 전체 조회
	public List<Member> allList() {

		// DAO 작업
		List<Member> list = null;
		try {
			// 동기화/////////////////////////////////////////////////////
			MemberDao memberdao = sqlsession.getMapper(MemberDao.class);
			/////////////////////////////////////////////////////////////
			list = memberdao.getMember();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	

}
