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
		return "ISBN: " + number + "  ����: " + name + "  ����: " + price;
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
	
		System.out.println("�߰��� ���� ISBN: ");
		number = Integer.parseInt(scan.nextLine());
	
		System.out.println("���� ����: ");
		name = scan.nextLine();
	
		System.out.println("����: ");
		price = Integer.parseInt(scan.nextLine());
	
		list.put(number, new Book(number, name, price));
	
		System.out.println("ISBN: " + number + "  ����: " + name + "  ����: " + price + "  �߰��Ͽ����ϴ�.");
	}

	public void removeBook() {
		
		int number;
		//String name;
		//int price;
	
		System.out.println("������ ���� ISBN: ");
		number = Integer.parseInt(scan.nextLine());

		System.out.println(((Book)list.get(number)).getName() + " �� �����Ǿ����ϴ�.");
		Object value = list.remove(number);
	}

	public void searchBook() {
		
		int number;
		//String name;
		//int price;
	
		System.out.println("�˻��� ���� ISBN: ");
		number = Integer.parseInt(scan.nextLine());
	
		System.out.println("�˻� ��� >> ISBN: " + number + "  ����: " + ((Book)list.get(number)).getName() + "  ����: " + ((Book)list.get(number)).getPrice());
	}

	public void bookList() {

		System.out.println("���� ���");
		System.out.println("���� ��: " + list.size());
		
		Set set = list.keySet();
		Iterator it = set.iterator();
		
		while (it.hasNext()) {
			System.out.println(((Book)list.get(it.next())).toString());
		}
	}

	public void isbnList() {
		
		System.out.println("ISBN ���");
		System.out.println("���� ��: " + list.size());
	
		//for (int i = 0; i < list.size(); i++) {
			System.out.println(list.keySet()/*.toArray()[i]*/);
		//}
	
	}



	// ��� �Լ�
	public void printmenu() {
	
	while (true) {
		System.out.println("1: �߰�  2: ����  3: �˻�  4: ���� ���  5: ISBN ���  0: ����");
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
			System.out.println("���α׷��� �����մϴ�.");
			System.exit(0);
			break;
	
		default:
			System.out.println("�߸��� �Է°��Դϴ�.");
			System.out.println("�ٽ� �Է��� �ּ���.");
		}
	}

	}


}
