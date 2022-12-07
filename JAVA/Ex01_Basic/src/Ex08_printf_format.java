import java.util.Scanner;

public class Ex08_printf_format {
	
	public static void main(String[] args) {
		
		// System.out.println();
		// C#: Console.WriteLine();
		
		System.out.println();	// 출력 후 줄바꿈 (엔터)
		System.out.print("A");
		System.out.print("B");
		System.out.println();
		System.out.print("C");
		System.out.println();
		
		int num = 100;
		System.out.println(num);
		System.out.println("num 값은 " + num + "입니다");
		
		// 형식 format 정의
		System.out.printf("num 값은 %d입니다", num); System.out.println();
		System.out.printf("num 값은 [%d]입니다. 또 [%d]도 있습니다. \n", num, 12345);
		// format 형식 문자
/*
		%d	10진수 형식의 정수
		%f	실수
		%s	문자열
		%c	문자
		\t	tab
		\n	줄바꿈
*/
		
		float f = 3.14f;
		System.out.println(f);
		System.out.printf("f 변수값 %.2f 입니다 \n", f);
		
		// 입력 받기 (cmd) 사용자가 입력한 값
		Scanner sc = new Scanner(System.in);
		//String value = sc.nextLine();
		// 입력 후 엔터칠 때까지 대기 (프로그램이 종료되지 않고 대기)
		// 입력한 값을 문자열로 전달
		// System.out.println(value);
		
		// int number = sc.nextInt();
		// System.out.println("number: " + number);
		
		// float number = sc.nextFloat();
		// System.out.println("float: " + number);
		
		// 권장 사항: nextInt, nextFloat 보다는 nextLine을 사용해 read 후 타입 변환
/*
		Today Point
		문자를 > 숫자로 (정수, 실수)
*/
		// Integer.parseInt("11111")	> 정수 > 1111
		// Float.parseFloat("3.14") 	> 실수 > 3.14
		/*
		System.out.println("숫자를 입력하세요");
		int number = Integer.parseInt(sc.nextLine());
		System.out.println("정수값: " + number);
		*/
		
		

		
	}

}
