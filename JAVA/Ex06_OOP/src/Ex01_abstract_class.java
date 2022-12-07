/* 0906

�߻� Ŭ����
>> �̿ϼ� Ŭ���� (���赵)
1. �ϼ��� �ڵ� + �̿ϼ� �ڵ�
2. �ϼ�(�Լ�) ���� ����� �ִ� �Լ� + �̿ϼ�(�Լ�) ���� ����� ���� �Լ� >> public void run();
3. �ϼ��� Ŭ���� (new ����)

������ ���忡��
>> �ǵ� >> �ݵ�� ������ �� �� >> ������ ���� ���� (���� ���ϹǷ�)

 */


class Car {
	void run() {}	// ������ ��� ���� ��ϸ� ������ �ϼ��� �ڵ�
}

class Hcar extends Car {
	@Override
	void run() {
		System.out.println("������");
	}
	
}

// Car ���� ���: run() �����Ǹ� ���� ���� �ٲ��
// �׷��� ������ �����Ƿ� Hcar ���� ����� �ǹ��� �ƴ�
// �� �ڵ�� �������� ����

abstract class Abclass {	// �߻� Ŭ����: �ּ� 1�� �̻��� �߻� �Լ��� ������ Ŭ����
	// �ϼ��� �ڵ�
	int pos;
	void run() {
		pos++;
	}
	
	// �̿ϼ� �ڵ� �߰� (�̿ϼ� �Լ�: �߻� �Լ� abstract method)
	abstract void stop();	// {���� ���} ����� ��: ������(Override)�� ����
}

class Child extends Abclass {
	@Override
	void stop() {			// ���� ����� ����� ���� (������)
		this.pos = 0;
		System.out.println("stop: " + this.pos);
	}
}

class Child2 extends Abclass {
	@Override
	void stop() {			// ���� ����� ����� ���� (������)
		this.pos = -1;
		System.out.println("stop: " + this.pos);
	}
}


public class Ex01_abstract_class {

	public static void main(String[] args) {
		Child ch = new Child();
		ch.run();
		ch.run();
		ch.stop();
		
		Child2 ch2 = new Child2();
		ch2.stop();
		
		Abclass ab =  ch;	// ������
		// ��� ���迡�� �θ� Ÿ���� ���� ������ �ڽ� Ÿ�� ��ü���� �ּҸ� ���� �� �ִ�
		// ��, �θ�� �ڽ��� �͸� �� �� �ִ�
		// ��, ������ ����
		ab.run();
		ab.stop(); 			// �ڽ� �Լ��� ȣ�� (����)
	}
}
