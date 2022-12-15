package service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import dao.EmpDao;
import dao.NoticeDao;
import vo.Emp;
import vo.Notice;

@Service
public class EmpService {

	// Mybatis 작업
	private SqlSession sqlsession;

	@Autowired
	public void setSqlsession(SqlSession sqlsession) {
		this.sqlsession = sqlsession;
	}

	
	// Emp 전체 조회
	public List<Emp> allList() {

		// DAO 작업
		List<Emp> list = null;
		try {
			// 동기화/////////////////////////////////////////////////////
			EmpDao empdao = sqlsession.getMapper(EmpDao.class);
			/////////////////////////////////////////////////////////////
			list = empdao.allList();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//상세보기 서비스
		public Emp empDetail(int empno) {
			Emp emp = null;
			try {
					//동기화/////////////////////////////////////////////////////
				EmpDao empdao = sqlsession.getMapper(EmpDao.class);
					///////////////////////////////////////////////////////////	
				    emp = empdao.getEmp(empno);
			} catch (ClassNotFoundException e) {
							e.printStackTrace();
			} catch (SQLException e) {
							e.printStackTrace();
			}
			return emp;		
		}

	
	// Emp 조건 조회
	public List<Emp> searchList(int keyword) {

		// DAO 작업
		List<Emp> list = null;
		try {
			// 동기화/////////////////////////////////////////////////////
			EmpDao empdao = sqlsession.getMapper(EmpDao.class);
			/////////////////////////////////////////////////////////////
			list = empdao.searchList(keyword);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	
	// 삽입
	public String insert(Emp emp) {

		try {
			EmpDao empdao = sqlsession.getMapper(EmpDao.class);
			empdao.insert(emp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:emp.htm";
	}

	
	// 수정
	public Emp empEdit(int empno) {
		Emp emp = null;
		try {
			// 동기화/////////////////////////////////////////////////////
			EmpDao empdao = sqlsession.getMapper(EmpDao.class);
			///////////////////////////////////////////////////////////
			emp = empdao.getEmp(empno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}

	
	// 수정 처리 서비스
	public String empEdit(Emp emp, HttpServletRequest request) {

		try {
			// 동기화/////////////////////////////////////////////////////
			EmpDao empdao = sqlsession.getMapper(EmpDao.class);
			///////////////////////////////////////////////////////////
			empdao.update(emp); // DB insert
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:empDetail.htm?empno=" + emp.getEmpno();
	}

	
	// 삭제
	public String empDel(int empno) {
		EmpDao empdao = sqlsession.getMapper(EmpDao.class);
		try {
			empdao.delete(empno);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return "redirect:emp.htm";
	}

}
