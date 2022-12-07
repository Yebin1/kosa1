import java.io.File;

/* 0915

파일 / 폴더를 다루는 클래스
Java: 파일 (생성, 삭제) ... 폴더 (생성, 삭제) >> File 클래스
>> a.txt 생성, 수정, 삭제, 정보 read
>> Temp  생성, 수정, 삭제, 정보 read

경로
* 절대경로: C:\\	D:\\
* 상대경로: 현재 파일을 중심으로 >> ../ >> /

*/

public class Ex07_File {

	public static void main(String[] args) {
		
		String path = "C:\\Temp\\file.txt";
		File f = new File(path);
		
		// File 목적: 다양한 정보를 취득
		System.out.println("파일, 폴더의 존재 여부: " + f.exists());
		System.out.println("폴더인지: " + f.isDirectory());
		System.out.println("파일인지: " + f.isFile());
		
		System.out.println("파일명: " + f.getName());
		System.out.println("절대경로: " + f.getAbsolutePath());
		
		System.out.println("파일 크기: " + f.length() + "byte");
		System.out.println("부모 경로: " + f.getParent());

	}
	
}
