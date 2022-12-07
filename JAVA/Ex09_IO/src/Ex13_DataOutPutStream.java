import java.io.DataOutputStream;
import java.io.FileOutputStream;

/* 0916

���� ��Ʈ��
DataOutputStream
DataInputStream

java 8���� �⺻ Ÿ�� (Ÿ�Ժ��� write, read ����)
����: DataOutputStream, DataInputStream ���� ���

����.txt
100, 20, 60, 88 >> ���ڿ� > split > �迭 > ���ڷ� ��ȯ ...


*/

public class Ex13_DataOutPutStream {

	public static void main(String[] args) {
		
		int[] score = {100, 60, 55, 95, 50};
		FileOutputStream fos = null;
		DataOutputStream dos = null;
		
		try {
		
			fos = new FileOutputStream("score.txt");
			dos = new DataOutputStream(fos);
			for (int i = 0; i < score.length; i++) {
				dos.writeInt(score[i]);	// ������ �״�� write
				// ����: read �ݵ�� DataInputStream
				// dos.writeUTF(null); >> ä�� ����� (�ѱ� �� ����)
			}
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				dos.close();
				fos.close();
			} catch (Exception e2) {
			}
		}
		
		
		
	}

}
