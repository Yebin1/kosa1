package kr.or.onepizza;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.regex.Pattern;

public class OrderSystem {

	private boolean login; // �α��� ���� T/F
	private String request;
	private Scanner scan;
	private Cart cart;
	private PizzaFactory pizzaFactory;
	private int takeOut;
	private Calendar calendar;
	private int totalPrice;

	public OrderSystem() {
		scan = new Scanner(System.in);
		cart = new Cart();
		pizzaFactory = new PizzaFactory();
		takeOut = -1;
		calendar = null;
		totalPrice = 0;
	}

	// �ʱ� ȭ��
	public void start() {
		System.out.println("[*** OnePizza ***]");
		System.out.println("�ȳ��ϼ���. ���� ������ �븮�� OnePizza�Դϴ�.");
		UserSystem userSystem = new UserSystem();
		while (true) {
			System.out.println("1: �޴� Ȯ�� | 2: �α��� | 3. ȸ�� ����");
			System.out.println("0: ���α׷� ����");
			System.out.print("��ȣ�� ������ �ּ��� : ");
			String select = scan.nextLine();
			System.out.println();
			switch (select) {
			case "1": // �޴� Ȯ��
				viewMenu();
				break;
			case "2": // �α���
				System.out.println("1: ȸ�� | 2: ������");
				System.out.println("0: ����");
				System.out.print("��ȣ�� �������ּ��� : ");
				String select1 = scan.nextLine();
				System.out.println();
				switch (select1) {
				case "1":
					login = userSystem.signIn();
					if (!login) {
						start();
					} else {
						startUser();
					}
					break;
				case "2":
					pizzaFactory.signIn();
					break;
				case "0": // ����
					break;
				default:
					System.out.println("�߸��� �Է°��Դϴ�.\n");
				}
				break;
			case "3": // ȸ������
				userSystem.register();
				break;
			case "0":
				System.out.println("�����մϴ�. �� �湮���ּ���~");
				System.exit(0);
				break;
			default:
				System.out.println("�߸��� �Է°��Դϴ�.\n");
			}
		}
	}

	// ȸ���� �ʱ� ȭ��
	private void startUser() {
		Calendar nowTime = Calendar.getInstance(Locale.KOREA);
		System.out.println("���� ������ ���� �Բ� ���� ������ �ݰ����ϴ�~!");
		pizzaFactory.getTime();
		System.out.println();
		UserSystem userSystem = new UserSystem();
		while (true) {
			System.out.println("[*** Main Home ***]");
			System.out.println("1. �޴� | 2. ��ٱ��� | 3. �α׾ƿ� | 4. ȸ�� Ż��");
			System.out.print("��ȣ�� �������ּ��� : ");
			String select = scan.nextLine();
			System.out.println();
			switch (select) {
			case "1":
				int checkNumber = viewMenu(); // �޴� Ȯ��
				if (checkNumber == 0) {
					getRequest();
				}
				break;
			case "2": // ��ٱ���
				while (true) {
					if (pizzaFactory.dough > 0 && nowTime.after(pizzaFactory.getOpenInfo())
							&& nowTime.before(pizzaFactory.getCloseInfo()) && pizzaFactory.operatingHours) {
						int select1 = cart.viewCart();
						if (select1 == 1) { // ���� ����
							if (pizzaFactory.pizzaMap(cart.getCart())) {
								System.out.println("������ �Ϸ�Ǿ����ϴ�.\n");
								viewOrder(); // ���� ���� �����ֱ� + txt ���Ϸ� �����ϱ�
							}
							cart.emptyCart();
							break;
						} else if (select1 == -1) {
							break;
						}
					} else {
						System.out.println("������ �����Ǿ����ϴ�.");
						System.out.println("������ �ٽ� �湮�� �ּ���.");
						cart.emptyCart();
						break;
					}
				}
				break;

			case "3":
				login = false; // �α׾ƿ�
				start();
				break;

			case "4":
				if (userSystem.removeUser()) { // ȸ�� Ż�� ����
					start();
				}
				break;
			default:
				System.out.println("�߸��� �Է°��Դϴ�.");
				break;
			}
		}

	}

	// 1. �޴� Ȯ��
	private int viewMenu() {
		int returnNumber = 0;

		while (true) {
			if (login) {
				System.out.println("[�޴�]");
			}
			System.out.println("1. ���۷δ� ���� | 2. ���� ���� | 3. ������ ���� ");
			System.out.println("0. ���� ȭ��");
			if (login) {
				System.out.print("��ȣ�� �������ּ��� : ");
			}
			if (!login) {
				System.out.println("�ֹ��� ȸ�� ���� �� �̿��� �ּ���.\n");
				start();
			} else {
				returnNumber = selectMenu();
				break;
			}
		}

		return returnNumber;
	}

	// �޴� ����
	private int selectMenu() {

		int returnNumber = 0;
		String name = null;
		int tempCount = 0;

		while (tempCount == 0) {
			String select = scan.nextLine();
			System.out.println();

			switch (select) {
			case "1":
				name = "���۷δ� ����";
				tempCount = 1;
				break;
			case "2":
				name = "���� ����";
				tempCount = 1;
				break;
			case "3":
				name = "������ ����";
				tempCount = 1;
				break;
			case "0":
				startUser();
				break;
			default:
				System.out.println("�߸��� �Է°��Դϴ�.");
				System.out.print("�ٽ� �Է��� �ּ��� : ");
			}
		}

		String regex = "^[1-9]$";
		int count = 0;
		int countTry = 0;

		while (countTry < 3) {
			System.out.print("������ �Է��� �ּ��� (�ִ� ���� 9��) : ");
			String tmpCount = scan.nextLine();
			System.out.println();

			if (Pattern.matches(regex, tmpCount)) { // ����� �Է��� ���
				count = Integer.parseInt(tmpCount);
				countTry = 4;

				if (!(pizzaFactory.dough >= count)) { // �ֹ��Ϸ��� ���� ���� ���� ������� ���� ���
					System.out.println("�˼��մϴ�. ��� �����մϴ�.");
					countTry = 5;
					returnNumber = 1;
				}
			} else {
				System.out.println("�߸��� �Է°��Դϴ�.\n");
				countTry++;
			}
		}
		if (countTry == 4) { // ����ε� ������ �Է��� ��쿡�� ��ٱ��Ͽ� �ֱ�
			Map<String, Integer> tmpCart = cart.getCart();
			if (!tmpCart.containsKey(name)) {
				cart.addCart(name, count);
			} else {
				count += tmpCart.get(name);
				cart.setCart(name, count);
			}
			viewAddMenu();
		} else if (countTry == 5) { // ��� ������ ���

		} else {
			System.out.println("�߸��� �Է°��Դϴ�.\n");
		}

		return returnNumber;
	}

	// �߰� �޴� Ȯ��
	private void viewAddMenu() {
		System.out.println("[�߰� �޴� ����]");
		System.out.println("1: �ݶ� | 2: ��Ŭ | 3. �ּҽ� | 4. �߰� ����");
		System.out.println("0: ���� ȭ��");
		System.out.print("��ȣ�� ������ �ּ��� : ");
		selectAddMenu();
	}

	private void selectAddMenu() { // �߰� �޴� ����
		String select = scan.nextLine();
		System.out.println();
		boolean check = true;
		String name = null;

		while (check) {
			switch (select) {
			case "1":
				name = "�ݶ�";
				break;
			case "2":
				name = "��Ŭ";
				break;
			case "3":
				name = "�ּҽ�";
				break;
			case "4":
				check = false;
				break;
			case "0":
				startUser();
				break;
			default:
				System.out.println("�߸��� �Է°��Դϴ�.");
				System.out.println("�ٽ� �Է��� �ּ���.\n");
				System.out.println("1: �ݶ� | 2: ��Ŭ | 3. �ּҽ� | 4. �߰� ����");
				System.out.println("0: ���� ȭ��");
				System.out.print("��ȣ�� ������ �ּ��� : ");
				selectAddMenu();
			}
			int count = 0;
			int countTry = 0;

			while (countTry < 3) {
				if (check) {
					System.out.print("������ �Է��� �ּ��� (�ִ� ���� 9��) : ");
					String tmp_count = scan.nextLine();
					System.out.println();

					String regex = "^[1-9]$";

					if (Pattern.matches(regex, tmp_count)) {
						count = Integer.parseInt(tmp_count);

						Map<String, Integer> tmpCart = cart.getCart();
						if (!tmpCart.containsKey(name)) {
							cart.addCart(name, count);
						} else {
							count += tmpCart.get(name);
							cart.setCart(name, count);
						}
						check = false;
						countTry = 4;
					} else {
						System.out.println("�߸��� �Է°��Դϴ�.\n");
						countTry++;
					}

				} else {
					break;
				}
			}
		}
		while (true) {
			System.out.println("�߰� �޴��� �� �����Ͻðڽ��ϱ�?");
			System.out.println("1: �� | 2: �ƴϿ�");
			System.out.print("��ȣ�� ������ �ּ��� : ");
			String select2 = scan.nextLine();
			System.out.println();

			if (select2.equals("1")) {
				viewAddMenu();
				break;
			} else if (select2.equals("2")) {
				check = false;
				break;
			} else {
				System.out.println("�߸��� �Է°��Դϴ�.\n");
			}
		}
	}

	// �䱸����
	private void getRequest() {
		boolean check = true;
		while (check) {
			System.out.print("�䱸������ �Է����ּ���(�ִ� 100��) : ");
			request = scan.nextLine();
			System.out.println();
			String regex = "^.*{0,100}$";
			if (request.matches(regex)) {
				takeOut = viewTakeOut();
				check = false;
			} else {
				System.out.println("�߸��� �Է°��Դϴ�.\n");
			}
		}

	}

	// ����ũ �ƿ� ���� Ȯ��
	private int viewTakeOut() {

		System.out.println("�Ļ��Ͻ� ��Ҹ� �������ּ���.");
		System.out.println("1. ���忡�� �Ļ� | 2. ����ũ �ƿ�");
		System.out.print("��ȣ�� �������ּ���: ");

		boolean check = true;
		int count = 0;

		while (check) {
			String select = scan.nextLine();
			System.out.println();
			switch (select) {
			case "1":
				System.out.println("[���忡�� �Ļ�]�� �����Ͽ����ϴ�.\n");
				count = 1;
				check = false;
				break;
			case "2":
				System.out.println("[����ũ �ƿ�]�� �����Ͽ����ϴ�.\n");
				count = 2;
				pizzaFactory.box--; // ���� �ڽ� ��� ���̱�
				check = false;
				break;
			default:
				System.out.println("�߸��� �Է°��Դϴ�.");
				System.out.print("��ȣ�� �������ּ���: ");
			}
		}

		System.out.println("��ٱ��Ͽ��� ������ �Ϸ����ּ���.\n");
		return count;
	}

	// �ֹ� ���� Ȯ�� + ����
	private void viewOrder() {
		Map<String, Integer> tempCart = cart.getCart();

		int price = 0;
		String salesFilename = "TotalSales.txt";
		String priceFilename = "PriceSales.txt";
		calendar = Calendar.getInstance(Locale.KOREA);

		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		FileWriter fileWriter1 = null;
		BufferedWriter bufferedWriter1 = null;

		System.out.println("[�ֹ�����]");

		for (Entry<String, Integer> entry : tempCart.entrySet()) {
			switch (entry.getKey()) {
			case "������ ����":
				price = entry.getValue() * pizzaFactory.getShrimpPizzaPrice();
				break;
			case "���� ����":
				price = entry.getValue() * pizzaFactory.getSweetPotatoPizzaPrice();
				break;
			case "���۷δ� ����":
				price = entry.getValue() * pizzaFactory.getPepperoniPizzaPrice();
				break;
			case "�ݶ�":
				price = entry.getValue() * pizzaFactory.getCoke();
				break;
			case "��Ŭ":
				price = entry.getValue() * pizzaFactory.getPickle();
				break;
			case "�ּҽ�":
				price = entry.getValue() * pizzaFactory.getHotsauce();
				break;
			}
			String priceOutPut = "[" + entry.getKey() + "] " + entry.getValue() + "��, ���� : " + price + " / " + "�ֹ��ð� : "
					+ (calendar.get(Calendar.MONTH) + 1) + "�� " + (calendar.get(Calendar.DAY_OF_MONTH)) + "�� - "
					+ (calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + ":"
							+ calendar.get(Calendar.SECOND));
			System.out.println(priceOutPut + "\n");
			totalPrice += price;
			String totalPriceString = String.valueOf(totalPrice);

			try {
				fileWriter = new FileWriter(salesFilename, true);
				bufferedWriter = new BufferedWriter(fileWriter);

				fileWriter1 = new FileWriter(priceFilename, false);
				bufferedWriter1 = new BufferedWriter(fileWriter1);

				bufferedWriter.write(priceOutPut);
				bufferedWriter1.write(totalPriceString);

				bufferedWriter.newLine();
				bufferedWriter1.newLine();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					bufferedWriter.close();
					fileWriter.close();
					bufferedWriter1.close();
					fileWriter.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}

		}

	}

	public int getTakeOut() {
		return takeOut;
	}

}