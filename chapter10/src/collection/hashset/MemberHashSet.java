package collection.hashset;

import java.util.HashSet;
import java.util.Iterator;
import collection.Member;

public class MemberHashSet {

	private HashSet<Member> hashset;

	public MemberHashSet() {
		hashset = new HashSet<>();
	}

	// ȸ�� �߰�, ����,  ��¸޼���
	public boolean addMember(Member member) {  // ȸ���߰�
		return hashset.add(member);
	}

	public boolean removeMember(int memberid) { // ȸ������
		// get(i)�� ������ �ִ� List���� ��� �����ϹǷ�
		// ������ ���� hashSet �� ���� �����ϴ� iterator Ŭ������ ����Ѵ�.

		// Iterator iterator = arrayList.iterator();
		/*
		Iterator<Member> iterator = hashset.iterator();
		while( iterator.hasNext() ) { // hasNext() ������ ��Ұ� �ִ��� ?

			Member member =	iterator.next(); // ���� ��Ҹ� ��ȯ�Ͽ� �����´�.
			int itemId = member.getMemberId();

			if(memberid == itemId) {
				hashset.remove(member);
				return true;
			}
		}

		System.out.println(memberid+"�� �������� �ʽ��ϴ�.");
		return false;
  */
		for(Member member : hashset) {
			 int tempid = member.getMemberId();
			 if(tempid == memberid) {
				 hashset.remove(member);
				 return true;
			 }
		}
		 System.out.println(memberid+"�� �������� �ʽ��ϴ�.");
		 return false;
		
	}

	public void showAll() {  // ȸ����� ���

		/*
		Iterator<Member> iterator = hashset.iterator();
		while( iterator.hasNext() ) {
			Member member = iterator.next();
			System.out.println(member);
		*/
		//Ȯ�� for�� �̿�
			for(Member member : hashset) {
				System.out.println(member);
			}
		}

//------------------------------------------------------------------------------------------------
	}
	

