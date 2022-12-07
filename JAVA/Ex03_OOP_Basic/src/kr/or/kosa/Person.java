package kr.or.kosa;


/*
class == ���赵 == ������ Ÿ��
���赵�� ���� >> ��üȭ �ʿ� (�޸�) >> ��ü
��üȭ�� ��: ��ü, �ν��Ͻ�

���赵: field(����, ����, ��ǰ) + method(���) + constructor(������ �Լ�)

public class Ex01_Basic{
	public static void main(String[] args){
	�� �ȿ��� �ڵ� ����
	main �̸��� ���� �Լ��� ����
	String name = "�ʱ�ȭ";	// local variable > ������ > �Լ��� ȣ�� ���� > �Լ� ����, �Ҹ�
	int age = 0;
	}
}


*/


public class Person {
	public String name;		// default (�ڵ�) null
	public int age;			// default (�ڵ�) 0
	public boolean power;	// default (�ڵ�) false
	
	// member field >> instance variable
	// 1. instance variable �ʱ�ȭ���� �ʾƵ� �ȴ� >> default ��
	// �ʱ�ȭ: ������ ó������ ���� �Ҵ� �޴� ��
	// ����: name member field �ʱ�ȭ �ϰ� ���� �� >> �ص� ��
	// �ʿ��ϴٸ� �ʱ�ȭ ����: public int age = 100
	
	// Today Point: �� �ʱ�ȭ���� ������?
	// �����Ǵ� ��ü(���)���� [�ٸ� �̸��� ���� �� �ִ�]
	// Person member field: ����� ���� ������ �ٸ� ���� ������ �Ѵٸ� �ʱ�ȭ�� ���� �ʿ����� X
	
	/*
	main(){
		Person ���� = new Person(); // ��� �� �� ����
		����.name = "������";
		����.age = 100;
		����.power = true;
		
		Person ���� = new Person(); // ��� �� �� �� ����
		����.name = "������";
		����.age = 20;
		����.power = false;
		
		Person �ΰ� = new Person();
		// stack	�Լ� �Ҵ�
		// heap		class �Ҵ�
	}
	*/
	
	// ���
	// ������ ����ϴ� ���
	// void ��� �͵� �������� �ʰڴٴ� �ǹ�
	public void personPrint() {
		System.out.printf("�̸��� %s, ���̴� %d, �Ŀ��� %s", name, age, power);
	}
	
	
	
	
	
	
	


}
