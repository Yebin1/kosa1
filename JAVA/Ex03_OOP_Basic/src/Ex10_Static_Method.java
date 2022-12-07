// 0826

/*
static member field: 객체 간 공유 자원
static method
1. 객체 생성 없이
2. 많이 사용
3. 설계도를 만들 때 고려 (해당 자원 혹은 기능을 많이 사용한다면)
4. 자원 많이 쓸 때 편하게 사용하도록 >> new 하지 않고도 사용할 수 있게 >> static 함수

*/

class StaticClass {
	
	int iv;			// instance variable
	static int cv;
	
	void m() {
		// 일반 함수
		// new를 통해 Heap 메모리에 올라가야 사용 가능
		// 1. iv값 제어 가능
		// 2. cv값 제어 가능
		cv = 100;
		// static 자원이 객체 생성 이전에 이미 memory에 로드되므로
	}
	
	static void print() {
		// static 함수
		// 1. cv값 제어 가능
		// 2. iv값 제어 불가
		// iv = 1000; >> Cannot make a static reference to the non-static field iv
		// static 자원이 일반 자원보다 우선
		
		// static 함수는 static 자원만 제어할 수 있음
		cv = 10000;
	}
}


public class Ex10_Static_Method {

	public static void main(String[] args) {
		// System.out.println();
		StaticClass.print();
		System.out.println(StaticClass.cv);
		
		StaticClass sc = new StaticClass();
		sc.m();
		sc.print();
	}

}
