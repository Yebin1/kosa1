// 0826

// static	����: ��ü���� ���� ���� ������ �� �������� ����
// instance	����: ��ü���� �ٸ� ���� ������ �� �������� ����

// �� ������ ���� �ʱ�ȭ�ϴ� ���

class InitTest{
	static int cv = 10;
	static int cv2;
	int iv = 9;
	// default���� �����Ƿ� �ʱ�ȭ���� �ʾƵ� ����X
	
	
	static {
		// static �ڿ� �ʱ�ȭ ���
		// static int cv = 10;, static int cv2;�� �޸�(class area)�� �ö� �� �ٷ� ȣ��
		cv = 1111;
		cv2 = cv + 2222;
		// System.out.println(cv2);
	}
	
	
	
	{
		// �ʱ�ȭ ��� (member field �ش� ��Ͽ��� �ʱ�ȭ)
		// ��ü �����ǰ� �� (int iv�� �޸𸮿� �ö� ��) �ٷ� ȣ�� { �� }
		// �������� �ڵ�
		System.out.println("�ʱ�ȭ ���");
		// iv = 2222;
		if (iv > 10) iv = 1000;
		
		cv = 100;	// static: ��ü�� �����Ǳ⵵ ���� �޸𸮿� �ö� �����Ƿ� ���� ����
					// �ʱ�ȭX
					// ��ü�� new ���������� static �ʱ�ȭ ����X
					// static {} �ʱ�ȭ ���
	}
}





public class Ex09_Static_init {

	public static void main(String[] args) {
		// InitTest t = new InitTest();
		// System.out.println(t.iv);
		
		System.out.println(InitTest.cv);
		System.out.println(InitTest.cv2);

	}

}
