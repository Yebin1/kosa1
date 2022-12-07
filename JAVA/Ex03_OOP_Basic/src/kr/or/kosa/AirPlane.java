// 0826 + 0829

package kr.or.kosa;

/*
�츮 ȸ��� ����⸦ �ֹ� ���� �Ǹ��ϴ� ȸ���Դϴ�
�츮 ȸ��� ����⸦ �����ϴ� ���赵�� ������� �մϴ�

�䱸 ����
1. ����⸦ �����ϰ� ������� �̸��� ��ȣ�� �ο��ؾ� �Ѵ�
2. ����Ⱑ ����Ǹ� ������� �̸��� ��ȣ�� �°� �ο��Ǿ����� Ȯ���ϴ� �۾��� �ʿ��ϴ� (���)
3. �������� ������� ������� ������� �� ���� ����� Ȯ���� �� �ִ�

AirPlane air101 = new AirPlane();
air101 �̸� >> �����װ�
air101 ��ȣ >> 707
��� Ȯ��
... 5��
������: ����� ���� ��� Ȯ�� >> 5�� Ȯ�εǾ����ϴ�

*/

/* ������ ���X
public class AirPlane {
	
	private int airnum;
	private String airname;
	
	private static int aircount;
	
	public void makeAirPlane(int num, String name) {
		airnum = num;
		airname = name;
		aircount++;
		
		AirDisplay();
	}
	
	public void AirDisplay() {
		System.out.printf("��ȣ: %d, �̸�: %s\n", airnum, airname);
	}
	
	public void airPlaneCount() {
		System.out.printf("�� ����� ���� ���: %d��\n", aircount);
	}

}
*/

// 0829 ������ ���
public class AirPlane {
	
	private int airnum;
	private String airname;
	
	private static int aircount;
	
	/*public AirPlane() {	// default constructor
							// ������� �̸�, ��ȣ�� �ݵ�� �ο��ؾ� �ϹǷ� ���X
	}*/
	
	public AirPlane(int num, String name) {	// overloading constructor
		airnum = num;
		airname = name;
		aircount++;
		AirDisplay();
	}
	
	public void AirDisplay() {
		System.out.printf("��ȣ: %d, �̸�: %s\n", airnum, airname);
	}
	
	public void airPlaneCount() {
		System.out.printf("�� ����� ���� ���: %d��\n", aircount);
	}

}

