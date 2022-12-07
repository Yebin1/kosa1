import java.util.Scanner;

public class Ex12_Statement_Quiz {
	public static void main(String[] args) {
		
		// 메뉴를 보여주고 선택
		// 다른 것을 선택하면 다시 선택하도록 강제
		
		// while(true)로 짜는 법
		// do ~ while 로 짜는 법
		
		boolean auto = true;
		int balance = 0;
		Scanner	sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("********************************");
			System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
			System.out.println("********************************");
			
			System.out.println("선택하세요");
			
			int input = Integer.parseInt(sc.nextLine());
			
			// 판단
			
			switch(input) {
			case 1: System.out.println("예금 처리");
					balance += Integer.parseInt(sc.nextLine());
					break;
			case 2: System.out.println("출금 처리");
					balance -= Integer.parseInt(sc.nextLine());
					break;
			case 3: System.out.println("잔고: " + balance);
					break;
			case 4: System.out.println("종료합니다");
					auto = false;
					break;
			default: System.out.println("올바른 메뉴를 선택하세요");
			}
			
			if (auto == false) {
				break;
			}
		}
		
	}

}
