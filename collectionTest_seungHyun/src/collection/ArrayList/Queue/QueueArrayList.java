package collection.ArrayList.Queue;

import java.util.ArrayList;

public class QueueArrayList {
   private ArrayList<String> arrayQueue = new ArrayList<>();
   public QueueArrayList() {}
   
   // queue의 저장은 enqueue 이다.
   public void enQueue(String data) {
	   arrayQueue.add(data);
   }
   
   // queue의 삭제는 dequeue 이다. Queue는 FIFO이다.
   public String deQueue() {
	   int len = arrayQueue.size();
	   if(len == 0) {
		   System.out.println("큐가 비어있습니다.");
		   return null;
	   }
	   return arrayQueue.remove(0);// remove(0)은 첫번째 데이터 삭제
   }
   
}
