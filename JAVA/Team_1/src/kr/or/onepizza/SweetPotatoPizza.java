package kr.or.onepizza;

public class SweetPotatoPizza extends Pizza {

	public void prepareTopping() { //
		sweetPotato -= 2; // 1�Ǵ� 2��
		onion--; // 1�Ǵ� 1��
		mustardSauce--; // 1�Ǵ� 1��
		sweetCorn--; // 1�Ǵ� 1��
		parsley--; // 1�Ǵ� 1��
	}

	@Override
	public String toString() {
		return "SweetPotatoPizza baking �Ϸ�";
	}

}