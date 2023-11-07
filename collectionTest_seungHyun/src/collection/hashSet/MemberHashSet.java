package collection.hashSet;

import java.util.HashSet;
import java.util.Iterator;

import collection.Member;

public class MemberHashSet {
     // 멤버변수
	HashSet<Member>  hashset;
	// 생성자
	public MemberHashSet() {
		hashset = new HashSet<>();
	}
	
     // 추가
	public void addhashMember(Member member) {
		hashset.add(member);
	}
	
	//삭제
	public boolean removeMember(int memberid) {
		// memberid가 같으면 데이터 삭제 
		 Iterator<Member> it = hashset.iterator();
		 
		 while(it.hasNext()) {
			 
			  Member member = it.next();
			   int tempid =member.getMemberid();
			   if(tempid == memberid) {
				   hashset.remove(member);
				   return true;
			   }
		 }
		   System.out.println(memberid+"가 존재하지 않습니다.");
			return false;
	}
	
	
	// 모두 출력
	public void showAll() {
		// 확장 for문 이용
		for(Member member : hashset) {
			System.out.println(member);
		}
	}
	
}
