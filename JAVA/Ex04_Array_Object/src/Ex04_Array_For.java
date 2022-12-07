// 0830

public class Ex04_Array_For {

	public static void main(String[] args) {
		
		/*
		Today Point
		for문 >> 향상된 for문, 개선된 for문
		JAVA: 		for(Type 변수명:	 배열 || Collection) { 실행 블록 }
		C#	: 		for(Type 변수명 in 배열 || Collection) { 실행 블록 }
		JavaScript: for(Type 변수명 in Collection) { 실행 블록 }
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
