import java.text.DecimalFormat;
import java.text.MessageFormat;

// 0915


public class Ex11_Format_ETC {

	public static void main(String[] args) {
		
		double money = 123456.5678;
		DecimalFormat df = new DecimalFormat("0.0");	// 123456.6 (�ݿø�)
		System.out.println(df.format(money));
		
		DecimalFormat df2 = new DecimalFormat("0");		// 123457 (�ݿø�)
		System.out.println(df2.format(money));
		
		DecimalFormat df3 = new DecimalFormat("0.0000000");	// 123456.568000
		System.out.println(df3.format(money));
		
		DecimalFormat df4 = new DecimalFormat("#.#######");	// 123456.5678
		System.out.println(df4.format(money));
		
		System.out.println();
		
		String userId = "kglim";
		String userName = "ȫ�浿";
		String userTel = "010-1234-5678";
		String message = "ȸ�� Id :{0} \nȸ�� �̸� : {1} \nȸ�� ��ȭ��ȣ : {2}";
		String result = MessageFormat.format(message, userId, userName, userTel);
		
		// printf()
		System.out.println(result);
		
	}

}
