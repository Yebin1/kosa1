import java.util.Scanner;

public class test2 {

	public static void main(String[] args) {

		boolean auto = true;
		
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("**********************************");
			System.out.println("1. 가위 | 2. 바위 | 3. 보 | 4. 게임 종료");
			System.out.println("**********************************");
			
			System.out.println("선택하세요");
			int input = Integer.parseInt(sc.nextLine());
			
			double random = Math.random();
			random = (3*random+1);

			int result = (int) random;
		
			String st1 = "";
			if (result == 1) { st1 = "가위"; }
			else if (result == 2) { st1 = "바위"; }
			else if (result == 3) { st1 = "보"; }
			
			if (input<=3 &&
					(input ==1 && result ==2) ||
					(input ==2 && result ==3) ||
					(input ==3 && result ==1)
					) {System.out.println("졌습니다");}
			else if (input<=3 &&
					(input ==3 && result ==2) ||
					(input ==2 && result ==1) ||
					(input ==1 && result ==3)
					) {System.out.println("이겼습니다");}
			else if (input<=3 && (input==result)) {System.out.println("비겼습니다");}
			else if (input==4) {auto = false;}
			else {System.out.println("다시 선택하세요"); continue;}
			
			if (auto == false) {
				System.out.println("게임을 종료합니다");
				break;
			}
			
			if (auto == true)
			{ System.out.println("컴퓨터의 결과: " + st1); }
		}
		
	}
	}

