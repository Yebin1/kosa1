import java.io.FileInputStream;
import java.io.FileOutputStream;

/* 0915

Byte �����͸� read, write >> �� ����� >> File
FileInputStream
FileOutputStream

(�̹���, ���� ����) read, write ����

File >> 1.txt, data.txt (�����͸� ���Ͽ� ���)

I/O Ŭ���� ���� ����

I/O �ڿ��� �����ڰ� ���������� �ڿ��� ���� ����
>> close()

*/

public class Ex02_Point_FileStream {

	public static void main(String[] args) {
		
		FileInputStream fs = null;
		FileOutputStream fos = null;
		
		String path =  "C:\\Temp\\a.txt";
		
		try {
			fs = new FileInputStream(path);
			fos = new FileOutputStream("C:\\Temp\\new.txt");
			/*
			FileOutputStream
			1. write ������ �������� ���� ��� �ڵ� �����ϴ� ���
			2. FileOutputStream("C\\Temp\\new.txt", false);
				* false >> overwrite
			3. FileOutputStream("C\\Temp\\new.txt", true);
				* true >> append
			*/
			
			int data = 0;
			while ((data = fs.read()) != -1) {
				// System.out.println("����: " + data + " >> " + (char)data);
				// ���ڰ� char c = (char) data
				// read�� �����͸� ���ο� ���Ͽ� write
				fos.write(data); 	// data ���� ���������� read�ؼ� new.txt�� write
			}
			
		} catch (Exception e) {
			
		} finally {
			// ����, ������
			// �Լ��� return �ص� finally ����
			// �ڿ� ���� �ڵ�
			// I/O ������ �÷��Ͱ� �������� ����
			// close() ����� >> �Ҹ��� ȣ��
			try {
				fs.close();
				fos.close();
			} catch (Exception e) {
				
			}
		}
		
	}

}
