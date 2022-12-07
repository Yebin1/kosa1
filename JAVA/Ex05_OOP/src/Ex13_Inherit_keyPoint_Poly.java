/* 0905
���� Ǯ�� ������ ^^
�䱸����
īƮ (Cart)
īƮ���� ���忡 �ִ� [��� ������ǰ]�� ���� �� �ִ� 
īƮ�� ũ��� �����Ǿ� �ִ� (10��) : 1��  , 2�� ���� �� �ְ� �ִ� 10������ ���� �� �ִ�
���� ������ ���� �ϸ� ... [īƮ�� ��´�]
---------------------------------------
���뿡 ���� ��ü ���
������� �ʿ�
summary() ��� �߰��� �ּ���
����� ������ �����̸� �� �������� ����
�� �����ݾ� ��� ���

hint) īƮ ������ ��� ���� (Buy() �Լ��ȿ��� cart  ��� ���� ���� )
hint) Buyer ..>> summary()  main �Լ����� ����Ҷ�

�����ڴ� default �ݾ��� ������ �ְ� �ʱ�ݾ��� ������ �� �� �ִ�
*/
class Product2{
	int price;
	int bonuspoint;
	//Product(){}
	Product2(int price){
		this.price = price;
		this.bonuspoint = (int)(this.price/10.0);
	}
}

class KtTv2 extends Product2{
	KtTv2(){
		super(500);
	}
		
	//�̸�
	@Override
	public String toString() {
		return "KtTv2";
	}
}

class Audio2 extends Product2{
	Audio2(){
		super(100);
	}
	
	@Override
	public String toString() {
		return "Audio2";
	}
}

class Buyer2{
	int money = 5000;
	int bonuspoint;
	//////////////////////////////////////////////////////
	//��ٱ���(īƮ) �����ϱ� (��� ������ǰ�� ���� �� �ִ�) : 10��
	Product2[] cart;
	int index=0;
	//////////////////////////////////////////////////////
	Buyer2() {
		this(1000,0);
	}
	Buyer2(int money , int bonuspoint){
		//�ʱ�ȭ
		cart = new Product2[10]; //ī�� �ʱ�ȭ  (POINT)
		this.money = money;
		this.bonuspoint = bonuspoint;
	}
	
	
	
	
	
	void Buy(Product2 n) { //�Լ��� parameter ��ǰ��ü�� �ּҸ� �޾Ƽ� ..(����,����Ʈ)
		if(this.money < n.price) {
			System.out.println("���� �ܾ��� �����մϴ�^^! " + this.money);
			return; //kttvBuy �Լ� ����
		}
		//cart ���
		//������� �ڵ�//////////////////////////////////////////////
		if(this.index >= 10) {
			System.out.println("���� �׸� �缼�� ^^");
			return;
		}
		cart[index++] = n;  //0�� index ���  ��ġ���� index=1 ....
		////////////////////////////////////////////////////////
		
		//�� ��������
		this.money -= n.price;
		this.bonuspoint += n.bonuspoint;
		System.out.println("������ ������ : " + n.toString());
		System.out.println("�ܾ� : " + this.money);
		System.out.println("����Ʈ : " + this.bonuspoint);
	}
	
	// ����(��ٱ���)
	// ������ ��� 
	// ������ ���� , �̸�
	// �� ���Ű���
	void summery() {
		int totalprice=0;
		int totalbonuspoint=0;
		String productlist=""; //���� (StringBuffer ...)
		/*
		for(int i = 0 ; i < cart.length ;i++) {  //������ ������ null ���� ����
			//�����̵� 10�� ������ ...
			if(cart[i] == null) break; //���� continue
			totalprice += cart[i].price;
			totalbonuspoint += cart[i].bonuspoint;
			productlist+= cart[i].toString()+ " ";
		}
		*/
		for(int i = 0 ; i < index ;i++) {
			totalprice += cart[i].price;
			totalbonuspoint += cart[i].bonuspoint;
			productlist+= cart[i].toString()+ " ";
		}
		
		System.out.println("***********");
		System.out.println("������ ���� �Ѿ�: " + totalprice);
		System.out.println("����Ʈ �Ѿ�: " + totalbonuspoint);
		System.out.println("������ ���� ���: " + productlist);
	}
}

class NoteBook2 extends Product2{
	NoteBook2(){
		super(150);
	}
	//�̸�
	@Override
	public String toString() {
		return "NoteBook2";
	}
}
public class Ex13_Inherit_keyPoint_Poly {

	public static void main(String[] args) {
		KtTv2 tv2 = new KtTv2();
		Audio2 audio2 = new Audio2();
		NoteBook2 notebook2 = new NoteBook2();
		
		Buyer2 buyer2 = new Buyer2(5000,0);
		
		buyer2.Buy(notebook2);
		buyer2.Buy(notebook2);
		buyer2.Buy(tv2);
		buyer2.Buy(tv2);
		buyer2.Buy(tv2);
		buyer2.Buy(audio2);
		buyer2.Buy(audio2);
		buyer2.summery();

	}

}