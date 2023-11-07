package collection.treeSet;

import java.util.Iterator;
import java.util.TreeSet;

import collection.Member;

public class MemberTreeSet {
	 // 멤버변수
		TreeSet<Member>  treeset;
		// 생성자
		public MemberTreeSet() {
			treeset = new TreeSet<>(new Member());
		}
		
	     // 추가
		public void addhashMember(Member member) {
			treeset.add(member);
		}
		
		//삭제
		public boolean removeMember(int memberid) {
			// memberid가 같으면 데이터 삭제 
			 Iterator<Member> it = treeset.iterator();
			 
			 while(it.hasNext()) {
				 
				  Member member = it.next();
				   int tempid =member.getMemberid();
				   if(tempid == memberid) {
					   treeset.remove(member);
					   return true;
				   }
			 }
			   System.out.println(memberid+"가 존재하지 않습니다.");
				return false;
		}
		
		
		// 모두 출력
		public void showAll() {
			// 확장 for문 이용
			for(Member member : treeset) {
				System.out.println(member);
			}
		}
}
