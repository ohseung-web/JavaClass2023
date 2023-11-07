package collection.ArrayList;

import java.util.ArrayList;

class MyQueue{
	private ArrayList<String> arrayqueue = new ArrayList<>();
	
	public void enQueue(String data) { // 큐 데이터 추가
		arrayqueue.add(data);
	}
	
	public String deQueue() {  // 큐 데이터 삭제
		int len = arrayqueue.size();
		if(len == 0) {
			System.out.println("큐가 비어있습니다.");
			return null;
		}
		return arrayqueue.remove(0);
	}
}



public class QueueTest {

	public static void main(String[] args) {
            
		MyQueue myqueue = new MyQueue();
		myqueue.enQueue("a");
		myqueue.enQueue("b");
		myqueue.enQueue("c");
		
		System.out.println(myqueue.deQueue());
		System.out.println(myqueue.deQueue());
		System.out.println(myqueue.deQueue());
		System.out.println(myqueue.deQueue());
		
		
	}

}
