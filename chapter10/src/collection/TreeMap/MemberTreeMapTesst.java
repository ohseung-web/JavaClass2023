package collection.TreeMap;

import collection.Member;
import collection.hashset.MemberHashSet;

public class MemberTreeMapTesst {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MemberTreeMap membertreemap = new MemberTreeMap();
		
		membertreemap.addMember(new Member(1004,"�̼���"));
		membertreemap.addMember(new Member(1002,"������"));
		membertreemap.addMember(new Member(1001,"��ȫ��"));
		membertreemap.addMember(new Member(1003,"�Ż��Ӵ�"));
		
		membertreemap.showAllMember();
		System.out.println();
	//	membertreemap.removeMember(1001);
	//	membertreemap.showAllMember();
	
	}

}
