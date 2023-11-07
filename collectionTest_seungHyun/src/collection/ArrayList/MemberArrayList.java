package collection.ArrayList;

import java.util.ArrayList;
import collection.Member;

public class MemberArrayList {

	private ArrayList<Member> arrayList;

	public MemberArrayList() {
		arrayList = new ArrayList<>();
	}

	// arrayList�� ȸ�� �����ϴ� �޼���
	public void memberAdd(Member member) {
		arrayList.add(member);
	}

	// arrayList�� ����� ȸ�� ���� �޼���
	// ������ memberid �� ���ƾ� ���� ����
	public boolean memberRemove(int memberid) {

		for(int i=0; i<arrayList.size(); i++) {
			Member member = arrayList.get(i);
			int tempid = member.getMemberid();
			if(tempid == memberid) {
				arrayList.remove(i);
				return true;
			}
		}
		System.out.println("�������� �ʴ� ���̵� �Դϴ�.");
		return false;
	}

   // arrayList ��� ��� �޼���
	public void showAll() {
		
		for(int i=0; i<arrayList.size(); i++) {
     	  Member member = arrayList.get(i);
		  System.out.println(member);
		}
	}

}
