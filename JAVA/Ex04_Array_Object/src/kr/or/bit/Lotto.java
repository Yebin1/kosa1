package kr.or.bit;

import java.util.Scanner;

public class Lotto {
	
	private int R_num[]; //�ζ� ����
	private int U_num[]; //����� �Է� �ޱ�
	
	//������
	public Lotto() {
		R_num = new int[6];
		U_num = new int[6];
	}
	/*
	//�ζ� ����
	public void func() {
		Scanner scan = new Scanner(System.in);
		System.out.println("�ζ� ���α׷��� �����մϴ�.");
		R_number();
		
		while(true) {
			printMenu(); //�⺻ �޴� ���
			
			int num = Integer.parseInt(scan.nextLine());
			
			switch(num) {
				case 1:
					U_number();
					break;
				case 2:
					if(U_num[0] == 0) {
						System.out.println("���� ����� ��ȣ�� �Է����� �ʾҽ��ϴ�.");
					}else {
						System.out.println(resultRotto() + "���� ��ȣ�� ���߾����ϴ�.");
					}
					break;
				case 3:
					printR_num();
					break;
				case 4:
					System.out.println("�ζ� ���α׷��� ���� �մϴ�.");
					System.exit(0);
					break;
				default:
					System.out.println("��Ȯ�� ��ȣ�� �Է����ּ���");
			}
			
			System.out.println();
		}
	}
	
	//�޴��� ���
	private void printMenu() {
		System.out.println("1. ��÷ || 2. ��� ���� || 3. �ζ� ��÷ ��ȣ Ȯ�� || 4. ����");
		System.out.print("��ȣ�� �������ּ��� : ");
	}
	
	*/
	//6���� ���� �߻�
	//�ζ� ���� ����
	private void R_number() {
		System.out.println("�ζ� ��ȣ ����");
		for(int i=0; i<R_num.length; i++) {
			R_num[i] = ((int)(Math.random()*45)+1);
			for(int j=0; j<i; j++){		//�ߺ��� �Ǻ�
				if(R_num[i] == R_num[j]) {
					i--;
					break;
				}
			} System.out.println();
		}
		//sortNumber(R_num); //����
	}
	/*
	//����� �ζ� ��ȣ �޾Ƽ� ����
	private void U_number() {
		System.out.println("�ζ� ��ȣ 6�ڸ��� �Է����ּ���");
		Scanner scan = new Scanner(System.in);
		
		for(int i=0; i<U_num.length; i++) {
			System.out.print((i+1) + "��° ��ȣ : ");
			U_num[i] = Integer.parseInt(scan.nextLine());
			if(U_num[i] < 1 || U_num[i] > 45) {				//�ùٸ� �ζ� �� �Ǻ�
				i--;
				System.out.println("�ζ� ��ȣ�� 1~45������ ���� �Է��� �� �ֽ��ϴ�.");
				System.out.println("�ٽ� �Է����ּ���");
			}	
			for(int j=0; j<i; j++){			//�ߺ��� �Ǻ�
				if(U_num[i] == U_num[j]) {
					i--;
					System.out.println("�ߺ����� �Է��ϼ̽��ϴ�.");
					System.out.println("�ٽ� �Է����ּ���");
					break;
				}
			}
		}
		sortNumber(U_num);
	}
	
	//��ȣ ����
	private void sortNumber(int[] num) {
		int tmp=0;
		for(int i=0; i<num.length; i++) {
			for(int j=1; j<num.length-i; j++) {
				if(num[j] < num[j-1]) {
					tmp = num[j];
					num[j] = num[j-1];
					num[j-1] = tmp;
				}
			}
		}
	}
	
	//��� ����
	private int resultRotto() {
		int sum = 0;
		
		for(int i=0; i<R_num.length; i++) {
			for(int j=0; j<U_num.length; j++) {
				if(U_num[j] == R_num[i]) {
					sum++;
				}else if(U_num[j] > R_num[i]) {
					break;
				}
			}
		}
		
		return sum;
	}*/
	
	//�ζ� ��ȣ Ȯ��
	private void printR_num() {
		System.out.println("***��÷ ��ȣ***");
		for(int i=0; i<R_num.length; i++) {
			System.out.print(R_num[i] + " ");
		}
		System.out.println();
		System.out.println("***�Է� ��ȣ***");
		for(int i=0; i<R_num.length; i++) {
			System.out.print(U_num[i] + " ");
		}
		System.out.println();
	}
}