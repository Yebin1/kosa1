import kr.or.bit.Emp;

// 0830

public class Ex06_Array_Object {

	public static void main(String[] args) {
		
		/*
		��� 3���� ����
		��� ����
		1. 1000, ȫ�浿
		2. 2000, ������
		3. 3000, ������
		���� �� ����� �̸� ���
		*/
		
		// 1
		Emp[] emplist = new Emp[3];
		emplist[0] = new Emp(1000, "ȫ�浿");
		emplist[1] = new Emp(2000, "������");
		emplist[2] = new Emp(3000, "������");
		/*
		for(int i = 0; i < emplist.length; i++) {
			emplist[i].empInfoPrint();
		}
		*/
		// 2
		Emp[] emplist2 = new Emp[] {new Emp(1000, "ȫ�浿"), new Emp(2000, "������"), new Emp(3000, "������")};
		
		// 3
		Emp[] emplist3 = {new Emp(1000, "ȫ�浿"), new Emp(2000, "������"), new Emp(3000, "������")};
		for (Emp e: emplist3) {
			e.empInfoPrint();
		}

	}

}
