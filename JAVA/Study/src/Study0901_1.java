

class Recipe {
	
	private String bean;	// 원두 카페인, 디카페인
	private String contain;	// 물, 우유
	private String syrup;	// 시럽 여부
	
	public String menu;
	private int price = 0;
	
	Recipe(String bean){
		this(bean, "X", "X");
		pricePrint(bean, "", "");
		menuPrint(bean, "", "");
	}
	Recipe(String bean, String contain){
		this(bean, contain, "X");
		pricePrint(bean, contain, "");
		menuPrint(bean, contain, "");
	}
	Recipe(String bean, String contain, String syrup){
		this.bean = bean;
		this.contain = contain;
		this.syrup = syrup;
		pricePrint(bean, contain, syrup);
		menuPrint(bean, contain, syrup);
	}
	
	void pricePrint(String bean, String contain, String syrup) {
		price = 2700;
		if (bean.equals("decaffeine")) { price += 300; }
		if (contain.equals("water")) { price += 500; } 
		if (contain.equals("milk")) { price += 1000; }
		if (syrup.equals("vanilla") || syrup.equals("chocolate")) { price += 200;}
	}
	
	void menuPrint(String bean, String contain, String syrup) {
		if (bean.equals("espresso")) { menu = "에스프레소"; }
		if (bean.equals("espresso") && contain.equals("water")) { menu = "아메리카노"; }
		if (bean.equals("espresso") && contain.equals("milk")) { menu = "카페라떼";}
		if (bean.equals("espresso") && contain.equals("milk") && syrup.equals("vanilla")) { menu = "바닐라라떼";}
		if (bean.equals("espresso") && contain.equals("milk") && syrup.equals("chocolate")) { menu = "카페모카";}
		
		if (bean.equals("decaffeine")) { menu = "디카페인 에스프레소"; }
		if (bean.equals("decaffeine") && contain.equals("water")) { menu = "디카페인 아메리카노"; }
		if (bean.equals("decaffeine") && contain.equals("milk")) { menu = "디카페인 카페라떼";}
		if (bean.equals("decaffeine") && contain.equals("milk") && syrup.equals("vanilla")) { menu = "디카페인 바닐라라떼";}
		if (bean.equals("decaffeine") && contain.equals("milk") && syrup.equals("chocolate")) { menu = "디카페인 카페모카";}
	}
	
	void print_Info() {
		System.out.printf("주문한 음료: %s\n가격: %d\n**********************\n", menu, price);
	}
	
}

public class Study0901_1 {
	
	public static void main(String[] args) {
		
		Recipe coffee = new Recipe("decaffeine", "milk");
		coffee.print_Info();
		Recipe coffee2 = new Recipe("espresso", "water");
		coffee2.print_Info();
		Recipe coffee3 = new Recipe("decaffeine", "milk", "vanilla");
		coffee3.print_Info();
		Recipe coffee4 = new Recipe("espresso", "milk", "chocolate");
		coffee4.print_Info();
		Recipe coffee5 = new Recipe("espresso");
		coffee5.print_Info();
		Recipe coffee6 = new Recipe("decaffeine");
		coffee6.print_Info();
	}


}
