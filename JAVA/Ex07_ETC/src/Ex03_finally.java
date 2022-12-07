import java.io.IOException;

/* 0901

try {

} catch (Exception e) {

} finally {
	>> 예외가 발생하든 말든 강제적으로 실행되는 구문
}

>> PC에 게임CD 설치
1. C:\Temp 설치 파일을 복사
2. 복사한 파일로 프로그램 설치
3. 정상적으로 설치되었다면 C:\Temp 에 복사해뒀던 설치 파일을 삭제
4. 비정상적으로 설치되었다면 강제 종료 >> 복사한 설치 파일이 남는다

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
	
	
	// 실제로 예외는 아니지만 개발자가 필요에 따라 어떠한 상황을 예외적 상황으로 정의하고 예외를 발생시킬 수 있다
	// 사용자 정의 예외 처리
	// throw new IOException
	public static void main(String[] args) {
		
		try {
			copyFiles();
			startInstall();
			throw new IOException("install 중 문제가 발생");
		} catch (Exception e) {
			System.out.println("예외 메시지 출력");
		} finally {		// 실행 블록(강제적)에 대한 예외가 발생해도 실행되며 정상건이어도 실행되는 블록
						// 함수의 강제 종료인 return을 만나도 finally가 먼저 실행된다
			fileDelete();
		}
	}

}
