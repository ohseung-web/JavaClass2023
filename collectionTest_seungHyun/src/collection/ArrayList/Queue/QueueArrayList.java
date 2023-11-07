package collection.ArrayList.Queue;

import java.util.ArrayList;

public class QueueArrayList {
   private ArrayList<String> arrayQueue = new ArrayList<>();
   public QueueArrayList() {}
   
   // queue�� ������ enqueue �̴�.
   public void enQueue(String data) {
	   arrayQueue.add(data);
   }
   
   // queue�� ������ dequeue �̴�. Queue�� FIFO�̴�.
   public String deQueue() {
	   int len = arrayQueue.size();
	   if(len == 0) {
		   System.out.println("ť�� ����ֽ��ϴ�.");
		   return null;
	   }
	   return arrayQueue.remove(0);// remove(0)�� ù��° ������ ����
   }
   
}
