/* 0905

������ (��� ���迡�� ����)
������: ���� ���� ����(����)�� ���� �� �ִ� �ɷ�

JAVA: [��� ����]���� [�ϳ��� ���� ����]�� [���� ���� Ÿ����] ���� �� �ִ�
>> �ϳ��� ���� ����	: �θ� Ÿ��
>> ���� ���� Ÿ��	: �θ� ��� ���� �ڽ� ���

������
* ����	: �θ� �ڽĿ��� ��� ����...
* ���α׷�	: �ڽ��� �θ𿡰� ���� ���� �帲

*/


class Tv2 {					// �θ� (�и�, ������� >> �Ϲ�ȭ, �߻�ȭ)
	boolean power;
	int ch;
	
	void power() {
		this.power =! this.power;
	}
	
	void chUp() {
		this.ch++;
	}
	
	void chDown() {
		this.ch--;
	}
}

class CapTv extends Tv2 {	// CapTv Ư��ȭ, ��üȭ, ������ ��
	String text;
	String captionText() {
		return this.text = "���� �ڸ� ó���� ...";
	}
}


public class Ex10_Inherit_Poly {

	public static void main(String[] args) {
		
		CapTv ct = new CapTv();
		ct.power();
		ct.chUp();
		System.out.println(ct.captionText());
		
		Tv2 tv2 = ct;
		// ��� ���迡�� [�θ� Ÿ��]�� [�ڽ� Ÿ��]�� �ּҸ� ���� �� �ִ�
		// ��, �θ�� �ڽ��� �ڿ��� ���� �����ϴ�
		// �����Ǵ� ����
		System.out.println(ct.toString());		// CapTv@1d8d30f7
		System.out.println(tv2.toString());		// CapTv@1d8d30f7
		
		// tv2.captionText() �ڽ� �ڿ��� ���� �Ұ�
		// �����Ǵ� ����
		
		
	}

}
