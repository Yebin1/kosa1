import java.util.Random;

public class Study0901_2 {

	public static void main(String[] args) {
		
		Random random = new Random();
		int[] arr = new int[4];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = random.nextInt(10);
		
			for (int j = 0; j < i; j++) {
				if(arr[i] == arr[j]) {
					i--;
					break;
				}
			}
		}
		
		for (int i = 0; i < arr.length ; i++) {
			System.out.printf("%d", arr[i]);
		}
		
	}
}
