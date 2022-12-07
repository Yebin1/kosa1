import java.util.HashMap;
import java.util.Scanner;

// 0913


public class Ex14_Map_Quiz {

	public static void main(String[] args) {
		
		// Map ��� ���� ������ ����
		// ���� ��ȣ, ���� ��ȣ, ȸ�� ����(id, pwd) ����
		
		HashMap loginmap = new HashMap();
		loginmap.put("kim", "kim1004");
		loginmap.put("scott", "tiger");
		loginmap.put("lee", "kim1004");
		
		/*
		�츮 �ý����� ������ ȸ���� id, pwd ������ ������ �ִ�
		�α��ν� id, pwd�� Ȯ���Ͽ� ȸ���̶�� ����Ʈ�� ���� �����ϴ�
		
		id(O), pwd(O) >> ȸ���� �氡�氡 ���, while�� Ż��
		id(O), pwd(X) >> ��й�ȣ�� Ȯ���� �ּ��� (���Է�)
		id(X), pwd(O) / id(X), pwd(X) >> id ���Է��ϼ��� ���, ���̵�� ��й�ȣ �Է� �޵���
		*/
		
		Scanner scan = new Scanner(System.in);
		
		while (true) {
			
			System.out.println("���̵�� ��й�ȣ�� �Է��ϼ���.");
			String id = scan.nextLine().trim().toLowerCase();
			String pwd = scan.nextLine().trim();
			
			if (!loginmap.containsKey(id)) {
				System.out.println("id�� �������� �ʽ��ϴ�. �ٽ� �Է����ּ���.");
			} else {
				if (loginmap.get(id).equals(pwd)) {
					System.out.println("ȸ���� �氡�氡");
					break;
				} else {
					System.out.println("��й�ȣ�� Ȯ�����ּ���.");
				}
			}
			
			
			
			/*
			// id, pwd scan
			System.out.println("���̵�� ��й�ȣ�� �Է��ϼ���.");
			String id = scan.nextLine();
			String pwd = scan.nextLine();
			id.replace(" ","");
			pwd.replace(" ","");
			
			for (int i = 0; i < loginmap.size(); i++) {
				if (id.equals(loginmap.get(id))) {
					if (pwd.equals(loginmap.get(pwd))) {
					System.out.println("ȸ���� �氡�氡");
					break;
					} else {
						System.out.println("��й�ȣ�� Ȯ�����ּ���.");
					}
				} else {
					System.out.println("���̵� �ٽ� �Է����ּ���.");
				}
			}
			*/
			// id: ���� ����, �ҹ��ڷ� ��ȯ >> String �Լ�
			// pwd: ���� ����
		}
	
		
	}

}
