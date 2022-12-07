import kr.or.kosa.Emp;

// 0901

class Test2 {
	int x = 100;

	void print() {
		System.out.println("부모 함수 Test2");
	}
}

class Test3 extends Test2 {
	int x = 300;	// 부모 무시하기 >> 쓰지 말기
	
	// 재정의 (검증)
	@Override
	void print() {
		System.out.println("자식이 부모의 함수를 재정의");
	}
	
	void print(String str) {	// Overloading
		System.out.println("오버로딩 함수: " + str);
	}
}





public class Ex05_Inherit_Override {

	public static void main(String[] args) {
		Test3 t3 = new Test3();
		System.out.println(t3.x);
		
		t3.print();
		t3.print("Overloading");
		
		Emp emp = new Emp(1000, "홍길동");
		System.out.println(emp);			// (재정의 전) kr.or.kosa.Emp@3e57cd70 (재정의 후) Emp [empno: 1000, ename: 홍길동]
		System.out.println(emp.toString());	// (재정의 전) kr.or.kosa.Emp@3e57cd70 (재정의 후) Emp [empno: 1000, ename: 홍길동]
		
		// emp 출력시 emp.toString()과 동일한 효과
		// toString()은 Object의 자원	>> 주소값 return
		// toString()을 재정의한 후 >> 재정의된 내용 출력
		// emp와 toString()은 같다
		
		// JAVA API가 제공하는 수많은 클래스가 Object 클래스의 toString을 재정의하고 있다

	}

}
