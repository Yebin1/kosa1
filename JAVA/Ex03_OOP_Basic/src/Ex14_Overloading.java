//0829
class Human2 {
	String name;
	int age;
}

class Test2{
	Human2 add(Human2 h) {
		h.name = "�ƹ���";
		h.age = 200;
		return h;						// return 0x123 �ּ�
	}
	
	Human2 add(Human2 h, Human2 h2) {	// �����ε�
		h2.name = h.name;
		h2.age = h.age;
		return h2;
		// return null; >> Human2�� �ּҸ� ������ ���� �ʴ�
	}
}


public class Ex14_Overloading {

	public static void main(String[] args) {
		
		Test2 t = new Test2();			// man	0x123 �ּ�
		Human2 man = new Human2();		// man2 0x123 �ּ�
		Human2 man2 = t.add(man);
		System.out.println(man == man2);// true
	}

}
