import java.util.Scanner;


public class study1 {

	public static void main(String[] args) {
/*
		// ���� num�� ¦���� Even ��ȯ
		// ���� num�� Ȧ���� Odd ��ȯ
		
		System.out.println("���ڸ� �Է��ϼ���");
		Scanner sc = new Scanner(System.in);
		
		int num = Integer.parseInt(sc.nextLine());
		
		if (num % 2 == 0 || num == 0) {
			System.out.println("Even");
		} else {
			System.out.println("Odd");
		}
*/		
		
		System.out.println("���ڸ� �Է��ϼ���");
		Scanner sc = new Scanner(System.in);
		
		int a = Integer.parseInt(sc.nextLine());
		int b = Integer.parseInt(sc.nextLine());
		
		int temp;
		int sum = 0;
		
		if (a<b) {}
		else if (a>b) {
			temp = a;	// a, b ����
			a = b;
			b = temp;
		}
	
		for (; a<=b; a++) {
			sum += a;
		}

		System.out.printf("%d", sum);
		
	}

}

