package collection.ArrayList.Stack;

import java.util.ArrayList;

public class StackArrayLsit {
    
	private ArrayList<String> arraystack = new ArrayList<>();
	
	public StackArrayLsit() {}
	
	// stack 저장하는 메서드 stack 저장은 push
	public void push(String data) {
		arraystack.add(data);
	}
	
	// stack 꺼내는 메서드 stack 꺼낼때는 pop
   public String pop() {
	   int len = arraystack.size(); 
	   if(len == 0) {
		   System.out.println("스택이 비어있습니다.");
		   return null;
	   }
 	  return arraystack.remove(len-1); // stack는 FILO이므로 삭제할때는 마지막 데이터 부터 size()-1 
   }
   
   // stack에서 peek은 맨 위의 데이터를 꺼내보는것, 삭제는 되지 않는다.
   public String peek(){ // get(i)와 같은 의미이다.
	   int len = arraystack.size();
	   if(len == 0) {
		   System.out.println("스택이 비어있습니다.");
		   return null;
	   }
		return arraystack.get(len-1);
   }
	
}
