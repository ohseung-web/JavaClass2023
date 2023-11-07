package collection.TreeSet;

import collection.Member;

public class MemberTreeSetTest {

	public static void main(String[] args) {
            
		MemberTreeSet memberhashset = new MemberTreeSet();
		
		memberhashset.addMember(new Member(1004,"이순신"));
		memberhashset.addMember(new Member(1002,"김유신"));
		memberhashset.addMember(new Member(1001,"박홍식"));
		memberhashset.addMember(new Member(1003,"신사임당"));
		
		memberhashset.showAll();
		
	}

}
