import java.util.ArrayList;

/* 0913

Today Point
Generic jdk 1.5

C#, Java �ʼ� ���

Collection Ÿ���� Ŭ���� >> ������ �⺻ ���� ���� Ÿ��: Object
����: Object � ���� �־ ��ȭ (String, Emp, int)
����: ū Ÿ�Կ� ���� ����, ���ϴ� ������ Ÿ������ �����ϴ� �۾�(downcasting) ... ����

1. Ÿ���� ó������ ���� ... 
2. Ÿ�� ������ (Ÿ���� ������ ���)
3. ���� �� ��ȯ �ʿ�X

���ʸ� ������ ���ؼ��� ���赵���� ������ �Ǿ�� �Ѵ�

*/

// T�� E�� ������� ��� �����ϳ� �Ϲ������� T�� ���� ���
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
		
		// �޸𸮿� �ö� �� T��� �����ִ� �κ��� String���� �ٲ�
		MyGen<String> mygen = new MyGen<String>();
		mygen.add("���ڿ�");
		String str = mygen.get();					// Ÿ�� ��ȯ �ʿ�X
		System.out.println("���ڿ� ������: " + str); 	// ���ڿ� ������: ���ڿ�
		
		ArrayList list = new ArrayList<>();			// ������ Ÿ�� Object
		list.add(10);
		list.add("ȫ�浿");
		list.add(new Person());
		
		// list �� ���
		// Person ��ü�� ����, �������� ���� ��� (100, 10, ȫ�浿)
		for (Object obj : list) {
			// System.out.println(obj);
			// ���̰��� �ƴ϶� �ּ�(Person@1d8d30f7)�� ���
			if (obj instanceof Person) {
				Person p = (Person)obj;
				System.out.println(p.age);
			} else {
				System.out.println(obj);
			}
		}
		
		// Generic Ÿ�� ����: �� ������
		ArrayList<Person> plist = new ArrayList<Person>();
		plist.add(new Person());
		plist.add(new Person());	 // ���ڲٸԴ°���
		// ���ʸ� ����: ���� ��(Ÿ��)�� ���� ��
		
		for (Person p: plist) {
			System.out.println(p.age);
		}
		
		ArrayList<String> slist = new ArrayList<String>();
		slist.add("���ڿ��� ���̱�");
		System.out.println(slist);	// [���ڿ��� ���̱�]
	}

}
