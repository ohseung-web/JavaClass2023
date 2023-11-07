package collection.TreeMap;

import collection.Member;
import collection.hashset.MemberHashSet;

public class MemberTreeMapTesst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MemberTreeMap membertreemap = new MemberTreeMap();
		
		membertreemap.addMember(new Member(1004,"이순신"));
		membertreemap.addMember(new Member(1002,"김유신"));
		membertreemap.addMember(new Member(1001,"박홍식"));
		membertreemap.addMember(new Member(1003,"신사임당"));
		
		membertreemap.showAllMember();
		System.out.println();
	//	membertreemap.removeMember(1001);
	//	membertreemap.showAllMember();
	
	}

}
