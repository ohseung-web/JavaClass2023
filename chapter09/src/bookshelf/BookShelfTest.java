package bookshelf;

public class BookShelfTest {

	public static void main(String[] args) {
		//Queue shelfQueue = new BookShelf();
		BookShelf book = new BookShelf();
		
		System.out.println("�Է� ���� :");
		book.inQueue("�ξ����4");
		book.inQueue("�ξ����1");
		book.inQueue("�ξ����5");
		book.inQueueshwoInfo();
		System.out.println("==========");
		//shelfQueue.inQueue("�¹���1");
		//shelfQueue.inQueue("�¹�2");
		//shelfQueue.inQueue("��3");
		System.out.println("��� ����");
		book.deQueueshwoInfo();
		//System.out.println(book.deQueue());
		//System.out.println(book.deQueue());
		//System.out.println(book.deQueue());
		//System.out.println(shelfQueue.deQueue());
		//System.out.println(shelfQueue.deQueue());
		//System.out.println(shelfQueue.deQueue());
	}

}
