// 0905

class Pbase {
	int p = 100;
}

class Cbase extends Pbase {
	int c = 200;
}

class Dbase extends Pbase {
	
}


public class Ex11_Inherit_Poly {

	public static void main(String[] args) {
		
		Cbase cbase = new Cbase();
		System.out.println(cbase.toString());
		
		Pbase p = cbase;	// 다형성
		
		Dbase dbase = new Dbase();
		p = dbase;			// 다형성
							// 어떨 때는 cbase, 어떨 때는 dbase
		System.out.println(p.toString());
		
		Cbase c = (Cbase)p;	// downcasting 부모 > 자식 타입

	}

}
