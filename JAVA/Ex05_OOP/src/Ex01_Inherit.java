/* 0901
OOP Ư¡ (���� ���� ����(class)���� �����ؼ� �ϳ��� ū ��ǰ�� ����� ����)
1. ���
2. ĸ��ȭ (����ȭ) >> private
3. ������ (��� ���迡�� �θ� Ÿ���� �ڽ� Ÿ���� �ּҸ� ���� �� �ִ�)

���
java: child extends Base
c#	: child : Base

Ư¡
1. ���� ����� �Ұ��� (���� ��Ӹ� ����, ������ ��� ����)
2. ���� ��� (������ ���) ���� >> ���� ���� Ŭ������ ���
3. ���� ����� ���� (interface)

���
1. ���뼺
2. ����: �ʱ� ���� ��� ��
3. ���뼺 >> ���� �ð� �� >> ���� ���� ���赵�� ���� (�θ�, �ڽ� ���� ����)

��� ���迡���� �θ� Ŭ���� > �ڽ� Ŭ���� ������ �޸𸮿� �����ȴ�
GrandFather > Father > Child (heap �޸𸮿� ��ü 3�� ����)
*/

// ����ڰ� ����� ��� Ŭ������ default�� Object��� Ŭ������ ����Ѵ�
// class Car extend Object �� �ؼ�
// Object: ��� Ŭ������ (�ֻ���) �θ� Ŭ����
class Car {	// class Car extends Object �� �ۼ� ����
	
}

class GrandFather /* extends Object */ {
	
	public int gmoney = 5000;
	private int pmoney = 10000;	// ������ private�̹Ƿ� ��� ���� Ŭ������ ���� �Ұ�
								// Ŭ���� ���ο��� public�� private�� �����ϹǷ� public ����� ���������� ������ �� ���� (���� ���X)
	
	public GrandFather() {
		System.out.println("GrandFather");
	}
}

class Father extends GrandFather {
	
	public int fmoney = 3000;
	
	public Father() {
		System.out.println("Father");
	}
}

class Child extends Father {
	
	public int cmoney = 1000; 
	public Child() {
		System.out.println("Child");
	}
}


public class Ex01_Inherit {

	public static void main(String[] args) {
		
		Child child = new Child(); // 4���� ��ü ����
		System.out.println(child.gmoney);
		System.out.println(child.fmoney);
		System.out.println(child.cmoney);
		
		
		Car car = new Car();
		
	}

}
