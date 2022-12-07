import java.io.File;

// 0915

public class Ex08_File_Dir {

	public static void main(String[] args) {
		// System.out.println(args[0]);
		if (args.length != 1) {
			System.out.println("����: java ���ϸ� [���丮]");
			System.exit(0);	// ���� ����
		}
		// java Ex08_File_Dir C:\\Temp
		File f = new File(args[0]);
		if(!f.exists() || !f.isDirectory()) {
			// �� �� �ϳ��� �������� �ʴ´ٸ�
			// �������� �ʰų� ���丮�� �ƴ϶��
			System.out.println("��ȿ���� ���� ����Դϴ�");
			System.exit(0);
		}
		
		// ������ �����ϴ� ����̸� ������ ���� �������
		// Point
		File[] files = f.listFiles();
		// C:\\Temp ���� ������ ������ �迭�� ���
		// [a.txt] [b.txt] [] []
		// System.out.println(files.length);
		
		for (int i = 0; i < files.length; i++) {
			String name = files[i].getName();
			System.out.println(files[i].isDirectory() ? "[DIR]" + name : name);
		}
		
	}

}
