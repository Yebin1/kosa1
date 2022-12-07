import java.io.FileReader;
import java.io.FileWriter;

/* 0915

문자 기반의 데이터 처리 (char[])
String 클래스: String str = "ABC" >> 내부적으로 char[] >> [A][B][C]

한글 1자, 영문1자 >> 2Byte >> Reader, Writer (추상 클래스)

대상이 파일이라면
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
					// 엔터, 탭, 빈 문자 파일 쓰지 않겠다
					// 압축 파일 버전
					// https://jquery.com/download/ 실사례 (jquery 다운로드)
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
