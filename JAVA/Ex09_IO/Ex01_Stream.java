import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

/* 0915

IO

Stream (���)
������ ����: �̹���, ���� (���̳ʸ�) <> ����

JAVA API
Byte ������ ������ IO

�߻� Ŭ����
InputStream, OutputStream (������ ... ���ϴ� �߻� �Լ�)


Byte ������ �۾��� ��
�Է� InputStream ��ӹ޴� Ŭ���� ���
* ���
1. Memory:	ByteArrayInputStream
2. File:	FileInputStream

��� OutputStream ��ӹ޴� Ŭ���� ���
* ���
1. Memory:	ByteArrayOutputStream
2. File:	FileOutputStream

*/

public class Ex01_Stream {

	public static void main(String[] args) {
		
		// byte (-128 ~ +127 ���� ���� Ÿ��)
		byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		byte[] outSrc = null;	// ���� �޸𸮸� ������ ���� �ʴ�
		
		// ������ read, write �ϴ� ��� memory
		ByteArrayInputStream input = null;
		ByteArrayOutputStream output = null;
		
		input = new ByteArrayInputStream(inSrc); // inSrc ������κ��� data read
		output = new ByteArrayOutputStream();    // write
		
		System.out.println("outSrc before: " + Arrays.toString(outSrc));
		// outScr before: null
		
		// ���� (�ϱ��ϸ� ����)
		int data = 0;
		while ((data = input.read()) != -1) {	// �� �̻� read�� �����Ͱ� ������ -1
			// System.out.println("data: " +data);
			// System.out.println("input.read(): " + input.read());
			// 1 3 5 7 9
			// read()�� ���������� next() ���� >> read() > next()
			
			// read �����͸� write
			output.write(data);	// ��� ��� �ȿ� �����͸� ������ ����
			// write ����� data�� �ƴ� ByteArrayOutputStream �ڽ��� ��ο� data�� ������ ����
		}
		
		outSrc = output.toByteArray();	// Byte[]�� ���� ��ȯ���� �Ѱ��ش�
		System.out.println("outSrc after: " + Arrays.toString(outSrc));
		
	}

}
