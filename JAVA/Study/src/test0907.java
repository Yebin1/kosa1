import java.util.Scanner;
import java.util.regex.Pattern;

public class test0907 {

	  
    public static boolean Email(String str) {			// 이메일 주소
        return Pattern.matches("[0-9a-zA-Z]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$", str);
        // 0-9a-zA-Z: 숫자, 영어 대소문자 허용
        // +: 앞 문자가 하나 이상 (숫자, 영어)
        // *: 앞 문자가 없을 수도, 무한정 많을 수도 있음
        // (?:\\w+\\.): 알파벳 혹은 숫자 하나 이상, .
        // \\w+$: 알파벳 혹은 숫자 하나 이상, 문자열 종료
        
    }
     
    public static boolean PhoneNumber(String str) {		// 휴대폰 번호
        return Pattern.matches("^01(?:0|1|[6-9])(?:\\d{3}|\\d{4})\\d{4}$", str);
        // ^: 문자열 시작
        // 01(?:0|1|[6-9]): (?: ) 그룹 검색 패턴 >> 016, 019 등의 경우 체크
        // (?:\\d{3}|\\d{4}): 0~9 범위의 숫자가 3개 혹은 4개
        // \\d{4}: 0~9 범위의 숫자가 4개
        // $: 문자열 종료
    }
    
    public static boolean Zip(String str) {				// 우편 번호
    	return Pattern.matches("[0-6][0-3]\\d{3}", str);
    	// [0-6]: 0~6 범위의 숫자 하나
    	// [0-3]: 0~3 범위의 숫자 하나
    	// \d{3}: 0~9 범위의 숫자 3개
    }
     
   
   
	
	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		
		System.out.println(PhoneNumber(str));
		// System.out.println(Zip(str));
		// System.out.println(Email(str));
	}
}