package kr.or.kosa;

/*
기능	(행위) 만드는 법
함수 (method)

method: 행위 또는 기능의 최소 단위로 구현 >> 하나의 함수로 하나의 기능만 구현
ex) 먹는다, 잔다, 걷는다...

클래스: field + method
ex) 롯데월드 : 게임방 : 농구, 동전, 동전 뽑기

method 함수는 호출에 의해서만 동작한다
누군가 이름을 부르지 않으면 동작하지 않는다

JAVA
1. void, parameter(0): void print(String str) { 실행 코드 }		>> () 동전 들어가는 구멍
2. void, parameter(x): void print(){ 실행 코드 }					>> 공짜
3. return type, parameter(0): int print(int data) {return 100;}
4. return type, parameter(x): int print() {return 100;}	

*** void >> 반환X >> return type이 없다
return type >> 기분 8가지 + String + Array, class, collection, interface
기본 8가지 + String + class ...

boolean print(return type)
Car print()
Car print() {Car c = new Car(); return c;} // 나는 당신에게 Car라고 하는 객체의 주소를 반환
String print() {return "A"}

parameter type >> void print(String 파라메터)
기본 8까지 + String + Array, class, collection, interface

void print(int i) {}
void print(String str) {}
void print(Car car)			// print 함수는 parameter로 Car 타입의 주소값을 받는다

ex)
Car c = new Car();
void print(Car car) {}
print(c);					// print 함수 호출시 c라는 변수값

void print(int a, int b, int c, int d) {}	// 원칙적으로 동전 4개 전부 넣어야 실행
print(10, 20)			// 동전 2개 넣어서 실행X
print(10, 20, 30, 40,)	// 4개 넣어 실행

void print(Car c, String str, int i) {}		// 주소값, 문자열, 정수 다양하게 넣는다

관용적인 표현
코드 규칙: 관용적
class 이름의 첫 글자는 대문자: class Car, class Person
method의 이름은 소문자, 대문자 순서: getNumber()

사원 번호를 가지고 사원의 모든 정보를 가지고 올 것 (함수 생성)
getEmpListByEmpno()		// 함수를 통해 유추할 수 있을 정도로 쓸 것

*/

public class Fclass {	// 설계도. 메모리에 올려야 동작
	public int data;
	
	// void m() >> 컴파일러가 >> default void m() >> 같은 폴더 내에서
	// 함수 70% public
	// 함수 30% private >> public, private 클래스 내부 동등
	// 클래스 내부에서만 사용해라 >> 공통 함수 >> 다른 함수를 도와주는 목적
	
	public void m() {	// void, parameter(x)
		// 기능 구현
		// main 함수에서 사용했던 코드 작성
		System.out.println("일반 함수: void, parameter(x)");
	}
	
	// void m2(int)
	public void m2(int i) {
		System.out.println("일반 함수: void, parameter(o)");
		System.out.println("parameter 값은 활용, i변수 함수 내부: "+ i);
	}
	
	//return type m3(x)
	public int m3() {
						// 무조건 return 사용
						// 뒤에 int와 같은 타입의 값을 넣는다
		return 1000;	// return type이 존재하면 반드시 return 키워드 필수
		
	}
	
	public int m4(int data) {
		return 100 + data;
	}
	
	// 여기까지가 기본 4가지 유형
	///////////////////////////////////////////////////////////////////
	
	// 확장
	// return type(0), parameter(0) 개수 차이
	public int sum(int i, int j, int k) {
		return i + j + k;
	}
	
	
	// 함수의 접근자
	// default int subSum(){}	>> 같은 폴더
	// private int subSum(){}	>> 같은 폴더조차 X
	// 클래스 내부에서 다른 함수를 도와주는 공통 함수
	// private 함수 만들어 사용
	
	private int subSum(int i) {	// 다른 함수가 호출해서 사용
		return i + 100;			// 로직을 모든 함수가 가지고 있다면 유지보수
	}
	public void callSubSum() {
		// 함수가 다른 함수를 호출 가능
		int result = subSum(100);
		// result == local variable
		System.out.println("call result: " + result);
	}
	
	
	private int operationMethod(int data) {
		return data * 200;
	}
	public int opSum(int data) {
		int result = operationMethod(data);
		// 제어문
		if (result > 0) {
			return 1;
		} else {
			return -1;
		}
	}
	
	
	//Quiz
	//a와 b 둘 중 큰 값을 return하는 함수 작성	
	private int maxMethod(int a, int b) {
		return data;
	}
	public int maxNum(int a, int b) {
		int result = maxMethod(a, b);
		return (a > b) ? a : ((a == b) ? 0 : b);
		
	}
	
	///////////////////////////////////////////////////

	
	
	
	
	

}
