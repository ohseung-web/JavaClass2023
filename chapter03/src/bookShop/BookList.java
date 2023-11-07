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

	// ���
	@Override
	public String toString() {
		String str = "";	
		int total = 0;
		System.out.println("==========================================");
		System.out.println("������        ����           ���ǻ�              ������                 ����     ");
		System.out.println("==========================================");
		for (int i = 0; i < booklist.size(); i++) {
			System.out.println(booklist.get(i).toString());
			total = total + booklist.get(i).getPrice();
		}
		DecimalFormat de = new DecimalFormat("#,##0��");
		System.out.println("==========================================");
		System.out.println("�հ� : " + de.format(total));
		System.out.println("==========================================");
		return str;
	}

	// �߰�
	public void addBook(BookVO vo) {
		booklist.add(vo);
	}
}
