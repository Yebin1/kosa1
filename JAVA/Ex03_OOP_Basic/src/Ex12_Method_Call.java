/* 0829
�Լ� ���� parameter ��, �ּҸ� ����
void m(int x) {}	>> x ����: ���� �޴´�
int y = 200;
ȣ��: m(y);
y = 1000; ���� >> �ǹ�X

 * call by value

/////////////////////////////////////////////////////////

void m2(Car c) { c.color = "red" }	>> c ����: �ּҸ� �޴´�
Car c2 = new Car();
ȣ��: m(c2);			>> ���� Ÿ���� �ּҰ��� �����Ѵ� (Today Point)

 * call by reference
*/


class Data { // ������
	int i;
}

public class Ex12_Method_Call {
	static void scall(Data sdata) { // default static
		System.out.println("�Լ�: " + sdata.i);
		sdata.i = 111;				// 0xA���� i���� 111�� ����
	}
	static void vcall(int x) {		// default static
		System.out.println("before x: " + x);
		x = 8888;
		System.out.println("after x: "+ x);
		
	}

	public static void main(String[] args) {
		Data d = new Data();		// d�� �ּҰ� 0xA����
		d.i = 100;
		System.out.println("d.i: " + d.i);
		/*
		scall(d);					// �ּҰ� ���� (0xA����)
		System.out.println("after d.i: " + d.i);
		*/
		////////////////////////////////////////////////////////
		
		vcall(d.i);					// ���� ���� (100)
		System.out.println("d.i: " +d.i); 		// ���� ����X

	}

}
