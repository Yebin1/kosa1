import java.util.Scanner;


public class test {

	public static void main(String[] args) {
		
		double random = Math.random();
		System.out.println(random); // 0<= random < 1
		random = (3*random+1); //1 <= random < 4;
		System.out.println((int)random);

/*
		for(char i2='a'; i2<='z'; i2++)
			System.out.print(i2 + " ");
		
		/* char test1;
		int i2;
		for(i2=97; i2<=122; i2++) {
			test1 = (char) i2;
			System.out.print(test1 + " ");
		} 
		System.out.println("\n");
	
		///////////////////////////////////////////////////
		
		for(int i4=1; i4<=100; i4++) {
			System.out.print(i4+ " ");
			if(i4%10 ==0) {
				System.out.println();
			}
		}
		System.out.println("");		
		
		///////////////////////////////////////////////////
		
		int test2, test3;
		for(test2=1; test2<=6; test2++) {
			for(test3=1; test3<=6; test3++) {
				if(test2+test3 == 6) {
					System.out.print("(" + test2 + "," + test3 + ")");
				}
			}
		}
		
		Scanner sc = new Scanner(System.in);
        int a = Integer.parseInt(sc.nextLine());
        int b = Integer.parseInt(sc.nextLine());
        
        System.out.println(a/b);
		*/
	}
}
