// import java.lang.*;
// 쓰지 않아도 java.lang 폴더 안 자원은 그냥 사용할 수 있음 (생략)

public class Ex06_Operation {

	public static void main(String[] args) {
		int result = 100/100;
		System.out.println(result);
		
		result = 13/2;	// 몫
		System.out.println(result);
		
		// 나머지를 구하는 연산자 (%)
		result = 13%2;
		System.out.println(result);
		
		// 증가, 감소 연산자: ++, --
		int i = 10;
		++i;			// 전치증가
		System.out.println("전치: " + i);
		i++;			// 후치증가
		System.out.println("후치: " + i);
		// 혼자서는 전치, 후치의 의미X
		
		// Today Point (증감 연산자가 다른 연산자와 결합 시 전치, 후치 의미O)
		int i2 = 5;
		int j2 = 4;
		int result2 = i2 + ++j2;
		System.out.println("result2: " + result2 + " j2: " + j2);	// result2: 10 j2: 5
		result2 = i2 + j2++;
		System.out.println("result2: " + result2 + " j2: " + j2);	// result2: 10 j2: 6
		
		
		byte b = 100;
		byte c = 1;
/*	1.	byte d = b + c;
		// Type mismatch: cannot convert from int to byte
		// Java는 연산을 위해 정수 사용
		// 4byte 공간을 사용해서 연산 int + int
		// byte d = (byte) (b + c);	// 손실 감수
*/		
		int d = b + c;	// 결과의 타입을 조정 (손실X)
		System.out.println("d값 출력: " + d);
		
		/*
		Today Point
		1. 정수의 모든 연산은 [int] 타입 변환 후 처리
		ex)	byte + short	> 컴파일러가 내부적으로 int + int 로 변환
			char + char		> int + int
			연산 처리시 정수의 연산에서 int보다 작은 타입은 int로 변환하여 연산 (long 제외) 
			byte, char, short >> 연산할 때 int
			
			char + int		> int + int
			int	+ long		> long + long
			
			정수 + 실수		> 실수 + 실수 (타입의 크기와 상관X)
		*/
		
		long ln = 10000000000l;
		float fl = 1.2f;
		// long lnresult = ln + fl;			// Type mismatch: cannot convert from float to long
		long lnresult = (long) (ln + fl);	// 손실 발생 (소수부)
		// float lnresult = ln + fl;
		System.out.println("lnresult: " + lnresult);
		
		float num2 = 10.45f;
		int num3 = 20;
		// num2 + num3
		float flresult = num2 + num3;
		System.out.println("flresult: " + flresult);
		
		char c2 = '!';	// ASCII 33
		char c3 = '!';
		// c2 + c3
		int cresult = c2 + c3;
		System.out.println("cresult: " + cresult);
		
		// 제어문
		// 중소기업 시험 문제		>> 구구단 출력	>> 삼각형 별 찍기 >> 연습
		
		int sum = 0;			// local variable
		for(int j = 1; j <= 100; j++) {
			// sum += j;
			if(j % 2 == 0) {	// 짝수라면
				sum += j;		// 짝수의 합 구하기 (1~100)
			}
		}
		System.out.println("sum: " + sum);
		
		// == 비교 연산자 (값O 타입X)
		if(10 == 10.0f) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
		
		// ! 부정 연산자
		if('A' != 65) {
			System.out.println("같지 않다: true");
		} else {
			System.out.println("같다: false");
		}
		
/*
	★	Today Point
	제어문 역할을 하는 연산자: 삼항 연산자	
*/
		int p = 10;
		int k = -10;
		int result9;
		
		int result8 = (p == k) ? p : k;
		System.out.println("result8: " + result8);
		
		if(p==k) {
			result9 = p;
		} else { result9 = k;}
		System.out.println("result9: " + result9);
		
		// 진리표
		// 논리 연산
		// 0: false
		// 1: true
		
/*				OR	AND
		0 0		0	0	
		0 1		1	0
		1 0		1	0
		1 1		1	1
		
		DB (Oracle) SQL 자연어
		select *
		from emp
		where job = 'IT' and sal > 2000	(그리고	둘 다 참인 경우만 만족)
		
		select *
		from emp
		where job = 'IT' or sal > 2000	(또는		둘 중 하나만 참이어도 만족)
		
		|	비트 연산 (or)
		&	비트 연산 (and)
		
		||	논리 연산 (OR)
		&& 	논리 연산 (AND)
*/
		int x = 3;
		int y = 5;
		
		System.out.println("x|y: " + (x|y));
/*
		십진수를 이진수로 변환
		256 128 64 32 16 8 4 2 1	8bit
*/
		System.out.println("x&y: " + (x&y));
		
/*
 		Today Point (&& and, || or)
 		if (10>0 && -1>1 && 100>2 && 1>-1){ A } else{ B }	// 거짓이 나오는 순간 처리
 		if (10>0 || -1>1 || 100>2 || 1>-1){ A } else{ B }	// 참이 나오는 순간 처리
*/
		int data = 80;
		switch(data) {
		case 100: System.out.println("100입니다");
		break;
		case 90: System.out.println("90입니다");
		break;
		case 80: System.out.println("80입니다");
		break;
		default: System.out.println("일치하는 값이 없음");
		}
		
		int month = 5;
		String res = "";	// 빈 문자열 초기화
		switch(month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			res = "31";
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			res = "30";
			break;
		case 2:
			res = "29";
			break;
		default:
			res = "월이 아닙니다";
		}
		System.out.println(month + "월은 " + res + "일까지입니다");
		
		// 난수	(랜덤값: 임의의 추출값)
		// java	(사용하고자 하는 다양한 자원을 미리 생성 >> 찾아서 사용 >> JAVA API
		// 도움말	(찾아서 사용)	API 문서
		// https://docs.oracle.com/javase/8/docs/api/index/html
		// java.lang.Math 클래스
		// public static double random()
		// equl to 0.0 and less than 1.0 범위의 난수를 얻을 수 있다
		// 결과: double 실수 return 0.0 <= random < 1.0
		
		// 원칙적인 방법	쓰고자 하는 자원이 있는 폴더를 open
		// import java.lang.*	>> java 폴더 내 lang 폴더 내에 있는 모든 자원 사용 가능
		
		/*
		System.out.println("Math.random() " + Math.random());	
		System.out.println("Math.random() * 10: " + (Math.random() * 10));							// 0 ~ 9
		System.out.println("((int) Math.random() * 10) + 1: " + ((int) (Math.random() * 10) + 1));	// 1 ~ 10
		*/
/* 
	우리는 백화점 경품 시스템을 만들려고 한다
	경품 시스템은 나오는 점수에 따라 경품을 지급하는 시스템이다
	경품 추첨시 1000 점수가 나오면
	경품으로 TV , NoteBook , 냉장고 , 한우세트 , 휴지
	경품 추첨시 900 점수가 나오면
	경품으로  NoteBook , 냉장고 , 한우세트 , 휴지
	경품 추첨시 800 점수가 나오면
	경품으로  냉장고 , 한우세트 , 휴지
	경품 추첨시 700 점수가 나오면
	경품으로  한우세트 , 휴지
	경품 추첨시 600 점수가 나오면
	경품으로  휴지
	그외 점수는 100 ~ 500 까지는 칫솔 
	경품시스템의 점수 범위는 100 ~ 1000 점까지 한정되어 있다
	사용자가 경품 시스템을 사용시 랜덤하게 100 ~ 1000까지의 값이 나오게 되어 있습니다.
 */
		/*
		double randomn = (Math.random() * 1000);
		int score = (int) randomn / 100 ;
		int score2 = (score*100)+100;
		System.out.println("점수: " + score2);
		String res2 = "";
		switch(score2) {
		case 1000:
			res2 = "TV, NoteBook, 냉장고, 한우세트, 휴지";
			break;
		case 900:
			res2 = "NoteBook, 냉장고, 한우세트, 휴지";
			break;
		case 800:
			res2 = "냉장고, 한우세트, 휴지";
			break;
		case 700:
			res2 = "한우세트, 휴지";
			break;
		case 600:
			res2 = "휴지";
			break;
		default:
			res2 = "칫솔";
		}
		System.out.println("경품 당첨: " + res2); */
		
		int randomn = (int) ((Math.random() * 10) + 1)*100;
		System.out.println(randomn);
		String res2 = "";
		switch(randomn) {
		case 1000: res2 += "TV";
		case 900: res2 += "NoteBook";
		case 800: res2 += "냉장고";
		case 700: res2 += "한우";
		case 600: res2 += "휴지";
		break;
		default: res2 += "칫솔";
		}
		System.out.println(res2);
		
		// switch(조건) 정수뿐만 아니라 문자열, 문자 가능
		
		String m = "F";
		String f = "";
		switch (m) {
		case "A":
		case "B":
		case "C": f = "ok";
			break;
		case "D":
		case "E": f = "no";
			break;
		default: f = "no data";
			break;
		}
		System.out.println("결과: " + f);


	}

}
