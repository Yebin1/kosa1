
public class Ex02_Exception {

	public static void main(String[] args) {

		System.out.println("main start");
		int num = 100;
		int result = 0;
		
		try {
			for (int i = 0; i < 10; i++) {
				result = num / (int) (Math.random() * 10); // 0 ~ 9
				System.out.println("result: " + result + " i: " + i);
			}
		} catch (Exception e) {	// 문제가 발생하면 발생 객체의 주소를 받아 원인을 분석
			System.out.println("문제 발생시 관리자에게 메일 발송");
			System.out.println("원인: " + e.getMessage());
			
			// catch (Exception e) 보다 구체적인 객체를 명시하는 것이 가독성을 좋게 한다
		}
		
		System.out.println();

	}

}
