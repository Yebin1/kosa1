// 0901

// 두 개의 설계도
class Tv {
	boolean power;
	int ch;
	
	void power() {		// 두 개의 기능을 하나의 함수로 처리 (켜기, 끄기)
		this.power =! this.power;
	}
	
	void chUp() {		// 채널 올리기
		this.ch++;
	}
	
	void chDown() {		// 채널 내리기
		this.ch--;
	}
}

class Vcr {				// 비디오 플레이어
	boolean power;
	void power() {
		this.power =! this.power;
	}
	
	void play() {
		System.out.println("재생하기");
	}
	
	void stop() {
		System.out.println("정지하기");
	}
	
	void rew() {}		// 리와인드
	void ff() {}		// 빨리감기
}

// Tv 설계도, Vcr 설계도
// TvVcr란 제품
// class TvVcr extends Tv, Vcr >> 다중 상속 X
// 계층적 상속 이상 (자원 이름 동일 >> 하나 사용 불가)
// 하나 상속, 하나 포함 >> 일반적인 해결 방법
// Tv(상속), Vcr(포함)
// 기준: 비중 높은 클래스 (주기능)

class TvVcr2 extends Tv {
	Vcr vcr;
	
	public TvVcr2() {
		vcr = new Vcr();
	}
}





class TvVcr {
	Tv t;
	Vcr v;
	
	public TvVcr() {
		this.t = new Tv();
		this.v = new Vcr();
	}
}


public class Ex03_Inherit {

	public static void main(String[] args) {
		TvVcr tv = new TvVcr();
		tv.t.power();
		tv.v.power();
		
		System.out.println(tv.t.power);
		
		TvVcr2 tv2 = new TvVcr2();
		tv2.power();
		System.out.println("Tv 전원: " + tv2.power);
		tv2.chUp();
		tv2.vcr.power();
		System.out.println("비디오 전원: " + tv2.vcr.power);
		tv2.vcr.play();
	}

}
