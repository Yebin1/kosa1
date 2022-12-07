import java.util.Vector;

/* 0908

Collection FrameWork
�ټ��� �����͸� �ٷ�� ǥ��ȭ�� �������̽��� �����ϰ� �ִ� Ŭ������ ����

Collection �������̽� >> ��� List (����: ArrayList), Set (����: HashSet)
>> ArrayList�� �θ� Ÿ���� List�̴� (O) >> ������
>> Collection�� ArrayList�� �θ� Ÿ���̴� (O)


Map �������̽� (key, value) ���� �迭 >> ���� Ŭ����: HashMap

1. List (���� ���ÿ�)
 * ����(��ȣǥ), �ߺ� ��� >> ���������� ������(�ڷ�)�� �迭�� ����
>> [ȫ�浿] [ȫ�浿] [ȫ�浿] >> �ߺ��� ������ ����

1-1. Vector (������)		>> ����ȭ ���� (��Ƽ ������) >> Lock ��ȣ >> ���� ����
1-2. ArrayList (�Ź���)	>> ����ȭ ���� (��Ƽ ������) >> Lock �ɼ� (�⺻X) >> ���� �켱

///////////////////////////////////////////////////////////////
����: �ټ��� �����͸� �ٷ�� ��� >> Array (����, ����)
array ���� ������ �� �� �������� ũ�� ������ �Ұ��ϴ�

int[] arr = new int[5];
arr[0] = 100;
int[] arr2 = {10, 20, 30}
�����Ͱ� �������� ���ο� ũ���� �迭�� ����� ������ �̵� (�ڵ�� ���� ����)

Array
1. �迭�� ũ�Ⱑ ����: Car[] cars = {new Car(), new Car()}; �� 2��
2. ���� ��� (index ÷��) �� ��ȣ�� ����: cars[0] ... n(length-1)��° ��
///////////////////////////////////////////////////////////////

List �������̽��� �����ϰ� �ִ� (Vector, ArrayList)
1. �迭�� ũ�⸦ �������� Ȯ��, ��� ���� >> �����Ϸ��� ����� ������ �̵��� �˾Ƽ�
2. ������ ���� (���������� Array ���), �ߺ��� ���
3. ������ ���� ���� Array ���

*/


public class Ex01_Vector {

	public static void main(String[] args) {
		Vector v = new Vector();
		System.out.println("�ʱ� default �뷮: " + v.capacity());	// 10
		System.out.println("size: " + v.size());				// 0 (�� ������ ũ��)
		
		v.add("AA");
		v.add("AA");
		v.add("AA");
		v.add(10);
		
		System.out.println("size: " + v.size());				// 4
		System.out.println(v.toString()); 						// [AA, AA, AA, 10] ������: ������ ���
		// Array�� length: �迭�� ���� (������ ���� ��� X) >> ��������� index ���� ����� ������ó�� ���
		// Collection�� size: ���� ������ �ִ� �迭 ������
		
		for (int i = 0; i < v.size(); i++) {
			System.out.println(v.get(i));	// get(index) >> ���� return
											// ���� �迭 array[index]
		} System.out.println("---");
		for (Object obj: v) {
			System.out.println(obj);
		}
		// ����: ���� ������ (���� Ÿ���� ������) ... ���� ū Ÿ���� ����ϴ� �� ���ո�
		// ���ʸ� >> Ÿ���� ���� >> ���� ������ �н�
		Vector<String> v2 = new Vector<String>();
		v2.add("hello");
		v2.add("world");
		v2.add("king");
		for (String str: v2) {
			System.out.println(str);
		}
		
		Vector v3 = new Vector();
		System.out.println(v3.capacity());	// 10
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");
		v3.add("A");	// 11��°
		System.out.println(v3.toString());
		System.out.println(v3.capacity());	// �� ��� �þ
	}

}
