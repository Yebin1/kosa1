


class Car {
	boolean license;				// 면허를 가진다
	void Drive() {					// 운전을 한다
		System.out.println("운전");
	}

}

class Bus extends Car {				// 버스
	int number;						// 번호(노선)을 가진다
	int people;						// 10명 이상의 인원
}

class Taxi extends Car {			// 택시
	double meter;					// 미터기
}

class Truck extends Car {			// 트럭
	String purpose;					// 용도를 가진다
}

class Lorry extends Truck {
	int wheel;
}


public class Study0905 {
	
	public static void main(String[] args) {
		
		Bus bus = new Bus();
		bus.Drive();
		bus.license = true;
		System.out.println(bus.license);
		
		Lorry lorry = new Lorry();
		lorry.wheel = 8;
		lorry.license = false;		// Car의 member field
		lorry.purpose = "식품";		// Truck의 member field
		System.out.println(lorry.wheel);
		System.out.println(lorry.license);
		System.out.println(lorry.purpose);
	}
}


