package collection.TreeMap;

import java.util.Comparator;
import java.util.TreeMap;

import collection.Member;

public  class MemberTreeMap  {
	
    private TreeMap<Integer, Member> treemap ;
    public MemberTreeMap() {
    	treemap = new TreeMap<Integer,Member>();
    }
    
    public void addMember(Member member) {
    	// hashmap은 put 입력하는 메서드이다.
    	treemap.put(member.getMemberId(), member);
    }
    
    public boolean removeMember(int memberid) {
    	// hashmap 에서 containsKey는 값의 존재유무를 알려주는 메서드
    	// get() 꺼내는 메서드
    	if(treemap.containsKey(memberid)) {
    		treemap.remove(memberid);
    	     	return true;
    	}
    	System.out.println(memberid+"가 존재하지 않습니다.");
        return false;   	
    }
    
    public void showAllMember() {
    	// 확장 for문 이용
    	for(Integer keys : treemap.keySet()) {
    		Member member = treemap.get(keys);
    		System.out.println(member);
    	
    	/*
          Iterator<Integer>  ir = treemap.keySet().iterator();
          while(ir.hasNext()) {   // 다음 key가 있으면
        	  int key = ir.next();  // key 값을 가져와서
        	  Member member = treemap.get(key); // key로 부터 value 가져오기
        	 System.out.println(member);
       */ 	 
          }
    }

}
