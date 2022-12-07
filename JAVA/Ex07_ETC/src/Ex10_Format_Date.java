import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

// 0915
// https://cafe.naver.com/kosait/336
// https://cafe.naver.com/kosait/201 (��¥, �ð��� �� ���ϱ�)

public class Ex10_Format_Date {

	public static void main(String[] args) {
		
		Date currdate = new Date();
		Calendar cal = Calendar.getInstance();
		
		System.out.println("date: " + currdate);
		// Thu Sep 15 09:19:17 KST 2022
		
		System.out.println("cal: " + cal);	// ���ڿ��� ����
		// java.util.GregorianCalendar[time=1663201157185,...
		
		System.out.println("cal getTime() �Լ�: " +cal.getTime());
		// Thu Sep 15 09:20:58 KST 2022
	
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMddHHmm");
		String s = dateformat.format(currdate);
		String s2 = dateformat.format(cal.getTime());
		System.out.println(s);
		System.out.println(s2);
		
		// ����Ʈ�� � ������ �Է� >> ���ڿ��� ��¥ ��������
		// "202209150925"
		String StringDate = "202209150925";	// ���Ŀ� ���� ���ٸ�
		
		Date stringdate = null;
		try {
			stringdate = dateformat.parse(StringDate);
			// parse ���� ������ (���� �߻� ���) throws ... ����ڴ� ���� ó��
			//System.out.println();
			long datelong = stringdate.getTime();
			System.out.println(datelong);
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			System.out.println(stringdate);
		}
		System.out.println();
	}

}
