import java.io.FileReader;
import java.io.FileWriter;

/* 0915

���� ����� ������ ó�� (char[])
String Ŭ����: String str = "ABC" >> ���������� char[] >> [A][B][C]

�ѱ� 1��, ����1�� >> 2Byte >> Reader, Writer (�߻� Ŭ����)

����� �����̶��
FileReader
FileWriter

*/


public class Ex05_Reader_Writer {

	public static void main(String[] args) {
		
		FileReader fr = null;
		FileWriter fw = null;
		
		try {
			fr = new FileReader("Ex01_Stream.java");	// read
			fw = new FileWriter("copy_Ex01.txt"); 	// write
					
			int data = 0;
			while ((data = fr.read()) != -1) {
				// System.out.println(data);
				if (data != '\n' && data != '\t' && data != '\r' && data != ' ') {
					fw.write(data);
					// ����, ��, �� ���� ���� ���� �ʰڴ�
					// ���� ���� ����
					// https://jquery.com/download/ �ǻ�� (jquery �ٿ�ε�)
				}
			}
			
		} catch (Exception e) {
		} finally {
			try {
				fr.close();
				fw.close();
			} catch (Exception e2) {
			}
		}

	}

}
