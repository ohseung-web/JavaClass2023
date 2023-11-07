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
    	// hashmap은 put 입력하는 메서드이다.
    	hashmap.put(member.getMemberId(), member);
    	//hashmap.put(1006, new Member(1006,"오승현"));
    	//hashmap.put(1007, new Member(1007,"김길동"));
    }
    
   
    public boolean removeMember(int memberid) {
    	// hashmap 에서 containsKey는 값의 존재유무를 알려주는 메서드
    	// get() 꺼내는 메서드
    	if(hashmap.containsKey(memberid)) {
    	     	hashmap.remove(memberid);
    	     	return true;
    	}
    	System.out.println(memberid+"가 존재하지 않습니다.");
        return false;   	
    }
    
    public void showAllMember() {
          Iterator<Integer>  ir = hashmap.keySet().iterator();
          while(ir.hasNext()) {   // 다음 key가 있으면
        	  int key = ir.next();  // key 값을 가져와서
        	  Member member = hashmap.get(key); // key로 부터 value 가져오기
        	 System.out.println(member);
          }
    }
}
