import java.io.File;
import java.util.Scanner;

public class Dos0916 {

	public static void main(String[] args) throws Exception {
		
		Scanner scan = new Scanner(System.in);
				
		if (args[1].equals("mkdir")) {
			
			File f = new File(args[0]);
		
			System.out.println("������ ������ �̸��� �Է����ּ���.");
			
			String path2 = scan.nextLine();
			String path = f + "\\" + path2;
			File folder = new File(path);
			
			if (!f.exists()) {
				System.out.println("�������� �ʴ� �����Դϴ�.");
				System.exit(0);
			} else if (!f.isDirectory()) {
				System.out.println("������ �ƴմϴ�.");
				System.exit(0);
			}
			
			if (folder.exists()) {
				System.out.println("�̹� �����ϴ� �����Դϴ�.");
			} else {
				folder.mkdir();
				System.out.println(path + " ������ �����Ǿ����ϴ�.");
			}
		}
	}		
}

