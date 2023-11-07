package collection.ArrayList;

import java.util.ArrayList;

class MyStack {
	private ArrayList<String> arraystack = new ArrayList<>();
	
	public void push(String data) { // stack에 자료 추가
		arraystack.add(data);
	}
	
	public String pop() {  // stack에서 자료 삭제
		
		// stack에 자료가 존재하지 않을때
		int len = arraystack.size();
		if(len == 0){
			System.out.println("스택이 비어 있습니다.");
			return null;
		}
		return arraystack.remove(arraystack.size()-1);
		
	}
	
	public String peek() { // 맨 위에 있는 자료를 꺼내보는 것(단, 삭제되지 않는다)
		int len = arraystack.size();
		if(len == 0){
			System.out.println("스택이 비어 있습니다.");
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
