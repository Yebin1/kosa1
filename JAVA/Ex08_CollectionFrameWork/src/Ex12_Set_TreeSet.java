import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

// 0913

public class Ex12_Set_TreeSet {

	public static void main(String[] args) {
		
		// Set: 순서X, 중복X	
		// TreeSet: 순서X, 중복X, 정렬O
		// [검색]하거나 [정렬]을 필요로 하는 자료 구조 (데이터 집합) ex. 로또
		// 중복 데이터 ... 출력 정렬 (낮은 값부터)
		
		// 특징
		// 1. 이진 트리 구조: root > leaf
		// 2. 데이터 저장시 정렬 기능 제공
		
		HashSet<String> hs = new HashSet<String>();
		hs.add("B");
		hs.add("A");
		hs.add("F");
		hs.add("K");
		hs.add("G");
		hs.add("D");
		hs.add("P");
		System.out.println(hs.toString());
		// [P, A, B, D, F, G, K] 정렬 기능X
		
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
