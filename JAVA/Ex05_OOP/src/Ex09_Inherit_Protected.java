import kr.or.kosa.Bird;

/* 0902

������ 

*/

class Bi extends Bird {
	
	@Override
	public void moveFast() {
	// protected void moveFast() �� �ۼ��ص� ���X	
		super.moveFast();	// �θ� Ŭ������ moveFast ȣ��
	}
}

class Ostrich extends Bird {
	// ��üȭ, Ư��ȭ >> �޸���
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
		// b.moveFast(); >> public�̾����� ����
		// moveFast() ��� ���迡�� �������Ͽ� ����ϵ��� �����ϴ� ��: protected
		b.moveFast();	// flying
		
		Ostrich o = new Ostrich();
		o.run();		// run...
		o.moveFast();	// run...
	}

}
