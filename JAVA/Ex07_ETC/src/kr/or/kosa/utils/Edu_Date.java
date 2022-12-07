package kr.or.kosa.utils;

import java.util.Calendar;

// 설계도
// 날짜를 적용하는 함수는 많이 적용 >> 편하게 사용 원함
// static, overloading

public class Edu_Date {
	
	public static String DateString(Calendar date) {
		return date.get(Calendar.YEAR) + "년 "
				+ (date.get(Calendar.MONTH)+1) + "월 "
				+ date.get(Calendar.DATE) + "일";
	}
	
	public static String DateString(Calendar date, String opr) {
		return date.get(Calendar.YEAR) + opr
				+ (date.get(Calendar.MONTH)+1) + opr
				+ date.get(Calendar.DATE);
	}
	
	public static String monthFormat_DateString(Calendar date) {
		/*
		String month = "" + (date.get(Calendar.MONTH)+1);
		if (date.get(Calendar.MONTH)+1 < 10) {
			month = "0" + (date.get(Calendar.MONTH)+1);
		}
		*/
		String month = "";
		if (date.get(Calendar.MONTH)+1 < 10) {
			month = "0" + (date.get(Calendar.MONTH)+1);
		} else month = String.valueOf(date.get(Calendar.MONTH)+1);
		
		return date.get(Calendar.YEAR) + "년 "
				+ month + "월 "
				+ date.get(Calendar.DATE) + "일";
	}
	
	
}
