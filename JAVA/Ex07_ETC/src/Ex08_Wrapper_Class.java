import java.util.ArrayList;
import java.util.List;

//0914
// https://cafe.naver.com/kosait/329

/*
자바 8가지 기본 타입(값 타입): JAVA API 제공
8가지 기본 타입에 대해 객체 형태로 사용 가능하도록 만든 클래스(wrapper class)

용도
1. 매개 변수로 객체가 요구될 때
2. 기본형 값이 아닌 객체 형태로 저장이 필요할 때
3. 객체 간 값을 비교할 때
4. 타입 변환시 처리

>> generic 설계 (객체 형태) int > Integer


*/



public class Ex08_Wrapper_Class {

	public static void main(String[] args) {
		
		int i = 100;
		/*
		Integer n = new Integer(500);	// 거의 사용X
		System.out.println(n); 			// 주소가 아닌 값을 return하도록 toString 재정의
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		*/
		
		// Point
		// parameter 활용
		// 제너릭(Generic): 객체 생성시 타입 강제 >> wrapper class
		
		List<Integer> li = new ArrayList<Integer>();
		li.add(100);
		for (int value: li) {
			System.out.println(value);
		}
		
		Integer i2 = new Integer(100);
		Integer i3 = new Integer(100);
		System.out.println(i2 == i3); 		// false (주소값 비교)
		System.out.println(i2.equals(i3));	// true
		// String >> 문자열값 비교 >> equals (재정의)
		
		int i4 = 100;
		int i5 = 100;
		System.out.println(i4 == i5); 		// true		
	}
	
	static void iMethod(Integer i) {
		
	}

}
