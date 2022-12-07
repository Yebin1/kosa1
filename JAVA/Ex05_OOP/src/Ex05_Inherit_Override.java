import kr.or.kosa.Emp;

// 0901

class Test2 {
	int x = 100;

	void print() {
		System.out.println("�θ� �Լ� Test2");
	}
}

class Test3 extends Test2 {
	int x = 300;	// �θ� �����ϱ� >> ���� ����
	
	// ������ (����)
	@Override
	void print() {
		System.out.println("�ڽ��� �θ��� �Լ��� ������");
	}
	
	void print(String str) {	// Overloading
		System.out.println("�����ε� �Լ�: " + str);
	}
}





public class Ex05_Inherit_Override {

	public static void main(String[] args) {
		Test3 t3 = new Test3();
		System.out.println(t3.x);
		
		t3.print();
		t3.print("Overloading");
		
		Emp emp = new Emp(1000, "ȫ�浿");
		System.out.println(emp);			// (������ ��) kr.or.kosa.Emp@3e57cd70 (������ ��) Emp [empno: 1000, ename: ȫ�浿]
		System.out.println(emp.toString());	// (������ ��) kr.or.kosa.Emp@3e57cd70 (������ ��) Emp [empno: 1000, ename: ȫ�浿]
		
		// emp ��½� emp.toString()�� ������ ȿ��
		// toString()�� Object�� �ڿ�	>> �ּҰ� return
		// toString()�� �������� �� >> �����ǵ� ���� ���
		// emp�� toString()�� ����
		
		// JAVA API�� �����ϴ� ������ Ŭ������ Object Ŭ������ toString�� �������ϰ� �ִ�

	}

}
