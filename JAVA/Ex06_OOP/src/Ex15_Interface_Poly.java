// 0906

// �������̽� ����
// ~�� �� �ִ� (������ �� �ִ�)
interface Irepairable {}


class Unit2 {
	int hitpoint;		// �⺻ ������
	final int MAX_HP;	// �ִ� ������
	
	Unit2 (int hp) {	// �ʱ�ȭ�� �����ϹǷ� ����X
		this.MAX_HP = hp;
	}
}

// ���� ����, ���� ����, �ǹ�

// ���� ����
class GroundUnit extends Unit2 {
	GroundUnit(int hp) {
		super(hp);
	}	
}

// ���� ����
class AirUnit extends Unit2 {
	AirUnit(int hp) {
		super(hp);
	}
}

// �ǹ�
class CommandCenter implements Irepairable {}

class Tank2 extends GroundUnit implements Irepairable {
	Tank2() {			// Tank2(int hp)
		super(50);		// super(hp)
		this.hitpoint = this.MAX_HP;
	}
	
	@Override
	public String toString() {
		return "Tank2";
	}
}

class Marine2 extends GroundUnit {
	Marine2() {
		super(50);
		this.hitpoint = this.MAX_HP;
	}
	
	@Override
	public String toString() {
		return "Marine2";
	}
}

// Scv ���� ĳ��, ġ�� ���
class Scv extends GroundUnit implements Irepairable {

	Scv() {
		super(50);
		this.hitpoint = this.MAX_HP;
	}
	
	@Override
	public String toString() {
		return "Scv";
	}
	
	////////////////////////////////////////////
	// Scv ��üȭ, Ư��ȭ�� ���� ���
	// �����ϴ� ��� (repair)
	// Tank2, Scv
	
	// ������ �þ ������ �߰��ؾ� �ϴ� �ڵ�
	// ������ �θ� Ÿ�� buy(Product p)
	
	// �θ�: GroundUnit
	// ����: Marine2�� �θ� GroundUnit
	// Marine2sms repair�� ����� ���� ����
	// void repair(Unit2 unit) 		>> Tank2(o), Marine2(x), Scv(o)
	// void repair(GroundUnit unit) >> Tank2(o), Marine2(x), Scv(o)
	
	// ** CommmandCenter�� repair ����� ���
	// Tank2, Marine2, Scv, CommandCenter ���� �� (������)
	
	// �ƹ� �ڿ� ���� interface�� ����� �θ�� �ش�
	// implements Irepairable
	
	/*
	void repair(Tank2 tank) {
		if (tank.hitpoint != tank.MAX_HP) {
			tank.hitpoint += 5;
		}
	}
	
	void repair(Scv scv) {
		if (scv.hitpoint != scv.MAX_HP) {
			scv.hitpoint += 5;
		}
	}
	*/
	
	// ������ >> �θ� �ڿ��� ���� ����
	// �����ǵ� �ڿ��� ���� ����
	
	// 1. void repair(Irepairable repairunit)	>> Tank2, CommandCenter, Scv
	// Irepairable�� �ڽ� Ÿ�� ... �θ� Ÿ���� �ڽ� Ÿ���� ������ ���� �� �ִ�
	// repair Tank2, Scv >> scv.hitpoint += 5;
	// repair CommandCenter �ٸ� �������
	void repair(Irepairable repairunit) {
		// repairunit ���� Unit2�� �����ϴ� ��?
		
		// Tank2, Scv���̶�� ����	>> �θ� Unit2
		// Unit2 unit = (Unit2) repairunit;	// Unit2�� �ٿ�ĳ����
		// unit.hitpoint += 5;
		//////////////////////////////////////////////////////////////
		// CommandCenter�� Unit2�� ĳ���� �Ұ� (�������� �����Ƿ�)
		
		// repair(Irepairable repairunit) ���
		// �� (Ÿ��) >> instanceof >> Ÿ�� ����
		
		if (repairunit instanceof Unit2) {	// Ÿ�� �� ������ (���� ����) instanceof (Ŭ����)
			// Tank2, Scv
			Unit2 unit = (Unit2) repairunit;
			if (unit.hitpoint != unit.MAX_HP) {
				unit.hitpoint = unit.MAX_HP;
			}
		} else {
			// �ٸ� ��ü
			System.out.println("�ٸ� ����� ���� repair ����");
		}
	}
	
}



public class Ex15_Interface_Poly {

	public static void main(String[] args) {
		
		Tank2 tank = new Tank2();
		Marine2 marine = new Marine2();
		Scv scv = new Scv();
		
		// ����
		tank.hitpoint -= 20;
		System.out.println("Tank: " + tank.hitpoint);
		System.out.println("Scv ���� ��û");
		scv.repair(tank);
		System.out.println("Tank ���� �Ϸ�");
		System.out.println("Tank: " + tank.hitpoint);
		
		System.out.println("--------------------------");
		
		scv.hitpoint -= 30;
		System.out.println("Scv: " + scv.hitpoint);
		System.out.println("Scv ���� ��û");
		scv.repair(scv);
		System.out.println("Scv ���� �Ϸ�");
		System.out.println("Scv: " + scv.hitpoint);
		
		System.out.println("--------------------------");

		CommandCenter center = new CommandCenter();
		scv.repair(center);
	}

}
