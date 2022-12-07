import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

/* 0915
File ó�� (Disk): �Է� ����� Byte ������ (�� Byte) read, write

���� �л��� ��� �ϳ��� ������ �¿��� ������ ...
����: Buffer
1. I/O ���� ���� (���� Ƚ��)
2. Line ���� (����)

BufferedInputStream (���� ��Ʈ��)


*/

public class Ex04_Stream_Buffer {

	public static void main(String[] args) {
		
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		
		try {
			fos = new FileOutputStream("data.txt");	// ������ ������ create
			bos = new BufferedOutputStream(fos);	// FileOutputStream ���� ���
			
			/*
			JAVA Buffer ũ�� (8kbyte: 8192byte)
			1. buffer �ȿ� ������ ä������ ������ ��� (���۸� ���� �۾�)
			2. ������ ��� (bufffer ������ ����): flush() or close()
			3. close() �ڿ� ���� >> ���������� flush() ȣ�� >> �ڿ� ����			
			*/
			
			for (int i = 0; i < 10; i++) {
				bos.write('A'); 	// data.txt ���Ͽ� A 10�� �ۼ�
			}
			bos.flush();
			
		} catch (Exception e) {
			
		} finally {
			try {
				bos.close();
				fos.close();
			} catch (Exception e2) {
			}
		}
	}

}
