package bookShop;
import java.util.*;
public class BookMain {

	public static void main(String[] args) {

		BookList booklist = new BookList();
		booklist.addBook(new BookVO("자바","홍길동","코리아출판사",new Date(2010,5,6),35000));
		booklist.addBook(new BookVO("자바","김길동","코리아출판사",new Date(2011,7,10),45000));
		booklist.addBook(new BookVO("자바","박길동","코리아출판사",new Date(2015,8,12),25000));
		booklist.addBook(new BookVO("자바","최길동","코리아출판사",new Date(2009,10,8),15000));
		booklist.addBook(new BookVO("자바","오길동","코리아출판사",new Date(2018,11,25),55000));
		System.out.println(booklist);
	}

}
