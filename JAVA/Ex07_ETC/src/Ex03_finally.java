import java.io.IOException;

/* 0901

try {

} catch (Exception e) {

} finally {
	>> ���ܰ� �߻��ϵ� ���� ���������� ����Ǵ� ����
}

>> PC�� ����CD ��ġ
1. C:\Temp ��ġ ������ ����
2. ������ ���Ϸ� ���α׷� ��ġ
3. ���������� ��ġ�Ǿ��ٸ� C:\Temp �� �����ص״� ��ġ ������ ����
4. ������������ ��ġ�Ǿ��ٸ� ���� ���� >> ������ ��ġ ������ ���´�

*/

public class Ex03_finally {
	
	static void copyFiles() {
		System.out.println("copy files...");
	}
	
	static void startInstall() {
		System.out.println("install...");
	}
	
	static void fileDelete() {
		System.out.println("file delete...");
	}
	
	
	// ������ ���ܴ� �ƴ����� �����ڰ� �ʿ信 ���� ��� ��Ȳ�� ������ ��Ȳ���� �����ϰ� ���ܸ� �߻���ų �� �ִ�
	// ����� ���� ���� ó��
	// throw new IOException
	public static void main(String[] args) {
		
		try {
			copyFiles();
			startInstall();
			throw new IOException("install �� ������ �߻�");
		} catch (Exception e) {
			System.out.println("���� �޽��� ���");
		} finally {		// ���� ���(������)�� ���� ���ܰ� �߻��ص� ����Ǹ� ������̾ ����Ǵ� ���
						// �Լ��� ���� ������ return�� ������ finally�� ���� ����ȴ�
			fileDelete();
		}
	}

}
