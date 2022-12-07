import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/* 0913

Collection FrameWork
������ �������̽��� �װ��� �����ϰ� �ִ� ������ Ŭ������ ����

Iterator �������̽� (�ݺ���)
������ �ڿ��� ���� ���������� �����Ͽ� ���� �����ϴ� *ǥ��*�� ����
�߻� �Լ��� ���� >> ������(ArrayList)�� �߻� �Լ��� �������� �� (ǥ��ȭ��)

Iterator �������̽��� ������ �ִ� �߻� �Լ�
>> hasNext(), Next(), remove() �߻� �ڿ�
>> ArrayList implements Iterator { hasNext() ... �����Ǹ� ���� ���� }

*/

public class Ex09_Collection_Iterator {

	public static void main(String[] args) {
		
		ArrayList list = new ArrayList();
		list.add(100);
		list.add(200);
		list.add(300);
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("----");
		
		// ǥ��ȭ�� ��� ����� ��� (������� ������ �����Ϳ� ����)
		Iterator it = list.iterator();	// ȣ�� >> �Լ� �ȿ��� �������̽��� �����ϴ� ��ü ����, �ش� �ּҸ� ����
		// Iterator it �θ� Ÿ��
		while (it.hasNext()) {			// ���� �ڵ� ������� (ǥ��ȭ)
			System.out.println(it.next());
		}

		System.out.println("----");

		ArrayList<Integer> intlist = new ArrayList<Integer>();
		intlist.add(1);
		intlist.add(2);
		intlist.add(3);
		// �������̽� Generic Ÿ�� ����Ͽ� ��� (����)
		Iterator<Integer> it2 = intlist.iterator();
		while (it2.hasNext()) {
			System.out.println(it2.next());
		}
		
		System.out.println("----");
		
		for (int i = intlist.size()-1; i >= 0; i--) {
			System.out.println(intlist.get(i));
		}
		
		System.out.println("----");
		/////////////////////////////////////////////////
		// Iterator �������̽� 	>> ǥ��ȭ�� ������ ��¸� �����Ѱ�
		// ������ ��ȸ�� ǥ��ȭ��?	
		ListIterator<Integer> it3 = intlist.listIterator();
		
		// ������
		while (it3.hasNext()) {
			System.out.println(it3.next());
		}
		
		System.out.println("----");
		
		// ������
		while (it3.hasPrevious()) {
			System.out.println(it3.previous());
		}
		
		// ���� (������ ǥ��ȭ�� ������ ����)
		while (it3.hasNext()) {
			int i = it3.next();
			if (i == 3) {
				it3.remove();
			}
		}
		
	}

}
