import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Ex12_PrintWriter_String_Finder {
	
	String baseDir = "C:\\Temp";	// �˻��� ���丮
	String word = "HELLO";			// �˻��� �ܾ�
	String savetxt = "result.txt";	// HELLO �ܾ ����ִ� ������ ������ ����
		
	void Find() throws IOException {	// Find() ��� �� try-catch�� ���� ���� ó�� ����
		File dir = new File(baseDir);
		if (!dir.isDirectory()) {
			System.out.println("��ȿ�� ������ �ƴ�");
			System.exit(0);
		}
		
		PrintWriter writer = new PrintWriter(new FileWriter(savetxt));
		BufferedReader br = null;
		
		File[] files = dir.listFiles();
		for (int i = 0; i < files.length; i++) {
			if (!files[i].isFile()) {
				continue;	// �Ʒ� �ڵ� ����
			}
			// ������ ���
			br = new BufferedReader(new FileReader(files[i]));
			
			// a.txt
			// a.txt �� �پ� read
			String line = "";
			while((line = br.readLine()) != null) {
				// �ܾ� �˻�
				if (line.indexOf(word) != -1) {
					// a.txt �� �پ� �о �� ���� �ȿ� HELLO �ܾ �ϳ��� �����Ѵٸ�
					writer.write("word = " + files[i].getAbsolutePath() + "\n");
				}
			}
			writer.flush();
		}
		br.close();
		writer.close();
	}
	
	
	public static void main(String[] args) {
		
		Ex12_PrintWriter_String_Finder finder = new Ex12_PrintWriter_String_Finder();
		
		try {
			finder.Find();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		/* result.txt
		word = C:\Temp\a.txt
		word = C:\Temp\new.txt
		*/
		
	}

}
