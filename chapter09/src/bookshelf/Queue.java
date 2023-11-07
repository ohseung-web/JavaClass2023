package bookshelf;

public interface Queue {
	void inQueue(String title); //맨 뒤로 집어 넣기
	String deQueue(); // 꺼네기, FIFO
	int getSize();
}
