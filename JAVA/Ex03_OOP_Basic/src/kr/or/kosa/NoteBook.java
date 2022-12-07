package kr.or.kosa;

public class NoteBook {

	// 노트북은 마우스를 가지고 있다
	// 마우스 >> 휠, 버튼 2개, 좌표값 등 >> 부품 정보
	// 마우스 설계도 class
	
	// 노트북과 마우스는 별개의 상품
	
	
	public Mouse mouse;	// Mouse라는 타입은 클래스 >> 참조 변수 mouse는 주소값을 가진다
	
	public String color;
	
	
	// 객체 지향 언어 (캡슐화, 은닉화: 직접적으로 값을 변경하고 쓰는 것 방지)
	// year에 마이너스값 X >> 설계자: 막을 거야 >> 사용 불가 >> 간접적으로 사용 가능하도록 >> 누군가(method)를 통해 주고 받게 함
	// 간접 >> 개발자가 논리를 통해 제어
	
	// public int year;
	private int year;

	// 약속 캡슐화 (read, write 함수) >> 표준화 >> getYear, setYear
	public void setYear(int data) {	// 간접 할당의 장점: 내가 원하는 대로
		if (data < 0) {
			year = 1999;
		} else {
			year = data;
		}
		
	}
	
	public int getYear() {			// 간접적으로 year member field를 return하는 함수
		return year;
	}
	
	public int number;
	
	// 노트북은 필요에 따라 마우스를 가질 수 있다
	// 가진다: 생성된 객체의 주소를 가진다
	
	public void handle(Mouse m) {
		m.x = 100;
		m.y = 200;
	}

	

}
