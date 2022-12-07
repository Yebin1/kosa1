import kr.or.kosa.Car;

public class Ex05_Modifier {

	public static void main(String[] args) {
		Car car = new Car();
		int speed = car.getSpeed();
		System.out.println("speed: " + speed);
		
		car.speedUP();
		car.speedUP();
		speed = car.getSpeed();
		System.out.println("speed: " + speed);
		
		car.speedDown();
		car.speedDown();
		car.speedDown();
		speed = car.getSpeed();

		System.out.println("speed: " + speed);

	}

}
