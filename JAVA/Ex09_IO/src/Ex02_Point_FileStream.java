import java.io.FileInputStream;
import java.io.FileOutputStream;

/* 0915

Byte 데이터를 read, write >> 그 대상이 >> File
FileInputStream
FileOutputStream

(이미지, 엑셀 파일) read, write 목적

File >> 1.txt, data.txt (데이터를 파일에 기록)

I/O 클래스 예외 강제

I/O 자원은 개발자가 직접적으로 자원에 대한 해제
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
			1. write 파일이 존재하지 않을 경우 자동 생성하는 기능
			2. FileOutputStream("C\\Temp\\new.txt", false);
				* false >> overwrite
			3. FileOutputStream("C\\Temp\\new.txt", true);
				* true >> append
			*/
			
			int data = 0;
			while ((data = fs.read()) != -1) {
				// System.out.println("정수: " + data + " >> " + (char)data);
				// 문자값 char c = (char) data
				// read한 데이터를 새로운 파일에 write
				fos.write(data); 	// data 값을 내부적으로 read해서 new.txt에 write
			}
			
		} catch (Exception e) {
			
		} finally {
			// 정상, 비정상
			// 함수가 return 해도 finally 실행
			// 자원 해제 코드
			// I/O 가비지 컬렉터가 관리하지 않음
			// close() 명시적 >> 소멸자 호출
			try {
				fs.close();
				fos.close();
			} catch (Exception e) {
				
			}
		}
		
	}

}
