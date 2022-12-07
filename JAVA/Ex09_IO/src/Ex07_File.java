import java.io.File;

/* 0915

���� / ������ �ٷ�� Ŭ����
Java: ���� (����, ����) ... ���� (����, ����) >> File Ŭ����
>> a.txt ����, ����, ����, ���� read
>> Temp  ����, ����, ����, ���� read

���
* ������: C:\\	D:\\
* �����: ���� ������ �߽����� >> ../ >> /

*/

public class Ex07_File {

	public static void main(String[] args) {
		
		String path = "C:\\Temp\\file.txt";
		File f = new File(path);
		
		// File ����: �پ��� ������ ���
		System.out.println("����, ������ ���� ����: " + f.exists());
		System.out.println("��������: " + f.isDirectory());
		System.out.println("��������: " + f.isFile());
		
		System.out.println("���ϸ�: " + f.getName());
		System.out.println("������: " + f.getAbsolutePath());
		
		System.out.println("���� ũ��: " + f.length() + "byte");
		System.out.println("�θ� ���: " + f.getParent());

	}
	
}
