
public class Ex02_Array_Quiz {

	public static void main(String[] args) {
		// 국문과 학생들의 기말고사 시험 점수
		int[] score = new int[] {79, 88, 97, 54, 56, 95};
		int max = score[0];		// 79
		int min = score[0];		// 79
		
		/*
		제어문을 통해 max 변수에 시험 점수 중 최댓값, min 변수에 최솟값
		출력 결과: max 97, min 54
		조건: for문 1회 사용
		*/
		
		
		for (int i = 0; i < score.length; i++) { /*
			if (score[i] < min) {
				min = score[i];
			}
			if (score[i] > max) {
				max = score[i];
			}
		}*/
		max = (score[i] > max) ? score[i] : max;
		min = (score[i] < min) ? score[i] : min; }
		System.out.printf("max: %d, min: %d", max, min);
		
		System.out.println();
		
		int[] numbers = new int[10];
		// 10개의 방을 1부터 10까지로 초기화
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = i + 1;
			System.out.printf("%d\t", numbers[i]);
		}
		
		System.out.println();
		
		
		// 어느 학생의 기말고사 시험 점수 (5과목)
		int [] jumsu = {100, 55, 90, 60, 78};
		int sum = 0;
		float avg = 0f;
		
		// 1. 과목의 개수
		// 2. 과목의 합
		// 3. 점수 평균
		// 조건: 2, 3 문제의 경우 for문 1회 사용
		
		/*
		// 1
		for (int i = 0; i < jumsu.length ; i++) {
		} System.out.println();
		
		// 2
		for (int i = 0; i < jumsu.length; i++) {
			sum += jumsu[i];
		} System.out.println(sum);
		
		// 3
		for (int i = 0; i < jumsu.length; i++) {
			avg = sum / jumsu.length;
		} System.out.println(avg);
		*/
		
		for (int i = 0; i < jumsu.length; i++) {
			sum += jumsu[i];
			if (i == jumsu.length-1) {
				avg = sum / (float) jumsu.length;
			}
		}
		System.out.printf("과목 수: %d, 총점: %d, 평균: %f", jumsu.length, sum, avg);
		
		
	}

}
