package kr.or.kosa.utils;

import java.util.Calendar;

// ���赵
// ��¥�� �����ϴ� �Լ��� ���� ���� >> ���ϰ� ��� ����
// static, overloading

public class Edu_Date {
	
	public static String DateString(Calendar date) {
		return date.get(Calendar.YEAR) + "�� "
				+ (date.get(Calendar.MONTH)+1) + "�� "
				+ date.get(Calendar.DATE) + "��";
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
		
		return date.get(Calendar.YEAR) + "�� "
				+ month + "�� "
				+ date.get(Calendar.DATE) + "��";
	}
	
	
}
