package kr.or.onepizza;

public class ShrimpPizza extends Pizza {

	public void prepareTopping() { //
		shrimp -= 8; // 1�Ǵ� 8��
		bacon -= 10; // 1�Ǵ� 10��
		mushroom -= 3; // 1�Ǵ� 3��
		mayoneseSauce--; // 1�Ǵ� 1��
		parsley--; // 1�Ǵ� 1��
	}

	@Override
	public String toString() {
		return "ShrimpPizza baking �Ϸ�";
	}

}