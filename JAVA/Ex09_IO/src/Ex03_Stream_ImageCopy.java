import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Ex03_Stream_ImageCopy {

	public static void main(String[] args) {
		
		String orifile = "C:\\Temp\\k422839563_1.jpg";
		String targetfile = "copy.jpg";
		// default ���: C:\KOSA_IT\JAVA\Labs\Ex09_IO
		// ������ �ִ� ������Ʈ ���� �⺻ ���
		
		FileInputStream fs = null;
		FileOutputStream fos = null;
		
		try {
			fs = new FileInputStream(orifile);
			fos = new FileOutputStream(targetfile, false);	// overwrite
			
			int data = 0;
			while ((data = fs.read()) != -1) {
				fos.write(data);	// byte ��
			}
			
		} catch (Exception e) {
			
		} finally {
			try {
				fs.close();
				fos.close();
			} catch (Exception e2) {
			}
		}
		
	}

}
