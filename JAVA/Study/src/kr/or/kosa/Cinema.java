package kr.or.kosa;

import java.util.Scanner;

public class Cinema {
	Scanner scan = new Scanner(System.in);
	
	public String seat1[][];
	public String seat2[][];
	private int movie;
	private int x, y;
	private String password;
	
	//������
	public Cinema() {
		seat1 = new String[5][5];
		seat2 = new String[8][8];
	}
	
	//���� �ý��� ���� �Լ�
	public void start() {
		System.out.println("��ȭ ���� �ý����� �����մϴ�.");
		System.out.println();
		
		//�ʱ�ȭ
		initSeat(seat1);
		initSeat(seat2);
		
		while(true) {
			printInfo(); //�ý��� �޴� ���
			int n = Integer.parseInt(scan.nextLine());
			
			switch(n) {
				case 1:
					printMovie(); //��ȭ ���� ���
					movie = selectMovie(); //��ȭ ���� ����
					
					if(movie == 1) {
						printSeat(seat1); //��ȭ�� �¼� ���� ���
						selectSeat(seat1); //��ȭ ����
					}else {
						printSeat(seat2); //��ȭ�� �¼� ���� ���
						selectSeat(seat2); //��ȭ ����
					}
					break;
				case 2:
					checkInfo(); //���� ���� Ȯ��
					break;
				case 3:
					if(movie == 1) {
						drop(seat1);
					}else if(movie == 2){
						drop(seat2);
					}else {
						System.out.println("���� ������ �����ϴ�.");
					}
					break;
				case 4: //�¼� Ȯ��
					printMovie(); //��ȭ ���� ���
					
					switch(selectMovie()) {
						case 1:
							printSeat(seat1);
							break;
						case 2:
							printSeat(seat2);
							break;
						default:
							System.out.println("�߸��� ���Դϴ�.");
					}
					
					break;
				case 5:
					System.out.println("���α׷��� �����մϴ�.");
					System.exit(0);
					break;
				default:
					System.out.println("�߸��� �Է°��Դϴ�.");
					System.out.println("�ٽ��Է����ּ���.");
			}
		}
	}

	//�޴��� ���
	public void printInfo() {
		System.out.println("-----------------------------");
		System.out.println("       [��ȭ ���� �ý���]");
		System.out.println("1. �����ϱ� 2. ������ȸ 3. �������");
		System.out.println("4. �¼�Ȯ�� 5. ���α׷� ����");
		System.out.println("-----------------------------");
		System.out.println();
		System.out.print("��ȣ�� �������ּ��� : ");
	}
	
	//��ȭ ���� ���
	private void printMovie() {
		System.out.println("--------------------");
		System.out.println("     [��ȭ ����]	");
		System.out.println("| 1. �ѻ� | 2. ž�� |");
		System.out.println("--------------------");
		System.out.println();
	}
	
	//��ȭ ���� ����
	private int selectMovie() {
		System.out.print("���Ͻô� ��ȭ�� �������ּ��� : ");
		System.out.println();
		int m = Integer.parseInt(scan.nextLine());
		if(m != 1 && m != 2) {
			System.out.println("�߸��� ���� �Է��߽��ϴ�.");
			selectMovie();
		}
		return m;
	}
	
	//�¼� ��Ȳ ���
	private void printSeat(String[][] seat) {
		System.out.printf("        ");
		for(int i=0; i<seat[0].length; i++) {
			System.out.printf("[%d��]", i);
		}
		System.out.println();
		
		for(int i=0; i<seat.length; i++) {
			System.out.printf("[%d��] : ", i);
			for(int j=0; j<seat[i].length; j++) {
				System.out.printf("[%s]", seat[i][j].equals("__") ? "����" : "�Ϸ�");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	//�¼� �ʱ�ȭ
	private void initSeat(String[][] seat) {
		for(int i=0; i<seat.length; i++) {
			for(int j=0; j<seat[i].length; j++) {
				//�¼��� �ʱ�ȭ
				seat[i][j] = "__"; //���ڿ��� �ʱ�ȭ
			}
		}
	}
	
	//����
	private void selectSeat(String[][] seat) {
		System.out.println("���Ͻô� �¼��� �Է����ּ���");
		
		while(true) { //�¼� ������ ����� �� ����
			System.out.print("��: ");
			x = Integer.parseInt(scan.nextLine());
			if(x >= 0 && x < seat.length)
				break;
			else
				System.out.println("�ùٸ� ���� �ƴմϴ�.");
		}
		
		while(true) {	//�¼� ������ ����� �� ����
			System.out.print("��: ");
			y = Integer.parseInt(scan.nextLine());
			if(y >= 0 && y < seat[0].length)
				break;
			else
				System.out.println("�ùٸ� ���� �ƴմϴ�.");
		}
		
		System.out.println("����Ȯ�� ��й�ȣ 4�ڸ� ���ڸ� �Է����ּ���");
		password = scan.nextLine();
		
		seat[x][y] = password;
	}
	
	//������ȸ
	private void checkInfo() {
		if(movie == 0) {
			System.out.println("���� ������ �����ϴ�.");
		}else {
			System.out.println("�¼� Ȯ�� ��й�ȣ�� �Է����ּ��� : ");
			String tmp_p = scan.nextLine();
			if(tmp_p.equals(password)) {
				System.out.printf("[��������]\n��ȭ : ");
				System.out.print(movie == 1 ? "�ѻ�" : "ž��");
				System.out.printf("�¼�: %d�� %d��\n", x, y);
			}else {
				System.out.println("��й�ȣ�� �߸��Ǿ����ϴ�.");
			}
		}
		System.out.println();
	}
	
	//���� ���
	private void drop(String[][] seat) {
		System.out.println("���Ÿ� ����Ͻ÷��� ����Ȯ�� ��й�ȣ�� �Է����ּ���");
		String tmp_p = scan.nextLine();
		if(tmp_p.equals(password)) {
			password = null;
			movie = 0;
			seat[x][y] = "__";
			x = 0;
			y = 0;
			System.out.println("���Ű� ��ҵǾ����ϴ�.");
		}else {
			System.out.println("��й�ȣ�� �߸��Ǿ����ϴ�.");
		}
	}
	
}