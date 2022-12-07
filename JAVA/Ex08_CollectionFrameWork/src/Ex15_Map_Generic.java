import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// 0914
/*

HashMap<key, value>

HashMap<String, String>
HashMap<Integer, String>

HashMap<String, Student>	POINT** >> 클래스도 데이터 타입이므로
class Student { }

>> put("kglim", new Student());

Student st= new Student();
>> put("kglim", st);

*/

class Student {
	int kor;
	int math;
	int eng;
	String name;
	
	public Student(int kor, int math, int eng, String name) {
		super();
		this.kor = kor;
		this.math = math;
		this.eng = eng;
		this.name = name;
	}
	
}

class ArrayTest {
	// 주의사항
	// Generic 타입으로 배열도 가능
	ArrayList<String[]> al = new ArrayList<String[]>();
	// al.add >> String[]의 주소값
}



public class Ex15_Map_Generic {

	public static void main(String[] args) {
		
		HashMap<String, String> sts = new HashMap<String, String>();
		sts.put("A", "AAA");
		System.out.println(sts.get("A"));
		
		// 실무에서는 Map
		// 학생의 성적 데이터
		// kim, [국어, 영어, 수학] >> Array, Collection(ArrayList)
		// value 값으로 객체 타입 (Emp, Student) >> ArrayList에 담아서 사용하는 경우
		
		// Map<String, Student> smap = new HashMap<String, Student>(); >> 다형성
		
		// Today Point
		HashMap<String, Student> smap = new HashMap<String, Student>();
		smap.put("hong", new Student(100, 80, 50, "홍길동"));
		smap.put("kim", new Student(50, 30, 60, "김유신"));
		
		Student sd = smap.get("hong");
		System.out.println(sd.kor);
		System.out.println(sd.math);
		
		ArrayTest at = new ArrayTest();
		String[] starr = {"A", "B", "C"};
		at.al.add(starr);
		
		// Tip
		// entrySet(): Map의 key, value 가공 >> key + "=" + value
		Set set = smap.entrySet();		
		Iterator it = set.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		// hong=Student@1d8d30f7
		// kim=Student@3e57cd70
		
		// key, value 분리된 결과 출력
		// class Entry { Object key, Object value }
		// Map { Entry[] elements } >> Map.Entry
		for (Map.Entry m: smap.entrySet()) {
			System.out.println(m.getKey());
			System.out.println(m.getValue());					// 주소값
			System.out.println(((Student)m.getValue()).name);	// 다운캐스팅(둘 다 Object 타입이므로)
		}
	}

}
