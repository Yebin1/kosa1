/* 0905
�ó����� (�䱸����)
������ǰ ���� �ַ�� ���� �����
A ������ǰ ������ ���µǸ�

[Ŭ���̾�Ʈ �䱸����]
��� ������ǰ�� ��ǰ�� ����, ��ǰ�� ����Ʈ ������ ������ �ִ�
������ ������ǰ�� ��ǰ�� ������ �̸� ������ ������ �ִ�
ex) ������ ������ǰ�� �̸��� ������ �ִ� (Tv, Audio, Computer)
    ������ ������ǰ�� ������ ������ �ִ� (Tv: 5000, Audio: 6000)
    ��ǰ�� ����Ʈ�� ������ 10%�� �����Ѵ�

�ùķ��̼� �ó�����
������: ��ǰ�� �����ϱ� ���� �ݾ� ����, ����Ʈ ������ ������ �ִ�
ex) 10����, ����Ʈ 0
�����ڴ� ��ǰ�� ������ �� �ִ�, ���� ������ �ϰ� �Ǹ� ������ �ִ� ���� �����ϰ� ����Ʈ�� �����Ѵ�
�����ڴ� �ʱ� �ݾ��� ���� �� �ִ�

���� ����
���忡 1000���� �ٸ� ��ǰ�� �߰� (���콺, �佺Ʈ�� ...) ��ǰ ��� POS (�ڵ� ���)
���忡 1000���� ��ǰ ���� (Product ����ϴ� ��ǰ)
1. ���忡�� 3���� ��ǰ�� ������ �� �ִ� �ڵ� >> 997�� ��ǰ ���� ��� X
>> ��ȭ�� �����Ǵ� �ڵ� (������)
>>> �Լ��� parameter�� �θ� Ÿ��(Product)��


*/

class Product {
	int price;
	int bonuspoint;
	
	Product() {}
	Product(int price) {
		this.price = price;
		this.bonuspoint = (int) (this.price / 10.0);
	}
}

class KtTv extends Product {
	KtTv() {
	super(500);
	}
	
	/* KtTv(int price){
		super(price);
	} */
	
	@Override
	public String toString() {
		return "KtTv";
	}
}

class Audio extends Product {
	Audio() {
	super(100);
	}
		
	@Override
	public String toString() {
		return "Audio";
	}
}

// ������
class Buyer {
	int money = 2000;
	int bonuspoint;
	
	/* ��ǰ�� �߰��� ������ �Լ��� ������ �þ�� ���
	// ������ ���� ���� (���: method)
	// ���� ���� (�������� �ܾ׿��� -��ǰ�� ����, +����Ʈ ���� ����)
	// �����ڴ� ���忡 �ִ� ��� ������ǰ�� ������ �� �ִ� ** 3�� ���� ����
	
	void kttvBuy(KtTv n) {	// �Լ��� parameter�� ��ǰ ��ü�� �ּҸ� �޾Ƽ�...
		if (this.money < n.price) {
			System.out.println("�ܾ��� �����մϴ�. " + this.money + "��");
			return;		// Buy �Լ� ��������
		}
		// �Ǳ��� ����
		this.money -= n.price;
		this.bonuspoint += n.bonuspoint;
		System.out.println("���� ��ǰ��: " + n.toString() + "�Դϴ�.");
	}
	
	void audioBuy(Audio n) {	
		if (this.money < n.price) {
			System.out.println("�ܾ��� �����մϴ�. " + this.money + "��");
			return;		
		}
		this.money -= n.price;
		this.bonuspoint += n.bonuspoint;
		System.out.println("���� ��ǰ��: " + n.toString() + "�Դϴ�.");
	}
	
	void notebookBuy(NoteBook n) {
		if (this.money < n.price) {
			System.out.println("�ܾ��� �����մϴ�. " + this.money + "��");
			return;		
		}
		this.money -= n.price;
		this.bonuspoint += n.bonuspoint;
		System.out.println("���� ��ǰ�� " + n.toString() + "�Դϴ�.");
	} */
	
	// 1�� ����
	// �ϳ��� �̸����� ���� ���� ���(method overloading) >> Buy(KtTv n), Buy(Audio n) ... >> buyer.Buy(audio)
	
	// 2�� ����
	// ��ǰ�� �߰��Ǵ��� ���� ���� ��ӵǵ���
	// �ϳ��� �̸��� ��� >> �ߺ� �ڵ� >> ����
	// ��� ��ǰ�� Product�� ����ϰ� ���� >> �θ� Ÿ���� ���� ������ �ڽ� ��ü�� �ּҸ� ������
	void Buy(Product n) {
		if (this.money < n.price) {
			System.out.println("�ܾ��� �����մϴ�. " + this.money + "��");
			return;		
		}
		this.money -= n.price;
		this.bonuspoint += n.bonuspoint;
		System.out.println("���� ��ǰ�� " + n.toString() + "�Դϴ�.");
	}
}




class NoteBook extends Product {
	NoteBook() {
	super(150);
	}
		
	@Override
	public String toString() {
		return "NoteBook";
	}
}

public class Ex12_Inherit_keyPoint_Poly {

	public static void main(String[] args) {
		
		// �������� �����ϰ� ��ǰ ����
		KtTv kt = new KtTv();
		Audio audio = new Audio();
		NoteBook notebook = new NoteBook();
		
		Buyer buyer = new Buyer();
		// buyer.kttvBuy(kt);
		// buyer.notebookBuy(notebook);
		// buyer.audioBuy(audio);
		
		buyer.Buy(notebook);
		buyer.Buy(kt);
		buyer.Buy(audio);
		
		
		
		// System.out.println(kt.price);
		// System.out.println(kt.bonuspoint);
		// System.out.println(kt);
		
		
	}

}
