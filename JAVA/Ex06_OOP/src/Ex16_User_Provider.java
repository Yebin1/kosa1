/* 0906

user 사용자 <ㅡ> provider 제공자

class A {}
class B {}
관계: A는 B를 사용합니다

1. 상속: A extends B
2. 포함: A라는 클래스가 member field로 B를 사용 >> class A { B b; }
 * 부분
 * 전체

class B {}
class A {
	public int i;
	public B b;			// A는 B를 사용한다 (포함)
	public A() {
		b = new B();	// 생성자를 통해 초기화 (주소값 갖게 만들기)
	}
}
>> main 함수
A a = new A();			// B도 함께 만들어진다
a.b.자원					// b에 접근하는 방식

>> 포함 관계로 사용시 B는 독자적으로 생성 불가능
>> A라는 객체가 만들어져야 B도 같이 생성
>> A, B는 운명 공동체 (전체 집합)
>> 자동차와 엔진, 노트북과 CPU
-----------------------------------------------------------
public class B {}
public class A {
	public int i;
	public B b;			// A는 B를 사용한다
	public A() {}
	
	// method
	void m(B b) {
		this.b = b;		// B가 만들어지는 것X (new 안해서)
	}
}
>> main 함수
A a = new A();
B b = new B();
a.m(b);
>> A, B는 다른 운명 (부분 집합)


class A {}
class B {}
관계:	A는 B를 사용합니다
	A는 B를 참조합니다 (포함) >> B를 member field로 사용

*/

interface Icall {
	void m();
}

class D implements Icall {

	@Override
	public void m() {
		System.out.println("D 클래스가 Icall 인터페이스에 함수 m()을 재정의");		
	}	
}

class F implements Icall {
	
	@Override
	public void m() {
		System.out.println("F 클래스가 Icall 인터페이스에 함수 m()을 재정의");
	}
}

// 현대적인 프로그래밍 방식 (interface 대세) >> 유연성 >> 대충 만들어도 대충 들어맞는...
// >> 느슨하게 >> 





class C {
	/* 확장성, 변환 무시
	void method(D d) {}
	void m(F f) {}
	*/
	void method(Icall ic) {	// Icall을 구현하는 모든 객체의 주소가 올 수 있다
		ic.m();
	}
}


public class Ex16_User_Provider {

	public static void main(String[] args) {
		C c = new C();
		D d = new D();
		F f = new F();
		
		c.method(d);		// implements Icall
		c.method(f);

	}

}
