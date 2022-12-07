import java.io.DataInputStream;
import java.io.FileInputStream;

// 0916

public class Ex14_DataInputStream {

	public static void main(String[] args) {
		
		// 파일 학생 점수 기록
		// read 합계, 평균
		// DataOutputSream >> dos.writeInt
		
		// 반드시 >> DataInputStream >> read
		
		int sum = 0;
		int score = 0;
		FileInputStream fis = null;
		DataInputStream dis = null;
		
		try {
			
			fis = new FileInputStream("score.txt");
			dis = new DataInputStream(fis);
			
			while (true) {
				score = dis.readInt();
				System.out.println("score int 타입: " + score);
				sum += score;	// 가능 (정수 타입)
				// 더 이상 read할 자원이 없으면 IOexception 발생
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("sum 결과: " + sum);
		} finally {
			try {
				fis.close();
				dis.close();
			} catch (Exception e2) {
			}
		}
		
	}

}
