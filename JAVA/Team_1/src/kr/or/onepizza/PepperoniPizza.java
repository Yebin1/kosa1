package kr.or.onepizza;

public class PepperoniPizza extends Pizza {

	@Override
	public void prepareTopping() { // ���۷δ� �ø���
		pepperoni -= 20; // 1�� �� 20��
		parsley--; // 1�Ǵ� 1��
	}

	@Override
	public String toString() {
		return "PepperoniPizza baking �Ϸ�";
	}

}