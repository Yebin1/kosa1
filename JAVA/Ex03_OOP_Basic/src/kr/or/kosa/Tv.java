package kr.or.kosa;

/*
Tv ���赵 �䱸���� ����
Tv�� ä�� ������ ������ �ִ� (1~200)				// public
Tv�� �귣�� �̸��� ������ �ִ� (����, �Ｚ)			// public
Tv�� ä�� ��ȯ ����� ������ �ִ� (�� ä�ξ� �̵� ����)
>> ä���� ������Ű�� ���
>> ä���� ���ҽ�Ű�� ���
Tv�� ä�� ����, �귣�� �̸� ��� ����� ������ �ִ�

*/


public class Tv {
	
	public int channel;	// default: 0
	public String name;	// default: null

	
	public void ch_Up() {
		channel++;
	}
	public void ch_Down() {
		channel--;
	}
	public void info_Tv() {
		System.out.printf("%s, %d \n", name, channel);
	}
	
	

}
