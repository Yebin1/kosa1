import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 0908
// AllDay Point



public class Ex02_ArrayList {

	public static void main(String[] args) {
		// ArrayList: List 인터페이스 구현 (순서 보장, 중복 허용)
		ArrayList arraylist = new ArrayList();
		// Object 타입으로
		arraylist.add(100);
		arraylist.add(200);
		arraylist.add(300);
		
		for ( int i = 0; i < arraylist.size(); i++) {
			System.out.println(arraylist.get(i));
		}
		System.out.println(arraylist.toString());
		
		// add 함수: 순차적으로 데이터 넣기
		arraylist.add(0, 111); // 자리 이동
		System.out.println(arraylist.toString());
		arraylist.add(4, 444);
		// 비순차적인 데이터의 추가 삭제는 ArraylList 자료구조에 적합하지 않다 >> 순서가 있는 데이터 집합이 적합
		// 순차적인 데이터 추가, 삭제 용도로 사용
		
		// arraylist.remove(111);
		// System.out.println(arraylist.toString());
		
		// [111, 100, 200, 300, 444]
		// ArrayList 함수 공부 (초급)
		System.out.println(arraylist.contains(200));
		System.out.println(arraylist.contains(2000));
		
		arraylist.clear(); 	// 데이터 삭제 (공간은 남아있다)
		System.out.println(arraylist.size());
		System.out.println(arraylist.isEmpty());	// true
		
		arraylist.add(101);
		arraylist.add(102);
		arraylist.add(103);
		System.out.println(arraylist.isEmpty()); 	// false
		System.out.println(arraylist.size());		// 3
		arraylist.remove(0);						// 01 삭제 후 자리 바꿈
		System.out.println(arraylist.toString());	
		
		// POINT
		// 인터페이스 부모 타입
		// 개발자 습관적으로 .. 다형성 (확장성, 유연성)
		List li = new ArrayList();	// 습관적으로 부모 타입을 이용해 다형성 익히기
		li.add("가");
		li.add("나");
		li.add("다");
		li.add("라");
		
		List li2 = li.subList(0, 2); // subList 함수는 내부적으로 new ArrayList() 생성
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
		
		Collections.sort(alist);	// 프로젝트에 쓰면 감점
		System.out.println(alist.toString());
		
		// 내림차순 정렬
		// 오름차순 정렬 후 리버스하기
		Collections.reverse(alist);
		System.out.println(alist.toString());

	}

}
