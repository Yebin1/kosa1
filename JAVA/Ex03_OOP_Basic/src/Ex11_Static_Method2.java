//0829
public class Ex11_Static_Method2 {

	public void method() {	// 일반 자원 heap에 로드 후 사용 가능 >> new
		System.out.println("나 일반 함수");
	}
	
	public static void smethod() {
		System.out.println("나 static 함수");
	}
	
	public static void main(String[] args) {

		// 안에서 smethod 사용
		// Ex11_Static_Method.smethod();
		// smethod는 Ex11의 자원이므로 위처럼 호출할 필요X
		smethod();
		
		Ex11_Static_Method2 ex11 = new Ex11_Static_Method2();
		// ex11 참조 변수(주소를 가지는 변수)는 static 자원, 일반 자원에 접근 가능
		ex11.method();
		
	}

}
