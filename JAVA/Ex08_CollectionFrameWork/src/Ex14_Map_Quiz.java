import java.util.HashMap;
import java.util.Scanner;

// 0913


public class Ex14_Map_Quiz {

	public static void main(String[] args) {
		
		// Map 사용 구현 데이터 집합
		// 지역 번호, 우편 번호, 회원 가입(id, pwd) 정보
		
		HashMap loginmap = new HashMap();
		loginmap.put("kim", "kim1004");
		loginmap.put("scott", "tiger");
		loginmap.put("lee", "kim1004");
		
		/*
		우리 시스템은 가입한 회원의 id, pwd 정보를 가지고 있다
		로그인시 id, pwd을 확인하여 회원이라면 사이트에 접속 가능하다
		
		id(O), pwd(O) >> 회원님 방가방가 출력, while문 탈출
		id(O), pwd(X) >> 비밀번호를 확인해 주세요 (재입력)
		id(X), pwd(O) / id(X), pwd(X) >> id 재입력하세요 출력, 아이디와 비밀번호 입력 받도록
		*/
		
		Scanner scan = new Scanner(System.in);
		
		while (true) {
			
			System.out.println("아이디와 비밀번호를 입력하세요.");
			String id = scan.nextLine().trim().toLowerCase();
			String pwd = scan.nextLine().trim();
			
			if (!loginmap.containsKey(id)) {
				System.out.println("id가 존재하지 않습니다. 다시 입력해주세요.");
			} else {
				if (loginmap.get(id).equals(pwd)) {
					System.out.println("회원님 방가방가");
					break;
				} else {
					System.out.println("비밀번호를 확인해주세요.");
				}
			}
			
			
			
			/*
			// id, pwd scan
			System.out.println("아이디와 비밀번호를 입력하세요.");
			String id = scan.nextLine();
			String pwd = scan.nextLine();
			id.replace(" ","");
			pwd.replace(" ","");
			
			for (int i = 0; i < loginmap.size(); i++) {
				if (id.equals(loginmap.get(id))) {
					if (pwd.equals(loginmap.get(pwd))) {
					System.out.println("회원님 방가방가");
					break;
					} else {
						System.out.println("비밀번호를 확인해주세요.");
					}
				} else {
					System.out.println("아이디를 다시 입력해주세요.");
				}
			}
			*/
			// id: 공백 제거, 소문자로 변환 >> String 함수
			// pwd: 공백 제거
		}
	
		
	}

}
