


// 아파트 설계도
class Apt{	// 설계도 == 데이터 타입 (작은 타입을 모아 넣은 큰 타입)
	int window;
}

// 데이터 타입 + 변수명 ex) int number; >> number라는 변수는 타입에 맞는 값을 가진다
// Apt apt;

public class Ex03_Object_Variable {

	public static void main(String[] args) {
				
		int number = 100;
		Apt apt;	// 선언 Apt 타입 apt 변수
					// apt 변수는 Apt 타입의 값을 가져야 하는데 >> 주소값
					// 실제로 아파트를 메모리에 올려야 아파트가 생성되고, 해당 주소가 만들어짐
					// 아파트를 짓는 유일한 방법: new (연산자)
		/*Apt*/ apt = new Apt();	// heap 메모리에 아파트가 한 채 만들어지고, 주소가 생성
									// 생성된 주소값을 apt 변수가 가진다
		
		System.out.println("apt 변수가 가지는 값은: " + apt);
		// apt 변수가 가지는 값은: kr.or.kosa.Apt@6f2b958e	: 사실 조작된 값
		// Apt + @ + 6f2b958e >> 설계도의 이름 + @ + 주소값
		// . (주소를 찾아가는 연산자) ex) apt2.window = 4;
		
		Apt apt2 = new Apt();
		// System.out.println("apt2 변수가 가지는 값은: " + apt2);
		System.out.println(apt == apt2);	// 두 변수의 주소가 같은지 >> false
		
		Apt apt3 = apt2;	// 주소값을 할당
		System.out.println(apt3 == apt2);	// 두 변수의 주소가 같은지 >> true
		
		apt2.window = 20;
		System.out.println("apt3 창문의 수: " + apt3.window);
		// 값 타입과 주소 타입 증명하기
		/*
			*
			Ex03_Object_Variable 소스 파일
			javac Ex03_Object_Variable >> Ex03_Object_Variable.class 실행 파일
			java Ex03_Object_Variable + 엔터
			JVM 동작 >> OS >> Java 메모리 구성 (구획 정리) >> 자원 할당 (메모리) >> 프로그램 종료 >> 사용했던 메모리를 OS에게 반환 ... end
			*
		이클립스 통합 개발 툴 >> Ctrl+f11
		
		1. main 함수 안 지역 변수는 반드시 초기화 후 사용
		2. 약속 >> main 함수 >> 시작점 >> 영역이 제일 먼저 실행
		
		*/
	}

}
