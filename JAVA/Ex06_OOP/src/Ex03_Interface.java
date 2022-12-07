/* 0906

추상 클래스와 인터페이스

추상 클래스와 인터페이스의 공통점
1. 스스로 객체 생성 불가능 (new 연산자 사용 불가)
>> 차이점
 * 추상 클래스:	부분적으로 완성된 것이 있고, 나머지 미완성
 * 인터페이스:	모든 것이 미완성 (약속만 가짐)
2. 사용
 * 추상 클래스:	extends
 * 인터페이스:	implements

class Car extends Abclass {}
class Car implements Ia {}
>> 둘 다 추상 자원을 가진다
>> extends, implements >> 강제 구현 목적 (재정의)

추상 클래스와 인터페이스의 차이점
1. 완성, 미완성
 * 추상 클래스:	완성된 코드를 일부 가진다
 * 인터페이스:	전체적으로 미완성
>> 원칙적으로 클래스는 다중 상속이 불가 	>> 계층적 상속
>> 인터페이스는 유일하게 다중 구현이 가능	>> 작은 단위로 여러 개를 만들어 모아 큰 약속 >> 너무 큰 약속: 사용성, 재사용성 저하
Ia, Ib, Ic
class Test extends Object implements Ia, Ib, Ic {} 
Tip) 인터페이스끼리는 상속이 가능 (extends) >> 약속을 크게 만들 수 있다
2. 인터페이스: 상수를 제외한 나머지는 일반적으로 미완성(추상 함수) 자원 >> JDK8 (Default 값, static 값)

인터페이스: 약속, 표준 (규칙, 규약)
소프트웨어 설계의 최상위 단계

초급 개발자는 설계보다 만들어진 인터페이스를 사용하는 방법, 처리에 초점
구현부를 가지지 않음 >> 약속에 대한 정의만

초급 개발자의 시선
1. 인터페이스를 **다형성** 입장으로 접근 (인터페이스는 부모 타입)
2. 서로 연관성이 없는 클래스를 하나로 묶어주는 기능 (같은 부모를 가지게 함으로써)
3. Java API 미리 만들어진 수많은 인터페이스를 제공 (설계하지 않아도 사용 가능한 자원)
4. 인터페이스 (~able): 날 수 있는, 수리할 수 있는
5. 객체 간 연결 고리 (객체 간 소통) >> 다형성

** 설계 표준 >> 구현 >> 재정의

interface
1. 실제 구현부를 가지고 있지 않다 >> 실행 블록 X >> 규칙 (약속)
시스템에서 이동하는 것을 move라는 이름을 사용하고 이동 시 좌표값을 받아야 한다
>> 합의 >> void move(int x, int y); { 구현은 알아서 (implement하는 자원이 재정의를 통해서 하도록) }

>> Java API 인터페이스 설계, 구현하는 클래스 생성되어 있음
>> Collection (동적 배열) >> Vector, ArrayList, HashSet, HashMap
이런 클래스는 수많은 인터페이스를 구현하고 있는 클래스

2. 생성 방법
 * 상수(final):	public static final int VERSION = 1;	>> int VERSION = 1;
  				생략하면 컴파일러가 알아서 public static final 붙여서 사용
 * 추상 함수:		public abstract void run();				>> void run();
 				생략하면 컴파일러가 알아서 public abstract 붙여서 사용

interface Aa {
	int VERSION = 1;			public static final int VERSION = 1;
	void run();					public abstract void run();
	String move(int x, int y);	public abstract String move(int x, int y);
}

종류
interface Aable { }					// 아무 자원을 가지지 않아도 된다
interface Aable { int NUM = 10; }	// 상수만
interface Aable { void run(); }		// 추상 함수만

class Test extends Object implements Ia, Ib, Ic {}
class Test implements Ia, Ib, Ic



*/


interface Ia {
	int AGE = 100;				// 상수		public static final int AGE = 100;
	String GENDER = "남성";		//			public static final String GENDER = "남성";
	String print();				// 추상 함수	public abstract String print();
	void message(String str);	// 추상 함수	public abstract void message(String str);
}

interface Ib {
	int AGE = 100;
	void info();
	String val(String s);
}

class Test2 extends Object implements Ia {

	@Override
	public String print() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void message(String str) {
		// TODO Auto-generated method stub
		
	}
	
}

// 인터페이스 implements 하는 순간 미완성 자원을 반드시 구현해야 한다
class Test3 extends Object implements Ia, Ib {	// 다중 구현

	@Override
	public void info() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String val(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String print() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void message(String str) {
		// TODO Auto-generated method stub
		
	}
	
}


public class Ex03_Interface {

	public static void main(String[] args) {
		
		Test2 t2 = new Test2();
		Ia ia = t2;						// 인터페이스는 무조건 부모
										// 부모 타입의 참조 변수는 자식 객체의 주소를 가질 수 있다 (다형성)
		ia.message("재정의");				// 재정의된 자원 (자식 함수) 호출
		System.out.println(ia.GENDER); 	// 값 변경 불가 (final) 사용만 가능
		
		Test3 t3 = new Test3();
		Ia ia2 = t3;					// Test3의 부모 Ia, Ib
		Ib ib2 = t3;
		System.out.println(ia2.AGE);
		System.out.println(ib2.AGE);

	}

}
