import java.util.Properties;

// 0914

/*

Map �������̽��� ������ Ŭ����
Ư���� ����: <String><String>	(key, value) Ÿ���� �����Ǿ� �ִ� Ŭ����
Properties prop = new Properties();

��� ����
1. Application ��ü�� ���Ǵ� �ڿ��� �����ϵ��� ����
2. ȯ�� ���� ����
3. ���α׷� ���� ����
4. ���� ���
5. ���� ����



*/


public class Ex17_Properties {

	public static void main(String[] args) {
		
		Properties prop = new Properties();
		prop.setProperty("admin", "kosa@or.kr");
		prop.setProperty("version", "2.x.x.x");
		prop.setProperty("downpath", "C:\\Temp\\images");
		
		// ������ ���� ���������� ���
		// �ϰ� ������ �����ϰų� ���� �ٸ��� �Է����� �ʵ���
		System.out.println(prop.getProperty("admin"));	// kosa@or.kr
		System.out.println(prop.get("version"));
		System.out.println(prop.get("downpath"));
		
	}

}
