import java.util.Properties;

// 0914

/*

Map 인터페이스를 구현한 클래스
특수한 목적: <String><String>	(key, value) 타입이 고정되어 있는 클래스
Properties prop = new Properties();

사용 목적
1. Application 전체에 사용되는 자원을 관리하도록 설계
2. 환경 변수 설정
3. 프로그램 버전 관리
4. 파일 경로
5. 공통 변수



*/


public class Ex17_Properties {

	public static void main(String[] args) {
		
		Properties prop = new Properties();
		prop.setProperty("admin", "kosa@or.kr");
		prop.setProperty("version", "2.x.x.x");
		prop.setProperty("downpath", "C:\\Temp\\images");
		
		// 각각의 개발 페이지에서 사용
		// 일괄 변경이 가능하거나 각각 다르게 입력하지 않도록
		System.out.println(prop.getProperty("admin"));	// kosa@or.kr
		System.out.println(prop.get("version"));
		System.out.println(prop.get("downpath"));
		
	}

}
