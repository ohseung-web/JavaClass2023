package collection.hashset;

import java.util.HashSet;
import java.util.Iterator;
import collection.Member;

public class MemberHashSet {

	private HashSet<Member> hashset;

	public MemberHashSet() {
		hashset = new HashSet<>();
	}

	// 회원 추가, 삭제,  출력메서드
	public boolean addMember(Member member) {  // 회원추가
		return hashset.add(member);
	}

	public boolean removeMember(int memberid) { // 회원삭제
		// get(i)는 순서가 있는 List에만 사용 가능하므로
		// 순서가 없는 hashSet 에 값을 추출하는 iterator 클래스를 사용한다.

		// Iterator iterator = arrayList.iterator();
		/*
		Iterator<Member> iterator = hashset.iterator();
		while( iterator.hasNext() ) { // hasNext() 다음번 요소가 있느냐 ?

			Member member =	iterator.next(); // 다음 요소를 반환하여 가져온다.
			int itemId = member.getMemberId();

			if(memberid == itemId) {
				hashset.remove(member);
				return true;
			}
		}

		System.out.println(memberid+"가 존재하지 않습니다.");
		return false;
  */
		for(Member member : hashset) {
			 int tempid = member.getMemberId();
			 if(tempid == memberid) {
				 hashset.remove(member);
				 return true;
			 }
		}
		 System.out.println(memberid+"가 존재하지 않습니다.");
		 return false;
		
	}

	public void showAll() {  // 회원모두 출력

		/*
		Iterator<Member> iterator = hashset.iterator();
		while( iterator.hasNext() ) {
			Member member = iterator.next();
			System.out.println(member);
		*/
		//확장 for문 이용
			for(Member member : hashset) {
				System.out.println(member);
			}
		}

//------------------------------------------------------------------------------------------------
	}
	

