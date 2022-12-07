/* 0906

추상 클래스
>> 미완성 클래스 (설계도)
1. 완성된 코드 + 미완성 코드
2. 완성(함수) 실행 블록이 있는 함수 + 미완성(함수) 실행 블록이 없는 함수 >> public void run();
3. 완성된 클래스 (new 가능)

설계자 입장에서
>> 의도 >> 반드시 재정의 할 것 >> 강제적 구현 목적 (믿지 못하므로)

 */


class Car {
	void run() {}	// 구문이 없어도 실행 블록만 있으면 완성된 코드
}

class Hcar extends Car {
	@Override
	void run() {
		System.out.println("재정의");
	}
	
}

// Car 만든 사람: run() 재정의를 통해 내용 바꿔라
// 그러나 강제가 없으므로 Hcar 만든 사람의 의무는 아님
// 위 코드는 강제성이 없다

abstract class Abclass {	// 추상 클래스: 최소 1개 이상의 추상 함수를 가지는 클래스
	// 완성된 코드
	int pos;
	void run() {
		pos++;
	}
	
	// 미완성 코드 추가 (미완성 함수: 추상 함수 abstract method)
	abstract void stop();	// {실행 블록} 없어야 함: 재정의(Override)를 강제
}

class Child extends Abclass {
	@Override
	void stop() {			// 실행 블록을 만들어 구현 (강제적)
		this.pos = 0;
		System.out.println("stop: " + this.pos);
	}
}

class Child2 extends Abclass {
	@Override
	void stop() {			// 실행 블록을 만들어 구현 (강제적)
		this.pos = -1;
		System.out.println("stop: " + this.pos);
	}
}


public class Ex01_abstract_class {

	public static void main(String[] args) {
		Child ch = new Child();
		ch.run();
		ch.run();
		ch.stop();
		
		Child2 ch2 = new Child2();
		ch2.stop();
		
		Abclass ab =  ch;	// 다형성
		// 상속 관계에서 부모 타입의 참조 변수가 자식 타입 객체들의 주소를 가질 수 있다
		// 단, 부모는 자신의 것만 볼 수 있다
		// 단, 재정의 제외
		ab.run();
		ab.stop(); 			// 자식 함수를 호출 (구현)
	}
}
