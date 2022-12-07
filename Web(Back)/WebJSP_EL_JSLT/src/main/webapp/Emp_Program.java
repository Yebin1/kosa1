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


	public static void empPrint(Emp emp) {
		System.out.println(emp.toString());
	}

	public static void empPrint(List<Emp> list) {
		for (Emp data : list) {
			System.out.println(data.toString());
		}
	}

}
