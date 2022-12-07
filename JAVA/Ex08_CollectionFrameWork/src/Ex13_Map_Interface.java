// 0913

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/*
Map 인터페이스
(key, value) 한 쌍의 구조를 갖는 배열
ex) 지역 번호: (02, 서울), (031, 경기)

조건
key: 중복X		>> Set
value: 중복O		>> List

Generic 지원

Map 인터페이스 구현 클래스
구버전: HashTable (동기화 보장)	>> Lock 자원 보호
신버전: HashMap	(동기화 강제X) >> 성능 고려
*/


public class Ex13_Map_Interface {

	public static void main(String[] args) {
		
		HashMap map = new HashMap();
		map.put("Tiger", "1004");		// id, pwd
		map.put("Scott", "1004");
		map.put("Superman", "1007");
		
		System.out.println(map.containsKey("tiger")); 	// false 대소문자 구별
		System.out.println(map.containsKey("Scott"));	
		System.out.println(map.containsValue("1004"));	// 중복 상관X
		
		System.out.println("-------------------------------");
		
		// key를 제공하면 value 값을 알 수 있다 >> map.get(key)
		System.out.println(map.get("Tiger"));	 		// 1004
		System.out.println(map.get("hong"));	 		// null
		
		map.put("Tiger", "1008");						// value replace (overwrite)
		System.out.println(map.toString());
		System.out.println(map.get("Tiger"));
		// key가 같은 경우 value 값은 오버라이트
		
		System.out.println("-------------------------------");
		
		Object value = map.remove("Superman");
		System.out.println("삭제된 value: " + value);
		System.out.println(map.toString());
		
		System.out.println("-------------------------------");
		
		// 응용 (이해)
		// Set 인터페이스를 구성하는 객체를 생성하여 주소를 return
		// 순서X, 중복X
		Set set = map.keySet();
		Iterator it = set.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println("-------------------------------");
		
		// value는 중복 데이터가 허용되므로 순서가 있는 데이터 집합
		Collection clist = map.values();
		System.out.println(clist.toString());
		
	}

}
