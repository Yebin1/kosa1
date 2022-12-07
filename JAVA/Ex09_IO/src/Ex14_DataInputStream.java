import java.io.DataInputStream;
import java.io.FileInputStream;

// 0916

public class Ex14_DataInputStream {

	public static void main(String[] args) {
		
		// ���� �л� ���� ���
		// read �հ�, ���
		// DataOutputSream >> dos.writeInt
		
		// �ݵ�� >> DataInputStream >> read
		
		int sum = 0;
		int score = 0;
		FileInputStream fis = null;
		DataInputStream dis = null;
		
		try {
			
			fis = new FileInputStream("score.txt");
			dis = new DataInputStream(fis);
			
			while (true) {
				score = dis.readInt();
				System.out.println("score int Ÿ��: " + score);
				sum += score;	// ���� (���� Ÿ��)
				// �� �̻� read�� �ڿ��� ������ IOexception �߻�
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("sum ���: " + sum);
		} finally {
			try {
				fis.close();
				dis.close();
			} catch (Exception e2) {
			}
		}
		
	}

}
