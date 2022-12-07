// 0829

package kr.or.kosa;

/*
1. 책은 책 이름과 가격 정보를 가지고 있다
2. 책이 출판되면 반드시 책 이름과 가격 정보를 가지고 있어야 한다
3. 책의 이름과 가격 정보는 특정 기능을 통해서만 볼 수 있고 출판된 이후에는 수정할 수 없다
4. 책의 이름과 가격 정보는 각각 확인할 수 있다
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
		System.out.printf("책의 이름: %s\n", name);
	}
	public void bookPricePrint() {
		System.out.printf("책의 번호: %d\n", price);
	}
	
	public static void main(String[] args) {
	Book book = new Book("가나다", 5000);
	book.bookNamePrint();
	book.bookNumberPrint();
	}

	*/
	
	public void bookInfo() {
		System.out.printf("책의 이름: %s, 가격: %d\n", name, price);
	}
	
	// 조건 4번 위해 각각 getter 만들 것
	public String getname() {
		return name;
	}
	public int getprice() {
		return price;
	}
	
	public static void main(String[] args) {
		Book book = new Book("홍길동전", 5000);
		book.bookInfo();
		System.out.println(book.getname());
		System.out.println(book.getprice());
		}
	
}
