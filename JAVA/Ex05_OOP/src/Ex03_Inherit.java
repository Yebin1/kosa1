// 0901

// �� ���� ���赵
class Tv {
	boolean power;
	int ch;
	
	void power() {		// �� ���� ����� �ϳ��� �Լ��� ó�� (�ѱ�, ����)
		this.power =! this.power;
	}
	
	void chUp() {		// ä�� �ø���
		this.ch++;
	}
	
	void chDown() {		// ä�� ������
		this.ch--;
	}
}

class Vcr {				// ���� �÷��̾�
	boolean power;
	void power() {
		this.power =! this.power;
	}
	
	void play() {
		System.out.println("����ϱ�");
	}
	
	void stop() {
		System.out.println("�����ϱ�");
	}
	
	void rew() {}		// �����ε�
	void ff() {}		// ��������
}

// Tv ���赵, Vcr ���赵
// TvVcr�� ��ǰ
// class TvVcr extends Tv, Vcr >> ���� ��� X
// ������ ��� �̻� (�ڿ� �̸� ���� >> �ϳ� ��� �Ұ�)
// �ϳ� ���, �ϳ� ���� >> �Ϲ����� �ذ� ���
// Tv(���), Vcr(����)
// ����: ���� ���� Ŭ���� (�ֱ��)

class TvVcr2 extends Tv {
	Vcr vcr;
	
	public TvVcr2() {
		vcr = new Vcr();
	}
}





class TvVcr {
	Tv t;
	Vcr v;
	
	public TvVcr() {
		this.t = new Tv();
		this.v = new Vcr();
	}
}


public class Ex03_Inherit {

	public static void main(String[] args) {
		TvVcr tv = new TvVcr();
		tv.t.power();
		tv.v.power();
		
		System.out.println(tv.t.power);
		
		TvVcr2 tv2 = new TvVcr2();
		tv2.power();
		System.out.println("Tv ����: " + tv2.power);
		tv2.chUp();
		tv2.vcr.power();
		System.out.println("���� ����: " + tv2.vcr.power);
		tv2.vcr.play();
	}

}
