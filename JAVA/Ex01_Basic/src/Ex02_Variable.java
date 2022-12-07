// 라인 주석

/* 블록 주석

Ex02_Variable >> 클래스 >> 설계도 >> 데이터 타입

클래스의 종류 
1. class Car{} >> 독자적인 실행이 불가능 >> 다른 클래스(설계도) 에서 참조하는 클래스 >> main 함수(X) >> Lib
2. class Car{public static void main(String[] arg{}} >> 독자적으로 실행 가능
2-1. static void main(String[] args) >> main 이름을 가지는 함수 >> 프로그램 시작점, 진입점 > 실행(약속)

Tip) C#언어 >> public static void Main(String[] args)

변수: variable
데이터(자료)를 담을 수 있는 공간의 이름(메모리)
공간(크기): 데이터 타입(자료형) >> 메모리의 공간이 한정되어 있다 >> 최소한의 공간 최대한의 데이터
데이터 타입 변수명 >> int i = 100

*/



/*
 
public class 클래스 이름{
	public static void main(){
		안에 있는 변수: 지역 변수
		int num = 100; // 초기화를 통해 사용
	}
}

변수가 선언되는 위치 (scope: 유효 범위)
1. instance variable: 객체 변수 >> class Car { int number = 2000; }
2. local variable: 지역 변수 (함수 안에) >> class Car { public void run(){ int speed = 0;} }
3. 함수 안 제어 블록(if, for) 안에 있는 변수 >> class Car { public void run(){ for(int i = 0; ...} } >> 블록 변수
4. static variable: 공유 자원(객체 간) >> class Car { public static num = 100; }

 */

// class는 설계도이다 == class는 Type이다 (여러 개의 의미있는 작은 타입을 가지는 큰 타입): 사용자 정의 타입
// Java는 하나의 물리적인 파일 안에 여러 개의 클래스를 사용할 수 있음 ... (연습용)
// 실개발 시 하나의 파일에 하나의 클래스 사용이 일반적

class Car{ 			// 설계도를 사용하기 위해서는 구체화시켜야 한다 >> 메모리 위에다가 만드는 행위를 통해 (연산자 new)
	int iv = 100; 	// instance variable
	int window; 	// instance variable은 초기화를 하지 않아도 된다
					// 내부적으로 기본값(default: 0)을 가짐 >> int window = 0;
	/*
	초기화: 변수가 처음 값을 갖는 것(할당을 통해서)
	질문: int window 같은 객체 변수는 초기화를 하지 않아도 문제가 생기지 않음 (설계도의 확장성을 고려: 창문 0개~)
	자동차를 만들 때 int window = 4; >> 창문 4개
	
	Car라는 설계도를 가지고 차량 생산 가능
	Car 쌍용차 = new Car();	자동차를 만드는 행위 >> 창문 0개
	쌍용차.window = 10; 
	
	Car 삼성차 = new Car();
	삼성차.window = 2;
	
	생산되는 자동차마다 창문의 개수를 달리할 수 있다
	*/
	
	public void stop() {	// 경기도
		// 별도의 지역
		window = 100;
		// speed = 200; 선언 시 문제점을 파악할 수 있다... 알아야 할 것...
	}
	public void start() {	// 강원도
		int speed = 100;	// 지역 변수(도의원)
	}
	
}

public class Ex02_Variable {

	public static void main(String[] args) {
		// 시작점
		// main 함수 안에 코드가 있어야 실행된 결과를 볼 수 있음
		int lv = 100;
		System.out.println("lv 지역 변수: " + lv);
	
		int number = 0;	// 선언과 동시에 초기화
		number = 100;	// 초기화 아님
		number = 200;	// 초기화 아님
		System.out.println("number: " + number);
		
		int a; // 선언만
		int b;
		// System.out.println(a); 
		// The local variable a may not have been initialized
		// main() {함수 안에 있는 변수를 지역 변수라고 하는데, 초기화하지 않으면 사용할 수 없음}
		
		b = 200; // 최초로 값을 할당했으므로 초기화에 해당
		System.out.println("b 변수 초기화: " + b);
		
		int c, d; // 선호X >> 개발자 >> Array(배열) >> int[] i...
		
		// key point 
		// local variable (함수 안에 있는 변수: main(){ 안에 있는 변수 })
		// 반드시 초기화가 필요함
		int k = 100; // 지역 변수는 선언과 동시에 초기화를 하고 사용하는 습관
		
		Car scar = new Car(); 	// scar라는 자동차를 생산 (현실 아파트를 지은 것)
								// Java가 OS에게 할당받은 [메모리 영역]에 만들어짐
	
		////////////////////////////////////////////////////////////////////
		// int k = 500; 같은 지역 내 같은 변수명이 존재할 수 없음
		
		int f = 100;	// f라는 변수는 100이라는 값을 갖고 있음
		int f2 = f;		// 할당
		System.out.println("f: " + f);
		System.out.println("f2: " + f2);
		// f변수의 값을 2000으로 변경 시 f2의 값은 영향을 받지 않음
		
		
	}

}