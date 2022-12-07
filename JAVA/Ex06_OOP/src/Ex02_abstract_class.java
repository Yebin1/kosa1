/* 0906

게임 유닛 (unit)
unit 공통 기능: 이동 좌표, 이동, 멈춤 >> 추상화, 일반화
unit 이동 방법은 다르다 (유닛마다 별도의 구현을 통해 강제)

abstract class Unit { abstract void move(); }

*/

abstract class Unit {
	int x, y;
	void stop() {
		System.out.println("Unit Stop");
	}
	
	// 서로 다른 이동 방법 강제 구현
	abstract void move(int x, int y);	// 실행 블록 X (추상 함수)	
}

// Tank
class Tank extends Unit {

	@Override
	void move(int x, int y) {
		this.x = x;
		this.y = y;
		System.out.println("Tank 소리내며 이동: " + this.x + ", " + this.y);	
	}
	
	// 필요하다면 Tank만의 구체화, 특수화된 내용 구현
	void changeMode() {
		System.out.println("탱크 모드 변환");
	}	
}

class Marine extends Unit {
	@Override
	void move(int x, int y) {
		this.x = x;
		this.y = y;
		System.out.println("Marine 이동: " + this.x + ", " + this.y);	
	}
	
	// 특수화, 구체화
	void stimPack() {
		System.out.println("스팀팩 기능");
	}
}

class DropShip extends Unit {
	@Override
	void move(int x, int y) {
		this.x = x;
		this.y = y;
		System.out.println("DropShip 하늘로 이동: " + this.x + ", " + this.y);	
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
		// 1. tank 3대를 만들고 같은 좌표(600, 800)로 이동시킨다
		Tank[] tanklist = {new Tank(), new Tank(), new Tank()};
		for (Tank t: tanklist) {
			t.move(600, 800);
		}
		System.out.println("------------------------");
		// 2. 여러 개의 유닛(tank 1, marine 1, dropship 1,) 생성 후 같은 좌표로 이동
		Unit[] unitlist = {new Tank(), new Marine(), new DropShip()};
		// 단점: 각 유닛의 구체화, 특수화된 자원에 접근 불가
		for (Unit u: unitlist) {
			u.move(100, 200);
		}
				

	}

}
