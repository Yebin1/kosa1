/* 0829
OOP 객체 지향 프로그래밍 (여러 개의 조각(설계도)을 만들어 조합하는 행위)
>> 여러 개의 설계도를 재사용하는 방법

1. 상속 (재사용성)
2. 캡슐화 (은닉화): private	// setter, getter (직접 할당을 막고 간접 할당을 통해 데이터 보호)
3. 다형성: 하나의 타입으로 여러 객체의 주소를 가질 수 있는 것

>> method overloading (오버로딩): 하나의 이름으로 여러 기능을 하는 함수
	* System.out.println() >> println() 함수 이름은 하나, 사용법은 여러 개
1. 오버로딩은 성능 향상과 무관하다
2. 개발자가 편하게 사용하기 위해
3. 오버로딩을 사용하지 않아도 문제되지 않는다

Overloading 문법
1. 함수 이름은 동일해야 한다
2. parameter 개수 또는 타입이 달라야 한다
3. return type은 오버로딩의 판단 기준이 아니다
4. parameter의 순서가 다름을 인정해야 한다 ★주의!
*/


class Human{
	String name;
	int age;
}

class OverTest {					// 클래스 설계
	int add(int i) {
		return 100 + i;
	}
	// int add(int s) >> 이름 충돌
	
	int add(int i, int j) {			// parameter 개수 다름 >> overloading
		System.out.println("오버로딩 : " + i + "," + j);
		return i + j;
	}
	
	String add(String s) {
		System.out.println("오버로딩: " + s);
		return "hello" + s;
	}
	
	String add(String s, int i) {
		return "오버로딩";
	}
	
	String add(int i, String s) {	// int, String 순서 다름 인정
		return "";
	}
	
	void add(Human human) {			// 오버로딩		
		human.name = "홍길동";
		human.age = 100;
		System.out.println(human.name + "," + human.age);
	}
}


public class Ex13_Method_Overloading {

	public static void main(String[] args) {
		// Overloading
		System.out.println();
		System.out.println("A");	// 자동으로 parameter String 호출
		System.out.println('a');	// 자동으로 parameter char 호출
		
		// System 설계도
		// System sys = new System();
		
		OverTest ot = new OverTest();
		int result = ot.add(100);
		System.out.println(result);
		result = ot.add(200, 300);
		System.out.println(result);
		
		
	}

}
