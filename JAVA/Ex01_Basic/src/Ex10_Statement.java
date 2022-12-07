
public class Ex10_Statement {

	public static void main(String[] args) {

		// 제어문
		// 조건문: if (3가지 종류),		switch(조건){case 값: ... break;}
		// 반복문: for(반복 횟수가 명확),	while(진위){},	do{}~while{}
		// 분기문: break(블록 탈출),		continue(아래 구문 skip)
		
		int count = 0;
//		if(count < 1) System.out.println("true");
		
		if(count < 1) {
			System.out.println("true");
		}
		
		char data = 'A';
		switch(data) {
		case 'A': System.out.println("문자 비교");
			break;
		case 'B':
			break;
		default: System.out.println("나머지 처리");
		}
		
		// for문
		// 1 ~ 100 합계
		int sumn = 0;
		for (int i = 1; i <= 100; i++) {
			sumn += i;
//			System.out.println("i: " + i);
		} System.out.println("1 ~ 100의 합계: " + sumn);
		
		// 1 ~ 5까지의 합
		// for, while 사용X	>>	개수 * (시작 + 끝) / 2
		int sum3 = 5 * (1 + 5) / 2;
		System.out.println("sum: " + sum3);
		
		// for문 사용	>> 1 ~ 10까지 홀수 합
		// for문만 사용 (if문X)
		// for 증감 변경
		int sumn2 = 0;
		for (int i = 1; i <= 10; i += 2) {
			sumn2 += i;
		} System.out.println("sum2: " + sumn2);
		
		// for문 안에 if문 사용 1 ~ 1000까지 짝수 합계
		int sumn3 = 0;
		for (int i = 1; i <= 1000; i++) {
			if(i%2==0) {
				sumn3 += i;
			}
		} System.out.println("sum3: " + sumn3);
		
		
		// 구구단
		// 중첩 for
		
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				System.out.printf("%d\t", j*i);
			} System.out.println();
		}
		
		
		// for + 분기문 (continue, break)
		// Today Point
		// continue: 아래 구문 skip
		// break: for, while 블록 탈출
		
		for (int i = 2; i <= 9; i++) {
			for (int j = 1 ; j <= 9 ; j++) {
				if (i == j) {
					break;
				}
				System.out.printf("%s", "*");
			}
			System.out.println();
		}
		
		for (int i = 2; i <= 9; i++) {
			for (int j = 1 ; j <= 9 ; j++) {
				if (i == j) {
					continue;
				}
				System.out.printf("%d\t", j*i);
			}
			System.out.println();
		}
		
		////////////////////////////////////////////////////
			
		
		for (int i = 2; i <= 9; i++) {
			for (int j = 1; j < i; j++) {
				System.out.printf("*");
			}
			System.out.println();
		}
		
		// 100 ~ 0까지 출력
		for (int i = 100; i >= 0; i--) {
			System.out.printf("%d ", i);
		}
		
		System.out.println();
		
		/* 
		// 피보나치 수열 공식
		int j = 1;
		for (int i = 1; i <= 10; i++) {
			
			int k = 0;
			System.out.printf("%d ", k);
			j += i;
		} */
		
	}

}
