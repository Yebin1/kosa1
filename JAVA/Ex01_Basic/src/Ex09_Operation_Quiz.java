import java.util.Scanner;

public class Ex09_Operation_Quiz {
	
	public static void main(String[] args) {
		
		// int a1, b1;
		System.out.println("숫자를 입력하세요");
		Scanner sc = new Scanner(System.in);
		
		// String a1 = sc.nextLine();
		// String b1 = sc.nextLine();
		
		int a1 = Integer.parseInt(sc.nextLine());
		int b1 = Integer.parseInt(sc.nextLine());
		
		// a1 = sc.nextInt();
		// b1 = sc.nextInt();

		System.out.println("기호를 입력하세요");
		Scanner sc2 = new Scanner(System.in);
		String ch = sc2.nextLine();
		
		int sum3 = 0;
		
		/*
		if(ch.equals("+")) {System.out.println(a1+b1);}	// 출력 따로따로X 되도록 나중에 한 번만
		else if (ch.equals("-")) { if(a1>=b1) {System.out.println(a1-b1);} else {System.out.println(b1-a1);}}
		else if (ch.equals("*")) {System.out.println(a1*b1);}
		else if (ch.equals("/")) { if(a1>=b1) {System.out.println(a1/b1);} else {System.out.println(b1/a1);}}
		else System.out.println("잘못된 기호입니다"); */
		
		/*
		if(ch.equals("+")) {sum3 = a1+b1;}	// 출력 따로따로X 되도록 나중에 한 번만
		else if (ch.equals("-")) { if(a1>=b1) { sum3 = a1-b1;} else {sum3 = b1-a1;}}
		else if (ch.equals("*")) {sum3 = a1*b1;}
		else if (ch.equals("/")) { if(a1>=b1) sum3 = a1/b1;} else {sum3= b1/a1;}}
		else {System.out.println("잘못된 기호입니다");}*/
	}	

}
