package kr.or.kosa;
//220826

// 원칙적으로 (실무)
// 1. 캡슐화 (member field)
// 2. 캡슐화 (간접적으로 처리: setter, getter 함수)
// 3. 이런 데이터를 담을 수 있는 클래스 (VO, DTO, DOMAIN) (Value Object, Data Transfer Object)
//								>> MVC 패턴

public class Car {
	private int window;	// instance variable member field
	private int speed;
	
	// 필요에 따라 
	// setter만 만드는 경우
	// getter만 만드는 경우
	// setter, getter 만드는 경우 >> write, read
	
	public int getWindow() {	// getter 함수
		return window;
	}
	
	public void setWindow(int data) {	// setWindow(int window) {this.}
		window = data;			// setter 함수	
	}

	// 1. IDE 사용
	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	// Lombok이란
	// java 라이브러리로 반복되는 getter, setter, toString 등
	// 반복 메소드 작성 코드를 줄여주는 코드 다이어트 라이브러리
	// @Getter
	// @Setter
	// 컴파일러에게 자동으로 setter, getter 만들도록
	
	
	// 필요하다면 별도의 함수를 생성
	// speed를 10씩 증감하는 기능
	// 일반적으로 아래와 같이 별도의 함수를 만들기보다 (read, write만 할 경우) setter, getter를 통해 제어
	public void speedUP() {
		speed += 10;
	}
	public void speedDown() {
		if (speed > 0) {
		speed -= 10;
		}else {
			speed = 0;
		}
	}
	/////////////////////////////
	

}
