package com.common.dao;

import java.sql.SQLException;
import java.util.List;

import com.common.dto.Member;

public interface MemberDao {
	List<Member> getMember() throws ClassNotFoundException, SQLException;

	int insert(Member member) throws ClassNotFoundException, SQLException;

	String idCheck(String userid) throws ClassNotFoundException, SQLException;

}
