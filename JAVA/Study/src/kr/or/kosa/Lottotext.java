package kr.or.kosa;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Random;




public class Lottotext {
	
	
	public void Write() {
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat dateformat = new SimpleDateFormat("[yyyy년 MM월 dd일 HH:mm]");
		String s2 = dateformat.format(cal.getTime());
		String number = "";
		
		for (int k = 0; k < 8; k++) {
			Random random = new Random();
			HashSet<Integer> lotto = new HashSet<Integer>();
			
			for (int i = 0; lotto.size() < 6; i++) {
				lotto.add(random.nextInt(45)+1);
			}
			
			number = "로또 번호: " + lotto.toString() + " " + s2;
			System.out.println(number);
		}
	
	
		FileReader fr = null;
		FileWriter fw = null;
		BufferedWriter bw = new BufferedWriter(fw);
		
		try {
			fw = new FileWriter("lottonumber.txt", true);
			
			fw.write(number);
			bw.newLine();
			
		} catch (Exception e) {} finally {
			try {
				fw.close();
				fr.close();
				bw.close();
			} catch (Exception e2) {}
		}
		
	}	
	
		
}
		
	