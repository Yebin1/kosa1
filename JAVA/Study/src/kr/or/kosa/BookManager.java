package kr.or.kosa;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;



class Book {
	private int number;
	private String name;
	private int price;
	
	public Book(int number, String name, int price) {
		super();
		this.number = number;
		this.name = name;
		this.price = price;
	}
	
	public int getNumber() {
		return number;
	}


	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	
	@Override
	public String toString() {
		return "ISBN: " + number + "  제목: " + name + "  가격: " + price;
	}
	
}

public class BookManager {
		
	Scanner scan = new Scanner(System.in);
	HashMap<Integer, Book> list;
	
	public BookManager() {
		list = new HashMap<Integer, Book>();
	}
	

	
	public void addBook() {
	
		int number;
		String name;
		int price;
	
		System.out.println("추가할 도서 ISBN: ");
		number = Integer.parseInt(scan.nextLine());
	
		System.out.println("도서 제목: ");
		name = scan.nextLine();
	
		System.out.println("가격: ");
		price = Integer.parseInt(scan.nextLine());
	
		list.put(number, new Book(number, name, price));
	
		System.out.println("ISBN: " + number + "  제목: " + name + "  가격: " + price + "  추가하였습니다.");
	}

	public void removeBook() {
		
		int number;
		//String name;
		//int price;
	
		System.out.println("삭제할 도서 ISBN: ");
		number = Integer.parseInt(scan.nextLine());

		System.out.println(((Book)list.get(number)).getName() + " 가 삭제되었습니다.");
		Object value = list.remove(number);
	}

	public void searchBook() {
		
		int number;
		//String name;
		//int price;
	
		System.out.println("검색할 도서 ISBN: ");
		number = Integer.parseInt(scan.nextLine());
	
		System.out.println("검색 결과 >> ISBN: " + number + "  제목: " + ((Book)list.get(number)).getName() + "  가격: " + ((Book)list.get(number)).getPrice());
	}

	public void bookList() {

		System.out.println("도서 목록");
		System.out.println("도서 수: " + list.size());
		
		Set set = list.keySet();
		Iterator it = set.iterator();
		
		while (it.hasNext()) {
			System.out.println(((Book)list.get(it.next())).toString());
		}
	}

	public void isbnList() {
		
		System.out.println("ISBN 목록");
		System.out.println("도서 수: " + list.size());
	
		//for (int i = 0; i < list.size(); i++) {
			System.out.println(list.keySet()/*.toArray()[i]*/);
		//}
	
	}



	// 출력 함수
	public void printmenu() {
	
	while (true) {
		System.out.println("1: 추가  2: 삭제  3: 검색  4: 도서 목록  5: ISBN 목록  0: 종료");
		int choice = Integer.parseInt(scan.nextLine());
		
		switch (choice) {
	
		case 1: addBook();
			break;
	
		case 2: removeBook();
			break;
		
		case 3: searchBook();
			break;
		
		case 4: bookList();
			break;
	
		case 5: isbnList();
			break;
		
		case 0: 
			System.out.println("프로그램을 종료합니다.");
			System.exit(0);
			break;
	
		default:
			System.out.println("잘못된 입력값입니다.");
			System.out.println("다시 입력해 주세요.");
		}
	}

	}


}
