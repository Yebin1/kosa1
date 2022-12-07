/* 0905

다형성 (상속 관계에서 존재)
다형성: 여러 가지 성질(형태)을 가질 수 있는 능력

JAVA: [상속 관계]에서 [하나의 참조 변수]가 [여러 개의 타입을] 가질 수 있다
>> 하나의 참조 변수	: 부모 타입
>> 여러 개의 타입	: 부모를 상속 받은 자식 요소

다형성
* 현실	: 부모가 자식에게 모든 것을...
* 프로그램	: 자식이 부모에게 조건 없이 드림

*/


class Tv2 {					// 부모 (분모, 공통사항 >> 일반화, 추상화)
	boolean power;
	int ch;
	
	void power() {
		this.power =! this.power;
	}
	
	void chUp() {
		this.ch++;
	}
	
	void chDown() {
		this.ch--;
	}
}

class CapTv extends Tv2 {	// CapTv 특수화, 구체화, 고유한 것
	String text;
	String captionText() {
		return this.text = "현재 자막 처리중 ...";
	}
}


public class Ex10_Inherit_Poly {

	public static void main(String[] args) {
		
		CapTv ct = new CapTv();
		ct.power();
		ct.chUp();
		System.out.println(ct.captionText());
		
		Tv2 tv2 = ct;
		// 상속 관계에서 [부모 타입]은 [자식 타입]의 주소를 가질 수 있다
		// 단, 부모는 자신의 자원만 접근 가능하다
		// 재정의는 제외
		System.out.println(ct.toString());		// CapTv@1d8d30f7
		System.out.println(tv2.toString());		// CapTv@1d8d30f7
		
		// tv2.captionText() 자식 자원은 접근 불가
		// 재정의는 제외
		
		
	}

}
