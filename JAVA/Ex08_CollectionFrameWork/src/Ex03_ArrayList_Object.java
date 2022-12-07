import java.util.ArrayList;
import kr.or.kosa.Emp;

// 0908

public class Ex03_ArrayList_Object {

	public static void main(String[] args) {
		
		// 1. 사원 1명
		Emp emp = new Emp(1000, "김유신", "장군");
		System.out.println(emp.toString());
		
		System.out.println("-----------------------------------");

		// 2. 사원 2명 만들기 array
		Emp[] emplist = {new Emp(100, "김씨", "영업"), new Emp(200, "박씨", "IT")};
		for (Emp e: emplist) {
			System.out.println(e.toString());
		}
		
		System.out.println("-----------------------------------");
		
		// 3. 사원 1명이 입사함 (300, "이씨", "IT")
		// 방 3개짜리 배열 생성해 이사... >> 귀찮아
		// ArrayList
		ArrayList elist = new ArrayList();
		elist.add(new Emp(100, "김씨", "영업"));
		elist.add(new Emp(200, "박씨", "IT"));
		elist.add(new Emp(300, "이씨", "IT"));
		for (int i = 0; i < elist.size(); i++) {
			System.out.println(elist.get(i));
			
			/* Emp e = (Emp)elist.get(i);
			e.toString(); */
		}

		System.out.println("-----------------------------------");

		elist.add(new Emp(400, "최씨", "관리"));
		for (int i = 0; i < elist.size(); i++) {
			System.out.println(elist.get(i).toString());
		}
		
		System.out.println("-----------------------------------");

		// toString() 사용X
		// 4명 사원의 사번, 이름, 직종 출력
		// for문 내에서 getEmpno(), getEname(), getJob() 사용
		
		for (int i = 0; i < elist.size(); i++) {
			Object obj = elist.get(i);
			// obj.toString();
			// Object는 모든 타입의 부모 타입이다 >> downcasting
			Emp e = (Emp) obj;
			System.out.println(e.getEmpno() + ", " + e.getEname() + ", " + e.getJob());
		}
		
		// 현업 개발자 >> Object 타입 >> 항상 다운캐스팅 ... 자식 요소 접근
		// Object 사용하지 말자
		// 타입 강제 (해당 타입만 쓰도록) 하나의 타입만을 가지고 데이터를 관리
		// 제너릭 (객체 생성시 타입 강제하는 방법)
		ArrayList<Emp> list2 = new ArrayList<Emp>();
		// list2.add(emp);
		list2.add(new Emp(1, "A", "IT"));
		for (Emp e: list2) {
			System.out.println(e.getEmpno());
		}
		

	}

}
