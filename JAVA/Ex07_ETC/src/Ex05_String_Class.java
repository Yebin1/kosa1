
/* 0902

String 클래스 (문자열)
String 수많은 함수	>> 문자열 조작 (자르기, 합치기 ...)
String >> Static 함수 + 일반 함수

*/


public class Ex05_String_Class {
	
	public static void main(String[] args) {
		String str = "";
		String[] strarr = {"aaa", "bbb", "ccc"};
		for (String s: strarr) {
			System.out.println(s);
		}
		// 사용 방법: int, double 값 타입처럼 사용
		
		String st = "홍길동"; 					// 내부적으로 배열로 관리 (char) 한글자씩 저장
		System.out.println(st.length());		// 3
		System.out.println(st);					// 홍길동
		System.out.println(st.toString());		// 홍길동 >> 주소로 가서 데이터를 return 설계 (재정의)
		// String 클래스는 Object 부모 클래스를 상속 받아 Object의 toString()을 재정의 ...
		
		// 정석적인 방법
		String sdata = new String("김유신");		// new 사용
		System.out.println(sdata);				// 김유신
		
		String name = "가나다라마";
		// String 클래스가 내부적으로 char[] 타입의 member field를 가지고 있다
		// char[] member field는 [가] [나] [다] [라] [마] 배열의 주소값을 가진다
		// class String extends Object { private char[] str... @Override toString() ... }
		
		String str1 = "AAA";
		String str2 = "AAA";
		// 문자열의 비교
		System.out.println(str1);
		System.out.println(str2.toString());	// toString() 재정의 >> 주소값 아닌 값 출력
		
		System.out.println(str1 == str2);
		// 연산자 값을 비교 str1(주소값), str2(주소값)
		// 같은 주소임이 판명됨
		// ★ 메모리에 실제로 같은 문자열이 있으면 [재사용]
		
		// POINT
		System.out.println(str1.equals(str2));	// equals: 주소를 찾아가 해당되는 값을 비교
		
		// 문자열의 비교 equals를 사용해야 하는 이유
		String str3 = new String("BBB");		// new: 무조건 새로운 객체 생성
		String str4 = new String("BBB");
		System.out.println(str3 == str4); 		// 주소값 비교이므로 false
		// 문자열은 주소가 아니라 값이 중요
		System.out.println(str3.equals(str4));	// true
		
		// 문자열 누적하면 계속해서 새로 만든다
		String s = "A";
		s += "B";			
		s += "C";
		// A짜리 하나, AB짜리 하나, ABC짜리 하나
		System.out.println(s);
	}

}
