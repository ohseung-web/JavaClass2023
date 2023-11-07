package collection.ArrayList;

import java.util.ArrayList;

class MyQueue{
	private ArrayList<String> arrayqueue = new ArrayList<>();
	
	public void enQueue(String data) { // ť ������ �߰�
		arrayqueue.add(data);
	}
	
	public String deQueue() {  // ť ������ ����
		int len = arrayqueue.size();
		if(len == 0) {
			System.out.println("ť�� ����ֽ��ϴ�.");
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
