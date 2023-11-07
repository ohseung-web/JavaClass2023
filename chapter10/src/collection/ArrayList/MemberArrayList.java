package collection.ArrayList;

import java.util.ArrayList;
import java.util.Iterator;

import collection.Member;

public class MemberArrayList { // member Ŭ������ ArrayList �����ϴ� Ŭ����
	
	private ArrayList<Member> arrayList;
	
	public MemberArrayList() {
		arrayList = new ArrayList<>();
	}
	
	// ȸ�� �߰�, ����,  ��¸޼���
	public void addMember(Member member) {  // ȸ���߰�
		arrayList.add(member);
	}
	
	public boolean removeMember(int memberid) { // ȸ������
		// get(i)�� ������ �ִ� List���� ��� �����ϹǷ�
		// ������ ���� hashSet �� ���� �����ϴ� iterator �޼��带 ����Ѵ�.
		
		// Iterator iterator = arrayList.iterator();
		Iterator<Member> iterator = arrayList.iterator();
		while( iterator.hasNext() ) { // hasNext() ������ ��Ұ� �ִ��� ?
			
			Member member =	iterator.next(); // ���� ��Ҹ� ��ȯ�Ͽ� �����´�.
			int itemId = member.getMemberId();
			
			if(memberid == itemId) {
				   arrayList.remove(member);
				   return true;
			  }
		}
		
		/*  
		for(int i=0; i< arrayList.size(); i++) {   
			//  Member member = arrayList.get(i);
			//  int itemId = member.getMemberId();
			  int itemId = arrayList.get(i).getMemberId();
			  if(memberid == itemId) {
				   arrayList.remove(i);
				   return true;
			  }
		}
		*/
		System.out.println(memberid+"�� �������� �ʽ��ϴ�.");
		return false;
	
	}
	
	public void showAll() {  // ȸ����� ���
		
		Iterator<Member> iterator = arrayList.iterator();
	    while( iterator.hasNext() ) {
	    	  Member member = iterator.next();
	    	  System.out.println(member);
	    }
		/*
		for(int i=0;i<arrayList.size(); i++) {
		   Member member = arrayList.get(i);
			System.out.println(member);
		}
		//System.out.println(arrayList);
		 */
		 
	}
	
}
