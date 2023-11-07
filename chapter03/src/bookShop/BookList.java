package bookShop;

import java.util.*;
import java.text.*;

public class BookList {

	ArrayList<BookVO> booklist = new ArrayList<>();

	public ArrayList<BookVO> getBooklist() {
		return booklist;
	}

	public void setBooklist(ArrayList<BookVO> booklist) {
		this.booklist = booklist;
	}

	// 출력
	@Override
	public String toString() {
		String str = "";	
		int total = 0;
		System.out.println("==========================================");
		System.out.println("도서명        저자           출판사              출판일                 가격     ");
		System.out.println("==========================================");
		for (int i = 0; i < booklist.size(); i++) {
			System.out.println(booklist.get(i).toString());
			total = total + booklist.get(i).getPrice();
		}
		DecimalFormat de = new DecimalFormat("#,##0원");
		System.out.println("==========================================");
		System.out.println("합계 : " + de.format(total));
		System.out.println("==========================================");
		return str;
	}

	// 추가
	public void addBook(BookVO vo) {
		booklist.add(vo);
	}
}
