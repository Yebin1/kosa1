/* 0901
OOP 특징 (여러 개의 조각(class)들을 조립해서 하나의 큰 제품을 만드는 행위)
1. 상속
2. 캡슐화 (은닉화) >> private
3. 다형성 (상속 관계에서 부모 타입이 자식 타입의 주소를 가질 수 있다)

상속
java: child extends Base
c#	: child : Base

특징
1. 다중 상속이 불가능 (단일 상속만 가능, 계층적 상속 가능)
2. 단일 상속 (계층적 상속) 가능 >> 여러 개의 클래스를 상속
3. 다중 상속을 지원 (interface)

상속
1. 재사용성
2. 단점: 초기 설계 비용 ↑
3. 재사용성 >> 설계 시간 ↑ >> 여러 개의 설계도로 분할 (부모, 자식 관계 생성)

상속 관계에서는 부모 클래스 > 자식 클래스 순으로 메모리에 생성된다
GrandFather > Father > Child (heap 메모리에 객체 3개 존재)
*/

// 사용자가 만드는 모든 클래스는 default로 Object라는 클래스를 상속한다
// class Car extend Object 로 해석
// Object: 모든 클래스의 (최상위) 부모 클래스
class Car {	// class Car extends Object 로 작성 가능
	
}

class GrandFather /* extends Object */ {
	
	public int gmoney = 5000;
	private int pmoney = 10000;	// 접근자 private이므로 상속 관계 클래스도 접근 불가
								// 클래스 내부에서 public과 private은 동일하므로 public 만들어 간접적으로 접근할 수 있음 (굳이 사용X)
	
	public GrandFather() {
		System.out.println("GrandFather");
	}
}

class Father extends GrandFather {
	
	public int fmoney = 3000;
	
	public Father() {
		System.out.println("Father");
	}
}

class Child extends Father {
	
	public int cmoney = 1000; 
	public Child() {
		System.out.println("Child");
	}
}


public class Ex01_Inherit {

	public static void main(String[] args) {
		
		Child child = new Child(); // 4개의 객체 생성
		System.out.println(child.gmoney);
		System.out.println(child.fmoney);
		System.out.println(child.cmoney);
		
		
		Car car = new Car();
		
	}

}
