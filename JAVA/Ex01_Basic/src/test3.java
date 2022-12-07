import java.util.Scanner;

public class test3 {

	public static void main(String[] args) {
		
		int unit = 10000; 
		int num =0; int sw = 0; 
		int money = 0;
		
		System.out.println("금액을 입력하세요");
		
		Scanner sc = new Scanner(System.in);
		money = Integer.parseInt(sc.nextLine());
		
		while(unit>=1) {
			
			num = (money / unit);
			
				money -= (unit * num);
				
				if(sw==0) {
					System.out.printf("%d: %d개\n", unit, num);
					unit /= 2;
					sw = 1;
					
				} else {
					System.out.printf("%d: %d개\n", unit, num);
					unit /= 5;
					sw = 0;
				}

			
		}
	}
}
