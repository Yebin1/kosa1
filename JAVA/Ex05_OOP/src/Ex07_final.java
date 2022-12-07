/* 0901

변수 <-> 상수
상수: 한번 값이 [초기화]되면 변경 불가
상수 자원: 고유값 (주민번호), PI (3.141592...), 시스템 번호 (버전 번호)
상수는 관용적으로 [대문자]

java: final int NUM = 10;
c#	: const integer NUM = 10;

final 키워드
1. final class Car {} >> 클래스 final	>> 상속 금지
	* public final class Math extends Object
2. public final void print() {}		>> 함수 앞에 final	 >> 상속 관계에서 재정의(Override) 금지


*/


class Vcard {
	final String KIND = "heart";
	final int NUM = 10;
	
	void method() {
		System.out.println(Math.PI);
	}
}

class Vcard2 {			// 만드는 카드마다 다른 상수값을 가지도록 하겠다
	final String KIND;
	final int NUM;
	
	// Vcard2 (){} >> 초기화 되지 않았음!
	/*
	Vcard2 (){
		this("", 1);
	}
	*/
	
	Vcard2(String kind, int num){
		this.KIND = kind;
		this.NUM = num;
	}

	@Override
	public String toString() {
		return "Vcard2 [KIND: " + KIND + ", NUM: " + NUM + "]";
	}
	
}

public class Ex07_final {

	public static void main(String[] args) {

		/*
		Vcard vc = new Vcard();
		// vc.KIND = "aaa"; >> The final field Vcard.KIND cannot be assigned
		System.out.println(vc.KIND);
		vc.method();
		*/
		
		Vcard2 v1 = new Vcard2("spade", 1);
		System.out.println(v1.toString());
		Vcard2 v2 = new Vcard2("spade", 2);
		System.out.println(v2.toString());
		Vcard2 v3 = new Vcard2("heart", 3);
		System.out.println(v3.toString());

	}

}
