package kr.or.kosa;

public class NoteBook {

	// ��Ʈ���� ���콺�� ������ �ִ�
	// ���콺 >> ��, ��ư 2��, ��ǥ�� �� >> ��ǰ ����
	// ���콺 ���赵 class
	
	// ��Ʈ�ϰ� ���콺�� ������ ��ǰ
	
	
	public Mouse mouse;	// Mouse��� Ÿ���� Ŭ���� >> ���� ���� mouse�� �ּҰ��� ������
	
	public String color;
	
	
	// ��ü ���� ��� (ĸ��ȭ, ����ȭ: ���������� ���� �����ϰ� ���� �� ����)
	// year�� ���̳ʽ��� X >> ������: ���� �ž� >> ��� �Ұ� >> ���������� ��� �����ϵ��� >> ������(method)�� ���� �ְ� �ް� ��
	// ���� >> �����ڰ� ���� ���� ����
	
	// public int year;
	private int year;

	// ��� ĸ��ȭ (read, write �Լ�) >> ǥ��ȭ >> getYear, setYear
	public void setYear(int data) {	// ���� �Ҵ��� ����: ���� ���ϴ� ���
		if (data < 0) {
			year = 1999;
		} else {
			year = data;
		}
		
	}
	
	public int getYear() {			// ���������� year member field�� return�ϴ� �Լ�
		return year;
	}
	
	public int number;
	
	// ��Ʈ���� �ʿ信 ���� ���콺�� ���� �� �ִ�
	// ������: ������ ��ü�� �ּҸ� ������
	
	public void handle(Mouse m) {
		m.x = 100;
		m.y = 200;
	}

	

}
