import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 0908
// AllDay Point



public class Ex02_ArrayList {

	public static void main(String[] args) {
		// ArrayList: List �������̽� ���� (���� ����, �ߺ� ���)
		ArrayList arraylist = new ArrayList();
		// Object Ÿ������
		arraylist.add(100);
		arraylist.add(200);
		arraylist.add(300);
		
		for ( int i = 0; i < arraylist.size(); i++) {
			System.out.println(arraylist.get(i));
		}
		System.out.println(arraylist.toString());
		
		// add �Լ�: ���������� ������ �ֱ�
		arraylist.add(0, 111); // �ڸ� �̵�
		System.out.println(arraylist.toString());
		arraylist.add(4, 444);
		// ��������� �������� �߰� ������ ArraylList �ڷᱸ���� �������� �ʴ� >> ������ �ִ� ������ ������ ����
		// �������� ������ �߰�, ���� �뵵�� ���
		
		// arraylist.remove(111);
		// System.out.println(arraylist.toString());
		
		// [111, 100, 200, 300, 444]
		// ArrayList �Լ� ���� (�ʱ�)
		System.out.println(arraylist.contains(200));
		System.out.println(arraylist.contains(2000));
		
		arraylist.clear(); 	// ������ ���� (������ �����ִ�)
		System.out.println(arraylist.size());
		System.out.println(arraylist.isEmpty());	// true
		
		arraylist.add(101);
		arraylist.add(102);
		arraylist.add(103);
		System.out.println(arraylist.isEmpty()); 	// false
		System.out.println(arraylist.size());		// 3
		arraylist.remove(0);						// 01 ���� �� �ڸ� �ٲ�
		System.out.println(arraylist.toString());	
		
		// POINT
		// �������̽� �θ� Ÿ��
		// ������ ���������� .. ������ (Ȯ�强, ������)
		List li = new ArrayList();	// ���������� �θ� Ÿ���� �̿��� ������ ������
		li.add("��");
		li.add("��");
		li.add("��");
		li.add("��");
		
		List li2 = li.subList(0, 2); // subList �Լ��� ���������� new ArrayList() ����
		System.out.println(li2.toString());
		
		ArrayList alist = new ArrayList();
		alist.add(50);
		alist.add(1);
		alist.add(7);
		alist.add(40);
		alist.add(46);
		alist.add(3);
		alist.add(15);
		System.out.println(alist.toString());
		
		Collections.sort(alist);	// ������Ʈ�� ���� ����
		System.out.println(alist.toString());
		
		// �������� ����
		// �������� ���� �� �������ϱ�
		Collections.reverse(alist);
		System.out.println(alist.toString());

	}

}
