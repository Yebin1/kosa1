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
		ObjectOutputStream out = null;	// 객체 통신
		
		try {
			
			fos = new FileOutputStream(filename, true);
			bos = new BufferedOutputStream(fos);
			
			// 직렬화
			out = new ObjectOutputStream(bos);
			UserInfo u1 = new UserInfo("홍길동", "super", 500);	// 완제품
			UserInfo u2 = new UserInfo("scott", "tiger", 50);	// 완제품
			
			// 직렬화 과정
			out.writeObject(u1);	// UserInfo 분해해서 한 줄로 세워서 파일에 기록
			out.writeObject(u2);
			// 파일에 UserInfo 객체 2개를 직렬화하여 write
			
		} catch (Exception e) {	
			System.out.println(e.getMessage());
		} finally {
			try { // 순서대로 닫아야 하나 봐...
				out.close();
				bos.close();
				fos.close();
				System.out.println("파일 생성 > buffer > 직렬화 > 파일 write");
				
			} catch (Exception e2) {
			}
		}
		
	}

}
