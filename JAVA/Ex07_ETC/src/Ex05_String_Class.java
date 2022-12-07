
/* 0902

String Ŭ���� (���ڿ�)
String ������ �Լ�	>> ���ڿ� ���� (�ڸ���, ��ġ�� ...)
String >> Static �Լ� + �Ϲ� �Լ�

*/


public class Ex05_String_Class {
	
	public static void main(String[] args) {
		String str = "";
		String[] strarr = {"aaa", "bbb", "ccc"};
		for (String s: strarr) {
			System.out.println(s);
		}
		// ��� ���: int, double �� Ÿ��ó�� ���
		
		String st = "ȫ�浿"; 					// ���������� �迭�� ���� (char) �ѱ��ھ� ����
		System.out.println(st.length());		// 3
		System.out.println(st);					// ȫ�浿
		System.out.println(st.toString());		// ȫ�浿 >> �ּҷ� ���� �����͸� return ���� (������)
		// String Ŭ������ Object �θ� Ŭ������ ��� �޾� Object�� toString()�� ������ ...
		
		// �������� ���
		String sdata = new String("������");		// new ���
		System.out.println(sdata);				// ������
		
		String name = "�����ٶ�";
		// String Ŭ������ ���������� char[] Ÿ���� member field�� ������ �ִ�
		// char[] member field�� [��] [��] [��] [��] [��] �迭�� �ּҰ��� ������
		// class String extends Object { private char[] str... @Override toString() ... }
		
		String str1 = "AAA";
		String str2 = "AAA";
		// ���ڿ��� ��
		System.out.println(str1);
		System.out.println(str2.toString());	// toString() ������ >> �ּҰ� �ƴ� �� ���
		
		System.out.println(str1 == str2);
		// ������ ���� �� str1(�ּҰ�), str2(�ּҰ�)
		// ���� �ּ����� �Ǹ��
		// �� �޸𸮿� ������ ���� ���ڿ��� ������ [����]
		
		// POINT
		System.out.println(str1.equals(str2));	// equals: �ּҸ� ã�ư� �ش�Ǵ� ���� ��
		
		// ���ڿ��� �� equals�� ����ؾ� �ϴ� ����
		String str3 = new String("BBB");		// new: ������ ���ο� ��ü ����
		String str4 = new String("BBB");
		System.out.println(str3 == str4); 		// �ּҰ� ���̹Ƿ� false
		// ���ڿ��� �ּҰ� �ƴ϶� ���� �߿�
		System.out.println(str3.equals(str4));	// true
		
		// ���ڿ� �����ϸ� ����ؼ� ���� �����
		String s = "A";
		s += "B";			
		s += "C";
		// A¥�� �ϳ�, AB¥�� �ϳ�, ABC¥�� �ϳ�
		System.out.println(s);
	}

}
