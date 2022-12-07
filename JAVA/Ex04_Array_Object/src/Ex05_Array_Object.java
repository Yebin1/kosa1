// 0830

// 클래스 == 타입 == 설계도

class Person {
	String name;
	int age;
	// 사람을 만들 때 반드시 이름, 나이를 가지게 하기 위해서
	// Person(String name, int age) { this.name = name; this.age = age; } >> 생성자
	void print() {
		System.out.println(this.name + ", " + this.age);
	}
}




public class Ex05_Array_Object {

	public static void main(String[] args) {
		int[] intarr = new int[10];			// 값 타입 배열 (종류 8가지) + String (엄밀히 따지면 String 아니지만)
		boolean[] booarr = new boolean[5];	// 값 타입 (5개 방에 false)
		
		Person p = new Person();			// p: 참조 변수 (주소값reference을 가짐)
		p.name = "홍길동";
		p.age = 100;
		p.print();
		
		// 사람 3명 만드세요
		// Person p = new Person();
		// Person p2 = new Person(); ... 비효율적
		
		Person[] people = new Person[3];				// 배열로 한 번에 만들기
		System.out.println("people: " + people);
		System.out.println("people[0]: " + people[0]);	// 각각의 방이 null default 값을 가진다
		// 객체 배열은 방을 만든 후 방에 객체까지 넣어주는 작업을 해야한다
		// people[0]은 person 객체의 주소를 가진다
		people[0] = new Person();
		Person p2 = new Person();
		people[1] = p2;
		people[2] = new Person();
		System.out.println("people[0]: " + people[0]);
		System.out.println("people[1]: " + people[1]);
		System.out.println("people[2]: " + people[2]);
		
		people[0].name = "김유신";
		people[0].age = 100;
		
		// 객체 배열: 방을 만드는 것과 방을 채우는 작업은 별도
		for (int i = 0; i < people.length; i++) {
			System.out.println(people[i].name);
		}
		
		// 객체 배열 3가지 방법으로 만들기
		// 1. int[] arr = new int[10]
		Person[] parray = new Person[10];	// 방만 생성
		for (int i = 0; i < parray.length; i++) {
			parray[i] = new Person();
			System.out.println("주소값: " + parray[i]);
		}
		
		// 2. int[] arr = new int[] {10, 20, 30}
		Person[] parray2 = new Person[] {new Person(), new Person(),
				new Person()}; // 주소를 만들어서 넣어준다
		
		// 3. int[] arr = {10, 20, 30}
		Person[] parray3 = {new Person(), new Person(), new Person()};
	}

}
