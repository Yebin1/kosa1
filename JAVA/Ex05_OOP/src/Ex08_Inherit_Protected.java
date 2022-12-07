import kr.or.kosa.Pclass;

/* 0902

전제 조건: 상속 관계
접근자: protected

public
private
default
protected

protected: 양면성 >> default, public
>> 상속이 없는 클래스 안에서 protected 접근자는 default와 동일
>> 상속 관계에서만 의미를 가진다 >> 상속 관계에서 public이다

*/

class Dclass {
	public int i;
	private int p;
	int s;				// default
	protected int k;	// default (상속X) >> 사용X
}

class Child2 extends Pclass {
	void method() {
		this.k = 100;	// 상속 관계 >> 자식은 부모의 protected 자원을 public처럼 사용
		System.out.println(this.k);
	}
}


public class Ex08_Inherit_Protected {

	public static void main(String[] args) {
		
		Pclass p = new Pclass();
		// p.i
		// p.k >> 이렇게 사용하면 default와 마찬가지 (다른 패키지에서 사용 불가)
		Child2 ch = new Child2();
		ch.method();
		
	}

}
