import java.util.ArrayList;
import kr.or.kosa.Emp;

// 0908

public class Ex03_ArrayList_Object {

	public static void main(String[] args) {
		
		// 1. ��� 1��
		Emp emp = new Emp(1000, "������", "�屺");
		System.out.println(emp.toString());
		
		System.out.println("-----------------------------------");

		// 2. ��� 2�� ����� array
		Emp[] emplist = {new Emp(100, "�达", "����"), new Emp(200, "�ھ�", "IT")};
		for (Emp e: emplist) {
			System.out.println(e.toString());
		}
		
		System.out.println("-----------------------------------");
		
		// 3. ��� 1���� �Ի��� (300, "�̾�", "IT")
		// �� 3��¥�� �迭 ������ �̻�... >> ������
		// ArrayList
		ArrayList elist = new ArrayList();
		elist.add(new Emp(100, "�达", "����"));
		elist.add(new Emp(200, "�ھ�", "IT"));
		elist.add(new Emp(300, "�̾�", "IT"));
		for (int i = 0; i < elist.size(); i++) {
			System.out.println(elist.get(i));
			
			/* Emp e = (Emp)elist.get(i);
			e.toString(); */
		}

		System.out.println("-----------------------------------");

		elist.add(new Emp(400, "�־�", "����"));
		for (int i = 0; i < elist.size(); i++) {
			System.out.println(elist.get(i).toString());
		}
		
		System.out.println("-----------------------------------");

		// toString() ���X
		// 4�� ����� ���, �̸�, ���� ���
		// for�� ������ getEmpno(), getEname(), getJob() ���
		
		for (int i = 0; i < elist.size(); i++) {
			Object obj = elist.get(i);
			// obj.toString();
			// Object�� ��� Ÿ���� �θ� Ÿ���̴� >> downcasting
			Emp e = (Emp) obj;
			System.out.println(e.getEmpno() + ", " + e.getEname() + ", " + e.getJob());
		}
		
		// ���� ������ >> Object Ÿ�� >> �׻� �ٿ�ĳ���� ... �ڽ� ��� ����
		// Object ������� ����
		// Ÿ�� ���� (�ش� Ÿ�Ը� ������) �ϳ��� Ÿ�Ը��� ������ �����͸� ����
		// ���ʸ� (��ü ������ Ÿ�� �����ϴ� ���)
		ArrayList<Emp> list2 = new ArrayList<Emp>();
		// list2.add(emp);
		list2.add(new Emp(1, "A", "IT"));
		for (Emp e: list2) {
			System.out.println(e.getEmpno());
		}
		

	}

}
