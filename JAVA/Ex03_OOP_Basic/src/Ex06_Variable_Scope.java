/* 220826
instance variable	>> color	>>	class Car {private String color;}
��ü ����				>> �����Ǵ� ��ü���� �ٸ� ������ ���� �� �ִ�

local variable		>> speed	>> class Car {public void move() {int speed = 0;} }
���� ����				>> ������X, �ݵ�� �ʱ�ȭ, main �Լ�

block variable		>> i		>> class Car {public void move() { for (int i; i < 10 ...} }

static variable		>>
					>> ���� �ڿ� (��ü ��), ��ü ���� ������ memory�� �ö󰡴� �ڿ� (����: class area, method area)
					
��ü�� ����� ������ ���: new
static: new ���̵� memory�� �ö󰣴�

Ex06_Variable_Scope >> Ŭ���� >> ��üȭ (�޸�) >> new �� ���� ���µ�
static �켱�����		>> main �Լ� >> memory�� �ø��ڸ��� stack����

*/

class Variable{
	int iv;
	/*
	1. member field (instance variable)
	2. iv�� ��� ����
		* Variable v = new Variable();	>> Heap memory�� ��ü ���� >> ��ü �� iv ����
		* Variable v2 = new Variable();	>> Heap memory�� ��ü ���� >> iv�� �ϳ� �� ����
	3. ����: ������(����, �ڷ� ���)
		* ���� ����, ���� ����, ��ǰ(class) ����
	>> �����Ǵ� ��ü���� �ٸ� ���� ���� �� �ִ�
	>> �ʱ�ȭ�Ͽ� ���� �������� �ʴ´�
	>> default ���� ������ �ִ�
		* int: 0, double: 0.0, char: '\u0000', boolean: false, String: null, Car: null
	>> iv ������ ���� ����: new �����ڸ� ���� Heap�� Variable �̸��� ��ü ���� �� ��ٷ� ����

	*/
	
	static int cv;
	/*
	1. class variable (Ŭ���� ����), �Ϲ������δ� static variable (��ü �� ���� �ڿ�)
	2. ����: ������ ��� �� (�����Ǵ� ��� ��ü�� �����ϴ� �ڿ�)
		* �����Ǵ� ��� ��ü (Heap ������ ������ ��ü���� �����ϴ� �ڿ�)
	3. ���� ���:
		* 1) class�̸�.static������				>> Variable.cv
											>> ��ü�� �����Ǳ� ���� ����
		* 2) Variable v = new Variable();	>> v.cv
		 	 Variable v2 = new Variable();	>> v2.cv
		 	 >> v.cv == v2.cv (���� �ּҸ� �ٶ󺻴�: static ���� �ּ�)
	4. ���� ����
		* Hello.java > javac Hello.java > Hello.class > java.exe Hello ���ͷ� ����
		  > JVM > OS < memory ���� ���� (���� ������) > class Loader System�� �м�
		  > Ŭ���� ����(metadata: ����)�� �о� > class area(|| method area) memory�� �ø�
		  > �ش� Ŭ���� �� static variable�̳� static method�� �ִٸ�
		  > �� static�� class area(|| method area) ������ �Ҵ�
		  > �Լ��� �̸��� main�� ��� ������ ��Ģ�� ���� ���� (Stack ����), �ڿ� �Ҵ�
	
	
	*/
	
	void method() {
		int Iv = 0;
		/*
		local variable (�Լ� ���� ���� ����: ��� �� �ݵ�� �ʱ�ȭ)
		���� �ֱ�: �Լ��� ȣ��Ǹ� ���� (stack�� �Լ� ������ �Ҵ�) >> �Լ��� ���� Ȥ�� ���� return >> �Բ� �Ҹ�
			* �Լ��� ��� ����ü
		*/
		
		for (int i = 0; i <= 10; i++) {
			/*
			int i	>> block variable
					>> for ���۵Ǹ� ����
			*/
		}
	}
}

public class Ex06_Variable_Scope {

	public static void main(String[] args) {
		// � ��ü�� �������� ����
		Variable.cv = 100;
		Ex06_Variable_Scope ex06 = new Ex06_Variable_Scope();
		ex06.method();
		
		Variable b = new Variable();
		System.out.println("v.cv: " + Variable.cv);
	}

	public void method() {
			System.out.println("�Ϲ� �Լ�");
		}	

	}


