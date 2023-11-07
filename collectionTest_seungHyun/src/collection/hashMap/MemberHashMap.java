package collection.hashMap;

import java.util.HashMap;

import collection.Member;

public class MemberHashMap {

	private HashMap<Integer, Member> hashMap;
	public  MemberHashMap() {
		 hashMap = new HashMap<>();
	}
	
	// 자료 저장 put 이용
	public void addMember(Member member) {
		hashMap.put(member.getMemberid(), member);
	}
	
	// memberid와 같은 데이터 삭제
	public boolean removeMember(int memberid) {
		  
		if(hashMap.containsKey(memberid)) {
			 hashMap.remove(memberid);
			 return true;
		}
		System.out.println(memberid + "는 존재하지 않습니다.");
		return false;
	}
	
	// 모든 정보 출력
	public void showAll() {
		
		for(Integer num : hashMap.keySet()) {
			Member member = hashMap.get(num);
			 System.out.println(member);
		}
	
	}
}
