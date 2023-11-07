package collection.ArrayList;

import java.util.ArrayList;
import collection.Member;

public class MemberArrayList {

	private ArrayList<Member> arrayList;

	public MemberArrayList() {
		arrayList = new ArrayList<>();
	}

	// arrayList에 회원 저장하는 메서드
	public void memberAdd(Member member) {
		arrayList.add(member);
	}

	// arrayList에 저장된 회원 삭제 메서드
	// 삭제시 memberid 가 같아야 삭제 가능
	public boolean memberRemove(int memberid) {

		for(int i=0; i<arrayList.size(); i++) {
			Member member = arrayList.get(i);
			int tempid = member.getMemberid();
			if(tempid == memberid) {
				arrayList.remove(i);
				return true;
			}
		}
		System.out.println("존재하지 않는 아이디 입니다.");
		return false;
	}

   // arrayList 모두 출력 메서드
	public void showAll() {
		
		for(int i=0; i<arrayList.size(); i++) {
     	  Member member = arrayList.get(i);
		  System.out.println(member);
		}
	}

}
