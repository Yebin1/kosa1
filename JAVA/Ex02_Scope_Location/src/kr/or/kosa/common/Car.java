package kr.or.kosa.common;

public class Car {

	int i;				// �����Ϸ��� �ڵ����� default >> ���� ���� ���� package
						// kr.or.kosa.common package������ ��� ����
						// default package Ex01_Main���� i�� ��� �Ұ�
	public int window;	// ���� ����, �ٸ� ���� ��� ���� ���
	private int door;	// �ٸ� ���������� ������ ��� �Ұ�, ĸ��ȭ�� ���� �Ұ�
						
	// ����X ���������� ����O setter, getter
	public void setDoor(int d) {	// ������ �ڿ�(door) write
		door = d;
	}					
	
	public int getDOor() {			// ������ �ڿ� read
		return door;	
	}


}
