package collection.ArrayList.Queue;

public class QueueTesst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          QueueArrayList queue = new QueueArrayList();
          queue.enQueue("a");
          queue.enQueue("b");
          queue.enQueue("c");
          
          System.out.println(queue.deQueue());
          System.out.println(queue.deQueue());
          System.out.println(queue.deQueue());
	}

}
