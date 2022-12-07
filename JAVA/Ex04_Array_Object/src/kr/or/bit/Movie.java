package kr.or.bit;

import java.util.Random;
import java.util.Scanner;

public class Movie {
	
	Scanner scan = new Scanner(System.in);
	
	private String[][] movieArr1;
	private String[][] movieArr2;
	
	public Movie() {	// ������
		movieArr1 = new String[4][5];
		movieArr2 = new String[5][5];
		
		for (int i = 0; i < movieArr1.length; i++) {
			for (int j = 0; j < movieArr1[i].length; j++) {
				movieArr1[i][j] = "__";	// arr1 ���ڿ��� �ʱ�ȭ
			}
		}
		
		for (int i = 0; i < movieArr2.length; i++) {
			for (int j = 0; j < movieArr2[i].length; j++) {
				movieArr2[i][j] = "__";	// arr2 ���ڿ��� �ʱ�ȭ
			}
		}
		
	}
	
	private int row, col;		// �Է� ���� �¼� ��ġ
	private int cinema;
	
	public void mySeat() {
		row = 0;
		col = 0;
	}
		
	
	
 	private void printSeat(String[][] movieArr) {	// �¼� ��Ȳ ���
		for (int i = 0; i < movieArr.length; i++) {
			for (int j = 0; j < movieArr[i].length; j++) {
				System.out.printf("[%s]", movieArr[i][j].equals("__") ? "�¼�" : "����");
			}
			System.out.println();
		}
	}
	
	public void print() {
	
		System.out.println();
		System.out.println("----------------------");
		System.out.println("-----��ȭ ���� �ý���-----");
		System.out.println("----------------------");
		movieMenu3();
		}
	
	private void movieMenu() {	// ����, ��ȸ, ���
		System.out.println("\n1. �����ϱ�\n2. ���� ��ȸ\n3. ���� ���\n4. ����\n");
		System.out.println("���ϴ� ��ȣ�� �������ּ���.");
		
	}
	
	private void movieMenu2() {	// ���� ��ȭ���� ���� ���
		System.out.println("\n������ ��ȭ�� �������ּ���.");
		System.out.println("1. �ѻ�\n2. ž��");
		
		cinema = Integer.parseInt(scan.nextLine());
		switch (cinema) {
		case 1: // �ѻ�
			printSeat(movieArr1);
			ticketCheck(movieArr1);
			printCheck();
		
		case 2: // ž��
			printSeat(movieArr2);
			ticketCheck(movieArr2);
			printCheck();
		default:
			System.out.println("�ٽ� �Է����ּ���.");
	
		}
		
	}
		
	
	private void movieMenu3() {
		
		movieMenu();
		
		while (true) {
			int num = Integer.parseInt(scan.nextLine());
			switch (num) {
			case 1: // �����ϱ�
				movieMenu2();
				break;
			case 2: // ���� ��ȸ
				viewmySeat();
				

			case 3: // ���� ���
				System.out.println("���Ÿ� ����մϴ�.");
				movieMenu2();
				break;
			case 4: // ����
				System.out.println("���α׷��� �����մϴ�.");
				break;
			default:
				System.out.println("�ٽ� �Է����ּ���.");
			}
		}
	}
	
	
	private void printCheck() { // ���� ������ ���
		
		System.out.println("\n1. ����\n2. ���� ���\n3. �ʱ� ȭ������ ���ư���\n");
		System.out.println("��ȣ�� �������ּ���.");
		
		while (true) {
			int num = Integer.parseInt(scan.nextLine());
			switch (num) {
			case 1: // ��
				ticketing(); // ���� ���θ� �迭�� �ִ� ���
				System.out.println("���Ű� �Ϸ�Ǿ����ϴ�.");
				myMovienumber();
				// System.out.printf("������ �¼� ��ȣ: [%s],/t ���� ��ȣ: [%d]", �¼���ȣ, ���Ź�ȣ);
				movieMenu3();
				break;
			case 2: // �ƴϿ�
				System.out.println("���Ÿ� ����մϴ�.");
				movieMenu3();
				break;
			case 3: movieMenu(); // �ʱ� ȭ������ ���ư���
				break;
			default:
				System.out.println("�ٽ� �Է����ּ���.");
			}
		}
	}
	
	
	
	private void possibleSeat(int seat, int seat2) {
		seat = Integer.parseInt(scan.nextLine());
		seat2 = Integer.parseInt(scan.nextLine());
		row = seat;
		col = seat2;
	}
	
	private void ticketCheck(String arr[][]) {	// ���� ���� ���θ� Ȯ��
		
		System.out.println("������ �¼��� �Է����ּ���.");
		possibleSeat(row, col);
		
		if (arr[row][col].equals("__")) {
			System.out.println("���� ������ �¼��Դϴ�.");
		} else {System.out.println("�̹� ���� �Ϸ�� �¼��Դϴ�.");}
	}
	
	
	private void ticketing() {	// ���� ���θ� �迭�� �ִ� ���
		
		if (cinema == 1 && movieArr1[row][col].equals("����")) {
			System.out.println("�̹� ���ŵ� �¼��Դϴ�.");
			
		} else if (cinema == 1 && movieArr1[row][col].equals("__"))
		{
			movieArr1[row][col] = "����";
		}
		
		if (cinema == 2 && movieArr2[row][col].equals("����")) {
			System.out.println("�̹� ���ŵ� �¼��Դϴ�.");
			
		} else if (cinema == 2 && movieArr2[row][col].equals("__"))
		{
			movieArr2[row][col] = "����";
		}
				
	}
	
	
	/////////////////////////////////////////////////////////////////////
	
	// ���Ź�ȣ
	
	Random random = new Random();
	
	public int[] myNumber = new int[4];
	
	private void myMovienumber() {
		for (int i = 0; i < myNumber.length; i++) {
			myNumber[i] = random.nextInt(10);
		}
		for (int i = 0; i < myNumber.length; i++) {
			System.out.printf("%d", myNumber[i]);
		}
		
	}
	

	//���� ��ȸ ���
	private void viewmySeat() {
		System.out.println("���� ��ȣ�� �Է����ּ���.");
		int num11 = Integer.parseInt(scan.nextLine());
		/*
		for (int i = 3; i >= 0; i--) {
			int temp = num11 % 10;
			if (temp == myNumber[i]) {
				temp = num11 / 10;
			} else if (temp != myNumber[i]) { 
				System.out.println("���� ��ȣ�� �ٽ� Ȯ�����ּ���."); 
				break;
			}
		}*/
		
		
		if (cinema == 1) { printSeat(movieArr1); }
		if (cinema == 2) { printSeat(movieArr2); }
		movieMenu3();
	}
	
	
	

}
