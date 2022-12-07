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
	
	Product(int price) {
		this.price = price;
		this.bonuspoint = (int) (this.price / 10.0);
	}
}

class Tv extends Product {
	Tv() {
		super(500);
	}
	@Override
	public String toString() {
		return "Tv";
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

class NoteBook extends Product {
	NoteBook() {
		super(200);
	}
	@Override
	public String toString() {
		return "NoteBook";
	}
}

class Buyer {
	int money = 1500;
	int bonuspoint;
	
	void Buy(Product n) {
		if(this.money <= n.price) {
			System.out.println("�ܾ��� �����մϴ�. " + this.money);
			return;
		}
		
		money -= n.price;
		bonuspoint += n.bonuspoint;
		System.out.println("���� ����: " + n.toString());
	}
}




public class c {
	
	public static void main(String[] args) {
		
		Tv tv = new Tv();
		Audio audio = new Audio();
		NoteBook notebook = new NoteBook();
		
		Buyer buyer = new Buyer();
		
		buyer.Buy(tv);
		buyer.Buy(tv);
		buyer.Buy(audio);
		buyer.Buy(notebook);
		buyer.Buy(notebook);
		
	}
}