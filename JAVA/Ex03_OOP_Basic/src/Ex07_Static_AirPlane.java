// 0826

import kr.or.kosa.AirPlane;

public class Ex07_Static_AirPlane {

	public static void main(String[] args) {

		/*
		AirPlane air1 = new AirPlane();
		air1.makeAirPlane(101, "대한항공");
		air1.airPlaneCount();
		
		AirPlane air2 = new AirPlane();
		air2.makeAirPlane(707, "대한항공");
		air2.airPlaneCount();
		
		AirPlane air3 = new AirPlane();
		air3.makeAirPlane(808, "아시아나항공");
		air3.airPlaneCount(); 
		*/
		
		// 0829 생성자 사용 코드
		AirPlane air1 = new AirPlane(101, "대한항공");
		AirPlane air2 = new AirPlane(707, "대한항공");
		AirPlane air3 = new AirPlane(808, "아시아나항공");

			}

}
