// 0826

package kr.or.kosa;

/*
�츮�� ī�带 ����� �Ǹ��ϴ� ȸ���Դϴ�
���� ��û�� ���� ī�� 53���� �����ϰ� �Ǿ����ϴ�

�䱸 ����
1. ī��� ī���� ��ȣ�� ����� ������ �ִ�
2. ī��� ũ�⸦ ������ ������, ũ��� ���̿� ���̸� ������ �ִ�
3. ī���� ũ��� h = 50, w = 20

---------------------------------------------------

��: ī�尡 �ʹ� Ŀ �ٽ� ����� �ּ���

���赵�� �������� �ʰ� 53�� ī���� ���̿� �ʺ� ������ �� �ֵ���


*/


public class Card {
	
	private int number;
	private String kind;
	
	public static int h = 50;
	public static int w = 20;
	
	public void makeCard(int num, String name) {
		number = num;
		kind = name;
	}
	
	public void cardDisplay() {
		System.out.printf("��ȣ: %d, ī�� ���: %s, ����: %d, �ʺ�: %d\n", number, kind, h, w);
	}
		
		

}
