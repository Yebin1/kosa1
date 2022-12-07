// 0826

/*
static member field: ��ü �� ���� �ڿ�
static method
1. ��ü ���� ����
2. ���� ���
3. ���赵�� ���� �� ��� (�ش� �ڿ� Ȥ�� ����� ���� ����Ѵٸ�)
4. �ڿ� ���� �� �� ���ϰ� ����ϵ��� >> new ���� �ʰ� ����� �� �ְ� >> static �Լ�

*/

class StaticClass {
	
	int iv;			// instance variable
	static int cv;
	
	void m() {
		// �Ϲ� �Լ�
		// new�� ���� Heap �޸𸮿� �ö󰡾� ��� ����
		// 1. iv�� ���� ����
		// 2. cv�� ���� ����
		cv = 100;
		// static �ڿ��� ��ü ���� ������ �̹� memory�� �ε�ǹǷ�
	}
	
	static void print() {
		// static �Լ�
		// 1. cv�� ���� ����
		// 2. iv�� ���� �Ұ�
		// iv = 1000; >> Cannot make a static reference to the non-static field iv
		// static �ڿ��� �Ϲ� �ڿ����� �켱
		
		// static �Լ��� static �ڿ��� ������ �� ����
		cv = 10000;
	}
}


public class Ex10_Static_Method {

	public static void main(String[] args) {
		// System.out.println();
		StaticClass.print();
		System.out.println(StaticClass.cv);
		
		StaticClass sc = new StaticClass();
		sc.m();
		sc.print();
	}

}
