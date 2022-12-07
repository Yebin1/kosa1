

/*
1. Java가 제공하는 기본 타입(시스템 타입: 원시 타입) >> 8가지
2. 8가지 기본 타입 [값을 저장]하는 타입
3. 숫자	>	정수	>	(음의 정수, 0, 양의 정수)		byte	(8bit) -128 ~ 127
											char	영문자, 특수문자, 공백 1byte	한글	2byte
													협의 char(2byte): 한글, 영문자, 특수문자, 공백 크기 상관없이 2byte 표현
													>> unicode >> 아스키 코드표
													ex) char c = 'A', char c2 = '가'
											short	(c언어 호환성)
											int		(4byte) -21억 ~ 21억 정수
													★ 정수의 기본 타입
											long	(8byte)
		>	실수 (고정 소수점, 부동 소수점)		>	float	(4byte)	int보다 큰 표현 가능
											double	(8byte) >> 정밀도가 높다 (표현 범위가 크다)
													★ 실수의 기본 타입
	논리	>	참, 거짓	>	true, false		>	boolean

현재는 대충...
정수는 int 타입, 실수는 double 타입 사용하면 별 문제 없다

가장 많이 쓰는 데이터: 문자열	>>	홍길동, 김유신, 안녕하세요
★ 문자열의 표현	"홍길동", "안녕하세요"
String name = "홍길동";	>>	String: 클래스 (참조 타입) String str = new String();
★ 별도의 언급을 하기 전까지 String을 값 타입처럼 사용하기 (int, double처럼)

기본 타입 8가지 + String	>> 9가지를 가지고 데이터 표현

Java 타입
1. 값 타입: 8가지 기본 타입	>> int i = 100; int j = 200; ...	value type
2. 참조 타입(주소값): 클래스, 배열	>>	변수에 주소값이 저장				ref type (reference)

*/

// class == 설계도 == Data Type
class Car2{	// Car2는 데이터 타입이고 설계도이다 >> 구체화 (메모리 위에 올리기) 하기 위해 new 연산자 필요
	String color;
	int window;
}


public class Ex04_DataType {

	public static void main(String[] args) {
		String str = "홍길동";	// 문자열 데이터를 담을 수 있는 타입
		int age = 100;
		
		Car2 c;	// c는 main 함수 안에 있는 지역 변수
		// System.out.println(c);	// 지역 변수 초기화하지 않으면 실행 불가능
		// c라는 변수의 초기화 >> 주소값을 가지게 하는 것 >> new 연산자를 통해 메모리에 주소 할당
		c = new Car2();
		System.out.println("c의 주소값: " + c);
		
		// 선언과 초기화를 한 번에
		Car2 c2 = new Car2();
		c2.window = 100;
		c2.color = "gold";
		
		int i = 10;
		int j;
		j = 20;
		
		int k;
		k = j; // ★ POINT (값 할당: 변수 j가 가지는 값을 k에게 할당)
		System.out.println("k: " + k); // 20
		k = 300;
		System.out.println("k: " + k);
		System.out.println("j값은 변화X: " + j);
		
		// int p, q, g; // 선호X
		// 이런 경우는 배열 사용 Array: int[] arr = new int[3];
		
		// int (-21억 ~ 21억)
		int p = 100000000;
		// int p2 = 10000000000;
		// p2가 정수(int) 당연히 안 되겠지 예상... 값 자체로 오류
		// The literal 10000000000 of type int is out of range
		// 개발자가 직접 입력한 정수값은 int 그릇에 담아서 처리
		// 4byte보다 더 큰 값을 입력하면 담을 수 없음
		// 해결 방법 1. 
		long l = 10000000000l;	// 리터럴값을 long에 담아서 할당
		long l2 = 100;			// 100 리터럴값은 int
		// 작은 타입값을 큰 타입에 넣는 것은 문제가 되지 않음 (손실X)
		// int p2 = 10000000000l;		// 값 오류X 변수형에 맞지 않음
		int p2 = (int) 10000000000l;	// 캐스팅 >> 타입 변환
		System.out.println(p2);			// 1410065408 (쓰레기값) 정상적인 해결 방법X
		
		int p3 = (int) 1000l;	// 캐스팅을 통해 타입 일치시킴
		System.out.println(p3);	// 1000l 값이 int 범위 내라 쓰레기값이 아닌 것
		
		/*
		큰 타입에 작은 타입 값을 집어 넣는 것은 문제X
		작은 타입에 큰 타입 값을 집어 넣는 것은 오류
		캐스팅을 통해 타입 일치시킬 경우 손실될 수 있음
		 */
		
		
		//////////////////////////////////////////////////////////////
		
		
		/*
		char 2byte 정수값
		한 문자를 표현하기 위해 만든 자료형
		영문자, 특수문자, 공백, 한글 한 문자 표현
		
		문자열 (문자의 집합)	: "홍길동"	String name = "홍길동";	// char의 배열
		문자 (한 문자)		: 'A', '홍'	char ch = '홍';
		*/
		
		char single = '가';
		System.out.println(single);
		// char s = 'AB'; 컴파일도 되지 않음
		
		// char 정수 타입
		// char 문자를 저장하지만 내부적으로 정수값을 가지고 있음
		// 정수값은 아스키 코드값을 기반으로 한다
		// 정수와 호환
		
		int intch = 'A';	// 65
							// int intch = (int) 'A';
							// 내부적으로 자동 형 변환이 일어나므로 캐스팅X (암시적, 묵시적)
		System.out.println("intch: " + intch);
		
		char ch2 = 'a';		// 97
		System.out.println(ch2);
		int intch2 = ch2;
		System.out.println(intch2);
		
		int intch3 = 65;
		char ch3 = (char) intch3;
		System.out.println(ch3);
		
		/* 
		★★	할당에 있어 값을 보지 말고 변수형을 보자
			명시적 형 변환, 암시적 형 변환
			명시적(강제적) 형 변환: 개발자의 몫
			key point: 형 변환 시 손실 데이터 고민
			
			작은 쪽으로 형 변환 >> 데이터 손실 감안
		*/
		
		/*
			Today Point
			1. 할당에서 변수가 가지고 있는 값이 아닌, 변수의 타입을 볼 것
			2. 변수의 타입 크기를 확인할 것
			3. 큰 타입에는 작은 타입의 값을 넣을 수 있다
		★★	4. 작은 타입에 큰 타입을 넣고 싶을 경우 강제로 형 변환(캐스팅)할 것
		
			char	<<	int		<<	(char) int	<<	데이터 손실 발생 가능
			int		<<	char	<<	내부적으로 컴파일러가 친절하게 (int) char 처리
		
		 */
		
		
		//////////////////////////////////////////////////////////////
		
		
		/*
		String 문자열을 담을 수 있는 타입
		쓰는 방법: int, double 처럼 사용		
		*/
		
		String name = "hello world";
		System.out.println(name);
		
		String name2 = name + "방가방가";
		System.out.println(name2); // syso ctrl+space
		
		// + 산술, 결합 연산
		// Tip) Oracle 데이터 베이스 (언어) > + 산술 연산 > || 결합 연산
		// ex) Oracle의 경우 '안녕' || '방가'
		
		// Tip) Java에서의 특수문자 처리
		// 이스케이프 문자: 특정 문자 앞에 \
		
		// char sing = ''';	// Invalid character constant
		char sing = '\''; 	// 문자로 인식 \를 통해 데이터임을 표현
		System.out.println(sing);
		
		// Quiz: 홍"길"동		문자열 표현
		String name3 = "홍\"길\"동";
		System.out.println(name3);
		
		String str3 = "1000";
		String str4 = "10";
		String result = str3 + str4; // 100010
		System.out.println(result);
		
		System.out.println("100" + 100);			// 100100
		System.out.println(100 + "100");			// 100100
		System.out.println(100 + 100 + "100");		// 200100
		System.out.println(100 + (100 + "100"));	// 100100100
		System.out.println(100 + "100" + 100);		// 100100100
		
		// Quiz	C:\Temp 문자열을 String 변수에 담아서 화면에 출력하세요
		String temp = "C:\\Temp";
		System.out.println(temp);
		// \t >> tab
		// \n >> 줄바꿈
		
		
		//////////////////////////////////////////////////////////////
		
		
		// 실수형 (부동소수점)
		// float	4byte
		// double	8byte			실수 리터럴 기본 타입: double

		// float f = 3.14;			Type mismatch: cannot convert from double to float
		// float f = (float) 3.14;	데이터 손실 가능
		// float f = 3.14f;			데이터 손실 가능
		
		double f = 3.14;			// 가장 좋은 방법
		System.out.println(f);
		
		float f2 = 1.123456789f;	// float 타입에 담고 싶다면 무조건 접미사 f
									// 대략 소수 7자리 표현
									// 반올림 default
		System.out.println(f2);		// 1.1234568
		
		double d = 1.123456789123456789;
		System.out.println(d);		// 대략 소수 16자리 표현
									// 반올림 default
									// 1.1234567891234568
		
		System.out.println((byte) 128);	// byte로 표현 불가한 값
										// byte (-128 ~ 127)
										// overflow 순환
		
		byte q = (byte) 129;
		System.out.println(q);			// -127 (순환)
		
		// 정수와 실수
		double d2 = 100;			// 암시적 컴파일러 형 변환
		System.out.println(d2);		// 100.0
		
		// Quiz
		double d3 = 100;
		int i5 = 100;
		// int result2 = (int) (d3 + i5);	// 데이터 손실 가능
		double result2 = d3 + i5;
		System.out.println(result2);		// 데이터 손실X
		
		/*
		Today Point
		1. 큰 타입 + 작은 타입	>> 큰 타입
		2. 타입 간 변환			>> 변수가 가지는 값X 변수의 타입을 보고 판단
		3. 명시적 형 변환		>> 손실 데이터 고민
		*/
		
		int i6 = 100;
		byte b2 = (byte) i6;	// 강제적 형 변환
		
		byte b3 = 20;
		int i7 = b3;			// 컴파일러가 내부적으로 자동 형 변환
								// int i7 = (int) b3;
		
	}

}
