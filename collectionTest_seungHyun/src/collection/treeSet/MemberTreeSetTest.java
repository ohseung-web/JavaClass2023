package collection.treeSet;

import collection.Member;

public class MemberTreeSetTest {

	public static void main(String[] args) {

		MemberTreeSet membertreeset = new MemberTreeSet();

		membertreeset.addhashMember(new Member(1003,"�̼���"));
		membertreeset.addhashMember(new Member(1002,"������"));
		membertreeset.addhashMember(new Member(1004,"��ȫ��"));
		membertreeset.addhashMember(new Member(1001,"�Ż��Ӵ�"));

		membertreeset.showAll();
		System.out.println();
		


	}

}
