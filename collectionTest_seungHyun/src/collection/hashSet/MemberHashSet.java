package collection.hashSet;

import java.util.HashSet;
import java.util.Iterator;

import collection.Member;

public class MemberHashSet {
     // �������
	HashSet<Member>  hashset;
	// ������
	public MemberHashSet() {
		hashset = new HashSet<>();
	}
	
     // �߰�
	public void addhashMember(Member member) {
		hashset.add(member);
	}
	
	//����
	public boolean removeMember(int memberid) {
		// memberid�� ������ ������ ���� 
		 Iterator<Member> it = hashset.iterator();
		 
		 while(it.hasNext()) {
			 
			  Member member = it.next();
			   int tempid =member.getMemberid();
			   if(tempid == memberid) {
				   hashset.remove(member);
				   return true;
			   }
		 }
		   System.out.println(memberid+"�� �������� �ʽ��ϴ�.");
			return false;
	}
	
	
	// ��� ���
	public void showAll() {
		// Ȯ�� for�� �̿�
		for(Member member : hashset) {
			System.out.println(member);
		}
	}
	
}
