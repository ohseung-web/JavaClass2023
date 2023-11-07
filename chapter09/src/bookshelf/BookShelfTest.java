package bookshelf;

public class BookShelfTest {

	public static void main(String[] args) {
		//Queue shelfQueue = new BookShelf();
		BookShelf book = new BookShelf();
		
		System.out.println("입력 순서 :");
		book.inQueue("인어공주4");
		book.inQueue("인어공주1");
		book.inQueue("인어공주5");
		book.inQueueshwoInfo();
		System.out.println("==========");
		//shelfQueue.inQueue("태백산맥1");
		//shelfQueue.inQueue("태백2");
		//shelfQueue.inQueue("태3");
		System.out.println("출력 순서");
		book.deQueueshwoInfo();
		//System.out.println(book.deQueue());
		//System.out.println(book.deQueue());
		//System.out.println(book.deQueue());
		//System.out.println(shelfQueue.deQueue());
		//System.out.println(shelfQueue.deQueue());
		//System.out.println(shelfQueue.deQueue());
	}

}
