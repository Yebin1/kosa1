import kr.or.kosa.Bird;

/* 0902

설계자 

*/

class Bi extends Bird {
	
	@Override
	public void moveFast() {
	// protected void moveFast() 로 작성해도 상관X	
		super.moveFast();	// 부모 클래스의 moveFast 호출
	}
}

class Ostrich extends Bird {
	// 구체화, 특수화 >> 달린다
	void run() {
		System.out.println("run...");
	}
	
	@Override
	public void moveFast() {
		run();
	}
}


public class Ex09_Inherit_Protected {

	public static void main(String[] args) {
		
		Bi b = new Bi();
		b.fly();		// flying
		// b.moveFast(); >> public이었으면 보임
		// moveFast() 상속 관계에서 재정의하여 사용하도록 강제하는 것: protected
		b.moveFast();	// flying
		
		Ostrich o = new Ostrich();
		o.run();		// run...
		o.moveFast();	// run...
	}

}
