import java.util.ArrayList;
import java.util.List;

import kr.or.kosa.CopyEmp;
import kr.or.kosa.Emp;

// 0913

class Product {
	int price;
	int bonuspoint;
	
	Product() {}
	Product(int price) {
		this.price = price;
		this.bonuspoint = (int) (this.price / 10.0);
	}
}

class KtTv extends Product {
	KtTv() {
	super(500);
	}
	
	@Override
	public String toString() {
		return "KtTv";
	}
}

class Audio extends Product {
	Audio() {
	super(100);
	}
		
	@Override
	public String toString() {
		return "Audio";
	}
}

class NoteBook extends Product {
	NoteBook() {
	super(150);
	}
		
	@Override
	public String toString() {
		return "NoteBook";
	}
}

public class Ex08_Generic_Quiz {
	
	
	public static void main(String[] args) {
		
		// 1. Array�� ����Ͽ� tv, audio, notebook�� ���� �� �ִ� cart �迭 ���� �� ��ǰ ���
		Product[] cart = new Product[3];
		cart[0] = new KtTv();
		cart[1] = new Audio();
		cart[2] = new NoteBook();
		
		// 2. ArrayList Generic ����Ͽ� cart �迭 ���� �� ��ǰ ���
		// ArrayList<Product> pcart = new ArrayList<Product>();
		List<Product> pcart = new ArrayList<Product>();
		pcart.add(new KtTv());
		pcart.add(new KtTv());
		pcart.add(new KtTv());
		pcart.add(new NoteBook());
		
		for (Product product: pcart) {
			System.out.println(product);
		}
		
		System.out.println("------------------------------------");
		
		// 3. Emp Ŭ���� (kr.or.kosa) ArrayList Generic ����Ͽ� ��� 3�� �����
		ArrayList<Emp> emplist = new ArrayList<Emp>();
		emplist.add(new Emp(1000, "�达", "IT"));
		emplist.add(new Emp(2000, "�ھ�", "SALES"));
		emplist.add(new Emp(3000, "�̾�", "MANAGER"));
		
		// 3-1. toString() ������� �ʰ� ������ for������ ����� ����(���, �̸�, ����) ����ϱ�
		for (Emp emp: emplist) {
			System.out.println(emp.getEmpno() + " / " + emp.getEname() + " / " + emp.getJob());
		}
		
		System.out.println("------------------------------------");
		
		// 3-2. ���� ����, �Ϲ� for�� ����� ��
		for (int i = 0; i < emplist.size(); i++) {
			System.out.println(emplist.get(i).getEmpno() + " / " + emplist.get(i).getEname() + " / " + emplist.get(i).getJob());
		}
		
		
		List<CopyEmp> clist = new ArrayList<CopyEmp>();
		clist.add(new CopyEmp(100, "�达", 1000));
		clist.add(new CopyEmp(200, "�̾�", 2000));
		clist.add(new CopyEmp(300, "�ھ�", 5000));
		
		System.out.println("------------------------------------");
		
		// 1. 200�� ����� �޿��� 6000���� ���� (�Ϲ� for�� ���)
		for (int i = 0; i < clist.size(); i++) {
			if (clist.get(i).getEmpno() == 200) {
				clist.get(i).setSal(6000);
				System.out.println(clist.get(i).toString());
			}
		}
		
		
		// 2. 300�� ����� �̸��� '�ñ��ؾ�'�� ���� �� ��� ��� (������ for�� ���)
		for (CopyEmp emp: clist) {
			if (emp.getEmpno() == 300) {
				emp.setEname("�ñ��ؾ�");
				System.out.println(emp);
			}
		}
		
		
	}

}
