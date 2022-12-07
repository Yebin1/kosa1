package kr.or.kosa.common;

public class Car {

	int i;				// 컴파일러가 자동으로 default >> 같은 폴더 같은 package
						// kr.or.kosa.common package에서만 사용 가능
						// default package Ex01_Main에서 i는 사용 불가
	public int window;	// 같은 폴더, 다른 폴더 상관 없이 사용
	private int door;	// 다른 폴더에서는 무조건 사용 불가, 캡슐화로 접근 불가
						
	// 직접X 간접적으로 접근O setter, getter
	public void setDoor(int d) {	// 숨겨진 자원(door) write
		door = d;
	}					
	
	public int getDOor() {			// 숨겨진 자원 read
		return door;	
	}


}
