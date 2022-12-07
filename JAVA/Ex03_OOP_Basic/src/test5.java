import java.util.Scanner;

// 별 찍기 문제

public class test5 {

	public static void main(String[] args) {
		/*
		int index = 10;
		for (int i = 1; i <= index; i++) {
			for (int j = index - i; j> -1; j--) {
				System.out.print("*");
			}
			System.out.println("");
		}
		
		
		////////////////////////////////////////////////
		
		int index = 5;

		
		for (int i = 1; i <= index; i++) {
			for (int j = 0; j < i ; j++) {
				System.out.print("*");
			} System.out.println("");
		}	

		////////////////////////////////////////////////
		
		for (int i = 1; i <= index; i++) {
			for (int j = index; j > 0 ; j-- ) {
			if (i<j) { System.out.print(" ");}
			else {System.out.print("*");}
			} System.out.println("");
		}
		
		////////////////////////////////////////////////
		
		for (int i = 0; i < index; i++) {
			for (int j = 0; j < index - i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < (2*i)+1; j++) {
				System.out.print("*");
			}
				System.out.println("");	
		}	*/
		
	
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("입력해주세요");
			
			int a = Integer.parseInt(sc.nextLine());
			int b = Integer.parseInt(sc.nextLine());
			int c = 0;
			
			if(a<b) {
				for(; a<=b; a++) {
					c+=a; 
				}
			}else {
				for(; b<=a; b++) {
					c+=b; 
				}
			}
			System.out.println(c);
		}
		
	}

