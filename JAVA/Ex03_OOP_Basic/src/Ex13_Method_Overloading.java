/* 0829
OOP ��ü ���� ���α׷��� (���� ���� ����(���赵)�� ����� �����ϴ� ����)
>> ���� ���� ���赵�� �����ϴ� ���

1. ��� (���뼺)
2. ĸ��ȭ (����ȭ): private	// setter, getter (���� �Ҵ��� ���� ���� �Ҵ��� ���� ������ ��ȣ)
3. ������: �ϳ��� Ÿ������ ���� ��ü�� �ּҸ� ���� �� �ִ� ��

>> method overloading (�����ε�): �ϳ��� �̸����� ���� ����� �ϴ� �Լ�
	* System.out.println() >> println() �Լ� �̸��� �ϳ�, ������ ���� ��
1. �����ε��� ���� ���� �����ϴ�
2. �����ڰ� ���ϰ� ����ϱ� ����
3. �����ε��� ������� �ʾƵ� �������� �ʴ´�

Overloading ����
1. �Լ� �̸��� �����ؾ� �Ѵ�
2. parameter ���� �Ǵ� Ÿ���� �޶�� �Ѵ�
3. return type�� �����ε��� �Ǵ� ������ �ƴϴ�
4. parameter�� ������ �ٸ��� �����ؾ� �Ѵ� ������!
*/


class Human{
	String name;
	int age;
}

class OverTest {					// Ŭ���� ����
	int add(int i) {
		return 100 + i;
	}
	// int add(int s) >> �̸� �浹
	
	int add(int i, int j) {			// parameter ���� �ٸ� >> overloading
		System.out.println("�����ε� : " + i + "," + j);
		return i + j;
	}
	
	String add(String s) {
		System.out.println("�����ε�: " + s);
		return "hello" + s;
	}
	
	String add(String s, int i) {
		return "�����ε�";
	}
	
	String add(int i, String s) {	// int, String ���� �ٸ� ����
		return "";
	}
	
	void add(Human human) {			// �����ε�		
		human.name = "ȫ�浿";
		human.age = 100;
		System.out.println(human.name + "," + human.age);
	}
}


public class Ex13_Method_Overloading {

	public static void main(String[] args) {
		// Overloading
		System.out.println();
		System.out.println("A");	// �ڵ����� parameter String ȣ��
		System.out.println('a');	// �ڵ����� parameter char ȣ��
		
		// System ���赵
		// System sys = new System();
		
		OverTest ot = new OverTest();
		int result = ot.add(100);
		System.out.println(result);
		result = ot.add(200, 300);
		System.out.println(result);
		
		
	}

}
