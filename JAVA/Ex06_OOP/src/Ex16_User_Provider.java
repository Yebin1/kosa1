/* 0906

user ����� <��> provider ������

class A {}
class B {}
����: A�� B�� ����մϴ�

1. ���: A extends B
2. ����: A��� Ŭ������ member field�� B�� ��� >> class A { B b; }
 * �κ�
 * ��ü

class B {}
class A {
	public int i;
	public B b;			// A�� B�� ����Ѵ� (����)
	public A() {
		b = new B();	// �����ڸ� ���� �ʱ�ȭ (�ּҰ� ���� �����)
	}
}
>> main �Լ�
A a = new A();			// B�� �Բ� ���������
a.b.�ڿ�					// b�� �����ϴ� ���

>> ���� ����� ���� B�� ���������� ���� �Ұ���
>> A��� ��ü�� ��������� B�� ���� ����
>> A, B�� ��� ����ü (��ü ����)
>> �ڵ����� ����, ��Ʈ�ϰ� CPU
-----------------------------------------------------------
public class B {}
public class A {
	public int i;
	public B b;			// A�� B�� ����Ѵ�
	public A() {}
	
	// method
	void m(B b) {
		this.b = b;		// B�� ��������� ��X (new ���ؼ�)
	}
}
>> main �Լ�
A a = new A();
B b = new B();
a.m(b);
>> A, B�� �ٸ� ��� (�κ� ����)


class A {}
class B {}
����:	A�� B�� ����մϴ�
	A�� B�� �����մϴ� (����) >> B�� member field�� ���

*/

interface Icall {
	void m();
}

class D implements Icall {

	@Override
	public void m() {
		System.out.println("D Ŭ������ Icall �������̽��� �Լ� m()�� ������");		
	}	
}

class F implements Icall {
	
	@Override
	public void m() {
		System.out.println("F Ŭ������ Icall �������̽��� �Լ� m()�� ������");
	}
}

// �������� ���α׷��� ��� (interface �뼼) >> ������ >> ���� ���� ���� ���´�...
// >> �����ϰ� >> 





class C {
	/* Ȯ�强, ��ȯ ����
	void method(D d) {}
	void m(F f) {}
	*/
	void method(Icall ic) {	// Icall�� �����ϴ� ��� ��ü�� �ּҰ� �� �� �ִ�
		ic.m();
	}
}


public class Ex16_User_Provider {

	public static void main(String[] args) {
		C c = new C();
		D d = new D();
		F f = new F();
		
		c.method(d);		// implements Icall
		c.method(f);

	}

}
