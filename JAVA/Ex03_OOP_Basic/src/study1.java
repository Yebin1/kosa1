import java.util.Scanner;


public class study1 {

	public static void main(String[] args) {
/*
		// 정수 num이 짝수면 Even 반환
		// 정수 num이 홀수면 Odd 반환
		
		System.out.println("숫자를 입력하세요");
		Scanner sc = new Scanner(System.in);
		
		int num = Integer.parseInt(sc.nextLine());
		
		if (num % 2 == 0 || num == 0) {
			System.out.println("Even");
		} else {
			System.out.println("Odd");
		}
*/		
		
		System.out.println("숫자를 입력하세요");
		Scanner sc = new Scanner(System.in);
		
		int a = Integer.parseInt(sc.nextLine());
		int b = Integer.parseInt(sc.nextLine());
		
		int temp;
		int sum = 0;
		
		if (a<b) {}
		else if (a>b) {
			temp = a;	// a, b 스왑
			a = b;
			b = temp;
		}
	
		for (; a<=b; a++) {
			sum += a;
		}

		System.out.printf("%d", sum);
		
	}

}

