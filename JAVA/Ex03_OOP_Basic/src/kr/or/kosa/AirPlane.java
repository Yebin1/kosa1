// 0826 + 0829

package kr.or.kosa;

/*
우리 회사는 비행기를 주문 제작 판매하는 회사입니다
우리 회사는 비행기를 생산하는 설계도를 만들려고 합니다

요구 사항
1. 비행기를 생산하고 비행기의 이름과 번호를 부여해야 한다
2. 비행기가 생산되면 비행기의 이름과 번호가 맞게 부여되었는지 확인하는 작업이 필요하다 (출력)
3. 공장장은 현재까지 만들어진 비행기의 총 누적 대수를 확인할 수 있다

AirPlane air101 = new AirPlane();
air101 이름 >> 대한항공
air101 번호 >> 707
출력 확인
... 5대
관리자: 비행기 누적 대수 확인 >> 5대 확인되었습니다

*/

/* 생성자 사용X
public class AirPlane {
	
	private int airnum;
	private String airname;
	
	private static int aircount;
	
	public void makeAirPlane(int num, String name) {
		airnum = num;
		airname = name;
		aircount++;
		
		AirDisplay();
	}
	
	public void AirDisplay() {
		System.out.printf("번호: %d, 이름: %s\n", airnum, airname);
	}
	
	public void airPlaneCount() {
		System.out.printf("총 비행기 제작 대수: %d대\n", aircount);
	}

}
*/

// 0829 생성자 사용
public class AirPlane {
	
	private int airnum;
	private String airname;
	
	private static int aircount;
	
	/*public AirPlane() {	// default constructor
							// 비행기의 이름, 번호를 반드시 부여해야 하므로 사용X
	}*/
	
	public AirPlane(int num, String name) {	// overloading constructor
		airnum = num;
		airname = name;
		aircount++;
		AirDisplay();
	}
	
	public void AirDisplay() {
		System.out.printf("번호: %d, 이름: %s\n", airnum, airname);
	}
	
	public void airPlaneCount() {
		System.out.printf("총 비행기 제작 대수: %d대\n", aircount);
	}

}

