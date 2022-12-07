package kr.or.kosa;
//220826

// ��Ģ������ (�ǹ�)
// 1. ĸ��ȭ (member field)
// 2. ĸ��ȭ (���������� ó��: setter, getter �Լ�)
// 3. �̷� �����͸� ���� �� �ִ� Ŭ���� (VO, DTO, DOMAIN) (Value Object, Data Transfer Object)
//								>> MVC ����

public class Car {
	private int window;	// instance variable member field
	private int speed;
	
	// �ʿ信 ���� 
	// setter�� ����� ���
	// getter�� ����� ���
	// setter, getter ����� ��� >> write, read
	
	public int getWindow() {	// getter �Լ�
		return window;
	}
	
	public void setWindow(int data) {	// setWindow(int window) {this.}
		window = data;			// setter �Լ�	
	}

	// 1. IDE ���
	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	// Lombok�̶�
	// java ���̺귯���� �ݺ��Ǵ� getter, setter, toString ��
	// �ݺ� �޼ҵ� �ۼ� �ڵ带 �ٿ��ִ� �ڵ� ���̾�Ʈ ���̺귯��
	// @Getter
	// @Setter
	// �����Ϸ����� �ڵ����� setter, getter ���鵵��
	
	
	// �ʿ��ϴٸ� ������ �Լ��� ����
	// speed�� 10�� �����ϴ� ���
	// �Ϲ������� �Ʒ��� ���� ������ �Լ��� ����⺸�� (read, write�� �� ���) setter, getter�� ���� ����
	public void speedUP() {
		speed += 10;
	}
	public void speedDown() {
		if (speed > 0) {
		speed -= 10;
		}else {
			speed = 0;
		}
	}
	/////////////////////////////
	

}
