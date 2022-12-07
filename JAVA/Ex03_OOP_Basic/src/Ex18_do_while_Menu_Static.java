import java.util.Scanner;

// 0829

// Ex17_do_while_Menu �Լ��� ��� static���� �ڵ� ����
// static >> new ���� �ʾƵ� class area�� �ö�

public class Ex18_do_while_Menu_Static {
	
	static Scanner sc = new Scanner(System.in);
	
	// ��� ����
	static void inputRecord() {
		System.out.println("���� ������ �Է�");
	}

	static void deleteRecord() {
		System.out.println("���� ������ ����");
	}
	
	static void sortRecord() {
		System.out.println("���� ������ ����");
	}
	
	static int displayMenu() {
		System.out.println("****���� ����****");
		System.out.println("1. �л� ���� �Է�");
		System.out.println();
		System.out.println("2. �л� ���� ����");
		System.out.println();
		System.out.println("3. �л� ���� �̸��� ����");
		System.out.println();
		System.out.println("4. ���α׷� ����");
		System.out.println();
		
		int menu = 0;
		do {
			try {
				menu = Integer.parseInt(sc.nextLine()); // 1, 2... �Է�
				if (menu >= 1 && menu <= 4) {
					break;	// do-while�� Ż��
				} else {
					// 1���� �۰� 4���� ū ��
					// ���� ������ �ƴ����� (���ܰ� �ƴ�����)
					// �ش� ��Ȳ�� ���ܷ� ���� �� �ִ�
					throw new Exception("�Ŵ� ���� ��ȣ�� �߸��Ǿ����ϴ�.");
				}
			} catch (Exception e) {
				System.out.println("���� ����: " + e.getMessage());
				System.out.println("�޴� ���� ���� �߻�");
				System.out.println("1~4 ��ȣ�� �Է��ϼ���.");
			}
		} while(true);
		
		// 1~4 ������ ���ڸ� �����ߴٸ�
		return menu;
	}

		public static void main(String[] args) {
			while(true) {
				switch (displayMenu()) {
				case 1: inputRecord();
					break;
				case 2: deleteRecord();
					break;
				case 3: sortRecord();
					break;
				case 4: System.out.println("���α׷� ����");
					// return;	>> main �Լ� ����
					System.exit(0); // ���α׷� ���� ���� (kill)
				}
			}
		}
}
