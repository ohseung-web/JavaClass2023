package collection.hashSet;

import collection.Member;

public class MemberHashSetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       MemberHashSet memberhashset = new MemberHashSet();
		
		memberhashset.addhashMember(new Member(1001,"이순신"));
		memberhashset.addhashMember(new Member(1002,"김유신"));
		memberhashset.addhashMember(new Member(1003,"박홍식"));
		memberhashset.addhashMember(new Member(1004,"신사임당"));
		
		memberhashset.showAll();
		System.out.println();
	
		memberhashset.addhashMember(new Member(1001,"이순신")); // 중복이 불가능 하도록 코딩
	    memberhashset.showAll();
	}

}
