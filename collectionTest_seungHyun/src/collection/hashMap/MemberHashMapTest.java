package collection.hashMap;

import collection.Member;

public class MemberHashMapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MemberHashMap memberhashmap = new MemberHashMap();

		memberhashmap.addMember(new Member(1001,"�̼���"));
		memberhashmap.addMember(new Member(1002,"������"));
		memberhashmap.addMember(new Member(1003,"��ȫ��"));
		memberhashmap.addMember(new Member(1004,"�Ż��Ӵ�"));


		memberhashmap.showAll();
		System.out.println();
		memberhashmap.addMember(new Member(1001,"�̼���"));
		memberhashmap.removeMember(1004);
		memberhashmap.showAll();
	}

}
