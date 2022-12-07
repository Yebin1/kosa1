package kr.or.kosa;

public class Coffee {
	
	private String name = "아메리카노";
	private int price = 1500;
	private int shot = 2;

	
	public void shotAdd() {
		if (shot <=4) {
			shot++;
			price += 300;
		} else {
		System.out.println("더 이상 추가할 수 없습니다.");
		}
	}
	
	public void shotRemove() {
		if (shot > 1) {
			shot--;
			if (shot >= 2) {
				price -= 300;
				
			}
		} else {
			System.out.println("더 이상 제외할 수 없습니다.");
		}
	}
	
	public void deCaff() {
		name = "디카페인 아메리카노";
		price += 300;
	}
	
	public void print_Info() {
		System.out.printf("메뉴: %s\n가격: %d원\n", name, price);
	}

}
