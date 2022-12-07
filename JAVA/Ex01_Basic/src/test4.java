import java.util.Scanner;

public class test4 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
	
		boolean auto = true;
	
		while(auto) {
			
			System.out.println("가위바위보 게임을 시작합니다.");
			System.out.println("----------------------------------------");
			System.out.println("가위 => 1 | 바위 => 2 | 보 => 3 | 종료 => 4");
			System.out.println("----------------------------------------");
			
			System.out.print("위의 보기 중 한가지 숫자를 입력해주세요 : ");
			int user = Integer.parseInt(scan.nextLine());
			int computer = (int)((3*(Math.random()))+1);
			
			if(user == 4) {
				System.out.println("프로그램을 종료합니다.");
				auto = false;
				continue;
			}else if(user == computer) {
				System.out.println("비겼습니다.");
			}else if((user - computer == -1) || (user - computer == 2)) {
				System.out.println("computer 승리");
			}else if((user - computer == 1) || (user - computer == -2)) {
				System.out.println("user 승리");
			}else {
				System.out.println("올바른 숫자를 입력해 주세요");
				continue;
			}
			
			System.out.printf("user : %d | computer : %d\n", user, computer);
			System.out.println();
		}
	}
	
}