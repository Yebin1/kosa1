import java.util.Scanner;

// 0829
public class Ex17_do_while_Menu {

	Scanner sc = new Scanner(System.in);
	
	// ��� ����
	void inputRecord() {
		System.out.println("���� ������ �Է�");
	}

	void deleteRecord() {
		System.out.println("���� ������ ����");
	}
	
	void sortRecord() {
		System.out.println("���� ������ ����");
	}
	
	int displayMenu() {
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
		
		Ex17_do_while_Menu ex17 = new Ex17_do_while_Menu();
		while(true) {
			switch (ex17.displayMenu()) {
			case 1: ex17.inputRecord();
				break;
			case 2: ex17.deleteRecord();
				break;
			case 3: ex17.sortRecord();
				break;
			case 4: System.out.println("���α׷� ����");
				// return;	>> main �Լ� ����
				System.exit(0); // ���α׷� ���� ���� (kill)
			}
		}
	}

}
