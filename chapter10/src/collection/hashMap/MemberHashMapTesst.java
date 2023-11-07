package collection.hashMap;

import collection.Member;
import collection.hashset.MemberHashSet;

public class MemberHashMapTesst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MemberHashMap memberhashmap = new MemberHashMap();
		
		memberhashmap.addMember(new Member(1001,"이순신"));
		memberhashmap.addMember(new Member(1002,"김유신"));
		memberhashmap.addMember(new Member(1003,"박홍식"));
		memberhashmap.addMember(new Member(1004,"신사임당"));
		
		
		memberhashmap.showAllMember();
		System.out.println();
		memberhashmap.addMember(new Member(1007,"이순신"));   
		memberhashmap.addMember(new Member(1002,"김유신"));
		memberhashmap.showAllMember();
	
	}

}
