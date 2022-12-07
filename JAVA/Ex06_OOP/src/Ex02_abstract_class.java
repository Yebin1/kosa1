/* 0906

���� ���� (unit)
unit ���� ���: �̵� ��ǥ, �̵�, ���� >> �߻�ȭ, �Ϲ�ȭ
unit �̵� ����� �ٸ��� (���ָ��� ������ ������ ���� ����)

abstract class Unit { abstract void move(); }

*/

abstract class Unit {
	int x, y;
	void stop() {
		System.out.println("Unit Stop");
	}
	
	// ���� �ٸ� �̵� ��� ���� ����
	abstract void move(int x, int y);	// ���� ��� X (�߻� �Լ�)	
}

// Tank
class Tank extends Unit {

	@Override
	void move(int x, int y) {
		this.x = x;
		this.y = y;
		System.out.println("Tank �Ҹ����� �̵�: " + this.x + ", " + this.y);	
	}
	
	// �ʿ��ϴٸ� Tank���� ��üȭ, Ư��ȭ�� ���� ����
	void changeMode() {
		System.out.println("��ũ ��� ��ȯ");
	}	
}

class Marine extends Unit {
	@Override
	void move(int x, int y) {
		this.x = x;
		this.y = y;
		System.out.println("Marine �̵�: " + this.x + ", " + this.y);	
	}
	
	// Ư��ȭ, ��üȭ
	void stimPack() {
		System.out.println("������ ���");
	}
}

class DropShip extends Unit {
	@Override
	void move(int x, int y) {
		this.x = x;
		this.y = y;
		System.out.println("DropShip �ϴ÷� �̵�: " + this.x + ", " + this.y);	
	}
	
	void load() {
		System.out.println("Unit load");
	}
	void unload() {
		System.out.println("Unit unload");
	}
}

public class Ex02_abstract_class {

	public static void main(String[] args) {
		
		Tank tank = new Tank();
		tank.move(500, 200);
		tank.stop();
		tank.changeMode();
		
		Marine marine = new Marine();
		marine.move(200, 300);
		marine.stop();
		marine.stimPack();
		
		if (tank instanceof Unit) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
			
		// hint: buy(Product n), Product[] cart
		// 1. tank 3�븦 ����� ���� ��ǥ(600, 800)�� �̵���Ų��
		Tank[] tanklist = {new Tank(), new Tank(), new Tank()};
		for (Tank t: tanklist) {
			t.move(600, 800);
		}
		System.out.println("------------------------");
		// 2. ���� ���� ����(tank 1, marine 1, dropship 1,) ���� �� ���� ��ǥ�� �̵�
		Unit[] unitlist = {new Tank(), new Marine(), new DropShip()};
		// ����: �� ������ ��üȭ, Ư��ȭ�� �ڿ��� ���� �Ұ�
		for (Unit u: unitlist) {
			u.move(100, 200);
		}
				

	}

}
