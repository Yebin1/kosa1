// 0829

package kr.or.kosa;

/*
1. å�� å �̸��� ���� ������ ������ �ִ�
2. å�� ���ǵǸ� �ݵ�� å �̸��� ���� ������ ������ �־�� �Ѵ�
3. å�� �̸��� ���� ������ Ư�� ����� ���ؼ��� �� �� �ְ� ���ǵ� ���Ŀ��� ������ �� ����
4. å�� �̸��� ���� ������ ���� Ȯ���� �� �ִ�
*/

public class Book {
	private String name;
	private int price;
	
	public Book(String na, int nu) {
		name = na;
		price = nu;
	}
	
	/*
	public void bookNamePrint() {
		System.out.printf("å�� �̸�: %s\n", name);
	}
	public void bookPricePrint() {
		System.out.printf("å�� ��ȣ: %d\n", price);
	}
	
	public static void main(String[] args) {
	Book book = new Book("������", 5000);
	book.bookNamePrint();
	book.bookNumberPrint();
	}

	*/
	
	public void bookInfo() {
		System.out.printf("å�� �̸�: %s, ����: %d\n", name, price);
	}
	
	// ���� 4�� ���� ���� getter ���� ��
	public String getname() {
		return name;
	}
	public int getprice() {
		return price;
	}
	
	public static void main(String[] args) {
		Book book = new Book("ȫ�浿��", 5000);
		book.bookInfo();
		System.out.println(book.getname());
		System.out.println(book.getprice());
		}
	
}
