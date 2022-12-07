/* 0829

this (이것)
1. 객체 자신을 가리키는 this (앞으로 생성될 객체의 주소를 담을 곳)
인스턴스 자신을 가리키는 참조 변수 인스턴스의 주소가 저장되어 있음
>> 모든 instance method에 지역 변수로 숨겨진 채 존재

2. this 객체 자신의 주소 (생성자 호출)	>> 원칙적으로 생성자는 객체 생성시 한 개만 호출
								>> this 학습 후 예외적으로 this()를 통해 여러 개의 생성자 호출 가능
								
static은 this 못 씀!

*/


class Test {
	int i;
	int j;
	
	Test () {	// 생성자
	}
	
	Test (int i, int j) {
		this.i = i;
		this.j = j;
	}
}

class Book2 {
	String bookname;
	
	Book2(String bookname) {
		this.bookname = bookname;
	}
}

class Socar {
	String color;
	String geartype;
	int door;
	
	Socar() {			// 기본 설정
		this.color = "red";	// member field (instance variable) 사용시 this 사용
		this.geartype = "auto";
		this.door = 2;
	}
	
	Socar(String color, String geartype, int door) {
		this.color = color;
		this.geartype = geartype;
		this.door = door;
	}
	
	void print() {
		System.out.println(this.color + ", " + this.geartype + ", " + this.door);
	}
	
}


public class Ex19_this {

	public static void main(String[] args) {
		
		Test t = new Test(100, 200);
		System.out.println(t.i);
		System.out.println(t.j);
		
		Socar socar = new Socar();
		socar.print();
		Socar socar2 = new Socar("blue", "auto", 4);
		socar2.print();

	}

}
