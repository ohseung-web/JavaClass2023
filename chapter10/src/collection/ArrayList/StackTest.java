package collection.ArrayList;

import java.util.ArrayList;

class MyStack {
	private ArrayList<String> arraystack = new ArrayList<>();
	
	public void push(String data) { // stack�� �ڷ� �߰�
		arraystack.add(data);
	}
	
	public String pop() {  // stack���� �ڷ� ����
		
		// stack�� �ڷᰡ �������� ������
		int len = arraystack.size();
		if(len == 0){
			System.out.println("������ ��� �ֽ��ϴ�.");
			return null;
		}
		return arraystack.remove(arraystack.size()-1);
		
	}
	
	public String peek() { // �� ���� �ִ� �ڷḦ �������� ��(��, �������� �ʴ´�)
		int len = arraystack.size();
		if(len == 0){
			System.out.println("������ ��� �ֽ��ϴ�.");
			return null;
		}
		return arraystack.get(arraystack.size()-1);
	}
}

public class StackTest {

	public static void main(String[] args) {
          
		MyStack mystack = new MyStack();
		mystack.push("a");
		mystack.push("b");
		mystack.push("s");
		
		System.out.println(mystack.peek());
		System.out.println(mystack.peek());
		
		System.out.println(mystack.pop());
		System.out.println(mystack.pop());
		System.out.println(mystack.pop());
		
		System.out.println(mystack.pop());
		
	}

}
