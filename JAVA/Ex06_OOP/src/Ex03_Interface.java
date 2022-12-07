/* 0906

�߻� Ŭ������ �������̽�

�߻� Ŭ������ �������̽��� ������
1. ������ ��ü ���� �Ұ��� (new ������ ��� �Ұ�)
>> ������
 * �߻� Ŭ����:	�κ������� �ϼ��� ���� �ְ�, ������ �̿ϼ�
 * �������̽�:	��� ���� �̿ϼ� (��Ӹ� ����)
2. ���
 * �߻� Ŭ����:	extends
 * �������̽�:	implements

class Car extends Abclass {}
class Car implements Ia {}
>> �� �� �߻� �ڿ��� ������
>> extends, implements >> ���� ���� ���� (������)

�߻� Ŭ������ �������̽��� ������
1. �ϼ�, �̿ϼ�
 * �߻� Ŭ����:	�ϼ��� �ڵ带 �Ϻ� ������
 * �������̽�:	��ü������ �̿ϼ�
>> ��Ģ������ Ŭ������ ���� ����� �Ұ� 	>> ������ ���
>> �������̽��� �����ϰ� ���� ������ ����	>> ���� ������ ���� ���� ����� ��� ū ��� >> �ʹ� ū ���: ��뼺, ���뼺 ����
Ia, Ib, Ic
class Test extends Object implements Ia, Ib, Ic {} 
Tip) �������̽������� ����� ���� (extends) >> ����� ũ�� ���� �� �ִ�
2. �������̽�: ����� ������ �������� �Ϲ������� �̿ϼ�(�߻� �Լ�) �ڿ� >> JDK8 (Default ��, static ��)

�������̽�: ���, ǥ�� (��Ģ, �Ծ�)
����Ʈ���� ������ �ֻ��� �ܰ�

�ʱ� �����ڴ� ���躸�� ������� �������̽��� ����ϴ� ���, ó���� ����
�����θ� ������ ���� >> ��ӿ� ���� ���Ǹ�

�ʱ� �������� �ü�
1. �������̽��� **������** �������� ���� (�������̽��� �θ� Ÿ��)
2. ���� �������� ���� Ŭ������ �ϳ��� �����ִ� ��� (���� �θ� ������ �����ν�)
3. Java API �̸� ������� ������ �������̽��� ���� (�������� �ʾƵ� ��� ������ �ڿ�)
4. �������̽� (~able): �� �� �ִ�, ������ �� �ִ�
5. ��ü �� ���� �� (��ü �� ����) >> ������

** ���� ǥ�� >> ���� >> ������

interface
1. ���� �����θ� ������ ���� �ʴ� >> ���� ��� X >> ��Ģ (���)
�ý��ۿ��� �̵��ϴ� ���� move��� �̸��� ����ϰ� �̵� �� ��ǥ���� �޾ƾ� �Ѵ�
>> ���� >> void move(int x, int y); { ������ �˾Ƽ� (implement�ϴ� �ڿ��� �����Ǹ� ���ؼ� �ϵ���) }

>> Java API �������̽� ����, �����ϴ� Ŭ���� �����Ǿ� ����
>> Collection (���� �迭) >> Vector, ArrayList, HashSet, HashMap
�̷� Ŭ������ ������ �������̽��� �����ϰ� �ִ� Ŭ����

2. ���� ���
 * ���(final):	public static final int VERSION = 1;	>> int VERSION = 1;
  				�����ϸ� �����Ϸ��� �˾Ƽ� public static final �ٿ��� ���
 * �߻� �Լ�:		public abstract void run();				>> void run();
 				�����ϸ� �����Ϸ��� �˾Ƽ� public abstract �ٿ��� ���

interface Aa {
	int VERSION = 1;			public static final int VERSION = 1;
	void run();					public abstract void run();
	String move(int x, int y);	public abstract String move(int x, int y);
}

����
interface Aable { }					// �ƹ� �ڿ��� ������ �ʾƵ� �ȴ�
interface Aable { int NUM = 10; }	// �����
interface Aable { void run(); }		// �߻� �Լ���

class Test extends Object implements Ia, Ib, Ic {}
class Test implements Ia, Ib, Ic



*/


interface Ia {
	int AGE = 100;				// ���		public static final int AGE = 100;
	String GENDER = "����";		//			public static final String GENDER = "����";
	String print();				// �߻� �Լ�	public abstract String print();
	void message(String str);	// �߻� �Լ�	public abstract void message(String str);
}

interface Ib {
	int AGE = 100;
	void info();
	String val(String s);
}

class Test2 extends Object implements Ia {

	@Override
	public String print() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void message(String str) {
		// TODO Auto-generated method stub
		
	}
	
}

// �������̽� implements �ϴ� ���� �̿ϼ� �ڿ��� �ݵ�� �����ؾ� �Ѵ�
class Test3 extends Object implements Ia, Ib {	// ���� ����

	@Override
	public void info() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String val(String s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String print() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void message(String str) {
		// TODO Auto-generated method stub
		
	}
	
}


public class Ex03_Interface {

	public static void main(String[] args) {
		
		Test2 t2 = new Test2();
		Ia ia = t2;						// �������̽��� ������ �θ�
										// �θ� Ÿ���� ���� ������ �ڽ� ��ü�� �ּҸ� ���� �� �ִ� (������)
		ia.message("������");				// �����ǵ� �ڿ� (�ڽ� �Լ�) ȣ��
		System.out.println(ia.GENDER); 	// �� ���� �Ұ� (final) ��븸 ����
		
		Test3 t3 = new Test3();
		Ia ia2 = t3;					// Test3�� �θ� Ia, Ib
		Ib ib2 = t3;
		System.out.println(ia2.AGE);
		System.out.println(ib2.AGE);

	}

}
