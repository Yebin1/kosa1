// 0829

/*
생성자 함수 (Constructor)
1. 함수 (특수한 목적)
2. 목적 (member field 초기화) >> static {}, { 초기자 블록 }
3. 일반 함수와 다른 점
	* 함수의 이름이 고정 (class 이름과 동일)
	* return type 없음 (객체 생성과 동시에 호출, return 받을 대상이 없음)
	* 실행 시점: new를 통해 객체 생성 >> heap에 공간 생성 >> member field 올라감 >> 자동으로 생성자 함수 호출
4. return type(x): void >> public (void) class명 (어차피 return하지 않으므로 생략) >> public class명(){}

★★ 생성되는 객체마다 강제적으로 member field값을 초기화할 수 있다

class Car {String color;} 설계도 제작 ... 자동차 색상은 만들 때 알아서
	* A: 무조건 파란색 차 >> 처음부터 파란색으로 설계해주세요
		>> class Car { String color = "blue" }
	* B: 알아서 설정 ※※ 색상을 설정하지 않은 경우: null
		>> class Car { String color; }
		Car car = new Car();
		car.color = "gold";
		
>> 차량 제작시 무조건 색상을 입력하도록 할 수 있는 방법
>> 함수, { 초기자 블록 } >> 강제성이 없거나 입력값을 넣을 수 없음

5. 생성자 함수 (overloading 기법 적용 가능)
6. 생성자 overloading을 통해 다양한 강제 사항을 구현 ★★★

생성자를 사용하는 가장 중요한 목적은 강제적 초기화 (member field)

*/

class Car4 {
	String carname;
	// public Car4(){} 생성자가 생략
}

class Car2 {		// 강제 구현
	String carname;	// default: null
	public Car2() {	// default constructor를 통해 초기화
		carname = "포니";
	}	
}

class Car3 {		// 구현, 생성자 오버로딩
					// 기본 이름으로 생산 OK, 이름 넣어 생산 OK
	String carname;
	public Car3() {
		carname = "기본 이름";
	}
	// overloading을 통해
	public Car3 (String name) {	// Today Point
		carname = name;
	}
}

class Car {
	String carname = "포니";
	// 만약 Car 설계도를 만들 때 코드를 쓰지 않는다면 컴파일러가 알아서 생성자 함수를 생성한다
	// public Car() {} >> 컴파일러가 자동 생성
	
	// 개발자가 직접 구현한다면
	public Car() {
		System.out.println("기본 생성자 호출");
		carname = "내 마음";
	}
}


// 조건: 자동차의 이름은 무조건 자동차가 만들어질 때 정하도록 강제할 것
// public Car5(){} 구현되지 않았음
// 예외적으로 개발자가 overloading된 생성자를 하나라도 만든다면 컴파일러는 default constructor를 자동 생성하지 않는다
// 컴파일러가 설계자의 강제 의도를 파악한 것
// default 생성자 사용: 필요하면 이름 넣고 없으면 하지마 (강제성X)
class Car5 {
	String carname;
	public Car5 (String name) {
		carname = name;
	}
}


public class Ex15_Constructor {

	public static void main(String[] args) {
		Car car = new Car();	// Car() 괄호: 함수의 괄호	>> default constructor
		System.out.println(car.carname);
		
		Car3 car3 = new Car3();
		System.out.println(car3.carname);
		
		Car3 car31 = new Car3("mycar");
		System.out.println(car31.carname);
		
	}

}


