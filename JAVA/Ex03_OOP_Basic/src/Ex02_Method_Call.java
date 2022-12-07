import kr.or.kosa.Fclass;

public class Ex02_Method_Call {
	public static void main(String[] args) {
		// Fclass를 생성 (객체 생성)
		Fclass fclass = new Fclass();
		fclass.m();		// 호출 (call)
		fclass.m2(100);	// i값 지정
		
		int result = fclass.m3();
		System.out.println("m3 함수 호출시 반환값: " + result);
		
		int result2 = fclass.m4(555);
		System.out.println("m4 함수 호출시 반환값: " + result2);
		
		result2 = fclass.sum(100, 200, 300);
		System.out.println("sum 함수 호출시 반환값: " + result2);
		
		fclass.callSubSum();
		
		result2 = fclass.opSum(1111);
		System.out.println("opSum 함수 호출시 반환값: " + result2);
		
		
		// Quiz
		// a와 b 둘 중 큰 값을 return하는 함수 작성
		result = fclass.maxNum(10, 5);
		System.out.println("maxNum 함수 호출시 반환값: " + result);
		
	}
}
