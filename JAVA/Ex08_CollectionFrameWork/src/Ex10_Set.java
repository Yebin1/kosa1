import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/* 0913

Set �������̽� (�� �ȿ� ����) >> ���� ���� X
������ ���� �ߺ��� ������� �ʴ� ������ ���� ǥ��

HashSet, TreeSet (�ڷᱸ������ �߿�)


*/


public class Ex10_Set {

	public static void main(String[] args) {
		
		HashSet<Integer> hs = new HashSet<Integer>();
		
		// ������ ����, [�ߺ����� �ʴ�] ������ ����
		hs.add(1);
		hs.add(100);
		// return type boolean >> �ߺ��� �ƴ� ��� true, �ƴϸ� false
		boolean bo = hs.add(55);
		System.out.println("����: " + bo);
		
		bo = hs.add(1);
		// false >> �ߺ� ������
		System.out.println("���: " + bo);
		
		// �ߺ��� ������� �ʴ� ������ ���� >> �ζ�, ���� ��ȣ ...
		System.out.println(hs.toString()); 	// [1, 100, 55]
		
		HashSet<String> hs2 = new HashSet<String>();
		hs2.add("B");
		hs2.add("A");
		hs2.add("F");
		hs2.add("C");
		hs2.add("Z");
		hs2.add("A");
		hs2.add("H");
		hs2.add("b");
		hs2.add("b");
		System.out.println(hs2.toString());
		
		String[] strobj = {"A", "B", "C", "D", "B", "A"};	// 1000�� (1�Ǿ� �ߺ�)
		HashSet<String> hs3 = new HashSet<String>();
		for (int i = 0; i < strobj.length; i++) {
			// �ߺ� �����ʹ� add���� �ʴ´�
			hs3.add(strobj[i]);
		}
		System.out.println(hs3.toString()); 				// [A, B, C, D]
		
		
		// Quiz
		// HashSet �̿��Ͽ� 1 ~ 45�� ���� 6�� �ֱ�
		
		/*
		Random random = new Random();
		int[] lotarr = new int[6];
		
		for (int i = 0; i < lotarr.length; i++) {
			lotarr[i] = random.nextInt(45)+1;
			
			for (int j = 0; j < i; j++) {
				if(lotarr[i] == lotarr[j]) {
					i--;
					break;
				}	
			}
		}*/
		
		Random random = new Random();
		HashSet<Integer> lotto = new HashSet<Integer>();
		for (int i = 0; lotto.size() < 6; i++) {
			lotto.add(random.nextInt(45)+1);
		}
		/* while (lotto.size() < 6) {
			lotto.add(random.nextInt(45)+1);
		}*/
		System.out.println(lotto.toString());
		
		
		// HashSet ������ >> �θ� �������̽�: Set
		
		Set set2 = new HashSet();
		int index = 0;
		while (set2.size() < 6) {
			set2.add(random.nextInt(45)+1);
			// add �߻� �Լ��� HashSet Ŭ������ ������
		}
		System.out.println(set2.toString());
		
		
		// ������
		Set<String> set3 = new HashSet<String>();
		set3.add("AA");
		set3.add("DD");
		set3.add("ABC");
		set3.add("FFF");
		System.out.println(set3.toString());
		
		System.out.println("---------------------");
		
		Iterator<String> st = set3.iterator();
		while (st.hasNext()) {
			System.out.println(st.next());
		}
		
		
	}
}
