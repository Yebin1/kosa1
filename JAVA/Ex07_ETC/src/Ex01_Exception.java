/*
오류
1. 에러 (Error)		: 네트워크 장애, 메모리, 하드웨어	>> 개발자가 코드적으로 해결 불가능
2. 예외 (Exception)	: 코드의 실수에 의해 발생			>> 문제 코드를 찾아 수정 및 배포
					 >> 프로그램 컴파일시가 아니라 실행시 (알 수 없음)
					 >> 문제가 발생하면 (exception) 프로그램 강제 종료 (웹: 500)
3. 예외 처리	>> 예외 발생에 대해 코드를 수정하는 것이 아닌, 임시 방편으로 문제가 생기더라도 프로그램이 안정적으로 종료될 수 있도록 처리
			>> 결국 예외 처리를 통해 문제가 생긴 부분을 찾고 다시 코드를 수정, 배포한다
			
try {
	>> 문제가 의심되는 코드 실행 영역
	>> 문제 발생(exception)
} catch(Exception e) {
	>> 문제가 발생한 예외 부분을 파악
	>> 처리 (코드 수정X, 보고O)
		* 관리자 email
		* 로그 파일에 기록
		* 강제 프로그램 종료를 막는다 (일단)
		>> 결국 개발자 연락을 받고 수정하는 것이 정답
} finally {
	>> 문제가 발생 여부에 상관없이 강제적으로 실행할 코드
	>> DB 작업 문제 (특정 자원에 종료) 강제
}
*/


public class Ex01_Exception {

	public static void main(String[] args) {

		/*
		System.out.println("main start");
		System.out.println(0/0);
		System.out.println("main end");
		*/
		
		System.out.println("main start");
		
		try {
			System.out.println(0/0);
			// 연산 예외 발생 >> try{} catch{} 처리 프로그램이 강제 종료되지 X
			
			
			// Exception 클래스 사용 (예외 클래스의 최상위 부모 클래스)
			// e라는 변수는 무엇을 가질까? >> Exception 객체의 주소값
			
			// ArithmeticException 문제가 발생
			// 컴파일러에 의해 ArithmeticException 객체가 생성되고 그 객체에게 문제가 되는 메시지, 코드 전달
		} catch(Exception e) {	// 부모 타입 변수는 자식 타입 객체의 주소값을 가질 수 있다 (다형성)
			// 어떤 문제인지를  파악하고 그 정보를 전달
			// 관리자, email, log write
			System.out.println(e.getMessage());
		}
		
		System.out.println("main end");
	}

}
