import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

// 0914

class QuizInfo {
	String question;
	String answer;
	String result;
	
	public QuizInfo(String question, String answer, String result) {
		super();
		this.question = question;
		this.answer = answer;
		this.result = result;
	}

	@Override
	public String toString() {
		return "QuizInfo [����=" + question + ", ���=" + answer + ", ���=" + result + "]";
	}
	
}


public class Ex16_Map_Generic {

	public static void main(String[] args) {
		
		HashMap<String, String> quiz = new HashMap<String, String>();
		quiz.put("1+1", "2");
		quiz.put("1+2", "3");
		quiz.put("1+3", "4");
	}

}
