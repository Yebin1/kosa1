import java.io.File;
import java.util.Scanner;

public class Dos0916 {

	public static void main(String[] args) throws Exception {
		
		Scanner scan = new Scanner(System.in);
				
		if (args[1].equals("mkdir")) {
			
			File f = new File(args[0]);
		
			System.out.println("생성할 폴더의 이름을 입력해주세요.");
			
			String path2 = scan.nextLine();
			String path = f + "\\" + path2;
			File folder = new File(path);
			
			if (!f.exists()) {
				System.out.println("존재하지 않는 폴더입니다.");
				System.exit(0);
			} else if (!f.isDirectory()) {
				System.out.println("폴더가 아닙니다.");
				System.exit(0);
			}
			
			if (folder.exists()) {
				System.out.println("이미 존재하는 폴더입니다.");
			} else {
				folder.mkdir();
				System.out.println(path + " 폴더가 생성되었습니다.");
			}
		}
	}		
}

