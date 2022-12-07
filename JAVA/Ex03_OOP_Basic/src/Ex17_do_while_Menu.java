import java.util.Scanner;

// 0829
public class Ex17_do_while_Menu {

	Scanner sc = new Scanner(System.in);
	
	// 기능 정리
	void inputRecord() {
		System.out.println("성적 데이터 입력");
	}

	void deleteRecord() {
		System.out.println("성적 데이터 삭제");
	}
	
	void sortRecord() {
		System.out.println("성적 데이터 정렬");
	}
	
	int displayMenu() {
		System.out.println("****성적 관리****");
		System.out.println("1. 학생 성적 입력");
		System.out.println();
		System.out.println("2. 학생 성적 삭제");
		System.out.println();
		System.out.println("3. 학생 성적 이름순 정렬");
		System.out.println();
		System.out.println("4. 프로그램 종료");
		System.out.println();
		
		int menu = 0;
		do {
			try {
				menu = Integer.parseInt(sc.nextLine()); // 1, 2... 입력
				if (menu >= 1 && menu <= 4) {
					break;	// do-while을 탈출
				} else {
					// 1보다 작고 4보다 큰 값
					// 실제 오류가 아니지만 (예외가 아니지만)
					// 해당 상황을 예외로 만들 수 있다
					throw new Exception("매뉴 선택 번호가 잘못되었습니다.");
				}
			} catch (Exception e) {
				System.out.println("원인 파일: " + e.getMessage());
				System.out.println("메뉴 선택 문제 발생");
				System.out.println("1~4 번호만 입력하세요.");
			}
		} while(true);
		
		// 1~4 사이의 숫자를 선택했다면
		return menu;
	}
	

	public static void main(String[] args) {
		
		Ex17_do_while_Menu ex17 = new Ex17_do_while_Menu();
		while(true) {
			switch (ex17.displayMenu()) {
			case 1: ex17.inputRecord();
				break;
			case 2: ex17.deleteRecord();
				break;
			case 3: ex17.sortRecord();
				break;
			case 4: System.out.println("프로그램 종료");
				// return;	>> main 함수 종료
				System.exit(0); // 프로그램 강제 종료 (kill)
			}
		}
	}

}
