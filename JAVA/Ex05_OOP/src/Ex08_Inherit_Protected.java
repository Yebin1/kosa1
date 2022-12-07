import kr.or.kosa.Pclass;

/* 0902

���� ����: ��� ����
������: protected

public
private
default
protected

protected: ��鼺 >> default, public
>> ����� ���� Ŭ���� �ȿ��� protected �����ڴ� default�� ����
>> ��� ���迡���� �ǹ̸� ������ >> ��� ���迡�� public�̴�

*/

class Dclass {
	public int i;
	private int p;
	int s;				// default
	protected int k;	// default (���X) >> ���X
}

class Child2 extends Pclass {
	void method() {
		this.k = 100;	// ��� ���� >> �ڽ��� �θ��� protected �ڿ��� publicó�� ���
		System.out.println(this.k);
	}
}


public class Ex08_Inherit_Protected {

	public static void main(String[] args) {
		
		Pclass p = new Pclass();
		// p.i
		// p.k >> �̷��� ����ϸ� default�� �������� (�ٸ� ��Ű������ ��� �Ұ�)
		Child2 ch = new Child2();
		ch.method();
		
	}

}
