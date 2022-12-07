import java.io.IOException;

import kr.or.kosa.ExClass;

public class Ex04_throws {

	public static void main(String[] args) {

		// ExClass ex = new ExClass("Temp");
		// Unhandled exception type IOException
		// 두 예외를 던졌으니 해결하기 전에 X
		
		/*
		try {
			ExClass ex = new ExClass("Temp");
		} catch (Exception e) {	// 모든 예외를 다 처리하므로 아래 예외 의미X
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		
		/* 문제 없는 케이스
		try {
			ExClass ex = new ExClass("Temp");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		
		try {
			ExClass ex = new ExClass("Temp");	
		} catch (NullPointerException | IOException e) {
			e.printStackTrace();
		}
	}
		


}
