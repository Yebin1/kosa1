import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	static int AnswerN;
	static int N = 10;
	static String arr[][] = new String[N][N];
	
	
	public static void solution() {
		Scanner sc = new Scanner(System.in);
		for (int a = 0; a <= arr.length; a++ ) {
			for (int b = 0; b <= arr.length; b++) {
				sc.next();
			}
		}
		
		for (int i = 0; i <= arr.length; i++) {
			for (int j = 0; j <= arr.length; j++) {
				if (arr[i][j].equals("H")) {
					arr[i][j] = "X";
					AnswerN++;
				} else if (arr[i][j].equals("Y")) {
					break;
				} else if (arr[i][j].equals("L")) {
					continue;
				}
			}
		}
	}
	
	public static void viewArr() {
		for (int i = 0; i <= arr.length; i++) {
			for (int j = 0; j <= arr.length; j++) {
			System.out.println(arr[i][j]);
			}
		}
	}
	
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			viewArr();
			System.out.println("#"+test_case+" "+AnswerN);
		}
		
		
		
		
		
	}
}