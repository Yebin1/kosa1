//0829
public class Ex11_Static_Method2 {

	public void method() {	// �Ϲ� �ڿ� heap�� �ε� �� ��� ���� >> new
		System.out.println("�� �Ϲ� �Լ�");
	}
	
	public static void smethod() {
		System.out.println("�� static �Լ�");
	}
	
	public static void main(String[] args) {

		// �ȿ��� smethod ���
		// Ex11_Static_Method.smethod();
		// smethod�� Ex11�� �ڿ��̹Ƿ� ��ó�� ȣ���� �ʿ�X
		smethod();
		
		Ex11_Static_Method2 ex11 = new Ex11_Static_Method2();
		// ex11 ���� ����(�ּҸ� ������ ����)�� static �ڿ�, �Ϲ� �ڿ��� ���� ����
		ex11.method();
		
	}

}
