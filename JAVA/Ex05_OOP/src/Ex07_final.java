/* 0901

���� <-> ���
���: �ѹ� ���� [�ʱ�ȭ]�Ǹ� ���� �Ұ�
��� �ڿ�: ������ (�ֹι�ȣ), PI (3.141592...), �ý��� ��ȣ (���� ��ȣ)
����� ���������� [�빮��]

java: final int NUM = 10;
c#	: const integer NUM = 10;

final Ű����
1. final class Car {} >> Ŭ���� final	>> ��� ����
	* public final class Math extends Object
2. public final void print() {}		>> �Լ� �տ� final	 >> ��� ���迡�� ������(Override) ����


*/


class Vcard {
	final String KIND = "heart";
	final int NUM = 10;
	
	void method() {
		System.out.println(Math.PI);
	}
}

class Vcard2 {			// ����� ī�帶�� �ٸ� ������� �������� �ϰڴ�
	final String KIND;
	final int NUM;
	
	// Vcard2 (){} >> �ʱ�ȭ ���� �ʾ���!
	/*
	Vcard2 (){
		this("", 1);
	}
	*/
	
	Vcard2(String kind, int num){
		this.KIND = kind;
		this.NUM = num;
	}

	@Override
	public String toString() {
		return "Vcard2 [KIND: " + KIND + ", NUM: " + NUM + "]";
	}
	
}

public class Ex07_final {

	public static void main(String[] args) {

		/*
		Vcard vc = new Vcard();
		// vc.KIND = "aaa"; >> The final field Vcard.KIND cannot be assigned
		System.out.println(vc.KIND);
		vc.method();
		*/
		
		Vcard2 v1 = new Vcard2("spade", 1);
		System.out.println(v1.toString());
		Vcard2 v2 = new Vcard2("spade", 2);
		System.out.println(v2.toString());
		Vcard2 v3 = new Vcard2("heart", 3);
		System.out.println(v3.toString());

	}

}
