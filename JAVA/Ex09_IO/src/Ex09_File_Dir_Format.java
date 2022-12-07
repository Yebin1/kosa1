// 0915

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex09_File_Dir_Format {
 
	public static void main(String[] args) {
		File dir = new File("C:\\Temp");
		File[] files = dir.listFiles();
		
		for (int i = 0; i < files.length; i++) {
			File file = files[i];
			String name = file.getName();	// 폴더명 or 파일명
			SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd HH-mm a");
			String attribute = "";
			String size = "";
			
			if (files[i].isDirectory()) {
				attribute = "< DIR >";
			} else {	// 전부 파일
				size = file.length() + "byte";
				attribute = file.canRead() ? "R" : "";
				attribute += file.canWrite() ? "W" : "";
				attribute += file.isHidden() ? "H" : "";
			}
			System.out.printf("%s  %3s  %10s  %s  \n",
					dt.format(new Date(file.lastModified())),
					attribute, size, name);
		}
		
	}

}
