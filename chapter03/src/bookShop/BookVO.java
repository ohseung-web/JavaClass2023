package bookShop;

import java.text.*;
import java.util.*;

public class BookVO {

	private String booktitle;	// ������
    private String author; // ����
    private String publisher; //���ǻ�
    private Date date; //������
    private int price; // ����
   
   public String getBooktitle() {
		return booktitle;
	}
	public void setBooktitle(String booktitle) {
		this.booktitle = booktitle;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
public BookVO() { }
   public BookVO(String booktitle, String author, String publisher, Date date, int price ) {
	this.booktitle = booktitle;
	this.author = author;
	this.publisher = publisher;
	this.price = price;
	
	// Date �ڷ������� ��, ��, ���� ���� �Է� �޴´�.
	 date.setYear(date.getYear()-1900);
	 date.setMonth(date.getMonth()-1);
	 date.setDate(date.getDate());
	  
	 this.date = date;
   }
    
   @Override
    public String toString() {
	 
	  SimpleDateFormat sd = new SimpleDateFormat("yyyy.MM.dd(E)");
	  DecimalFormat de = new DecimalFormat("#,##0��");
	  return String.format("%s \t\t%s \t%s \t%s %s", booktitle,author,publisher,sd.format(date),de.format(price));
   }
}
