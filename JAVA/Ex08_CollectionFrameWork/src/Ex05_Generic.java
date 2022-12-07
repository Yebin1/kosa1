import java.util.ArrayList;

/* 0913

Today Point
Generic jdk 1.5

C#, Java 필수 기능

Collection 타입의 클래스 >> 데이터 기본 저장 공간 타입: Object
장점: Object 어떤 값을 넣어도 소화 (String, Emp, int)
단점: 큰 타입에 대한 문제, 원하는 데이터 타입으로 변경하는 작업(downcasting) ... 불편

1. 타입을 처음부터 강제 ... 
2. 타입 안정성 (타입을 강제할 경우)
3. 강제 형 변환 필요X

제너릭 적용을 위해서는 설계도부터 적용이 되어야 한다

*/

// T나 E나 마음대로 사용 가능하나 일반적으로 T를 많이 사용
// T: type parameter
class MyGen<T> {
	T obj;
	
	void add(T obj) {
		this.obj = obj;
	}
	
	T get() {
		return this.obj;
	}
}

class Person {
	int age = 100;
}

public class Ex05_Generic {

	public static void main(String[] args) {
		
		// 메모리에 올라갈 때 T라고 쓰여있던 부분이 String으로 바뀜
		MyGen<String> mygen = new MyGen<String>();
		mygen.add("문자열");
		String str = mygen.get();					// 타입 변환 필요X
		System.out.println("문자열 데이터: " + str); 	// 문자열 데이터: 문자열
		
		ArrayList list = new ArrayList<>();			// 데이터 타입 Object
		list.add(10);
		list.add("홍길동");
		list.add(new Person());
		
		// list 값 출력
		// Person 객체는 나이, 나머지는 값을 출력 (100, 10, 홍길동)
		for (Object obj : list) {
			// System.out.println(obj);
			// 나이값이 아니라 주소(Person@1d8d30f7)가 출력
			if (obj instanceof Person) {
				Person p = (Person)obj;
				System.out.println(p.age);
			} else {
				System.out.println(obj);
			}
		}
		
		// Generic 타입 강제: 한 종류만
		ArrayList<Person> plist = new ArrayList<Person>();
		plist.add(new Person());
		plist.add(new Person());	 // 왜자꾸먹는거지
		// 제너릭 장점: 먹은 것(타입)을 보는 것
		
		for (Person p: plist) {
			System.out.println(p.age);
		}
		
		ArrayList<String> slist = new ArrayList<String>();
		slist.add("문자열만 먹이기");
		System.out.println(slist);	// [문자열만 먹이기]
	}

}
