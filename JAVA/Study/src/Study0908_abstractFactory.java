

// DoorProduct, TireProduct �߻� Ŭ����
abstract class DoorProduct {
	abstract String makeAssemble();
}

abstract class TireProduct {
	abstract String makeAssemble();
}

// Korea, State ���� �����Ͽ� �����ϴ� CarFactory �߻� Ŭ����
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

// DoorProduct, TireProduct ���� ���丮 Ŭ����
class KoreaDoorProduct extends DoorProduct {
	@Override
	public String makeAssemble() {
		return "���� �����ϴ�.";
	}
}

class KoreaTireProduct extends TireProduct {
	public KoreaTireProduct() {}
	
	@Override
	String makeAssemble() {
		return "���� Ÿ�̾�";
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
		return "�̱��� Ÿ�̾�";
	}
}




public class Study0908_abstractFactory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
