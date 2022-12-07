// 0902

package kr.or.kosa;

// 새 (공통 일반, 추상): 새는 날 수 있다, 새는 빠르다

public class Bird {

	public void fly() {
		System.out.println("flying");
	}
	
	// 설계자 고민: Bird를 상속하는 당신은 moveFast 자원에 대해 재정의를 했으면 좋겠어 >> protected 사용 이유
	protected void moveFast() {
		fly();
	}
}
