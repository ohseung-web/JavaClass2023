package collection.treeSet;

import java.util.Iterator;
import java.util.TreeSet;

import collection.Member;

public class MemberTreeSet {
	 // �������
		TreeSet<Member>  treeset;
		// ������
		public MemberTreeSet() {
			treeset = new TreeSet<>(new Member());
		}
		
	     // �߰�
		public void addhashMember(Member member) {
			treeset.add(member);
		}
		
		//����
		public boolean removeMember(int memberid) {
			// memberid�� ������ ������ ���� 
			 Iterator<Member> it = treeset.iterator();
			 
			 while(it.hasNext()) {
				 
				  Member member = it.next();
				   int tempid =member.getMemberid();
				   if(tempid == memberid) {
					   treeset.remove(member);
					   return true;
				   }
			 }
			   System.out.println(memberid+"�� �������� �ʽ��ϴ�.");
				return false;
		}
		
		
		// ��� ���
		public void showAll() {
			// Ȯ�� for�� �̿�
			for(Member member : treeset) {
				System.out.println(member);
			}
		}
}
