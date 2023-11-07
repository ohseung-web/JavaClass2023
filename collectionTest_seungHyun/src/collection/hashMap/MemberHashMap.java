package collection.hashMap;

import java.util.HashMap;

import collection.Member;

public class MemberHashMap {

	private HashMap<Integer, Member> hashMap;
	public  MemberHashMap() {
		 hashMap = new HashMap<>();
	}
	
	// �ڷ� ���� put �̿�
	public void addMember(Member member) {
		hashMap.put(member.getMemberid(), member);
	}
	
	// memberid�� ���� ������ ����
	public boolean removeMember(int memberid) {
		  
		if(hashMap.containsKey(memberid)) {
			 hashMap.remove(memberid);
			 return true;
		}
		System.out.println(memberid + "�� �������� �ʽ��ϴ�.");
		return false;
	}
	
	// ��� ���� ���
	public void showAll() {
		
		for(Integer num : hashMap.keySet()) {
			Member member = hashMap.get(num);
			 System.out.println(member);
		}
	
	}
}
