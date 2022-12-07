//0830


class Human {
	String name;
}

class OverTest {
	int add(int i, int j) {
		return i + j;
	}
	void add(Human human) {	// Human 객체의 주소값
		System.out.println(human.name);
	}
	
	// 1. add(new Human());					>> 주소값 넣기
	// 2. Human h = new Human(); add(h);	>> 주소값을 가진 참조 변수 넣기
	
	// Today Point (배열: 타입, 객체)
	int add(int param) {
		return param + 100;
	}
	
	int[] add(int[] params) {	// POINT	params은 int[] 배열의 주소값을 받는다
		// return null;			// int[] 배열의 주소값 return
		int[] target = new int[params.length];	// params가 참조하는 배열의 크기와 똑같은 크기의 배열을 만든다
		for (int i = 0; i < target.length; i++) {
			target[i] = params[i] + 1;			
		}
		return target;	// target 배열의 주소값을 반환
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
