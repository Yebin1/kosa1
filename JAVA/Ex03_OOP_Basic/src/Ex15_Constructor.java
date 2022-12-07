// 0829

/*
������ �Լ� (Constructor)
1. �Լ� (Ư���� ����)
2. ���� (member field �ʱ�ȭ) >> static {}, { �ʱ��� ��� }
3. �Ϲ� �Լ��� �ٸ� ��
	* �Լ��� �̸��� ���� (class �̸��� ����)
	* return type ���� (��ü ������ ���ÿ� ȣ��, return ���� ����� ����)
	* ���� ����: new�� ���� ��ü ���� >> heap�� ���� ���� >> member field �ö� >> �ڵ����� ������ �Լ� ȣ��
4. return type(x): void >> public (void) class�� (������ return���� �����Ƿ� ����) >> public class��(){}

�ڡ� �����Ǵ� ��ü���� ���������� member field���� �ʱ�ȭ�� �� �ִ�

class Car {String color;} ���赵 ���� ... �ڵ��� ������ ���� �� �˾Ƽ�
	* A: ������ �Ķ��� �� >> ó������ �Ķ������� �������ּ���
		>> class Car { String color = "blue" }
	* B: �˾Ƽ� ���� �ء� ������ �������� ���� ���: null
		>> class Car { String color; }
		Car car = new Car();
		car.color = "gold";
		
>> ���� ���۽� ������ ������ �Է��ϵ��� �� �� �ִ� ���
>> �Լ�, { �ʱ��� ��� } >> �������� ���ų� �Է°��� ���� �� ����

5. ������ �Լ� (overloading ��� ���� ����)
6. ������ overloading�� ���� �پ��� ���� ������ ���� �ڡڡ�

�����ڸ� ����ϴ� ���� �߿��� ������ ������ �ʱ�ȭ (member field)

*/

class Car4 {
	String carname;
	// public Car4(){} �����ڰ� ����
}

class Car2 {		// ���� ����
	String carname;	// default: null
	public Car2() {	// default constructor�� ���� �ʱ�ȭ
		carname = "����";
	}	
}

class Car3 {		// ����, ������ �����ε�
					// �⺻ �̸����� ���� OK, �̸� �־� ���� OK
	String carname;
	public Car3() {
		carname = "�⺻ �̸�";
	}
	// overloading�� ����
	public Car3 (String name) {	// Today Point
		carname = name;
	}
}

class Car {
	String carname = "����";
	// ���� Car ���赵�� ���� �� �ڵ带 ���� �ʴ´ٸ� �����Ϸ��� �˾Ƽ� ������ �Լ��� �����Ѵ�
	// public Car() {} >> �����Ϸ��� �ڵ� ����
	
	// �����ڰ� ���� �����Ѵٸ�
	public Car() {
		System.out.println("�⺻ ������ ȣ��");
		carname = "�� ����";
	}
}


// ����: �ڵ����� �̸��� ������ �ڵ����� ������� �� ���ϵ��� ������ ��
// public Car5(){} �������� �ʾ���
// ���������� �����ڰ� overloading�� �����ڸ� �ϳ��� ����ٸ� �����Ϸ��� default constructor�� �ڵ� �������� �ʴ´�
// �����Ϸ��� �������� ���� �ǵ��� �ľ��� ��
// default ������ ���: �ʿ��ϸ� �̸� �ְ� ������ ������ (������X)
class Car5 {
	String carname;
	public Car5 (String name) {
		carname = name;
	}
}


public class Ex15_Constructor {

	public static void main(String[] args) {
		Car car = new Car();	// Car() ��ȣ: �Լ��� ��ȣ	>> default constructor
		System.out.println(car.carname);
		
		Car3 car3 = new Car3();
		System.out.println(car3.carname);
		
		Car3 car31 = new Car3("mycar");
		System.out.println(car31.carname);
		
	}

}


