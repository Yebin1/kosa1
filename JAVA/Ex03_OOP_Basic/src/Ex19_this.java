/* 0829

this (�̰�)
1. ��ü �ڽ��� ����Ű�� this (������ ������ ��ü�� �ּҸ� ���� ��)
�ν��Ͻ� �ڽ��� ����Ű�� ���� ���� �ν��Ͻ��� �ּҰ� ����Ǿ� ����
>> ��� instance method�� ���� ������ ������ ä ����

2. this ��ü �ڽ��� �ּ� (������ ȣ��)	>> ��Ģ������ �����ڴ� ��ü ������ �� ���� ȣ��
								>> this �н� �� ���������� this()�� ���� ���� ���� ������ ȣ�� ����
								
static�� this �� ��!

*/


class Test {
	int i;
	int j;
	
	Test () {	// ������
	}
	
	Test (int i, int j) {
		this.i = i;
		this.j = j;
	}
}

class Book2 {
	String bookname;
	
	Book2(String bookname) {
		this.bookname = bookname;
	}
}

class Socar {
	String color;
	String geartype;
	int door;
	
	Socar() {			// �⺻ ����
		this.color = "red";	// member field (instance variable) ���� this ���
		this.geartype = "auto";
		this.door = 2;
	}
	
	Socar(String color, String geartype, int door) {
		this.color = color;
		this.geartype = geartype;
		this.door = door;
	}
	
	void print() {
		System.out.println(this.color + ", " + this.geartype + ", " + this.door);
	}
	
}


public class Ex19_this {

	public static void main(String[] args) {
		
		Test t = new Test(100, 200);
		System.out.println(t.i);
		System.out.println(t.j);
		
		Socar socar = new Socar();
		socar.print();
		Socar socar2 = new Socar("blue", "auto", 4);
		socar2.print();

	}

}
