/* 0901

this: ��ü �ڽ��� ����Ű�� this(this.empno, this.ename)
this: �����ڸ� ȣ���ϴ� this ( this(100, "red") )

��� ����
�θ�, �ڽ�

super(���� �ڽ��� �θ��� ���� �ּҰ��� ������): ��� ���迡�� �θ𿡰� ������ �� �ִ� ���
 * super �θ� ��ü�� �ּҰ��� ������

1. super >> ��� ���迡�� �θ� �ڿ��� ����
2. super >> ��� ���迡�� �θ��� ������ ȣ�� ���� (���������)

java: super()

*/

class Base {
	
	String basename;
	
	Base () {
		System.out.println("Base �⺻ ������ �Լ�");
	}
	
	Base (String basename){
		this.basename = basename;
		System.out.println("basename: " + this.basename);
	}
	
	void method() {
		System.out.println("�θ� method");
	}
}

class Derived extends Base {
	
	String dname;
	
	Derived() {
		System.out.println("Derived �⺻ ������ �Լ�");
	}
	
	Derived(String dname) {
		
		// �θ��� ������ ȣ�� super
		super(dname);
		
		this.dname = dname;
		System.out.println("dname: " + this.dname);
	}
	
	@Override
	void method() {
		System.out.println("�θ� �ڿ� ������");
	}
	// �������ؼ� ������ "�θ� �ڿ� ������" ��µ�
	
	void pmethod() {
		super.method();		// �θ� �Լ�
		// ������ ���¿��� �θ� �ڿ��� �θ� �� �ִ� ������ ���: super
	}
}


public class Ex06_Inherit_super {

	public static void main(String[] args) {
		
	//	Derived d = new Derived();			// Base �⺻ ������ �Լ�
											// Derived �⺻ ������ �Լ�
											// overloading �Ķ���� �ٸ��Ƿ�
		
		Derived d = new Derived("ȫ�浿");	// Base �⺻ ������ �Լ�
											// dname: ȫ�浿
											// �Է� ���� parameter�� dname�̹Ƿ� Base (String basename) ȣ�� X
											
											// super(dname);�� ���� �θ��� �����ڸ� ȣ���ϸ�
											// basename: ȫ�浿
											// dname: ȫ�浿
		d.method();							// console: �θ� �ڿ� ������
		d.pmethod();						// console: �θ� method
	}

}
