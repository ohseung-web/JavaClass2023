package collection.TreeSet;

import java.util.Iterator;
import java.util.TreeSet;

import collection.Member;

public class MemberTreeSet {

	private TreeSet<Member> treeset ;

	
	public MemberTreeSet() {
		treeset = new TreeSet<>();
	}

	// ȸ�� �߰�, ����,  ��¸޼���
	public void addMember(Member member) {  // ȸ���߰�
		treeset.add(member);
	}

	public boolean removeMember(int memberid) { // ȸ������
		// get(i)�� ������ �ִ� List���� ��� �����ϹǷ�
		// ������ ���� hashSet �� ���� �����ϴ� iterator Ŭ������ ����Ѵ�.

		// Iterator iterator = arrayList.iterator();
		Iterator<Member> iterator = treeset.iterator();
		while( iterator.hasNext() ) { // hasNext() ������ ��Ұ� �ִ��� ?

			Member member =	iterator.next(); // ���� ��Ҹ� ��ȯ�Ͽ� �����´�.
			int itemId = member.getMemberId();

			if(memberid == itemId) {
				treeset.remove(member);
				return true;
			}
		}

		System.out.println(memberid+"�� �������� �ʽ��ϴ�.");
		return false;

	}

	public void showAll() {  // ȸ����� ���

		Iterator<Member> iterator = treeset.iterator();
		while( iterator.hasNext() ) {
			Member member = iterator.next();
			System.out.println(member);
		}

		
		

	}

	
}
