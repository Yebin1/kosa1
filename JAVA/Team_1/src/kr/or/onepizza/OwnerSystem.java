package kr.or.onepizza;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class OwnerSystem {

	private Scanner scan;
	private Map<String, User> userList;
	Calendar openInfo; // ���� �ð� �ȳ�
	Calendar closeInfo; // ���� �ð� �ȳ�
	boolean operatingHours; // ���� ���� Ȯ��

	private File salesFile;
	private File memberFile;

	private int shrimpPizzaPrice = 20000;
	private int sweetPotatoPizzaPrice = 15000;
	private int pepperoniPizzaPrice = 12000;
	private int coke = 1000;
	private int pickle = 500;
	private int hotsauce = 300;

	// ��� (�Ϸ� ���귮 �� 100������ �������� ��)
	static int box; // �ڽ�
	static int dough; // ����
	static int tomatoSauce; // �丶�� �ҽ�
	static int mustardSauce; // �ӽ�Ÿ�� �ҽ�
	static int mayoneseSauce; // ������� �ҽ�
	static int cheese; // ġ��
	static int shrimp; // ������ ����
	static int bacon; // ������ ����
	static int pepperoni; // ���۷δ� ����
	static int sweetPotato; // ���� ����
	static int onion; // ���� ����
	static int mushroom; // ���� ����
	static int sweetCorn; // ������ ����
	static int parsley; // �Ľ��� ����

	public OwnerSystem() {
		scan = new Scanner(System.in);
		userList = new HashMap<String, User>();
		openInfo = Calendar.getInstance(Locale.KOREA);
		openInfo.set(Calendar.HOUR_OF_DAY, 11);
		openInfo.set(Calendar.MINUTE, 00);
		openInfo.set(Calendar.SECOND, 00);

		salesFile = new File("TotalSales.txt");
		memberFile = new File("Member.txt");

		closeInfo = Calendar.getInstance(Locale.KOREA);
		closeInfo.set(Calendar.HOUR_OF_DAY, 23);
		closeInfo.set(Calendar.MINUTE, 00);
		closeInfo.set(Calendar.SECOND, 00);
		operatingHours = false;
	}

	// ������ �ʱ� ȭ��
	private void start() {

		boolean returnValue = true;

		while (returnValue) {
			System.out.println("���� ���� ��Ȳ : " + operatingHours + "\n");
			System.out.println("[������ �޴�]");
			System.out.println("1. ���� Ȯ�� | 2. ȸ�� ���� | 3. ����/���� | 4. ��� Ȯ��");
			System.out.println("0. ���� ȭ��"); // ȸ��, ������ �����ϴ� ȭ��
			System.out.print("��ȣ�� ������ �ּ���: ");
			String select = scan.nextLine();
			System.out.println();
			switch (select) {
			case "1": // ���� Ȯ��
				viewSales();
				break;
			case "2": // ȸ�� ����
				userManagement();
				break;
			case "3": // ���� ���� (���� ���� �ð�)
				viewSetTime();
				break;
			case "4": // ��� Ȯ��
				System.out.println(viewStock());
				break;
			case "0":
				System.out.println("���� ȭ������ ���ư��ϴ�.\n");
				returnValue = false;
				break;
			default:
				System.out.println("�߸��� �Է°��Դϴ�.\n");

			}
		}
	}

	// ���� �� �ֹ� ���� Ȯ�� �޴�
	private void viewSales() {

		boolean check = true;
		while (check) {

			System.out.println("1: ���� ���� Ȯ�� | 2: �Ϻ� ���� Ȯ�� | 3: �� �ֹ� ���� Ȯ��");
			System.out.println("0: ����");
			System.out.print("��ȣ�� ������ �ּ���: ");
			String select = scan.nextLine();
			System.out.println();

			switch (select) {
			case "1":
				monthlySales();
				check = false;
				break;
			case "2":
				dailySales();
				check = false;
				break;
			case "3":
				nowViewSales();
				check = false;
				break;
			case "0":
				check = false;
				break;
			default:
				System.out.println("�߸��� �Է°��Դϴ�.\n");
			}
		}
	}

	// �� ���� Ȯ��
	private void nowViewSales() {
		String filename = "TotalSales.txt";

		FileReader fileReader = null;
		BufferedReader bufferedReader = null;

		if (!salesFile.exists()) {
			System.out.println("���� ������ �����ϴ�.\n");
		} else {
			try {
				fileReader = new FileReader(filename);
				bufferedReader = new BufferedReader(fileReader);
				String line = ""; // ���� ������ ó��
				for (int i = 0; (line = bufferedReader.readLine()) != null; i++) {
					System.out.println(line);
				}

			} catch (Exception e) {
				e.getMessage();
			} finally {
				try {

					bufferedReader.close();
					fileReader.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
	}

	// �Ϻ� ���� Ȯ��
	private void dailySales() {
		System.out.print("������ ���� �Է��� �ּ��� : ");
		String month = scan.nextLine();
		System.out.println();
		System.out.print("������ ���� �Է��� �ּ��� : ");
		String day = scan.nextLine();
		System.out.println();
		System.out.println();
		int plus = 0;
		String price = null;
		List<String> list = new ArrayList<String>();
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader("TotalSales.txt"));
			String textLine;
			String[] splitLine = new String[15];
			while ((textLine = bufferedReader.readLine()) != null) {
				splitLine = textLine.split("\\s+");

				if (splitLine[9].equals(month + "��") && splitLine[10].equals(day + "��")) {
					if (splitLine[1].equals("����]")) {
						price = splitLine[5];
						list.add(price);
					} else {
						price = splitLine[4];
						list.add(price);
					}
				} else if (splitLine[8].equals(month + "��") && splitLine[9].equals(day + "��")) {
					if (splitLine[1].equals("����]")) {
						price = splitLine[5];
						list.add(price);
					} else {
						price = splitLine[4];
						list.add(price);
					}
				} else {
					System.out.println("�߸��� �Է°��Դϴ�.\n");
				}

			}
			for (String i : list) { // ���ݸ� ���
				int j = Integer.parseInt(i);
				plus += j;

			}
			System.out.println(plus + "��");

		} catch (Exception e) {
			e.getMessage();
		} finally {
			try {
				bufferedReader.close();
			} catch (Exception e2) {
				e2.getMessage();
			}
		}

	}

	// ���� ���� Ȯ��
	private void monthlySales() {
		System.out.print("������ ���� �Է��� �ּ��� : ");
		String month = scan.nextLine();
		int plus = 0;
		String price = null;
		List<String> list = new ArrayList<String>();
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new FileReader("TotalSales.txt"));
			String textLine; // ���� ������
			String[] splitLine = new String[15];
			while ((textLine = bufferedReader.readLine()) != null) {
				splitLine = textLine.split("\\s+");

				if (splitLine[9].equals(month + "��")) {
					if (splitLine[1].equals("����]")) {
						price = splitLine[5];
						list.add(price);
					} else {
						price = splitLine[4];
						list.add(price);
					}
				} else if (splitLine[8].equals(month + "��")) {
					if (splitLine[1].equals("����]")) {
						price = splitLine[5];
						list.add(price);
					} else {
						price = splitLine[4];
						list.add(price);
					}
				} else {
					System.out.println("�߸��� �Է°��Դϴ�.");
				}
			}
			for (String i : list) { // ���ݸ� ���
				int j = Integer.parseInt(i);
				plus += j;

			}
			System.out.println(plus + "��");

		} catch (Exception e) {
			e.getMessage();
		} finally {
			try {
				bufferedReader.close();
			} catch (Exception e2) {
				e2.getMessage();
			}
		}
	}

	// ���� �ð�, ���� �ð� ����
	private void viewSetTime() {
		boolean check = true;
		while (check) {
			System.out.println("1. ����/���� �ð� ���� | 2. ����/���� �ð� ���� | 3. �����ϱ� | 4. �����ϱ�");
			System.out.println("0: ����");
			System.out.print("��ȣ�� ������ �ּ���: ");
			String select = scan.nextLine();
			System.out.println();
			switch (select) {
			case "1": // ����/���� �ð� �ȳ� ����
				setTime();
				check = false;
				break;
			case "2": // ����/���� �ð� �ȳ� ����
				getTime();
				check = false;
				break;
			case "3": // �����ϱ�
				open();
				check = false;
				break;
			case "4": // �����ϱ�
				close();
				check = false;
				break;
			case "0": // ����
				check = false;
				break;
			default:
				System.out.println("�߸��� �Է°��Դϴ�.\n");
			}
		}

	}

	// �����ϱ�
	private void open() {
		operatingHours = true;
		box = 100; // �ڽ�
		dough = 100; // ����
		tomatoSauce = 100; // �丶�� �ҽ�
		mustardSauce = 100; // �ӽ�Ÿ�� �ҽ�
		mayoneseSauce = 100; // ������� �ҽ�
		cheese = 100; // ġ��
		shrimp = 800; // ������ ����
		bacon = 1000; // ������ ����
		pepperoni = 2000; // ���۷δ� ����
		sweetPotato = 200; // ���� ����
		onion = 100; // ���� ����
		mushroom = 300; // ���� ����
		sweetCorn = 100; // ������ ����
		parsley = 100; // �Ľ��� ����

		System.out.println("���� ���� �Ϸ�");
		System.out.println("��� ���� �Ϸ�\n");
	}

	// �����ϱ�
	private void close() {
		operatingHours = false;
		System.out.println("���� ���� �Ϸ�\n");
	}

	// ���� �����ϱ�
	private boolean inNumeric(String innumeric) {
		return innumeric.replaceAll("[+-]?\\d+", "").equals("") ? true : false;
	}

	// ����/���� �ð� ����
	private void setTime() {
		int hour = 0;
		int minute = 0;
		boolean check = true;
		SimpleDateFormat simpleDataFormat = new SimpleDateFormat("hh�� mm��");

		while (check) {
			System.out.println("1. ���� �ð� ���� | 2. ���� �ð� ����");
			System.out.println("0. ������ ����");
			System.out.print("��ȣ�� ������ �ּ���: ");
			String select = scan.nextLine();
			System.out.println();

			switch (select) {
			case "1":
				System.out.print("�����ϰ��� �ϴ� �ð�(00~23)�� �Է��ϼ��� : ");
				String tempOpenHour = scan.nextLine();
				System.out.println();

				if (inNumeric(tempOpenHour)) {
					hour = Integer.parseInt(tempOpenHour);
					if (hour >= 00 && hour <= 23) {
						openInfo.set(Calendar.HOUR_OF_DAY, hour);
					} else {
						System.out.println("�߸��� �Է°��Դϴ�.\n");
						break;
					}
				} else {
					System.out.println("�߸��� �Է°��Դϴ�.\n");
					break;
				}
				System.out.print("�����ϰ��� �ϴ� ��(00~59)�� �Է��ϼ��� : ");
				String tempOpenMinute = scan.nextLine();
				System.out.println();

				if (inNumeric(tempOpenMinute)) {
					minute = Integer.parseInt(tempOpenMinute);
					if (minute >= 00 && minute <= 59) {
						openInfo.set(Calendar.MINUTE, minute);
						openInfo.set(Calendar.SECOND, 00);
					} else {
						System.out.println("�߸��� �Է°��Դϴ�.\n");
						break;
					}
				} else {
					System.out.println("�߸��� �Է°��Դϴ�.\n");
					break;
				}

				if (closeInfo.after(openInfo)) {
					System.out.println("���� �ð��� �����Ǿ����ϴ�.");
					System.out.println(simpleDataFormat.format(openInfo.getTime()));
					check = false;
				} else {
					System.out.println("���� �ð��� ���� �ð����� �����ϴ�.");
					System.out.println("�ٽ� �����ϼ���.\n");
					closeInfo.set(Calendar.HOUR_OF_DAY, 11);
					closeInfo.set(Calendar.MINUTE, 00);
					closeInfo.set(Calendar.SECOND, 00);
				}
				break;
			case "2":
				System.out.print("�����ϰ��� �ϴ� �ð�(00~24)�� �Է��ϼ��� : ");
				String tempCloseHour = scan.nextLine();
				System.out.println();

				if (inNumeric(tempCloseHour)) {
					hour = Integer.parseInt(tempCloseHour);
					if (hour >= 00 && hour <= 24) {
						closeInfo.set(Calendar.HOUR_OF_DAY, hour);
					} else {
						System.out.println("�߸��� �Է°��Դϴ�.\n");
						break;
					}
				} else {
					System.out.println("�߸��� �Է°��Դϴ�.\n");
					break;
				}

				System.out.print("�����ϰ��� �ϴ� ��(00~59)�� �Է��ϼ��� : ");
				String tempCloseMinute = scan.nextLine();
				System.out.println();

				if (inNumeric(tempCloseMinute)) {
					if (minute >= 00 && minute <= 59) {
						closeInfo.set(Calendar.MINUTE, minute);
						closeInfo.set(Calendar.SECOND, 00);
					} else {
						System.out.println("�߸��� �Է°��Դϴ�.\n");
						break;
					}
				} else {
					System.out.println("�߸��� �Է°��Դϴ�.\n");
					break;
				}

				if (openInfo.before(closeInfo)) {
					System.out.println("���� �ð��� �����Ǿ����ϴ�.");
					System.out.println(simpleDataFormat.format(closeInfo.getTime()));
					check = false;
				} else {
					System.out.println("���� �ð��� ���� �ð����� �����ϴ�.");
					System.out.println("�ٽ� �����ϼ���.\n");
					closeInfo.set(Calendar.HOUR_OF_DAY, 23);
					closeInfo.set(Calendar.MINUTE, 00);
					closeInfo.set(Calendar.SECOND, 00);
				}
				break;
			case "0":
				check = false;
				break;
			default:
				System.out.println("�߸��� �Է°��Դϴ�.\n");
			}
		}

	}

	// ���� �ð�, ���� �ð� ���
	public void getTime() {
		System.out.println(
				"���� ���� ���� �ð� �ȳ�: " + openInfo.get(Calendar.HOUR_OF_DAY) + "�� " + openInfo.get(Calendar.MINUTE) + "��");
		System.out.println("���� ���� ���� �ð� �ȳ�: " + closeInfo.get(Calendar.HOUR_OF_DAY) + "�� "
				+ closeInfo.get(Calendar.MINUTE) + "��\n");
	}

	// ȸ�� ���� ȭ��
	private void userManagement() {

		boolean check = true;

		while (check) {
			System.out.println("1. ȸ�� ����Ʈ | 2. ȸ�� ����");
			System.out.println("0. ���� ȭ��");
			System.out.print("��ȣ�� ������ �ּ���: ");
			String select = scan.nextLine();
			System.out.println();
			switch (select) {
			case "1":
				viewUserList();
				break;
			case "2":
				removeUser();
				break;
			case "0":
				check = false;
				break;
			default:
				System.out.println("�߸��� �Է°��Դϴ�.\n");
			}
		}

	}

	// ȸ�� ����Ʈ
	private void viewUserList() {
		String file = "Member.txt";
		FileInputStream fileInputStream = null;
		ObjectInputStream objectInputStream = null;

		if (!memberFile.exists()) {
			System.out.println("ȸ���� �����ϴ�.\n");
		} else {
			try {
				fileInputStream = new FileInputStream(file);
				objectInputStream = new ObjectInputStream(fileInputStream);

				userList = (HashMap) objectInputStream.readObject();

				Set<String> set = userList.keySet();
				for (String string : set) {
					String emailid = userList.get(string).getEmailId();
					String password = userList.get(string).getPassword();
					String phonenumber = userList.get(string).getPhoneNumber();
					String address = userList.get(string).getAddress();

					System.out.printf("%s\t%s\t%s\t%s\n\n", emailid, password, phonenumber, address);
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					objectInputStream.close();
					fileInputStream.close();
				} catch (Exception e2) {
					e2.getMessage();
				}
			}
		}
	}

	// ȸ�� ����
	private void removeUser() {
		String file = "Member.txt";
		if (!memberFile.exists()) {
			System.out.println("ȸ���� �����ϴ�.\n");
		} else {
			System.out.print("�����Ͻ� Email-Id�� �Է����ּ��� : ");
			String emailId = scan.nextLine();
			System.out.println();

			FileInputStream fileInputStream = null;
			BufferedInputStream bufferedInputStream = null;
			ObjectInputStream objectInputStream = null;
			FileOutputStream fileOutputStream = null;
			BufferedOutputStream bufferedOutputStream = null;
			ObjectOutputStream objectOutputStream = null;

			try {
				fileInputStream = new FileInputStream(file);
				bufferedInputStream = new BufferedInputStream(fileInputStream);
				objectInputStream = new ObjectInputStream(bufferedInputStream);

				userList = (HashMap) objectInputStream.readObject();

				if (userList.containsKey(emailId)) {
					userList.remove(emailId);
					System.out.println(emailId + "-> �ش� ���̵�� ���������� �����Ǿ����ϴ�.\n");
				} else {
					System.out.println("�ش� ���̵� �����ϴ�. ȸ�� ���� �ý������� ���ư��ϴ�.\n");
					viewUserList();
				}

				fileOutputStream = new FileOutputStream(file);
				bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
				objectOutputStream = new ObjectOutputStream(bufferedOutputStream);

				objectOutputStream.writeObject(userList);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					objectOutputStream.close();
					bufferedOutputStream.close();
					fileOutputStream.close();
					objectInputStream.close();
					bufferedInputStream.close();
					fileInputStream.close();
				} catch (Exception e2) {
					System.out.println(e2.getMessage());
				}
			}
		}

	}

	// �α���
	public void signIn() {
		Owner owner = new Owner();
		int countId = 0;
		int countPassword = 0;

		while (countId < 3) {
			System.out.println("0: ����");
			System.out.print("������ ���̵�: ");
			String ownerId = scan.nextLine();
			System.out.println();

			if (ownerId.equals(owner.getId())) { // ����� �Է��� ���

				// �α��� Ƚ�� 3ȸ ����
				while (countPassword < 3) {
					System.out.print("������ ��й�ȣ: ");
					String ownerPassword = scan.nextLine();
					System.out.println();
					if (ownerPassword.equals(owner.getPassword())) {
						System.out.println("�α��ο� �����Ͽ����ϴ�.\n");
						start(); // �����ڿ� ���� ȭ������ ����
						countPassword = 4;
						countId = 4;
					} else if (ownerPassword.equals("0")) {
						countPassword = 5;
					} else {
						System.out.println("��й�ȣ�� Ȯ���� �ּ���.\n");
						countPassword++;
						if (countPassword >= 3) {
							System.out.println("�α��� �õ� Ƚ���� �ʰ��Ͽ����ϴ�.");
							System.out.println("���� ȭ������ ���ư��ϴ�.\n");
							countId = 4;
						}
					}
				}
			} else if (ownerId.equals("0")) {
				countId = 5;
			} else {
				System.out.println("�������� �ʴ� ���̵��Դϴ�.\n");
				countId++;
				if (countId >= 3) {
					System.out.println("���� ȭ������ ���ư��ϴ�.\n");
				}
			}
		}
	}

	// ��� ��� ��Ȳ ����
	private String viewStock() {

		return "<��� ��� ��Ȳ ����> \n box =\t\t" + box + "\n dough =\t" + dough + "\n tomatoSauce = \t" + tomatoSauce
				+ "\n cheese =\t" + cheese + "\n shrimp =\t" + shrimp + "\n bacon =\t" + bacon + "\n pepperoni =\t"
				+ pepperoni + "\n sweetPotato =\t" + sweetPotato + "\n onion =\t" + onion + "\n";
	}

	public int getShrimpPizzaPrice() {
		return shrimpPizzaPrice;
	}

	public int getSweetPotatoPizzaPrice() {
		return sweetPotatoPizzaPrice;
	}

	public int getPepperoniPizzaPrice() {
		return pepperoniPizzaPrice;
	}

	public int getCoke() {
		return coke;
	}

	public int getPickle() {
		return pickle;
	}

	public int getHotsauce() {
		return hotsauce;
	}

	public boolean isOperatingHours() {
		return operatingHours;
	}

	public Calendar getOpenInfo() {
		return openInfo;
	}

	public Calendar getCloseInfo() {
		return closeInfo;
	}

}