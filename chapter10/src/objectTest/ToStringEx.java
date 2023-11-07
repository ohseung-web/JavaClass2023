package objectTest;

class Book{
	String title;
	String author;

	public Book(String title, String author) {
		this.title = title;
		this.author = author;
	}

	@Override
	public String toString() {
		return "책이름 : "+ title + " ,저자 :"+ author;
	}
	
	
	
}
public class ToStringEx {
	public static void main(String[] arg) {

		Book book = new Book("자바의 정석","남궁성");
		System.out.println(book);
		
		String str = new String("test");
		//System.out.println(str);
		
		
		
	}
}
