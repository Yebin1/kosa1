package kr.or.kosa;

public class Coffee {
	
	private String name = "�Ƹ޸�ī��";
	private int price = 1500;
	private int shot = 2;

	
	public void shotAdd() {
		if (shot <=4) {
			shot++;
			price += 300;
		} else {
		System.out.println("�� �̻� �߰��� �� �����ϴ�.");
		}
	}
	
	public void shotRemove() {
		if (shot > 1) {
			shot--;
			if (shot >= 2) {
				price -= 300;
				
			}
		} else {
			System.out.println("�� �̻� ������ �� �����ϴ�.");
		}
	}
	
	public void deCaff() {
		name = "��ī���� �Ƹ޸�ī��";
		price += 300;
	}
	
	public void print_Info() {
		System.out.printf("�޴�: %s\n����: %d��\n", name, price);
	}

}
