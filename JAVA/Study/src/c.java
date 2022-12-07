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
	
	Product(int price) {
		this.price = price;
		this.bonuspoint = (int) (this.price / 10.0);
	}
}

class Tv extends Product {
	Tv() {
		super(500);
	}
	@Override
	public String toString() {
		return "Tv";
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

class NoteBook extends Product {
	NoteBook() {
		super(200);
	}
	@Override
	public String toString() {
		return "NoteBook";
	}
}

class Buyer {
	int money = 1500;
	int bonuspoint;
	
	void Buy(Product n) {
		if(this.money <= n.price) {
			System.out.println("잔액이 부족합니다. " + this.money);
			return;
		}
		
		money -= n.price;
		bonuspoint += n.bonuspoint;
		System.out.println("구매 물건: " + n.toString());
	}
}




public class c {
	
	public static void main(String[] args) {
		
		Tv tv = new Tv();
		Audio audio = new Audio();
		NoteBook notebook = new NoteBook();
		
		Buyer buyer = new Buyer();
		
		buyer.Buy(tv);
		buyer.Buy(tv);
		buyer.Buy(audio);
		buyer.Buy(notebook);
		buyer.Buy(notebook);
		
	}
}