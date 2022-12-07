// 0916


import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import kr.or.kosa.UserInfo;

public class Ex15_ObjectDataOutPutStream {

	public static void main(String[] args) {
		
		String filename = "UserData.txt";
		
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		ObjectOutputStream out = null;	// ��ü ���
		
		try {
			
			fos = new FileOutputStream(filename, true);
			bos = new BufferedOutputStream(fos);
			
			// ����ȭ
			out = new ObjectOutputStream(bos);
			UserInfo u1 = new UserInfo("ȫ�浿", "super", 500);	// ����ǰ
			UserInfo u2 = new UserInfo("scott", "tiger", 50);	// ����ǰ
			
			// ����ȭ ����
			out.writeObject(u1);	// UserInfo �����ؼ� �� �ٷ� ������ ���Ͽ� ���
			out.writeObject(u2);
			// ���Ͽ� UserInfo ��ü 2���� ����ȭ�Ͽ� write
			
		} catch (Exception e) {	
			System.out.println(e.getMessage());
		} finally {
			try { // ������� �ݾƾ� �ϳ� ��...
				out.close();
				bos.close();
				fos.close();
				System.out.println("���� ���� > buffer > ����ȭ > ���� write");
				
			} catch (Exception e2) {
			}
		}
		
	}

}
