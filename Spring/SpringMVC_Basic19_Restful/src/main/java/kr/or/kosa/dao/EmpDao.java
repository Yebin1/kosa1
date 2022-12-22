package kr.or.kosa.dao;

import java.util.List;

import kr.or.kosa.dto.Emp;

public interface EmpDao {

	// CRUD 함수
	
	int insert (Emp emp);
	
	List<Emp> select();
	Emp SelectByEmpno(int empno);
	
	int update (Emp emp);
	
	int delete(int empno);
	
}
