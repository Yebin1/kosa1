// 0830

public class Ex04_Array_For {

	public static void main(String[] args) {
		
		/*
		Today Point
		for�� >> ���� for��, ������ for��
		JAVA: 		for(Type ������:	 �迭 || Collection) { ���� ��� }
		C#	: 		for(Type ������ in �迭 || Collection) { ���� ��� }
		JavaScript: for(Type ������ in Collection) { ���� ��� }
		*/
		
		int[] arr = {5, 6, 7, 8, 9};
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		
		for (int value: arr) {
			System.out.println(value);
		}
		
		String[] strarr = {"A", "B", "C", "D", "FFF"};
		for	(String value2: strarr) {
			System.out.println(value2);
		}
		
		

	}

}
