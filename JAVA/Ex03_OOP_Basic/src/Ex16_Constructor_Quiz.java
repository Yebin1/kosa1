/* 0829
�ڵ��� ������ �Դϴ�.
��������� ������ �ڵ����� �ȷ��� �մϴ�.
���� �ڵ����� �⺻ ����� �� �� �� �ְ�  �������� ���� �ɼ��� ���� �� �� �ֽ��ϴ�.

�ڵ����� �⺻��
���� ���� 4�� , �ڵ����� ���� �⺻�� red  4���� �⺻ �Դϴ�

�׷��� ����
���� ������ ���� �����ϰ�  �ڵ����� ���� �⺻�� red  ���� �� �� �ְ�
���� ������ �⺻���� �ϰ� �ڵ����� ���� ���� �����ϰ�
���� ������ �ڵ����� ���� ��� ���� �Ͽ� ���� ������ �� �ֽ��ϴ�

�ڵ��� ����
1. �⺻ ���  
2. �ɼ� : �� ���� , �ڵ����� ���� �⺻
3. �ɼ� : �ڵ����� ���� ���� , �� �⺻
4. �ɼ� : �ڵ����� ���� ���� , �� ����
*/


class Car1 {						// 1. �⺻ ���
	int door;
	String color;
	
	public Car1() {					// default constructor
		door = 4;
		color = "red";
	}
	
	public Car1(int d) {			// 2. �� ���� ����
		door = d;
		color = "red";
	}
	
	public Car1(String s) {			// 3. ���� ����
		door = 4;
		color = s;
	}
	
	public Car1(int d, String s) {	// 4. ��� ����
		door = d;
		color = s;
	}
	
	public void carInfoPrint() {
		System.out.printf("��: %d��, ����: %s\n", door, color);
	}
}


public class Ex16_Constructor_Quiz {

	public static void main(String[] args) {
		
		Car1 car = new Car1();
		car.carInfoPrint();
		Car1 car2 = new Car1(5, "blue");
		car2.carInfoPrint();
	}

}
