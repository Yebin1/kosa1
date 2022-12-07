import java.io.Serializable;

public class Book implements Serializable {

      public final String isbn;
      public String title;
      public int price;

      public Book(String isbn, String title,int price){
             this.isbn = isbn;
             this.title = title;
             this.price = price;
      }
      
      

      public String getIsbn() {
		return isbn;
	}



	public String getTitle() {
		return title;
	}



	public int getPrice() {
		return price;
	}



	public String ISBN(){
             return isbn;
      }

      public String toString(){
             return String.format("ISBN: %s 이름: %s 가격: %d", isbn, title, price);
      }
}
