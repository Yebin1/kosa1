
public class Ex02_Exception {

	public static void main(String[] args) {

		System.out.println("main start");
		int num = 100;
		int result = 0;
		
		try {
			for (int i = 0; i < 10; i++) {
				result = num / (int) (Math.random() * 10); // 0 ~ 9
				System.out.println("result: " + result + " i: " + i);
			}
		} catch (Exception e) {	// ������ �߻��ϸ� �߻� ��ü�� �ּҸ� �޾� ������ �м�
			System.out.println("���� �߻��� �����ڿ��� ���� �߼�");
			System.out.println("����: " + e.getMessage());
			
			// catch (Exception e) ���� ��ü���� ��ü�� ����ϴ� ���� �������� ���� �Ѵ�
		}
		
		System.out.println();

	}

}
