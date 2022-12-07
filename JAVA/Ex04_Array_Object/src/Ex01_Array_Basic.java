import java.util.Arrays;

/* 0830
배열은 객체다
1. new를 통해 생성
2. heap 메모리 생성
3. 고정 배열 (정적 배열): 한 번 선언하면 (크기가 정해지면) 변경이 불가하다 <> collection (동적)
4. 자료구조 (알고리즘) 기초적인 학습

*/


public class Ex01_Array_Basic {

	public static void main(String[] args) {
		// 같은 타입의 변수 여러 개를 선언해서 데이터를 처리할 경우
		// int s, s1, s2;	>> 비효율적
		
		// 배열
		int[] score = new int[4];
		// int 타입의 방 4개 생성 (heap 메모리 연속된 공간에)
		System.out.println(score[0]);
		score[0] = 101;
		score[1] = 20;
		score[2] = 300;
		score[3] = 500;
		
		// java.lang.ArrayIndexOutOfBoundsException: Index 4 out of...
		// 없는 방 사용
		// score[4] = 111;
		// 방의 개수는 항상 index보다 1이 크다
		
		System.out.println(score[3]);
		
		// Array 배열 궁합 제어문 (for문)
		for (int i = 0; i < 4; i++) {
			System.out.printf("[%d] = %d\t", i, score[i]);
		}	System.out.println();
		
		// score.length 배열의 개수
		for (int i = 0; i < score.length; i++) {	
			System.out.printf("[%d] = %d\t", i, score[i]);
		}  System.out.println();
		
		// Tip Arrays.toString(score) 초급 개발자 쓰지 말기
		// String resultArray = Arrays.toString(score);
		// System.out.println(resultArray);
		// Tip Arrays.sort(score); 마찬가지로 초급 개발자 쓰지 말기
		
		
		
		// 정렬 알고리즘
		
		// Today Point
		// 배열 생성 3가지
		int[] arr = new int[5];					// 기본
		int[] arr2 = new int[] {100, 200, 300};	// 초기값을 통해 배열 개수 정의
		int[] arr3 = {11, 22, 33};				// 컴파일러에게 자동으로 new 부탁
		// javascript: let cararr = [1, 2, 3, 4, 5];
		
		for (int i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i]);
		}
		
		// 배열은 객체다 (new ... heap 로드)
		int[] arr4;
		arr4 = new int[] {21, 22, 23, 24, 25};
		System.out.println(arr4);	// I@12c8a2c0 주소값
		int[] arr5 = arr4;
		System.out.println(arr4 == arr5);
		
		// 배열 타입: 8가지 기본 + String + 클래스
		String[] strarr = new String[] {"가", "나", "다"};
		for (int i = 0; i < strarr.length; i++) {
			System.out.println(strarr[i]);
		}
		
		char[] carr = new char[5];
		float[] farr = new float[3];
		
		/*
		class Car {}
		Car[] cararr = new Car[5];
		*/

	}

}
