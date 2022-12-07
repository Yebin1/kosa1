import java.util.Scanner;

// 주민번호 : 뒷번호 첫자리 : 1,3 남자 , 2,4 여자 라고 출력 ... 하는 문제
// main 함수 Scanner  사용 주민번호 입력받고
// 앞:6자리     뒷:7자리
// 입력값 : 123456-1234567 

// 전부 static으로 생성
// 1. 자리수 체크 (기능)함수 (14 ok)  return true , false 
// 2. 뒷번호 첫번째 자리값 1~4까지의 값만 허용 기능함수  return true, false
// 3. 뒷번호 첫번째 자리값을 가지고 1,3 남자 , 2,4 여자 출력 기능함수  void  출력

public class Ex07_String_Total_Quiz {

	static String number = "";
	static boolean result1;
	static boolean result2;
	
	static void numberScan() {
		System.out.println("주민등록번호를 입력해주세요.");
		
		Scanner scan = new Scanner(System.in);
		number = scan.nextLine();
	}
	
	static void numberCheck() {
		if (number.length() == 14) {
			result1 = true;
		}
		System.out.println(result1);
	}
	
	static void numberCheck2() {
		
		String[] numberArr = number.replace("-", "").split("");
		if (numberArr[6].equals("1")
				|| numberArr[6].equals("2")
				|| numberArr[6].equals("3")
				|| numberArr[6].equals("4")) {
			result2 = true;
		} else {
			result2 = false;
		}
		System.out.println(result2);
	}
	
	static void numberCheck3() {
		String[] numberArr = number.replace("-", "").split("");
		if (numberArr[6].equals("1")
				|| numberArr[6].equals("3")) {
			System.out.println("남성");
		} else if
				(numberArr[6].equals("2")
				|| numberArr[6].equals("4")) {
			System.out.println("여성");
		}
			
	}

		
	public static void main(String[] args) {
		
		numberScan();
		numberCheck();
		numberCheck2();
		numberCheck3();

	}

}
