/* 220826
instance variable	>> color	>>	class Car {private String color;}
객체 변수				>> 생성되는 객체마다 다른 색상을 가질 수 있다

local variable		>> speed	>> class Car {public void move() {int speed = 0;} }
지역 변수				>> 접근자X, 반드시 초기화, main 함수

block variable		>> i		>> class Car {public void move() { for (int i; i < 10 ...} }

static variable		>>
					>> 공유 자원 (객체 간), 객체 생성 이전에 memory에 올라가는 자원 (영역: class area, method area)
					
객체를 만드는 유일한 방법: new
static: new 없이도 memory에 올라간다

Ex06_Variable_Scope >> 클래스 >> 구체화 (메모리) >> new 한 적이 없는데
static 우선입장권		>> main 함수 >> memory에 올리자마자 stack으로

*/

class Variable{
	int iv;
	/*
	1. member field (instance variable)
	2. iv의 사용 가능
		* Variable v = new Variable();	>> Heap memory에 객체 생성 >> 객체 내 iv 생성
		* Variable v2 = new Variable();	>> Heap memory에 객체 생성 >> iv가 하나 더 생성
	3. 목적: 데이터(정보, 자료 담기)
		* 고유 정보, 상태 정보, 부품(class) 정보
	>> 생성되는 객체마다 다른 값을 가질 수 있다
	>> 초기화하여 값을 강제하지 않는다
	>> default 값을 가지고 있다
		* int: 0, double: 0.0, char: '\u0000', boolean: false, String: null, Car: null
	>> iv 변수의 생성 시점: new 연산자를 통해 Heap에 Variable 이름의 객체 생성 후 곧바로 생성

	*/
	
	static int cv;
	/*
	1. class variable (클래스 변수), 일반적으로는 static variable (객체 간 공유 자원)
	2. 목적: 정보를 담는 것 (생성되는 모든 객체가 공유하는 자원)
		* 생성되는 모든 객체 (Heap 영역에 생성된 객체들이 공유하는 자원)
	3. 접근 방법:
		* 1) class이름.static변수명				>> Variable.cv
											>> 객체가 생성되기 전에 접근
		* 2) Variable v = new Variable();	>> v.cv
		 	 Variable v2 = new Variable();	>> v2.cv
		 	 >> v.cv == v2.cv (같은 주소를 바라본다: static 변수 주소)
	4. 생성 시점
		* Hello.java > javac Hello.java > Hello.class > java.exe Hello 엔터로 실행
		  > JVM > OS < memory 빌려 정리 (영역 나누기) > class Loader System이 분석
		  > 클래스 정보(metadata: 설명)를 읽어 > class area(|| method area) memory에 올림
		  > 해당 클래스 내 static variable이나 static method가 있다면
		  > 두 static을 class area(|| method area) 영역에 할당
		  > 함수의 이름이 main인 경우 정해진 규칙에 따라 실행 (Stack 영역), 자원 할당
	
	
	*/
	
	void method() {
		int Iv = 0;
		/*
		local variable (함수 안의 지역 변수: 사용 전 반드시 초기화)
		생명 주기: 함수가 호출되면 생성 (stack에 함수 영역을 할당) >> 함수가 종료 혹은 강제 return >> 함께 소멸
			* 함수와 운명 공동체
		*/
		
		for (int i = 0; i <= 10; i++) {
			/*
			int i	>> block variable
					>> for 시작되면 생성
			*/
		}
	}
}

public class Ex06_Variable_Scope {

	public static void main(String[] args) {
		// 어떤 객체도 생성하지 않음
		Variable.cv = 100;
		Ex06_Variable_Scope ex06 = new Ex06_Variable_Scope();
		ex06.method();
		
		Variable b = new Variable();
		System.out.println("v.cv: " + Variable.cv);
	}

	public void method() {
			System.out.println("일반 함수");
		}	

	}


