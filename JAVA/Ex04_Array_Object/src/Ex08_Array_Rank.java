// 0830

public class Ex08_Array_Rank {

	public static void main(String[] args) {
		/*
		다차원 배열 (2차원)
		[행][열]
		영화관 좌석, 지도 좌표값, 오목, 엑셀
		영화관 예매 취소 관리 프로그램
		
		*/
		
		int[][] score = new int[3][2];
		score[0][0] = 100;
		score[0][1] = 200;
		
		score[1][0] = 300;
		score[1][1] = 400;
		
		score[2][0] = 500;
		score[2][1] = 600;
		
		// for문 (중첩)
		// 행의 개수: 배열명.length >> score.length >> 3
		// 열의 개수: score[i].length
		
		for (int i = 0; i < score.length; i++) {
			for (int j = 0; j < score[i].length; j++) {
				System.out.printf("score[%d][%d] = %d\t", i, j, score[i][j]);
			}
			System.out.println();
		}
		
		int[][] score3 = new int[][] { {11, 12}, {13, 14}, {15, 16} };
		
		for (int[] r: score3) {		// 열의 주소값
			for (int c: r) {	// 열의 배열 값을 출력
				System.out.println(c);
			}

	}
	}
}
