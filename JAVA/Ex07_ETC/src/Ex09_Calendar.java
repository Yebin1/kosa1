import java.util.Date;
import java.util.GregorianCalendar;

import kr.or.kosa.utils.Edu_Date;

import java.util.Calendar;

// 0914
/*
Calendar �� ��ӹ޾� ������ ������ Ŭ������ 
GregorianCalendar
buddhisCalendar

getInstance()�� [�ý����� ������ ��������]�� [Ȯ��]
�±��� ��� buddhisCalendar�� �ν��Ͻ��� ��ȯ
�׿ܿ��� GregorianCalendar�� �ν��Ͻ��� ��ȯ

GregorianCalendar�� Calendar�� ��ӹ޾� ���ó� ������ �������� ����ϰ� �ִ� �׷����¿� �°� ������ ��
�±��� ������ ������ ���������� GregorianCalendar ���

�׷��� �ν��Ͻ��� ���� �����ؼ� ������� �ʰ� �޼��带 ���ؼ� �ν��Ͻ��� ��ȯ�ް� �ϴ� ����
�ּ��� �������� ���α׷� ������ �ϵ��� �ϱ� ����
class MyApp{
static void main(){
Calendar cal = new GregorianCalendar();
�ٸ� ������ ������ ����ϴ� �������� �����ϸ� ����...... } }
class MyApp{
static void main(){
Calendar cal = new getInstance();
�ٸ� ������ ������ ����ϴ� �������� �����ϸ� ����...... } }
API : ������ Protected Calendar() 
*/


public class Ex09_Calendar {

	public static void main(String[] args) {
		
		Date dt = new Date();					// ������
		System.out.println(dt.toString());
		// Wed Sep 14 16:50:07 KST 2022
		
		// Calendar cal = new Calendar();
		// �߻� Ŭ�����̹Ƿ� new �Ұ���
		Calendar cal = Calendar.getInstance();	// �Ź���
		
		// GregorianCalendar cal2 = new GregorianCalendar();
		// getInstance()�� ��� >> �ý����� ����, ���� ���� Ȯ�� >> �±��� �ƴ� ��� GregorianCalendar ��ȯ
		
		System.out.println(cal.toString());
		// �ʿ��� ������ �����Ͽ� ����
		// java.util.GregorianCalendar[time=1663142176367,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id="Asia/Seoul",offset=32400000,dstSavings=0,useDaylight=false,transitions=30,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=2022,MONTH=8,WEEK_OF_YEAR=38,WEEK_OF_MONTH=3,DAY_OF_MONTH=14,DAY_OF_YEAR=257,DAY_OF_WEEK=4,DAY_OF_WEEK_IN_MONTH=2,AM_PM=1,HOUR=4,HOUR_OF_DAY=16,MINUTE=56,SECOND=16,MILLISECOND=367,ZONE_OFFSET=32400000,DST_OFFSET=0]
		
		/*
		System.out.println("�⵵: " + cal.get(Calendar.YEAR));
		System.out.println("��: " + (cal.get(Calendar.MONTH)+1));
		System.out.println("��: " + cal.get(Calendar.DATE));

		System.out.println("�̴��� ��°��: " + cal.get(Calendar.WEEK_OF_MONTH));
		System.out.println("�̴��� ��°��: " + cal.get(Calendar.DAY_OF_MONTH));
		System.out.println("�̴��� ��°��: " + cal.get(Calendar.DAY_OF_WEEK));
		*/
		
		System.out.println(cal.get(Calendar.YEAR) + "�� " + (cal.get(Calendar.MONTH)+1) + "�� " + cal.get(Calendar.DATE) + "��");
		System.out.println(cal.get(Calendar.HOUR) + "�� " + cal.get(Calendar.MINUTE) + "�� " + cal.get(Calendar.SECOND) + "��");
		System.out.println(cal.get(Calendar.AM_PM));
		
		
		// �л� ���� �ý��� (��)
		// ������ ����: 200page
		// 150page: �� ������ �ϴ� ��¥ ���� ��� (2022�� 09�� 14��)
		// A >> cal.get(Calendar.YEAR) + "��" ... >> �������� �����
		
		// �� ���� �������� 150page ������ �ٲ�� �Ϸ���
		System.out.println(Edu_Date.DateString(Calendar.getInstance()));
		System.out.println(Edu_Date.DateString(Calendar.getInstance(), "-"));	// opr
		System.out.println(Edu_Date.DateString(Calendar.getInstance(), "/"));	// opr
		System.out.println(Edu_Date.monthFormat_DateString(Calendar.getInstance()));

	}

}
