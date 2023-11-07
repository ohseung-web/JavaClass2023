package collection.treeSet;

import collection.Member;

public class MemberTreeSetTest {

	public static void main(String[] args) {

		MemberTreeSet membertreeset = new MemberTreeSet();

		membertreeset.addhashMember(new Member(1003,"이순신"));
		membertreeset.addhashMember(new Member(1002,"김유신"));
		membertreeset.addhashMember(new Member(1004,"박홍식"));
		membertreeset.addhashMember(new Member(1001,"신사임당"));

		membertreeset.showAll();
		System.out.println();
		


	}

}
