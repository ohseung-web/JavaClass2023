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
    	// hashmap�� put �Է��ϴ� �޼����̴�.
    	treemap.put(member.getMemberId(), member);
    }
    
    public boolean removeMember(int memberid) {
    	// hashmap ���� containsKey�� ���� ���������� �˷��ִ� �޼���
    	// get() ������ �޼���
    	if(treemap.containsKey(memberid)) {
    		treemap.remove(memberid);
    	     	return true;
    	}
    	System.out.println(memberid+"�� �������� �ʽ��ϴ�.");
        return false;   	
    }
    
    public void showAllMember() {
    	// Ȯ�� for�� �̿�
    	for(Integer keys : treemap.keySet()) {
    		Member member = treemap.get(keys);
    		System.out.println(member);
    	
    	/*
          Iterator<Integer>  ir = treemap.keySet().iterator();
          while(ir.hasNext()) {   // ���� key�� ������
        	  int key = ir.next();  // key ���� �����ͼ�
        	  Member member = treemap.get(key); // key�� ���� value ��������
        	 System.out.println(member);
       */ 	 
          }
    }

}
