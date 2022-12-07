import java.io.IOException;

import kr.or.kosa.ExClass;

public class Ex04_throws {

	public static void main(String[] args) {

		// ExClass ex = new ExClass("Temp");
		// Unhandled exception type IOException
		// �� ���ܸ� �������� �ذ��ϱ� ���� X
		
		/*
		try {
			ExClass ex = new ExClass("Temp");
		} catch (Exception e) {	// ��� ���ܸ� �� ó���ϹǷ� �Ʒ� ���� �ǹ�X
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		
		/* ���� ���� ���̽�
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
