import java.util.Scanner;

public class Ex11_Statement {

	public static void main(String[] args) {
		
		// 반복문 (while, do ~ while)
		
		int i = 10;
		while (i >= 10) {
					// 반드시 인위적으로 증감 명시
			i--;	// 증감 위치 고민할 것
			System.out.println("i: " + i);
		}
		
		
		// while 1 ~ 100 합계
		int number = 1;
		int sum3 = 0;
		while (number>=1 && number<=100) {
			sum3 += number;
			number++;
		} System.out.println("sum3: " + sum3);
		
		
		// while 구구단
		int a9 = 2, b9 = 1;
		while (a9 <= 9) {
			
			while (b9 <= 9) {
				System.out.printf("%d\t", a9*b9);
				b9++;
			}
			a9++;
			b9 = 1;
			System.out.println();
		}
		
		
		// for(;;) {}		무한 루프
		// while(true) {}	무한 루프	>>	while(true) { if (조건) break; }
		
		// do ~ while		1회 수행 후 조건 판단		주로 메뉴 구성에 사용
		// do { 실행문 }		어떠한 값을 받음
		// while ()	조건 판단
		
		// 점심 메뉴를 선택하세요
		// 1. 짜장	2. 짬뽕
		// 3 입력시 메뉴 재출력
		/*
		Scanner sc = new Scanner(System.in);
		int inputdata = 0;
		do { 
			System.out.println("숫자를 입력하세요 (0 ~ 9)");	
			inputdata = Integer.parseInt(sc.nextLine());
		} while (inputdata >= 10);	// true인 경우 do문을 반복 실행
		System.out.println("당신이 입력한 숫자는: " + inputdata);
		
		
		*/
		
		
	}
}
