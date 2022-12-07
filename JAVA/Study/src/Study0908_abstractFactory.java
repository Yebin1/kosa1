

// DoorProduct, TireProduct 추상 클래스
abstract class DoorProduct {
	abstract String makeAssemble();
}

abstract class TireProduct {
	abstract String makeAssemble();
}

// Korea, State 차를 조립하여 생성하는 CarFactory 추상 클래스
abstract class CarFactory {
	public abstract TireProduct createTire();
	public abstract DoorProduct createDoor();
}

class KoreaCarFactory extends CarFactory {
	public KoreaCarFactory() {}
	
	@Override
	public TireProduct createTire() {
		return new KoreaTireProduct();
	}
	
	@Override
	public DoorProduct createDoor() {
		return new KoreaDoorProduct();
	}
}

class StateCarFactory extends CarFactory {
	public StateCarFactory() {}
	
	@Override
	public TireProduct createTire() {
		return new StateTireProduct();
	}
	
	@Override
	public DoorProduct createDoor() {
		return new StateDoorProduct();
	}
}

// DoorProduct, TireProduct 구현 팩토리 클래스
class KoreaDoorProduct extends DoorProduct {
	@Override
	public String makeAssemble() {
		return "문이 열립니다.";
	}
}

class KoreaTireProduct extends TireProduct {
	public KoreaTireProduct() {}
	
	@Override
	String makeAssemble() {
		return "국산 타이어";
	}
}

class StateDoorProduct extends DoorProduct {
	@Override
	public String makeAssemble() {
		return "Door is open";
	}
}

class StateTireProduct extends TireProduct {
	public StateTireProduct() {}
	
	@Override
	public String makeAssemble() {
		return "미국산 타이어";
	}
}




public class Study0908_abstractFactory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
