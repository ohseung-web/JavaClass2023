package collection.hashMap;

import java.util.HashMap;
import java.util.Iterator;

import collection.Member;

public class MemberHashMap {
	
    private HashMap<Integer, Member> hashmap ;
    public MemberHashMap() {
    	hashmap = new HashMap<Integer, Member>();
    }
    
    public void addMember(Member member) {
    	// hashmap�� put �Է��ϴ� �޼����̴�.
    	hashmap.put(member.getMemberId(), member);
    	//hashmap.put(1006, new Member(1006,"������"));
    	//hashmap.put(1007, new Member(1007,"��浿"));
    }
    
   
    public boolean removeMember(int memberid) {
    	// hashmap ���� containsKey�� ���� ���������� �˷��ִ� �޼���
    	// get() ������ �޼���
    	if(hashmap.containsKey(memberid)) {
    	     	hashmap.remove(memberid);
    	     	return true;
    	}
    	System.out.println(memberid+"�� �������� �ʽ��ϴ�.");
        return false;   	
    }
    
    public void showAllMember() {
          Iterator<Integer>  ir = hashmap.keySet().iterator();
          while(ir.hasNext()) {   // ���� key�� ������
        	  int key = ir.next();  // key ���� �����ͼ�
        	  Member member = hashmap.get(key); // key�� ���� value ��������
        	 System.out.println(member);
          }
    }
}
