import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

// 0913

public class Ex12_Set_TreeSet {

	public static void main(String[] args) {
		
		// Set: ����X, �ߺ�X	
		// TreeSet: ����X, �ߺ�X, ����O
		// [�˻�]�ϰų� [����]�� �ʿ�� �ϴ� �ڷ� ���� (������ ����) ex. �ζ�
		// �ߺ� ������ ... ��� ���� (���� ������)
		
		// Ư¡
		// 1. ���� Ʈ�� ����: root > leaf
		// 2. ������ ����� ���� ��� ����
		
		HashSet<String> hs = new HashSet<String>();
		hs.add("B");
		hs.add("A");
		hs.add("F");
		hs.add("K");
		hs.add("G");
		hs.add("D");
		hs.add("P");
		System.out.println(hs.toString());
		// [P, A, B, D, F, G, K] ���� ���X
		
		TreeSet<String> ts = new TreeSet<String>();
		ts.add("B");
		ts.add("A");
		ts.add("F");
		ts.add("K");
		ts.add("G");
		ts.add("D");
		ts.add("P");
		System.out.println(ts.toString());
		
		Random random = new Random();
		Set<Integer> lotto = new TreeSet<Integer>();
		for (int i = 0; lotto.size() < 6; i++) {
			int num = (random.nextInt(45)+1);
			lotto.add(num);
			System.out.println(num);
		} System.out.println(lotto.toString());
		
	}

}
