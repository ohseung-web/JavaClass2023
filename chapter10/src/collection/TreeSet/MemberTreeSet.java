package collection.TreeSet;

import java.util.Iterator;
import java.util.TreeSet;

import collection.Member;

public class MemberTreeSet {

	private TreeSet<Member> treeset ;

	
	public MemberTreeSet() {
		treeset = new TreeSet<>();
	}

	// 회원 추가, 삭제,  출력메서드
	public void addMember(Member member) {  // 회원추가
		treeset.add(member);
	}

	public boolean removeMember(int memberid) { // 회원삭제
		// get(i)는 순서가 있는 List에만 사용 가능하므로
		// 순서가 없는 hashSet 에 값을 추출하는 iterator 클래스를 사용한다.

		// Iterator iterator = arrayList.iterator();
		Iterator<Member> iterator = treeset.iterator();
		while( iterator.hasNext() ) { // hasNext() 다음번 요소가 있느냐 ?

			Member member =	iterator.next(); // 다음 요소를 반환하여 가져온다.
			int itemId = member.getMemberId();

			if(memberid == itemId) {
				treeset.remove(member);
				return true;
			}
		}

		System.out.println(memberid+"가 존재하지 않습니다.");
		return false;

	}

	public void showAll() {  // 회원모두 출력

		Iterator<Member> iterator = treeset.iterator();
		while( iterator.hasNext() ) {
			Member member = iterator.next();
			System.out.println(member);
		}

		
		

	}

	
}
