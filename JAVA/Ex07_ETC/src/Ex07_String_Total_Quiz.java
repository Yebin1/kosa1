import java.util.Scanner;

// �ֹι�ȣ : �޹�ȣ ù�ڸ� : 1,3 ���� , 2,4 ���� ��� ��� ... �ϴ� ����
// main �Լ� Scanner  ��� �ֹι�ȣ �Է¹ް�
// ��:6�ڸ�     ��:7�ڸ�
// �Է°� : 123456-1234567 

// ���� static���� ����
// 1. �ڸ��� üũ (���)�Լ� (14 ok)  return true , false 
// 2. �޹�ȣ ù��° �ڸ��� 1~4������ ���� ��� ����Լ�  return true, false
// 3. �޹�ȣ ù��° �ڸ����� ������ 1,3 ���� , 2,4 ���� ��� ����Լ�  void  ���

public class Ex07_String_Total_Quiz {

	static String number = "";
	static boolean result1;
	static boolean result2;
	
	static void numberScan() {
		System.out.println("�ֹε�Ϲ�ȣ�� �Է����ּ���.");
		
		Scanner scan = new Scanner(System.in);
		number = scan.nextLine();
	}
	
	static void numberCheck() {
		if (number.length() == 14) {
			result1 = true;
		}
		System.out.println(result1);
	}
	
	static void numberCheck2() {
		
		String[] numberArr = number.replace("-", "").split("");
		if (numberArr[6].equals("1")
				|| numberArr[6].equals("2")
				|| numberArr[6].equals("3")
				|| numberArr[6].equals("4")) {
			result2 = true;
		} else {
			result2 = false;
		}
		System.out.println(result2);
	}
	
	static void numberCheck3() {
		String[] numberArr = number.replace("-", "").split("");
		if (numberArr[6].equals("1")
				|| numberArr[6].equals("3")) {
			System.out.println("����");
		} else if
				(numberArr[6].equals("2")
				|| numberArr[6].equals("4")) {
			System.out.println("����");
		}
			
	}

		
	public static void main(String[] args) {
		
		numberScan();
		numberCheck();
		numberCheck2();
		numberCheck3();

	}

}
