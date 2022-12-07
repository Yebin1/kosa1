// 0906

// 인터페이스 설계
// ~할 수 있는 (수리할 수 있는)
interface Irepairable {}


class Unit2 {
	int hitpoint;		// 기본 에너지
	final int MAX_HP;	// 최대 에너지
	
	Unit2 (int hp) {	// 초기화를 보장하므로 에러X
		this.MAX_HP = hp;
	}
}

// 지상 유닛, 공중 유닛, 건물

// 지상 유닛
class GroundUnit extends Unit2 {
	GroundUnit(int hp) {
		super(hp);
	}	
}

// 공중 유닛
class AirUnit extends Unit2 {
	AirUnit(int hp) {
		super(hp);
	}
}

// 건물
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

// Scv 광물 캐기, 치료 기능
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
	// Scv 구체화, 특수화된 고유 기능
	// 수리하는 기능 (repair)
	// Tank2, Scv
	
	// 유닛이 늘어날 때마다 추가해야 하는 코드
	// 다형성 부모 타입 buy(Product p)
	
	// 부모: GroundUnit
	// 문제: Marine2의 부모도 GroundUnit
	// Marine2sms repair의 대상이 되지 않음
	// void repair(Unit2 unit) 		>> Tank2(o), Marine2(x), Scv(o)
	// void repair(GroundUnit unit) >> Tank2(o), Marine2(x), Scv(o)
	
	// ** CommmandCenter도 repair 대상일 경우
	// Tank2, Marine2, Scv, CommandCenter 연결 고리 (연관성)
	
	// 아무 자원 없는 interface를 만들어 부모로 준다
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
	
	// 다형성 >> 부모 자원만 접근 가능
	// 재정의된 자원은 접근 가능
	
	// 1. void repair(Irepairable repairunit)	>> Tank2, CommandCenter, Scv
	// Irepairable의 자식 타입 ... 부모 타입이 자식 타입의 변수를 가질 수 있다
	// repair Tank2, Scv >> scv.hitpoint += 5;
	// repair CommandCenter 다른 방법으로
	void repair(Irepairable repairunit) {
		// repairunit 통해 Unit2에 접근하는 법?
		
		// Tank2, Scv만이라면 정답	>> 부모 Unit2
		// Unit2 unit = (Unit2) repairunit;	// Unit2로 다운캐스팅
		// unit.hitpoint += 5;
		//////////////////////////////////////////////////////////////
		// CommandCenter는 Unit2로 캐스팅 불가 (연관성이 없으므로)
		
		// repair(Irepairable repairunit) 사용
		// 비교 (타입) >> instanceof >> 타입 질문
		
		if (repairunit instanceof Unit2) {	// 타입 비교 연산자 (참조 변수) instanceof (클래스)
			// Tank2, Scv
			Unit2 unit = (Unit2) repairunit;
			if (unit.hitpoint != unit.MAX_HP) {
				unit.hitpoint = unit.MAX_HP;
			}
		} else {
			// 다른 객체
			System.out.println("다른 방식을 통해 repair 제공");
		}
	}
	
}



public class Ex15_Interface_Poly {

	public static void main(String[] args) {
		
		Tank2 tank = new Tank2();
		Marine2 marine = new Marine2();
		Scv scv = new Scv();
		
		// 전투
		tank.hitpoint -= 20;
		System.out.println("Tank: " + tank.hitpoint);
		System.out.println("Scv 수리 요청");
		scv.repair(tank);
		System.out.println("Tank 수리 완료");
		System.out.println("Tank: " + tank.hitpoint);
		
		System.out.println("--------------------------");
		
		scv.hitpoint -= 30;
		System.out.println("Scv: " + scv.hitpoint);
		System.out.println("Scv 수리 요청");
		scv.repair(scv);
		System.out.println("Scv 수리 완료");
		System.out.println("Scv: " + scv.hitpoint);
		
		System.out.println("--------------------------");

		CommandCenter center = new CommandCenter();
		scv.repair(center);
	}

}
