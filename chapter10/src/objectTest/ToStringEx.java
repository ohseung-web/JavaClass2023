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
		return "å�̸� : "+ title + " ,���� :"+ author;
	}
	
	
	
}
public class ToStringEx {
	public static void main(String[] arg) {

		Book book = new Book("�ڹ��� ����","���ü�");
		System.out.println(book);
		
		String str = new String("test");
		//System.out.println(str);
		
		
		
	}
}
