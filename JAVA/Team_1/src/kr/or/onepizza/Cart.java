package kr.or.onepizza;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Cart {

	private Map<String, Integer> cart;
	private Scanner scan;

	public Cart() {
		cart = new HashMap<String, Integer>();
		scan = new Scanner(System.in);
	}

	// ��ٱ��� ����
	public int viewCart() {
		for (Entry<String, Integer> entry : cart.entrySet()) {
			System.out.println("[" + entry.getKey() + "] " + entry.getValue() + "��");
		}

		return selectCart();
	}

	// ��ٱ��� ��� ȭ��
	private int selectCart() {
		int returnValue = 0;

		System.out.println("1: ���� | 2: ���� ���� | 3. ����");
		System.out.println("0: ����");
		System.out.print("��ȣ�� ������ �ּ��� : ");
		String select = scan.nextLine();
		System.out.println();
		Payment payment = new Payment();

		switch (select) {
		case "1":
			if (cart.size() != 0) {
				if (!payment.pay()) { // ���� ����
					returnValue = 0;
				} else { // ���� ���� viewOrder();
					returnValue = 1;
				}
			} else {
				System.out.println("���� �޴��� ������ �ּ���.\n");
			}
			break;
		case "2":
			selectAmount(); // ���� ����
			break;
		case "3":
			emptyCart(); // ����
			break;
		case "0": // ���� �޴�
			returnValue = -1;
			break;
		default:
			System.out.println("�߸��� �Է°��Դϴ�.\n");
		}
		return returnValue;
	}

	// ���� ����
	private void selectAmount() {
		String changeMenu = null;
		String regex = "^[1-9]$";
		int count = 0;
		if (cart.isEmpty()) {
			System.out.println("������ ��ٱ��ϰ� ����ֽ��ϴ�. �޴��� �����ϰ� �õ��� �ּ���.\n");
		}

		while (count < 3) {
			System.out.print("������ ������ �޴�: ");
			changeMenu = scan.nextLine();
			System.out.println();
			if (cart.containsKey(changeMenu)) {
				break;
			} else {
				System.out.println("��ٱ��Ͽ� �������� �ʴ� �޴��Դϴ�.\n");
				count++;
			}
		}
		while (count < 3) {
			System.out.print("�����l ���� (�ִ� ���� 9��): ");
			String tmpCount = scan.nextLine();
			System.out.println();
			if (Pattern.matches(regex, tmpCount)) {
				int changeMenuCount = Integer.parseInt(tmpCount);
				System.out.println(changeMenu + "�� ������ " + changeMenuCount + "���� �����մϴ�.\n");
				cart.put(changeMenu, changeMenuCount);
				break;
			} else {
				System.out.println("�߸��� �Է°��Դϴ�.\n");
				count++;
			}
		}

	}

	// ��ٱ��� ����
	public void emptyCart() {
		if (cart.isEmpty()) {
			System.out.println("��ٱ��ϰ� ����ֽ��ϴ�.\n");
		} else {
			System.out.println("��ٱ��� ���⿡ �����߽��ϴ�.\n");
		}
		cart.clear();
	}

	public void addCart(String name, int count) {
		cart.put(name, count);
	}

	public Map<String, Integer> getCart() {
		return cart;
	}

	public void setCart(String name, int count) {
		cart.put(name, count);
	}

}
