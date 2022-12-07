/* 0901

this: 객체 자신을 가리키는 this(this.empno, this.ename)
this: 생성자를 호출하는 this ( this(100, "red") )

상속 관계
부모, 자식

super(현재 자식이 부모의 접근 주소값을 가진다): 상속 관계에서 부모에게 접근할 수 있는 방법
 * super 부모 객체의 주소값을 가진다

1. super >> 상속 관계에서 부모 자원에 접근
2. super >> 상속 관계에서 부모의 생성자 호출 가능 (명시적으로)

java: super()

*/

class Base {
	
	String basename;
	
	Base () {
		System.out.println("Base 기본 생성자 함수");
	}
	
	Base (String basename){
		this.basename = basename;
		System.out.println("basename: " + this.basename);
	}
	
	void method() {
		System.out.println("부모 method");
	}
}

class Derived extends Base {
	
	String dname;
	
	Derived() {
		System.out.println("Derived 기본 생성자 함수");
	}
	
	Derived(String dname) {
		
		// 부모의 생성자 호출 super
		super(dname);
		
		this.dname = dname;
		System.out.println("dname: " + this.dname);
	}
	
	@Override
	void method() {
		System.out.println("부모 자원 재정의");
	}
	// 재정의해서 무조건 "부모 자원 재정의" 출력됨
	
	void pmethod() {
		super.method();		// 부모 함수
		// 재정의 상태에서 부모 자원을 부를 수 있는 유일한 방법: super
	}
}


public class Ex06_Inherit_super {

	public static void main(String[] args) {
		
	//	Derived d = new Derived();			// Base 기본 생성자 함수
											// Derived 기본 생성자 함수
											// overloading 파라미터 다르므로
		
		Derived d = new Derived("홍길동");	// Base 기본 생성자 함수
											// dname: 홍길동
											// 입력 받은 parameter가 dname이므로 Base (String basename) 호출 X
											
											// super(dname);을 통해 부모의 생성자를 호출하면
											// basename: 홍길동
											// dname: 홍길동
		d.method();							// console: 부모 자원 재정의
		d.pmethod();						// console: 부모 method
	}

}
