import kr.or.kosa.Mouse;
import kr.or.kosa.NoteBook;

public class Ex04_Modifier {

	public static void main(String[] args) {
		NoteBook notebook = new NoteBook();
		notebook.setYear(2022);
		int year = notebook.getYear();
		System.out.println("year: " + year);
		
		/*
		notebook.number = -100;
		notebook.mouse.x = 5;
		notebook.mouse.y = 4;
		*/
		
		Mouse mouse = new Mouse(); // 마우스가 메모리에 (heap)
		
		System.out.println(mouse.x + ": " + mouse.y);
		notebook.handle(mouse);
		System.out.println(mouse.x + ": " + mouse.y);
		
		
		
		
	}

}
