import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

/* 0916

��� ���� ����
1. printf
2. String.format
3. PrintWriter (������)
4. ����: ������ ����Ʈ���� (�����: ��ǥ, ���� ��꼭, �ް� ������)
 * ũ����Ż ����Ʈ, ����



*/



public class Ex11_PrintWriter {

	public static void main(String[] args) {
		
		try {
			/*
			PrintWriter pw = new PrintWriter("C:\\Temp\\homework.txt");
			pw.println("************************************");
			pw.println("*             HOMEWORK             *");
			pw.println("************************************");
			pw.printf("%3s: %5d %5d %5d %5.1f", "�ƹ���", 100, 99, 80, (float)((100+99+80)/3));
			pw.println();
			pw.close();
			*/
			
			// read (line ����)
			FileReader fr = new FileReader("C:\\Temp\\homework.txt");
			BufferedReader br = new BufferedReader(fr);
			String s = "";
			
			while ((s = br.readLine()) != null) {
				System.out.println(s);
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			
		}

	}

}
