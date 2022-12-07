/* 0905
시나리오 (요구사항)
가전제품 매장 솔루션 개발 사업팀
A 전자제품 매장이 오픈되면

[클라이언트 요구사항]
모든 가전제품은 제품의 가격, 제품의 포인트 정보를 가지고 있다
각각의 가전제품은 제품별 고유한 이름 정보를 가지고 있다
ex) 각각의 전자제품은 이름을 가지고 있다 (Tv, Audio, Computer)
    각각의 전자제품은 가격을 가지고 있다 (Tv: 5000, Audio: 6000)
    제품의 포인트는 가격의 10%를 적용한다

시뮬레이션 시나리오
구매자: 제품을 구매하기 위해 금액 정보, 포인트 정보를 가지고 있다
ex) 10만원, 포인트 0
구매자는 제품을 구매할 수 있다, 구매 행위를 하게 되면 가지고 있는 돈은 감소하고 포인트는 증가한다
구매자는 초기 금액을 가질 수 있다

공식 오픈
매장에 1000개의 다른 제품이 추가 (마우스, 토스트기 ...) 제품 등록 POS (자동 등록)
매장에 1000개의 제품 전시 (Product 상속하는 제품)
1. 매장에서 3개의 제품만 구매할 수 있는 코드 >> 997개 제품 구매 기능 X
>> 변화에 대응되는 코드 (다형성)
>>> 함수의 parameter를 부모 타입(Product)로


*/

class Product {
	int price;
	int bonuspoint;
	
	Product() {}
	Product(int price) {
		this.price = price;
		this.bonuspoint = (int) (this.price / 10.0);
	}
}

class KtTv extends Product {
	KtTv() {
	super(500);
	}
	
	/* KtTv(int price){
		super(price);
	} */
	
	@Override
	public String toString() {
		return "KtTv";
	}
}

class Audio extends Product {
	Audio() {
	super(100);
	}
		
	@Override
	public String toString() {
		return "Audio";
	}
}

// 구매자
class Buyer {
	int money = 2000;
	int bonuspoint;
	
	/* 제품이 추가될 때마다 함수의 개수가 늘어나는 방식
	// 구매자 구매 행위 (기능: method)
	// 구매 행위 (구매자의 잔액에서 -제품의 가격, +포인트 정보 갱신)
	// 구매자는 매장에 있는 모든 전자제품을 구매할 수 있다 ** 3개 구매 가능
	
	void kttvBuy(KtTv n) {	// 함수의 parameter로 제품 객체의 주소를 받아서...
		if (this.money < n.price) {
			System.out.println("잔액이 부족합니다. " + this.money + "원");
			return;		// Buy 함수 빠져나감
		}
		// 실구매 행위
		this.money -= n.price;
		this.bonuspoint += n.bonuspoint;
		System.out.println("구매 제품은: " + n.toString() + "입니다.");
	}
	
	void audioBuy(Audio n) {	
		if (this.money < n.price) {
			System.out.println("잔액이 부족합니다. " + this.money + "원");
			return;		
		}
		this.money -= n.price;
		this.bonuspoint += n.bonuspoint;
		System.out.println("구매 제품은: " + n.toString() + "입니다.");
	}
	
	void notebookBuy(NoteBook n) {
		if (this.money < n.price) {
			System.out.println("잔액이 부족합니다. " + this.money + "원");
			return;		
		}
		this.money -= n.price;
		this.bonuspoint += n.bonuspoint;
		System.out.println("구매 제품은 " + n.toString() + "입니다.");
	} */
	
	// 1차 개선
	// 하나의 이름으로 여러 가지 기능(method overloading) >> Buy(KtTv n), Buy(Audio n) ... >> buyer.Buy(audio)
	
	// 2차 개선
	// 제품이 추가되더라도 구매 행위 계속되도록
	// 하나의 이름을 사용 >> 중복 코드 >> 제거
	// 모든 제품은 Product를 상속하고 있음 >> 부모 타입의 참조 변수는 자식 객체의 주소를 가진다
	void Buy(Product n) {
		if (this.money < n.price) {
			System.out.println("잔액이 부족합니다. " + this.money + "원");
			return;		
		}
		this.money -= n.price;
		this.bonuspoint += n.bonuspoint;
		System.out.println("구매 제품은 " + n.toString() + "입니다.");
	}
}




class NoteBook extends Product {
	NoteBook() {
	super(150);
	}
		
	@Override
	public String toString() {
		return "NoteBook";
	}
}

public class Ex12_Inherit_keyPoint_Poly {

	public static void main(String[] args) {
		
		// 매장으로 가정하고 제품 전시
		KtTv kt = new KtTv();
		Audio audio = new Audio();
		NoteBook notebook = new NoteBook();
		
		Buyer buyer = new Buyer();
		// buyer.kttvBuy(kt);
		// buyer.notebookBuy(notebook);
		// buyer.audioBuy(audio);
		
		buyer.Buy(notebook);
		buyer.Buy(kt);
		buyer.Buy(audio);
		
		
		
		// System.out.println(kt.price);
		// System.out.println(kt.bonuspoint);
		// System.out.println(kt);
		
		
	}

}
