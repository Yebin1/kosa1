import java.util.Random;

//0830
/*
1. 1 ~ 45������ ������ �߻����� 6���� �������� �迭�� ��´�
2. �迭�� ��� 6���� �迭���� �ߺ����� �ʾƾ� �Ѵ� (�ߺ��� ���� �ڵ�)
3. �迭�� ���� ���� ������ ���Ľ�Ų��
4. �� ����� ��� �ִ� �迭�� ����Ѵ�

main �Լ� ���� ��� �ۼ��ϰų� �ʿ��� ��� static �Լ� ���
*/


public class Ex03_Array_Lotto_Main {

	public static void main(String[] args) {
		
		Random random = new Random();
		int[] lotarr = new int[6];
		
		for (int i = 0; i < lotarr.length; i++) {
			lotarr[i] = random.nextInt(45)+1;
			
			for (int j = 0; j < i; j++) {
				if(lotarr[i] == lotarr[j]) {
					i--;
					break;
				}
				
			} // System.out.println(lotarr[i]);
		}
			/*
		for (int i = 0; i < lotarr.length; i++) {
			for(int j = 0; j < lotarr.length-i-1; j++) {
			if (lotarr[j] > lotarr[j+1]) {
				int tmp = lotarr[j+1];
				lotarr[j+1] = lotarr[j];
				lotarr[j] = tmp;
			}
			}
			
		} */
		
		System.out.println("�ζ� ��ȣ ��÷");
		for (int i = 0; i < lotarr.length; i++) {
			System.out.printf(lotarr[i] + " ");
		}

	}

}

/*
5
12
14
25
36
41
*/ /*
public class Ex03_Array_Lotto_Main {
	
	static void swap(int [] arr , int source , int target) {
	   int tmp = arr[source];
	   arr[source]  = arr[target];
	   arr[target] = tmp;
	}	

	static void printArray(int[] arr) {
	   for(int  data : arr) {
		   System.out.print(data + ", ");
	   }
	   System.out.println();
	}

	static void bubbleSort(int[] arr) {
	   bubbleSort(arr, arr.length -1);
	}

	static void bubbleSort(int[] arr , int last) {
	   if(last > 0 ) {
		    for(int i = 1 ; i <= last ; i++) {
		    	 if(arr[i-1] > arr[i]) {
		    		 swap(arr, i - 1 , i);
		    	 }
		    }
		    bubbleSort(arr, last - 1 );
		    	 
	   }
}
}
*/
 
