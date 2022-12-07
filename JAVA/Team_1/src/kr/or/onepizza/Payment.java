package kr.or.onepizza;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Payment {

	private Scanner scan;
	private String cardNumber;
	private String cardPassword;

	public Payment() {
		scan = new Scanner(System.in);
	}

	// ī�� ��ȣ Ȯ��
	private boolean checkCardNumber() {
		System.out.print("ī�� ��ȣ�� �Է����ּ��� : ");
		cardNumber = scan.nextLine();
		System.out.println();
		String patternCardNumber = "^\\d{4}-?\\d{4}-?\\d{4}-?\\d{4}$";
		boolean matchCardNumber = Pattern.matches(patternCardNumber, cardNumber);

		return matchCardNumber;
	}

	// ī�� ��й�ȣ Ȯ��
	private boolean checkCardPassword() {
		System.out.print("��й�ȣ�� �Է����ּ��� : ");
		cardPassword = scan.nextLine();
		System.out.println();
		String patternCardPassword = "^\\d{4}";
		boolean matchCardPassword = Pattern.matches(patternCardPassword, cardPassword);

		return matchCardPassword;
	}

	// ����
	public boolean pay() {
		boolean returnValue = false;
		System.out.println("1. ī�� ���� | 2. ���ư���");
		System.out.print("��ȣ�� �������ּ��� : ");
		String select = scan.nextLine();
		System.out.println();

		int count = 0;

		switch (select) {
		case "1":
			while (true) {
				if (count >= 3) {
					System.out.println("���������� �ùٸ��� �ʽ��ϴ�. ����ȭ������ ���ư��ϴ�.\n");
					returnValue = false; // ���� ���� viewCart();
					break;
				}
				if (checkCardNumber() == true) {
					if (checkCardPassword() == true) {
						returnValue = true; // ���� ����
						break;
					} else {
						System.out.println("��й�ȣ�� �ùٸ��� �ʽ��ϴ�.\n");
						count++;
					}
				} else {
					System.out.println("ī�� ��ȣ�� �ùٸ��� �ʽ��ϴ�.\n");
					count++;
				}
			}
			break;
		case "2":
			returnValue = false; // ���� ���� viewCart();
			break;
		}
		return returnValue;
	}

} 