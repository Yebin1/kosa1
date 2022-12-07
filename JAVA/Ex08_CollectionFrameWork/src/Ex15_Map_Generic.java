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

HashMap<String, Student>	POINT** >> Ŭ������ ������ Ÿ���̹Ƿ�
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
	// ���ǻ���
	// Generic Ÿ������ �迭�� ����
	ArrayList<String[]> al = new ArrayList<String[]>();
	// al.add >> String[]�� �ּҰ�
}



public class Ex15_Map_Generic {

	public static void main(String[] args) {
		
		HashMap<String, String> sts = new HashMap<String, String>();
		sts.put("A", "AAA");
		System.out.println(sts.get("A"));
		
		// �ǹ������� Map
		// �л��� ���� ������
		// kim, [����, ����, ����] >> Array, Collection(ArrayList)
		// value ������ ��ü Ÿ�� (Emp, Student) >> ArrayList�� ��Ƽ� ����ϴ� ���
		
		// Map<String, Student> smap = new HashMap<String, Student>(); >> ������
		
		// Today Point
		HashMap<String, Student> smap = new HashMap<String, Student>();
		smap.put("hong", new Student(100, 80, 50, "ȫ�浿"));
		smap.put("kim", new Student(50, 30, 60, "������"));
		
		Student sd = smap.get("hong");
		System.out.println(sd.kor);
		System.out.println(sd.math);
		
		ArrayTest at = new ArrayTest();
		String[] starr = {"A", "B", "C"};
		at.al.add(starr);
		
		// Tip
		// entrySet(): Map�� key, value ���� >> key + "=" + value
		Set set = smap.entrySet();		
		Iterator it = set.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		// hong=Student@1d8d30f7
		// kim=Student@3e57cd70
		
		// key, value �и��� ��� ���
		// class Entry { Object key, Object value }
		// Map { Entry[] elements } >> Map.Entry
		for (Map.Entry m: smap.entrySet()) {
			System.out.println(m.getKey());
			System.out.println(m.getValue());					// �ּҰ�
			System.out.println(((Student)m.getValue()).name);	// �ٿ�ĳ����(�� �� Object Ÿ���̹Ƿ�)
		}
	}

}
