package collection.TreeSet;

import collection.Member;

public class MemberTreeSetTest {

	public static void main(String[] args) {
            
		MemberTreeSet memberhashset = new MemberTreeSet();
		
		memberhashset.addMember(new Member(1004,"�̼���"));
		memberhashset.addMember(new Member(1002,"������"));
		memberhashset.addMember(new Member(1001,"��ȫ��"));
		memberhashset.addMember(new Member(1003,"�Ż��Ӵ�"));
		
		memberhashset.showAll();
		
	}

}
