
public class Ex07_Operation {

	public static void main(String[] args) {
		// 대입 연산자
		// +=, -=, *=, /=

		int sum = 0;
		sum += 1;		// sum = sum + 1;
		sum -= 1;
		System.out.println(sum);
		
		/*
		간단한 학점 계산기
		학점: A+, A-, B+, B-, ...F
		점수: 94점
		
		90점 이상		>> A
		95점 이상		>> A+
		90 ~ 94점	>> A-
		
		80점 이상 	>> B
		85점 이상 	>> B+
		80~84점 		>> B-
		*/
		
		int score2 = 88;
		String grade = "";	// A+, A- 를 담는 변수
		System.out.println("당신의 점수는: " + score2);
		/*
		// if문
		if(score2>=90) { grade = "A";
			if(score2>=95) {grade += "+";} else {grade += "-";}
		} else if(score2>=80) {	grade = "B";
			if(score2>=85) {grade += "+";} else {grade += "-";}
		} else grade = "C"; */
		
		if (score2 >= 90) {
			grade = "A";
			grade = (score2 >= 95) ? (grade += "+") : (grade += "-");
		} else if (score2 >= 80) {
			grade = "B";
			grade = (score2 >= 85) ? (grade += "+") : (grade += "-");
		} else {
			grade = "C";
		}
		
		System.out.println("당신의 학점은: " + grade);
		
	}

}
