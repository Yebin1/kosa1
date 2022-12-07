import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/* 0913

Collection FrameWork
수많은 인터페이스와 그것을 구현하고 있는 수많은 클래스가 존재

Iterator 인터페이스 (반복자)
나열된 자원에 대해 순차적으로 접근하여 값을 리턴하는 *표준*을 정의
추상 함수로 정의 >> 누군가(ArrayList)는 추상 함수를 구현했을 것 (표준화된)

Iterator 인터페이스가 가지고 있는 추상 함수
>> hasNext(), Next(), remove() 추상 자원
>> ArrayList implements Iterator { hasNext() ... 재정의를 통해 구현 }

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
		
		// 표준화된 출력 방식을 사용 (순서대로 나열된 데이터에 대해)
		Iterator it = list.iterator();	// 호출 >> 함수 안에서 인터페이스를 구현하는 객체 생성, 해당 주소를 리턴
		// Iterator it 부모 타입
		while (it.hasNext()) {			// 현업 코드 권장사항 (표준화)
			System.out.println(it.next());
		}

		System.out.println("----");

		ArrayList<Integer> intlist = new ArrayList<Integer>();
		intlist.add(1);
		intlist.add(2);
		intlist.add(3);
		// 인터페이스 Generic 타입 명시하여 사용 (주의)
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
		// Iterator 인터페이스 	>> 표준화된 순방향 출력만 가능한가
		// 역방향 조회의 표준화는?	
		ListIterator<Integer> it3 = intlist.listIterator();
		
		// 순방향
		while (it3.hasNext()) {
			System.out.println(it3.next());
		}
		
		System.out.println("----");
		
		// 역방향
		while (it3.hasPrevious()) {
			System.out.println(it3.previous());
		}
		
		// 참고 (삭제도 표준화된 구현이 가능)
		while (it3.hasNext()) {
			int i = it3.next();
			if (i == 3) {
				it3.remove();
			}
		}
		
	}

}
