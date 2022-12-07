import java.util.Scanner;
import java.util.regex.Pattern;

public class test0907 {

	  
    public static boolean Email(String str) {			// �̸��� �ּ�
        return Pattern.matches("[0-9a-zA-Z]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$", str);
        // 0-9a-zA-Z: ����, ���� ��ҹ��� ���
        // +: �� ���ڰ� �ϳ� �̻� (����, ����)
        // *: �� ���ڰ� ���� ����, ������ ���� ���� ����
        // (?:\\w+\\.): ���ĺ� Ȥ�� ���� �ϳ� �̻�, .
        // \\w+$: ���ĺ� Ȥ�� ���� �ϳ� �̻�, ���ڿ� ����
        
    }
     
    public static boolean PhoneNumber(String str) {		// �޴��� ��ȣ
        return Pattern.matches("^01(?:0|1|[6-9])(?:\\d{3}|\\d{4})\\d{4}$", str);
        // ^: ���ڿ� ����
        // 01(?:0|1|[6-9]): (?: ) �׷� �˻� ���� >> 016, 019 ���� ��� üũ
        // (?:\\d{3}|\\d{4}): 0~9 ������ ���ڰ� 3�� Ȥ�� 4��
        // \\d{4}: 0~9 ������ ���ڰ� 4��
        // $: ���ڿ� ����
    }
    
    public static boolean Zip(String str) {				// ���� ��ȣ
    	return Pattern.matches("[0-6][0-3]\\d{3}", str);
    	// [0-6]: 0~6 ������ ���� �ϳ�
    	// [0-3]: 0~3 ������ ���� �ϳ�
    	// \d{3}: 0~9 ������ ���� 3��
    }
     
   
   
	
	public static void main(String[] args) {
	
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		
		System.out.println(PhoneNumber(str));
		// System.out.println(Zip(str));
		// System.out.println(Email(str));
	}
}