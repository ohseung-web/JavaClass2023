package collection.hashset;

import collection.Member;

public class MemberHashSetTest {

	public static void main(String[] args) {
            
		MemberHashSet memberhashset = new MemberHashSet();
		
		memberhashset.addMember(new Member(1001,"이순신"));
		memberhashset.addMember(new Member(1002,"김유신"));
		memberhashset.addMember(new Member(1003,"박홍식"));
		memberhashset.addMember(new Member(1004,"신사임당"));
		
		memberhashset.showAll();
		System.out.println();
	
		Member memberlee = new Member(1001,"이순신");
		
		// boolean k = memberhashset.addMember(memberlee);
	    //System.out.println(k);
		memberhashset.removeMember(1001);
		memberhashset.showAll();
	}

}
