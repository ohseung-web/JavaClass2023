package bookshelf;

public interface Queue {
	void inQueue(String title); //�� �ڷ� ���� �ֱ�
	String deQueue(); // ���ױ�, FIFO
	int getSize();
}
