import kr.or.kosa.Fclass;

public class Ex02_Method_Call {
	public static void main(String[] args) {
		// Fclass�� ���� (��ü ����)
		Fclass fclass = new Fclass();
		fclass.m();		// ȣ�� (call)
		fclass.m2(100);	// i�� ����
		
		int result = fclass.m3();
		System.out.println("m3 �Լ� ȣ��� ��ȯ��: " + result);
		
		int result2 = fclass.m4(555);
		System.out.println("m4 �Լ� ȣ��� ��ȯ��: " + result2);
		
		result2 = fclass.sum(100, 200, 300);
		System.out.println("sum �Լ� ȣ��� ��ȯ��: " + result2);
		
		fclass.callSubSum();
		
		result2 = fclass.opSum(1111);
		System.out.println("opSum �Լ� ȣ��� ��ȯ��: " + result2);
		
		
		// Quiz
		// a�� b �� �� ū ���� return�ϴ� �Լ� �ۼ�
		result = fclass.maxNum(10, 5);
		System.out.println("maxNum �Լ� ȣ��� ��ȯ��: " + result);
		
	}
}
