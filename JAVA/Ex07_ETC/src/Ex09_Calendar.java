import java.util.Date;
import java.util.GregorianCalendar;

import kr.or.kosa.utils.Edu_Date;

import java.util.Calendar;

// 0914
/*
Calendar 를 상속받아 완전히 구현한 클래스는 
GregorianCalendar
buddhisCalendar

getInstance()는 [시스템의 국가와 지역설정]을 [확인]
태국인 경우 buddhisCalendar의 인스턴스를 반환
그외에는 GregorianCalendar의 인스턴스를 반환

GregorianCalendar는 Calendar를 상속받아 오늘날 전세계 공통으로 사용하고 있는 그레고리력에 맞게 구현한 것
태국을 제외한 나머지 국가에서는 GregorianCalendar 사용

그래서 인스턴스를 직접 생성해서 사용하지 않고 메서드를 통해서 인스턴스를 반환받게 하는 이유
최소의 변경으로 프로그램 동작을 하도록 하기 위함
class MyApp{
static void main(){
Calendar cal = new GregorianCalendar();
다른 종류의 역법의 사용하는 국가에서 실행하면 변경...... } }
class MyApp{
static void main(){
Calendar cal = new getInstance();
다른 종류의 역법의 사용하는 국가에서 실행하면 변경...... } }
API : 생성자 Protected Calendar() 
*/


public class Ex09_Calendar {

	public static void main(String[] args) {
		
		Date dt = new Date();					// 구버전
		System.out.println(dt.toString());
		// Wed Sep 14 16:50:07 KST 2022
		
		// Calendar cal = new Calendar();
		// 추상 클래스이므로 new 불가능
		Calendar cal = Calendar.getInstance();	// 신버전
		
		// GregorianCalendar cal2 = new GregorianCalendar();
		// getInstance()로 사용 >> 시스템의 국가, 지역 설정 확인 >> 태국이 아닐 경우 GregorianCalendar 반환
		
		System.out.println(cal.toString());
		// 필요한 형식을 추출하여 조립
		// java.util.GregorianCalendar[time=1663142176367,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id="Asia/Seoul",offset=32400000,dstSavings=0,useDaylight=false,transitions=30,lastRule=null],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=2022,MONTH=8,WEEK_OF_YEAR=38,WEEK_OF_MONTH=3,DAY_OF_MONTH=14,DAY_OF_YEAR=257,DAY_OF_WEEK=4,DAY_OF_WEEK_IN_MONTH=2,AM_PM=1,HOUR=4,HOUR_OF_DAY=16,MINUTE=56,SECOND=16,MILLISECOND=367,ZONE_OFFSET=32400000,DST_OFFSET=0]
		
		/*
		System.out.println("년도: " + cal.get(Calendar.YEAR));
		System.out.println("월: " + (cal.get(Calendar.MONTH)+1));
		System.out.println("일: " + cal.get(Calendar.DATE));

		System.out.println("이달의 몇째주: " + cal.get(Calendar.WEEK_OF_MONTH));
		System.out.println("이달의 몇째주: " + cal.get(Calendar.DAY_OF_MONTH));
		System.out.println("이달의 몇째주: " + cal.get(Calendar.DAY_OF_WEEK));
		*/
		
		System.out.println(cal.get(Calendar.YEAR) + "년 " + (cal.get(Calendar.MONTH)+1) + "월 " + cal.get(Calendar.DATE) + "일");
		System.out.println(cal.get(Calendar.HOUR) + "시 " + cal.get(Calendar.MINUTE) + "분 " + cal.get(Calendar.SECOND) + "초");
		System.out.println(cal.get(Calendar.AM_PM));
		
		
		// 학사 관리 시스템 (웹)
		// 페이지 본수: 200page
		// 150page: 각 페이지 하단 날짜 정보 출력 (2022년 09월 14일)
		// A >> cal.get(Calendar.YEAR) + "월" ... >> 유지보수 어려움
		
		// 한 번의 수정으로 150page 내용이 바뀌게 하려면
		System.out.println(Edu_Date.DateString(Calendar.getInstance()));
		System.out.println(Edu_Date.DateString(Calendar.getInstance(), "-"));	// opr
		System.out.println(Edu_Date.DateString(Calendar.getInstance(), "/"));	// opr
		System.out.println(Edu_Date.monthFormat_DateString(Calendar.getInstance()));

	}

}
