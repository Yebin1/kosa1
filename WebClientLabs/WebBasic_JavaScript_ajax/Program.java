import java.sql.SQLException;
import java.util.List;

import DAO.DeptDao;
import DTO.Dept;

/*
MVC 패턴
>> 잘하는 것만 해

Model		: 데이터 		java
View		: 화면		jsp
Controller	: 조정 (제어)	servlet

jsp, servlet, java ...

Model	: DTO(VO), DAO >> java
View	: java (console)
...

*/
public class Program {

	public static void main(String[] args) {
		
		DeptDao dao = new DeptDao();
		
		
		// 전체 조회
		System.out.println("[전체 조회]");
		List<Dept> deptlist = dao.getDeptAllList();
		if (deptlist != null) {
			deptPrint(deptlist);
		}
		
		System.out.println();
		
		// 조건 조회
		System.out.println("[조건 조회]");
		Dept dept = dao.getDeptListByDeptNo(10);
		if (dept != null) {
			deptPrint(dept);
		} else {
			
		}
		
		System.out.println();
		
		// 데이터 삽입
		System.out.println("[데이터 삽입]");
		Dept insertdept = new Dept();
		insertdept.setDeptno(100);
		insertdept.setDname("IT");
		insertdept.setLoc("SEOUL");
		int row = dao.insertDept(insertdept);
		if (row > 0) {
			System.out.println("insert rowcount: " + row);
		} else {
			
		}
		
		System.out.println();
		
		// 전체 조회
		System.out.println("[전체 조회]");
		deptlist = dao.getDeptAllList();
		if (deptlist != null) {
			deptPrint(deptlist);
		}
		
		System.out.println();
		
		// 데이터 수정
		System.out.println("[데이터 수정]");
		Dept updatedept = new Dept();
		updatedept.setDeptno(100);
		updatedept.setDname("IT_UP");
		updatedept.setLoc("SEOUL_UP");
		row = dao.updateDept(updatedept);
		if (row > 0) {
			System.out.println("update rowcount: " + row);
		} else {
			
		}
		
		System.out.println();
		
		// 전체 조회
		System.out.println("[전체 조회]");
		deptlist = dao.getDeptAllList();
		if (deptlist != null) {
			deptPrint(deptlist);
		}
		
		System.out.println();
		
		// 데이터 삭제
		row = dao.deleteDept(100);
		if (row > 0) {
			System.out.println("delete rowcount: " + row);
		} else {
			
		}
		
		System.out.println();
	
		// 전체 조회
		System.out.println("[전체 조회]");
		deptlist = dao.getDeptAllList();
		if (deptlist != null) {
			deptPrint(deptlist);
		}
	
	}
	
	public static void deptPrint(Dept dept) {
		System.out.println(dept.toString());
	}
	
	public static void deptPrint(List<Dept> list) {
		for (Dept data: list) {
			System.out.println(data.toString());
		}
	}

}
	
