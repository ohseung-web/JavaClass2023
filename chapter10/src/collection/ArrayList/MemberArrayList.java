package collection.ArrayList;

import java.util.ArrayList;
import java.util.Iterator;

import collection.Member;

public class MemberArrayList { // member 클래스를 ArrayList 관리하는 클래스
	
	private ArrayList<Member> arrayList;
	
	public MemberArrayList() {
		arrayList = new ArrayList<>();
	}
	
	// 회원 추가, 삭제,  출력메서드
	public void addMember(Member member) {  // 회원추가
		arrayList.add(member);
	}
	
	public boolean removeMember(int memberid) { // 회원삭제
		// get(i)는 순서가 있는 List에만 사용 가능하므로
		// 순서가 없는 hashSet 에 값을 추출하는 iterator 메서드를 사용한다.
		
		// Iterator iterator = arrayList.iterator();
		Iterator<Member> iterator = arrayList.iterator();
		while( iterator.hasNext() ) { // hasNext() 다음번 요소가 있느냐 ?
			
			Member member =	iterator.next(); // 다음 요소를 반환하여 가져온다.
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
		System.out.println(memberid+"가 존재하지 않습니다.");
		return false;
	
	}
	
	public void showAll() {  // 회원모두 출력
		
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
