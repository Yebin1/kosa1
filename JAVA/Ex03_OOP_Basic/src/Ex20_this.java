/* 0829
��Ģ: ��ü�� ���� �� �����ڴ� 1���� ȣ�� ���� (new Car() or new Car(10)...)
this (��ü): ���� ���� �����ڸ� ȣ�� ����
�ڵ差 ����
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
		this("red", "auto", 2);			// parameter 3���̹Ƿ� 3�� ã�� ����...
		System.out.println("default");	// ����� ���ƿͼ� default �����
		/*
		this.color = "blue";			// �̷��� �ڵ� © ���
		this.geartype = "auto";			// �Ҵ��ϴ� �ڵ尡 �Ʒ����� �ݺ���
		this.door = 4;
		*/
	}
	
	Zcar(String color, String geartype, int door) {	// 3�� ã����! �����ؼ� overloading ��� �� �ٽ� ���ư�
		this.color = color;				// �ݺ� �� �κ�!
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
		System.out.println("overloading parameter 2��");
	}
	Zcar2(String color, int door, String geartype){
		this.color = color;
		this.geartype = geartype;
		this.door = door;
		System.out.println("overloading parameter 3��");
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

