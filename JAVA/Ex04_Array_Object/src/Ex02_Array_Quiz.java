
public class Ex02_Array_Quiz {

	public static void main(String[] args) {
		// ������ �л����� �⸻��� ���� ����
		int[] score = new int[] {79, 88, 97, 54, 56, 95};
		int max = score[0];		// 79
		int min = score[0];		// 79
		
		/*
		����� ���� max ������ ���� ���� �� �ִ�, min ������ �ּڰ�
		��� ���: max 97, min 54
		����: for�� 1ȸ ���
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
		// 10���� ���� 1���� 10������ �ʱ�ȭ
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = i + 1;
			System.out.printf("%d\t", numbers[i]);
		}
		
		System.out.println();
		
		
		// ��� �л��� �⸻��� ���� ���� (5����)
		int [] jumsu = {100, 55, 90, 60, 78};
		int sum = 0;
		float avg = 0f;
		
		// 1. ������ ����
		// 2. ������ ��
		// 3. ���� ���
		// ����: 2, 3 ������ ��� for�� 1ȸ ���
		
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
		System.out.printf("���� ��: %d, ����: %d, ���: %f", jumsu.length, sum, avg);
		
		
	}

}
