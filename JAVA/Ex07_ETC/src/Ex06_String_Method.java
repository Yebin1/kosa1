import java.util.StringTokenizer;

// 0902

public class Ex06_String_Method {

	public static void main(String[] args) {
		
		String str = "hello";
		String concatstr = str.concat(" world");
		System.out.println(concatstr);
		
		boolean bo = str.contains("ell");				// ell를 포함하고 있는지 >> true
		boolean bo1 = str.contains("elo");				// elo를 포함하고 있는지 >> false
		
		System.out.println(bo);
		
		String str2 = "a b c d";
		// [a][ ][b][ ][c][ ][d]
		System.out.println(str2.length());				// 공백: 문자 >> 7
		
		String filename = "hello java world";
		System.out.println(filename.indexOf(" "));		// 공백의 순서 >> 5
		System.out.println(filename.indexOf("java"));	// 6
		System.out.println(filename.indexOf("없는 값"));	// -1 (찾고자 하는 값이 없다)
		
		// 신문 사설에서 원하는 단어를 검색할 때 indexOf 사용
		// 내가 원하는 문자열의 해당 사설 내 포함 여부를 파악
		
		if (filename.indexOf("wow") != -1 ) {
			System.out.println("wow 단어가 하나 이상 있다");
		} else System.out.println("wow 단어가 없다");
		
		System.out.println(filename.lastIndexOf("a"));	// 가장 마지막에 있는 a 찾기 >> 9
		
		// length(), indexOf(), substring(), replace(), split()
		
		String result = "superman";
		System.out.println(result.substring(5));		// 해당 index부터 출력 	>> man
		System.out.println(result.substring(3, 5));		// 해당 index 범위 출력	>> er
		// beginIndex - the beginning index, inclusive.
		// endIndex - the ending index, exclusive. 		>> endindex -1
		System.out.println(result.substring(0, 0));		// 아무것도 안 나옴
		
		// Quiz
		String filename2 = "home.jpeg";					// or h.png or aaaaa.hwp
		// 파일명과 확장자를 분리하여 출력
		int filename3 = filename2.indexOf(".");
		System.out.println("파일명: " + filename2.substring(0, filename3));
		System.out.println("확장자명: " + filename2.substring(filename3+1));
		
		// replace 치환 함수
		String str3 = "ABCDADDDDDA";
		String result3 = str3.replace("DDDDD", "오늘은 금요일");
		System.out.println(result3);					// ABCDA오늘은 금요일A
		
		result3 = str3.replace("A", "a");				
		System.out.println(result3);					// aBCDaDDDDDa
		
		// ETC
		System.out.println(str3.charAt(2));				// C
		System.out.println(str3.endsWith("DDDA")); 		// 끝에서부터 있는지 확인 >> true
		System.out.println(str3.equalsIgnoreCase(str3));// 대소문자 구별없이 비교 >> true
		
		System.out.println(str3.equalsIgnoreCase("aBCDaddddda"));	
		
		// Today Point
		String str4 = "슈퍼맨, 팬티, 노란색, 우하하, 우하하";
		String[] namearray = str4.split(", ");
		for (String s: namearray) {
			System.out.println(s);
		}
		System.out.println("----------");
		String str5 = "슈퍼맨.팬티.노란색.우하하.우하하";
		String[] namearray2 = str5.split(".");
		for (String s: namearray2) {
			System.out.println(s);
		}
		System.out.println("----------");
		String str6 = "슈퍼맨.팬티.노란색.우하하.우하하";
		String[] namearray3 = str6.split("\\.");		// escape sequence
		for (String s: namearray3) {
			System.out.println(s);
		}
		
		// 정규표현식 (문자를 조합해 규칙을 만들고 그 규칙과 데이터를 비교, 판단)
		// 우편번호: {\d3}-{\d3} >> 12-123 (false), 123*123 (false), 111-111 (true)
		
		// 정규 표현식 (java, javascript, Oracle, C#) 표준
		// 핸드폰, 차량 번호, 도메인 주소, 이메일 정규표현으로 구현 >> 입력한 데이터의 유효성 검증
		
		String filename4 = "kosa.hwp";
		// 파일명과 확장자를 분리하여 출력
		String [] f1 = filename4.split("\\.");
		for (String f: f1) {
			System.out.println(f);
		}
		
		String str7 = "a/b,c-d.f";
		StringTokenizer sto = new StringTokenizer(str7, "/,-.");
		while (sto.hasMoreElements()) {
			System.out.println(sto.nextToken());		// abcdf
		}
		
		String str8 = "홍     길     동";
		// 저장 >> 공백 제거 >> "홍길동"
		System.out.println(str8.replace(" ", ""));
		
		String str9 = "     홍길동     ";
		System.out.println(">" + str9.trim() + "<");
		
		// 이렇게 하지 말기
		String str10 = "     홍     길     동     ";
		String result10 = str10.trim();
		System.out.println(">" + result10.replace(" ", "") + "<");
		
		// 여러 개의 함수를 사용할 경우 method chain 기법을 사용
		System.out.println(">" + str10.trim().replace(" ", "") + "<");
		
		
		//Quiz
		  String jumin="123456-1234567";
		   //위 주민번호의 합을 구하세요_1
		   int sum2=0;
		   for(int i = 0 ; i < jumin.length() ; i++) {
			   String numstr =jumin.substring(i, i+1);
			   if(numstr.equals("-")) continue;
			   sum2+= Integer.parseInt(numstr);
		   } 
		   System.out.println("주민번호 합:" + sum2);
		   
		 //위 주민번호의 합을 구하세요_2
		 //String jumin="123456-1234567";
		   String[] numarr2 = jumin.replace("-","").split("");
		   int sum3=0;
		   for(String i : numarr2) {
			   sum3+= Integer.parseInt(i);
		   }
		   System.out.println("주민번호 합2:" + sum3);
		   
		 //위 주민번호의 합을 구하세요_3
		   String jumin4 = jumin.replace("-", "");
		   int sum4=0;
		   for(int i = 0 ; i < jumin4.length() ;i++) {
			   sum4+=Integer.parseInt(String.valueOf(jumin4.charAt(i)));
		   }
		   System.out.println("주민번호 합4:" + sum4);
		
	}

}
