package collection.ArrayList.Stack;

public class StackTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         
		StackArrayLsit stack = new StackArrayLsit();
		stack.push("a");
		stack.push("b");
		stack.push("c");
		
		System.out.println(stack.peek());
		System.out.println(stack.peek());
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
	}

}
