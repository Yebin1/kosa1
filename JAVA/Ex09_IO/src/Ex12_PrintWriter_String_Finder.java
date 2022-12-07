import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Ex12_PrintWriter_String_Finder {
	
	String baseDir = "C:\\Temp";	// 검색할 디렉토리
	String word = "HELLO";			// 검색할 단어
	String savetxt = "result.txt";	// HELLO 단어가 들어있는 파일의 정보를 저장
		
	void Find() throws IOException {	// Find() 사용 시 try-catch를 통해 예외 처리 강제
		File dir = new File(baseDir);
		if (!dir.isDirectory()) {
			System.out.println("유효한 폴더가 아님");
			System.exit(0);
		}
		
		PrintWriter writer = new PrintWriter(new FileWriter(savetxt));
		BufferedReader br = null;
		
		File[] files = dir.listFiles();
		for (int i = 0; i < files.length; i++) {
			if (!files[i].isFile()) {
				continue;	// 아래 코드 무시
			}
			// 파일인 경우
			br = new BufferedReader(new FileReader(files[i]));
			
			// a.txt
			// a.txt 한 줄씩 read
			String line = "";
			while((line = br.readLine()) != null) {
				// 단어 검색
				if (line.indexOf(word) != -1) {
					// a.txt 한 줄씩 읽어서 그 문장 안에 HELLO 단어가 하나라도 존재한다면
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
