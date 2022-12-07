
/*
클래스는 설계도이다, 클래스는 데이터 타입이다
클래스 == 설계도 == 데이터 타입

클래스는 구체화를 통해 사용
프로그램에서는 [new 연산자]를 통해 memory에 집을 짓는다

클래스의 종류 2가지
1. 독자적으로 실행 가능	>> public static void main(String[] args) {} 내부 클래스
2. 독자적으로 실행 불가능	>> main 함수가 없는 나머지 클래스 >> 남을 도와주는 클래스 >> 라이브러리(LIB)

*/

class Apt2{	// main 함수가 없다
	int door = 10;
	int window = 20;
}

/* class Car{	// The type Car is already defined
				// 같은 폴더 안 자바 파일이 해당 클래스를 가지고 있음
				// Ex02
}
*/

public class Ex05_Ref_Type {
	
	public static void main(String[] args) {
		// Apt2 설계도를 가지고 구체화된 산물 생산 (객체)
		int num;
		num = 100;			// 정수값을 넣어준다
		Apt2 apt2;			// 주소값을
		apt2 = new Apt2();	// Apt2 설계도를 기반으로 아파트 생성 >> JVM >> OS >> memory(heap)
		System.out.println("apt2: " + apt2);	// 주소값
												// apt2: Apt2@1d8d30f7
		
		Apt2 ssapt = apt2;	// 주소값을 할당 ... ssapt 변수는 apt2가 가지고 있는 주소값으로 초기화
		ssapt.door = 100;	// .연산자는 주소를 찾아가는 연산자
		
		System.out.println("apt2 바라보는 door: " + apt2.door);
	}

}
