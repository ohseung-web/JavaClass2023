package bookShop;
import java.util.*;
public class BookMain {

	public static void main(String[] args) {

		BookList booklist = new BookList();
		booklist.addBook(new BookVO("�ڹ�","ȫ�浿","�ڸ������ǻ�",new Date(2010,5,6),35000));
		booklist.addBook(new BookVO("�ڹ�","��浿","�ڸ������ǻ�",new Date(2011,7,10),45000));
		booklist.addBook(new BookVO("�ڹ�","�ڱ浿","�ڸ������ǻ�",new Date(2015,8,12),25000));
		booklist.addBook(new BookVO("�ڹ�","�ֱ浿","�ڸ������ǻ�",new Date(2009,10,8),15000));
		booklist.addBook(new BookVO("�ڹ�","���浿","�ڸ������ǻ�",new Date(2018,11,25),55000));
		System.out.println(booklist);
	}

}
