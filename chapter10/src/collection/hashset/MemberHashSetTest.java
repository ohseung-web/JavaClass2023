package collection.hashset;

import collection.Member;

public class MemberHashSetTest {

	public static void main(String[] args) {
            
		MemberHashSet memberhashset = new MemberHashSet();
		
		memberhashset.addMember(new Member(1001,"�̼���"));
		memberhashset.addMember(new Member(1002,"������"));
		memberhashset.addMember(new Member(1003,"��ȫ��"));
		memberhashset.addMember(new Member(1004,"�Ż��Ӵ�"));
		
		memberhashset.showAll();
		System.out.println();
	
		Member memberlee = new Member(1001,"�̼���");
		
		// boolean k = memberhashset.addMember(memberlee);
	    //System.out.println(k);
		memberhashset.removeMember(1001);
		memberhashset.showAll();
	}

}
