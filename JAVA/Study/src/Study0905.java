


class Car {
	boolean license;				// ���㸦 ������
	void Drive() {					// ������ �Ѵ�
		System.out.println("����");
	}

}

class Bus extends Car {				// ����
	int number;						// ��ȣ(�뼱)�� ������
	int people;						// 10�� �̻��� �ο�
}

class Taxi extends Car {			// �ý�
	double meter;					// ���ͱ�
}

class Truck extends Car {			// Ʈ��
	String purpose;					// �뵵�� ������
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
		lorry.license = false;		// Car�� member field
		lorry.purpose = "��ǰ";		// Truck�� member field
		System.out.println(lorry.wheel);
		System.out.println(lorry.license);
		System.out.println(lorry.purpose);
	}
}


