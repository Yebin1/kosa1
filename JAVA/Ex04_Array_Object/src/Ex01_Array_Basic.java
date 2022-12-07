import java.util.Arrays;

/* 0830
�迭�� ��ü��
1. new�� ���� ����
2. heap �޸� ����
3. ���� �迭 (���� �迭): �� �� �����ϸ� (ũ�Ⱑ ��������) ������ �Ұ��ϴ� <> collection (����)
4. �ڷᱸ�� (�˰���) �������� �н�

*/


public class Ex01_Array_Basic {

	public static void main(String[] args) {
		// ���� Ÿ���� ���� ���� ���� �����ؼ� �����͸� ó���� ���
		// int s, s1, s2;	>> ��ȿ����
		
		// �迭
		int[] score = new int[4];
		// int Ÿ���� �� 4�� ���� (heap �޸� ���ӵ� ������)
		System.out.println(score[0]);
		score[0] = 101;
		score[1] = 20;
		score[2] = 300;
		score[3] = 500;
		
		// java.lang.ArrayIndexOutOfBoundsException: Index 4 out of...
		// ���� �� ���
		// score[4] = 111;
		// ���� ������ �׻� index���� 1�� ũ��
		
		System.out.println(score[3]);
		
		// Array �迭 ���� ��� (for��)
		for (int i = 0; i < 4; i++) {
			System.out.printf("[%d] = %d\t", i, score[i]);
		}	System.out.println();
		
		// score.length �迭�� ����
		for (int i = 0; i < score.length; i++) {	
			System.out.printf("[%d] = %d\t", i, score[i]);
		}  System.out.println();
		
		// Tip Arrays.toString(score) �ʱ� ������ ���� ����
		// String resultArray = Arrays.toString(score);
		// System.out.println(resultArray);
		// Tip Arrays.sort(score); ���������� �ʱ� ������ ���� ����
		
		
		
		// ���� �˰���
		
		// Today Point
		// �迭 ���� 3����
		int[] arr = new int[5];					// �⺻
		int[] arr2 = new int[] {100, 200, 300};	// �ʱⰪ�� ���� �迭 ���� ����
		int[] arr3 = {11, 22, 33};				// �����Ϸ����� �ڵ����� new ��Ź
		// javascript: let cararr = [1, 2, 3, 4, 5];
		
		for (int i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i]);
		}
		
		// �迭�� ��ü�� (new ... heap �ε�)
		int[] arr4;
		arr4 = new int[] {21, 22, 23, 24, 25};
		System.out.println(arr4);	// I@12c8a2c0 �ּҰ�
		int[] arr5 = arr4;
		System.out.println(arr4 == arr5);
		
		// �迭 Ÿ��: 8���� �⺻ + String + Ŭ����
		String[] strarr = new String[] {"��", "��", "��"};
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
