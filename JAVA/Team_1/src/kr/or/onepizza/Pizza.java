package kr.or.onepizza;

abstract public class Pizza extends OwnerSystem {
	OrderSystem odersystem = new OrderSystem();

	// ���� ����� �Լ�
	public void createPizza(String pizzaName) {
		prepareDough(); // �����غ�
		prepareCheese(); // ġ��ø���
		prepareTopping(); // ���οø���
		prepareSauce(); // �ҽ��Ѹ���
		packaging(); // ���忩�ο� ���� �����ϱ�
	}

	private void prepareDough() {
		dough--;
	}

	// ���ڸ��� ���� ������
	abstract public void prepareTopping();

	private void packaging() {
		if (odersystem.getTakeOut() == 2) {
			box--;
		}
	}

	private void prepareCheese() {
		cheese--;
	}

	private void prepareSauce() {
		tomatoSauce--;
	}

}