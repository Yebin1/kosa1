import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/* 0913

Set 인터페이스 (원 안에 들어가기) >> 순서 보장 X
순서가 없고 중복을 허락하지 않는 데이터 집합 표현

HashSet, TreeSet (자료구조에서 중요)


*/


public class Ex10_Set {

	public static void main(String[] args) {
		
		HashSet<Integer> hs = new HashSet<Integer>();
		
		// 순서가 없는, [중복되지 않는] 데이터 집합
		hs.add(1);
		hs.add(100);
		// return type boolean >> 중복이 아닐 경우 true, 아니면 false
		boolean bo = hs.add(55);
		System.out.println("정상: " + bo);
		
		bo = hs.add(1);
		// false >> 중복 데이터
		System.out.println("결과: " + bo);
		
		// 중복을 허락하지 않는 데이터 집합 >> 로또, 차량 번호 ...
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
		
		String[] strobj = {"A", "B", "C", "D", "B", "A"};	// 1000건 (1건씩 중복)
		HashSet<String> hs3 = new HashSet<String>();
		for (int i = 0; i < strobj.length; i++) {
			// 중복 데이터는 add하지 않는다
			hs3.add(strobj[i]);
		}
		System.out.println(hs3.toString()); 				// [A, B, C, D]
		
		
		// Quiz
		// HashSet 이용하여 1 ~ 45의 난수 6개 넣기
		
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
		
		
		// HashSet 다형성 >> 부모 인터페이스: Set
		
		Set set2 = new HashSet();
		int index = 0;
		while (set2.size() < 6) {
			set2.add(random.nextInt(45)+1);
			// add 추상 함수를 HashSet 클래스가 재정의
		}
		System.out.println(set2.toString());
		
		
		// 다형성
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
