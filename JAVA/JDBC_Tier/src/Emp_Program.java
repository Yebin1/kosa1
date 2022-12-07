import java.util.Date;
import java.util.List;

import DAO.EmpDao;
import DTO.Emp;

public class Emp_Program {

	public static void main(String[] args) {

		EmpDao dao = new EmpDao();

		// 전체 조회
		System.out.println("[전체 조회]");
		List<Emp> emplist = dao.getEmpAllList();
		if (emplist != null) {
			empPrint(emplist);
		}

		System.out.println();

		// 조건 조회
		System.out.println("[조건 조회]");
		Emp emp = dao.getEmpListByEmpNo(7788);
		if (emp != null) {
			empPrint(emp);
		} else {

		}

		System.out.println();

		// 데이터 삽입
		System.out.println("[데이터 삽입]");
		Emp insertemp = new Emp();
		insertemp.setEmpno(1000);
		insertemp.setEname("AAA");
		insertemp.setJob("job");
		insertemp.setMgr(9999);
		insertemp.setHiredate(new Date());
		insertemp.setSal(5000);
		insertemp.setComm(50);
		insertemp.setDeptno(20);
		int row = dao.insertEmp(insertemp);
		if (row > 0) {
			System.out.println("insert rowcount: " + row);
		} else {

		}

		System.out.println();

		// 전체 조회
		System.out.println("[전체 조회]");
		emplist = dao.getEmpAllList();
		if (emplist != null) {
			empPrint(emplist);
		}

		System.out.println();

		// 데이터 수정
		System.out.println("[데이터 수정]");
		Emp updateemp = new Emp();
		updateemp.setEmpno(1000);
		updateemp.setEname("BBB");
		updateemp.setJob("job2");
		updateemp.setSal(3000);
		updateemp.setHiredate(new Date());
		row = dao.updateEmp(updateemp);
		if (row > 0) {
			System.out.println("update rowcount: " + row);
		} else {

		}

		System.out.println();

		// 전체 조회
		System.out.println("[전체 조회]");
		emplist = dao.getEmpAllList();
		if (emplist != null) {
			empPrint(emplist);
		}

		System.out.println();

		// 데이터 삭제
		row = dao.deleteEmp(1000);
		if (row > 0) {
			System.out.println("delete rowcount: " + row);
		} else {

		}

		System.out.println();

		// 전체 조회
		System.out.println("[전체 조회]");
		emplist = dao.getEmpAllList();
		if (emplist != null) {
			empPrint(emplist);
		}

	}

	public static void empPrint(Emp emp) {
		System.out.println(emp.toString());
	}

	public static void empPrint(List<Emp> list) {
		for (Emp data : list) {
			System.out.println(data.toString());
		}
	}

}
