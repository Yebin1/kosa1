import java.util.StringTokenizer;

// 0902

public class Ex06_String_Method {

	public static void main(String[] args) {
		
		String str = "hello";
		String concatstr = str.concat(" world");
		System.out.println(concatstr);
		
		boolean bo = str.contains("ell");				// ell�� �����ϰ� �ִ��� >> true
		boolean bo1 = str.contains("elo");				// elo�� �����ϰ� �ִ��� >> false
		
		System.out.println(bo);
		
		String str2 = "a b c d";
		// [a][ ][b][ ][c][ ][d]
		System.out.println(str2.length());				// ����: ���� >> 7
		
		String filename = "hello java world";
		System.out.println(filename.indexOf(" "));		// ������ ���� >> 5
		System.out.println(filename.indexOf("java"));	// 6
		System.out.println(filename.indexOf("���� ��"));	// -1 (ã���� �ϴ� ���� ����)
		
		// �Ź� �缳���� ���ϴ� �ܾ �˻��� �� indexOf ���
		// ���� ���ϴ� ���ڿ��� �ش� �缳 �� ���� ���θ� �ľ�
		
		if (filename.indexOf("wow") != -1 ) {
			System.out.println("wow �ܾ �ϳ� �̻� �ִ�");
		} else System.out.println("wow �ܾ ����");
		
		System.out.println(filename.lastIndexOf("a"));	// ���� �������� �ִ� a ã�� >> 9
		
		// length(), indexOf(), substring(), replace(), split()
		
		String result = "superman";
		System.out.println(result.substring(5));		// �ش� index���� ��� 	>> man
		System.out.println(result.substring(3, 5));		// �ش� index ���� ���	>> er
		// beginIndex - the beginning index, inclusive.
		// endIndex - the ending index, exclusive. 		>> endindex -1
		System.out.println(result.substring(0, 0));		// �ƹ��͵� �� ����
		
		// Quiz
		String filename2 = "home.jpeg";					// or h.png or aaaaa.hwp
		// ���ϸ�� Ȯ���ڸ� �и��Ͽ� ���
		int filename3 = filename2.indexOf(".");
		System.out.println("���ϸ�: " + filename2.substring(0, filename3));
		System.out.println("Ȯ���ڸ�: " + filename2.substring(filename3+1));
		
		// replace ġȯ �Լ�
		String str3 = "ABCDADDDDDA";
		String result3 = str3.replace("DDDDD", "������ �ݿ���");
		System.out.println(result3);					// ABCDA������ �ݿ���A
		
		result3 = str3.replace("A", "a");				
		System.out.println(result3);					// aBCDaDDDDDa
		
		// ETC
		System.out.println(str3.charAt(2));				// C
		System.out.println(str3.endsWith("DDDA")); 		// ���������� �ִ��� Ȯ�� >> true
		System.out.println(str3.equalsIgnoreCase(str3));// ��ҹ��� �������� �� >> true
		
		System.out.println(str3.equalsIgnoreCase("aBCDaddddda"));	
		
		// Today Point
		String str4 = "���۸�, ��Ƽ, �����, ������, ������";
		String[] namearray = str4.split(", ");
		for (String s: namearray) {
			System.out.println(s);
		}
		System.out.println("----------");
		String str5 = "���۸�.��Ƽ.�����.������.������";
		String[] namearray2 = str5.split(".");
		for (String s: namearray2) {
			System.out.println(s);
		}
		System.out.println("----------");
		String str6 = "���۸�.��Ƽ.�����.������.������";
		String[] namearray3 = str6.split("\\.");		// escape sequence
		for (String s: namearray3) {
			System.out.println(s);
		}
		
		// ����ǥ���� (���ڸ� ������ ��Ģ�� ����� �� ��Ģ�� �����͸� ��, �Ǵ�)
		// �����ȣ: {\d3}-{\d3} >> 12-123 (false), 123*123 (false), 111-111 (true)
		
		// ���� ǥ���� (java, javascript, Oracle, C#) ǥ��
		// �ڵ���, ���� ��ȣ, ������ �ּ�, �̸��� ����ǥ������ ���� >> �Է��� �������� ��ȿ�� ����
		
		String filename4 = "kosa.hwp";
		// ���ϸ�� Ȯ���ڸ� �и��Ͽ� ���
		String [] f1 = filename4.split("\\.");
		for (String f: f1) {
			System.out.println(f);
		}
		
		String str7 = "a/b,c-d.f";
		StringTokenizer sto = new StringTokenizer(str7, "/,-.");
		while (sto.hasMoreElements()) {
			System.out.println(sto.nextToken());		// abcdf
		}
		
		String str8 = "ȫ     ��     ��";
		// ���� >> ���� ���� >> "ȫ�浿"
		System.out.println(str8.replace(" ", ""));
		
		String str9 = "     ȫ�浿     ";
		System.out.println(">" + str9.trim() + "<");
		
		// �̷��� ���� ����
		String str10 = "     ȫ     ��     ��     ";
		String result10 = str10.trim();
		System.out.println(">" + result10.replace(" ", "") + "<");
		
		// ���� ���� �Լ��� ����� ��� method chain ����� ���
		System.out.println(">" + str10.trim().replace(" ", "") + "<");
		
		
		//Quiz
		  String jumin="123456-1234567";
		   //�� �ֹι�ȣ�� ���� ���ϼ���_1
		   int sum2=0;
		   for(int i = 0 ; i < jumin.length() ; i++) {
			   String numstr =jumin.substring(i, i+1);
			   if(numstr.equals("-")) continue;
			   sum2+= Integer.parseInt(numstr);
		   } 
		   System.out.println("�ֹι�ȣ ��:" + sum2);
		   
		 //�� �ֹι�ȣ�� ���� ���ϼ���_2
		 //String jumin="123456-1234567";
		   String[] numarr2 = jumin.replace("-","").split("");
		   int sum3=0;
		   for(String i : numarr2) {
			   sum3+= Integer.parseInt(i);
		   }
		   System.out.println("�ֹι�ȣ ��2:" + sum3);
		   
		 //�� �ֹι�ȣ�� ���� ���ϼ���_3
		   String jumin4 = jumin.replace("-", "");
		   int sum4=0;
		   for(int i = 0 ; i < jumin4.length() ;i++) {
			   sum4+=Integer.parseInt(String.valueOf(jumin4.charAt(i)));
		   }
		   System.out.println("�ֹι�ȣ ��4:" + sum4);
		
	}

}
