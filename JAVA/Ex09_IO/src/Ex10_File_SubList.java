import java.io.File;
import java.util.ArrayList;
import java.util.List;
 
// 0916 
public class Ex10_File_SubList {

	static int totalfiles = 0;	// ���� ����
	static int totaldirs = 0;	// ���� ����
	
	static void printFileList (File dir) {
		System.out.println("Full Path: " + dir.getAbsolutePath());
		 
		// �ڵ� ... ����
		List<Integer> subdir = new ArrayList<Integer>();
		File[] files = dir.listFiles(); // ���� �ڿ� ������ ���� �� ... �ϳ� �ϳ��� file ��ü
		// [0] > a.txt		>> �� ���� File Ÿ��
		// [1] > aaa ����
		// [2] > bbb ����
		// [3] > java.jpg
		for (int i = 0; i < files.length; i++) {
			String filename = files[i].getName();	// ������ �Ǵ� ���ϸ�
			if (files[i].isDirectory()) {			// ����
				filename = "[ DIR ]" + filename;
				// Point
				subdir.add(i);	// ������ �ε��� ��(i)�� arraylist��
				// subdir[0] >> 1
				// subdir[1] >> 2
			} else {
				filename = filename + "/" + files[i].length() + "byte";
			}
		}
		
		// ���� ���� Ȯ��
		int dirnum = subdir.size();	// ���� �־��� ������ ���� ���� ����
		int filenum = files.length - dirnum;
		
		// ���� ���� (���� ���� ���� �ڿ�)
		totaldirs += dirnum;	// �� ������ ���� ���� (������ �������� ����)
		totalfiles += filenum;	// �� ������ ���� ���� (������ �������� ����)
		
		System.out.println("[Current DirNum]: " + dirnum);
		System.out.println("[Current FileNum]: " + filenum);
		System.out.println("---------------------------------------------");
		
		// Point (���� ������ ���� ���� ����)
		// [0] > a.txt
		// [1] > aaa ����		>> a-1 ����, a-2 ����
		// [2] > bbb ����		>> b-1 ����, b.txt, b-1.jpg
		// [3] > java.jpg
		for (int i = 0; i < subdir.size(); i++) {	// ���� ������ ������ŭ
			int index = subdir.get(i);	// ������ �� ��ġ��
			//�� ���� �ڵ�
			printFileList(files[index]);// ��� ȣ�� (�ڱ� �ڽ��� ȣ��)
			
		}
		
	}
	

	public static void main(String[] args) {
		
		if (args.length != 1) {
			System.out.println("����: java [���� ���ϸ�] [��θ�]");
			System.out.println("����: java Ex10_File_SubList C:\\Temp");
			System.exit(0);
		}
		
		File f = new File(args[0]);	// == File f = new File("C:\\Temp); 
		if (!f.exists() || !f.isDirectory()) {
			// �������� �ʰų� ���丮�� �ƴ϶��
			System.out.println("��ȿ���� ���� ���丮");
			System.exit(0);
		}
		
		// �������� ��� �׸��� ����
		printFileList(f);	// ȣ�� (�ݺ�)
		// ���� ���� �ȱ����� ���� ����, ���� ���� ����
		System.out.println("���� �� ���� ��: " + totalfiles);
		System.out.println("���� �� ���� ��: " + totaldirs);
		
	}

}
