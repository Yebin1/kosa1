/* 0829
원칙: 객체를 만들 때 생성자는 1개만 호출 가능 (new Car() or new Car(10)...)
this (객체): 여러 개의 생성자를 호출 가능
코드량 감소
*/

/*
class Zcar {
	String color;
	String geartype;
	int door;
	
	Zcar() {	// default
		
	}
	
	Zcar(String color, String geartype, int door) {
		this.color = color;
		this.geartype = geartype;
		this.door = door;
	}
	
	void print() {
		System.out.println(this.color + ", " + this.geartype + ", " + this.door);
	}
}
*/


class Zcar {
	String color;
	String geartype;
	int door;
	
	Zcar() {	// default
		this("red", "auto", 2);			// parameter 3개이므로 3개 찾아 떠남...
		System.out.println("default");	// 여기로 돌아와서 default 출력함
		/*
		this.color = "blue";			// 이렇게 코드 짤 경우
		this.geartype = "auto";			// 할당하는 코드가 아래에서 반복됨
		this.door = 4;
		*/
	}
	
	Zcar(String color, String geartype, int door) {	// 3개 찾았음! 실행해서 overloading 출력 후 다시 돌아감
		this.color = color;				// 반복 이 부분!
		this.geartype = geartype;
		this.door = door;
		System.out.println("overloading");
	}
	
	void print() {
		System.out.println(this.color + ", " + this.geartype + ", " + this.door);
	}
}

class Zcar2 {
	String color;
	String geartype;
	int door;
	
	Zcar2(){
		this("red", 1);
		System.out.println("default");
	}
	Zcar2(String color, int door){
		this(color, door, "auto");
		System.out.println("overloading parameter 2개");
	}
	Zcar2(String color, int door, String geartype){
		this.color = color;
		this.geartype = geartype;
		this.door = door;
		System.out.println("overloading parameter 3개");
	}
	
	void print() {
		System.out.println(this.color + ", " + this.geartype + ", " + this.door);
}
	}




public class Ex20_this {

	public static void main(String[] args) {
		
		Zcar zcar = new Zcar();
		zcar.print();
		// Zcar zcar2 = new Zcar(null, null, 0);
		
	}

}

