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
		
		// 1. Array를 사용하여 tv, audio, notebook을 담을 수 있는 cart 배열 생성 후 제품 담기
		Product[] cart = new Product[3];
		cart[0] = new KtTv();
		cart[1] = new Audio();
		cart[2] = new NoteBook();
		
		// 2. ArrayList Generic 사용하여 cart 배열 생성 후 제품 담기
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
		
		// 3. Emp 클래스 (kr.or.kosa) ArrayList Generic 사용하여 사원 3명 만들기
		ArrayList<Emp> emplist = new ArrayList<Emp>();
		emplist.add(new Emp(1000, "김씨", "IT"));
		emplist.add(new Emp(2000, "박씨", "SALES"));
		emplist.add(new Emp(3000, "이씨", "MANAGER"));
		
		// 3-1. toString() 사용하지 않고 개선된 for문으로 사원의 정보(사번, 이름, 직종) 출력하기
		for (Emp emp: emplist) {
			System.out.println(emp.getEmpno() + " / " + emp.getEname() + " / " + emp.getJob());
		}
		
		System.out.println("------------------------------------");
		
		// 3-2. 위와 동일, 일반 for문 사용할 것
		for (int i = 0; i < emplist.size(); i++) {
			System.out.println(emplist.get(i).getEmpno() + " / " + emplist.get(i).getEname() + " / " + emplist.get(i).getJob());
		}
		
		
		List<CopyEmp> clist = new ArrayList<CopyEmp>();
		clist.add(new CopyEmp(100, "김씨", 1000));
		clist.add(new CopyEmp(200, "이씨", 2000));
		clist.add(new CopyEmp(300, "박씨", 5000));
		
		System.out.println("------------------------------------");
		
		// 1. 200번 사원의 급여를 6000으로 수정 (일반 for문 사용)
		for (int i = 0; i < clist.size(); i++) {
			if (clist.get(i).getEmpno() == 200) {
				clist.get(i).setSal(6000);
				System.out.println(clist.get(i).toString());
			}
		}
		
		
		// 2. 300번 사원의 이름을 '궁금해씨'로 수정 후 결과 출력 (개선된 for문 사용)
		for (CopyEmp emp: clist) {
			if (emp.getEmpno() == 300) {
				emp.setEname("궁금해씨");
				System.out.println(emp);
			}
		}
		
		
	}

}
