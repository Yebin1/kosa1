//0830


class Human {
	String name;
}

class OverTest {
	int add(int i, int j) {
		return i + j;
	}
	void add(Human human) {	// Human ��ü�� �ּҰ�
		System.out.println(human.name);
	}
	
	// 1. add(new Human());					>> �ּҰ� �ֱ�
	// 2. Human h = new Human(); add(h);	>> �ּҰ��� ���� ���� ���� �ֱ�
	
	// Today Point (�迭: Ÿ��, ��ü)
	int add(int param) {
		return param + 100;
	}
	
	int[] add(int[] params) {	// POINT	params�� int[] �迭�� �ּҰ��� �޴´�
		// return null;			// int[] �迭�� �ּҰ� return
		int[] target = new int[params.length];	// params�� �����ϴ� �迭�� ũ��� �Ȱ��� ũ���� �迭�� �����
		for (int i = 0; i < target.length; i++) {
			target[i] = params[i] + 1;			
		}
		return target;	// target �迭�� �ּҰ��� ��ȯ
	}
	int[] add(int[] so, int[] so2) {
		return null;
	}
	
}


public class Ex07_Array_method_param {

	public static void main(String[] args) {
		OverTest ot = new OverTest();
		
		int[] source = {10, 20, 30, 40, 50};
		int[] ta = ot.add(source);
		
		for (int value: ta) {
			System.out.println(value);
		}
		
	}

}
