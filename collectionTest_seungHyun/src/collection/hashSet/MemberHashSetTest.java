package collection.hashSet;

import collection.Member;

public class MemberHashSetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       MemberHashSet memberhashset = new MemberHashSet();
		
		memberhashset.addhashMember(new Member(1001,"�̼���"));
		memberhashset.addhashMember(new Member(1002,"������"));
		memberhashset.addhashMember(new Member(1003,"��ȫ��"));
		memberhashset.addhashMember(new Member(1004,"�Ż��Ӵ�"));
		
		memberhashset.showAll();
		System.out.println();
	
		memberhashset.addhashMember(new Member(1001,"�̼���")); // �ߺ��� �Ұ��� �ϵ��� �ڵ�
	    memberhashset.showAll();
	}

}
