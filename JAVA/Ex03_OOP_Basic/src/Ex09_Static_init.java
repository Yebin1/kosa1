// 0826

// static	변수: 객체마다 같은 값을 가지게 할 목적으로 설계
// instance	변수: 객체마다 다른 값을 가지게 할 목적으로 설계

// 두 변수에 대해 초기화하는 방법

class InitTest{
	static int cv = 10;
	static int cv2;
	int iv = 9;
	// default값을 가지므로 초기화하지 않아도 문제X
	
	
	static {
		// static 자원 초기화 블록
		// static int cv = 10;, static int cv2;가 메모리(class area)에 올라간 후 바로 호출
		cv = 1111;
		cv2 = cv + 2222;
		// System.out.println(cv2);
	}
	
	
	
	{
		// 초기화 블록 (member field 해당 블록에서 초기화)
		// 객체 생성되고 후 (int iv가 메모리에 올라간 후) 바로 호출 { 블럭 }
		// 인위적인 코드
		System.out.println("초기화 블록");
		// iv = 2222;
		if (iv > 10) iv = 1000;
		
		cv = 100;	// static: 객체가 생성되기도 전에 메모리에 올라가 있으므로 접근 가능
					// 초기화X
					// 객체를 new 하지않으면 static 초기화 실행X
					// static {} 초기화 블록
	}
}





public class Ex09_Static_init {

	public static void main(String[] args) {
		// InitTest t = new InitTest();
		// System.out.println(t.iv);
		
		System.out.println(InitTest.cv);
		System.out.println(InitTest.cv2);

	}

}
