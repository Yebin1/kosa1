// 0902

package kr.or.kosa;

// �� (���� �Ϲ�, �߻�): ���� �� �� �ִ�, ���� ������

public class Bird {

	public void fly() {
		System.out.println("flying");
	}
	
	// ������ ���: Bird�� ����ϴ� ����� moveFast �ڿ��� ���� �����Ǹ� ������ ���ھ� >> protected ��� ����
	protected void moveFast() {
		fly();
	}
}
