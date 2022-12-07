// 0830

// Ŭ���� == Ÿ�� == ���赵

class Person {
	String name;
	int age;
	// ����� ���� �� �ݵ�� �̸�, ���̸� ������ �ϱ� ���ؼ�
	// Person(String name, int age) { this.name = name; this.age = age; } >> ������
	void print() {
		System.out.println(this.name + ", " + this.age);
	}
}




public class Ex05_Array_Object {

	public static void main(String[] args) {
		int[] intarr = new int[10];			// �� Ÿ�� �迭 (���� 8����) + String (������ ������ String �ƴ�����)
		boolean[] booarr = new boolean[5];	// �� Ÿ�� (5�� �濡 false)
		
		Person p = new Person();			// p: ���� ���� (�ּҰ�reference�� ����)
		p.name = "ȫ�浿";
		p.age = 100;
		p.print();
		
		// ��� 3�� ���弼��
		// Person p = new Person();
		// Person p2 = new Person(); ... ��ȿ����
		
		Person[] people = new Person[3];				// �迭�� �� ���� �����
		System.out.println("people: " + people);
		System.out.println("people[0]: " + people[0]);	// ������ ���� null default ���� ������
		// ��ü �迭�� ���� ���� �� �濡 ��ü���� �־��ִ� �۾��� �ؾ��Ѵ�
		// people[0]�� person ��ü�� �ּҸ� ������
		people[0] = new Person();
		Person p2 = new Person();
		people[1] = p2;
		people[2] = new Person();
		System.out.println("people[0]: " + people[0]);
		System.out.println("people[1]: " + people[1]);
		System.out.println("people[2]: " + people[2]);
		
		people[0].name = "������";
		people[0].age = 100;
		
		// ��ü �迭: ���� ����� �Ͱ� ���� ä��� �۾��� ����
		for (int i = 0; i < people.length; i++) {
			System.out.println(people[i].name);
		}
		
		// ��ü �迭 3���� ������� �����
		// 1. int[] arr = new int[10]
		Person[] parray = new Person[10];	// �游 ����
		for (int i = 0; i < parray.length; i++) {
			parray[i] = new Person();
			System.out.println("�ּҰ�: " + parray[i]);
		}
		
		// 2. int[] arr = new int[] {10, 20, 30}
		Person[] parray2 = new Person[] {new Person(), new Person(),
				new Person()}; // �ּҸ� ���� �־��ش�
		
		// 3. int[] arr = {10, 20, 30}
		Person[] parray3 = {new Person(), new Person(), new Person()};
	}

}
