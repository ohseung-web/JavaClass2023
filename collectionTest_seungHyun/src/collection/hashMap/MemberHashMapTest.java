package collection.hashMap;

import collection.Member;

public class MemberHashMapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MemberHashMap memberhashmap = new MemberHashMap();

		memberhashmap.addMember(new Member(1001,"이순신"));
		memberhashmap.addMember(new Member(1002,"김유신"));
		memberhashmap.addMember(new Member(1003,"박홍식"));
		memberhashmap.addMember(new Member(1004,"신사임당"));


		memberhashmap.showAll();
		System.out.println();
		memberhashmap.addMember(new Member(1001,"이순신"));
		memberhashmap.removeMember(1004);
		memberhashmap.showAll();
	}

}
