package collection.ArrayList.Stack;

import java.util.ArrayList;

public class StackArrayLsit {
    
	private ArrayList<String> arraystack = new ArrayList<>();
	
	public StackArrayLsit() {}
	
	// stack �����ϴ� �޼��� stack ������ push
	public void push(String data) {
		arraystack.add(data);
	}
	
	// stack ������ �޼��� stack �������� pop
   public String pop() {
	   int len = arraystack.size(); 
	   if(len == 0) {
		   System.out.println("������ ����ֽ��ϴ�.");
		   return null;
	   }
 	  return arraystack.remove(len-1); // stack�� FILO�̹Ƿ� �����Ҷ��� ������ ������ ���� size()-1 
   }
   
   // stack���� peek�� �� ���� �����͸� �������°�, ������ ���� �ʴ´�.
   public String peek(){ // get(i)�� ���� �ǹ��̴�.
	   int len = arraystack.size();
	   if(len == 0) {
		   System.out.println("������ ����ֽ��ϴ�.");
		   return null;
	   }
		return arraystack.get(len-1);
   }
	
}
