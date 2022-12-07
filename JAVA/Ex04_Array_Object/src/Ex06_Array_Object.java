import kr.or.bit.Emp;

// 0830

public class Ex06_Array_Object {

	public static void main(String[] args) {
		
		/*
		사원 3명을 생성
		사원 정보
		1. 1000, 홍길동
		2. 2000, 김유신
		3. 3000, 유관순
		생성 후 사번과 이름 출력
		*/
		
		// 1
		Emp[] emplist = new Emp[3];
		emplist[0] = new Emp(1000, "홍길동");
		emplist[1] = new Emp(2000, "김유신");
		emplist[2] = new Emp(3000, "유관순");
		/*
		for(int i = 0; i < emplist.length; i++) {
			emplist[i].empInfoPrint();
		}
		*/
		// 2
		Emp[] emplist2 = new Emp[] {new Emp(1000, "홍길동"), new Emp(2000, "김유신"), new Emp(3000, "유관순")};
		
		// 3
		Emp[] emplist3 = {new Emp(1000, "홍길동"), new Emp(2000, "김유신"), new Emp(3000, "유관순")};
		for (Emp e: emplist3) {
			e.empInfoPrint();
		}

	}

}
