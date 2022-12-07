package kr.or.onepizza;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class UserSystem {

	private Map<String, User> userList; // ���� ����Ʈ

	private Scanner scan;

	private String emailId;
	private String password;
	private String phoneNumber;
	private String address;
	private File memberFile;

	public UserSystem() {
		scan = new Scanner(System.in);
		userList = new HashMap<String, User>();
		memberFile = new File("Member.txt");
	}

	// ȸ������
	public void register() {

		String file = "Member.txt";

		email();

		System.out.print("��й�ȣ�� �Է��� �ּ��� : ");
		password = scan.nextLine();
		System.out.println();

		phoneNumber();

		System.out.print("�ּҸ� �Է��� �ּ��� : ");
		address = scan.nextLine();
		System.out.println();

		User user = new User(emailId, password, phoneNumber, address);

		userList.put(emailId, user);

		System.out.println(user.toString() + "\n");

		FileOutputStream fileOutputStream = null;
		BufferedOutputStream bufferedOutputStream = null;
		ObjectOutputStream objectOutputStream = null;

		try {
			fileOutputStream = new FileOutputStream(file);
			bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
			objectOutputStream = new ObjectOutputStream(bufferedOutputStream);

			objectOutputStream.writeObject(userList);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				objectOutputStream.close();
				bufferedOutputStream.close();
				fileOutputStream.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
	}

	// �̸��� �ּ� �Է�
	private void email() {

		if (!memberFile.exists()) {
			while (true) {
				System.out.print("�̸��� �ּҸ� �Է��� �ּ��� : ");
				emailId = scan.nextLine();
				System.out.println();
				String regex = "^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-z]+$";
				if (!Pattern.matches(regex, emailId)) {
					System.out.println("�̸��� ������ �߸��Ǿ����ϴ�.\n");
					email();
				}
				return;
			}
		} else {
			String file = "Member.txt";
			FileInputStream fileInputStream = null;
			BufferedInputStream bufferedInputStream = null;
			ObjectInputStream objectInputStream = null;

			try {
				fileInputStream = new FileInputStream(file);
				bufferedInputStream = new BufferedInputStream(fileInputStream);
				objectInputStream = new ObjectInputStream(bufferedInputStream);

				userList = (HashMap) objectInputStream.readObject();

				while (true) {
					System.out.print("�̸��� �ּҸ� �Է��� �ּ��� : ");
					emailId = scan.nextLine();
					System.out.println();
					String regex = "^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-z]+$";
					if (userList.containsKey(emailId)) {
						System.out.println("������ ���̵� �����մϴ�.\n");
						email();
					}
					if (!Pattern.matches(regex, emailId)) {
						System.out.println("�̸��� ������ �߸��Ǿ����ϴ�.\n");
						email();
					}
					return;
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					objectInputStream.close();
					bufferedInputStream.close();
					fileInputStream.close();
				} catch (Exception e2) {
					System.out.println(e2.getMessage());
				}
			}

		}

	}

	// �޴��� ��ȣ �Է�
	private void phoneNumber() {
		while (true) {
			System.out.print("�޴��� ��ȣ�� �Է����ּ���(- ����) : ");
			phoneNumber = scan.nextLine();
			System.out.println();
			String regex = "^01(?:0|1|[6-9])(?:\\d{3}|\\d{4})\\d{4}$";
			if (!Pattern.matches(regex, phoneNumber)) {
				System.out.println("�޴��� ��ȣ ������ �߸��Ǿ����ϴ�.\n");
				phoneNumber();
			}
			return;
		}
	}

	// �α���
	public boolean signIn() {
		boolean returnValue = true;

		if (!memberFile.exists()) {
			System.out.println("ȸ�����Ե� ������ �����ϴ�.");
			System.out.println("ȸ�������� �ּ���.\n");
			register();
			returnValue = false;
		} else {
			String memberList = "Member.txt";
			FileInputStream fileInputStream = null;
			BufferedInputStream bufferedInputStream = null;
			ObjectInputStream objectInputStream = null;

			try {
				fileInputStream = new FileInputStream(memberList);
				bufferedInputStream = new BufferedInputStream(fileInputStream);
				objectInputStream = new ObjectInputStream(bufferedInputStream);

				userList = (HashMap) objectInputStream.readObject();

				int count = 0;

				while (true) {
					System.out.println("0: ����");
					System.out.print("�̸��� ���̵�: ");
					String userId = scan.nextLine();
					System.out.println();

					if (userId.equals("0")) {
						returnValue = false;
						break;
					}

					if (count >= 3) {
						System.out.println("�α��� �õ� Ƚ���� �ʰ��Ͽ����ϴ�. ȸ�� �����Ͻðڽ��ϱ�?");
						System.out.println("1. �� | 2. �ƴϿ�");
						String select = scan.nextLine();
						if (select.equals("1")) {
							register();
							break;
						} else if (select.equals("2")) {
							returnValue = false; // Ʋ�� ��� start()��
							break;
						}
					}
					if (!userList.containsKey(userId)) {
						System.out.println("�������� �ʴ� ���̵��Դϴ�.\n");
						count++;
					} else {
						System.out.print("��й�ȣ: ");
						String userPassword = scan.nextLine();

						if (!userList.get(userId).getPassword().equals(userPassword)) {
							System.out.println("��й�ȣ�� Ȯ�����ּ���\n");
							count++;
						} else {
							System.out.println("�α��ο� �����Ͽ����ϴ�.\n");
							returnValue = true; // �α��� ���� startUser()
							break;
						}
					}
				}
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				try {
					objectInputStream.close();
					bufferedInputStream.close();
					fileInputStream.close();
				} catch (Exception e2) {
					System.out.println(e2);
				}
			}
		}
		return returnValue;
	}

	// ȸ�� Ż��
	public boolean removeUser() {

		boolean returnValue = false;
		int count = 0;

		String file = "Member.txt";

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
			fileOutputStream = new FileOutputStream(file);
			bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
			objectOutputStream = new ObjectOutputStream(bufferedOutputStream);

			userList = (HashMap<String, User>) objectInputStream.readObject();

			while (true) {
				if (count >= 3) {
					break;
				}
				System.out.print("ȸ�� Ż�� �Ͻ÷��� ���̵� �Է����ּ��� : ");
				String userId = scan.nextLine();
				System.out.println();
				if (!userList.containsKey(userId)) { // ���� ���̵� ���� ���
					System.out.println("�ش��ϴ� ���̵� ã�� �� �����ϴ�.\n");
					count++;
				} else {
					System.out.print("��й�ȣ�� �Է��� �ּ��� :");
					String userPassword = scan.nextLine();
					System.out.println();
					if (!userList.get(userId).getPassword().equals(userPassword)) {
						System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�.\n");
						count++;
					} else {
						userList.remove(userId);
						System.out.println("ȸ�� Ż�� �����Ͽ����ϴ�.\n");
						returnValue = true;
						break;
					}
				}
			}

			objectOutputStream.writeObject(userList);

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				objectOutputStream.close();
				bufferedOutputStream.close();
				fileOutputStream.close();
				objectInputStream.close();
				bufferedInputStream.close();
				fileInputStream.close();
			} catch (Exception e1) {
				System.out.println(e1);
			}
		}
		return returnValue;
	}

}
